package com.revature.steps;

import com.revature.page.AssessBatchPage;
import com.revature.page.NavigationBar;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AssessBatchSteps {

	public static NavigationBar navbar = PagesUtil.navBar;
	public static AssessBatchPage batchpage = PagesUtil.assessBatchPage;
	public static WebDriver driver = PagesUtil.driver;

	private int lastWeekAdded;

	@When("^the user clicks on the year dropdown$")
	public void the_user_clicks_on_the_year_dropdown() throws Throwable {
		Thread.sleep(250);
		batchpage.getYearDropdown().click();
	}

	@When("^the user chooses a year \"([^\"]*)\"$")
	public void the_user_chooses_a_year(String arg1) throws Throwable {
		batchpage.selectYear(arg1);
	}

	@When("^the user clicks on quarter dropdown$")
	public void the_user_clicks_on_quarter_dropdown() throws Throwable {
		batchpage.getQuarterDropdown().click();
	}

	@When("^the user chooses a quarter \"([^\"]*)\"$")
	public void the_user_chooses_a_quarter(String arg1) throws Throwable {
		batchpage.selectQuarter(arg1);
	}

	@When("^the user clicks on select batch dropdown$")
	public void the_user_clicks_on_select_batch_dropdown() throws Throwable {
		batchpage.getBatchesDropdown().click();
	}

	@When("^the user enters \"([^\"]*)\" into the search bar$")
	public void the_user_enters_criteria_into_the_search_bar(String arg1)
		throws Throwable {
		batchpage.getBatchSearchBar().sendKeys(arg1);
	}

	@When("^the user clicks on the first displayed result$")
	public void the_user_clicks_on_the_first_displayed_result()
		throws Throwable {
		batchpage.selectBatch("");
	}

	@Then("^the page should display information for \"([^\"]*)\"$")
	public void the_page_title_should_display_information_for(String arg1)
		throws Throwable {
		Assert.assertEquals(arg1, batchpage.getTrainerName(0).getText());
	}

	@Given("^the user is on a specific batch page$")
	public void the_user_is_on_a_specific_batch_page() throws Throwable {
		batchpage.getYearDropdown().click();
		batchpage.selectYear("2018");
		batchpage.getQuarterDropdown().click();
		batchpage.selectQuarter("Q4");
		batchpage.getBatchesDropdown().click();
		batchpage.getBatchSearchBar().sendKeys("Ravi");
		batchpage.selectBatch("Ravi Singh - Full Stack Java/JEE - 7/9/2018");
	}

	@When("^the user clicks on a specific week$")
	public void the_user_clicks_on_a_specific_week() throws Throwable {
		batchpage.selectWeek(1);
	}

	@Then("^the details of that week should be displayed$")
	public void the_details_of_that_week_should_be_displayed()
		throws Throwable {
		Assert.assertEquals(batchpage.getWeeksContainer()
			.findElement(By.tagName("a")).getText(), "Week 1");
	}

	@When("^the user clicks the plus button$")
	public void the_user_clicks_the_plus_button() throws Throwable {
		batchpage.getAddWeekButton().click();
	}

	@When("^the user clicks the yes button$")
	public void the_user_clicks_the_yes_button() throws Throwable {
		// Not ever called outside the "add a week" scenario at time of writing
		batchpage.getNewWeekYesButton().click();

		// calculate the last week
		List<WebElement> elements =
			batchpage.getWeeksContainer().findElements(By.tagName("a"));
		Assert.assertTrue(elements.size() > 1);
		String text = elements.get(elements.size() - 2).getText();
		String parts[] = text.split(" ");

		int lastWeek = Integer.parseInt(parts[parts.length - 1]);
		this.lastWeekAdded = lastWeek;
	}

	@Then("^a new week should be displayed on the batch page$")
	public void a_new_week_should_be_displayed_on_the_batch_page()
		throws Throwable {
		Thread.sleep(2000);
		List<WebElement> elements =
			batchpage.getWeeksContainer().findElements(By.tagName("a"));
		Assert.assertTrue(elements.size() > 1);
		Assert.assertEquals("Week " + this.lastWeekAdded,
			elements.get(elements.size() - 2).getText());
	}

	@When("^the user clicks create assessment$")
	public void the_user_clicks_create_assessment() throws Throwable {
		Thread.sleep(250);
		batchpage.getCreateAssessmentButton().click();
	}

	@When("^the user clicks create assessment from dialog$")
	public void the_user_clicks_create_assessment_from_dialog()
		throws Throwable {
		Thread.sleep(250);
		batchpage.getCreateAssessmentCreateButton().click();
	}

	@When("^the user fills out assessment information$")
	public void the_user_fills_out_assessment_information() throws Throwable {
		Thread.sleep(250);
		batchpage.selectCreateAssessmentType(1);
		Thread.sleep(250);
		batchpage.getCreateMaxPointsInput().clear();
		batchpage.getCreateMaxPointsInput().sendKeys("100");
		Thread.sleep(250);
		batchpage.selectCreateCategory("NewBologna");
	}

	@Then("^the batch page will update with the new information$")
	public void the_batch_page_will_update_with_the_new_information()
		throws Throwable {
		Assert.assertNotNull(batchpage.getAssessmentType(0));
	}

	@When("^the user clicks import grades$")
	public void the_user_clicks_import_grades() throws Throwable {
		batchpage.getImportGradesButton().click();
	}

	@When("^the user enters a valid json from revpro$")
	public void the_user_enters_a_valid_json_from_revpro() throws Throwable {
		Thread.sleep(250);
		batchpage.getImportGradesInput().sendKeys("1");
		Thread.sleep(250);
		batchpage.getImportGradesButton().click();
	}

	@Then("^the batch page will be updated with the new information$")
	public void the_batch_page_will_be_updated_with_the_new_information()
		throws Throwable {
		Assert.assertNotNull(batchpage.getTrainerContainer(1));
	}

	@Given("^the user is on a specific batch page with existing assessments$")
	public void the_user_is_on_a_specific_batch_page_with_existing_assessments()
		throws Throwable {
		batchpage.getYearDropdown().click();
		batchpage.selectYear("2019");
		batchpage.getQuarterDropdown().click();
		batchpage.selectQuarter("Q1");
		batchpage.getBatchesDropdown().click();
		batchpage.getBatchSearchBar().sendKeys("Jake");
		batchpage.selectBatch("Jake Smith - Full Stack Java/JEE - 3/9/2019");
	}

	@When("^the user changes an assessment grade for a specific associate$")
	public void the_user_changes_an_assessment_grade_for_a_specific_associate()
		throws Throwable {
		Thread.sleep(250);
		batchpage.getUpdateAssessmentButton(0).click();
		Thread.sleep(250);
		batchpage.selectUpdateAssessmentType(0);
	}

	@Then("^the statistics at the bottom of the page should update correctly$")
	public void
		the_statistics_at_the_bottom_of_the_page_should_update_correctly()
			throws Throwable {
		Assert.assertTrue(
			!(batchpage.getWeeklyAverage().getText().equals("0.00%")));
	}

	@Given("^the user is on a specific batch page and has made changes to the existing data$")
	public void
		the_user_is_on_a_specific_batch_page_and_has_made_changes_to_the_existing_data()
			throws Throwable {
		batchpage.getYearDropdown().click();
		batchpage.selectYear("2018");
		batchpage.getQuarterDropdown().click();
		batchpage.selectQuarter("Q4");
		batchpage.getBatchesDropdown().click();
		batchpage.getBatchSearchBar().sendKeys("Ravi");
		batchpage.selectBatch("");
	}

	@When("^the user clicks save changes$")
	public void the_user_clicks_save_changes() throws Throwable {
		batchpage.getSaveButton().click();
	}

	@Then("^the batch information should update accordingly$")
	public void the_batch_information_should_update_accordingly()
		throws Throwable {
		Assert.assertNotNull(batchpage.getTrainerContainer(1));
	}

}
