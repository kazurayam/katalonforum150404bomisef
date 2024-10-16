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

	public List<Integer> getVoucherIdList() {
		List<Integer> list = dc.read("\$.vouchers[*].id")
		return list
	}

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

	public static String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper()
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		StringWriter sw = new StringWriter()
		mapper.writeValue(sw, obj);
		return sw.toString()
	}
}
