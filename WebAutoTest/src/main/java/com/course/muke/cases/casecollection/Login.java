package com.course.muke.cases.casecollection;

import com.course.muke.cases.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public WebDriver driver;
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");


    }

    //获取定位元素的值
    public By getByByLocal(String key){
        ProUtil proUtil = new ProUtil("F:\\ideaWorkspace\\AutoTest\\WebAutoTest\\src\\main\\java\\com\\course" +
                "\\muke\\cases\\config\\element.properties");
        String locator = proUtil.getPro(key);//name>email

        String locatorBy = locator.split(">")[0];//name
        String locatorValue = locator.split(">")[1];//email
        if(locatorBy.equals("id")){
         return By.id(locatorValue);
        }else if(locatorBy.equals("name")){
            return By.name(locatorValue);
        }else if(locatorBy.equals("className")){
            return By.className(locatorValue);
        }else {
            return By.xpath(locatorValue);
        }
    }

    //获取Element
    public WebElement getElement(String key){
        WebElement element = driver.findElement(this.getByByLocal(key));
        return element;
    }

    public void userLogin(String username,String password){
        initDriver();
        WebElement emailElement = getElement("username");
        WebElement passWordElement = getElement("pawwword");
        WebElement loginButtonElement = getElement("loginbutton");
        emailElement.sendKeys(username);
        passWordElement.sendKeys(password);
        loginButtonElement.click();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        Login login = new Login();

    }




}
