# This file covers the issues with given framework and the changes done to improvise it

Existing Issues :

1) Webelement locators should not be in the test file.
2) Driver initaialization & browser url launch should be separated from test files and generic.
3) Driver null condition is not handled.
4)Common utils like waitfor,iselement should be common.
5) Notification popup is not handled in browser.

Changes made:

1) Used page factory pattern to separate the webelement locator and test file.
2) Each page has respective locators along with functions handling the functionality.
3) Introduced new base/TestBase.java file which is the base file and handles driver initialization,quit,url navigation
4) All test class extends the testbase in order to get the driver steup ready
5) Also included testutils class for generic functions like waittime,expected waits,elements presence conditions.
6) Config properties file has the url for now but in future can be enhanced for user credentials info
7) Testng run file for test case execution and reporting
