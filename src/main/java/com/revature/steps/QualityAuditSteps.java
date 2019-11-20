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

	private static int cachedWeeks = 0;
	WebDriver driver = PagesUtil.driver;
	QualityAuditPage qap = PagesUtil.qualityAuditPage;

	@Then("^batch \"([^\"]*)\" should be displayed$")
	public void batch_should_be_displayed(String arg1) throws Throwable {
		Assert.assertEquals(arg1, this.qap.batchesDropdownOpenButton
			.findElement(By.tagName("a")).getText());
	}

	@Then("^\"([^\"]*)\" tag is displayed on page$")
	public void category_tag_is_displayed_on_page(String arg1)
		throws Throwable {

		for (WebElement elem : this.driver
			.findElement(By.tagName("app-categories-this-week"))
			.findElements(By.tagName("span"))) {
			if (elem.getText().contains(arg1)) {
				Assert.assertTrue(true);
				break;
			}
		}

	}

	@Then("^Changes saved to page$")
	public void changes_saved_to_page() throws Throwable {

	}

	@Then("^Comment \"([^\"]*)\" added with green/red flag icon beside Trainee$")
	public void comment_added_with_green_red_flag_icon_beside_Trainee(
		String arg1) throws Throwable {
		Actions actions = new Actions(this.driver);
		actions
			.moveToElement(this.qap
				.getAssociateDetailsFlag(this.qap.getTraineeRowByIndex(1)))
			.perform();
		Thread.sleep(333);
		String result = this.qap.getTraineeRowByIndex(1)
			.findElement(By.tagName("bs-tooltip-container")).getText();

		Assert.assertEquals(arg1, result);
	}

	@Then("^comment is deleted from trainee$")
	public void comment_is_deleted_from_trainee() throws Throwable {

		Assert.assertTrue(this.qap.getTraineeRowByIndex(1)
			.findElements(By.id("associate-details-container-flag"))
			.size() == 0);

	}

	@Then("^feedback should display \"([^\"]*)\"$")
	public void feedback_should_display(String arg1) throws Throwable {
		Assert.assertEquals(arg1, this.qap.getOverallQCFeedbackContainer()
			.findElement(By.tagName("textarea")).getAttribute("value"));
	}

	@Then("^First trainee has star in soft skills$")
	public void first_trainee_has_star_in_soft_skills() throws Throwable {
		Assert.assertTrue(this.qap
			.getAssociateSoftSkillsButton(this.qap.getTraineeRowByIndex(1))
			.findElement(By.tagName("em")).getAttribute("class")
			.contains("star"));
	}

	@Then("^First trainee has star in technical skills$")
	public void first_trainee_has_star_in_technical_skills() throws Throwable {

		Assert.assertTrue(this.qap
			.getAssociateTechSkillsButton(this.qap.getTraineeRowByIndex(1))
			.findElement(By.tagName("em")).getAttribute("class")
			.contains("star"));
	}

	@Then("^First trainee notes should be \"([^\"]*)\"$")
	public void first_trainee_notes_should_be(String arg1) throws Throwable {
		Thread.sleep(1000);
		String result = this.qap.getTraineeRowByIndex(1)
			.findElement(By.tagName("textarea")).getAttribute("value");
		Assert.assertEquals(arg1, result);
	}

	@Then("^new week is added to page$")
	public void new_week_is_added_to_page() throws Throwable {
		Assert.assertTrue(this.qap.getWeekContainer()
			.findElement(By.tagName("ul")).findElements(By.tagName("li"))
			.size() == (QualityAuditSteps.cachedWeeks + 1));
	}

	@Then("^No batches found should be displayed$")
	public void no_batches_found_should_be_displayed() throws Throwable {
		Assert.assertTrue(this.qap.selectBatchesDropdownButton.getText()
			.contains("No Batches Found"));
	}

	/**
	 * this will test whether or not the update comment modal has closed
	 *
	 * @throws Throwable If an error occurs
	 */
	@Then("^no changes are made$")
	public void no_changes_are_made() throws Throwable {

		Thread.sleep(1000);
		Assert.assertTrue(this.driver
			.findElements(By.id("associate-flag-dialog-cancel-button"))
			.size() == 0);

	}

	@Then("^no changes are made to page$")
	public void no_changes_are_made_to_page() throws Throwable {
		Assert.assertEquals(QualityAuditSteps.cachedWeeks,
			this.qap.getWeekContainer().findElement(By.tagName("ul"))
				.findElements(By.tagName("li")).size());
	}

	@Then("^Smily face is displayed under overall QC Status$")
	public void smily_face_is_displayed_under_overall_QC_Status()
		throws Throwable {

		Assert.assertTrue(this.qap.getOverallQCFeedbackContainer()
			.findElement(By.id("qc-feedback-dropdown-toggle"))
			.findElement(By.tagName("em")).getAttribute("class")
			.contains("smile"));
	}

	@Then("^The batch should be \"([^\"]*)\"$")
	public void the_batch_should_be(String arg1) throws Throwable {
		// qap.selectBatchesDropdown(arg1);

		Assert.assertEquals(arg1, this.qap.batchesDropdownOpenButton
			.findElement(By.tagName("a")).getText());
	}

	@When("^The User clicks the first option in the batch dropdown menu$")
	public void the_User_clicks_the_first_option_in_the_batch_dropdown_menu()
		throws Throwable {
		this.qap.getDropdownSelectBatchesContainer()
			.findElement(By.tagName("a")).click();
	}

	@When("^User clicks \\+ button next to categories this week:$")
	public void user_clicks_button_next_to_categories_this_week()
		throws Throwable {

		this.qap.getAddCategoryButton().click();
	}

	@When("^User clicks \\+ button next to latest week$")
	public void user_clicks_button_next_to_latest_week() throws Throwable {

		QualityAuditSteps.cachedWeeks =
			this.qap.getWeekContainer().findElement(By.tagName("ul"))
				.findElements(By.tagName("li")).size();
		this.qap.getWeekContainer().findElement(By.tagName("ul"))
			.findElements(By.tagName("li"))
			.get(QualityAuditSteps.cachedWeeks - 1).click();

	}

	@When("^User clicks cancel button$")
	public void user_clicks_cancel_button() throws Throwable {
		this.qap.getCancelCommentButton().click();
	}

	@When("^User clicks \"([^\"]*)\" from dropdown menu$")
	public void user_clicks_category_from_dropdown_menu(String arg1)
		throws Throwable {
		this.qap.selectCategoriesDropdownContainer(arg1);
	}

	@When("^User clicks confirm delete button$")
	public void user_clicks_confirm_delete_button() throws Throwable {
		this.qap.getConfirmDeleteButton().click();
	}

	@When("^User clicks Delete Comment button$")
	public void user_clicks_Delete_Comment_button() throws Throwable {
		this.qap.getDeleteCommentButton().click();
	}

	@When("^User clicks flag icon beside trainee$")
	public void user_clicks_flag_icon_beside_trainee() throws Throwable {
		Thread.sleep(500);
		this.qap.getAssociateDetailsFlag(this.qap.getTraineeRowByIndex(1))
			.click();
	}

	@When("^User clicks Green flag$")
	public void user_clicks_Green_flag() throws Throwable {
		this.qap.getGreenFlag().click();

	}

	@When("^User clicks no$")
	public void user_clicks_no() throws Throwable {
		Thread.sleep(1000);
		this.qap.selectAddWeekModalDeclineButton();
	}

	@When("^User clicks on notes text field$")
	public void user_clicks_on_notes_text_field() throws Throwable {
		this.qap.getTraineeRowByIndex(1).findElement(By.tagName("textarea"))
			.click();
	}

	@When("^User clicks on Select Batch$")
	public void user_clicks_on_Select_Batch() throws Throwable {
		this.qap.selectBatchesDropdownButton.click();
	}

	@When("^User clicks pencil icon beside trainee$")
	public void user_clicks_pencil_icon_beside_trainee() throws Throwable {

		Actions action = new Actions(this.driver);
		action.moveToElement(this.qap
			.getAssociateDetailsContainer(this.qap.getTraineeRowByIndex(1))
			.findElement(By.id("associate-details-trainee-name")));
		Thread.sleep(333);
		action.perform();
		this.qap.getAssociateDetailsPen(this.qap.getTraineeRowByIndex(1))
			.click();

	}

	@When("^User clicks save button$")
	public void user_clicks_save_button() throws Throwable {
		Thread.sleep(500);
		this.qap.getSaveButton().click();
	}

	@When("^User clicks Update Comment button$")
	public void user_clicks_Update_Comment_button() throws Throwable {
		this.qap.getCreateCommentButton().click();

	}

	@When("^User clicks yes$")
	public void user_clicks_yes() throws Throwable {
		Thread.sleep(1000);
		this.qap.selectAddWeekModalAcceptButton();

	}

	@When("^User deletes previous comment$")
	public void user_deletes_previous_comment() throws Throwable {
		this.qap.getTraineeRowByIndex(1).findElement(By.tagName("textarea"))
			.clear();
	}

	@When("^User selects a batch$")
	public void user_selects_a_batch() throws Throwable {

		List<WebElement> batches = this.qap.getDropdownSelectBatchesContainer()
			.findElements(By.tagName("a"));

		for (WebElement elem : batches) {
			if (elem.getText().contains("Dan Pickles - PEGA BPM - 10/7/2019")) {
				elem.click();
				break;
			}
		}
	}

	@When("^User selects a week$")
	public void user_selects_a_week() throws Throwable {
		this.qap.selectWeek(1);

	}

	@When("^User selects \"([^\"]*)\" in quarter dropbox$")
	public void user_selects_in_quarter_dropbox(String arg1) throws Throwable {
		Thread.sleep(333);
		this.qap.getQuartersDropdownButton().click();
		Thread.sleep(333);
		this.qap.selectQuartersDropdown(arg1);
	}

	@When("^User selects \"([^\"]*)\" in year dropbox$")
	public void user_selects_in_year_dropbox(String arg1) throws Throwable {
		Thread.sleep(333);
		this.qap.getYearsDropdownButton().click();
		Thread.sleep(333);
		this.qap.selectYearsDropdown(Integer.parseInt(arg1));
	}

	@When("^User selects smily face under overall QC Status$")
	public void user_selects_smily_face_under_overall_QC_Status()
		throws Throwable {
		Thread.sleep(1000);
		this.qap.getOverallQCFeedbackContainer()
			.findElement(By.id("qc-feedback-dropdown-toggle")).click();
		Thread.sleep(1000);

		for (WebElement elem : this.qap.getOverallQCFeedbackContainer()
			.findElement(By.id("qc-feedback-dropdown-toggle"))
			.findElement(By.id("qc-feedback-dropdown-container"))
			.findElements(By.tagName("em"))) {
			if (elem.getAttribute("class").contains("smile")) {
				elem.click();
			}
		}
	}

	@When("^User selects star under soft skills of first trainee$")
	public void user_selects_star_under_soft_skills_of_first_trainee()
		throws Throwable {
		Thread.sleep(1000);
		this.qap.getAssociateSoftSkillsButton(this.qap.getTraineeRowByIndex(1))
			.findElement(By.tagName("em")).click();
		Thread.sleep(1000);
		this.qap
			.getAssociateSoftSkillsContainer(this.qap.getTraineeRowByIndex(1))
			.findElements(By.tagName("em")).get(4).click();

	}

	@When("^User selects star under technical skills of first trainee$")
	public void user_selects_star_under_technical_skills_of_first_trainee()
		throws Throwable {

		Thread.sleep(1000);
		this.qap.getAssociateTechSkillsButton(this.qap.getTraineeRowByIndex(1))
			.findElement(By.tagName("em")).click();
		Thread.sleep(1000);
		this.qap
			.getAssociateTechSkillsContainer(this.qap.getTraineeRowByIndex(1))
			.findElements(By.tagName("em")).get(4).click();

	}

	@When("^User selects the first batch$")
	public void user_selects_the_first_batch() throws Throwable {

		List<WebElement> batches = this.qap.getDropdownSelectBatchesContainer()
			.findElements(By.tagName("a"));

		batches.get(0).click();
	}

	@When("^User types \"([^\"]*)\" in comment section$")
	public void user_types_in_comment_section(String arg1) throws Throwable {
		this.qap.getTrainerCommentInput().clear();
		this.qap.getTrainerCommentInput().sendKeys(arg1);

	}

	@When("^User types \"([^\"]*)\" in notes section$")
	public void user_types_in_notes_section(String arg1) throws Throwable {
		this.qap.getTraineeRowByIndex(1).findElement(By.tagName("textarea"))
			.sendKeys(arg1);
	}

	@When("^User types \"([^\"]*)\" in Overall QC Feedback section$")
	public void user_types_in_Overall_QC_Feedback_section(String arg1)
		throws Throwable {
		Thread.sleep(500);
		this.qap.getOverallQCFeedbackContainer()
			.findElement(By.tagName("textarea")).clear();
		Thread.sleep(500);
		this.qap.getOverallQCFeedbackContainer()
			.findElement(By.tagName("textarea")).sendKeys(arg1);
	}

	@When("^User types \"([^\"]*)\" in search bar$")
	public void user_types_in_search_bar(String arg1) throws Throwable {
		this.qap.getBatchesSearchBarInput().click();
		this.qap.getBatchesSearchBarInput().sendKeys(arg1);
	}

	@Then("^User views current trainees with results of technical skills and soft skills with notes of that week$")
	public void
		user_views_current_trainees_with_results_of_technical_skills_and_soft_skills_with_notes_of_that_week()
			throws Throwable {

		Assert.assertNotNull(this.qap.qualityAuditListTable);
	}

}
