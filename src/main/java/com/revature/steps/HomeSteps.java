package com.revature.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.revature.page.HomePage;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.*;

public class HomeSteps {
	
	PagesUtil p = new PagesUtil();	
	WebDriver driver = PagesUtil.driver;
	HomePage page = PagesUtil.homePage;
	
	@When("^The user clicks on the States dropdown$")
	public void the_user_clicks_on_the_States_dropdown() {
		page.lastQAStateDropdown.click();
	}
	
	@When("^The user clicks on state \"([^\"]*)\"$")
	public void the_user_clicks_on_state(String arg1) {
		page.selectLastQAState(arg1);
	}
	
	@Then("^The user can see stats for \"([^\"]*)\"$")
	public void the_user_can_see_stats_for(String arg1) {
		assertTrue(page.lastQAStateDropdown.getText().equals(arg1) || page.getCityDropdown().getText().equals(arg1));
	}
	
	@When("^The user clicks on the Cities dropdown$")
	public void the_user_clicks_on_the_Cities_dropdown() {
		page.getCityDropdown().click();
	}
	
	@When("^The user clicks on city \"([^\"]*)\"$")
	public void the_user_clicks_on_city(String arg1) {
		page.selectLastQACity(arg1);
	}
	//Then The user can see stats for city
	
	@When("^The user clicks on week \"([^\"]*)\"$")
	public void the_user_clicks_on_week(String arg1) {
		
	}
	
	@Then("^The table is updated$")
	public void the_table_is_updated() {
	}

	@When("^The user removes all weeks$")
	public void the_user_removes_all_weeks() {
	}

	@Then("^The table is empty$")
	public void the_table_is_empty() {
	}

	@When("^The user clicks the include weeks button$")
	public void the_user_clicks_the_include_weeks_button() throws Throwable {
	}

	@When("^The user selects a week$")
	public void the_user_selects_a_week() {
	}
}
