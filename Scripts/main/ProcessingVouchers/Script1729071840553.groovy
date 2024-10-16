// Test Cases/main/ProcessingVouchers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import bomisef.VouchersWrapper  // a custom Keyword
import internal.GlobalVariable

// This test case gets and transform a JSON into another data structure.
// The JSON is visible at the file path <projectDir>/docs/vouchers.json

// send a HTTP Request to a remote URL, receive a "vouchers" JSON text as response
ResponseObject resp = WS.sendRequest(findTestObject("Object Repository/vouchers"))

// save the raw JSON text into the GlobalVariable.VOUCHERS
String json = resp.getResponseText()
GlobalVariable.VOUCHERS = json

// print the raw "voucher" JSON
println GlobalVariable.VOUCHERS

// wrap the raw JSON
VouchersWrapper vw = new VouchersWrapper(GlobalVariable.VOUCHERS)

// transform the raw JSON into another data structure that I prefer
SortedMap<Integer, List<Integer>> mapOfEmployeeIdWithVoucherIdList = vw.getMapOfEmployeeIdWithVoucherIdList()

// save the transformation result into a GlobalVariable for later reuse
GlobalVariable.VOUCHER_ALLOCATION = mapOfEmployeeIdWithVoucherIdList

// print the transformation result
println VouchersWrapper.toJson(GlobalVariable.VOUCHER_ALLOCATION)
// {
//   "7" : [ 108040, 108041, 108042, 108046, 108047, 108048 ],
//   "8" : [ 108043, 108044, 108045, 108049 ]
// }
