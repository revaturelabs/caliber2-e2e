package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AssessBatchPage {

	WebDriver driver;
	WebDriverWait wait;

	public AssessBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement getAddWeekButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("shared-week-selector-addweek")));
	}

	/**
	 * @param index from 1
	 */
	public WebElement getAssessmentPercent(int index) {
		List<WebElement> l = this.driver
			.findElements(By.tagName("app-assessment-details-column"));
		return l.get(index).findElement(By.id("assessment-details-score-text"));
	}

	// Table Header
	/**
	 * @param index from 1
	 */
	public WebElement getAssessmentType(int index) {
		List<WebElement> l = this.driver
			.findElements(By.tagName("app-assessment-details-column"));
		return l.get(index)
			.findElement(By.id("assessment-details-assessment-type-text"));
	}

	public WebElement getAssociateCommentInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("comment")));
	}

	// Table Footer
	/**
	 * @param index from 1
	 */
	public WebElement getAverage(int index) {
		return this.driver.findElement(By.tagName("tfoot"))
			.findElement(By.xpath("//td[" + index + "]"));
	}

	public WebElement getBatchDropdownContainer() {
		return this.getBatchesDropdown()
			.findElement(By.id("batch-select-dropdown-list"));
	}

	// Batch #
	public WebElement getBatchesDropdown() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("batch-select-toolbar-batches-dropdown")))
			.findElement(By.tagName("a"));
	}

	public WebElement getBatchSearchBar() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("batch-select-search-bar")));
	}

	public WebElement getCancelCommentButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("associate-flag-dialog-cancel-button")));
	}

	public WebElement getCategoriesUpdateDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("updatedCategory")));
	}

	public WebElement getCreateAssessmentButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assess-batch-v2-createassessment")));
	}

	public WebElement getCreateAssessmentCancelButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-cancel-button")));
	}

	// Create New Assessment Window
	public WebElement getCreateAssessmentCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-close-button")));
	}

	public WebElement getCreateAssessmentCreateButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-create-button")));
	}

	public WebElement getCreateAssessmentTypeDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("selectAssessmentType")));
	}

	public WebElement getCreateCategoriesDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("selectCategory")));
	}

	public WebElement getCreateCommentButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("associate-flag-dialog-update-create-button")));
	}

	public WebElement getCreateMaxPointsInput() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("maxPoints")));
	}

	public WebElement getDeleteCommentButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("associate-flag-dialog-delete-comment-button")));
	}

	public WebElement getGreenFlag() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("associate-flag-dialog-flag")))
			.findElement(By.className("green-flag"));
	}

	public WebElement getImportGradesButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assess-batch-v2-import-grades")));
	}

	public WebElement getImportGradesCancelButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("shared-import-grades-dialogue-cancel")));
	}

	// Import Grades Window
	public WebElement getImportGradesCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("shared-import-grades-dialogue-closemodal")));
	}

	public WebElement getImportGradesImportButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("shared-import-grades-dialogue-import")));
	}

	public WebElement getImportGradesInput() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("gradeJsonObj")));
	}

	// Add Week Window
	public WebElement getNewWeekCloseButton() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("addNewWeek")));
	}

	public WebElement getNewWeekNoButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("assessDeclineWeek")));
	}

	public WebElement getNewWeekYesButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("assessAcceptWeek")));
	}

	// Overall Feedback
	public WebElement getOverallFeedbackInput() {
		return this.driver.findElement(By.id("notes-container"))
			.findElement(By.tagName("textarea"));
	}

	// Quarter
	public WebElement getQuarterDropdown() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("batch-select-toolbar-quarters-dropdown")))
			.findElement(By.tagName("a"));
	}

	public WebElement getQuarterDropdownContainer() {
		return this.getQuarterDropdown()
			.findElement(By.id("shared-dropdown-menu-dropdown-container"));
	}

	// Update Comment Window
	public WebElement getRedFlag() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("associate-flag-dialog-flag")))
			.findElement(By.className("red-flag"));
	}

	public WebElement getSaveButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("batch-level-feedback-save-button")));
	}

	public WebElement getSelectedBatch() {
		return this.getBatchesDropdown()
			.findElement(By.id("shared-dropdown-menu-current-value"));
	}

	public WebElement getSelectedFlag() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("associate-flag-dialog-selected-flag")))
			.findElement(By.tagName("app-flag"));
	}

	public WebElement getSelectedQuarter() {
		return this.getQuarterDropdown()
			.findElement(By.id("shared-dropdown-menu-current-value"));
	}

	public WebElement getSelectedYear() {
		return this.getYearDropdown()
			.findElement(By.id("shared-dropdown-menu-current-value"));
	}

	/**
	 * @param index from 1
	 */
	public WebElement getTrainerCommentContainer(int index) {
		return this.getTrainerContainer(index)
			.findElement(By.tagName("app-associate-notes"))
			.findElement(By.tagName("text-area"));
	}

	// Trainer comment
	public WebElement getTrainerCommentContainer(String trainerName) {
		return this.getTrainerContainer(trainerName)
			.findElement(By.tagName("app-associate-notes"))
			.findElement(By.tagName("text-area"));
	}

	/**
	 * @param index from 1
	 */
	public WebElement getTrainerContainer(int index) {
		int i = 0;
		for (WebElement element : this.getTrainersContainer()
			.findElements(By.tagName("app-associate-details"))) {
			if (index == i) {
				return element;
			}
			i++;
		}
		return null;
	}

	public WebElement getTrainerContainer(String trainerName) {
		for (WebElement element : this.getTrainersContainer()
			.findElements(By.tagName("app-associate-details"))) {
			if (element.getText().contains(trainerName)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @param index from 1
	 */
	public WebElement getTrainerEditButton(int index) {
		return this.getTrainerContainer(index)
			.findElement(By.id("associate-details-container"))
			.findElement(By.id("associate-details-container-pen"));
	}

	/**
	 * @param index from 1
	 */
	public WebElement getTrainerFlagButton(int index) {
		return this.getTrainerContainer(index)
			.findElement(By.id("associate-details-container"))
			.findElement(By.id("associate-details-container-flag"));
	}

	/**
	 * @param index from 1
	 */
	public WebElement getTrainerName(int index) {
		return this.getTrainerContainer(index)
			.findElement(By.id("associate-details-container"))
			.findElement(By.id("associate-details-trainee-name"));
	}

	// Trainers
	public WebElement getTrainersContainer() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("assess-associate-list-table")));
	}

	/**
	 * @param index from 1
	 */
	public WebElement getUpdateAssessmentButton(int index) {
		return this.driver
			.findElements(By.tagName("app-assessment-details-column"))
			.get(index);
	}

	public WebElement getUpdateAssessmentCancelButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-cancel-button")));
	}

	// Update Assessment Window
	public WebElement getUpdateAssessmentCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-close-button")));
	}

	public WebElement getUpdateAssessmentCreateButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-create-button")));
	}

	public WebElement getUpdateAssessmentDeleteButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-dialog-delete-button")));
	}

	public WebElement getUpdateAssessmentTypeDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("updateAssessmentType")));
	}

	public WebElement getUpdateMaxPointsInput() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("updatedMaxPoints")));
	}

	public WebElement getWeeklyAverage() {
		List<WebElement> l = this.driver.findElement(By.tagName("tfoot"))
			.findElements(By.tagName("td"));
		return l.get(l.size() - 1);
	}

	// Weeks
	public WebElement getWeeksContainer() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.tagName("app-week-selector")));
	}

	// Year
	public WebElement getYearDropdown() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("batch-select-toolbar-years-dropdown")))
			.findElement(By.tagName("a"));
	}

	public WebElement getYearDropdownContainer() {
		return this.getYearDropdown()
			.findElement(By.id("shared-dropdown-menu-dropdown-container"));
	}

	public void selectBatch(String batch) {
		WebElement container = this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("batch-select-dropdown-list")));

		for (WebElement element : container.findElements(By.tagName("a"))) {

			if (element.getText().contains(batch)) {
				element.click();
				return;
			}
		}
	}

	/**
	 * @param index from 1
	 */
	public void selectCreateAssessmentType(int index) {
		Select select = new Select(this.getCreateAssessmentTypeDropdown());
		select.selectByIndex(index);
	}

	public void selectCreateAssessmentType(String assessmentType) {
		Select select = new Select(this.getCreateAssessmentTypeDropdown());
		select.selectByValue(assessmentType);
	}

	/**
	 * @param index from 1
	 */
	public void selectCreateCategory(int index) {
		Select select = new Select(this.getCreateCategoriesDropdown());
		select.selectByIndex(index);
	}

	public void selectCreateCategory(String category) {
		Select select = new Select(this.getCreateCategoriesDropdown());
		select.selectByVisibleText(category);
	}

	public void selectQuarter(String quarter) {
		WebElement container =
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("shared-dropdown-menu-" + quarter + "")));
		container.click();
		// for (WebElement element : container.findElements(By.tagName("a"))) {
		// if (element.getText().contains(quarter)) {
		// element.click();
		// return;
		// }
		// }
	}

	/**
	 * @param index from 1
	 */
	public void selectUpdateAssessmentType(int index) {
		Select select = new Select(this.getUpdateAssessmentTypeDropdown());
		select.selectByIndex(index);
	}

	public void selectUpdateAssessmentType(String assessmentType) {
		Select select = new Select(this.getUpdateAssessmentTypeDropdown());
		select.selectByValue(assessmentType);
	}

	/**
	 * @param index from 1
	 */
	public void selectUpdateCategory(int index) {
		Select select = new Select(this.getCategoriesUpdateDropdown());
		select.selectByIndex(index);
	}

	public void selectUpdateCategory(String category) {
		Select select = new Select(this.getCategoriesUpdateDropdown());
		select.selectByVisibleText(category);
	}

	public void selectWeek(int week) {
		for (WebElement element : this.getWeeksContainer()
			.findElements(By.tagName("a"))) {
			if (element.getText().endsWith(Integer.toString(week))) {
				element.click();
			}
		}
	}

	public void selectYear(String year) {
		WebElement container =
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("shared-dropdown-menu-dropdown-container")));

		for (WebElement element : container.findElements(By.tagName("a"))) {
			if (element.getText().contains(year)) {
				element.click();
				return;
			}
		}
	}
}
