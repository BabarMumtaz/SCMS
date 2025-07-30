package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
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

public class ClientEditFromListingViewTest extends TestBeforeAndAfter {

	Logger log;

	@Test(priority = 1, description = "Verify that a user can edit Client successfully", groups = {"regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can edit Client successfully from the listing 1st page")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to edit Client successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Client Listing > Edit Client")
	public void VerifyClientEditTestCase() throws InterruptedException {

		log = LogManager.getLogger(ClientEditFromListingViewTest.class);
		log.info("Starting Client Edit Test from Listing Page.");

		pageObjectManager.getMenuBar().clickFreightRelationsMenu();
		log.info("Clicked Freight Relations Menu");

		pageObjectManager.getMenuBar().clickClientFRSubMenu();
		log.info("Clicked Client FR Sub Menu");

		Assert.assertTrue(pageObjectManager.getClientPage().isHeadingDisplayed(), "Heading Not Displayed");
		log.info("Client Page Heading: " + pageObjectManager.getClientPage().getPageHeading());

		pageObjectManager.getAdminOverviewTestPage().hoverAndClickIconOnRow(0, "Edit");
		log.info("Hover over on A row and click Edit Icon");

		Assert.assertTrue(pageObjectManager.getClientPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
		log.info("Client Edit Page Heading: " + pageObjectManager.getClientPage().getAddPageHeading());

		pageObjectManager.getClientPage().enterClientAddress2(faker.address().streetAddress());
		log.info("Entered Address 2");

		pageObjectManager.getClientPage().clickExtraEmailFieldCross();
		log.info("Click Extra Email Field Cross");

		pageObjectManager.getClientPage().clickExtraAddressFieldCross();
		log.info("Click Extra Address Field Cross");

		pageObjectManager.getClientPage().clickExtraPhoneFieldCross();
		log.info("Click Extra Phone Field Cross");

		pageObjectManager.getClientPage().clickSaveClientBack();
		log.info("Click Save Client Button");

		Assert.assertTrue(pageObjectManager.getClientPage().isUpdateClientSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
		log.info("Success Alert Message: " + pageObjectManager.getClientPage().getUpdatedClientSuccessAlertMessage());

		pageObjectManager.getClientPage().clickOnAlertPopupLP();
		log.info("Clicked Cross icon of Alert");

	}
}
