package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.page.NavigationBar;
import com.revature.utils.PagesUtil;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class NavSteps {

	WebDriver driver = PagesUtil.driver;
	NavigationBar navBar = PagesUtil.navBar;
	
	@Given("^The user is on the Caliber2 home page$")
	public void the_user_is_on_the_Caliber_home_page(int arg1) throws Throwable {
	    driver.get("http://caliber-2-dev.revaturelabs.com.s3-website-us-east-1.amazonaws.com/caliber/vp/home");
	}
	
	@When("^the user clicks on assess batch$")
	public void the_user_clicks_on_assess_batch() throws Throwable {
		navBar.assessbatch.click();
	}
	
	@Given("^User on quality audit page$")
	public void user_on_quality_audit_page() throws Throwable {
	    navBar.qualitybatch.click();
	}
	
	@Given("^The user is on the trainer page$")
	public void the_user_is_on_the_trainer_page() throws Throwable {
	    navBar.settings.click();
	    navBar.trainers.click();
	}
	
	@Given("^The user is in the Reports tab$")
	public void the_user_is_in_the_Reports_tab() throws Throwable {
	    navBar.reports.click();
	}
	
	@Given("^The user is on the caliber (\\d+) location page$")
	public void the_user_is_on_the_caliber_location_page(int arg1) throws Throwable {
	    navBar.settings.click();
		navBar.locations.click();
	}
	
	@Given("^The user is on the category page$")
	public void the_user_is_on_the_category_page() throws Throwable {
		navBar.settings.click();
		navBar.categories.click();
	}
}
