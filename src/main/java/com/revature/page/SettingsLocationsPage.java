package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsLocationsPage {

	WebDriver driver;
	WebDriverWait wait;

	public SettingsLocationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement cancelDeleteButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("location-disablelocation-cancel")));
	}

	public WebElement chooseEditNthState(int n) {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editLocationModal']//select[@id='locationState']//option["
					+ n + "]")));
	}

	public WebElement chooseEditStateByStateAbrv(String stateAbrv) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("locationspage-editlocationmodal-" + stateAbrv + "option")));
	}

	// Create Location Modal**********************************

	public WebElement chooseNthState(int n) {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addLocationModal']//select[@id='locationState']//option["
					+ n + "]")));
	}

	public WebElement chooseStateByStateAbrv(String stateAbrv) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("locationspage-addlocationmodal-" + stateAbrv + "option")));
	}

	public WebElement closeAddLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("location-addlocationmodal-closelocation")));
	}
	// **********************************************************************************************************************

	public WebElement closeEditLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("locationspage-editlocationmodal-closemodal")));
	}

	public WebElement createLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("locationspage-component-displayaddlocationmodal")));

	}

	public WebElement deactivateLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//button[@class='btn btn-lg btn-danger']")));
	}

	public WebElement getTableData(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public WebElement getTableRow(int rowNumber) {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//table[@id='locationspage-component-locations-table']/tbody/tr["
					+ rowNumber + "]")));
	}

	public WebElement inputCity() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addLocationModal']//input[@placeholder='Enter City']")));
	}

	// EDIT LOCATION
	// MODAL***************************************************************************************************

	public WebElement inputCompanyName() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addLocationModal']//input[@id='locationCompany']")));
	}

	public WebElement inputEditCity() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editLocationModal']//input[@placeholder='Enter City']")));
	}

	public WebElement inputEditCompanyName() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editLocationModal']//input[@id='locationCompany']")));
	}

	public WebElement inputEditLocationStreet() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editLocationModal']//input[@placeholder='Enter Street Address']")));
	}

	public WebElement inputEditZipCode() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editLocationModal']//input[@id='locationZipCode']")));
	}

	public WebElement inputLocationStreet() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addLocationModal']//input[@placeholder='Enter Street Address']")));
	}

	public WebElement inputZipCode() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addLocationModal']//input[@id='locationZipCode']")));
	}

	public WebElement reactivateLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//button[@class='btn btn-lg btn-danger']")));
	}

	public WebElement saveAddLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("location-addlocationmodal-savelocation")));
	}

	// Change Location Status
	// Modal*****************************************************************

	public WebElement saveEditLocationButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("locationspage-editlocationmodal-savelocation")));
	}

	public WebElement stateDropdown() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addLocationModal']//select[@id='locationState']")));
	}

	public WebElement stateEditDropdown() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editLocationModal']//select[@id='locationState']")));
	}

}
