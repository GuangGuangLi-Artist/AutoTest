package utils;

import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 存储登录状态 后续调用复用
 */

public class LoginManager {

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);
    String storageStatePath = "src/test/resources/loginState.json";

    /**
     * 加载已保存的登录状态
     */
    public static BrowserContext loadLoggedInContext(Browser browser, String storageStatePath) {
        Path path = Paths.get(storageStatePath);
        if (!Files.exists(path)) {
            logger.info("登录状态文件不存在：{}", storageStatePath);
            return browser.newContext();
        }
        logger.info("加载登录状态文件：{}", storageStatePath);
        return browser.newContext(new Browser.NewContextOptions().setStorageStatePath(path));
    }

    public static void saveLoginSession(Browser browser,
                                        String loginUrl,
                                        String username, String password,
                                        String storageStatePath) throws IOException {
        logger.info("执行自动登录...");

        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        InkassoLoginPage loginPage = new InkassoLoginPage(page);
        loginPage.navigateToInkassoLoginPage(loginUrl);
        loginPage.login(username, password);
        try {
            String userphone = loginPage.getUserphone();
            if (!userphone.equals("")) {
                logger.info("登录成功，保存登录状态到：{}", storageStatePath);
            }
        } catch (Exception e) {
            logger.error("登录失败，未检测到登录成功的电话号码");
            throw new RuntimeException("登录失败，账号或元素可能错误", e);
        }


        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths
                .get(storageStatePath)));

    }

    public static boolean isLogininValid(Page page, String checkUrl) {
        try {
            page.navigate(checkUrl);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("登录/注册")).click();
            return page.getByText("退出").isVisible();//登录
        } catch (Exception e) {
            logger.warn("检测登录状态失败，可能未登录");
            return false;
        }
    }
}
