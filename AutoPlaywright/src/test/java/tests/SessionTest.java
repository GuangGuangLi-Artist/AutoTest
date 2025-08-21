package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class SessionTest {

        @Test
        public void testWithSavedLogin() {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
            Browser.NewContextOptions options = new Browser.NewContextOptions()
                    .setStorageStatePath(Paths.get("src/test/resources/loginState.json"));
            BrowserContext context = browser.newContext(options);
            Page page = context.newPage();
            page.navigate("http://222.90.211.174:19998/tec#/dashboard");
            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("用户中心")).click();

            // 直接进行登录后操作
            System.out.println("已复用登录会话进行测试");

            browser.close();
            playwright.close();
        }

}
