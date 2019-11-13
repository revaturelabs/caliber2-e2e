package com.revature.utils;

import org.openqa.selenium.WebDriver;

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

public class PagesUtil {

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
	
	public PagesUtil(WebDriver driver){
		this.driver = driver;
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
}
