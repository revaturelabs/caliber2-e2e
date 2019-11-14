package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualityAuditPage {

	
	WebDriver driver;
	WebDriverWait wait;

	public QualityAuditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}
	
	@FindBy(id="batch-select-toolbar-years-dropdown")
	public WebElement selectYearsDropdownButton;
	
	public WebElement getDropdownSelectYearsContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-shared-dropdown-menu[@id='batch-select-toolbar-years-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}
	
	public void selectYearsDropdown(int year) {
		for(WebElement elem : this.getDropdownSelectYearsContainer().findElements(By.tagName("li"))) {
			if(Integer.parseInt(elem.getText()) == year) {
				elem.click();
				return;
			}
		}
	}
	
	@FindBy(id="batch-select-toolbar-quarters-dropdown")
	public WebElement selectQuartersDropdownButton;
	
	public WebElement getDropdownSelectQuartersContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-shared-dropdown-menu[@id='batch-select-toolbar-quarters-dropdown']//ul[@id='shared-dropdown-menu-dropdown-container']")));
	}
	
	public void selectQuartersDropdown(int quarter) {
		for(WebElement elem : this.getDropdownSelectQuartersContainer().findElements(By.tagName("li"))) {
			if(Integer.parseInt(elem.getText().split("")[1]) == quarter) {
				elem.click();
				return;
			}
		}
	}
	
	@FindBy(id="batch-select-toolbar-batches-dropdown")
	public WebElement selectBatchesDropdownButton;
	
	public WebElement getBatchesSearchBarInput() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='batch-select-toolbar-batches-dropdown']"
				+ "//input[@id='batch-select-search-bar']")));
	}
	
	public WebElement getDropdownSelectBatchesContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//app-shared-dropdown-menu[@id='batch-select-toolbar-batches-dropdown']"
				+ "//li[@id='batch-select-dropdown-list']")));
	}
	
	
	/**
	 * This method will return the first element matching the search parameter.
	 * @param search
	 */
	public void selectBatchesDropdown(String search) {
		
		for(WebElement elem : this.getDropdownSelectBatchesContainer().findElements(By.tagName("a"))) {
			if(elem.getText().contains(search)) {
				elem.click();
				return;
			}
		}
	}

	
	
	@FindBy(id="categories-this-week-add-category-button")
	public WebElement addCategoryButton;
	
	
	public void selectCategoriesDropdownContainer(String category) {
		for(WebElement elem : wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("categories-this-week-categories-dropdown-container"))).findElements(By.tagName("li"))) {
			if(elem.getText().contains(category)) {
				elem.click();
				return;
			}
		}
	}
	
	public void removeWeeklyCategory(String category) {
		for(WebElement elem : driver.findElement(By.tagName("app-categories-this-week")).findElements(By.tagName("span"))) {
			if(elem.getText().contains(category)) {
				elem.findElement(By.id("categories-this-week-remove-category-button")).click();
				return;
			}
		}
	}
	
	public void selectWeek(int week) {
		
		for(WebElement elem : driver.findElement(By.tagName("app-week-selector")).findElement(By.tagName("ul")).findElements(By.tagName("a"))) {
			if(elem.getText().contains(Integer.toString(week))) {
				elem.click();
				return;
			}
		}
		
	}
	
	
	@FindBy(id="app-week-selector")
	public WebElement weekContainer;
	
	
	public WebElement selectAddWeekButton() {
		
		 return driver.findElement(By.tagName("app-week-selector")).findElement(By.id("shared-week-selector-addweek"));
			
	}
	
	public WebElement getAddWeekModal() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addWeeks")));
	}
	
	public void selectAddWeekModalCloseButton() {
		this.getAddWeekModal().findElement(By.id("addNewWeek")).click();
	}
	
	public void selectAddWeekModalAcceptButton() {
		this.getAddWeekModal().findElement(By.id("assessAcceptWeek")).click();
	}
	
	public void selectAddWeekModalDeclineButton() {
		this.getAddWeekModal().findElement(By.id("assessDeclineWeek")).click();
	}

	
	@FindBy(id="quality-audit-list-table")
	public WebElement qualityAuditListTable;
	
	public WebElement getTraineeRowByName(String name) {
		
		
		for(WebElement elem : driver.findElement(By.id("quality-audit-list-table")).findElements(By.tagName("tr"))) {
			if(elem.findElement(By.id("associate-details-trainee-name")).getText().contains(name)) {
				return elem;
			}
		}
		return null;
	}
	
	public WebElement getTraineeRowByIndex(int index) {
		
		return driver.findElement(By.id("quality-audit-list-table")).findElements(By.tagName("tr")).get(index);
	}
	
	
	public WebElement getAssociateDetailsContainer(WebElement row) {
		return row.findElement(By.id("associate-details-container"));
	}
	
	public WebElement getAssociateDetailsPen(WebElement row) {
		return row.findElement(By.id("associate-details-container-pen"));
	}
	
	public WebElement getAssociateDetailsFlag(WebElement row) {
		return row.findElement(By.id("associate-details-container-flag"));
	}
	
	public WebElement getAssociateTechSkillsButton(WebElement row) {
		return row.findElements(By.id("qc-feedback-dropdown-toggle")).get(0);
	}
	
	public WebElement getAssociateTechSkillsContainer(WebElement row) {
		return wait.until(ExpectedConditions.visibilityOf(this.getAssociateTechSkillsButton(row).findElement(By.id("qc-feedback-dropdown-container"))));
		
	}
	
	public WebElement getAssociateSoftSkillsButton(WebElement row) {
		return row.findElements(By.id("qc-feedback-dropdown-toggle")).get(1);
	}
	
	public WebElement getAssociateSoftSkillsContainer(WebElement row) {
		return wait.until(ExpectedConditions.visibilityOf(this.getAssociateSoftSkillsButton(row).findElement(By.id("qc-feedback-dropdown-container"))));
		
	}
	
	public WebElement getAssociateNotes(WebElement row) {
		return row.findElement(By.tagName("textarea"));
	}
	
	public WebElement getQcFeedbackDropdownButton() {
		return driver.findElement(By.id("qc-feedback-dropdown-toggle"));
	}
	
	public WebElement getQcFeedbackDropdownContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("qc-feedback-dropdown-container")));
	}
	
	public WebElement getOverallQCFeedbackTextArea() {
		return driver.findElement(By.tagName("app-batch-level-feedback")).findElement(By.tagName("textarea"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("batch-level-feedback-save-button"));
	}
	
	// Update Comment Window
		public WebElement getRedFlag() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-flag"))).findElement(By.className("red-flag"));
		}
		
		public WebElement getGreenFlag() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-flag"))).findElement(By.className("green-flag"));
		}
			
		public WebElement getTrainerCommentInput() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment"))); 
		}
		
		public WebElement getSelectedFlag() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-selected-flag"))).findElement(By.tagName("app-flag"));
		}
		
		public WebElement getDeleteCommentButton () {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-delete-comment-button")));
		}
		
		public WebElement getConfirmDeleteButton () {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-delete-confirm-button")));
		}
		
		public WebElement getCancelCommentButton() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-cancel-button")));
		}
		
		public WebElement getCreateCommentButton() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-update-create-button")));
		}
		
//		// Trainer comment
//		public WebElement getTrainerCommentContainer(String trainerName) {
//			return getTrainerContainer(trainerName).findElement(By.tagName("app-associate-notes")).findElement(By.tagName("text-area"));
//		}
	
	
}
