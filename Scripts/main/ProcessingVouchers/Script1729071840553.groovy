import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import bomisef.VouchersWrapper
import internal.GlobalVariable

ResponseObject resp = WS.sendRequest(findTestObject("Object Repository/vouchers"))
String json = resp.getResponseText()
GlobalVariable.VOUCHERS = json

println GlobalVariable.VOUCHERS
VouchersWrapper vw = new VouchersWrapper(GlobalVariable.VOUCHERS)
SortedMap<Integer, List<Integer>> mapOfEmployeeIdWithVoucherIdList = vw.getMapOfEmployeeIdWithVoucherIdList()
println VouchersWrapper.toJson(mapOfEmployeeIdWithVoucherIdList)