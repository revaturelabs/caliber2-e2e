package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Create Batch Modal, Edit Batch Modal, Add Trainee Modal, and Show Trainees
// Modal are on separate POMs
public class ManageBatchPage {

	WebDriver driver;
	WebDriverWait wait;

	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}

	public WebElement getDropdownSelectYearContainer() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='manage-batch-year-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}

	public WebElement getItemByItemNumber(WebElement dropdownContainer,
		int dropdownNumber) {
		return dropdownContainer.findElements(By.tagName("a"))
			.get(dropdownNumber);
	}

	public WebElement createBatchButton() {
		return driver.findElement(By.id("create-batch-button"))
			.findElement(By.tagName("a"));
	}

	// FINDING ELEMENTS ON THE
	// TABLE***************************************************
	@FindBy(id = "manage-batch-batch-list-data")
	public WebElement manageBatchTable;

	public WebElement getManageBatchTableRow(int rowNumber) {
		return manageBatchTable
			.findElement(By.id("manage-batch-batch-list-" + rowNumber));
	}

	public WebElement getManageBatchTableData(WebElement row,
		int columnNumber) {
		return row.findElement(By.xpath("//span[" + columnNumber + "]"));
	}

	public WebElement showTraineesButtonForRow(WebElement row) {
		return row
			.findElement(By.id("manage-batch-actions-show-trainees-button"));
	}

	public WebElement editBatchButtonForRow(WebElement row) {
		return row.findElement(By.id("manage-batch-actions-edit-batch-button"));
	}

	public WebElement removeBatchButtonForRow(WebElement row) {
		return row
			.findElement(By.id("manage-batch-actions-remove-batch-button"));
	}
	// *********************************************************************************

	// **********************************************************************************************************************

	// IMPORT BATCH
	// MODAL****************************************************************************************************
	public WebElement importBatchButton() {
		return driver.findElement(By.id("import-batch-button"));
	}

	public WebElement inputBatchJSON() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("gradeJsonObj")));
	}

	public WebElement cancelImportBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("import-batch-dialog-cancel-button")));
	}

	public WebElement submitImportBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("import-batch-dialog-import-button")));
	}
	// ***********************************************************************************************************************

	// DELETE BATCH MODAL
	public WebElement cancelDeleteBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-cancel-button")));
	}

	public WebElement confirmDeleteBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-delete-button")));
	}
	// ***********************************************************************************************************************

	// FINDING ELEMENTS ON THE TRAINEES
	// TABLE***************************************************
	public WebElement getTraineesTable() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody")));
	}

	public WebElement getTraineesTableRow(int rowNumber) {
		return getTraineesTable().findElement(By.xpath(
			"//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr["
				+ rowNumber + "]"));
	}

	public WebElement getTraineesTableData(WebElement row, int columnNumber) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public WebElement toggleActiveTraineesButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("view-trainees-modal-show-trainees-toggle-button")));
	}

	public WebElement addTraineeButton() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("add-trainee-button")));
	}

	public WebElement closeViewTraineesModalButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("view-trainees-modal-close-button")));
	}

	public WebElement switchBatchButtonForRow(WebElement row) {
		return row.findElement(By.id("trainee-actions-switch-button"));
	}

	public WebElement editTraineeButtonForRow(WebElement row) {
		return row.findElement(By.id("trainee-actions-edit-button"));
	}

	public WebElement removeTraineeButtonForRow(WebElement row) {
		return row.findElement(By.id("trainee-actions-remove-button"));
	}
	// *********************************************************************************

	// SWITCH BATCH
	// MODAL***************************************************************
	public WebElement getDropdownSwitchBatch() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("switchedBatch")));
	}

	public WebElement cancelSwitchBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-cancel-button")));
	}

	public WebElement confirmSwitchBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-switch-button")));
	}
	// *********************************************************************************

	// EDIT TRAINEE
	// MODAL**************************************************************
	public WebElement getEditTraineeFirstNameInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	}

	public WebElement getEditTraineeLastNameInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	}

	public WebElement getEditTraineeEmailInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	}

	public WebElement getEditTraineePhoneNumberInput() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("phoneNumber")));
	}

	public WebElement getDropdownTrainingStatus() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainingStatus")));
	}

	public WebElement getEditSkypeInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("skypeId")));
	}

	public WebElement getEditTraineeCollegeInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("college")));
	}

	public WebElement getEditTraineeDegreeInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("degree")));
	}

	public WebElement getEditTraineeMajorInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("major")));
	}

	public WebElement getEditTraineeRecruiterInput() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("recruiterName")));
	}

	public WebElement getEditTraineeProfileInput() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("profileUrl")));
	}

	public WebElement getEditTraineeTechScreenerInput() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("techScreener")));
	}

	public WebElement getEditTraineeProjectInput() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("projectCompletion")));
	}

	public WebElement confirmEditTraineeButton() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainee-modal-cancel-button")));
	}

	public WebElement cancelEditTraineeButton() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainee-modal-update-button")));
	}
	// ********************************************************************************

	// REMOVE TRAINEE
	// MODAL************************************************************
	public WebElement deleteTraineeButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-delete-button")));
	}

	public WebElement cancelDeleteTraineeButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-cancel-button")));
	}

	public WebElement confirmDeleteTraineeButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-confirm-delete-button")));
	}
	// ********************************************************************************
}
