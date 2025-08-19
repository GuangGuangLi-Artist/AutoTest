package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeClass
    public void setUp()  {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterClass
    public void teartoen() {
        if (playwright != null) {
            playwright.close();
        }
    }



}
