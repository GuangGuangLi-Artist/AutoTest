package tests;

import com.course.code.pages.inkassoECommerceUserCenterPage.inkassoECommerceUserCenterPage;
import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviderUtil;
import utils.ScreenshotUtil;

import java.io.IOException;
import java.util.Map;


@Epic("国内电商用户中心页")//定义一个测试功能的顶层范围 可以将多个 @Allure.feature 标记的用例归类到同一个epic 下
@Feature("添加店铺")
public class inkassoECommerceUserCenterPageTest {


    private static final Logger logger = LoggerFactory.getLogger(inkassoECommerceUserCenterPageTest.class);
    String eCommerceUserCenterPagepath = "src/test/resources/testdata/json/ECommerceUserCenterPage/ECommerceUserCenterPage.json";

    @DataProvider(name="addShopData")
    public Object[][] addShopDataProvider(){
        return DataProviderUtil.loadFromJsonKey(eCommerceUserCenterPagepath,"addShop");
    }

    @Test(description = "添加店铺成功",dataProvider = "addShopData")
    @Severity(SeverityLevel.CRITICAL)
    @Story("添加店铺成功")
    public void testAddShopSuccessWithJSON(Map<String,Object> data) throws IOException {

        logger.info("开始测试国内电商添加店铺");
        String eCommerce_url = (String) data.get("ECommerce_url");
    }
}
