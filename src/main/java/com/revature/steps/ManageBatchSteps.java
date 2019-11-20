package com.revature.steps;

import com.revature.entity.Batch;
import com.revature.entity.Trainee;
import com.revature.page.AddTraineeModal;
import com.revature.page.CreateBatchModal;
import com.revature.page.ManageBatchPage;
import com.revature.utils.PagesUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ManageBatchSteps {
	WebDriver driver = PagesUtil.driver;
	ManageBatchPage mbp = PagesUtil.manageBatchPage;
	CreateBatchModal cbm = PagesUtil.createBatchModal;
	AddTraineeModal atm = PagesUtil.addTraineeModal;
	WebDriverWait wait = new WebDriverWait(this.driver, 5);

	Batch batch = new Batch();

	Trainee trainee = new Trainee();

	String temp = "";

	@Then("^Batch details should reflect changes$")
	public void batch_details_should_reflect_changes() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^The batch\"([^\"]*)\" should be missing from batch list$")
	public void the_batch_should_be_missing_from_batch_list(String arg1)
		throws Throwable {//////////////////////////////////////////////
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^The imported \"([^\"]*)\" is in the list$")
	public void the_imported_is_in_the_list(String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");
			// System.out.println(match[0] + " == " + arg1);

			if (match[0].equals(arg1)) {// found in the table
				Assert.assertTrue(true);
				return;
			}

		}
		Assert.fail();

	}

	@Then("^The newly created batch should reflect the information given$")
	public void the_newly_created_batch_should_reflect_the_information_given() {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");
			// System.out.println(match[0] + " == " + batch.getTrainingname());

			if (match[0].equals(this.batch.getTrainingname())) {// found in the
																// table
				Assert.assertTrue(true);
				return;
			}

		}
		Assert.fail();

	}

	@Then("^The \"([^\"]*)\" should reflect changes$")
	public void the_should_reflect_changes(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^The trainee is displayed in trainee list$")
	public void the_trainee_is_displayed_in_trainee_list() {
		List<WebElement> rows =
			this.mbp.getTraineesTable().findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			if (row.getText().equals(this.trainee.toString())) {
				Assert.assertTrue(true);
				return;
			}
		}
		Assert.fail();

	}

	@Then("^The trainee name  \"([^\"]*)\" should appear in the trainee list$")
	public void
		the_trainee_name_should_appear_in_the_trainee_list(String arg1) {/////////////////////////////////////////////////

	}

	@Then("^The trainee\"([^\"]*)\" should be removed from the trainee list$")
	public void
		the_trainee_should_be_removed_from_the_trainee_list(String arg1) {///////////////////////////////////////////////////////////////

	}

	@When("^The user clicks add trainee$")
	public void the_user_clicks_add_trainee() {
		this.driver.switchTo().activeElement();
		this.mbp.addTraineeButton().click();
		this.driver.switchTo().activeElement();
	}

	@When("^The user clicks confirm delete button in next alert$")
	public void the_user_clicks_confirm_delete_button_in_next_alert() {
		this.driver
			.findElement(By.id("delete-trainee-modal-confirm-delete-button"))
			.click();

	}

	@When("^The user clicks confirm delete in the next alert$")
	public void the_user_clicks_confirm_delete_in_the_next_alert() {
		this.driver.findElement(By.xpath(
			"/html/body/modal-container/div/div/app-delete-trainee-modal/div[2]/div/div/button[1]"))
			.click();//////////////////////////// no xpath, only full xpath
						//////////////////////////// displayed

	}

	@When("^The user clicks create button$")
	public void the_user_clicks_create_button() {
		this.atm.submitAddTrainerButton().click();
	}

	@When("^The user clicks import batch$")
	public void the_user_clicks_import_batch() {
		this.mbp.importBatchButton().click();

	}

	@Then("^The user clicks import grades$")
	public void the_user_clicks_import_grades() {
		// mbp.submitImportBatchButton().click();
		this.mbp.cancelImportBatchButton().click();
	}

	@When("^The user clicks on create batch$")
	public void the_user_clicks_on_create_batch() {
		this.wait
			.until(
				ExpectedConditions.visibilityOf(this.mbp.createBatchButton()))
			.click();
		this.driver.switchTo().activeElement();
	}

	@When("^The user clicks on the show trainee button on new batch \"([^\"]*)\"$")
	public void
		the_user_clicks_on_the_show_trainee_button_on_new_batch(String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");
			// System.out.println(match[0] + " == " + arg1);

			if (match[0].equals(arg1)) {// found in the table
				WebElement batch = this.mbp.getManageBatchTableRow(i);
				this.mbp.showTraineesButtonForRow(batch).click();
				return;
			}

		}
	}

	@When("^The user clicks on the switch batch button for a trainee \"([^\"]*)\"$")
	public void the_user_clicks_on_the_switch_batch_button_for_a_trainee(
		String arg1) throws Throwable {
		List<WebElement> rows =
			this.mbp.getTraineesTable().findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			if (row.getText().subSequence(0, arg1.length()) == arg1) {
				// found the trainee
				this.mbp.editBatchButtonForRow(row).click();
			}
		}
	}

	@When("^The user clicks remove trainee button on trainee \"([^\"]*)\"$")
	public void the_user_clicks_remove_trainee_button_on_trainee(String arg1)
		throws Throwable {///////////////////////////// need from pom
		List<WebElement> rows = this.driver.findElements(By.xpath(
			"//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr[1]"));
		for (WebElement row : rows) {
			if (row.getAttribute(this.driver.findElement(By.xpath(
				"//*[@id=\"view-trainees-modal-trainees-list-table\"]/tbody/tr[1]/td[2]"))
				.getText()) == arg1) {
				this.driver
					.findElement(By.xpath(
						"//*[@id=\"trainee-actions-remove-button\"]/span"))
					.click();
			}
		}

	}

	@When("^The user clicks show trainees in batch \"([^\"]*)\" for create trainee$")
	public void
		the_user_clicks_show_trainees_in_batch_for_create_trainee(String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");

			if (match[0].equals(arg1)) {// found in the table
				WebElement batch = this.mbp.getManageBatchTableRow(i);
				this.mbp.showTraineesButtonForRow(batch).click();
				return;
			}

		}

	}

	@Given("^The user clicks show trainees in batch \"([^\"]*)\" for edit trainee$")
	public void
		the_user_clicks_show_trainees_in_batch_for_edit_trainee(String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");
			// System.out.println(match[0] + " == " + arg1);

			if (match[0].equals(arg1)) {// found in the table
				WebElement batch = this.mbp.getManageBatchTableRow(i);
				this.mbp.showTraineesButtonForRow(batch).click();
				return;
			}

		}
	}

	@Given("^The user clicks show trainees in batch  (\\d+) for edit trainee status$")
	public void the_user_clicks_show_trainees_in_batch_for_edit_trainee_status(
		int arg1) {
		WebElement row = this.mbp.getManageBatchTableRow(arg1);
		this.mbp.showTraineesButtonForRow(row).click();
	}

	@When("^The user clicks show trainees in batch \"([^\"]*)\" for remove trainee$")
	public void
		the_user_clicks_show_trainees_in_batch_for_remove_trainee(String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");
			// System.out.println(match[0] + " == " + arg1);

			if (match[0].equals(arg1)) {// found in the table
				WebElement batch = this.mbp.getManageBatchTableRow(i);
				this.mbp.showTraineesButtonForRow(batch).click();
				return;
			}

		}
	}

	@Given("^The user clicks show trainees in original batch\"([^\"]*)\" for switch trainee$")
	public void
		the_user_clicks_show_trainees_in_original_batch_for_switch_trainee(
			String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");

			if (match[0].equals(arg1)) {// found in the table
				WebElement batch = this.mbp.getManageBatchTableRow(i);
				this.mbp.showTraineesButtonForRow(batch).click();
				return;
			}

		}
	}

	@When("^The user clicks the confirm button$")
	public void the_user_clicks_the_confirm_button() {///////////////////////////////////////////////////////////

	}

	@When("^The user clicks the delete batch button on batch\"([^\"]*)\"$")
	public void the_user_clicks_the_delete_batch_button_on_batch(String arg1) {
		WebElement info = this.mbp.manageBatchTable;
		List<WebElement> table = info.findElements(By.className("batch-row"));
		for (int i = 1; i <= table.size(); i++) {// arg1 = trianing name, arg6 =
													// start date, arg7 = end
													// date, arg8 = good grade,
													// arg9 = passing grade
			String[] match =
				this.mbp.getManageBatchTableRow(i).getText().split("\n.*");
			// System.out.println(match[0] + " == " + arg1);

			if (match[0].equals(arg1)) {// found in the table
				WebElement batch = this.mbp.getManageBatchTableRow(i);
				this.mbp
					.removeBatchButtonForRow(this.mbp.getManageBatchTableRow(i))
					.click();
				return;
			}

		}
	}

	@When("^The user clicks the delete button in alert$")
	public void the_user_clicks_the_delete_button_in_alert() {
		this.driver.switchTo().alert();
		this.driver.findElement(By.id("delete-trainee-modal-delete-button"))
			.click();

	}

	@When("^The user clicks the delete button in the alert$")
	public void the_user_clicks_the_delete_button_in_the_alert() {
		// driver.switchTo().alert();
		this.mbp.confirmDeleteBatchButton().click();
	}

	@When("^The user clicks the edit trainee button on trainee \"([^\"]*)\"$")
	public void the_user_clicks_the_edit_trainee_button_on_trainee(String arg1)
		throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user clicks the submit button$")
	public void the_user_clicks_the_submit_button() {
		// cbm.submitNewBatchButton().click();
		this.cbm.cancelNewBatchButton().click();
		this.driver.switchTo().defaultContent();
	}

	@When("^The user clicks the swich button$")
	public void the_user_clicks_the_swich_button() {///////////////////////////////////////////

	}

	@When("^The user clicks the update button$")
	public void the_user_clicks_the_update_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user fills in end date (\\d+)$")
	public void the_user_fills_in_end_date(int arg1) {
		this.batch.setEnddate(arg1);
		this.cbm.inputEndDate().sendKeys(String.valueOf(arg1));
	}

	@When("^the user fills in good gradesm (\\d+)$")
	public void the_user_fills_in_good_gradesm(int arg1) {
		this.batch.setGoodgrade(arg1);
		this.cbm.inputGoodGrade().clear();
		this.cbm.inputGoodGrade().sendKeys(String.valueOf(arg1));
	}

	@When("^The user fills in passing grades (\\d+)$")
	public void the_user_fills_in_passing_grades(int arg1) {
		this.batch.setPassinggrade(arg1);
		this.cbm.inputPassingGrade().clear();
		this.cbm.inputPassingGrade().sendKeys(String.valueOf(arg1));
	}

	@When("^The user fills in startdate (\\d+)$")
	public void the_user_fills_in_startdate(int arg1) {
		this.batch.setStartdate(arg1);
		this.cbm.inputStartDate().sendKeys(String.valueOf(arg1));
	}

	@When("^The user fills in training name \"([^\"]*)\"$")
	public void the_user_fills_in_training_name(String arg1) {
		this.batch.setTrainingname(arg1);
		this.cbm.inputTrainingName().sendKeys(arg1);
	}

	@When("^The user inputs (\\d+) in end date$")
	public void the_user_inputs_in_end_date(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user inputs (\\d+) in good grade$")
	public void the_user_inputs_in_good_grade(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user inputs (\\d+) in passing grade$")
	public void the_user_inputs_in_passing_grade(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user inputs \"([^\"]*)\" in the college field$")
	public void the_user_inputs_in_the_college_field(String arg1) {
		this.trainee.setCollege(arg1);
		this.atm.inputCollege().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the degree field$")
	public void the_user_inputs_in_the_degree_field(String arg1) {
		this.trainee.setDegree(arg1);
		this.atm.inputDegree().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the email field$")
	public void the_user_inputs_in_the_email_field(String arg1) {
		this.trainee.setEmail(arg1);
		this.atm.inputEmail().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the first name field$")
	public void the_user_inputs_in_the_first_name_field(String arg1) {
		this.trainee.setName(arg1);
		this.atm.inputFirstName().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the last name field$")
	public void the_user_inputs_in_the_last_name_field(String arg1) {
		String firstname = this.trainee.getName();
		String lastname = arg1;
		String fullinput = lastname + ", " + firstname;
		this.trainee.setName(fullinput);
		this.atm.inputLastName().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the major field$")
	public void the_user_inputs_in_the_major_field(String arg1) {
		this.trainee.setMajor(arg1);
		this.atm.inputMajor().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the phone number field$")
	public void the_user_inputs_in_the_phone_number_field(String arg1) {
		this.trainee.setPhonenumber(arg1);
		this.atm.inputPhoneNumber().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the profile URL field$")
	public void the_user_inputs_in_the_profile_URL_field(String arg1) {
		this.trainee.setResourceid(arg1);
		this.atm.inputProfileURL().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the project completion field$")
	public void the_user_inputs_in_the_project_completion_field(String arg1) {
		this.trainee.setProjectcompletion(arg1);
		this.atm.inputProjectCompletion().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the recruiter field$")
	public void the_user_inputs_in_the_recruiter_field(String arg1) {
		this.trainee.setRecruitername(arg1);
		this.atm.inputRecruiterName().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the skype ID field$")
	public void the_user_inputs_in_the_skype_ID_field(String arg1) {
		this.trainee.setSkypeid(arg1);
		this.atm.inputSkypeId().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in the tech screener field$")
	public void the_user_inputs_in_the_tech_screener_field(String arg1) {
		this.trainee.setTechscreenername(arg1);
		this.atm.inputTechScreener().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" in training name$")
	public void the_user_inputs_in_training_name(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user inputs \"([^\"]*)\" into paste JSON field$")
	public void the_user_inputs_into_paste_JSON_field(String arg1) {
		String file = "src/main/resources/" + arg1;
		try {
			StringBuilder text = new StringBuilder();
			File textFile = new File(file);
			Scanner scan = new Scanner(textFile);
			while (scan.hasNext()) {
				text.append(scan.next());
			}
			this.mbp.inputBatchJSON().sendKeys(text);
			scan.close();
		}
		catch (FileNotFoundException e1) {
			System.out.println("File not found");
		}

	}

	@When("^The user inputs <startdate> in start date$")
	public void the_user_inputs_startdate_in_start_date() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user selects co-trainer (\\d+)$")
	public void the_user_selects_co_trainer(int arg1) {
		this.batch.setCotrainer(
			this.cbm.selectCoTrainerDropdownByInt(arg1).getText());
		this.cbm.selectCoTrainerDropdownByInt(arg1).click();
	}

	@When("^The user selects contents \"([^\"]*)\" in training status drop down$")
	public void
		the_user_selects_contents_in_training_status_drop_down(String arg1) {////////////////////////////// need
																				////////////////////////////// this
																				////////////////////////////// in
																				////////////////////////////// pom

	}

	@When("^The user selects (\\d+) from training status drop down$")
	public void the_user_selects_from_training_status_drop_down(int arg1) {
		this.trainee.setTrianingstatus(
			this.atm.trainingStatusDropdownNthOption(arg1).getText());
		this.atm.trainingStatusDropdownNthOption(arg1).click();
	}

	@When("^The user selects (\\d+) in coTrainer$")
	public void the_user_selects_in_coTrainer(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user selects (\\d+) in location$")
	public void the_user_selects_in_location(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user selects (\\d+) in skill type$")
	public void the_user_selects_in_skill_type(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user selects (\\d+) in trainer$")
	public void the_user_selects_in_trainer(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^The user selects (\\d+) in training type$")
	public void the_user_selects_in_training_type(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the user selects location (\\d+)$")
	public void the_user_selects_location(int arg1) {
		this.batch
			.setLocation(this.cbm.selectLocationDropdownByInt(arg1).getText());
		this.cbm.selectLocationDropdownByInt(arg1).click();
	}

	@When("^The user selects new batch \"([^\"]*)\" from batch list drop down$")
	public void
		the_user_selects_new_batch_from_batch_list_drop_down(String arg1) {///////////////////////////////////////////////
		List<WebElement> selections = this.mbp.getDropdownSwitchBatch()
			.findElements(By.tagName("option"));
		for (WebElement selection : selections) {
			// System.out.println(selection.getText());
		}
	}

	@When("^The user selects skill type (\\d+)$")
	public void the_user_selects_skill_type(int arg1) {
		this.batch.setSkilltype(
			this.cbm.skillTypeDropdownBoxOptionByInt(arg1).getText());
		this.cbm.skillTypeDropdownBoxOptionByInt(arg1).click();
	}

	@When("^The user selects trainer (\\d+)$")
	public void the_user_selects_trainer(int arg1) {
		this.batch
			.setTrainer(this.cbm.trainerDropdownBoxOptionByInt(arg1).getText());
		this.cbm.trainerDropdownBoxOptionByInt(arg1).click();
	}

	@When("^The user selects training type (\\d+)$")
	public void the_user_selects_training_type(int arg1) {
		this.batch.setTrainingtype(
			this.cbm.selectTrainingTypeDropdownOptionByInt(arg1).getText());
		this.cbm.selectTrainingTypeDropdownOptionByInt(arg1).click();
	}

	@When("^user click on the edit batch button on \"([^\"]*)\"$")
	public void user_click_on_the_edit_batch_button_on(String arg1)
		throws Throwable {//////////////////////////////////////////////////////////////////////////////////
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
