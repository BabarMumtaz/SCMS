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
import com.LilyCargo.Pages.FreightTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Pages.FreightListingTestPage;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class FreightEditFromListingViewTest extends TestBaseClass {

	Logger log;

	@BeforeMethod
	public void setup() {
		initialization(); // Opens a new browser instance

		log = LogManager.getLogger(FreightEditFromListingViewTest.class);
		log.info("Test setup completed.");

		performLogin();
	}

	private void performLogin() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Entered valid username and password.");
	}

	@Test(priority = 1, description = "Verify that a user can edit freight successfully", groups = {"regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can edit freight successfully from the listing 1st page")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to edit freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Edit freight")
	public void EditFreightTestFromListingView() throws InterruptedException {

		// Check if login is successful
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
		log.info("Login successful.");

		freightListing.hoverOn1stRowClient();
		log.info("Hover over 1st Row");

		// Click on the freight ID
		freightListing.clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		// Switch to the new tab
		freightListing.switchToNewTab();
		log.info("Switched to the new tab");

		// Check if the edit wrapper is displayed
		Assert.assertTrue(bookedFreights.isEditPageDisplayed(), "Edit Page is not Displayed");

		bookedFreights.enterHouseBLNO(faker.number().digits(5));
		log.info("Entered House BL No");

		bookedFreights.clickSaveNextFreightBtn();
		log.info("Clicked Save & Next Freight Button");

		bookedFreights.enterBondedLocation("Industrial 193, 2511 79 Rotterdam, Netherlands");
		log.info("Entered Bonded Location");

		bookedFreights.clickCustomDocStatusBtn();
		log.info("Clicked Custom Doc Status Button");

		bookedFreights.selectCustomDocStatus();
		log.info("Select Custom Doc Status Drop");

		bookedFreights.clickPurchaseStepBtn();
		log.info("Clicked Purchase Step Button");

		bookedFreights.enterAdminFee("800.25");
		log.info("Entered Admin Fee");

		bookedFreights.clickSaleStepBtn();
		log.info("Clicked Sale Step Button");

		bookedFreights.enterDuty("400,66");
		log.info("Entered Duty");

		bookedFreights.clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");

		freightDetail.clickOnAlertPopupDP();
		log.info("Clicked Cross icon of Alert");

		// Log out after the test
		loginPage.logout();
		log.info("Logged out successfully.");
	}

	@AfterMethod
	public void tearDown() {
		captureScreenshot("EditFreightTestFromListingView");
		closeBrowser();
	}

	private void captureScreenshot(String testName) {
		try {
			ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
			log.info("Screenshot captured for test: " + testName);
		} catch (IOException e) {
			log.error("Error capturing screenshot.", e);
		}
	}

	private void closeBrowser() {
		if (driver != null) {
			driver.quit();
			log.info("Browser closed successfully.");
		}
	}
}
