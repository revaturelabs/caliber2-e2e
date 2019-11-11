package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AssessBatch {
	
	WebDriver driver;
	
	public AssessBatch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //Pagefactory is useful
	}
	
	@FindBy(id="batch-select-toolbar-years-dropdown")
	public WebElement yearDropdown;

	public WebElement getSelectedYear() {
		return yearDropdown.
			findElement(By.id("shared-dropdown-menu-current-value"));
	}
	
	public WebElement getYearDropdownContainer() {
		return yearDropdown.
			findElement(By.id("shared-dropdown-menu-dropdown-container"));
	}
	
	public void selectYear(String year) {
		Select select = new Select(getYearDropdownContainer());
		select.selectByVisibleText(year);
	}
	
	public void selectYear(int index) {
		Select select = new Select(getYearDropdownContainer());
		select.selectByIndex(index);
	}
	
	@FindBy (id = "batch-select-toolbar-quaters-dropdown")
	public WebElement quarterDropdown;
	
	public WebElement getSelectedQuarter() {
		return quarterDropdown.
			findElement(By.id("shared-dropdown-menu-current-value"));
	}
	
	public WebElement getQuarterDropdownContainer() {
		return quarterDropdown.
			findElement(By.id("shared-dropdown-menu-dropdown-container"));
	}
	
	public void selectQuarter(String quarter) {
		Select select = new Select(getQuarterDropdownContainer());
		select.selectByVisibleText(quarter);
	}
	
	public void selectQuarter(int index) {
		Select select = new Select(getQuarterDropdownContainer());
		select.selectByIndex(index);
	}
	
	@FindBy (id = "batch-select-toolbar-batches-dropdown")
	public WebElement batchesDropdown;
	
	public WebElement getSelectedBatch() {
		return batchesDropdown.
			findElement(By.id("shared-dropdown-menu-current-value"));
	}
	@FindBy (id ="batch-select-dropdown-list")
	public WebElement batchDropdownContainer;
	
	public void selectBatch(String batch) {
		Select select = new Select(batchDropdownContainer);
		select.selectByVisibleText(batch);
	}
	
	public void selectBatch(int index) {
		Select select = new Select(batchDropdownContainer);
		select.selectByIndex(index);
	}
	
	@FindBy (id ="batch-select-search-bar")
	public WebElement batchSearchBar;
	
	@FindBy (id = "assess-batch-v2-createassessment")
	public WebElement createAssessmentButton;
}
