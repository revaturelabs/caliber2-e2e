package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.ManageBatchPage;
import com.revature.runner.Caliber2Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageBatchStep {

	public static WebDriver driver = Caliber2Runner.driver;
	public static ManageBatchPage managebatchpage = Caliber2Runner.managebatchpage;
	
	
	
	@Given("^The user is on the Manage Batch page$")
	public void the_user_is_on_the_Manage_Batch_page() throws Throwable {
	    managebatchpage.managebatchlink.click();
	}

	@When("^The user clicks on Create Batch link$")
	public void the_user_clicks_on_Create_Batch_link() throws Throwable {
	    managebatchpage.createbatchlink.click();
	}

	@Then("^The create batch form should pop up$")
	public void the_create_batch_form_should_pop_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
