package com.LilyCargo.TestCases;

import java.io.IOException;

import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
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

public class FreightEditFromDetailPageTest extends TestBaseClass {

	LoginTestPage loginPage;
	MenuBarTestPage menuBar;
	BookedFreightTestPage bookedFreights;
	FreightListingTestPage freightListing;
	FreightDetailTestPage freightDetail;
	JavascriptExecutor js;
	Faker faker;
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
		log = LogManager.getLogger(FreightEditFromDetailPageTest.class);
		log.info("Test setup completed.");

		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Entered Valid Username and Password.");
	}

	@Test(priority = 1, description = "Verify that a user can edit freight successfully", groups = {"regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can edit freight successfully from the Freight Detail page")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to edit freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Edit freight")
	public void EditFreightTestFromDetailPage() throws InterruptedException {

		// Check if login is successful
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
		log.info("Login successful.");

		freightListing.hoverOn1stRowClient();
		log.info("Hover over 1st Row");

		freightListing.clickOnViewFreightIcon();
		log.info("Hover over View Icon and click");

		// Switch to the new tab
		freightListing.switchToNewTab();
		log.info("Switched to the new tab");

		// Check if the edit wrapper is displayed
		Assert.assertTrue(freightDetail.isEditFreightIconDisplayed(), "Edit wrapper not displayed.");

		// Clicked on Booked Freight Edit Icon On Detail Page
		freightDetail.clickOnEditFreightIconDP();
		log.info("Clicked on Booked Freight Edit Icon");

		bookedFreights.clickSaveNextFreightBtn();
		log.info("Clicked Save & Next Freight Button");

		bookedFreights.enterBondedLocation("Kerkstraat 132, 1311 13 Amsterdam, Netherlands");
		log.info("Entered Bonded Location");

		bookedFreights.clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");

		freightDetail.clickOnAlertPopupDP();
		log.info("Clicked Cross icon of Alert");

		// Log out after the test
		loginPage.logout();
		log.info("Logged out successfully.");
	}

	@AfterMethod
	public void tearDown() throws IOException {
		ScreenShotUtil.takeScreenshotAtEndOfTest(driver, "EditFreightTestFromDetailPage");
		if (driver != null) {
			driver.quit(); // Closes the browser instance after each test method
			log.info("Browser closed successfully.");
		}
	}
}
