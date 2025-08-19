package base;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;
    protected Logger logger;

    @BeforeClass
    public void setUp()  {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
        context = browser.newContext();
        page = context.newPage();
    }
    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (!result.isSuccess()) {
            String testName = result.getMethod().getMethodName();
            String screenshotPath = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(true));
            logger.error("Test failed. Screenshot saved at: {}", screenshotPath);
        }
    }

    @AfterClass
    public void teartoen() {
        if (playwright != null) {
            playwright.close();
        }
    }



}
