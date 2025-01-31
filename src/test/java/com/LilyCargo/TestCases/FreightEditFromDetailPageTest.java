package com.LilyCargo.TestCases;

import java.io.IOException;

import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import io.qameta.allure.*;

public class FreightEditFromDetailPageTest extends TestBaseClass {

	private Logger log;

	@BeforeMethod
	public void setup() {
		initialization();
		log = LogManager.getLogger(FreightEditFromDetailPageTest.class);
		log.info("Test setup completed.");
		performLogin();
	}

	private void performLogin() {
		if (loginPage == null) {
			loginPage = PageFactory.initElements(driver, LoginTestPage.class);
		}
		log.info("Attempting to log in with username: " + prop.getProperty("username"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
		log.info("Login successful.");
	}

	@Test(priority = 1, description = "Verify that a user can edit freight successfully", groups = {"regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can edit freight successfully from the Freight Detail page")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to edit freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Edit freight")
	public void EditFreightTestFromDetailPage() throws InterruptedException {

		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
		log.info("Login successful.");

		if (freightListing == null) {
			freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
		}
		freightListing.hoverOn1stRowClient();
		log.info("Hover over 1st Row");

		freightListing.clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		freightListing.switchToNewTab();
		log.info("Switched to the new tab");

		Assert.assertTrue(freightDetail.isEditFreightIconDisplayed(), "Edit wrapper not displayed.");
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

		loginPage.logout();
		log.info("Logged out successfully.");
	}

	@AfterMethod
	public void tearDown() {
		captureScreenshot("EditFreightTestFromDetailPage");
		if (driver != null) {
			driver.quit();
			log.info("Browser closed successfully.");
		}
	}

	private void captureScreenshot(String testName) {
		try {
			ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
			log.info("Screenshot captured for test: " + testName);
		} catch (IOException e) {
			log.error("Error capturing screenshot.", e);
		}
	}
}