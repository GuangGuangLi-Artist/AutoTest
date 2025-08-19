package com.course.code.pages.BaiduHomePage;

import com.microsoft.playwright.Page;

public class BaiduHomePage {
    private final Page page;

    // 选择器
    private final String searchInput = "//div[@id='chat-input-area']/textarea";
    private final String searchButton = "#chat-submit-button";

    public BaiduHomePage(Page page) {
        this.page = page;
    }

    public void navigateTo() {
        page.navigate("https://www.baidu.com");
    }

    public void enterSearchText(String text) {
        page.fill(searchInput, text);
    }

    public void clickSearchButton() {
        page.press(searchButton,"Enter");
    }

    public boolean isResultShown(){
        return page.locator("#content_left").isVisible();
    }

}
