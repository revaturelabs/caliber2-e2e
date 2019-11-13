package com.revature.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessBatchPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AssessBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}
	
	// Year
	public WebElement getYearDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-select-toolbar-years-dropdown"))).findElement(By.tagName("a"));
	}

	public WebElement getSelectedYear() {
		return getYearDropdown().findElement(By.id("shared-dropdown-menu-current-value"));
	}
	
	public WebElement getYearDropdownContainer() {
		return getYearDropdown().findElement(By.id("shared-dropdown-menu-dropdown-container"));
	}
	
	public void selectYear(String year) {
		WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shared-dropdown-menu-dropdown-container")));
		
		for (WebElement element : container.findElements(By.tagName("a"))) {
			if (element.getText().contains(year)) {
				element.click();
				return;
			}
		}
	}
	
	// Quarter
	public WebElement getQuarterDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-select-toolbar-quaters-dropdown"))).findElement(By.tagName("a"));
	}
	
	public WebElement getSelectedQuarter() {
		return getQuarterDropdown().findElement(By.id("shared-dropdown-menu-current-value"));
	}
	
	public WebElement getQuarterDropdownContainer() {
		return getQuarterDropdown().findElement(By.id("shared-dropdown-menu-dropdown-container"));
	}
	
	public void selectQuarter(String quarter) {
		WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shared-dropdown-menu-dropdown-container")));
		
		for (WebElement element : container.findElements(By.tagName("a"))) {
			if (element.getText().contains(quarter)) {
				element.click();
				return;
			}
		}
	}
	
	// Batch #
	public WebElement getBatchesDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-select-toolbar-batches-dropdown"))).findElement(By.tagName("a"));
	}
	
	public WebElement getSelectedBatch() {
		return getBatchesDropdown().findElement(By.id("shared-dropdown-menu-current-value"));
	}
	public WebElement getBatchDropdownContainer() {
		return getBatchesDropdown().findElement(By.id("batch-select-dropdown-list"));
	}
	
	public void selectBatch(String batch) {
		WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-select-dropdown-list")));
		
		for (WebElement element : container.findElements(By.tagName("a"))) {
			if (element.getText().contains(batch)) {
				element.click();
				return;
			}
		}
	}
	
	public WebElement getBatchSearchBar() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-select-search-bar")));
	}
	
	public WebElement getCreateAssessmentButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assess-batch-v2-createassessment")));
	}
	
	public WebElement getImportGradesButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assess-batch-v2-import-grades")));
	}
	
	// Create New Assessment Window
	public WebElement getCreateAssessmentCloseButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-close-button")));
	}
	
	public WebElement getCreateCategoriesDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectCategory")));
	}
	
	public void selectCreateCategory(String category) {
		Select select = new Select(getCreateCategoriesDropdown());
		select.selectByVisibleText(category);
	}
	
	/**
	 * @param index from 1
	 */
	public void selectCreateCategory(int index) {
		Select select = new Select(getCreateCategoriesDropdown());
		select.selectByIndex(index);
	}
	
	public WebElement getCreateMaxPointsInput() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maxPoints")));
	}
	
	public WebElement getCreateAssessmentTypeDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectAssessmentType")));
	}
	
	public void selectCreateAssessmentType(String assessmentType) {
		Select select = new Select(getCreateAssessmentTypeDropdown());
		select.selectByValue(assessmentType);
	}
	
	/**
	 * @param index from 1
	 */
	public void selectCreateAssessmentType(int index) {
		Select select = new Select(getCreateAssessmentTypeDropdown());
		select.selectByIndex(index);
	}
	
	public WebElement getCreateAssessmentCancelButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-cancel-button")));
	}
	
	public WebElement getCreateAssessmentCreateButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-create-button")));
	}
	
	// Import Grades Window
	public WebElement getImportGradesCloseButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shared-import-grades-dialogue-closemodal")));
	}
	
	public WebElement getImportGradesInput() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gradeJsonObj")));
	}
	
	public WebElement getImportGradesCancelButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shared-import-grades-dialogue-cancel")));
	}
	
	public WebElement getImportGradesImportButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shared-import-grades-dialogue-import")));
	}
	
	// Weeks
	public WebElement getWeeksContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-week-selector")));
	}
	
	public void selectWeek(int week) {
		for (WebElement element : getWeeksContainer().findElements(By.tagName("a"))) {
			if(element.getText().endsWith(Integer.toString(week))) {
				element.click();
			}
		}
	}
	
	public WebElement getAddWeekButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("shared-week-selector-addweek")));
	}
	
	// Add Week Window
	public WebElement getNewWeekCloseButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addNewWeek")));
	}
	
	public WebElement getNewWeekYesButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessAcceptWeek")));
	}
	
	public WebElement getNewWeekNoButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessDeclineWeek")));
	}
	
	// Trainers
	public WebElement getTrainersContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assess-associate-list-table")));
	}
	
	public WebElement getTrainerContainer(String trainerName) {
		for (WebElement element : getTrainersContainer().findElements(By.tagName("app-associate-details"))) {
			if (element.getText().contains(trainerName)) {
				return element;
			}
		}
		return null;
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getTrainerContainer(int index) {
		int i = 0;
		for (WebElement element : getTrainersContainer().findElements(By.tagName("app-associate-details"))) {
			if (index == i) {
				return element;
			}
			i++;
		}
		return null;
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getTrainerName (int index) {
		return getTrainerContainer(index).findElement(By.id("associate-details-container")).findElement(By.id("associate-details-trainee-name"));
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getTrainerEditButton (int index) {
		return getTrainerContainer(index).findElement(By.id("associate-details-container")).findElement(By.id("associate-details-container-pen"));
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getTrainerFlagButton (int index) {
		return getTrainerContainer(index).findElement(By.id("associate-details-container")).findElement(By.id("associate-details-container-flag"));
	}
	
	// Update Comment Window
	public WebElement getRedFlag() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-flag"))).findElement(By.className("red-flag"));
	}
	
	public WebElement getGreenFlag() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-flag"))).findElement(By.className("green-flag"));
	}
		
	public WebElement getAssociateCommentInput() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment"))); 
	}
	
	public WebElement getSelectedFlag() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-selected-flag"))).findElement(By.tagName("app-flag"));
	}
	
	public WebElement getDeleteCommentButton () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-delete-comment-button")));
	}
	
	public WebElement getCancelCommentButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-cancel-button")));
	}
	
	public WebElement getCreateCommentButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("associate-flag-dialog-update-create-button")));
	}
	
	// Trainer comment
	public WebElement getTrainerCommentContainer(String trainerName) {
		return getTrainerContainer(trainerName).findElement(By.tagName("app-associate-notes")).findElement(By.tagName("text-area"));
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getTrainerCommentContainer(int index) {
		return getTrainerContainer(index).findElement(By.tagName("app-associate-notes")).findElement(By.tagName("text-area"));
	}
	
	// Table Header
	/**
	 * @param index from 1
	 */
	public WebElement getAssessmentType(int index) {
		List<WebElement> l = driver.findElements(By.tagName("app-assessment-details-column"));
		return l.get(index).findElement(By.id("assessment-details-assessment-type-text"));
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getAssessmentPercent(int index) {
		List<WebElement> l = driver.findElements(By.tagName("app-assessment-details-column"));
		return l.get(index).findElement(By.id("assessment-details-score-text"));
	}
	
	/**
	 * @param index from 1
	 */
	public WebElement getUpdateAssessmentButton(int index) {
		return driver.findElements(By.tagName("app-assessment-details-column")).get(index);
	}
	
	// Update Assessment Window
	public WebElement getUpdateAssessmentCloseButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-close-button")));
	}
	
	public WebElement getCategoriesUpdateDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updatedCategory")));
	}
	
	public void selectUpdateCategory(String category) {
		Select select = new Select(getCategoriesUpdateDropdown());
		select.selectByVisibleText(category);
	}
	
	/**
	 * @param index from 1
	 */
	public void selectUpdateCategory(int index) {
		Select select = new Select(getCategoriesUpdateDropdown());
		select.selectByIndex(index);
	}
	
	public WebElement getUpdateMaxPointsInput() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updatedMaxPoints")));
	}
	
	public WebElement getUpdateAssessmentTypeDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updateAssessmentType")));
	}
	
	public void selectUpdateAssessmentType(String assessmentType) {
		Select select = new Select(getUpdateAssessmentTypeDropdown());
		select.selectByValue(assessmentType);
	}
	
	/**
	 * @param index from 1
	 */
	public void selectUpdateAssessmentType(int index) {
		Select select = new Select(getUpdateAssessmentTypeDropdown());
		select.selectByIndex(index);
	}
	
	public WebElement getUpdateAssessmentDeleteButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-delete-button")));
	}
	
	public WebElement getUpdateAssessmentCancelButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-cancel-button")));
	}
	
	public WebElement getUpdateAssessmentCreateButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assessment-dialog-create-button")));
	}
	
	// Table Footer
	/**
	 * @param index from 1
	 */
	public WebElement getAverage(int index) {
		return driver.findElement(By.tagName("tfoot")).findElement(By.xpath("//td[" + index + "]"));
	}
	
	public WebElement getWeeklyAverage() {
		List<WebElement> l = driver.findElement(By.tagName("tfoot")).findElements(By.tagName("td"));
		return l.get(l.size() - 1);
	}
	
	// Overall Feedback
	public WebElement getOverallFeedbackInput() {
		return driver.findElement(By.id("notes-container")).findElement(By.tagName("textarea"));
	}
		
	public WebElement getSaveButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-level-feedback-save-button")));
	}
}
