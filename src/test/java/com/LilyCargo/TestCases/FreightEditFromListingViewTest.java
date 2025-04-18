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

	@Test(priority = 1, description = "Verify that a user can edit freight successfully", groups = {"regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can edit freight successfully from the listing 1st page")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to edit freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Edit freight")
	public void EditFreightTestFromListingView() throws InterruptedException {

		log = LogManager.getLogger(FreightEditFromListingViewTest.class);
		log.info("Starting Freight Edit Test from Listing Page.");

		pageObjectManager.getFreightListing().hoverOn1stRowClient();
		log.info("Hover over 1st Row");

		// Click on the freight ID
		pageObjectManager.getFreightListing().clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		// Switch to the new tab
		pageObjectManager.getFreightListing().switchToNewTab();
		log.info("Switched to the new tab");

		// Check if the edit wrapper is displayed
		Assert.assertTrue(pageObjectManager.getBookedFreights().isEditPageDisplayed(), "Edit Page is not Displayed");

		pageObjectManager.getBookedFreights().enterHouseBLNO(faker.number().digits(5));
		log.info("Entered House BL No");

		pageObjectManager.getBookedFreights().clickSaveNextFreightBtn();
		log.info("Clicked Save & Next Freight Button");

		pageObjectManager.getBookedFreights().enterBondedLocation("Industrial 193, 2511 79 Rotterdam, Netherlands");
		log.info("Entered Bonded Location");

		pageObjectManager.getBookedFreights().clickCustomDocStatusBtn();
		log.info("Clicked Custom Doc Status Button");

		pageObjectManager.getBookedFreights().selectCustomDocStatus();
		log.info("Select Custom Doc Status Drop");

		pageObjectManager.getBookedFreights().clickPurchaseStepBtn();
		log.info("Clicked Purchase Step Button");

		pageObjectManager.getBookedFreights().enterAdminFee("800.25");
		log.info("Entered Admin Fee");

		pageObjectManager.getBookedFreights().clickSaleStepBtn();
		log.info("Clicked Sale Step Button");

		pageObjectManager.getBookedFreights().enterDuty("400,66");
		log.info("Entered Duty");

		pageObjectManager.getBookedFreights().clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");

		pageObjectManager.getFreightDetail().clickOnAlertPopupDP();
		log.info("Clicked Cross icon of Alert");

		// Log out after the test
		pageObjectManager.getLoginPage().logout();
		log.info("Logged out successfully.");
	}
}
