package tests;

import base.BaseTest;
import com.course.code.pages.BaiduHomePage.BaiduHomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("百度首页测试")
@Feature("搜索功能")
public class BaiduSearchTest extends BaseTest {

    @Test(description = "测试百度搜索功能")
    @Severity(SeverityLevel.CRITICAL)
    @Story("用户输入关键词进行搜索")
    public void testSearch() {

        BaiduHomePage baiduHomePage = new BaiduHomePage(page);//调用playwright 打开一个空白页面
        baiduHomePage.navigateTo();//在页面打开百度首页
        baiduHomePage.enterSearchText("百度改页面了吗");
        baiduHomePage.clickSearchButton();
        Assert.assertTrue(baiduHomePage.isResultShown(),"搜索结果未展示");

    }


}
