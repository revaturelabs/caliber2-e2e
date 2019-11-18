package com.revature.runner;

import com.revature.app.Caliber2E2eApplication;
import com.revature.utils.PagesUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@RunWith(Cucumber.class)
// @CucumberOptions(features = "src/main/resources/Reports.feature", glue =
// "com.revature.steps",plugin = {"pretty", "json:./cucumber.json"})
@CucumberOptions(features = "classpath:BOOT-INF/classes/Reports.feature",
	glue = "com.revature.steps", plugin = {"pretty", "json:./cucumber.json"})
public class ChromeRunner {
	// Run the test on Junit4 ONLY!~!~!~!

	@BeforeClass
	public static void setUp() {
		try {
			Caliber2E2eApplication.exportResource("chromedriver.exe");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// Chrome driver
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();

		PagesUtil.setup(driver);
	}

	@AfterClass
	public static void tearDown() {
		PagesUtil.tearDown();
	}
}
