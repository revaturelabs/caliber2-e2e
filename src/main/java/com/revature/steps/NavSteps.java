package com.revature.steps;

import com.revature.page.NavigationBar;
import com.revature.utils.Config;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

public class NavSteps {

	WebDriver driver = PagesUtil.driver;
	NavigationBar navBar = PagesUtil.navBar;

	@When("^the user clicks on assess batch$")
	public void the_user_clicks_on_assess_batch() throws Throwable {
		this.navBar.assessbatch.click();
	}

	@When("^the_user_clicks_on_category$")
	public void the_user_clicks_on_category() throws Throwable {
		this.navBar.categories.click();
	}

	@When("^the user clicks on the location$")
	public void the_user_clicks_on_locations() throws Throwable {
		this.navBar.locations.click();
	}

	@When("^the user clicks on manage batch$")
	public void the_user_clicks_on_manage_batch() throws Throwable {
		this.navBar.managebatch.click();
	}

	@When("^the user clicks on quality audit$")
	public void the_user_clicks_on_quality_audit_page() throws Throwable {
		this.navBar.qualitybatch.click();
	}

	@When("^the user clicks on reports$")
	public void the_user_clicks_on_reports_tab() throws Throwable {
		this.navBar.reports.click();
	}

	@When("^the user clicks on the settings$")
	public void the_user_clicks_on_settings() throws Throwable {
		this.navBar.settings.click();
	}

	@When("^the user clicks on the trainer$")
	public void the_user_clicks_on_trainers() throws Throwable {
		this.navBar.trainers.click();
	}

	@Given("^The user is on the Caliber2 home page$")
	public void the_user_is_on_the_Caliber_home_page() throws Throwable {
		if (!Config.isURLSet()) {
			Assert.fail("URL has not been set.");
		}
		try {
			this.driver.get(Config.getURL());
		}
		catch (InvalidArgumentException e) {
			Assert.fail("Invalid URL provided: '" + Config.getURL() + "'");
		}
	}

	@When("^the_user_clicks_on_login$")
	public void the_user_is_on_the_trainer_page() throws Throwable {
		this.navBar.login.click();
	}
}
