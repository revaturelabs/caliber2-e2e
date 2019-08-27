package com.revature.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.AssessBatchPOM;
import com.revature.pages.HomePage;
import com.revature.pages.ManageBatchPage;
import com.revature.pages.QAPage;
import com.revature.pages.ReportPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources",glue ="com.revature.steps")
public class Caliber2Runner {
	// Run the test on Junit4 ONLY!~!~!~!
	public static WebDriver driver;
	public static HomePage home;
	public static QAPage qaPage;
	public static ManageBatchPage managebatchpage;
	public static AssessBatchPOM assessBatch;
	public static ReportPage reportpage;
	
	static {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());        
		driver = new ChromeDriver();        
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		home = new HomePage(driver);
		qaPage = new QAPage(driver); 
		assessBatch = new AssessBatchPOM(driver);
		managebatchpage = new ManageBatchPage(driver);
		reportpage = new ReportPage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
