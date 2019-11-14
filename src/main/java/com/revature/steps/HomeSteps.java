package com.revature.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.revature.page.HomePage;
import com.revature.runner.ChromeRunner;
import com.revature.utils.PagesUtil;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class HomeSteps {
	
	WebDriver driver = PagesUtil.driver;
	HomePage page = PagesUtil.homePage;

//	@When("^The user clicks on performance \"([^\"]*)\"$")
//	public void the_user_clicks_on_performance(String arg1) throws Throwable {
//		page.lastQACanvas.click();
//		throw new PendingException();
//	}
//	
//	@Then("^The user toggles display of associates graded as \"([^\"]*)\"$")
//	public void the_user_toggles_display_of_associates_graded_as(String arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
	@Given("^The user is on the home page$")
	public void the_user_is_on_the_home_page() throws Throwable {
		assertTrue(driver.getCurrentUrl().endsWith("home"));
		throw new PendingException();
	}
	
	@When("^The user clicks on the States dropdown$")
	public void the_user_clicks_on_the_States_dropdown() throws Throwable {
		page.lastQAStateDropdown.click();
		throw new PendingException();
	}
	
	@When("^The user clicks on state \"([^\"]*)\"$")
	public void the_user_clicks_on_state(String arg1) throws Throwable {
		page.selectLastQAState(arg1);
		throw new PendingException();
	}
	
	@Then("^The user can see stats for \"([^\"]*)\"$")
	public void the_user_can_see_stats_for(String arg1) throws Throwable {
		//assertTrue(page.getCityDropdown() != null);
		assertTrue(page.lastQAStateDropdown.getText().equals(arg1) || page.getCityDropdown().getText().equals(arg1));
		throw new PendingException();
	}
	
	@When("^The user clicks on the Cities dropdown$")
	public void the_user_clicks_on_the_Cities_dropdown() throws Throwable {
		page.getCityDropdown().click();
		throw new PendingException();
	}
	
	@When("^The user clicks on city \"([^\"]*)\"$")
	public void the_user_clicks_on_city(String arg1) throws Throwable {
		page.selectLastQACity(arg1);
		throw new PendingException();
	}

	

	@When("^The user clicks on all weeks$")
	public void the_user_clicks_on_all_weeks() throws Throwable {
		page.weekSorterButton.click();
	    throw new PendingException();
	}

	@Then("^The user sees no results$")
	public void the_user_sees_no_results() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user clicks on one week$")
	public void the_user_clicks_on_one_week() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The user sees all reports that include that week$")
	public void the_user_sees_all_reports_that_include_that_week() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^The table is updated$")
	public void the_table_is_updated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user removes all weeks$")
	public void the_user_removes_all_weeks() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The table is empty$")
	public void the_table_is_empty() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user clicks the include weeks button$")
	public void the_user_clicks_the_include_weeks_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user selects a week$")
	public void the_user_selects_a_week() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
