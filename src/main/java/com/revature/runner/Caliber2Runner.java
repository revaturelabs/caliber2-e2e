package com.revature.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.revature.app.Caliber2E2eApplication;
import com.revature.page.Caliber2page;
import com.revature.page.HomePage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:", glue = "com.revature.steps",
	plugin = {"pretty", "json:./cucumber.json"})
public class Caliber2Runner {
	// Run the test on Junit4 ONLY!~!~!~!
	public static WebDriver driver;
	public static Caliber2page caliber2page;
	public static HomePage homepage;

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
		caliber2page = new Caliber2page(driver);
		homepage = new HomePage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
