package utils;

import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * 存储登录状态 后续调用复用
 */

public class SaveSession {

    String userPassFilePath = "src/test/resources/testdata/json/userPass.json";
    public Map<String, Object> loginRDataProvider() {
        return DataProviderUtil.getValueByJsonKey(userPassFilePath,"rightUser");


    }


    public static void saveLoginSession() throws IOException {
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
            String storeJson = context.storageState();
            Files.write(path,storeJson.getBytes(StandardCharsets.UTF_8));
            browser.close();



        }
    }
}
