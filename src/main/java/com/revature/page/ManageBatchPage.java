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

	// FINDING ELEMENTS ON THE
	// TABLE***************************************************
	@FindBy(id = "manage-batch-batch-list-data")
	public WebElement manageBatchTable;

	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement addTraineeButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("add-trainee-button")));
	}

	// DELETE BATCH MODAL
	public WebElement cancelDeleteBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-cancel-button")));
	}

	public WebElement cancelDeleteTraineeButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-cancel-button")));
	}

	public WebElement cancelEditTraineeButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainee-modal-update-button")));
	}
	// ********************************************************************************

	public WebElement cancelImportBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("import-batch-dialog-cancel-button")));
	}

	public WebElement cancelSwitchBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-cancel-button")));
	}

	public WebElement closeViewTraineesModalButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("view-trainees-modal-close-button")));
	}

	public WebElement confirmDeleteBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-delete-button")));
	}
	// ***********************************************************************************************************************

	// **********************************************************************************************************************

	public WebElement confirmDeleteTraineeButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-confirm-delete-button")));
	}
	// ********************************************************************************

	public WebElement confirmEditTraineeButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainee-modal-cancel-button")));
	}

	public WebElement confirmSwitchBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("switch-batch-modal-switch-button")));
	}
	// *********************************************************************************

	public WebElement createBatchButton() {
		return this.driver.findElement(By.id("create-batch-button"))
			.findElement(By.tagName("a"));
	}

	// REMOVE TRAINEE
	// MODAL************************************************************
	public WebElement deleteTraineeButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("delete-trainee-modal-delete-button")));
	}

	public WebElement editBatchButtonForRow(WebElement row) {
		return row.findElement(By.id("manage-batch-actions-edit-batch-button"));
	}

	public WebElement editTraineeButtonForRow(WebElement row) {
		return row.findElement(By.id("trainee-actions-edit-button"));
	}

	public WebElement getDropdownSelectYearContainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='manage-batch-year-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}

	// SWITCH BATCH
	// MODAL***************************************************************
	public WebElement getDropdownSwitchBatch() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("switchedBatch")));
	}

	public WebElement getDropdownTrainingStatus() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainingStatus")));
	}

	public WebElement getEditSkypeInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("skypeId")));
	}

	public WebElement getEditTraineeCollegeInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("college")));
	}

	public WebElement getEditTraineeDegreeInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("degree")));
	}

	public WebElement getEditTraineeEmailInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	}

	// EDIT TRAINEE
	// MODAL**************************************************************
	public WebElement getEditTraineeFirstNameInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	}

	public WebElement getEditTraineeLastNameInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	}

	public WebElement getEditTraineeMajorInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("major")));
	}

	public WebElement getEditTraineePhoneNumberInput() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("phoneNumber")));
	}

	public WebElement getEditTraineeProfileInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("profileUrl")));
	}

	public WebElement getEditTraineeProjectInput() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("projectCompletion")));
	}

	public WebElement getEditTraineeRecruiterInput() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("recruiterName")));
	}

	public WebElement getEditTraineeTechScreenerInput() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("techScreener")));
	}

	public WebElement getItemByItemNumber(WebElement dropdownContainer,
		int dropdownNumber) {
		return dropdownContainer.findElements(By.tagName("a"))
			.get(dropdownNumber);
	}

	public WebElement getManageBatchTableData(WebElement row,
		int columnNumber) {
		return row.findElement(By.xpath("//span[" + columnNumber + "]"));
	}

	public WebElement getManageBatchTableRow(int rowNumber) {
		return this.manageBatchTable
			.findElement(By.id("manage-batch-batch-list-" + rowNumber));
	}

	// FINDING ELEMENTS ON THE TRAINEES
	// TABLE***************************************************
	public WebElement getTraineesTable() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody")));
	}

	public WebElement getTraineesTableData(WebElement row, int columnNumber) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public WebElement getTraineesTableRow(int rowNumber) {
		return this.getTraineesTable()
			.findElement(By.xpath(
				"//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr["
					+ rowNumber + "]"));
	}

	// IMPORT BATCH
	// MODAL****************************************************************************************************
	public WebElement importBatchButton() {
		return this.driver.findElement(By.id("import-batch-button"));
	}

	public WebElement inputBatchJSON() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("gradeJsonObj")));
	}

	public WebElement removeBatchButtonForRow(WebElement row) {
		return row
			.findElement(By.id("manage-batch-actions-remove-batch-button"));
	}
	// *********************************************************************************

	public WebElement removeTraineeButtonForRow(WebElement row) {
		return row.findElement(By.id("trainee-actions-remove-button"));
	}
	// *********************************************************************************

	public WebElement showTraineesButtonForRow(WebElement row) {
		return row
			.findElement(By.id("manage-batch-actions-show-trainees-button"));
	}

	public WebElement submitImportBatchButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("import-batch-dialog-import-button")));
	}
	// ***********************************************************************************************************************

	public WebElement switchBatchButtonForRow(WebElement row) {
		return row.findElement(By.id("trainee-actions-switch-button"));
	}

	public WebElement toggleActiveTraineesButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("view-trainees-modal-show-trainees-toggle-button")));
	}
}
