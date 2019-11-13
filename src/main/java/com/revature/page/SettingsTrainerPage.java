package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsTrainerPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public SettingsTrainerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}
	
	
	@FindBy(id="addTrainerButton")
	public WebElement addTrainerButton;
	
	public WebElement getTableRow(int rowNumber) {
		return driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tr["+rowNumber+"]"));
	}
	public WebElement getTableCell(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td["+columnNumber+"]"));
	}
	
	
	//Add Trainer Modal******************************************
	
	public WebElement inputTrainerName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='trainerName']")));
	}
	
	public WebElement inputTrainerEmail() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='trainerEmail']")));
	}
	
	public WebElement inputTrainerTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='title']")));
	}
	
	public WebElement trainerTierDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='trainerTier']")));
	}
	
	public void selectTrainerTierByName(String tier) {
		Select selectTrainer = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='trainerTier']"))));
		selectTrainer.selectByVisibleText(tier);	
		}
	
	public void selectTrainerTier(int n) {
		Select selectTrainer = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='trainerTier']"))));
		selectTrainer.selectByIndex(n);
	}
	
	public WebElement submitAddTrainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='updateButton1']")));
	}
	
	public WebElement closeAddTrainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addTrainerModal']//input[@id='closeButton1']")));
	}
	//******************************************************************************************************************************************
	
	
	//Edit Trainer Modal***********************************************************************************************************************
	public WebElement inputEditTrainerName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='trainerName']")));
	}
	
	public WebElement inputEditTrainerEmail() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='trainerEmail']")));
	}
	
	public WebElement inputEditTrainerTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='title']")));
	}
	
	public WebElement trainerEditTierDropdown() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='trainerTier']")));
	}
	
	public void selectEditTrainerTierByName(String tier) {
		Select selectTrainer = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='trainerTier']"))));
		selectTrainer.selectByVisibleText(tier);	
		}
	
	public void selectEditTrainerTier(int n) {
		Select selectTrainer = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='trainerTier']"))));
		selectTrainer.selectByIndex(n);
	}
	
	public WebElement submitEditTrainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='updateButton1']")));
	}
	
	public WebElement closeEditTrainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='editTrainerModal']//input[@id='closeButton1']")));
	}
	
	//******************************************************************************************************************************************
	
	
	//DISABLE TRAINER MODAL*********************************************************************************************************************
	public WebElement yesDisableTrainerButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yesButton1")));
	}
	
	public WebElement noDisableTrainerButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noButton1")));
	}
	
}
