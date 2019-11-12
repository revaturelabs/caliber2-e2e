package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 3);

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//DROPDOWN CONTAINERS*****************************************************************************************************
	public WebElement getDropdownSelectBatchContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-select-dropdown-list")));
	}

	public WebElement getDropdownSelectWeeksContainer() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-shared-dropdown-menu[@id='reports-toolbar-week-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}

	public WebElement getDropdownSelectYearContainer() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-shared-dropdown-menu[@id='reports-toolbar-year-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}
	
	public WebElement getDropdownSelectTraineeContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-shared-dropdown-menu[@id='reports-toolbar-trainees-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}
	//**************************************************************************************************************
	

	public WebElement getItemByItemNumber(WebElement dropdownContainer, int dropdownNumber) {
		return dropdownContainer.findElements(By.tagName("a")).get(dropdownNumber);
	}

	public WebElement selectDropdownItem(String itemName) {
		return driver.findElement(By.id("shared-dropdown-menu-" + itemName));
	}

	public WebElement getRowForQCScores(int rowNumber) {
		return driver.findElement(By.xpath("//table[@id='qc-scores-container-table-default']/tr[" + rowNumber + "]"));
	}

	public WebElement getTableData(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	@FindBy(id = "qc-scores-donut-chart")
	public WebElement qcScoresDonutChart;

	public WebElement getRowForQCScoresDonutChartTable(int rowNumber) {
		return driver.findElement(By.xpath("//table[@id='qc-scores-donut-chart-table']/tr[" + rowNumber + "]"));
	}

	@FindBy(id = "qc-scores-bar-chart")
	public WebElement qcScoresBarChart;

}
