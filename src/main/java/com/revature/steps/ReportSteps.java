package com.revature.steps;

import com.revature.utils.PagesUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReportSteps {

	@When("^The user selects a year from the dropdown for year$")
	public void the_user_selects_a_year_from_the_dropdown_for_year()
		throws Throwable {
		// TODO make sure this works
		PagesUtil.reportsPage.getDropdownSelectYearContainer()
			.findElement(By.xpath(".//a[1]")).click();
	}

	@Then("^The select batch drop down is populated$")
	public void the_select_batch_drop_down_is_populated() throws Throwable {
		Assert
			.assertTrue(PagesUtil.reportsPage.getDropdownSelectBatchContainer()
				.findElements(By.xpath(".//a")).size() > 0);
	}

	@When("^The user selects a \"([^\"]*)\"$")
	public void the_user_selects_a(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user clicks the select batch dropdown$")
	public void the_user_clicks_the_select_batch_dropdown() throws Throwable {
		PagesUtil.reportsPage.getBatchSelectDropdownOpenButton().click();
	}

	@When("^The user inputs a \"([^\"]*)\" into the search bar$")
	public void the_user_inputs_a_into_the_search_bar(String criteria)
		throws Throwable {
		PagesUtil.reportsPage.getBatchSelectSearchBar().sendKeys(criteria);
	}

	@Then("^The batch dropdown should contain items matching the \"([^\"]*)\"$")
	public void the_batch_dropdown_should_contain_items_matching_the(
		String criteria) throws Throwable {

		List<WebElement> items = PagesUtil.reportsPage
			.getDropdownSelectBatchContainer().findElements(By.tagName("a"));
		for (WebElement item : items) {
			if (item.getText().contains(criteria)) {
				return;
			}
		}
		Assert.fail();
	}

	@Then("^A week selection drop down menu should be visible$")
	public void a_week_selection_drop_down_menu_should_be_visible()
		throws Throwable {
		// exception from this will act as a failed assertion
		WebElement container =
			PagesUtil.reportsPage.getDropdownSelectWeeksContainer();
		Assert.assertNotNull(container);
	}

	@Then("^populated with how many \"([^\"]*)\" they have in that batch$")
	public void populated_with_how_many_they_have_in_that_batch(
		String numEntries) throws Throwable {

		int entries = Integer.parseInt(numEntries);
		final int allWeeksEntry = 1;

		PagesUtil.reportsPage.getSelectWeeksDropdownButton().click();
		List<WebElement> items = PagesUtil.reportsPage
			.getDropdownSelectWeeksContainer().findElements(By.tagName("a"));
		Assert.assertEquals(entries + allWeeksEntry, items.size());
	}

}
