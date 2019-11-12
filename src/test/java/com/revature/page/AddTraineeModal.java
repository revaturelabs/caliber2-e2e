package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTraineeModal {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 3);

	public AddTraineeModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement inputFirstName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	}
	
	public WebElement inputLastName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	}
	
	public WebElement inputEmail() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	}
	
	public WebElement inputPhoneNumber() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneNumber")));
	}
	
	public WebElement inputSkypeId() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("skypeId")));
	}
	
	public WebElement inputDegree() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("degree")));
	}
	
	public WebElement inputRecruiterName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recruiterName")));
	}
	
	public WebElement inputTechScreener() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("techScreener")));
	}
	
	public WebElement trainingStatusDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trainingStatus")));
	}
	
	public WebElement trainingStatusDropdownNthOption(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='trainingStatus]//option["+n+"]")));
	}
	
	public WebElement trainingStatusDropdownOptionByName(String option) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='trainingStatus]//option[@value='"+option+"']")));
	}
	
	public WebElement inputCollege() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("college")));
	}
	
	public WebElement inputMajor() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("major")));
	}
	
	public WebElement inputProfileURL() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileUrl")));
	}
	
	public WebElement inputProjectCompletion() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("projectCompletion")));
	}
	
	public WebElement cancelAddTrainerButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trainee-modal-cancel-button")));
	}
	
	public WebElement submitAddTrainerButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trainee-modal-create-button")));
	}
}
