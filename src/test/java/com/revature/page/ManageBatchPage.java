package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//Create Batch Modal, Edit Batch Modal, Add Trainee Modal, and Show Trainees Modal are on separate POMs
public class ManageBatchPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 3);

	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDropdownSelectYearContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-shared-dropdown-menu[@id='manage-batch-year-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}
	
	public WebElement getItemByItemNumber(WebElement dropdownContainer, int dropdownNumber) {
		return dropdownContainer.findElements(By.tagName("a")).get(dropdownNumber);
	}
	
	public WebElement createBatchButton() {
		return driver.findElement(By.id("create-batch-button"));
	}
	
	//FINDING ELEMENTS ON THE TABLE***************************************************
	@FindBy(id="manage-batch-batch-list-data")
	public WebElement manageBatchTable;
	
	public WebElement getManageBatchTableRow(int rowNumber) {
		return manageBatchTable.findElement(By.id("manage-batch-batch-list-"+rowNumber));
	}
	
	public WebElement getManageBatchTableData(WebElement row, int columnNumber) {
		return row.findElement(By.xpath("//span["+columnNumber+"]"));
	}
	
	public WebElement showTraineesButtonForRow(WebElement row) {
		return row.findElement(By.id("manage-batch-actions-show-trainees-button"));
	}
	
	public WebElement editBatchButtonForRow(WebElement row) {
		return row.findElement(By.id("manage-batch-actions-edit-batch-button"));
	}
	
	public WebElement removeBatchButtonForRow(WebElement row) {
		return row.findElement(By.id("manage-batch-actions-remove-batch-button"));
	}
	//*********************************************************************************
		
	//**********************************************************************************************************************
	
	
	//IMPORT BATCH MODAL****************************************************************************************************
	public WebElement importBatchButton() {
		return driver.findElement(By.id("import-batch-button"));
	}
	
	public WebElement inputBatchJSON() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gradeJsonObj")));
	}
	
	public WebElement cancelImportBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("import-batch-dialog-cancel-button")));
	}
	
	public WebElement submitImportBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("import-batch-dialog-import-button")));
	}
	//***********************************************************************************************************************
	
	
	//DELETE BATCH MODAL
	public WebElement cancelDeleteBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete-trainee-modal-cancel-button")));
	}
	
	public WebElement confirmDeleteBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete-trainee-modal-delete-button")));
	}
	//***********************************************************************************************************************
	
}

