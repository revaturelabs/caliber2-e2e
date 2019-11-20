package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsCategoriesPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "assessment-categories-editassessmentcategory")
	public WebElement editCategoryButton;

	@FindBy(id = "assessment-categories-addassessmentcategory")
	public WebElement addCategoryButton;

	public SettingsCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement addCategoryCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("add-assess-cat-modal-closecategory")));
	}
	// *****************************************************************************************

	public WebElement editCategoryCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-close")));
	}
	// *****************************************************************************************

	// Edit Assessment Category
	// Modal*********************************************************

	public WebElement editCategorySaveButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-save")));
	}

	// Add Assessment Category
	// Modal************************************************************
	public WebElement inputCategoryNameAddCategories() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("category.skillCategory")));
	}

	public WebElement inputCategoryNameEditCategories() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("skillCategory")));
	}

	public WebElement inputCategoryOwner() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("categoryOwner")));
	}

	public WebElement selectCategoryDropdown() {
		return this.wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("selectedCategory")));

	}

	public WebElement selectCategoryOptionByName(String name) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-skillcategoryoption-"
				+ name)));
	}

	public WebElement selectNthActiveCategory(int n) {
		return this.driver
			.findElement(By.xpath("//span[@id='active-category'][" + n + "]"));
	}

	public WebElement selectNthCategoryOption(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='selectedCategory]//option[" + n + "]")));
	}

	public WebElement selectNthStaleCategory(int n) {
		return this.driver
			.findElement(By.xpath("//span[@id='stale-category'][" + n + "]"));
	}

	public WebElement submitCategoryButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("add-assess-cat-modal-addcategory")));
	}

}
