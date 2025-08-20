package tests;

import base.BaseTest;
import com.course.code.pages.baiduHomePage.BaiduHomePage;
import data.BaiduSearchData;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.AssertUtil;

@Epic("百度首页测试")
@Feature("搜索功能")
public class BaiduSearchTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaiduSearchTest.class);

    @Test(description = "测试百度搜索功能",dataProvider = "csvKeywords",dataProviderClass = BaiduSearchData.class)
    @Severity(SeverityLevel.CRITICAL)
    @Story("用户输入关键词进行搜索")
    public void testSearch(String keyword) {

        logger.info("开始测试搜索关键词：{}", keyword);

        BaiduHomePage baiduHomePage = new BaiduHomePage(page);//调用playwright 打开一个空白页面
        baiduHomePage.navigateTo();//在页面打开百度首页
        baiduHomePage.enterSearchText(keyword);
        baiduHomePage.clickSearchButton();
        AssertUtil.assertTrue(baiduHomePage.isResultShown(),"搜索结果有没有展示!");
        logger.info("测试完成：搜索关键词“{}”成功展示结果。", keyword);

    }


}
