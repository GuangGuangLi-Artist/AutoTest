package com.course.pageobject.handle;

import com.course.pageobject.page.CourseDetailPage;
import org.openqa.selenium.WebDriver;

public class AddCourseHandle {

    public CourseDetailPage courseDetailPage;

    public AddCourseHandle(WebDriver driver){
       courseDetailPage = new CourseDetailPage(driver);
    }

    public void clickAddcart(){
        courseDetailPage.getAddcart().click();


    }

    public String getActiveTitle(){
        String title = courseDetailPage.getActiveTitle().getText();
        return title;
    }



}
