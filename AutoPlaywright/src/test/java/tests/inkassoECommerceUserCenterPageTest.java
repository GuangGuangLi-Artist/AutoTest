package tests;

import base.BaseTest;
import com.course.code.pages.inkassoECommerceUserCenterPage.inkassoECommerceUserCenterPage;
import com.course.code.pages.inkassoLoginPage.InkassoLoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AssertUtil;
import utils.DataProviderUtil;

import java.nio.file.Paths;
import java.util.Map;


@Epic("国内电商用户中心页")//定义一个测试功能的顶层范围 可以将多个 @Allure.feature 标记的用例归类到同一个epic 下
@Feature("添加店铺")
public class inkassoECommerceUserCenterPageTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(inkassoECommerceUserCenterPageTest.class);
    String eCommerceUserCenterPagepath = "src/test/resources/testdata/json/ECommerceUserCenterPage/ECommerceUserCenterPage.json";


    @DataProvider(name="addShopData")
    public Object[][] addShopDataProvider(){
        return DataProviderUtil.loadFromJsonKey(eCommerceUserCenterPagepath,"addShop");
    }


    @Test(description = "添加店铺成功",dataProvider = "addShopData")
    @Severity(SeverityLevel.CRITICAL)
    @Story("添加店铺成功")
    public void testAddShopSuccessWithJSON(Map<String,Object> data){

        logger.info("开始测试国内电商添加店铺");
        String eCommerce_url = (String) data.get("ECommerce_url");
        Browser.NewContextOptions options = new Browser.NewContextOptions().setStorageStatePath(Paths.get("src/test/resources/loginState.json"));
        context = browser.newContext(options);
        inkassoECommerceUserCenterPage addShopPage = new inkassoECommerceUserCenterPage(page);
        addShopPage.navigateToECommerceUserCenterPag(eCommerce_url);

        addShopPage.addShop();


    }






    
}
