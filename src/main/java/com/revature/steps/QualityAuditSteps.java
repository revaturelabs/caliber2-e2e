package com.revature.steps;

import com.revature.page.QualityAuditPage;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class QualityAuditSteps {

	WebDriver driver = PagesUtil.driver;
	QualityAuditPage qap = PagesUtil.qualityAuditPage;
	private static int cachedWeeks = 0;

	@When("^User clicks on Select Batch$")
	public void user_clicks_on_Select_Batch() throws Throwable {
		qap.selectBatchesDropdownButton.click();
	}

	@When("^User types \"([^\"]*)\" in search bar$")
	public void user_types_in_search_bar(String arg1) throws Throwable {
		qap.getBatchesSearchBarInput().click();
		qap.getBatchesSearchBarInput().sendKeys(arg1);
	}

	@When("^The User clicks the first option in the batch dropdown menu$")
	public void the_User_clicks_the_first_option_in_the_batch_dropdown_menu()
		throws Throwable {
		qap.getDropdownSelectBatchesContainer().findElement(By.tagName("a"))
			.click();
	}

	@Then("^The batch should be \"([^\"]*)\"$")
	public void the_batch_should_be(String arg1) throws Throwable {
		// qap.selectBatchesDropdown(arg1);

		Assert.assertEquals(arg1, qap.batchesDropdownOpenButton
			.findElement(By.tagName("a")).getText());
	}

	@When("^User selects a batch$")
	public void user_selects_a_batch() throws Throwable {

		List<WebElement> batches = qap.getDropdownSelectBatchesContainer()
			.findElements(By.tagName("a"));

		for (WebElement elem : batches) {
			if (elem.getText().contains("Dan Pickles - PEGA BPM - 10/7/2019")) {
				elem.click();
				break;
			}
		}
	}

	@When("^User selects the first batch$")
	public void user_selects_the_first_batch() throws Throwable {

		List<WebElement> batches = qap.getDropdownSelectBatchesContainer()
			.findElements(By.tagName("a"));

		batches.get(0).click();
	}

	@Then("^User views current trainees with results of technical skills and soft skills with notes of that week$")
	public void
		user_views_current_trainees_with_results_of_technical_skills_and_soft_skills_with_notes_of_that_week()
			throws Throwable {

		Assert.assertNotNull(qap.qualityAuditListTable);
	}

	@When("^User selects a week$")
	public void user_selects_a_week() throws Throwable {
		qap.selectWeek(1);

	}

	@When("^User selects star under technical skills of first trainee$")
	public void user_selects_star_under_technical_skills_of_first_trainee()
		throws Throwable {

		Thread.sleep(1000);
		qap.getAssociateTechSkillsButton(qap.getTraineeRowByIndex(1))
			.findElement(By.tagName("em")).click();
		Thread.sleep(1000);
		qap.getAssociateTechSkillsContainer(qap.getTraineeRowByIndex(1))
			.findElements(By.tagName("em")).get(4).click();

	}

	@Then("^First trainee has star in technical skills$")
	public void first_trainee_has_star_in_technical_skills() throws Throwable {

		Assert.assertTrue(
			qap.getAssociateTechSkillsButton(qap.getTraineeRowByIndex(1))
				.findElement(By.tagName("em")).getAttribute("class")
				.contains("star"));
	}

	@When("^User selects star under soft skills of first trainee$")
	public void user_selects_star_under_soft_skills_of_first_trainee()
		throws Throwable {
		Thread.sleep(1000);
		qap.getAssociateSoftSkillsButton(qap.getTraineeRowByIndex(1))
			.findElement(By.tagName("em")).click();
		Thread.sleep(1000);
		qap.getAssociateSoftSkillsContainer(qap.getTraineeRowByIndex(1))
			.findElements(By.tagName("em")).get(4).click();

	}

	@Then("^First trainee has star in soft skills$")
	public void first_trainee_has_star_in_soft_skills() throws Throwable {
		Assert.assertTrue(
			qap.getAssociateSoftSkillsButton(qap.getTraineeRowByIndex(1))
				.findElement(By.tagName("em")).getAttribute("class")
				.contains("star"));
	}

	@When("^User clicks flag icon beside trainee$")
	public void user_clicks_flag_icon_beside_trainee() throws Throwable {
		Thread.sleep(500);
		qap.getAssociateDetailsFlag(qap.getTraineeRowByIndex(1)).click();
	}

	@When("^User clicks Delete Comment button$")
	public void user_clicks_Delete_Comment_button() throws Throwable {
		qap.getDeleteCommentButton().click();
	}

	@When("^User clicks confirm delete button$")
	public void user_clicks_confirm_delete_button() throws Throwable {
		qap.getConfirmDeleteButton().click();
	}

	@Then("^comment is deleted from trainee$")
	public void comment_is_deleted_from_trainee() throws Throwable {

		Assert.assertTrue(qap.getTraineeRowByIndex(1)
			.findElements(By.id("associate-details-container-flag"))
			.size() == 0);

	}

	@When("^User clicks cancel button$")
	public void user_clicks_cancel_button() throws Throwable {
		qap.getCancelCommentButton().click();
	}

	/**
	 * this will test whether or not the update comment modal has closed
	 * 
	 * @throws Throwable If an error occurs
	 */
	@Then("^no changes are made$")
	public void no_changes_are_made() throws Throwable {

		Thread.sleep(1000);
		Assert.assertTrue(
			driver.findElements(By.id("associate-flag-dialog-cancel-button"))
				.size() == 0);

	}

	@When("^User selects smily face under overall QC Status$")
	public void user_selects_smily_face_under_overall_QC_Status()
		throws Throwable {
		Thread.sleep(1000);
		qap.getOverallQCFeedbackContainer()
			.findElement(By.id("qc-feedback-dropdown-toggle")).click();
		Thread.sleep(1000);

		for (WebElement elem : qap.getOverallQCFeedbackContainer()
			.findElement(By.id("qc-feedback-dropdown-toggle"))
			.findElement(By.id("qc-feedback-dropdown-container"))
			.findElements(By.tagName("em"))) {
			if (elem.getAttribute("class").contains("smile")) {
				elem.click();
			}
		}
	}

	@Then("^Smily face is displayed under overall QC Status$")
	public void smily_face_is_displayed_under_overall_QC_Status()
		throws Throwable {

		Assert.assertTrue(qap.getOverallQCFeedbackContainer()
			.findElement(By.id("qc-feedback-dropdown-toggle"))
			.findElement(By.tagName("em")).getAttribute("class")
			.contains("smile"));
	}

	@When("^User clicks \\+ button next to latest week$")
	public void user_clicks_button_next_to_latest_week() throws Throwable {

		cachedWeeks = qap.getWeekContainer().findElement(By.tagName("ul"))
			.findElements(By.tagName("li")).size();
		qap.getWeekContainer().findElement(By.tagName("ul"))
			.findElements(By.tagName("li")).get(cachedWeeks - 1).click();

	}

	@When("^User clicks no$")
	public void user_clicks_no() throws Throwable {
		Thread.sleep(1000);
		qap.selectAddWeekModalDeclineButton();
	}

	@Then("^no changes are made to page$")
	public void no_changes_are_made_to_page() throws Throwable {
		Assert.assertEquals(cachedWeeks,
			qap.getWeekContainer().findElement(By.tagName("ul"))
				.findElements(By.tagName("li")).size());
	}

	@When("^User clicks yes$")
	public void user_clicks_yes() throws Throwable {
		Thread.sleep(1000);
		qap.selectAddWeekModalAcceptButton();

	}

	@Then("^new week is added to page$")
	public void new_week_is_added_to_page() throws Throwable {
		Assert.assertTrue(qap.getWeekContainer().findElement(By.tagName("ul"))
			.findElements(By.tagName("li")).size() == (cachedWeeks + 1));
	}

	@When("^User clicks \\+ button next to categories this week:$")
	public void user_clicks_button_next_to_categories_this_week()
		throws Throwable {

		qap.getAddCategoryButton().click();
	}

	@When("^User clicks \"([^\"]*)\" from dropdown menu$")
	public void user_clicks_category_from_dropdown_menu(String arg1)
		throws Throwable {
		qap.selectCategoriesDropdownContainer(arg1);
	}

	@Then("^\"([^\"]*)\" tag is displayed on page$")
	public void category_tag_is_displayed_on_page(String arg1)
		throws Throwable {

		for (WebElement elem : driver
			.findElement(By.tagName("app-categories-this-week"))
			.findElements(By.tagName("span"))) {
			if (elem.getText().contains(arg1)) {
				Assert.assertTrue(true);
				break;
			}
		}

	}

	@When("^User clicks on notes text field$")
	public void user_clicks_on_notes_text_field() throws Throwable {
		qap.getTraineeRowByIndex(1).findElement(By.tagName("textarea")).click();
	}

	@When("^User deletes previous comment$")
	public void user_deletes_previous_comment() throws Throwable {
		qap.getTraineeRowByIndex(1).findElement(By.tagName("textarea")).clear();
	}

	@When("^User types \"([^\"]*)\" in notes section$")
	public void user_types_in_notes_section(String arg1) throws Throwable {
		qap.getTraineeRowByIndex(1).findElement(By.tagName("textarea"))
			.sendKeys(arg1);
	}

	@Then("^First trainee notes should be \"([^\"]*)\"$")
	public void first_trainee_notes_should_be(String arg1) throws Throwable {
		Thread.sleep(1000);
		String result = qap.getTraineeRowByIndex(1)
			.findElement(By.tagName("textarea")).getAttribute("value");
		Assert.assertEquals(arg1, result);
	}

	@When("^User clicks pencil icon beside trainee$")
	public void user_clicks_pencil_icon_beside_trainee() throws Throwable {

		Actions action = new Actions(driver);
		action.moveToElement(
			qap.getAssociateDetailsContainer(qap.getTraineeRowByIndex(1))
				.findElement(By.id("associate-details-trainee-name")));
		Thread.sleep(333);
		action.perform();
		qap.getAssociateDetailsPen(qap.getTraineeRowByIndex(1)).click();

	}

	@When("^User clicks Green flag$")
	public void user_clicks_Green_flag() throws Throwable {
		qap.getGreenFlag().click();

	}

	@When("^User types \"([^\"]*)\" in comment section$")
	public void user_types_in_comment_section(String arg1) throws Throwable {
		qap.getTrainerCommentInput().clear();
		qap.getTrainerCommentInput().sendKeys(arg1);

	}

	@When("^User clicks Update Comment button$")
	public void user_clicks_Update_Comment_button() throws Throwable {
		qap.getCreateCommentButton().click();

	}

	@Then("^Comment \"([^\"]*)\" added with green/red flag icon beside Trainee$")
	public void comment_added_with_green_red_flag_icon_beside_Trainee(
		String arg1) throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(
			qap.getAssociateDetailsFlag(qap.getTraineeRowByIndex(1)));
		actions.perform();
		Thread.sleep(333);
		String result = qap.getTraineeRowByIndex(1)
			.findElement(By.tagName("bs-tooltip-container")).getText();

		Assert.assertEquals(arg1, result);
	}

	@When("^User selects \"([^\"]*)\" in year dropbox$")
	public void user_selects_in_year_dropbox(String arg1) throws Throwable {
		Thread.sleep(333);
		qap.getYearsDropdownButton().click();
		Thread.sleep(333);
		qap.selectYearsDropdown(Integer.parseInt(arg1));
	}

	@When("^User selects \"([^\"]*)\" in quarter dropbox$")
	public void user_selects_in_quarter_dropbox(String arg1) throws Throwable {
		Thread.sleep(333);
		qap.getQuartersDropdownButton().click();
		Thread.sleep(333);
		qap.selectQuartersDropdown(arg1);
	}

	@Then("^batch \"([^\"]*)\" should be displayed$")
	public void batch_should_be_displayed(String arg1) throws Throwable {
		Assert.assertEquals(arg1, qap.batchesDropdownOpenButton
			.findElement(By.tagName("a")).getText());
	}

	@Then("^No batches found should be displayed$")
	public void no_batches_found_should_be_displayed() throws Throwable {
		Assert.assertTrue(qap.selectBatchesDropdownButton.getText()
			.contains("No Batches Found"));
	}

	@When("^User types \"([^\"]*)\" in Overall QC Feedback section$")
	public void user_types_in_Overall_QC_Feedback_section(String arg1)
		throws Throwable {
		Thread.sleep(500);
		qap.getOverallQCFeedbackContainer().findElement(By.tagName("textarea"))
			.clear();
		Thread.sleep(500);
		qap.getOverallQCFeedbackContainer().findElement(By.tagName("textarea"))
			.sendKeys(arg1);
	}

	@Then("^feedback should display \"([^\"]*)\"$")
	public void feedback_should_display(String arg1) throws Throwable {
		Assert.assertEquals(arg1, qap.getOverallQCFeedbackContainer()
			.findElement(By.tagName("textarea")).getAttribute("value"));
	}

	@When("^User clicks save button$")
	public void user_clicks_save_button() throws Throwable {
		Thread.sleep(500);
		qap.getSaveButton().click();
	}

	@Then("^Changes saved to page$")
	public void changes_saved_to_page() throws Throwable {

	}

}
