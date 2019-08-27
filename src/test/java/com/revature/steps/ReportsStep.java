package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.Caliber2page;
import com.revature.runner.Caliber2Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsStep {

	public static WebDriver driver = Caliber2Runner.driver;
	public static Caliber2page caliber2page = Caliber2Runner.caliber2page;

	@Then("^The user should be on reports$")
	public void the_user_should_be_on_reports() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The user is on the reports page$")
	public void the_user_is_on_the_reports_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user clicks the dropdown and clicks (\\d+)$")
	public void the_user_clicks_the_dropdown_and_clicks(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The user will have the reports for (\\d+) displayed$")
	public void the_user_will_have_the_reports_for_displayed(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
