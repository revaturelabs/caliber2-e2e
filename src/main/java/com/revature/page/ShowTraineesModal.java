package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShowTraineesModal {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "view-trainees-modal-close-button")
	public WebElement closeTraineesModal;

	public ShowTraineesModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement addTraineeButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.className("create-trainee-button-text")));
	}

	// DELETE TRAINEE
	// MODAL*************************************************************************
	public WebElement cancelDeleteTraineeButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-cancel-button")));
	}

	public WebElement cancelSwitchBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-cancel-button")));
	}

	public WebElement confirmDeleteTraineeButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-delete-button")));
	}
	// **********************************************************************************************

	public WebElement getTraineesTableData(WebElement row, int columnNumber) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public WebElement getTraineesTableRow(int rowNumber) {
		return this.traineesTable()
			.findElement(By.xpath("//tr[" + rowNumber + "]"));
	}

	public WebElement selectBatchDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("switchedBatch")));
	}

	// SWITCH BATCH
	// MODAL****************************************************************************

	public WebElement selectBatchDropdownNthOption(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='switchedBatch']//option[" + n + "]")));
	}

	public WebElement showActiveTraineesOnlyToggle() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("view-trainees-modal-show-trainees-toggle-button")));
	}

	public WebElement submitSwitchBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-switch-button")));
	}
	// ***********************************************************************************************

	public WebElement traineesTable() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.className("view-trainees-modal-trainees-list-table")));
	}

}
