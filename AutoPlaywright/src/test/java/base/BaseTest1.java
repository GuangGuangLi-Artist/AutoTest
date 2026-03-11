package base;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest1 {

    public static final Logger logger = LoggerFactory.getLogger(BaseTest1.class);
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeMethod
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }


    @AfterMethod
    public void tearDown(){
        if (page != null){
            page.close();
        }
        if (browser!= null){
            browser.close();
        }
        if(playwright!= null) {
            playwright.close();
        }
    }
}
