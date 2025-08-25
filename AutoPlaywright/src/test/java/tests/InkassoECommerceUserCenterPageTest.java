package tests;

import base.BaseTest;
import com.course.code.pages.inkassoECommerceUserCenterPage.InkassoECommerceUserCenterPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviderUtil;

import java.util.Map;


@Epic("国内电商用户中心页")//定义一个测试功能的顶层范围 可以将多个 @Allure.feature 标记的用例归类到同一个epic 下
@Feature("添加店铺")
public class InkassoECommerceUserCenterPageTest extends BaseTest {


    private static final Logger logger = LoggerFactory.getLogger(InkassoECommerceUserCenterPageTest.class);
    String eCommerceUserCenterPagepath = "src/test/resources/testdata/json/ECommerceUserCenterPage/ECommerceUserCenterPage.json";

    @DataProvider(name="addShopData")
    public Object[][] addShopDataProvider(){
        return DataProviderUtil.loadFromJsonKey(eCommerceUserCenterPagepath,"addShop");
    }

    @Test(description = "添加店铺成功",dataProvider = "addShopData")
    @Severity(SeverityLevel.CRITICAL)
    @Story("添加店铺成功")
    public void testAddShopSuccessWithJSON(Map<String,Object> data)  {

        logger.info("开始测试国内电商添加店铺");
        String eCommerce_url = (String) data.get("ECommerce_url");
        InkassoECommerceUserCenterPage userCenterPage = new InkassoECommerceUserCenterPage(page);
        userCenterPage.navigateToECommerceUserCenterPag(eCommerce_url);
        //如果已登录 就不点击登录按钮，如果没登录，就先点击登录按钮 添加店铺
        if (page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("用户中心")).isVisible()){
            userCenterPage.addShop();
        }else {
            userCenterPage.clickLoginButton();
            userCenterPage.addShop();
        }


    }
}
