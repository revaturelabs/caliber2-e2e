package com.revature.steps;

import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReportSteps {

	@Then("^A week selection drop down menu should be visible$")
	public void a_week_selection_drop_down_menu_should_be_visible()
		throws Throwable {
		try {
			WebElement container =
				PagesUtil.reportsPage.getSelectWeeksDropdownButton();
			Assert.assertNotNull(container);
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^All cells should have an icon$")
	public void all_cells_should_have_an_icon() throws Throwable {
		try {
			List<WebElement> bodyRows = PagesUtil.reportsPage.getQcScoreTable()
				.findElements(By.xpath(".//tbody/tr"));
			List<WebElement> footRows = PagesUtil.reportsPage.getQcScoreTable()
				.findElements(By.xpath(".//tfoot/tr"));

			for (int i = 1; i < bodyRows.size(); ++i) {
				// skip the first column, it is a label
				WebElement row = bodyRows.get(i);
				List<WebElement> columns = row.findElements(By.xpath(".//td"));
				for (WebElement cell : columns) {
					try {
						cell.findElement(By.tagName("em"));
					}
					catch (NoSuchElementException e) {
						Assert.fail();
					}
				}
			}

			for (int i = 1; i < footRows.size(); ++i) {
				// skip the first column, it is a label
				WebElement row = footRows.get(i);
				List<WebElement> columns = row.findElements(By.xpath(".//td"));
				for (WebElement cell : columns) {
					try {
						cell.findElement(By.tagName("em"));
					}
					catch (NoSuchElementException e) {
						Assert.fail();
					}
				}
			}
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^populated with how many \"([^\"]*)\" they have in that batch$")
	public void populated_with_how_many_they_have_in_that_batch(
		String numEntries) throws Throwable {

		int entries;
		try {
			entries = Integer.parseInt(numEntries);
		}
		catch (NumberFormatException e) {
			Assert.fail();
			return;// redundant but fixes warning
		}

		try {
			PagesUtil.reportsPage.getSelectWeeksDropdownButton().click();
			List<WebElement> items =
				PagesUtil.reportsPage.getDropdownSelectWeeksContainer()
					.findElements(By.tagName("a"));
			Assert.assertEquals(entries, items.size());
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^The batch dropdown should contain items matching the \"([^\"]*)\"$")
	public void the_batch_dropdown_should_contain_items_matching_the(
		String criteria) throws Throwable {
		try {
			List<WebElement> items =
				PagesUtil.reportsPage.getDropdownSelectBatchContainer()
					.findElements(By.tagName("a"));
			for (WebElement item : items) {
				if (item.getText().contains(criteria)) {
					return;
				}
			}
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
		Assert.fail();
	}

	@Then("^The dashboard will populate charts$")
	public void the_dashboard_will_populate_charts() throws Throwable {
		try {
			PagesUtil.reportsPage.getDonutChartTable();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^The dashboard will populate individual scores$")
	public void the_dashboard_will_populate_individual_scores()
		throws Throwable {
		try {
			PagesUtil.reportsPage.getIndividualScoreTable();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^The dashboard will populate information$")
	public void the_dashboard_will_populate_information() throws Throwable {
		try {
			PagesUtil.reportsPage.getQcScoreTable();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^The select batch drop down is populated$")
	public void the_select_batch_drop_down_is_populated() throws Throwable {
		try {
			PagesUtil.reportsPage.getSelectBatchDropdownOpenButton().click();
			Assert.assertTrue(
				PagesUtil.reportsPage.getDropdownSelectBatchContainer()
					.findElements(By.xpath(".//a")).size() > 0);
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@Then("^The table should have the correct number of week columns$")
	public void the_table_should_have_the_correct_number_of_week_columns()
		throws Throwable {

		try {
			PagesUtil.reportsPage.getSelectWeeksDropdownButton().click();
			List<WebElement> items =
				PagesUtil.reportsPage.getDropdownSelectWeeksContainer()
					.findElements(By.tagName("a"));

			// The number of weeks + all weeks, which == #weeks + trainee col
			final int properCols = items.size();

			List<WebElement> headRows = PagesUtil.reportsPage.getQcScoreTable()
				.findElements(By.xpath(".//thead/tr"));
			List<WebElement> bodyRows = PagesUtil.reportsPage.getQcScoreTable()
				.findElements(By.xpath(".//tbody/tr"));
			List<WebElement> footRows = PagesUtil.reportsPage.getQcScoreTable()
				.findElements(By.xpath(".//tfoot/tr"));

			for (WebElement row : headRows) {
				List<WebElement> columns = row.findElements(By.xpath(".//th"));
				Assert.assertEquals(properCols, columns.size());
			}
			for (WebElement row : bodyRows) {
				List<WebElement> columns = row.findElements(By.xpath(".//td"));
				Assert.assertEquals(properCols, columns.size());
			}

			for (WebElement row : footRows) {
				List<WebElement> columns = row.findElements(By.xpath(".//td"));
				Assert.assertEquals(properCols, columns.size());
			}
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@When("^The user clicks the select batch dropdown$")
	public void the_user_clicks_the_select_batch_dropdown() throws Throwable {
		try {
			PagesUtil.reportsPage.getSelectBatchDropdownOpenButton().click();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@When("^The user inputs a \"([^\"]*)\" into the search bar$")
	public void the_user_inputs_a_into_the_search_bar(String criteria)
		throws Throwable {
		try {
			PagesUtil.reportsPage.getBatchSelectSearchBar().sendKeys(criteria);
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@When("^The user selects a batch \"([^\"]*)\"$")
	public void the_user_selects_a_batch(String batch) throws Throwable {
		try {
			PagesUtil.reportsPage.getSelectBatchDropdownOpenButton().click();
			List<WebElement> items =
				PagesUtil.reportsPage.getDropdownSelectBatchContainer()
					.findElements(By.tagName("a"));
			for (WebElement item : items) {
				if (item.getText().contains(batch)) {
					item.click();
					return;
				}
			}
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
		Assert.fail("Could not find batch");
	}

	@When("^The user selects a trainee \"([^\"]*)\"$")
	public void the_user_selects_a_trainee(String trainee) throws Throwable {
		try {
			PagesUtil.reportsPage.getSelectTraineesDropdownButton().click();
			PagesUtil.reportsPage.getDropdownSelectTraineeContainer()
				.findElement(By.xpath(
					".//a[@id=\"shared-dropdown-menu-" + trainee + "\"]"))
				.click();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@When("^The user selects a week \"([^\"]*)\"$")
	public void the_user_selects_a_week(String week) throws Throwable {
		try {
			PagesUtil.reportsPage.getSelectWeeksDropdownButton().click();
			PagesUtil.reportsPage.getDropdownSelectWeeksContainer()
				.findElement(
					By.xpath(".//a[@id=\"shared-dropdown-menu-" + week + "\"]"))
				.click();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

	@When("^The user selects a year \"([^\"]*)\"$")
	public void the_user_selects_a_year(String year) throws Throwable {
		PagesUtil.reportsPage.getSelectYearDropdownButton().click();
		PagesUtil.reportsPage.getDropdownSelectYearContainer()
			.findElement(
				By.xpath(".//a[@id=\"shared-dropdown-menu-" + year + "\"]"))
			.click();
	}

	@When("^The user selects a year from the dropdown for year$")
	public void the_user_selects_a_year_from_the_dropdown_for_year()
		throws Throwable {
		PagesUtil.reportsPage.getSelectYearDropdownButton().click();
		PagesUtil.reportsPage.getDropdownSelectYearContainer()
			.findElement(By.xpath(".//a[@id=\"shared-dropdown-menu-2019\"]"))
			.click();
	}

	@When("^The user selects all trainees$")
	public void the_user_selects_all_trainees() throws Throwable {
		PagesUtil.reportsPage.getSelectTraineesDropdownButton().click();
		PagesUtil.reportsPage.getDropdownSelectTraineeContainer()
			.findElement(By
				.xpath(".//a[@id=\"shared-dropdown-menu-Trainees (Overall)\"]"))
			.click();
	}

	@When("^The user selects all weeks$")
	public void the_user_selects_all_weeks() throws Throwable {
		try {
			PagesUtil.reportsPage.getSelectWeeksDropdownButton().click();
			PagesUtil.reportsPage.getDropdownSelectWeeksContainer()
				.findElement(
					By.xpath(".//a[@id=\"shared-dropdown-menu-All Weeks\"]"))
				.click();
		}
		catch (TimeoutException e) {
			Assert.fail();
		}
	}

}
