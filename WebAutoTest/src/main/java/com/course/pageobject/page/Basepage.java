package com.course.pageobject.page;

import com.course.muke.cases.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Basepage {
    private  WebDriver driver;

    public  Basepage(WebDriver driver){
        this.driver = driver;

    }

    public WebElement getElement(String key){
        return driver.findElement(getByByLocal(key));
    }

    public By getByByLocal(String key){
        ProUtil proUtil = new ProUtil("src/main/java/com/course/muke/cases/config/element.properties");
        String locator = proUtil.getPro(key);//name>email

        String locatorBy = locator.split(">")[0];//name
        String locatorValue = locator.split(">")[1];//email
        System.out.println(locatorValue);
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

    public void moveToElement(WebElement toElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(toElement).perform();

    }


}
