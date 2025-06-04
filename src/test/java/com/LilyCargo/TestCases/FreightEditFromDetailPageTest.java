package com.LilyCargo.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;

public class FreightEditFromDetailPageTest extends TestBeforeAndAfter {

	private Logger log;

	@Test(priority = 1, description = "Verify that a user can edit freight successfully", groups = {"regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can edit freight successfully from the Freight Detail page")
	@Epic("EP001")
	@Feature("Feature:002")
	@Story("As a user, I should be able to edit freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Edit freight")
	public void EditFreightTestFromDetailPage() throws InterruptedException {

		log = LogManager.getLogger(FreightEditFromDetailPageTest.class);
		log.info("Starting Freight Edit Test from Detail Page.");

		pageObjectManager.getFreightListing().hoverOn1stRowClient();
		log.info("Hover over 1st Row");

		pageObjectManager.getFreightListing().clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		pageObjectManager.getFreightListing().switchToNewTab();
		log.info("Switched to the new tab");

		System.out.println("After switching, active window: " + driver.getWindowHandle());
		System.out.println("All open windows: " + driver.getWindowHandles());

		Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit wrapper not displayed.");

		pageObjectManager.getFreightDetail().clickOnEditFreightIconDP();
		log.info("Clicked on Booked Freight Edit Icon");

		pageObjectManager.getBookedFreights().clickSaveNextFreightBtn();
		log.info("Clicked Save & Next Freight Button");

		pageObjectManager.getBookedFreights().enterBondedLocation("Kerkstraat 132, 1311 13 Amsterdam, Netherlands");
		log.info("Entered Bonded Location");

		pageObjectManager.getBookedFreights().clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");

		pageObjectManager.getFreightDetail().clickOnBFAlertPopupCrossIcon();
		log.info("Clicked Cross icon of Alert");

		pageObjectManager.getLoginPage().logout();
		log.info("Logged out successfully.");
	}
}