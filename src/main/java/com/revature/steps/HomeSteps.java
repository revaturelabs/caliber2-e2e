package com.revature.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.page.HomePage;
import com.revature.utils.PagesUtil;

import cucumber.api.java.en.*;

public class HomeSteps {
	
	WebDriver driver = PagesUtil.driver;
	HomePage page = PagesUtil.homePage;
	
	@When("^The user clicks on the States dropdown$")
	public void the_user_clicks_on_the_States_dropdown() {
		page.getLastQAstateDropdown().click();
	}
	
	/**
	 * @param arg1 the state that is to be clicked on
	 */
	@When("^The user clicks on state \"([^\"]*)\"$")
	public void the_user_clicks_on_state(String arg1) {
		page.selectLastQAState(arg1);
	}
	
	/**
	 * @param arg1 the state or city that the user clicked on
	 */
	@Then("^The user can see stats for \"([^\"]*)\"$")
	public void the_user_can_see_stats_for(String arg1) {
		assertTrue(page.getLastQAstateDropdown().getAttribute("value").equals(arg1) || page.getCityDropdown().getText().equals("All Cities\n" + arg1));
	}
	
	@When("^The user clicks on the Cities dropdown$")
	public void the_user_clicks_on_the_Cities_dropdown() {
		page.getCityDropdown().click();
	}
	
	/**
	 * @param arg1 the city that is to be clicked on
	 */
	@When("^The user clicks on city \"([^\"]*)\"$")
	public void the_user_clicks_on_city(String arg1) {
		page.selectLastQACity(arg1);
	}
	//Then The user can see stats for city
	
	/**
	 * @param arg1 the week number that is to be removed
	 */
	@When("^The user removes week \"([^\"]*)\"$")
	public void the_user_clicks_on_week(String arg1) {
		int week = Integer.parseInt(arg1);
		page.getWeekByWeekNumber(week).findElement(By.id("pills-pill-remove-week-button")).click();
	}
	
	/**
	 * @param arg1 the week that was removed
	 */
	@Then("^The table is updated minus week \"([^\"]*)\"$")
	public void the_table_is_updated_minus_week(String arg1) {
		List<Integer> pillList = new LinkedList<Integer>();
		for(WebElement pill :page.getWeeksContainer().findElements(By.className("pillContent"))){
			pillList.add(Integer.parseInt(pill.getText().split(" ")[1]));
		}
		List<WebElement> rows = page.getMissingGradeRows();
		for (WebElement webElement : rows) {
			boolean flag = false;
			for(WebElement week :webElement.findElements(By.tagName("span"))) {
				for(Integer i : pillList) {
					if(Integer.parseInt(week.getText())==i) {
						flag = true;
						break;
					}
				}
				if(flag)break;
			}
			assertTrue(flag);
		}
	}
	
	/**
	 * @param arg1 the week that was added back
	 */
	@Then("^The table is updated plus week \"([^\"]*)\"$")
	public void the_table_is_updated_updated_plus_week(String arg1) {
		List<Integer> pillList = new LinkedList<Integer>();
		for(WebElement pill :page.getWeeksContainer().findElements(By.className("pillContent"))){
			pillList.add(Integer.parseInt(pill.getText().split(" ")[1]));
		}
		List<WebElement> rows = page.getMissingGradeRows();
		for (WebElement webElement : rows) {
			boolean flag = false;
			for(WebElement week :webElement.findElements(By.tagName("span"))) {
				for(Integer i : pillList) {
					if(Integer.parseInt(week.getText())==i) {
						flag = true;
						break;
					}
				}
				if(flag)break;
			}
			assertTrue(flag);
		}
	}
	
	@When("^The user removes all weeks$")
	public void the_user_removes_all_weeks() {
		int weekNumber = (page.getWeeksContainer().findElements(By.className("pillX")).size());
		for(int i = 0; i< weekNumber; i++) {
			page.getWeeksContainer().findElement(By.id("pills-pill-remove-week-button")).click();
		}
	}

	@Then("^The table is empty$")
	public void the_table_is_empty() {
		assertNull(page.getMissingGradeRows());
	}

	@When("^The user clicks the include weeks button$")
	public void the_user_clicks_the_include_weeks_button() {
		page.weekSorterButton.click();
	}
	
	/**
	 * @param arg1 the week to be selected
	 */
	@When("^The user clicks a week \"([^\"]*)\"$")
	public void the_user_clicks_a_week(String arg1) {
		int week = Integer.parseInt(arg1);
		page.selectWeekSorterByIndex(week-1);	
	}

}
