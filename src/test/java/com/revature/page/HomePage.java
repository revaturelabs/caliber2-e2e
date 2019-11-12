package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 3);
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="last-quality-audit-panel")
	public WebElement lastQAContainer;
	
	@FindBy(id="home-toolbar-state-select")
	public WebElement lastQAStateDropdown;
	
	@FindBy(id="last-quality-audit-graph-base-chart-canvas")
	public WebElement lastQACanvas;
	
	@FindBy(id="lastQATable")
	public WebElement lastQATable;
	
	/**
	 * iterate through rows in the table, checking the th where the trainer name is stored
	 * if the name matches the trainer we are looking for, return the row. else return null
	 */
	public WebElement lastQARowByTrainer(String trainer) {
		for(WebElement elem : this.lastQATable.findElements(By.tagName("tr"))){
			if(elem.findElement(By.tagName("th")).getText().contains(trainer)) {
				return elem;
			}
		}
		return null;
	}
	
	@FindBy(id="missing-grades-list-data-container")
	public WebElement missingGradesContainer;
	
	@FindBy(id="WeekSorter")
	public WebElement weekSorterButton;
	
	public WebElement getWeekSorterDropdownContainer() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pill-box-dropdown-container")));
	}
	
	public void selectWeekSorterByIndex(int index) {
		this.getWeekSorterDropdownContainer().findElements(By.tagName("app-dropdown-button")).get(index).click();
	}
	
	public void selectWeekSorterByWeek(int week) {
		for(WebElement elem : this.getWeekSorterDropdownContainer().findElements(By.tagName("app-dropdown-button"))) {
			if(Integer.parseInt(elem.getText())==week) {
				elem.click();
			}
		}
	}
	
	@FindBy(id="pill-box-container")
	public WebElement pillBoxContainer;
	
	public WebElement getPillByIndex(int pillIndex) {
		return this.pillBoxContainer.findElements(By.tagName("app-pill")).get(pillIndex);
	}
	
	/**
	 * iterate through the pills, getting the text and parsing out the week number
	 * if the found number matches what we are looking for return the pill, else return null
	 */
	public WebElement getPillByWeek(int week) {
		for(WebElement elem: this.pillBoxContainer.findElements(By.tagName("app-pill"))) {
			if(Integer.parseInt(elem.findElement(By.className("pillContent")).getText().split(" ")[1])==week) {
				return elem;
			}
		}
		return null;
	}
	
	@FindBy(id="missing-grades-list-table")
	public WebElement missingGradesTable;
	
	/**
	 * iterate through rows in the table, checking the first td where the trainer name is stored
	 * if the name matches the trainer we are looking for, return the row. else return null
	 */
	public WebElement getMissingGradeRowByTrainer(String trainer) {
		for(WebElement elem : this.missingGradesTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"))) {
			if(elem.findElement(By.tagName("td")).getText().contains(trainer)) {
				return elem;
			}
		}
		return null;
	}
}
