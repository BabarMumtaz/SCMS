package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class FreightEditFromListingViewTest extends TestBeforeAndAfter {

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

		// Click on the freight ID
		pageObjectManager.getFreightListing().clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		// Switch to the new tab
		pageObjectManager.getFreightListing().switchToNewTab();
		log.info("Switched to the new tab");

		// Check if the edit wrapper is displayed
		Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");

		pageObjectManager.getFreightDetail().clickOnEditFreightIconDP();
		log.info("Clicked on Booked Freight Edit Icon");

		// Check if the edit page is displayed
		Assert.assertTrue(pageObjectManager.getBookedFreights().isEditPageDisplayed(), "Edit page is not Displayed");
		log.info("Heading: " + pageObjectManager.getBookedFreights().getEditFreightID());

		pageObjectManager.getBookedFreights().enterHouseBLNO(FakeDataUtil.getHouseBLNo());
		log.info("Entered House BL No");

		pageObjectManager.getBookedFreights().clickSaveNextFreightBtn();
		log.info("Clicked Save & Next Freight Button");

		pageObjectManager.getBookedFreights().enterBondedLocation(FakeDataUtil.getBondedLocation("Netherlands"));
		log.info("Entered Bonded Location");

		pageObjectManager.getBookedFreights().clickCustomDocStatusBtn();
		log.info("Clicked Custom Doc Status Button");

		pageObjectManager.getBookedFreights().selectCustomDocStatus();
		log.info("Select Custom Doc Status Drop");

		pageObjectManager.getBookedFreights().clickPurchaseStepBtn();
		log.info("Clicked Purchase Step Button");

		pageObjectManager.getBookedFreights().enterAdminFee(FakeDataUtil.getAdminFee());
		log.info("Entered Admin Fee");

		pageObjectManager.getBookedFreights().clickSaleStepBtn();
		log.info("Clicked Sale Step Button");

		pageObjectManager.getBookedFreights().enterDuty(FakeDataUtil.getDuty());
		log.info("Entered Duty");

		pageObjectManager.getBookedFreights().clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");

		Assert.assertTrue(pageObjectManager.getFreightDetail().isUpdateBFSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
		log.info("Heading: " + pageObjectManager.getFreightDetail().getUpdatedBFSuccessAlertMessage());

		pageObjectManager.getFreightDetail().clickOnBFAlertPopupCrossIcon();
		log.info("Clicked Cross icon of Alert");

		// Log out after the test
		pageObjectManager.getLoginPage().logout();
		log.info("Logged out successfully.");
	}
}
