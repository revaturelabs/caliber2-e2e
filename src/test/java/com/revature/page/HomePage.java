package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="auditStateSelect")
	public WebElement stateselect;
	
	@FindBy(id="logo-id")
	public WebElement logo;
	
	@FindBy(id="home-link")
	public WebElement homenav;
	
	@FindBy(id="manage-link")
	public WebElement managebatch;
	
	@FindBy(id="assess-link")
	public WebElement assessbatch;
	
	@FindBy(id="quality-link")
	public WebElement qualitybatch;
	
	@FindBy(id="panel-link")
	public WebElement panel;
	
	@FindBy(id="reports-link")
	public WebElement reports;
	
	@FindBy(xpath="/html/body/app-root/app-header/nav/div/ul[2]/li[7]/a")
	public WebElement settings;
	
	@FindBy(id="trainers-link")
	public WebElement trainers;
	
	@FindBy(id="location-link")
	public WebElement locations;
	
	@FindBy(id="category-link")
	public WebElement category;
	
	@FindBy(xpath="//*[@id=\"footer-id\"]/div/div/div/div[2]/a[1]")
	public WebElement telephonenum;
	
	@FindBy(xpath="//*[@id=\"footer-id\"]/div/div/div/div[2]/a[2]")
	public WebElement email;
	
	@FindBy(xpath="//*[@id=\"revature-link\"]")
	public WebElement revaturehome;
	
}
