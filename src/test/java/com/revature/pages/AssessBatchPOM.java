package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessBatchPOM {
    WebDriver driver;
    public AssessBatchPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
//    @FindBy(id="name")
//    public WebElement template;
    
    @FindBy(id="assessYearSelect")
    public WebElement yearSelect;
    
    @FindBy(id="assessQuarterSelect")
    public WebElement quarterSelect;
    
    @FindBy(id="assessSelectBatch")
    public WebElement selectBatch;
    @FindBy(id="Week:1")
    public WebElement weekOne;
    
    @FindBy(id="addNewWeek")
    public WebElement newWeek;
    
    @FindBy(id="assessAcceptWeek")
    public WebElement acceptWeek;
    
    @FindBy(id="assessDeclineWeek")
    public WebElement declineWeek;
}