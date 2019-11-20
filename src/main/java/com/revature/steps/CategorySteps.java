package com.revature.steps;

import com.revature.page.SettingsCategoriesPage;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategorySteps {

	WebDriver driver = PagesUtil.driver;
	SettingsCategoriesPage cp = PagesUtil.categoriesPage;

	// used for setting the current category in a scenario
	String currentCategory;

	@Then("^The active category is moved to the stale category list$")
	public void the_active_category_is_moved_to_the_stale_category_list()
		throws Throwable {

		List<WebElement> stale = this.cp.selectStaleCategories();
		for (WebElement category : stale) {
			if ((category.getAttribute("innerHTML").trim())
				.equals(this.currentCategory)) {
				return;
			}
		}
		Assert.fail("Couldn't find Test Category");
	}

	@Then("^The category will appear edited$")
	public void the_category_will_appear_edited() throws Throwable {
		this.cp.selectCategoryByName("NewCategory");

		this.cp.editCategoryButton().click();
		this.cp.selectCategoryOptionByName("NewCategory");
		this.cp.inputCategoryNameEditCategories()
			.sendKeys(this.currentCategory);
		this.cp.editCategorySaveButton().click();
		this.cp.editCategoryCloseButton().click();

	}

	@Then("^The new Category appears in category list$")
	public void the_new_Category_appears_in_category_list() throws Throwable {
		this.cp.selectCategoryByName("TestCategory");
	}

	@Then("^The stale category is moved to the active category list$")
	public void the_stale_category_is_moved_to_the_active_category_list()
		throws Throwable {
		List<WebElement> active = this.cp.selectActiveCategories();
		for (WebElement category : active) {
			if ((category.getAttribute("innerHTML").trim())
				.equals(this.currentCategory)) {
				return;
			}
		}
		Assert.fail("Couldn't find Test Category");
	}

	@When("^The User clicks add assesment$")
	public void the_User_clicks_add_assesment() throws Throwable {
		this.cp.addCategoryButton().click();
	}

	@When("^The User clicks edit category button$")
	public void the_User_clicks_edit_category_button() throws Throwable {
		this.currentCategory = this.cp.getFirstActiveCategoryName();
		this.cp.editCategoryButton().click();
	}

	@When("^The user clicks on a Stale Category$")
	public void the_user_clicks_on_a_Stale_Category() throws Throwable {
		this.currentCategory = this.cp.getFirstStaleCategoryName();
		this.cp.selectCategoryByName(this.currentCategory).click();
		Thread.sleep(1000);
	}

	@When("^The user clicks on an Active Categories$")
	public void the_user_clicks_on_an_Active_Categories() throws Throwable {
		this.currentCategory = this.cp.getFirstActiveCategoryName();
		this.cp.selectCategoryByName(this.currentCategory).click();
		Thread.sleep(1000);
	}

	@When("^The User clicks the add button$")
	public void the_User_clicks_the_add_button() throws Throwable {
		this.cp.submitCategoryButton().click();
	}

	@When("^The User clicks the close button$")
	public void the_User_clicks_the_close_button() throws Throwable {
		this.cp.addCategoryCloseButton().click();
	}

	@When("^The User clicks the dropdown box$")
	public void the_User_clicks_the_dropdown_box() throws Throwable {
		this.cp.getSelectCategoryDropdown().click();
	}

	@When("^The User clicks the edit close button$")
	public void the_User_clicks_the_edit_close_button() throws Throwable {
		this.cp.editCategoryCloseButton().click();

	}

	@When("^The User clicks the save button$")
	public void the_User_clicks_the_save_button() throws Throwable {
		this.cp.editCategorySaveButton().click();
	}

	@When("^The User edits category name$")
	public void the_User_edits_category_name() throws Throwable {
		this.cp.inputCategoryNameEditCategories().sendKeys("NewCategory");
	}

	@When("^The User inputs the category name$")
	public void the_User_inputs_the_category_name() throws Throwable {
		this.cp.inputCategoryNameAddCategories().sendKeys("TestCategory");
	}

	@When("^The User selects category$")
	public void the_User_selects_category() throws Throwable {
		this.cp.selectCategoryOptionByName(this.currentCategory);
	}

}
