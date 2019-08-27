package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.QAPage;
import com.revature.runner.Caliber2Runner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class QualityAuditStep {

	public static WebDriver driver = Caliber2Runner.driver;
	public static QAPage qaPage = Caliber2Runner.qaPage;
	
	@Given("^The user is on the Caliber(\\d+) QA page$")
	public void the_user_is_on_the_Caliber_QA_page(int arg1) throws Throwable {
	    driver.get("http://localhost:4200/caliber/vp/audit");
	    Thread.sleep(1000);
	}
	
	//first name might change if you add someone named Aaron for example
	// use the regex to replace any leading/trailing whitespace from received text
	// it WILL absolutely contain unexpected whitespace, so be careful when writing tests
	@Then("^The first trainee is Adams, Gary$")
	public void the_first_trainee_is_Adams_Gary() throws Throwable {
		System.out.println(qaPage.firstTraineeName.getText());
		Assert.assertEquals("should be adams, gary", 
				qaPage.firstTraineeName.getText().replaceAll("^\\s+|\\s+$", ""), 
				"Adams, Gary");
	}

	@When("^The user clicks on individual feedback$")
	public void the_user_clicks_on_individual_feedback() throws Throwable {
		qaPage.firstTraineeMenu.click();
		Thread.sleep(500);
	}

	@When("^The user clicks on frown$")
	public void the_user_clicks_on_frown() throws Throwable {
		qaPage.firstTraineeFrown.click();
	}

	@Then("^The feedback will be frown$")
	public void the_feedback_will_be_frown() throws Throwable {
		Assert.assertTrue(qaPage.firstTraineeMenu.getAttribute("className").contains("fa-frown-o"));
	}
	
	@When("^The user clicks on the first textbox$")
	public void the_user_clicks_on_the_first_textbox() throws Throwable {
		qaPage.firstTraineeNotes.click();
	}

	@When("^The user types hello world$")
	public void the_user_types_hello_world() throws Throwable {
		qaPage.firstTraineeNotes.clear();
		qaPage.firstTraineeNotes.sendKeys("hello world");
	}

	@Then("^The text feedback will be hello world$")
	public void the_text_feedback_will_be_hello_world() throws Throwable {
		Assert.assertEquals("should be hello world", 
				qaPage.firstTraineeNotes.getText().replaceAll("^\\s+|\\s+$", ""), 
				"hello world");
	}
	
	@When("^The user hits save$")
	public void the_user_hits_save() throws Throwable {
		qaPage.saveButton.click();
	}
}
