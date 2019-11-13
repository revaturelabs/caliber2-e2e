package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBatchModal {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 3);

	public CreateBatchModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement inputTrainingName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trainingName")));
	}
	
	public WebElement skillTypeDropdownBox() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("skillType")));
	}
	public WebElement skillTypeDropdownBoxOptionByName(String option) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='skillType']//option[@value='"+option+"']")));
	}
	
	//the n'th dropdown item
	public WebElement skillTypeDropdownBoxOptionByInt(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='skillType']//option["+n+"]")));
	}
	
	public WebElement trainerDropdownBox() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trainer")));
	}
	
	public WebElement trainerDropdownBoxOptionByName(String option) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='trainer']//option[@value='"+option+"']")));
	}
	
	public WebElement trainerDropdownBoxOptionByInt(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='trainer']//option["+n+"]")));
	}

	public WebElement inputStartDate() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startDate")));
	}
	
	public WebElement inputGoodGrade() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goodGrade")));
	}
	
	public WebElement selectTrainingTypeDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trainingType")));
	}
	
	public WebElement selectTrainingTypeDropdownOptionByInt(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='trainingType']//option["+n+"]")));
	}
	
	public WebElement selectLocationDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location")));
	}
	
	public WebElement selectLocationDropdownByInt(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='location']//option["+n+"]")));
	}
	
	public WebElement selectCoTrainerDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coTrainer")));
	}
	
	public WebElement selectCoTrainerDropdownByName(String option) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='coTrainer']//option[@value='"+option+"']")));
	}
	
	public WebElement selectCoTrainerDropdownByInt(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='coTrainer']//option["+n+"]")));
	}
	
	public WebElement inputEndDate() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("endDate")));
	}
	
	public WebElement inputPassingGrade() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passingGrade")));
	}
	
	public WebElement cancelNewBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-modal-cancel-button")));
	}
	
	public WebElement submitNewBatchButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batch-modal-create-button")));
	}

}
