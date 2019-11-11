package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsTrainerPage {

	WebDriver driver;
	
	public SettingsTrainerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="addTrainerButton")
	public WebElement addTrainerButton;
	
	public WebElement getTableRow(int rowNumber) {
		return driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tr["+rowNumber+"]"));
	}
	public WebElement getTableCell(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td["+columnNumber+"]"));
	}
}
