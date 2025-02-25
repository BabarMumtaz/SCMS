package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Pages.FreightTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Pages.FreightListingTestPage;
import com.LilyCargo.Pages.LoginTestPage;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class FreightAddTest extends TestBeforeAndAfter {

	Logger log;

	@Test(priority = 1, description = "Verify that a user can Add/Create freight successfully", groups = {"smoke", "regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can Add/Create freight successfully by entering data in required fields")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to Add/Create freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Create freight")
	public void AddFreightTest() throws InterruptedException {

		log = LogManager.getLogger(FreightAddTest.class);
		log.info("Starting Freight Add Test.");

		pageObjectManager.getBookedFreights().clickCreateFreightBtn();
		log.info("Clicked Create Freight Button");

		pageObjectManager.getBookedFreights().enterFNO(faker.number().digits(8));

		pageObjectManager.getBookedFreights().selectETDDate("26", "09", "2024");
		log.info("Entered ETD DATE");

		pageObjectManager.getBookedFreights().selectETADate("10", "010", "2024");
		log.info("Entered ETA DATE");

		pageObjectManager.getBookedFreights().enterBLNO("BL#84575487454");

		pageObjectManager.getBookedFreights().selectClient();
		log.info("Selected Client Dropdown Value");

		pageObjectManager.getBookedFreights().selectServiceType();
		log.info("Selected Service Type Dropdown Value");

		pageObjectManager.getBookedFreights().selectShipper();
		log.info("Selected Shipper Dropdown Value");

		pageObjectManager.getBookedFreights().selectCOO();
		log.info("Selected COO");

		pageObjectManager.getBookedFreights().selectContainer();
		log.info("Selected Container Type Dropdown Value");

		pageObjectManager.getBookedFreights().enterContents("5,000");
		log.info("Entered Contents");

		pageObjectManager.getBookedFreights().enterWeights("12654");
		log.info("Entered Weights");

		pageObjectManager.getBookedFreights().enterMeasurements("85454.15");
		log.info("Entered Measurements");

		pageObjectManager.getBookedFreights().selectPortOfLoading();
		log.info("Selected Port Of Loading Dropdown Value");

		pageObjectManager.getBookedFreights().selectPortOfDischarge();
		log.info("Selected Port Of Discharge Dropdown Value");

		pageObjectManager.getBookedFreights().scrollToElement();
		Thread.sleep(2000);

		pageObjectManager.getBookedFreights().selectCarrierCompany();
		log.info("Selected Carrier Company Value");

		pageObjectManager.getBookedFreights().selectExportCompany();
		log.info("Selected Export Company Value");

		pageObjectManager.getBookedFreights().selectFreightWay();
		log.info("Selected Freight Way Value");

		pageObjectManager.getBookedFreights().clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");
		Thread.sleep(2000);

		pageObjectManager.getMenuBar().clickBookedFreightMenu();
		log.info("Clicked on Booked Freight Menu");

		Assert.assertTrue(pageObjectManager.getBookedFreights().getHeading().contains("Booked Freights"), "Heading not Matched");

		// Click on the last page of freight listings
		pageObjectManager.getFreightListing().clickOnPaginationLastPageIcon();
		log.info("Clicked on Freight Pagination Last Icon");

		// Hover over the last record
		pageObjectManager.getFreightListing().hoverOverLastRecord();
		log.info("Hovered over the last record");

		// Click on the freight ID
		pageObjectManager.getFreightListing().clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		// Switch to the new tab
		pageObjectManager.getFreightListing().switchToNewTab();
		log.info("Switched to the new tab");

		// Check if the edit wrapper is displayed
		Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit wrapper not displayed.");
		log.info("Freight Edit wrapper displayed successfully.");

		// Log out after the test
		pageObjectManager.getLoginPage().logout();
		log.info("Logged out successfully.");
	}
}