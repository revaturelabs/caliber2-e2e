package com.revature.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.page.SettingsLocationsPage;
import com.revature.utils.PagesUtil;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class LocationSteps {

	SettingsLocationsPage lc = PagesUtil.locationsPage;
	WebDriver driver = PagesUtil.driver;

	String thisLocation;
	String activeStatus;
	
	@When("^The user clicks on add new location$")
	public void the_user_clicks_on_add_new_location() throws Throwable {
	    lc.createLocationButton().click();
	}

	@When("^The user types \"([^\"]*)\" into Company Name$")
	public void the_user_types_into_Company_Name(String arg1) throws Throwable {
	    lc.inputCompanyName().sendKeys(arg1);
	}

	@When("^The user types \"([^\"]*)\" into Street Address$")
	public void the_user_types_into_Street_Address(String arg1) throws Throwable {
		this.thisLocation += arg1;
	    lc.inputLocationStreet().sendKeys(arg1);
	}

	@When("^The user types \"([^\"]*)\" into City$")
	public void the_user_types_into_City(String arg1) throws Throwable {
		this.thisLocation += ", " + arg1;
	    lc.inputCity().sendKeys(arg1);
	}
	
	@When("^The user clicks on the Add State dropdown menu$")
	public void the_user_clicks_on_the_Add_State_dropdown_menu() throws Throwable {
		lc.stateDropdown().click();
	}

	@When("^The user selects \"([^\"]*)\"$")
	public void the_user_selects(String arg1) throws Throwable {
		this.thisLocation += ", " + arg1;
	    lc.chooseStateByStateAbrv(arg1).click();
	}

	@When("^The user types \"([^\"]*)\" into Zipcode$")
	public void the_user_types_into_Zipcode(String arg1) throws Throwable {
		this.thisLocation += " " + arg1;
	    lc.inputZipCode().sendKeys(arg1);
	}

	@When("^The user clicks Save$")
	public void the_user_clicks_Save() throws Throwable {
	    lc.saveAddLocationButton().click();
	}

	@When("^The user clicks on edit location for row (\\d+)$")
	public void the_user_clicks_on_edit_location_for_row(int arg1) throws Throwable {
	    WebElement row = lc.getTableRow(arg1);
	    //The fourth column is the edit button
	    lc.getTableData(4,row).findElement(By.id("locationspage-locationrow-displaylocationeditmodal")).click();
	    
	}

	@Then("^The Company Name field should match Company for row (\\d+)$")
	public void the_Company_Name_field_should_match_Company_for_row(int arg1) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
	    //Column 2 has the company name
	    String company = lc.getTableData(2, row).getText();
	    String placeholderCompany = lc.inputEditCompanyName().getAttribute("ng-reflect-model");
	    Assert.assertEquals(true, company.equals(placeholderCompany));
	}

	@Then("^The Street Address field should match Address for row (\\d+)$")
	public void the_Street_Address_field_should_match_Address_for_row(int arg1) throws Throwable {
	    //Column 3 has the street name
		WebElement row = lc.getTableRow(arg1+1);
	    String[] address = (lc.getTableData(3, row).getText()).split(",");
	    String streetAddress = address[0].trim();
	    String placeholder = lc.inputEditLocationStreet().getAttribute("ng-reflect-model");
	    Assert.assertEquals(true, streetAddress.equals(placeholder));
	}

	@Then("^The City field should match Address for row (\\d+)$")
	public void the_City_field_should_match_Address_for_row(int arg1) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
	    //Column 3 has the street name
	    String[] address = lc.getTableData(3, row).getText().split(",");
	    String city = address[1].trim();
	    String placeholder = lc.inputEditCity().getAttribute("ng-reflect-model");;
	    Assert.assertEquals(true, city.equals(placeholder));
	}

	@Then("^The State field should match Address for row (\\d+)$")
	public void the_State_field_should_match_Address_for_row(int arg1) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
	    //Column 3 has the street name
	    String[] address = lc.getTableData(3, row).getText().split("[, ]");
	    String state = address[address.length-2].trim();
	    String placeholder = lc.stateEditDropdown().getAttribute("ng-reflect-model");
	    Assert.assertEquals(true, state.equals(placeholder));
	}

	@Then("^The Zipcode field should match Address for row (\\d+)$")
	public void the_Zipcode_field_should_match_Address_for_row(int arg1) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
	    //Column 3 has the street name
	    String[] address = lc.getTableData(3, row).getText().split("[, ]");
	    String zipcode = address[address.length-1].trim();
	    String placeholder = lc.inputEditZipCode().getAttribute("ng-reflect-model");
	    Assert.assertEquals(true, zipcode.equals(placeholder));
	}

	@Then("^The location named \"([^\"]*)\" is added to the list of locations$")
	public void the_location_named_is_added_to_the_list_of_locations(String arg1) throws Throwable {
		// If the row does not exist, the driver will throw a NoSuchElementException
		try{
			driver.findElement(By.id("locationspage-component-displayedlocation-" + arg1));
		}catch(NoSuchElementException e) {
			Assert.fail();
		}
	}

	@When("^The user types \"([^\"]*)\" into edit Company Name$")
	public void the_user_types_into_edit_Company_Name(String arg1) throws Throwable {
		lc.inputEditCompanyName().clear();
	    lc.inputEditCompanyName().sendKeys(arg1);
	}

	@When("^The user clicks Save edit$")
	public void the_user_clicks_Save_edit() throws Throwable {
	    lc.saveEditLocationButton().click();
	    Thread.sleep(1000);
	}

	@Then("^The name field for the location at row (\\d+) is updated with \"([^\"]*)\"$")
	public void the_name_field_for_the_location_at_row_is_updated_with(int arg1, String arg2) throws Throwable {
		WebElement row = lc.getTableRow(arg1);
		String actualName = lc.getTableData(2, row).getText();
		Assert.assertEquals(arg2, actualName);
	}
	
	@Then("^The address field for the location at row (\\d+) is updated with \"([^\"]*)\"$")
	public void the_address_field_for_the_location_at_row_is_updated_with(int arg1, String arg2) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
		String fullAddress = lc.getTableData(3, row).getText();
		String actualAddress = fullAddress.split(",")[0];
		Assert.assertEquals(arg2, actualAddress);
	}
	
	@Then("^The city field for the location at row (\\d+) is updated with \"([^\"]*)\"$")
	public void the_city_field_for_the_location_at_row_is_updated_with(int arg1, String arg2) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
		String fullAddress = lc.getTableData(3, row).getText();
		String actualCity = fullAddress.split(",")[1].trim();
		Assert.assertEquals(arg2, actualCity);
	}
	
	@Then("^The state field for the location at row (\\d+) is updated with \"([^\"]*)\"$")
	public void the_state_field_for_the_location_at_row_is_updated_with(int arg1, String arg2) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
		String[] splitAddress = lc.getTableData(3, row).getText().split(",");
		String actualState = splitAddress[splitAddress.length - 1].trim().split(" ")[0];
		Assert.assertEquals(arg2, actualState);
	}
	
	@Then("^The zipcode field for the location at row (\\d+) is updated with \"([^\"]*)\"$")
	public void the_zipcode_field_for_the_location_at_row_is_updated_with(int arg1, String arg2) throws Throwable {
		WebElement row = lc.getTableRow(arg1+1);
		String[] splitAddress = lc.getTableData(3, row).getText().split(",");
		String actualZip = splitAddress[splitAddress.length - 1].trim().split(" ")[1];
		Assert.assertEquals(arg2, actualZip);
	}

	@When("^The user types \"([^\"]*)\" into edit Street Address$")
	public void the_user_types_into_edit_Street_Address(String arg1) throws Throwable {
		lc.inputEditLocationStreet().clear();
	    lc.inputEditLocationStreet().sendKeys(arg1);
	}

	@When("^The user types \"([^\"]*)\" into edit City$")
	public void the_user_types_into_edit_City(String arg1) throws Throwable {
		lc.inputEditCity().clear();
	    lc.inputEditCity().sendKeys(arg1);
	}

	@When("^The user clicks on the Edit State dropdown menu$")
	public void the_user_clicks_on_the_Edit_State_dropdown_menu() throws Throwable {
	    lc.stateEditDropdown().click();
	}

	@When("^The user selects \"([^\"]*)\" edit$")
	public void the_user_selects_edit(String arg1) throws Throwable {
	    lc.chooseEditStateByStateAbrv(arg1).click();
	}

	@When("^The user types \"([^\"]*)\" into edit Zipcode$")
	public void the_user_types_into_edit_Zipcode(String arg1) throws Throwable {
		lc.inputEditZipCode().clear();
	    lc.inputEditZipCode().sendKeys(arg1);
	}

	@When("^The user clicks on make inactive or make active for first location$")
	public void the_user_clicks_on_make_inactive_or_make_active_for_first_location() throws Throwable {
		WebElement row = lc.getTableRow(2);
		this.activeStatus = row.findElement(By.xpath("//td//span")).getAttribute("class");
		System.out.println("old:"+this.activeStatus);
		driver.findElement(By.id("locationspage-locationrow-displaydisablemodal")).click();
	}

	@When("^The user clicks Reactivate or Deactivate$")
	public void the_user_clicks_Reactivate_or_Deactivate() throws Throwable {
		lc.deactivateLocationButton().click();
	}

	@Then("^The location is made inactive or active$")
	public void the_location_is_made_inactive_or_active() throws Throwable {
		driver.navigate().refresh();
		WebElement row = lc.getTableRow(2);
		System.out.println(row.getText());
		String newActiveStatus = row.findElement(By.xpath("//td//span")).getAttribute("class");
		System.out.println("new:"+newActiveStatus);
		Assert.assertEquals(false, newActiveStatus.equals(this.activeStatus));
	}

}

