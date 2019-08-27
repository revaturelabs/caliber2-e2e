package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.QAPage;
import com.revature.runner.Caliber2Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class QualityAuditStep {

	public static WebDriver driver = Caliber2Runner.driver;
	public static QAPage qaPage = Caliber2Runner.qaPage;
	
	@Given("^The user is on the Caliber(\\d+) QA page$")
	public void the_user_is_on_the_Caliber_QA_page(int arg1) throws Throwable {
	    driver.get("http://localhost:4200/caliber/vp/audit");
	}
	
	//first name might change if you add someone named Aaron for example
	@Then("^The first trainee is Adams, Gary$")
	public void the_first_trainee_is_Adams_Gary() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(qaPage.firstTraineeName, "Adams, Gary");
		
	    //throw new PendingException();
	}

	@When("^The user clicks on individual feedback$")
	public void the_user_clicks_on_individual_feedback() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		Thread.sleep(2500);
		qaPage.firstTraineeMenu.click();
	}

	@When("^The user clicks on frown$")
	public void the_user_clicks_on_frown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		Thread.sleep(2500);
		qaPage.firstTraineeFrown.click();
	}

	@Then("^The feedback will be frown$")
	public void the_feedback_will_be_frown() throws Throwable {
		Thread.sleep(2500);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
}
