
package testcase;

import base.BaseTest;
import entity.TestCase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.TestCaseService;
import utils.HttpUtils;
import utils.JsonUtils;

import java.util.List;
import java.util.Map;

public class ApiTest extends BaseTest {

    @DataProvider(name = "caseProvider")
    public Object[][] caseProvider() {
        List<TestCase> cases = TestCaseService.getAllTestCases();
        Object[][] result = new Object[cases.size()][1];
        for (int i = 0; i < cases.size(); i++) result[i][0] = cases.get(i);
        return result;
    }

    @Test(dataProvider = "caseProvider")
    public void testApi(TestCase testCase) throws Exception {
        Map<String, String> headers = JsonUtils.toMap(testCase.headers);
        String response = "";

        switch (testCase.method.toUpperCase()) {
            case "GET":
                response = HttpUtils.doGet(testCase.url, headers);
                break;
            case "POST":
                if ("application/json".equals(testCase.contentType)) {
                    response = HttpUtils.doPostJson(testCase.url, headers, testCase.body);
                }
                break;
            case "PUT":
                response = HttpUtils.doPut(testCase.url, headers, testCase.body);
                break;
            case "DELETE":
                response = HttpUtils.doDelete(testCase.url, headers);
                break;
        }

        Assert.assertTrue(response.contains(testCase.expectedResult), "断言失败：" + response);
    }
}
