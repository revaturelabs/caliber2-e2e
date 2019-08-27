package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.AssessBatchPOM;
import com.revature.runner.Caliber2Runner;

import cucumber.api.java.en.When;

public class AssessBatchStep {

	public static WebDriver driver = Caliber2Runner.driver;
	public static AssessBatchPOM assessBatch = Caliber2Runner.assessBatch;
	
	@When("^The user clicks on Add Week$")
	public void the_user_clicks_on_Add_Week() throws Throwable {
	   assessBatch.newWeek.click();
	}

	@When("^The user clicks on No$")
	public void the_user_clicks_on_No() throws Throwable {
	    assessBatch.declineWeek.click();
	}


}
