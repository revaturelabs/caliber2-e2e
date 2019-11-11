package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsCategoriesPage {
	
	WebDriver driver;

	public SettingsCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement categoryById(int categoryId) {
		return driver.findElement(By.id("category"+categoryId));
	}
	
	public WebElement cagoryByCategoryName(String name) {
		return driver.findElement(By.id("assessment-categories-select-category-"+name));
	}
	
	@FindBy(id="assessment-categories-editassessmentcategory")
	public WebElement editCategoryButton;
	
	@FindBy(id="assessment-categories-addassessmentcategory")
	public WebElement addCategoryButton;
	
	
	
	//Edit Assessment Category Modal*********************
	
	@FindBy(id="selectedCategory")
	public WebElement selectCategoryDropdown;
	
	public WebElement selectCategoryByName(String name) {
		return driver.findElement(By.id("edit-assess-cat-modal-component-skillcategoryoption-"+name));
	}
	
	@FindBy(id="skillCategory")
	public WebElement inputCategoryNameEditCategories;
	
	@FindBy(id="categoryOwner")
	public WebElement inputCategoryOwner;
	
	@FindBy(id="edit-assess-cat-modal-component-save")
	public WebElement editCategorySaveButton;
	
	@FindBy(id="edit-assess-cat-modal-component-close")
	public WebElement editCategoryCloseButton;
	
	//Add Assessment Category Modal
	
	@FindBy(id="category.skillCategory")
	public WebElement inputCategoryNameAddCategories;
	
	@FindBy(id="add-assess-cat-modal-addcategory")
	public WebElement submitCategoryButton;
	
	@FindBy(id="add-assess-cat-modal-closecategory")
	public WebElement addCategoryCloseButton;
	
	
	
	

}
