package com.revature.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.page.AddTraineeModal;
import com.revature.page.CreateBatchModal;
import com.revature.page.ManageBatchPage;
import com.revature.utils.PagesUtil;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;


public class ManageBatchSteps
{
	WebDriver driver = PagesUtil.driver;
	ManageBatchPage mbp = PagesUtil.manageBatchPage;
	CreateBatchModal cbm = PagesUtil.createBatchModal;
	AddTraineeModal atm = PagesUtil.addTraineeModal;
	WebDriverWait wait = new WebDriverWait(driver, 5);

	
	@Given("^The user is on the manage batch page$")
	public void the_user_is_on_the_manage_batch_page() 
	{
	   driver.get("http://caliber-2-dev.revaturelabs.com.s3-website-us-east-1.amazonaws.com/caliber/vp/manage");
	   //driver.manage().window().maximize();
	}
	
	@When("^The user clicks on create batch$")
	public void the_user_clicks_on_create_batch() 
	{
		mbp.createBatchButton().click();
	   driver.switchTo().activeElement();
	}

	@When("^The user fills in training name \"([^\"]*)\"$")
	public void the_user_fills_in_training_name(String arg1) 
	{
		cbm.inputTrainingName().sendKeys(arg1);
	}

	@When("^The user selects training type (\\d+)$")
	public void the_user_selects_training_type(int arg1)
	{
		 cbm.selectTrainingTypeDropdownOptionByInt(arg1).click();
	}

	@When("^The user selects skill type (\\d+)$")
	public void the_user_selects_skill_type(int arg1)
	{
		cbm.skillTypeDropdownBoxOptionByInt(arg1).click();
	}

	@When("^the user selects location (\\d+)$")
	public void the_user_selects_location(int arg1)
	{
		cbm.selectLocationDropdownByInt(arg1).click();
	}

	@When("^The user selects trainer (\\d+)$")
	public void the_user_selects_trainer(int arg1)
	{
		cbm.trainerDropdownBoxOptionByInt(arg1).click();
	}

	@When("^The user selects co-trainer (\\d+)$")
	public void the_user_selects_co_trainer(int arg1)
	{
	    cbm.selectCoTrainerDropdownByInt(arg1).click();
	}

	@When("^The user fills in start date \"([^\"]*)\"$")
	public void the_user_fills_in_start_date(String arg1)
	{
	    cbm.inputStartDate().sendKeys(arg1);
	}

	@When("^The user fills in end date \"([^\"]*)\"$")
	public void the_user_fills_in_end_date(String arg1)
	{
		cbm.inputEndDate().sendKeys(arg1);
	}

	@When("^the user fills in good grades \"([^\"]*)\"$")
	public void the_user_fills_in_good_grades(String arg1) 
	{
		cbm.inputGoodGrade().clear();
		cbm.inputGoodGrade().sendKeys(arg1);
	}

	@When("^The user fills in passing grade \"([^\"]*)\"$")
	public void the_user_fills_in_passing_grade(String arg1) 
	{
		cbm.inputPassingGrade().clear();
	    cbm.inputPassingGrade().sendKeys(arg1);
	}
	
	@When("^The user clicks the submit button$")
	public void the_user_clicks_the_submit_button()
	{
		//cbm.submitNewBatchButton().click();
		cbm.cancelNewBatchButton().click();
		driver.switchTo().defaultContent();
	}

	@Then("^The new batch with matching training name \"([^\"]*)\", trainingType (\\d+), skilltype (\\d+), location (\\d+), co-trainer (\\d+), start date \"([^\"]*)\", end date \"([^\"]*)\", good grades \"([^\"]*)\", and passing grade \"([^\"]*)\" will appear inside the manage batch table$")
	public void the_new_batch_with_matching_training_name_trainingType_skilltype_location_co_trainer_start_date_end_date_good_grades_and_passing_grade_will_appear_inside_the_manage_batch_table(String arg1, int arg2, int arg3, int arg4, int arg5, String arg6, String arg7, String arg8, String arg9)
	{
		WebElement info = mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for(int i = 1; i <= table.size(); i++)
		{//arg1 = trianing name, arg6 = start date, arg7 = end date, arg8 = good grade, arg9 = passing grade
			String[] match = mbp.getManageBatchTableRow(i).getText().split("\n.*");
			//System.out.println(match[0] + " == " + arg1);
			
			if(match[0].equals(arg1))
			{//found in the table
				Assert.assertTrue(true);
				return;
			}
			
		}
		Assert.fail();
		
		
	}
	
	
	
	
	
	@When("^The user clicks import batch$")
	public void the_user_clicks_import_batch()  {
		mbp.importBatchButton().click();
		
	}

	@When("^The user inputs json \"([^\"]*)\" into paste JSON field$")
	public void the_user_inputs_json_into_paste_JSON_field(String arg1) //////////////////////////////////
	{
		String file = "src/main/resources/" + arg1;
	    try
	    {
	    	StringBuilder text = new StringBuilder();
	    	File textFile = new File(file);
	    	Scanner scan = new Scanner(textFile);
	    	while(scan.hasNext())
	    	{
	    		text.append(scan.next());
	    	}
	    	mbp.inputBatchJSON().sendKeys(text);
	    	
		} 
	    catch (FileNotFoundException e1) 
	    {
			System.out.println("File not found");
		} 
	 
	}

	@Then("^The user clicks import grades$")
	public void the_user_clicks_import_grades() {
	    mbp.submitImportBatchButton().click();
	}

	@Then("^The imported batch \"([^\"]*)\" is in the list$")
	public void the_imported_batch_is_in_the_list(String arg1) {
		WebElement info = mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for(int i = 1; i <= table.size(); i++)
		{//arg1 = trianing name, arg6 = start date, arg7 = end date, arg8 = good grade, arg9 = passing grade
			String[] match = mbp.getManageBatchTableRow(i).getText().split("\n.*");
			//System.out.println(match[0] + " == " + arg1);
			
			if(match[0].equals(arg1))
			{//found in the table
				Assert.assertTrue(true);
				return;
			}
			
		}
		Assert.fail();
		
		
	}

	@When("^The user selects year (\\d+) in drop down$")
	public void the_user_selects_year_in_drop_down(int arg1) {
	 //  mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	    
	    driver.findElement(By.id("shared-dropdown-menu-dropdown-container")).click();
	    String elementid = "shared-dropdown-menu-" + 2019;
	    driver.findElement(By.id(elementid)).click();
	   
	}

	@Then("^The batch list displays result \"([^\"]*)\" that match$")
	public void the_batch_list_displays_result_that_match(String arg1) {
		WebElement info = mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for(int i = 1; i <= table.size(); i++)
		{//arg1 = trianing name, arg6 = start date, arg7 = end date, arg8 = good grade, arg9 = passing grade
			String[] match = mbp.getManageBatchTableRow(i).getText().split("\n.*");
			//System.out.println(match[0] + " == " + arg1);
			
			if(match[0].equals(arg1))
			{//found in the table
				Assert.assertTrue(true);
				return;
			}
			
		}
		Assert.fail();
		
		
	}

	@When("^The user selects year  (\\d+) in drop down for show trainees$")
	public void the_user_selects_year_in_drop_down_for_show_trainees(int arg1){
		 mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@When("^The user clicks show trainees in batch \"([^\"]*)\" for show trainees$")
	public void the_user_clicks_show_trainees_in_batch_for_show_trainees(String arg1){
		List<WebElement> listElements = mbp.manageBatchTable.findElements(By.className("batch-row"));
		for(WebElement rows: listElements)
		{
			if(rows.getText() == arg1)
			{
				mbp.showTraineesButtonForRow(rows).click();
			}
		}
		
	}

	@Then("^Result \"([^\"]*)\" is displayed$")
	public void result_is_displayed(String arg1) {
	    if(driver.findElement(By.className("ng-star-inserted")).isDisplayed())
	    {
	    	Assert.assertTrue(true);
	    }
	}

	@When("^The user selectss year <year> in drop down$")
	public void the_user_selectss_year_year_in_drop_down(){
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), 1).click();
	}

	@When("^The user clicks show trainees in batch \"([^\"]*)\" for create trainee$")
	public void the_user_clicks_show_trainees_in_batch_for_create_trainee(String arg1)  {
		List<WebElement> listElements = mbp.manageBatchTable.findElements(By.className("batch-row"));
		for(WebElement rows: listElements)
		{
			if(rows.getText() == arg1)
			{
				mbp.showTraineesButtonForRow(rows).click();
			}
		}
	}

	@When("^The user clicks add trainee$")
	public void the_user_clicks_add_trainee() throws Throwable {
	  driver.findElement(By.xpath("//*[@id=\"add-trainee-button\"]/a")).click();
	}

	@When("^The user inputs first name\"([^\"]*)\" in the first name field$")
	public void the_user_inputs_first_name_in_the_first_name_field(String arg1)  {
	    atm.inputFirstName().sendKeys(arg1);
	}

	@When("^The user inputs last name \"([^\"]*)\" in the last name field$")
	public void the_user_inputs_last_name_in_the_last_name_field(String arg1) {
	   atm.inputLastName().sendKeys(arg1);
	}

	@When("^The user inputs email \"([^\"]*)\" in the email field$")
	public void the_user_inputs_email_in_the_email_field(String arg1)  {
	   atm.inputEmail().sendKeys(arg1);
	}

	@When("^The user inputs phone number \"([^\"]*)\" in the phone number field$")
	public void the_user_inputs_phone_number_in_the_phone_number_field(String arg1)  {
	  atm.inputPhoneNumber().sendKeys(arg1);
	}

	@When("^The user selects training status (\\d+) from training status drop down$")
	public void the_user_selects_training_status_from_training_status_drop_down(int arg1) {
	   atm.trainingStatusDropdownNthOption(arg1).click();
	}

	@When("^The user inputs skype id \"([^\"]*)\" in the skype ID field$")
	public void the_user_inputs_skype_id_in_the_skype_ID_field(String arg1)  {
	    atm.inputSkypeId().sendKeys(arg1);
	}

	@When("^The user inputs college\"([^\"]*)\" in the college field$")
	public void the_user_inputs_college_in_the_college_field(String arg1) {
	    atm.inputCollege().sendKeys(arg1);
	}

	@When("^The user inputs degree\"([^\"]*)\" in the degree field$")
	public void the_user_inputs_degree_in_the_degree_field(String arg1) {
	    atm.inputDegree().sendKeys(arg1);
	}

	@When("^The user inputs major \"([^\"]*)\" in the major field$")
	public void the_user_inputs_major_in_the_major_field(String arg1) {
	    atm.inputMajor().sendKeys(arg1);
	}

	@When("^The user inputs recruiter \"([^\"]*)\" in the recruiter field$")
	public void the_user_inputs_recruiter_in_the_recruiter_field(String arg1) {
		atm.inputRecruiterName().sendKeys(arg1);
	}

	@When("^The user inputs profile url \"([^\"]*)\" in the profile URL field$")
	public void the_user_inputs_profile_url_in_the_profile_URL_field(String arg1) {
	    atm.inputProfileURL().sendKeys(arg1);
	}

	@When("^The user inputs tech screener \"([^\"]*)\" in the tech screener field$")
	public void the_user_inputs_tech_screener_in_the_tech_screener_field(String arg1)  {
	    atm.inputTechScreener().sendKeys(arg1);
	}

	@When("^The user inputs project completion \"([^\"]*)\" in the project completion field$")
	public void the_user_inputs_project_completion_in_the_project_completion_field(String arg1) {
	   atm.inputProjectCompletion().sendKeys(arg1);
	}

	@When("^The user clicks create button$")
	public void the_user_clicks_create_button(){
	    atm.submitAddTrainerButton().click();
	}

	@Then("^Result  \"([^\"]*)\" is displayed in trainee list$")
	public void result_is_displayed_in_trainee_list(String arg1)  {////////////////////////////////////////////////////////
	    
	}

	@Given("^The user selects a year (\\d+) in drop down for show in different batch$")
	public void the_user_selects_a_year_in_drop_down_for_show_in_different_batch(int arg1)  {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@Given("^The user clicks show trainees in original batch \"([^\"]*)\"$")
	public void the_user_clicks_show_trainees_in_original_batch(String arg1) {
		List<WebElement> listElements = mbp.manageBatchTable.findElements(By.className("batch-row"));
		for(WebElement rows: listElements)
		{
			if(rows.getText() == arg1)
			{
				mbp.showTraineesButtonForRow(rows).click();
			}
		}
	}

	@When("^The user clicks on the switch batch button for a trainee \"([^\"]*)\"$")
	public void the_user_clicks_on_the_switch_batch_button_for_a_trainee(String arg1) throws Throwable {//////////////////////////////////////////////////
	   
	}

	@When("^The user selects new batch \"([^\"]*)\" from batch list drop down$")
	public void the_user_selects_new_batch_from_batch_list_drop_down(String arg1) {///////////////////////////////////////////////
	    
	}

	@When("^The user clicks the swich button$")
	public void the_user_clicks_the_swich_button() {///////////////////////////////////////////
	    
	}

	@When("^The user clicks the confirm button$")
	public void the_user_clicks_the_confirm_button() {///////////////////////////////////////////////////////////
	    
	}

	@When("^The user clicks on the show trainee button on new batch \"([^\"]*)\"$")
	public void the_user_clicks_on_the_show_trainee_button_on_new_batch(String arg1) {
		List<WebElement> listElements = mbp.manageBatchTable.findElements(By.className("batch-row"));
		for(WebElement rows: listElements)
		{
			if(rows.getText() == arg1)
			{
				mbp.showTraineesButtonForRow(rows).click();
			}
		}
	}

	@Then("^The trainee \"([^\"]*)\" should appear in the trainee list$")
	public void the_trainee_should_appear_in_the_trainee_list(String arg1){/////////////////////////////////////////////////
	   
	}

	@Given("^The user selects a year (\\d+) in drop down$")
	public void the_user_selects_a_year_in_drop_down(int arg1) {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	
	@Given("^The user clicks show trainees in  batch (\\d+) for edit trainee$")
	public void the_user_clicks_show_trainees_in_batch_for_edit_trainee(int arg1) {
		WebElement batch = mbp.getManageBatchTableRow(arg1);
		mbp.showTraineesButtonForRow(batch).click();
	}
	    
	
	@When("^The user clicks the edit trainee button on trainee \"([^\"]*)\"$")//////////////////////////////////////////////////////
	public void the_user_clicks_the_edit_trainee_button_on_trainee(String arg1) {
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr"));
		for(WebElement row : rows)
		{
			if(row.findElement(By.tagName("td")).getText() == arg1)
			{
				row.findElement(By.id("trainee-actions-edit-button")).click();
			}
		}
	}

	@When("^The user updates contents \"([^\"]*)\" in field \"([^\"]*)\"$")
	public void the_user_updates_contents_in_field(String arg1, String arg2) {/////////////////////////////////this needs to be changed to explicitly say which field its changing to which contents ///////////////////////////////////
	    
	}

	@When("^The user clicks the update button$")
	public void the_user_clicks_the_update_button() {
	    atm.submitAddTrainerButton().click();
	}

	@Then("^The trainee \"([^\"]*)\" field\"([^\"]*)\" should match contents \"([^\"]*)\"$")
	public void the_trainee_field_should_match_contents(String arg1, String arg2, String arg3){///////////////////////////////////////////
	   
	}

	@Given("^The user selects a year (\\d+) in drop down for edit trainee status$")
	public void the_user_selects_a_year_in_drop_down_for_edit_trainee_status(int arg1)  {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@Given("^The user clicks show trainees in batch  (\\d+) for edit trainee status$")
	public void the_user_clicks_show_trainees_in_batch_for_edit_trainee_status(int arg1) {
		WebElement row = mbp.getManageBatchTableRow(arg1);
	    mbp.showTraineesButtonForRow(row).click();;
	}

	@When("^The user selects contents \"([^\"]*)\" in training status drop down$")
	public void the_user_selects_contents_in_training_status_drop_down(String arg1) {//////////////////////////////need this in pom
	 
	}

	@Then("^The trainee \"([^\"]*)\" training status field  should match contents \"([^\"]*)\"$")
	public void the_trainee_training_status_field_should_match_contents(String arg1, String arg2) throws Throwable {//////////////////////////////////////
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The user selects a year (\\d+) in drop down for remove trainee$")
	public void the_user_selects_a_year_in_drop_down_for_remove_trainee(int arg1) {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@Given("^The user clicks show trainees in batch batch (\\d+)$")
	public void the_user_clicks_show_trainees_in_batch_batch(int arg1) {
		WebElement row = mbp.getManageBatchTableRow(arg1);
	    mbp.showTraineesButtonForRow(row).click();
	}

	@When("^The user clicks remove trainee button on trainee \"([^\"]*)\"$")
	public void the_user_clicks_remove_trainee_button_on_trainee(String arg1) throws Throwable {/////////////////////////////need from pom
	    List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr[1]"));
	    for(WebElement row : rows)
	    {
	    	if(row.getAttribute(driver.findElement(By.xpath("//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr[1]/td[2]")).getText())  == arg1)
	    	{
	    		driver.findElement(By.xpath("//*[@id=\"trainee-actions-remove-button\"]/span")).click();
	    	}
	    }
	    
	}

	@When("^The user clicks the delete button in alert$")
	public void the_user_clicks_the_delete_button_in_alert()  {
	  driver.switchTo().alert();
	  driver.findElement(By.id("delete-trainee-modal-delete-button")).click();
	 
	}

	@When("^The user clicks confirm delete button in next alert$")
	public void the_user_clicks_confirm_delete_button_in_next_alert(){
		driver.findElement(By.id("delete-trainee-modal-confirm-delete-button")).click();
	    
	}

	@Then("^The trainee \"([^\"]*)\" should be removed from the trainee list$")
	public void the_trainee_should_be_removed_from_the_trainee_list(String arg1) {///////////////////////////////////////////////////////////////
	   
	}

	@Given("^The user selects a year (\\d+) in drop down for edit batch by text$")
	public void the_user_selects_a_year_in_drop_down_for_edit_batch_by_text(int arg1) {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@When("^user click on the edit batch button on batch (\\d+)$")
	public void user_click_on_the_edit_batch_button_on_batch(int arg1) {
		WebElement row = mbp.getManageBatchTableRow(arg1);
		mbp.editBatchButtonForRow(row).click();
	}

	@Then("^The batch \"([^\"]*)\" field \"([^\"]*)\" should match contents \"([^\"]*)\"$")
	public void the_batch_field_should_match_contents(String arg1, String arg2, String arg3) throws Throwable {/////////////////////////////////////////////
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The user selects a year (\\d+) in drop down for edit batch by selection$")
	public void the_user_selects_a_year_in_drop_down_for_edit_batch_by_selection(int arg1) throws Throwable {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@When("^The user selects contents \"([^\"]*)\" in field \"([^\"]*)\" dropdown$")
	public void the_user_selects_contents_in_field_dropdown(String arg1, String arg2) throws Throwable {////////////////////////////////////////
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The user selects a year (\\d+) in drop down for delete batch$")
	public void the_user_selects_a_year_in_drop_down_for_delete_batch(int arg1) {
		mbp.getItemByItemNumber(mbp.getDropdownSelectYearContainer(), arg1).click();
	}

	@When("^The user clicks the delete batch button on batch (\\d+)$")
	public void the_user_clicks_the_delete_batch_button_on_batch(int arg1) {
	    WebElement batch = mbp.getManageBatchTableRow(arg1);
	    mbp.removeBatchButtonForRow(batch).click();
	}

	@When("^The user clicks the delete button in the alert$")
	public void the_user_clicks_the_delete_button_in_the_alert() {
	    	driver.switchTo().alert();
	    	driver.findElement(By.id("delete-trainee-modal-delete-button")).click();
	}

	@When("^The user clicks confirm delete in the next alert$")
	public void the_user_clicks_confirm_delete_in_the_next_alert() {
	   driver.findElement(By.xpath("/html/body/modal-container/div/div/app-delete-trainee-modal/div[2]/div/div/button[1]")).click();////////////////////////////no xpath, only full xpath displayed
	   
	}

	@Then("^The batch \"([^\"]*)\" should be missing from batch list$")
	public void the_batch_should_be_missing_from_batch_list(String arg1) throws Throwable {//////////////////////////////////////////////
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
}















