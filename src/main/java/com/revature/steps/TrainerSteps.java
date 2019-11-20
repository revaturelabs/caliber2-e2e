package com.revature.steps;

import com.revature.page.SettingsTrainerPage;
import com.revature.utils.PagesUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrainerSteps {

	WebDriver driver = PagesUtil.driver;
	SettingsTrainerPage page = PagesUtil.trainersPage;

	@Then("^The new trainer has information \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")

	public void the_new_trainer_has_information_and_and_and(String arg1,
		String arg2, String arg3, String arg4) throws Throwable {
		this.driver.navigate().refresh(); // because apparently stuff needs to
											// refresh first...
		Thread.sleep(250);
		for (WebElement element : this.page.getTableBody()
			.findElements(By.tagName("tr"))) {
			if (element.findElement(By.xpath("//td[1]")).getText().equals(arg1)
				&& element.findElement(By.xpath("//td[2]")).getText()
					.equals(arg2)
				&& element.findElement(By.xpath("//td[3]")).getText()
					.equals(arg3)
				&& element.findElement(By.xpath("//td[4]")).getText()
					.equals(arg4)) {
				return;
			}
		}
		Assert.fail();
	}

	@Then("^The trainer \"([^\"]*)\" is made inactive$")
	public void the_trainer_is_made_inactive(String arg1) throws Throwable {
		this.driver.navigate().refresh();
		Thread.sleep(250);
		for (int i = 1; i < this.page.getTableRowsCount(); i++) {
			if (this.page.getTableRowName(i).getText().equals(arg1) && this.page
				.getTableRowTier(i).getText().equals("ROLE_INACTIVE")) {
				return;
			}
		}
		Assert.fail();
	}

	@Then("^The trainers email should be \"([^\"]*)\"$")
	public void the_trainers_email_should_be(String arg1) throws Throwable {
		this.driver.navigate().refresh();
		for (int i = 1; i < this.page.getTableRowsCount(); i++) {
			if (this.page.getTableRowEmail(i).getText().equals(arg1)) {
				return;
			}
		}
		Assert.fail();
	}

	@Then("^The trainers name should be \"([^\"]*)\"$")
	public void the_trainers_name_should_be(String arg1) throws Throwable {
		this.driver.navigate().refresh();
		Thread.sleep(250);
		for (int i = 1; i < this.page.getTableRowsCount(); i++) {
			if (this.page.getTableRowName(i).getText().equals(arg1)) {
				Thread.sleep(250);
				// Resetting the information for another test
				this.page.editTrainerButton(arg1).click();
				Thread.sleep(250);
				this.page.inputEditTrainerName().clear();
				this.page.inputEditTrainerName().sendKeys("New");
				Thread.sleep(250);
				this.page.submitEditTrainer().click();
				return;
			}
		}
		Assert.fail();
	}

	@Then("^The trainers role should be \"([^\"]*)\"$")
	public void the_trainers_role_should_be(String arg1) throws Throwable {
		this.driver.navigate().refresh();
		Thread.sleep(250);
		for (int i = 1; i < this.page.getTableRowsCount(); i++) {
			if (this.page.getTableRowTier(i).getText().equals(arg1)) {
				return;
			}
		}
		Assert.fail();
	}

	@Then("^The trainers title should be \"([^\"]*)\"$")
	public void the_trainers_title_should_be(String arg1) throws Throwable {
		this.driver.navigate().refresh();
		Thread.sleep(250);
		for (int i = 1; i < this.page.getTableRowsCount(); i++) {
			if (this.page.getTableRowTitle(i).getText().equals(arg1)) {
				return;
			}
		}
		Assert.fail();
	}

	@When("^The user clicks edit trainer for trainer \"([^\"]*)\"$")
	public void the_user_clicks_edit_trainer_for_trainer(String arg1)
		throws Throwable {
		for (int i = 1; i <= this.page.getTableRowsCount(); i++) {
			if (this.page.getTableRowName(i).getText().equals(arg1)) {
				PagesUtil.dWait.until(ExpectedConditions
					.elementToBeClickable(this.page.getTableRow(i)
						.findElement(By.className("pull-right"))))
					.click();
				// page.editTrainerButton(arg1).click();

				return;
			}
		}
	}

	@When("^The user clicks inactive on a trainer \"([^\"]*)\"$")
	public void the_user_clicks_inactive_on_a_trainer(String arg1)
		throws Throwable {
		Thread.sleep(500);
		this.page.inactiveTrainerButton(arg1).click();
	}

	@When("^The user clicks new trainer$")
	public void the_user_clicks_new_trainer() throws Throwable {
		Thread.sleep(250);
		this.page.addTrainerButton().click();
	}

	@When("^The user clicks on confirm$")
	public void the_user_clicks_on_confirm() throws Throwable {
		Thread.sleep(500);
		this.page.yesDisableTrainerButton().click();
	}

	@When("^The user clicks submit$")
	public void the_user_clicks_submit() throws Throwable {
		this.page.submitAddTrainer().click();
	}

	@When("^The user clicks update$")
	public void the_user_clicks_update() throws Throwable {
		this.page.submitEditTrainer().click();
	}

	@When("^The user inputs \"([^\"]*)\" into edit email input$")
	public void the_user_inputs_into_edit_email_input(String arg1)
		throws Throwable {
		this.page.inputEditTrainerEmail().clear();
		this.page.inputEditTrainerEmail().sendKeys(arg1);
		this.page.submitEditTrainer().click();
	}

	@When("^The user inputs \"([^\"]*)\" into edit name input$")
	public void the_user_inputs_into_edit_name_input(String arg1)
		throws Throwable {
		Thread.sleep(250);
		this.page.inputEditTrainerName().clear();
		this.page.inputEditTrainerName().sendKeys(arg1);
		this.page.submitEditTrainer().click();
	}

	@When("^The user inputs \"([^\"]*)\" into edit title input$")
	public void the_user_inputs_into_edit_title_input(String arg1)
		throws Throwable {
		this.page.inputEditTrainerTitle().clear();
		this.page.inputEditTrainerTitle().sendKeys(arg1);
		this.page.submitEditTrainer().click();
	}

	@When("^The user inputs \"([^\"]*)\" into email input$")
	public void the_user_inputs_into_email_input(String arg1) throws Throwable {
		this.page.inputTrainerEmail().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" into name input$")
	public void the_user_inputs_into_name_input(String arg1) throws Throwable {
		this.page.inputTrainerName().sendKeys(arg1);
	}

	@When("^The user inputs \"([^\"]*)\" into title input$")
	public void the_user_inputs_into_title_input(String arg1) throws Throwable {
		this.page.inputTrainerTitle().sendKeys(arg1);
	}

	@When("^The user selects \"([^\"]*)\" from edit list$")
	public void the_user_selects_from_edit_list(String arg1) throws Throwable {
		// TODO parameters should not be assigned
		arg1 = arg1.replace("_", "-");
		this.page.trainerEditTierDropdown().click();
		this.page.trainerEditTierDropdown()
			.findElement(By.id("user-edit-trainer-" + arg1.toLowerCase()))
			.click();
	}

	@When("^The user selects \"([^\"]*)\" from list$")
	public void the_user_selects_from_list(String arg1) throws Throwable {
		// TODO parameters should not be assigned
		arg1 = arg1.replace("_", "-");
		this.page.trainerTier().click();
		this.page.trainerTierDropdown()
			.findElement(By.id("user-add-trainer-" + arg1.toLowerCase()))
			.click();
	}

}
