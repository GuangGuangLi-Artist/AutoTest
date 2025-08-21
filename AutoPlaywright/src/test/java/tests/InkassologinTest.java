package tests;

import base.BaseTest;
import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AssertUtil;
import utils.DataProviderUtil;

import java.util.Map;

@Epic("Inkasso登录测试")
@Feature("登录")
public class InkassologinTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(InkassologinTest.class);
    String filePath = "src/test/resources/testdata/json/userPass.json";

    @DataProvider(name = "loginRData")
    public Object[][] loginRDataProvider() {
        return DataProviderUtil.loadFromJsonKey(filePath,"rightUser");

    }

    @Test(description = "测试登录成功",dataProvider = "loginRData")
    @Severity(SeverityLevel.CRITICAL)
    @Story("用户输入手机号和验证码登录")
    public void testLoginSuccessWithJSON(Map<String,Object> data){
        logger.info("开始测试登录页面");
        String url = (String) data.get("login_url");
        String username = (String) data.get("username");
        String password = (String) data.get("password");
        String expected_error = (String) data.get("expected_error");
        InkassoLoginPage loginPage = new InkassoLoginPage(page);
        loginPage.navigateToInkassoLoginPage(url);
        loginPage.login(username, password);
        String phone = loginPage.getUserphone();
        AssertUtil.assertEquals(phone,"15607521234","登录成功");

    }

    @DataProvider(name = "loginWData")
    public Object[][] loginWDataProvider() {
        return DataProviderUtil.loadFromJsonKey(filePath,"wrongUser");

    }

    @Test(description = "测试登录失败",dataProvider = "loginWData")
    @Severity(SeverityLevel.CRITICAL)
    @Story("用户输入手机号和验证码登录")
    public void testLoginFailWithJSON(Map<String,Object> data) {
        logger.info("开始测试登录页面");
        String url = (String) data.get("login_url");
        String username = (String) data.get("username");
        String password = (String) data.get("password");
        String expected_error = (String) data.get("expected_error");
        InkassoLoginPage loginPage = new InkassoLoginPage(page);
        loginPage.navigateToInkassoLoginPage(url);
        loginPage.login(username, password);
        boolean mSg = loginPage.getFailMSg();
        AssertUtil.assertTrue(mSg,"登录验证码不正确，登录不成功");
    }
}
