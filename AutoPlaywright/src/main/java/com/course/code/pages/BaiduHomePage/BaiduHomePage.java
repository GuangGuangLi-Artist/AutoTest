package com.course.code.pages.BaiduHomePage;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaiduHomePage {
    private static final Logger logger = LoggerFactory.getLogger(BaiduHomePage.class);
    private final Page page;

    // 选择器
    private final String searchInput = "//div[@id='chat-input-area']/textarea";
    private final String searchButton = "#chat-submit-button";

    public BaiduHomePage(Page page) {
        this.page = page;
    }

    public void navigateTo() {
        logger.info("Navigating to Baidu home page");
        page.navigate("https://www.baidu.com");
    }

    public void enterSearchText(String text) {
        logger.info("Entering search text: " + text);
        page.fill(searchInput, text);
    }

    public void clickSearchButton() {
        logger.info("Clicking search button");
        page.press(searchButton,"Enter");
    }

    public boolean isResultShown(){
        boolean result = page.locator("#content_left").isVisible();
        logger.info("Result shown: {} " + result);
        return result;

    }

}
