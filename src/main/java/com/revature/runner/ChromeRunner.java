package com.revature.runner;

import com.revature.app.Caliber2E2eApplication;
import com.revature.page.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources", glue = "com.revature.steps",plugin = {"pretty", "json:./cucumber.json"})
//@CucumberOptions(features = "classpath:", glue = "com.revature.steps",plugin = {"pretty", "json:./cucumber.json"})
public class ChromeRunner {
	// Run the test on Junit4 ONLY!~!~!~!
	public static WebDriver driver;
	public static AddTraineeModal addTraineeModal;
	public static AssessBatchPage assessBatchPage;
	public static CreateBatchModal createBatchModal;
	public static EditBatchModal editBatchModal;
	public static EditTraineeModal editTraineeModal;
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static ManageBatchPage manageBatchPage;
	public static NavigationBar navBar;
	public static QualityAuditPage qualityAuditPage;
	public static ReportsPage reportsPage;
	public static SettingsCategoriesPage categoriesPage;
	public static SettingsLocationsPage locationsPage;
	public static SettingsTrainerPage trainersPage;
	public static ShowTraineesModal traineesModal;

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
		addTraineeModal = new AddTraineeModal(driver);
		assessBatchPage = new AssessBatchPage(driver);
		createBatchModal = new CreateBatchModal(driver);
		editBatchModal = new EditBatchModal(driver);
		editTraineeModal = new EditTraineeModal(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		manageBatchPage = new ManageBatchPage(driver);
		navBar = new NavigationBar(driver);
		qualityAuditPage = new QualityAuditPage(driver);
		reportsPage = new ReportsPage(driver);
		categoriesPage = new SettingsCategoriesPage(driver);
		locationsPage = new SettingsLocationsPage(driver);
		trainersPage = new SettingsTrainerPage(driver);
		traineesModal = new ShowTraineesModal(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
