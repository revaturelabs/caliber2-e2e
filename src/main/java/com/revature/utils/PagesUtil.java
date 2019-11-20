package com.revature.utils;

import com.revature.page.AddTraineeModal;
import com.revature.page.AssessBatchPage;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PagesUtil {

	public static WebDriver driver = null;
	public static WebDriverWait dWait;
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

	public static void setup(WebDriver driver) {
		PagesUtil.driver = driver;
		PagesUtil.dWait = new WebDriverWait(driver, 3);
		PagesUtil.driver.manage().timeouts().implicitlyWait(3,
			TimeUnit.SECONDS);
		PagesUtil.addTraineeModal = new AddTraineeModal(driver);
		PagesUtil.assessBatchPage = new AssessBatchPage(driver);
		PagesUtil.createBatchModal = new CreateBatchModal(driver);
		PagesUtil.editBatchModal = new EditBatchModal(driver);
		PagesUtil.editTraineeModal = new EditTraineeModal(driver);
		PagesUtil.homePage = new HomePage(driver);
		PagesUtil.loginPage = new LoginPage(driver);
		PagesUtil.manageBatchPage = new ManageBatchPage(driver);
		PagesUtil.navBar = new NavigationBar(driver);
		PagesUtil.qualityAuditPage = new QualityAuditPage(driver);
		PagesUtil.reportsPage = new ReportsPage(driver);
		PagesUtil.categoriesPage = new SettingsCategoriesPage(driver);
		PagesUtil.locationsPage = new SettingsLocationsPage(driver);
		PagesUtil.trainersPage = new SettingsTrainerPage(driver);
		PagesUtil.traineesModal = new ShowTraineesModal(driver);
	}

	public static void tearDown() {
		if (PagesUtil.driver != null) {
			PagesUtil.driver.quit();
		}
		PagesUtil.driver = null;
		PagesUtil.dWait = null;
		PagesUtil.addTraineeModal = null;
		PagesUtil.assessBatchPage = null;
		PagesUtil.createBatchModal = null;
		PagesUtil.editBatchModal = null;
		PagesUtil.editTraineeModal = null;
		PagesUtil.homePage = null;
		PagesUtil.loginPage = null;
		PagesUtil.manageBatchPage = null;
		PagesUtil.navBar = null;
		PagesUtil.qualityAuditPage = null;
		PagesUtil.reportsPage = null;
		PagesUtil.categoriesPage = null;
		PagesUtil.locationsPage = null;
		PagesUtil.trainersPage = null;
		PagesUtil.traineesModal = null;
	}
}
