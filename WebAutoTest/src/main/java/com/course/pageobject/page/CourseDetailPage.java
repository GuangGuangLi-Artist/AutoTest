package com.course.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseDetailPage extends Basepage {
    public CourseDetailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取CourseDetailPage页面元素
     */

    public WebElement getAddcart(){
        return getElement("addcart");
    }

    public WebElement getActiveTitle(){
        return getElement("activeTitle");
    }

    public WebElement getHaveCourse(){
        return getElement("haveCourse");
    }




}
