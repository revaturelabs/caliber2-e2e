package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Caliber2page {
	// Run the test on Junit4 ONLY!~!~!~!
	WebDriver driver;
	
	public Caliber2page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
