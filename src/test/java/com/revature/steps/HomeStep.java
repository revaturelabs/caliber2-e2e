package com.revature.steps;

import org.openqa.selenium.WebDriver;


import com.revature.pages.HomePage;
import com.revature.runner.Caliber2Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStep {

	public static WebDriver driver = Caliber2Runner.driver;
	public static HomePage home = Caliber2Runner.home;
	
	@Given("^The user is on the Caliber(\\d+) home page$")
	public void the_user_is_on_the_Caliber_home_page(int arg1) throws Throwable {
	    driver.get("localhost:4200");
	}

	@When("^The user clicks on Manage Batch$")
	public void the_user_clicks_on_Manage_Batch() throws Throwable {
	   home.managebatch.click();
	}

	@When("^The user clicks on Assess Batch$")
	public void the_user_clicks_on_Assess_Batch() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    home.assessbatch.click();
	}

	@When("^The user clicks on Quality Audit$")
	public void the_user_clicks_on_Quality_Audit() throws Throwable {
	   home.qualitybatch.click();
	}

	@When("^The user clicks on Panel$")
	public void the_user_clicks_on_Panel() throws Throwable {
	    home.panel.click();
	}

	@When("^The user clicks on Reports$")
	public void the_user_clicks_on_Reports() throws Throwable {
	    home.reports.click();
	}

	@When("^The user clicks on Settings$")
	public void the_user_clicks_on_Settings() throws Throwable {
	    home.settings.click();
	}

	@When("^The user clicks on Trainers$")
	public void the_user_clicks_on_Trainers() throws Throwable {
	    home.trainers.click();
	}

	@When("^The user clicks on Locations$")
	public void the_user_clicks_on_Locations() throws Throwable {
	    home.locations.click();
	}

	@When("^The user clicks on Category$")
	public void the_user_clicks_on_Category() throws Throwable {
	    home.category.click();
	}

	@Then("^The user clicks on Home$")
	public void the_user_clicks_on_Home() throws Throwable {
	   home.homenav.click();
	}

}
