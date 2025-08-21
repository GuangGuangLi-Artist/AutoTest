package utils;

import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class SaveSession {

    String userPassFilePath = "src/test/resources/testdata/json/userPass.json";
    String storageJson = "";
    public Map<String, Object> loginRDataProvider() {
        return DataProviderUtil.getValueByJsonKey(userPassFilePath,"rightUser");


    }


    @Test
    public static void saveLoginSession(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(5000).setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            InkassoLoginPage loginPage = new InkassoLoginPage(page);
            Map<String, Object> userInfo =new SaveSession().loginRDataProvider();
            String url = (String) userInfo.get("login_url");
            String username = (String) userInfo.get("username");
            String password = (String) userInfo.get("password");
            loginPage.navigateToInkassoLoginPage(url);
            loginPage.login(username, password);
            Path path = Paths.get("src/test/resources/loginState.json");
            String s = context.storageState(path);
            System.out.println(s);

            System.out.println("登录状态已保存到 loginState.json");
            browser.close();


        }
    }
}
