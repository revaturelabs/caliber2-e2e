package com.revature.runner;

import com.revature.app.Caliber2E2eApplication;
import com.revature.page.AddTraineeModal;
import com.revature.page.AssessBatchPage;
import com.revature.page.Caliber2page;
import com.revature.page.CreateBatchModal;
import com.revature.page.EditBatchModal;
import com.revature.page.EditTraineeModal;
import com.revature.page.HomePage;
import com.revature.page.LoginPage;
import com.revature.page.ManageBatchPage;
import com.revature.page.NavigationBar;
import com.revature.page.QualityAuditPage;
import com.revature.page.ReportsPage;
import com.revature.page.SettingsCategoriesPage;
import com.revature.page.SettingsLocationsPage;
import com.revature.page.SettingsTrainerPage;
import com.revature.page.ShowTraineesModal;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:", glue = "com.revature.steps",
	plugin = {"pretty", "json:./cucumber.json"})
public class Caliber2Runner {
	// Run the test on Junit4 ONLY!~!~!~!
	public static WebDriver driver;
	public static AddTraineeModal addTraineeModal;
	public static AssessBatchPage assessBatchPage;
	public static CreateBatchModal createBatchModal;
	public static EditBatchModal editBatchModal;
	public static EditTraineeModal editTraineeModal;
	public static HomePage homePage;
	public static Caliber2page caliber2page;
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
		caliber2page = new Caliber2page(driver);
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
