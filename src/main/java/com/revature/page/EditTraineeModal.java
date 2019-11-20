package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditTraineeModal {

	WebDriver driver;
	WebDriverWait wait;

	public EditTraineeModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement cancelUpdateTrainerButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainee-modal-cancel-button")));
	}

	public WebElement inputCollege() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("college")));
	}

	public WebElement inputDegree() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("degree")));
	}

	public WebElement inputEmail() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	}

	public WebElement inputFirstName() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	}

	public WebElement inputLastName() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	}

	public WebElement inputMajor() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("major")));
	}

	public WebElement inputPhoneNumber() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("phoneNumber")));
	}

	public WebElement inputProfileURL() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("profileUrl")));
	}

	public WebElement inputProjectCompletion() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("projectCompletion")));
	}

	public WebElement inputRecruiterName() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("recruiterName")));
	}

	public WebElement inputSkypeId() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("skypeId")));
	}

	public WebElement inputTechScreener() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("techScreener")));
	}

	public WebElement submitUpdateTrainerButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainee-modal-update-button")));
	}

	public WebElement trainingStatusDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainingStatus")));
	}

	public WebElement trainingStatusDropdownNthOption(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='trainingStatus]//option[" + n + "]")));
	}

	public WebElement trainingStatusDropdownOptionByName(String option) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='trainingStatus]//option[@value='" + option
				+ "']")));
	}
}
