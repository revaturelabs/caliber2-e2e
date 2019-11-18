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
	WebDriverWait wait;

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	// DROPDOWN
	// CONTAINERS*****************************************************************************************************
	/**
	 * The actual list that is inside the dropdown once open.
	 * 
	 * @return The dropdown list.
	 */
	public WebElement getDropdownSelectBatchContainer() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("batch-select-dropdown-list")));
	}

	public WebElement getDropdownSelectWeeksContainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='reports-toolbar-week-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}

	public WebElement getDropdownSelectYearContainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='reports-toolbar-year-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}

	public WebElement getDropdownSelectTraineeContainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='reports-toolbar-trainees-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}
	// **************************************************************************************************************

	public WebElement getItemByItemNumber(WebElement dropdownContainer,
		int dropdownNumber) {
		return dropdownContainer.findElements(By.tagName("a"))
			.get(dropdownNumber);
	}

	public WebElement getSelectBatchDropdownOpenButton() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-batch-select-dropdown[@id='reports-toolbar-batch-dropdown']//li[@id='batch-select-dropdown-open-button']")));
	}

	public WebElement getSelectWeeksDropdownButton() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='reports-toolbar-week-dropdown']//li[@id='shared-dropdown-menu-button']")));
	}

	public WebElement getSelectTraineesDropdownButton() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='reports-toolbar-trainees-dropdown']//li[@id='shared-dropdown-menu-button']")));
	}

	public WebElement getSelectYearDropdownButton() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='reports-toolbar-year-dropdown']//a[@id='shared-dropdown-menu-current-value']")));
	}

	public WebElement selectDropdownItem(String itemName) {
		return this.driver
			.findElement(By.id("shared-dropdown-menu-" + itemName));
	}

	public WebElement getRowForQCScores(int rowNumber) {
		return this.driver.findElement(
			By.xpath("//table[@id='qc-scores-container-table-default']/tr["
				+ rowNumber + "]"));
	}

	public WebElement getQcScoreTable() {
		return this.driver.findElement(
			By.xpath("//table[@id='qc-scores-container-table-default']"));
	}

	public WebElement getIndividualScoreTable() {
		return this.driver.findElement(
			By.xpath("//table[@id='qc-scores-individual-results-table']"));
	}

	public WebElement getTableData(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public WebElement getDonutChartTable() {
		return this.driver.findElement(
			By.xpath("//table[@id='qc-scores-donut-chart-table']"));
	}

	/**
	 * Must have clicked on the select batch dropdown for this to be visible.
	 * 
	 * @return The search bar element.
	 */
	public WebElement getBatchSelectSearchBar() {
		return this.driver.findElement(By.id("batch-select-search-bar"));
	}

	@FindBy(id = "qc-scores-donut-chart")
	public WebElement qcScoresDonutChart;

	public WebElement getRowForQCScoresDonutChartTable(int rowNumber) {
		return this.driver.findElement(
			By.xpath("//table[@id='qc-scores-donut-chart-table']/tr["
				+ rowNumber + "]"));
	}

	@FindBy(id = "qc-scores-bar-chart")
	public WebElement qcScoresBarChart;

}
