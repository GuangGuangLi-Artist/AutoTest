package com.course.code.pages.inkassoECommerceUserCenterPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InkassoECommerceUserCenterPage {
    /**
     * 国内电商用户中心首页
     */
    private static final Logger logger = LoggerFactory.getLogger(InkassoECommerceUserCenterPage.class);
    private Page page;

    private Locator loginButton;
    private Locator userCenter;
    private Locator addShopButton;
    public InkassoECommerceUserCenterPage(Page page) {
        this.page = page;
        this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("登录/注册"));
        this.userCenter = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("用户中心"));
        this.addShopButton = page.getByText("添加店铺");

    }

    public void navigateToECommerceUserCenterPag(String url) {
        logger.info("navigateToECommerceUserCenterPag(" + url + ")");
        page.navigate(url);
    }

    @Step("clickLoginButton")
    public void clickLoginButton() {
        logger.info("clickLoginButton()");
        loginButton.click();
    }

    @Step("clickUserCenter")
    public void clickUserCenter(){
        logger.info("click user center");
        userCenter.click();
    }
    @Step("clickAddShopButton")
    public void clickAddShopButton(){
        logger.info("click add shop button");
        addShopButton.click();
    }


    public void addShop(){
        logger.info("add shop");
        clickUserCenter();
        clickAddShopButton();


    }
}
