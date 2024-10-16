package bomisef

import com.jayway.jsonpath.Criteria
import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.Filter
import com.jayway.jsonpath.JsonPath
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

public class VouchersWrapper {

	private String jsonData

	private DocumentContext dc

	public VouchersWrapper(String jsonData) {
		this.jsonData = jsonData
		dc = createDocumentContext(this.jsonData)
	}

	public String getJsonData() {
		return this.jsonData
	}

	private DocumentContext createDocumentContext(String jsonData) {
		this.dc = JsonPath.parse(jsonData)
	}

	/**
	 * returns [108040,108041,108042,108043,108044,108045,108046,108047,108048,108049]
	 * 
	 * @return a List of voucherids found in the source JSON
	 */
	public List<Integer> getVoucherIdList() {
		List<Integer> list = dc.read("\$.vouchers[*].id")
		return list
	}

	/**
	 * [[108040, 7], [108041, 7], [108042, 7], [108043, 8], [108044, 8], [108045, 8], [108046, 7], [108047, 7], [108048, 7], [108049, 8]]
	 * 
	 * @return a List of (voucherId, employeeId) pairs found in the source JSON
	 */
	public List<Tuple2<Integer, Integer>> getVoucherEmployeeTupleList() {
		List<Integer> voucherIdList = this.getVoucherIdList()
		List<Tuple2<Integer, Integer>> list = new ArrayList<>()
		voucherIdList.forEach({ voucherId ->
			Filter voucherIdFilter = Filter.filter(Criteria.where("id").eq(voucherId))
			List<Integer> employeeIdList = dc.read("\$.vouchers[?].employeeId", voucherIdFilter)
			list.add(new Tuple2(voucherId, (employeeIdList.isEmpty() ? 0 : employeeIdList[0])))
		})
		return list
	}

	/**
	 *  [7:[108040, 108041, 108042, 108046, 108047, 108048], 8:[108043, 108044, 108045, 108049]]
	 *  
	 * @return a Map that comprises with key-value pairs 
	 * where the key is a employeeId as key, the value is a List of voucherIds allocated to the employee
	 */
	public SortedMap<Integer, List<Integer>> getMapOfEmployeeIdWithVoucherIdList() {
		Set<Integer> employeeIdSet = new HashSet<>()
		List<Tuple2<Integer, Integer>> voucherEmployeeTupleList = this.getVoucherEmployeeTupleList()
		voucherEmployeeTupleList.forEach({ voucherEmployeeTuple ->
			Integer employeeId = voucherEmployeeTuple.getV2()
			employeeIdSet.add(employeeId)
		})
		SortedMap<Integer, List<Integer>> mapOfEmployeeWithVoucherIdList = new TreeMap<>()
		employeeIdSet.forEach({ employeeId ->
			SortedSet<Integer> voucherIdSet = new TreeSet<>()
			voucherEmployeeTupleList.forEach({ voucherEmployeeTuple ->
				if (voucherEmployeeTuple.getV2() == employeeId) {
					voucherIdSet.add(voucherEmployeeTuple.getV1())
				}
			})
			mapOfEmployeeWithVoucherIdList.put(employeeId, voucherIdSet.toList())
		})
		return mapOfEmployeeWithVoucherIdList
	}


	/**
	 * A utility method that converts any type of object into a JSON text.
	 * 
	 * @param obj : any types of object that the Jackson ObjectMapper can serialize
	 * @param indented : give indentation to the output JSON or not; default to true
	 * @return
	 */
	public static String toJson(Object obj, boolean indented = true) {
		ObjectMapper mapper = new ObjectMapper()
		if (indented) {
			mapper.enable(SerializationFeature.INDENT_OUTPUT)
		}
		StringWriter sw = new StringWriter()
		mapper.writeValue(sw, obj);
		return sw.toString()
	}
}
