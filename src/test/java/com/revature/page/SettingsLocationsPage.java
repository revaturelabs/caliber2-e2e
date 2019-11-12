package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsLocationsPage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 3);
	
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
	
	//Create Location Modal**********************************
	
	public WebElement inputCompanyName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addLocationModal']//input[@id='locationCompany']")));
	}
	
	public WebElement inputLocationStreet() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addLocationModal']//input[@id='locationCity']")));
	}
	
	public WebElement inputCity() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addLocationModal']//input[@id='locationStreet']")));
	}
	
	public WebElement stateDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addLocationModal']//input[@id='locationState']")));
	}
	
	public WebElement chooseStateByStateAbrv(String stateAbrv) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationspage-addlocationmodal-"+stateAbrv+"option")));
	}
	public WebElement chooseNthState(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addLocationModal']//select[@id='locationState']//option["+n+"]")));
	}
	
	public WebElement inputZipCode() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addLocationModal']//input[@id='locationZipCode']")));
	}
	
	public WebElement saveAddLocationButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location-addlocationmodal-savelocation")));
	}
	
	public WebElement closeAddLocationButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location-addlocationmodal-closelocation")));
	}
	//**********************************************************************************************************************
	
	
	//EDIT LOCATION MODAL***************************************************************************************************
	
	public WebElement inputEditCompanyName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editLocationModal']//input[@id='locationCompany']")));
	}
	
	public WebElement inputEditLocationStreet() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editLocationModal']//input[@id='locationCity']")));
	}
	
	public WebElement inputEditCity() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editLocationModal']//input[@id='locationStreet']")));
	}
	
	public WebElement stateEditDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editLocationModal']//input[@id='locationState']")));
	}
	
	public WebElement chooseEditStateByStateAbrv(String stateAbrv) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationspage-editLocationModal-"+stateAbrv+"option")));
	}
	public WebElement chooseEditNthState(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editLocationModal']//select[@id='locationState']//option["+n+"]")));
	}
	
	public WebElement inputEditZipCode() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editLocationModal']//input[@id='locationZipCode']")));
	}
	
	public WebElement saveEditLocationButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationspage-editlocationmodal-savelocation")));
	}
	
	public WebElement closeEditLocationButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationspage-editlocationmodal-closemodal")));
	}
	
	
	//Change Location Status Modal*****************************************************************
	
	public WebElement deactivateLocationButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location-disablelocation-updatelocation-Deactivate")));
	}
	
	public WebElement cancelDeleteButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location-disablelocation-cancel")));
	}
	
	public WebElement reactivateLocationButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location-disablelocation-updatelocation-Reactivate")));
	}

}
