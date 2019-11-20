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
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement addTrainerButton() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("addTrainerButton")));
	};

	public WebElement closeAddTrainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addTrainerModal']//button[@id='closeButton1']")));
	}
	// ******************************************************************************************************************************************;

	public WebElement closeEditTrainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//button[@id='closeButton1']")));
	}

	public WebElement editTrainerButton(String name) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("user-view-trainers-displaytrainermodal-" + name + "")));
		// return
		// driver.findElement(By.id("user-view-trainers-displaytrainermodal-"+
		// name + ""));
	}

	public WebElement getTableBody() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody")));
	}

	public WebElement getTableCell(int columnNumber, WebElement row) {
		return row.findElement(By.xpath("//td[" + columnNumber + "]"));
	}

	public WebElement getTableRow(int rowNumber) {
		return this.driver.findElement(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]"));
	}

	public WebElement getTableRowEmail(int rowNumber) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[3]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[3]"));
	}

	public WebElement getTableRowName(int rowNumber) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[1]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[1]"));
	}

	public int getTableRowsCount() {
		WebElement table =
			this.driver.findElement(By.id("user-view-trainers-trainer-table"));
		WebElement tablebody = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tablebody.findElements(By.tagName("tr"));
		return rows.size();
	}

	public WebElement getTableRowTier(int rowNumber) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[4]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[4]"));
	}

	public WebElement getTableRowTitle(int rowNumber) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["
				+ rowNumber + "]/td[2]")));
		// return
		// driver.findElement(By.xpath("//table[@id='user-view-trainers-trainer-table']/tbody/tr["+rowNumber+"]/td[2]"));
	}

	// Add Trainer Modal******************************************

	public WebElement inactiveTrainerButton(String name) {
		System.out.println(name);
		System.out.println(
			"user-view-trainers-disabledisplaytrainermodal-" + name + "");
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.id("user-view-trainers-disabledisplaytrainermodal-" + name + "")));
		// return
		// driver.findElement(By.id("user-view-trainers-disabledisplaytrainermodal-"
		// + name + ""));
	}

	public WebElement inputEditTrainerEmail() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//input[@id='trainerEmail']")));
	}

	// Edit Trainer
	// Modal***********************************************************************************************************************
	public WebElement inputEditTrainerName() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath("//div[@id='editTrainerModal']//input[@id='trainerName']")));
	}

	public WebElement inputEditTrainerTitle() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[@id='editTrainerModal']//input[@id='title']")));
	}

	public WebElement inputTrainerEmail() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath("//div[@id='addTrainerModal']//input[@id='trainerEmail']")));
	}

	public WebElement inputTrainerName() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.xpath("//div[@id='addTrainerModal']//input[@id='trainerName']")));
	}

	public WebElement inputTrainerTitle() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[@id='addTrainerModal']//input[@id='title']")));
	}

	public WebElement noDisableTrainerButton() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("noButton1")));
	}

	public void selectEditTrainerTier(int n) {
		Select selectTrainer = new Select(this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByIndex(n);
	}

	public void selectEditTrainerTierByName(String tier) {
		Select selectTrainer = new Select(this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByVisibleText(tier);
	}

	public void selectTrainerTier(int n) {
		Select selectTrainer = new Select(this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByIndex(n);
	}

	public void selectTrainerTierByName(String tier) {
		Select selectTrainer = new Select(this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='addTrainerModal']//select[@id='trainerTier']"))));
		selectTrainer.selectByVisibleText(tier);
	}

	public WebElement submitAddTrainer() {
		return this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			"//div[@id='addTrainerModal']//button[@id='updateButton1']")));
	}

	public WebElement submitEditTrainer() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//button[@id='updateButton1']")));
	}

	public WebElement trainerEditTierDropdown() {
		return this.wait
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='editTrainerModal']//select[@id='trainerTier']")));
	}

	public WebElement trainerTier() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("trainerTier")));
	}

	// ******************************************************************************************************************************************

	public WebElement trainerTierDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id=\"trainerTier\"]")));
	}

	// DISABLE TRAINER
	// MODAL*********************************************************************************************************************
	public WebElement yesDisableTrainerButton() {
		return this.wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("yesButton1")));
	}

}
