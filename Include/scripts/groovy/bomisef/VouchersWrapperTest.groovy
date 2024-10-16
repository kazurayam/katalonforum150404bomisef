package bomisef


import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@RunWith(JUnit4.class)
public class VouchersWrapperTest {

	private static VouchersWrapper vw

	@BeforeClass
	public static void beforeClass() {
		Path jsonFile = Paths.get("./docs/vouchers.json")
		String jsonData = Files.readString(jsonFile)
		vw = new VouchersWrapper(jsonData)
	}

	@Test
	public void test_getVoucherIdList() {
		List<String> voucherIdList = vw.getVoucherIdList()
		println("[test_getVoucherIdList] " + voucherIdList.toString())
		assertEquals(10, voucherIdList.size())
	}
	
	@Test
	public void test_getVoucherEmployeeTupleList() {
		List<Tuple2<String,String>> voucherEmployeeTupleList = vw.getVoucherEmployeeTupleList()
		println("[test_getVoucherEmployeeeTupleList] " + voucherEmployeeTupleList.toString())
		assertEquals(10, voucherEmployeeTupleList.size())
	}
	
	@Test
	public void test_getMapOfEmployeeIdWithVoucherIdList() {
		SortedMap<Integer, List<Integer>> mapOfEmployeeIdWithVoucherIdList =
			vw.getMapOfEmployeeIdWithVoucherIdList()
		println("[test_getMapOfEmployeeIdWithVoucherIdList] " + mapOfEmployeeIdWithVoucherIdList.toString())
		assertEquals(2, mapOfEmployeeIdWithVoucherIdList.keySet().size())
		//
		List<Integer> employee7sVouchers = mapOfEmployeeIdWithVoucherIdList.get(7)
		assertEquals(6, employee7sVouchers.size())
		assertEquals(108040, employee7sVouchers.get(0))
		assertEquals(108041, employee7sVouchers.get(1))
		assertEquals(108042, employee7sVouchers.get(2))
		assertEquals(108046, employee7sVouchers.get(3))
		assertEquals(108047, employee7sVouchers.get(4))
		assertEquals(108048, employee7sVouchers.get(5))
		//
		List<Integer> employee8sVouchers = mapOfEmployeeIdWithVoucherIdList.get(8)
		assertEquals(4, employee8sVouchers.size())
		assertEquals(108043, employee8sVouchers.get(0))
		assertEquals(108044, employee8sVouchers.get(1))
		assertEquals(108045, employee8sVouchers.get(2))
		assertEquals(108049, employee8sVouchers.get(3))
	}
}
