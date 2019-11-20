package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBatchModal {

	WebDriver driver;
	WebDriverWait wait;

	public CreateBatchModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement cancelNewBatchButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("batch-modal-cancel-button")));
	}

	public WebElement inputEndDate() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("endDate")));
	}

	public WebElement inputGoodGrade() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("goodGrade")));
	}

	public WebElement inputPassingGrade() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("passingGrade")));
	}

	public WebElement inputStartDate() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("startDate")));
	}

	public WebElement inputTrainingName() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainingName")));
	}

	public WebElement selectCoTrainerDropdown() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("coTrainer")));
	}

	public WebElement selectCoTrainerDropdownByInt(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='coTrainer']//option[" + n + "]")));
	}

	public WebElement selectCoTrainerDropdownByName(String option) {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//select[@id='coTrainer']//option[@value='" + option + "']")));
	}

	public WebElement selectLocationDropdown() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("location")));
	}

	public WebElement selectLocationDropdownByInt(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='location']//option[" + n + "]"))); // *[@id="location"]/option[]
	}

	public WebElement selectTrainingTypeDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainingType")));
	}

	public WebElement selectTrainingTypeDropdownOptionByInt(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='trainingType']//option[" + n + "]")));
	}

	public WebElement skillTypeDropdownBox() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("skillType")));
	}

	// the n'th dropdown item
	public WebElement skillTypeDropdownBoxOptionByInt(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='skillType']//option[" + n + "]")));
	}

	public WebElement skillTypeDropdownBoxOptionByName(String option) {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//select[@id='skillType']//option[@value='" + option + "']")));
	}

	public WebElement submitNewBatchButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("batch-modal-create-button")));
	}

	public WebElement trainerDropdownBox() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("trainer")));
	}

	public WebElement trainerDropdownBoxOptionByInt(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='trainer']//option[" + n + "]")));
	}

	public WebElement trainerDropdownBoxOptionByName(String option) {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//select[@id='trainer']//option[@value='" + option + "']")));
	}

}
