package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsLocationsPage {
	
	WebDriver driver;
	
	public SettingsLocationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="locationspage-component-displayaddlocationmodal")
	public WebElement createLocationButton;
	
	public WebElement getTableRow(int rowNumber) {
		return driver.findElement(By.xpath("//table[@id='locationspage-component-locations-table']/tr["+rowNumber+"]"));
	}
	
	public WebElement getTableData(int columnNumber, WebElement row){
		return row.findElement(By.xpath("//td["+columnNumber+"]"));
	}
	
	//Create or Edit Location Modal**********************************
	
	@FindBy(id="locationCompany")
	public WebElement inputCompanyName;
	
	@FindBy(id="locationCity")
	public WebElement inputLocationStreet;
	
	@FindBy(id="locationStreet")
	public WebElement inputCity;
	
	@FindBy(id="locationState")
	public WebElement stateDropdown;
	
	public WebElement chooseState(String stateAbrv) {
		return driver.findElement(By.id("locationspage-addlocationmodal-"+stateAbrv+"option"));
	}
	
	@FindBy(id="locationZipCode")
	public WebElement inputZipCode;
	
	@FindBy(id="location-addlocationmodal-savelocation")
	public WebElement saveAddLocationButton;
	
	@FindBy(id="location-addlocationmodal-closelocation")
	public WebElement closeAddLocationButton;
	
	//Edit Location Modal*****************************************************************
	
	@FindBy(id="location-disablelocation-updatelocation-Deactivate")
	public WebElement deactivateLocationButton;
	
	@FindBy(id="location-disablelocation-cancel")
	public WebElement cancelDeleteButton;
	
	@FindBy(id="location-disablelocation-updatelocation-Reactivate")
	public WebElement reactivateLocationButton;

}
