package utils;

import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.PagesPerMinute;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * 存储登录状态 后续调用复用
 */

public class LoginManager {

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);

    /**
     * 加载已保存的登录状态
     */
    public static BrowserContext loadLoggedInContext(Browser browser,String storageStatePath) {
        Path path = Paths.get(storageStatePath);
        if (!Files.exists(path)) {
            logger.info("登录状态文件不存在：{}", storageStatePath);
            return browser.newContext();
        }
        logger.info("加载登录状态文件：{}", storageStatePath);
        return browser.newContext(new Browser.NewContextOptions().setStorageStatePath(path));
    }

    String userPassFilePath = "src/test/resources/testdata/json/userPass.json";
    public Map<String, Object> loginRDataProvider() {
        return DataProviderUtil.getValueByJsonKey(userPassFilePath,"rightUser");


    }


    public static void saveLoginSession() throws IOException {
        logger.info("执行自动登录...");
        String storageStatePath = "src/test/resources/loginState.json";
        try (Playwright playwright = Playwright.create()) {
            Browser  browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(5000).setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            InkassoLoginPage loginPage = new InkassoLoginPage(page);
            Map<String, Object> userInfo =new LoginManager().loginRDataProvider();
            String url = (String) userInfo.get("login_url");
            String username = (String) userInfo.get("username");
            String password = (String) userInfo.get("password");
            loginPage.navigateToInkassoLoginPage(url);
            loginPage.login(username, password);
            try {
                String userphone = loginPage.getUserphone();
                if (!userphone.equals("")){
                    logger.info("登录成功，保存登录状态到：{}", storageStatePath);
                }
            }catch (Exception e){
                logger.error("登录失败，未检测到登录成功的电话号码");
                throw new RuntimeException("登录失败，账号或元素可能错误", e);
            }


            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths
                    .get(storageStatePath)));
//            Path path = Paths.get(storageStatePath);
//            String storeJson = context.storageState();
//            Files.write(path,storeJson.getBytes(StandardCharsets.UTF_8));
            page.close();
            context.close();
            browser.close();
        }
    }

    public static boolean isLogininValid(Page page,String checkUrl) {
        try {
            page.navigate(checkUrl);
            return page.getByText("退出").isVisible();//登录
        } catch (Exception e) {
            logger.warn("检测登录状态失败，可能未登录");
            return false;
        }
    }
}
