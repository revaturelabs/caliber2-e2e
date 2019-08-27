package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAPage {
	WebDriver driver;

	public QAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// year dropdown
	@FindBy(css = "#selectedYearDropdown > a")
	public WebElement selectedYearDropdown;
	
	
	//2017
	@FindBy(xpath = "//*[@id=\"year dropdown\"]/li[1]/a")
	public WebElement selectedYearFirstElement;
	
	//2018
	@FindBy(xpath = "//*[@id=\"year dropdown\"]/li[2]/a")
	public WebElement selectedYearSecondElement;
	
	//2019
	@FindBy(xpath = "//*[@id=\"year dropdown\"]/li[3]/a")
	public WebElement selectedYearThirdElement;
	
	// add more as necessary, change the li[number]
	
	// Q1..4
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[2]/a")
	public WebElement selectedQuarter;
	
	// Q1
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[2]/ul/li[1]/a")
	public WebElement selectedQuarterFirst;
	
	// Q2
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[2]/ul/li[2]/a")
	public WebElement selectedQuarterSecond;
	
	// Q3
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[2]/ul/li[3]/a")
	public WebElement selectedQuarterThird;
	
	// Q4
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[2]/ul/li[3]/a")
	public WebElement selectedQuarterFourth;
	
	// Trainer Dropdown *may not appear if there are no trainers added*
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[3]/a")
	public WebElement selectedTrainerDropdown;
	
	// Trainer name input
	@FindBy(id = "myInput")
	public WebElement trainerNameInput;
	
	// Selected Trainer
	// 1st trainer in menu
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[3]/ul/li[2]/a")
	public WebElement selectedFirstTrainer;
	
	// 2nd trainer in menu
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[1]/ul/li[3]/ul/li[3]/a")
	public WebElement selectedSecondTrainer;
	
	//add more as necessary
	
	// Selected week
	// week 1
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[2]/ul/li[1]/a")
	public WebElement selectedWeekOne;
	
	// week 2
	@FindBy(xpath = "/html/body/app-root/div/app-audit/app-toolbar/div[1]/div/div/div[2]/ul/li[2]/a")
	public WebElement selectedWeekTwo;
	
	// add more as necessary, change the last li[]
	
	// add week
	@FindBy(css = "span.glyphicon.glyphicon-plus")
	public WebElement addWeek;
	
	// confirm on modal
	@FindBy(xpath = "//*[@id=\"confirmingweeks\"]/div/div/div[2]/button[1]")
	public WebElement addWeekConfirm;
	
	// cancel on modal
	@FindBy(xpath = "//*[@id=\"confirmingweeks\"]/div/div/div[2]/button[2]")
	public WebElement addWeekCancel;
	
	// x on modal
	@FindBy(xpath = "//*[@id=\"confirmingweeks\"]/div/div/div[1]/button")
	public WebElement addWeekClose;
	
	// add categories "button"
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/div/span")
	public WebElement addCategoriesMenu;
	
	// first category in dropdown
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/div/span/ul/li[1]/a")
	public WebElement addCategoriesMenuOne;
	
	
	// second category in dropdown
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/div/span/ul/li[2]/a")
	public WebElement addCategoriesMenuTwo;
	
	// add more as necessary, change the last li[]
	
	// sort randomly/sorted button
	@FindBy(id = "toggleNoteSort")
	public WebElement toggleSort;
	
	// first trainee name
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[1]/div")
	public WebElement firstTraineeName;
	
	// first trainee status menu -- not sure if you can click this, requires a hover to activate
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[3]/div/div/em")
	public WebElement firstTraineeMenu;
	
	// first trainee flag
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[1]/div/em")
	public WebElement firstTraineeFlag;
	
	// first trainee status (questionmark)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[3]/div/div/div/a[1]")
	public WebElement firstTraineeQuestion;
	
	// first trainee status (star)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[3]/div/div/div/a[2]")
	public WebElement firstTraineeStar;
	
	// first trainee status (smiley)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[3]/div/div/div/a[3]")
	public WebElement firstTraineeSmiley;
	
	// first trainee status (meh)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[3]/div/div/div/a[4]")
	public WebElement firstTraineeMeh;
	
	// first trainee status (frown)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[3]/div/div/div/a[5]")
	public WebElement firstTraineeFrown;
	
	// first trainee notes
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[5]/textarea")
	public WebElement firstTraineeNotes;
	
		// second trainee name
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[1]/div")
	public WebElement secondTraineeName;
	
	// second trainee flag
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[1]/div/em")
	public WebElement secondTraineeFlag;
	
	// second trainee status menu -- not sure if you can click this, requires a hover to activate
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[3]/div/div/em")
	public WebElement secondTraineeMenu;
	
	// second trainee status (questionmark)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[3]/div/div/div/a[1]")
	public WebElement secondTraineeQuestion;
	
	// second trainee status (star)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[3]/div/div/div/a[3]")
	public WebElement secondTraineeStar;
	
	// second trainee status (smiley)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[3]/div/div/div/a[3]")
	public WebElement secondTraineeSmiley;
	
	// second trainee status (meh)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[3]/div/div/div/a[4]")
	public WebElement secondTraineeMeh;
	
	// second trainee status (frown)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[3]/div/div/div/a[5]")
	public WebElement secondTraineeFrown;
	
	// second trainee notes
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[3]/td[5]/textarea")
	public WebElement secondTraineeNotes;
	
	// add more as necessary - change tr[]
	
	// overall feedback dropdown
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-overall/div/div/div/table/tbody/tr/td[1]/div/em")
	public WebElement overallFeedbackMenu;
	
	// overall feedback status (smiley)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-overall/div/div/div/table/tbody/tr/td[1]/div/em")
	public WebElement overallFeedbackSmiley;
	
	// overall feedback status (meh)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-overall/div/div/div/table/tbody/tr/td[2]/div/em")
	public WebElement overallFeedbackMeh;
	
	// overall feedback status (frown)
	@FindBy(xpath = "//*[@id=\"noTrainees\"]/app-overall/div/div/div/table/tbody/tr/td[3]/div/em")
	public WebElement overallFeedbackFrown;
	
	// overall feedback text
	@FindBy(css = "#noTrainees app-overall textarea")
	public WebElement overallFeedbackText;
	
	// save button
	@FindBy(css = "a.save-button")
	public WebElement saveButton;
}