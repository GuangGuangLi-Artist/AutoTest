package base;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ScreenshotUtil;

public class BaseTest {

    public static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeClass
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
    }

    @AfterClass
    public void teardown() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

    }


}
