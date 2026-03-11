package tests;

import base.BaseTest1;
import com.course.code.pages.baiduHomePage.BaiduHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewBdTest extends BaseTest1 {

    private static final Logger logger = LoggerFactory.getLogger(NewBdTest.class);

    @Test(dataProvider = "bdk")
    public void testBdSerarch(String text){
        logger.info("开始执行用例");
        //页面Page对象继承自BaseTest1,会打开浏览器等
        BaiduHomePage baiduHomePage = new BaiduHomePage(page);
        //打开百度
        baiduHomePage.navigateTo();
        baiduHomePage.enterSearchText(text);
        baiduHomePage.clickSearchButton();

    }


    @DataProvider(name="bdk")
    public Object[][] bdKeywords(){
        return new Object[][]{
                {"openClaw"},
                {"chatGpt"}
        };
    }
}
