package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	@FindBy(id = "signInFormUsername")
	public WebDriver inputUsername;

	@FindBy(id = "signInFormPassword")
	public WebDriver inputPassword;

	@FindBy(className = "redirect-customizable")
	public WebDriver forgotPasswordLink;

	@FindBy(className = "btn btn-primary submitButton-customizable")
	public WebDriver signInButton;
}
