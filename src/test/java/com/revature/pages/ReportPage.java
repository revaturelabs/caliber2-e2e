package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
	
    WebDriver driver;
    public ReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id="toolbarYearDropdown")
    public WebElement toolbarYearDropdown;
    
    @FindBy(xpath="\\*[@id=\"toolbarRow\"]/div/ul/li[1]/ul/li[1]/a")
    public WebElement toolbar2019;
    
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[1]/ul/li[3]/a")
    public WebElement toolbar2017;
    @FindBy(id="toolbarBatchDropdown")
    public WebElement toolbarBatchDropdown;
    
    @FindBy(id="toolbarWeekDropdown")
    public WebElement toolbarWeekDropdown;

    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[1]/a")
    public WebElement allWeekDropdown;
  
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[2]/a")
    public WebElement weekOneDropdown;
 
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[3]/a")
    public WebElement weekTwoDropdown;
  
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[4]/a")
    public WebElement weekThreeDropdown;
 
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[5]/a")
    public WebElement weekFourDropdown;
    
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[6]/a")
    public WebElement weekFiveDropdown;
    
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[7]/a")
    public WebElement weekSixDropdown;
    
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[8]/a")
    public WebElement weekSevenDropdown;
    
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[9]/a")
    public WebElement weekEightDropdown;
    
    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[3]/ul/li[10]/a")
    public WebElement weekTenDropdown;
        
    @FindBy(id="toolbarTraineeDropdown")
    public WebElement TraineeDropdown;

    @FindBy(xpath="//*[@id=\"toolbarRow\"]/div/ul/li[4]/ul/li[1]/a")
    public WebElement allTrainee; //all trainee option for traine dropdown
    
    @FindBy(xpath="  //*[@id=\"toolbarRow\"]/div/ul/li[4]/ul/li[2]/a")
    public WebElement martin; //martin for traine dropdown
    
    @FindBy(xpath="  //*[@id=\"toolbarRow\"]/div/ul/li[4]/ul/li[3]/a")
    public WebElement malone; //malone for traine dropdown
    
    @FindBy(xpath="  //*[@id=\"toolbarRow\"]/div/ul/li[4]/ul/li[4]/a")
    public WebElement benard; //benard for traine dropdown
    
    @FindBy(id="Martin, Angela 1")
    public WebElement questionmarkWeekOneMartin; //Martin week 1 question mark
    
    @FindBy(id="Martin, Angela 9")
    public WebElement questionmarkWeekNineMartin; //Martin week 9 question mark
    
    @FindBy(id="Malone, Kevin 1")
    public WebElement questionmarkWeekOneMalone; //Malone question mark
    
    @FindBy(id="Malone, Kevin 9")
    public WebElement questionmarkWeekNineMalone; //Malone week 9 question mark
    
    @FindBy(id="Bernard, Andy 1")
    public WebElement questionmarkWeekOneBernard; //Bernard question mark
    
    @FindBy(id="Bernard, Andy 9")
    public WebElement questionmarkWeekNineBernard; //Bernard week 9 question mark
    
    @FindBy(id="Overall1")
    public WebElement overallWeekOneQuestionMark; //question mark for week 1
    
    @FindBy(id="Overall9")
    public WebElement overallWeekNineQuestionMark; //question mark for week 9
 
    @FindBy(xpath="//*[@id=\"myModal\"]/div/div/div[3]/button")
    public WebElement questionMarkClosePopUp;  //close pop up after clinking on questoin mark

    @FindBy(xpath="//*[@id=\"radarPanel\"]/div[1]/div/i")
    public WebElement technicalSkillsPersonSelection;  //Technical skills person selection

    @FindBy(xpath="//*[@id=\"insert-trainee\"]/div/div/div[2]/div/table/tbody/tr[1]/td/input")
    public WebElement martinCheckboxTech;  //MARTIN CHECKBOX after clicking on technical skills

    @FindBy(xpath="//*[@id=\"checkboxID\"]")
    public WebElement maloneCheckboxTech;  //MALONE TECH

    @FindBy(xpath="//*[@id=\"checkboxID\"]")
    public WebElement bernardCheckboxTech;  //BERNARD TECH

    @FindBy(xpath="//*[@id=\"insert-trainee\"]/div/div/div[1]/button/span")
    public WebElement closeTech;  // close tech skills person selection
    
}
