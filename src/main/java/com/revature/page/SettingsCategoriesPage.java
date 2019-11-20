package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SettingsCategoriesPage {
	WebDriver driver;
	WebDriverWait wait;

	public SettingsCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 3);
	}

	public WebElement addCategoryButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-categories-addassessmentcategory")));

	}

	public WebElement addCategoryCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("add-assess-cat-modal-closecategory")));
	}

	public WebElement editCategoryButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("assessment-categories-editassessmentcategory")));

	}

	public WebElement editCategoryCloseButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-close")));
	}

	public WebElement editCategorySaveButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("edit-assess-cat-modal-component-save")));
	}

	public String getFirstActiveCategoryName() {
		WebElement category = this.driver
			.findElement(By.xpath("//span[@id='active-category'][1]"));
		return category.getAttribute("innerHTML").trim();

	}

	public String getFirstStaleCategoryName() {
		WebElement category = this.driver
			.findElement(By.xpath("//span[@id='stale-category'][1]"));
		return category.getAttribute("innerHTML").trim();
	}

	// Edit Assessment Category
	// Modal*********************************************************

	public WebElement getSelectCategoryDropdown() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='selectedCategory']")));

	}

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

	public List<WebElement> selectActiveCategories() {
		return this.driver
			.findElements(By.xpath("//span[@id='active-category']"));
	}

	public WebElement selectCategoryByName(String name) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//div[@id='category-" + name + "']/span")));
	}

	public void selectCategoryOptionByName(String name) {
		Select selectCategory = new Select(this.getSelectCategoryDropdown());
		selectCategory.selectByVisibleText(name);
	}

	public WebElement selectNthCategoryOption(int n) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//select[@id='selectedCategory]//option[" + n + "]")));
	}

	public List<WebElement> selectStaleCategories() {

		return this.driver
			.findElements(By.xpath("//span[@id='stale-category']"));
	}

	public WebElement submitCategoryButton() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.id("add-assess-cat-modal-addcategory")));
	}

}
