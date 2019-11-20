package com.revature.steps;

import com.revature.page.HomePage;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class HomeSteps {

	WebDriver driver = PagesUtil.driver;
	HomePage page = PagesUtil.homePage;

	@Then("^The table is empty$")
	public void the_table_is_empty() {
		Assert.assertNull(this.page.getMissingGradeRows());
	}

	/**
	 * @param arg1 the week that was removed
	 */
	@Then("^The table is updated minus week \"([^\"]*)\"$")
	public void the_table_is_updated_minus_week(String arg1) {
		List<Integer> pillList = new LinkedList<>();
		for (WebElement pill : this.page.getWeeksContainer()
			.findElements(By.className("pillContent"))) {
			pillList.add(Integer.parseInt(pill.getText().split(" ")[1]));
		}
		List<WebElement> rows = this.page.getMissingGradeRows();
		for (WebElement webElement : rows) {
			boolean flag = false;
			for (WebElement week : webElement
				.findElements(By.tagName("span"))) {
				for (Integer i : pillList) {
					if (Integer.parseInt(week.getText()) == i) {
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			Assert.assertTrue(flag);
		}
	}

	/**
	 * @param arg1 the week that was added back
	 */
	@Then("^The table is updated plus week \"([^\"]*)\"$")
	public void the_table_is_updated_updated_plus_week(String arg1) {
		List<Integer> pillList = new LinkedList<>();
		for (WebElement pill : this.page.getWeeksContainer()
			.findElements(By.className("pillContent"))) {
			pillList.add(Integer.parseInt(pill.getText().split(" ")[1]));
		}
		List<WebElement> rows = this.page.getMissingGradeRows();
		for (WebElement webElement : rows) {
			boolean flag = false;
			for (WebElement week : webElement
				.findElements(By.tagName("span"))) {
				for (Integer i : pillList) {
					if (Integer.parseInt(week.getText()) == i) {
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			Assert.assertTrue(flag);
		}
	}

	/**
	 * @param arg1 the state or city that the user clicked on
	 */
	@Then("^The user can see stats for \"([^\"]*)\"$")
	public void the_user_can_see_stats_for(String arg1) {
		Assert.assertTrue(this.page.getLastQAstateDropdown()
			.getAttribute("value").equals(arg1)
			|| this.page.getCityDropdown().getText()
				.equals("All Cities\n" + arg1));
	}

	/**
	 * @param arg1 the week to be selected
	 */
	@When("^The user clicks a week \"([^\"]*)\"$")
	public void the_user_clicks_a_week(String arg1) {
		int week = Integer.parseInt(arg1);
		this.page.selectWeekSorterByIndex(week - 1);
	}

	/**
	 * @param arg1 the city that is to be clicked on
	 */
	@When("^The user clicks on city \"([^\"]*)\"$")
	public void the_user_clicks_on_city(String arg1) {
		this.page.selectLastQACity(arg1);
	}
	// Then The user can see stats for city

	/**
	 * @param arg1 the state that is to be clicked on
	 */
	@When("^The user clicks on state \"([^\"]*)\"$")
	public void the_user_clicks_on_state(String arg1) {
		this.page.selectLastQAState(arg1);
	}

	@When("^The user clicks on the Cities dropdown$")
	public void the_user_clicks_on_the_Cities_dropdown() {
		this.page.getCityDropdown().click();
	}

	@When("^The user clicks on the States dropdown$")
	public void the_user_clicks_on_the_States_dropdown() {
		this.page.getLastQAstateDropdown().click();
	}

	/**
	 * @param arg1 the week number that is to be removed
	 */
	@When("^The user removes week \"([^\"]*)\"$")
	public void the_user_clicks_on_week(String arg1) {
		int week = Integer.parseInt(arg1);
		this.page.getWeekByWeekNumber(week)
			.findElement(By.id("pills-pill-remove-week-button")).click();
	}

	@When("^The user clicks the include weeks button$")
	public void the_user_clicks_the_include_weeks_button() {
		this.page.weekSorterButton.click();
	}

	@When("^The user removes all weeks$")
	public void the_user_removes_all_weeks() {
		int weekNumber = (this.page.getWeeksContainer()
			.findElements(By.className("pillX")).size());
		for (int i = 0; i < weekNumber; i++) {
			this.page.getWeeksContainer()
				.findElement(By.id("pills-pill-remove-week-button")).click();
		}
	}

}
