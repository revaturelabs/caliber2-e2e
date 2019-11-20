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

	public ShowTraineesModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}

	@FindBy(id = "view-trainees-modal-close-button")
	public WebElement closeTraineesModal;

	public WebElement showActiveTraineesOnlyToggle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("view-trainees-modal-show-trainees-toggle-button")));
	}

	public WebElement addTraineeButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.className("create-trainee-button-text")));
	}

	public WebElement traineesTable() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.className("view-trainees-modal-trainees-list-table")));
	}

	public WebElement getTraineesTableRow(int rowNumber) {
		return traineesTable().findElement(By.xpath("//tr[" + rowNumber + "]"));
	}

	public WebElement getTraineesTableData(WebElement row, int columnNumber) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	// DELETE TRAINEE
	// MODAL*************************************************************************
	public WebElement cancelDeleteTraineeButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-cancel-button")));
	}

	public WebElement confirmDeleteTraineeButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-delete-button")));
	}
	// **********************************************************************************************

	// SWITCH BATCH
	// MODAL****************************************************************************

	public WebElement selectBatchDropdown() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("switchedBatch")));
	}

	public WebElement selectBatchDropdownNthOption(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='switchedBatch']//option[" + n + "]")));
	}

	public WebElement cancelSwitchBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-cancel-button")));
	}

	public WebElement submitSwitchBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-switch-button")));
	}
	// ***********************************************************************************************

}
