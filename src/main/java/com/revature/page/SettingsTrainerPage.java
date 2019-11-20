package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SettingsTrainerPage {

	WebDriver driver;
	WebDriverWait wait;

	public SettingsTrainerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}

	public WebElement addTrainerButton() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("addTrainerButton")));
	};

	public WebElement trainerTier() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainerTier")));
	};

	public WebElement getTableRow(int rowNumber) {
		return driver.findElement(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]"));
	}

	public WebElement getTableBody() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody")));
	}

	public WebElement getTableCell(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public int getTableRowsCount() {
		WebElement table =
			driver.findElement(By.id("user-view-trainers-trainer-table"));
		WebElement tablebody = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tablebody.findElements(By.tagName("tr"));
		return rows.size();
	}

	public WebElement getTableRowName(int rowNumber) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[1]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[1]"));
	}

	public WebElement getTableRowTitle(int rowNumber) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[2]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[2]"));
	}

	public WebElement getTableRowEmail(int rowNumber) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[3]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[3]"));
	}

	public WebElement getTableRowTier(int rowNumber) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[4]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[4]"));
	}

	public WebElement editTrainerButton(String name) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("user-view-trainers-displaytrainermodal-" + name + "")));
		// return
		// driver.findElement(By.id("user-view-trainers-displaytrainermodal-"+
		// name + ""));
	}

	public WebElement inactiveTrainerButton(String name) {
		System.out.println(name);
		System.out.println(
			"user-view-trainers-disabledisplaytrainermodal-" + name + "");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.id("user-view-trainers-disabledisplaytrainermodal-" + name + "")));
		// return
		// driver.findElement(By.id("user-view-trainers-disabledisplaytrainermodal-"
		// + name + ""));
	}

	// Add Trainer Modal******************************************

	public WebElement inputTrainerName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath("//div[@id='addTrainerModal']//input[@id='trainerName']")));
	}

	public WebElement inputTrainerEmail() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath("//div[@id='addTrainerModal']//input[@id='trainerEmail']")));
	}

	public WebElement inputTrainerTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[@id='addTrainerModal']//input[@id='title']")));
	}

	public WebElement trainerTierDropdown() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id=\"trainerTier\"]")));
	}

	public void selectTrainerTierByName(String tier) {
		Select selectTrainer = new Select(
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByVisibleText(tier);
	}

	public void selectTrainerTier(int n) {
		Select selectTrainer = new Select(
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByIndex(n);
	}

	public WebElement submitAddTrainer() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			"//div[@id='addTrainerModal']//button[@id='updateButton1']")));
	}

	public WebElement closeAddTrainer() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addTrainerModal']//button[@id='closeButton1']")));
	}
	// ******************************************************************************************************************************************

	// Edit Trainer
	// Modal***********************************************************************************************************************
	public WebElement inputEditTrainerName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath("//div[@id='editTrainerModal']//input[@id='trainerName']")));
	}

	public WebElement inputEditTrainerEmail() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//input[@id='trainerEmail']")));
	}

	public WebElement inputEditTrainerTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[@id='editTrainerModal']//input[@id='title']")));
	}

	public WebElement trainerEditTierDropdown() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//select[@id='trainerTier']")));
	}

	public void selectEditTrainerTierByName(String tier) {
		Select selectTrainer = new Select(
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByVisibleText(tier);
	}

	public void selectEditTrainerTier(int n) {
		Select selectTrainer = new Select(
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByIndex(n);
	}

	public WebElement submitEditTrainer() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//button[@id='updateButton1']")));
	}

	public WebElement closeEditTrainer() {
		return wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//button[@id='closeButton1']")));
	}

	// ******************************************************************************************************************************************

	// DISABLE TRAINER
	// MODAL*********************************************************************************************************************
	public WebElement yesDisableTrainerButton() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("yesButton1")));
	}

	public WebElement noDisableTrainerButton() {
		return wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("noButton1")));
	}

}
