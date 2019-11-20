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

	public SettingsCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}

	public WebElement selectNthActiveCategory(int n) {
		return driver
			.findElement(By.xpath("//span[@id='active-category'][" + n + "]"));
	}

	public WebElement selectNthStaleCategory(int n) {
		return driver
			.findElement(By.xpath("//span[@id='stale-category'][" + n + "]"));
	}

	@FindBy(id = "assessment-categories-editassessmentcategory")
	public WebElement editCategoryButton;

	@FindBy(id = "assessment-categories-addassessmentcategory")
	public WebElement addCategoryButton;

	// Edit Assessment Category
	// Modal*********************************************************

	public WebElement selectCategoryDropdown() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("selectedCategory")));

	}

	public WebElement selectCategoryOptionByName(String name) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
			"edit-assess-cat-modal-component-skillcategoryoption-" + name)));
	}

	public WebElement selectNthCategoryOption(int n) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='selectedCategory]//option[" + n + "]")));
	}

	public WebElement inputCategoryNameEditCategories() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("skillCategory")));
	}

	public WebElement inputCategoryOwner() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("categoryOwner")));
	}

	public WebElement editCategorySaveButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-save")));
	}

	public WebElement editCategoryCloseButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-close")));
	}
	// *****************************************************************************************

	// Add Assessment Category
	// Modal************************************************************
	public WebElement inputCategoryNameAddCategories() {
		return wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.id("category.skillCategory")));
	}

	public WebElement submitCategoryButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("add-assess-cat-modal-addcategory")));
	}

	public WebElement addCategoryCloseButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("add-assess-cat-modal-closecategory")));
	}
	// *****************************************************************************************

}
