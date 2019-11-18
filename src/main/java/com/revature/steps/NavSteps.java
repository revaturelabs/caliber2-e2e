package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.page.NavigationBar;
import com.revature.utils.PagesUtil;

import cucumber.api.java.en.*;

public class NavSteps {

	WebDriver driver = PagesUtil.driver;
	NavigationBar navBar = PagesUtil.navBar;
	
	@Given("^The user is on the Caliber2 home page$")
	public void the_user_is_on_the_Caliber_home_page() throws Throwable {
	    driver.get("http://caliber-2-dev.revaturelabs.com.s3-website-us-east-1.amazonaws.com/caliber/vp/home");
	}
	
	@When("^the user clicks on assess batch$")
	public void the_user_clicks_on_assess_batch() throws Throwable {
		navBar.assessbatch.click();
	}
	
	@When("^the user clicks on manage batch$")
	public void the_user_clicks_on_manage_batch() throws Throwable {
		navBar.managebatch.click();
	}
	
	@When("^the user clicks on quality audit$")
	public void the_user_clicks_on_quality_audit_page() throws Throwable {
	    navBar.qualitybatch.click();
	}
		
	@When("^the user clicks on reports$")
	public void the_user_clicks_on_reports_tab() throws Throwable {
	    navBar.reports.click();
	}
	
	@When("^the user clicks on the settings$")
	public void the_user_clicks_on_settings() throws Throwable {
	    navBar.settings.click();
	}
	
	@When("^the user clicks on the trainer$")
	public void the_user_clicks_on_trainers() throws Throwable {
	    navBar.trainers.click();
	}
	
	@When("^the user clicks on the location$")
	public void the_user_clicks_on_locations() throws Throwable {
		navBar.locations.click();
	}
	
	@When("^the_user_clicks_on_category$")
	public void the_user_clicks_on_category() throws Throwable {
		navBar.categories.click();
	}
	
	@When("^the_user_clicks_on_login$")
	public void the_user_is_on_the_trainer_page() throws Throwable {
	    navBar.login.click();
	}
}
