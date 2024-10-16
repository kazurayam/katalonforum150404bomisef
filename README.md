# katalonforum150404bomisef

date 2024/10/16
author kazurayam

This is a small Katalon Studio project for demonstration purpose. This project was developed to propose a solution to the discussion at

- https://forum.katalon.com/t/is-it-possible-to-search-from-response-body-and-verify/150404

This project is open-sourced.
You can download the zip of this project from the [Releases](https://github.com/kazurayam/katalonforum150404bomisef/releases) page,
unzip it, open it with your local Katalon Studio installation, and run it.

## Environment

- Katalon Studio Free v9.0.0
- macOS Sonoma 14.7

## Input Data

- https://kazurayam.github.io/katalonforum150404bomisef/vouchers.json

## Output

Run the `Test Cases/main/ProcessingVouchers`. Then you will see the following output in the console:

```
2024-10-16 22:23:48.882 INFO  c.k.katalon.core.main.TestCaseExecutor   - --------------------
2024-10-16 22:23:48.885 INFO  c.k.katalon.core.main.TestCaseExecutor   - START Test Cases/main/ProcessingVouchers
2024-10-16 22:23:49.514 DEBUG testcase.ProcessingVouchers              - 1: resp = sendRequest(findTestObject("Object Repository/vouchers"))
2024-10-16 22:23:52.169 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/main/ProcessingVouchers/20241016_222343/requests/main/0.har
2024-10-16 22:23:52.304 DEBUG testcase.ProcessingVouchers              - 2: json = resp.getResponseText()
2024-10-16 22:23:52.323 DEBUG testcase.ProcessingVouchers              - 3: VOUCHERS = json
2024-10-16 22:23:52.465 DEBUG testcase.ProcessingVouchers              - 4: println(VOUCHERS)
{
  "vouchers": [
    {
      "id": 108040,
      "code": "fca97147c39bc89e",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 7,
      "voucherPoolId": 112,
      "createdAt": "2024-10-01T08:03:39.594Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Milo",
        "surname": "Ritchie",
        "email": "Milo.Ritchie@yahoo.com"
      },
      "cashier": null
    },
    {
      "id": 108041,
      "code": "e5ed0c6514ce28d9",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 7,
      "voucherPoolId": 112,
      "createdAt": "2024-10-01T08:03:39.594Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Milo",
        "surname": "Ritchie",
        "email": "Milo.Ritchie@yahoo.com"
      },
      "cashier": null
    },
    {
      "id": 108042,
      "code": "c49e525bb4da1d6b",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 7,
      "voucherPoolId": 112,
      "createdAt": "2024-10-01T08:03:39.594Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Milo",
        "surname": "Ritchie",
        "email": "Milo.Ritchie@yahoo.com"
      },
      "cashier": null
    },
    {
      "id": 108043,
      "code": "52bcc251c20bfdef",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 8,
      "voucherPoolId": 112,
      "createdAt": "2024-10-01T08:03:39.594Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Patience",
        "surname": "Sauer",
        "email": "Patience83@hotmail.com"
      },
      "cashier": null
    },
    {
      "id": 108044,
      "code": "0c6aac3b792ba0c3",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 8,
      "voucherPoolId": 112,
      "createdAt": "2024-10-01T08:03:39.594Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Patience",
        "surname": "Sauer",
        "email": "Patience83@hotmail.com"
      },
      "cashier": null
    },
    {
      "id": 108045,
      "code": "dc0eafdc9363b24e",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 8,
      "voucherPoolId": 112,
      "createdAt": "2024-10-01T08:03:39.594Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Patience",
        "surname": "Sauer",
        "email": "Patience83@hotmail.com"
      },
      "cashier": null
    },
    {
      "id": 108046,
      "code": "7a7478ed41c4be2a",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 7,
      "voucherPoolId": 114,
      "createdAt": "2024-10-01T08:06:17.303Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Milo",
        "surname": "Ritchie",
        "email": "Milo.Ritchie@yahoo.com"
      },
      "cashier": null
    },
    {
      "id": 108047,
      "code": "bed27a75d7bb6d0f",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 7,
      "voucherPoolId": 114,
      "createdAt": "2024-10-01T08:06:17.303Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Milo",
        "surname": "Ritchie",
        "email": "Milo.Ritchie@yahoo.com"
      },
      "cashier": null
    },
    {
      "id": 108048,
      "code": "3c049e6ccf2ac8bd",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 7,
      "voucherPoolId": 114,
      "createdAt": "2024-10-01T08:06:17.303Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Milo",
        "surname": "Ritchie",
        "email": "Milo.Ritchie@yahoo.com"
      },
      "cashier": null
    },
    {
      "id": 108049,
      "code": "4bbb830893e497d2",
      "price": 3000,
      "redeemedDate": null,
      "expiryDate": "2024-10-09T15:59:00.000Z",
      "status": "Expired",
      "employeeId": 8,
      "voucherPoolId": 114,
      "createdAt": "2024-10-01T08:06:17.303Z",
      "updatedAt": "2024-10-09T16:01:00.763Z",
      "deletedAt": null,
      "revokeReason": null,
      "cashierId": null,
      "revokedAt": null,
      "voucherPool": {
        "name": "Dinner"
      },
      "employee": {
        "firstname": "Patience",
        "surname": "Sauer",
        "email": "Patience83@hotmail.com"
      },
      "cashier": null
    }
  ],
  "pagination": {
    "pageNumber": 0,
    "perPage": 200,
    "totalCount": 26
  }
}

2024-10-16 22:23:52.501 DEBUG testcase.ProcessingVouchers              - 5: vw = new bomisef.VouchersWrapper(internal.GlobalVariable.VOUCHERS)
2024-10-16 22:23:52.606 DEBUG testcase.ProcessingVouchers              - 6: mapOfEmployeeIdWithVoucherIdList = vw.getMapOfEmployeeIdWithVoucherIdList()
2024-10-16 22:23:52.847 DEBUG testcase.ProcessingVouchers              - 7: println(VouchersWrapper.toJson(mapOfEmployeeIdWithVoucherIdList))
{
  "7" : [ 108040, 108041, 108042, 108046, 108047, 108048 ],
  "8" : [ 108043, 108044, 108045, 108049 ]
}
2024-10-16 22:23:53.017 INFO  c.k.katalon.core.main.TestCaseExecutor   - END Test Cases/main/ProcessingVouchers
```

## My proposal

The "ProcessingVouchers" results a data structure:

```
{
  "7" : [ 108040, 108041, 108042, 108046, 108047, 108048 ],
  "8" : [ 108043, 108044, 108045, 108049 ]
}
```
where

7 is an employee id,

[108040 , 108041, 108042, 108046, 108047, 108048 ] is the list of voucher ids allocated to the employee id 7.

8 is another employee id,

[ 108043, 108044, 108045, 108049 ] is the list of voucher ids allocated to the employee id 8.

I think this is what the original poster wanted.

## What I developed

I developed a set of Groovy scripts

- [Test Cases/main/ProcessingVouchers](https://github.com/kazurayam/katalonforum150404bomisef/blob/master/Scripts/main/ProcessingVouchers/Script1729071840553.groovy)
- [Keywords/bomisef/VouchersWrapper.groovy](https://github.com/kazurayam/katalonforum150404bomisef/blob/master/Keywords/bomisef/VouchersWrapper.groovy)

## Skills used

The "bomisef.VoucherWrapper" class implements a set of state-of-the-art methods that employ the following Java libraries:

- [Jayway JsonPath](https://www.baeldung.com/guide-to-jayway-jsonpath)
- [Groovy Tuples](https://blog.mrhaki.com/2018/06/groovy-goodness-tuples-with-up-to-9.html)
- [Jackson ObjectMapper](https://www.baeldung.com/jackson-object-mapper-tutorial)
- [JUnit4 for Katalon Studio](https://github.com/kazurayam/junit4ks)
