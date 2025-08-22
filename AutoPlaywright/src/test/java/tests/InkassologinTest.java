package tests;

import base.BaseTest;
import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.*;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AssertUtil;
import utils.DataProviderUtil;
import utils.ScreenshotUtil;

import java.util.Map;

@Epic("Inkasso登录测试")
@Feature("登录")
public class InkassologinTest {

    private static final Logger logger = LoggerFactory.getLogger(InkassologinTest.class);
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;


    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName) throws Exception {
        playwright = Playwright.create();
        BrowserType browserType;
        if ("firefox".equalsIgnoreCase(browserName)) {
            browserType = playwright.firefox();
            logger.info("启动 Firefox 浏览器");
        } else {
            browserType = playwright.chromium();
            logger.info("启动 Chrome 浏览器（默认）");
        }
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
        context = browser.newContext();
        page = context.newPage();
    }

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

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (!result.isSuccess()) {
            String testName = result.getMethod().getMethodName();
            String fileName = testName + "__" + System.currentTimeMillis() + ".png";
            byte[] screenshot = ScreenshotUtil.captureScreenshot(page, fileName);
            Allure.getLifecycle().addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    "png",
                    screenshot
            );

            logger.error("Test failed. Screenshot attached to Allure report: {}}", fileName);
        }
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

}
