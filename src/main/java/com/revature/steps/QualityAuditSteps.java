package com.revature.steps;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.page.NavigationBar;
import com.revature.page.QualityAuditPage;
import com.revature.utils.PagesUtil;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import junit.framework.Assert;

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

	@Then("^The batch should be \"([^\"]*)\"$")
	public void the_batch_should_be(String arg1) throws Throwable {
	    qap.selectBatchesDropdown(arg1);
	   
	    
	    Assert.assertEquals(driver.findElement(By.id("batch-select-dropdown-list")).findElement(By.tagName("a")).getText(), 
	    		qap.selectBatchesDropdownButton.findElement(By.tagName("a")).getText());
	}

	@When("^User selects a batch$")
	public void user_selects_a_batch() throws Throwable {
		
		List<WebElement> batches = qap.getDropdownSelectBatchesContainer().findElements(By.tagName("a"));
		
		for(WebElement elem : batches) {
			if(elem.getText().contains("Dan Pickles - PEGA BPM - 10/7/2019")) {
				elem.click();
				break;
			}
		}
	}


	@Then("^User views current trainees with results of technical skills and soft skills with notes of that week$")
	public void user_views_current_trainees_with_results_of_technical_skills_and_soft_skills_with_notes_of_that_week() throws Throwable {
	    
		Assert.assertNotNull(qap.qualityAuditListTable);
	}

	@When("^User selects a week$")
	public void user_selects_a_week() throws Throwable {
		qap.selectWeek(1);

	}

	@When("^User selects star under technical skills of first trainee$")
	public void user_selects_star_under_technical_skills_of_first_trainee() throws Throwable {
	    qap.getAssociateTechSkillsButton(qap.getTraineeRowByIndex(0)).click();
	    qap.getAssociateTechSkillsContainer(qap.getTraineeRowByIndex(0)).findElements(By.tagName("em")).get(4).click();
	    
	}

	@Then("^First trainee has star in technical skills$")
	public void first_trainee_has_star_in_technical_skills() throws Throwable {

		Assert.assertTrue(qap.getAssociateTechSkillsButton(qap.getTraineeRowByIndex(1)).getAttribute("class").contains("star"));
	}

	@When("^User selects star under soft skills of first trainee$")
	public void user_selects_star_under_soft_skills_of_first_trainee() throws Throwable {
	    qap.getAssociateSoftSkillsButton(qap.getTraineeRowByIndex(1)).click();
	    qap.getAssociateSoftSkillsContainer(qap.getTraineeRowByIndex(1)).findElements(By.tagName("em")).get(4).click();
	}

	@Then("^First trainee has star in soft skills$")
	public void first_trainee_has_star_in_soft_skills() throws Throwable {
		Assert.assertTrue(qap.getAssociateSoftSkillsButton(qap.getTraineeRowByIndex(1)).getAttribute("class").contains("star"));
	}
	
	@When("^User clicks flag icon beside trainee$")
	public void user_clicks_flag_icon_beside_trainee() throws Throwable {
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
	    Assert.assertNull(qap.getAssociateDetailsFlag(qap.getTraineeRowByIndex(1)));
	}

	@When("^User clicks pencil icon beside trainee$")
	public void user_clicks_pencil_icon_beside_trainee() throws Throwable {
	    qap.getAssociateDetailsPen(qap.getTraineeRowByIndex(1)).click();
	}

	@When("^User clicks cancel button$")
	public void user_clicks_cancel_button() throws Throwable {
	    qap.getCancelCommentButton().click();
	}

	@Then("^no changes are made$")
	public void no_changes_are_made() throws Throwable {
	    try{
	    	driver.findElement(By.id("comment"));
	    	Assert.fail();
	    	}catch(NoSuchElementException e){
	    	
	    }
	    
	    
	}

	@When("^User selects smily face under overall QC Status$")
	public void user_selects_smily_face_under_overall_QC_Status() throws Throwable {
	    qap.getQcFeedbackDropdownButton().click();
	}

	@Then("^Smily face is displayed under overall QC Status$")
	public void smily_face_is_displayed_under_overall_QC_Status() throws Throwable {

		Assert.assertNotNull(qap.getQcFeedbackDropdownContainer());
	}

	@When("^User clicks \\+ button next to latest week$")
	public void user_clicks_button_next_to_latest_week() throws Throwable {
		
		cachedWeeks = qap.weekContainer.findElements(By.tagName("ul")).size();
		qap.selectAddWeekButton().click();
	}

	@When("^User clicks no$")
	public void user_clicks_no() throws Throwable {
	    qap.selectAddWeekModalDeclineButton();
	}

	@Then("^no changes are made to page$")
	public void no_changes_are_made_to_page() throws Throwable {
		Assert.assertEquals(cachedWeeks, qap.weekContainer.findElements(By.tagName("ul")).size());
	}

	@When("^User clicks yes$")
	public void user_clicks_yes() throws Throwable {
		
	    qap.selectAddWeekModalAcceptButton();
	    
	}

	@Then("^new week is added to page$")
	public void new_week_is_added_to_page() throws Throwable {
		Assert.assertTrue(qap.weekContainer.findElements(By.tagName("ul")).size() == (cachedWeeks + 1));
	}


	@When("^User clicks \\+ button next to categories this week:$")
	public void user_clicks_button_next_to_categories_this_week() throws Throwable {
	    qap.addCategoryButton.click();;
	}

	@When("^User clicks \"([^\"]*)\" from dropdown menu$")
	public void user_clicks_category_from_dropdown_menu(String arg1) throws Throwable {
	    qap.selectCategoriesDropdownContainer(arg1);
	}

	@Then("^\"([^\"]*)\" tag is displayed on page$")
	public void category_tag_is_displayed_on_page(String arg1) throws Throwable {
		
		for(WebElement elem : driver.findElement(By.tagName("app-categories-this-week")).findElements(By.tagName("span"))) {
			if(elem.getText().contains(arg1)) {
				Assert.assertTrue(true);
				break;
			}
		}

	}

	@When("^User clicks save button$")
	public void user_clicks_save_button() throws Throwable {
		qap.getSaveButton().click();
	}

	@Then("^Changes saved to page$")
	public void changes_saved_to_page() throws Throwable {
	    
	}
	
}
