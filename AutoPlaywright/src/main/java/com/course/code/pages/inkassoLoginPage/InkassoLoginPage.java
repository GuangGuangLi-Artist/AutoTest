package com.course.code.pages.inkassoLoginPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InkassoLoginPage {
    public static Logger logger = LoggerFactory.getLogger(InkassoLoginPage.class);
    private final Page page;
    private final Locator loginButton;
    private final Locator phoneNumber;
    private final Locator verifyCode;
    private final Locator xiyi;
    private final Locator subButton;
    private final Locator userphone;


    public InkassoLoginPage(Page page) {
        this.page = page;
        this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("登录/注册"));
        this.phoneNumber = page.getByPlaceholder("请输入手机号码");
        this.verifyCode = page.getByPlaceholder("请输入6位数验证码");
        this.xiyi = page.locator("form div").filter(new Locator.FilterOptions().setHasText("我已阅读并接受 《用户协议》 和 《隐私政策》")).locator("span").nth(1);
        this.subButton = page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("登录/注册"));
        this.userphone = page.locator("xpath =//span[starts-with(@class,'el-dropdown-link')]");

    }

    public void navigateToInkassoLoginPage(String loginUrl) {
        logger.info("Navigating to inkasso login page");
        page.navigate(loginUrl);

    }

    @Step("调出登录框")
    public void clickLoginButton() {
        logger.info("Clicking login button");
        loginButton.click();
    }

    @Step("输入电话号码:{number}")
    public void enterphoneNumber(String number) {
        logger.info("Entering inkasso login using user name: " + number);
        phoneNumber.fill(number);
    }

    @Step("输入验证码:{code}")
    public void enterverifyCode(String code) {
        logger.info("Entering inkasso login using user code: " + code);
        verifyCode.fill(code);
    }

    @Step("点击协议")
    public void clickrxidyi() {
        logger.info("Clicking rxidyi");
        xiyi.click();
    }

    @Step("点击登录按钮")
    public void clicksubButton() {
        logger.info("Clicking sub button");
        subButton.click();
    }

    public String getUserphone() {
        logger.info("Getting user phone number");
        return userphone.innerText();
    }

    public void login(String number, String code) {
        clickLoginButton();
        enterphoneNumber(number);
        enterverifyCode(code);
        clickrxidyi();
        clicksubButton();

    }


}
