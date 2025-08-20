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

    private static final Logger logger = LoggerFactory.getLogger(BaiduSearchTest.class);

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        String filePath = "src/test/resources/testdata/json/userPass.json";
        return DataProviderUtil.loadAsDataProvider(filePath);

    }

    @Test(description = "测试登录成功",dataProvider = "loginData")
    @Severity(SeverityLevel.CRITICAL)
    @Story("用户输入手机号和验证码登录")
    public void testLoginWithCSV(Map<String,Object> data){
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
}
