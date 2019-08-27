package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageBatchPage {

	WebDriver driver;

	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="manage-link")
	public static WebElement managebatchlink;

	@FindBy(xpath="//*[@id=\"manage\"]/div[1]/div/div/ul/li[3]/a")
	public static WebElement createbatchlink;
	
	@FindBy(xpath="//*[@id=\"manage\"]/div[1]/div/div/ul/li[2]/a")
	public static WebElement importbatchlink;
	
	
	
}
