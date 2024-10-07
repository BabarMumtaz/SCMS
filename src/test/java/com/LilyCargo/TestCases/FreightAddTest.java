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
import com.LilyCargo.Pages.BookedFreightTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Pages.FreightListingTestPage;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
import com.LilyCargo.Util.TestUtilClass;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class FreightAddTest extends TestBaseClass {

	LoginTestPage loginPage;
	MenuBarTestPage menuBar;
	BookedFreightTestPage bookedFreights;
	FreightListingTestPage freightListing;
	FreightDetailTestPage freightDetail;
	JavascriptExecutor js;
	Faker faker;
	WebDriverWait wait;
	Logger log;

	@BeforeMethod
	public void setup() {
		initialization(); // Opens a new browser instance
		loginPage = PageFactory.initElements(driver, LoginTestPage.class);
		menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
		bookedFreights = PageFactory.initElements(driver, BookedFreightTestPage.class);
		freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
		freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class);

		faker = new Faker();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		log = LogManager.getLogger(FreightAddTest.class);
		log.info("Test setup completed.");

		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Entered Valid Username and Password.");
	}

	@Test(priority = 1, description = "Verify that a user can Add/Create freight successfully", groups = {"smoke", "regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can Add/Create freight successfully by entering data in required fields")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to Add/Create freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Create freight")
	public void AddFreightTest() throws InterruptedException {

		// Check if login is successful
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
		log.info("Login successful.");

		bookedFreights.clickCreateFreightBtn();
		log.info("Clicked Create Freight Button");

		bookedFreights.enterFNO(faker.number().digits(8));

		bookedFreights.selectETDDate("26", "09", "2024");
		log.info("Entered ETD DATE");

		bookedFreights.selectETADate("10", "010", "2024");
		log.info("Entered ETA DATE");

		bookedFreights.enterBLNO("BL#84575487454");

		bookedFreights.selectClient();
		log.info("Selected Client Dropdown Value");

		bookedFreights.selectServiceType();
		log.info("Selected Service Type Dropdown Value");

		bookedFreights.selectShipper();
		log.info("Selected Shipper Dropdown Value");

		bookedFreights.selectCOO();
		log.info("Selected COO");

		bookedFreights.selectContainer();
		log.info("Selected Container Type Dropdown Value");

		bookedFreights.enterContents("5,000");
		log.info("Entered Contents");

		bookedFreights.enterWeights("12654");
		log.info("Entered Weights");

		bookedFreights.enterMeasurements("85454.15");
		log.info("Entered Measurements");

		bookedFreights.selectPortOfLoading();
		log.info("Selected Port Of Loading Dropdown Value");

		bookedFreights.selectPortOfDischarge();
		log.info("Selected Port Of Discharge Dropdown Value");

		bookedFreights.scrollToElement();
		Thread.sleep(2000);

		bookedFreights.selectCarrierCompany();
		log.info("Selected Carrier Company Value");

		bookedFreights.selectExportCompany();
		log.info("Selected Export Company Value");

		bookedFreights.selectFreightWay();
		log.info("Selected Freight Way Value");

		bookedFreights.clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");
		Thread.sleep(2000);

		menuBar.clickBookedFreightMenu();
		log.info("Clicked on Booked Freight Menu");

		Assert.assertTrue(bookedFreights.getHeading().contains("Booked Freights"), "Heading not Matched");

		// Click on the last page of freight listings
		freightListing.clickOnPaginationLastPageIcon();
		log.info("Clicked on Freight Pagination Last Icon");

		// Hover over the last record
		freightListing.hoverOverLastRecord();
		log.info("Hovered over the last record");

		// Click on the view freight icon
		freightListing.clickOnViewFreightIcon();
		log.info("Clicked on View Icon");

		// Switch to the new tab
		freightListing.switchToNewTab();
		log.info("Switched to the new tab");

		// Check if the edit wrapper is displayed
		Assert.assertTrue(freightDetail.isEditFreightIconDisplayed(), "Edit wrapper not displayed.");
		log.info("Freight Edit wrapper displayed successfully.");

		// Log out after the test
		loginPage.logout();
		log.info("Logged out successfully.");
	}

	@AfterMethod
	public void tearDown() throws IOException {
		ScreenShotUtil.takeScreenshotAtEndOfTest(driver, "AddFreightTest");
		if (driver != null) {
			driver.quit(); // Closes the browser instance after each test method
			log.info("Browser closed successfully.");
		}
	}
}
