package com.revature.runner;

import com.revature.app.Caliber2E2eApplication;
import com.revature.page.*;
import com.revature.utils.PagesUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/QualityAudit.feature", glue = "com.revature.steps",plugin = {"pretty", "json:./cucumber.json"})
//@CucumberOptions(features = "classpath:", glue = "com.revature.steps",plugin = {"pretty", "json:./cucumber.json"})
public class ChromeRunner {
	// Run the test on Junit4 ONLY!~!~!~!
	public static WebDriver driver;
	public static PagesUtil pages;

	static {
		try {
			Caliber2E2eApplication.exportResource("chromedriver.exe");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pages = new PagesUtil(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
