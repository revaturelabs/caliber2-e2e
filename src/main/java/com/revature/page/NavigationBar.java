package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar {

	WebDriver driver;
	WebDriverWait wait;
	
	public NavigationBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}
	
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
	
	@FindBy(id="settings-link")
	public WebElement settings;
	
	@FindBy(id="trainers-link")
	public WebElement trainers;
	
	@FindBy(id="location-link")
	public WebElement locations;
	
	@FindBy(id="category-link")
	public WebElement categories;
	
	@FindBy(id="header-login-link")
	public WebElement login;
	
	@FindBy(id="header-navbar-toggle-button")
	public WebElement navBarToggleButton;
}
