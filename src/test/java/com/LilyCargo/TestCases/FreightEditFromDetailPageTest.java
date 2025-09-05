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
	@Epic("Booked Freight 03")
	@Feature("Feature:03.02_Edit Freight")
	@Story("As a user, I should be able to edit freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Edit freight")
	public void EditFreightTestFromDetailPage() throws InterruptedException {

		log = LogManager.getLogger(FreightEditFromDetailPageTest.class);
		log.info("Starting Freight Edit Test from Detail Page.");

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

		String pushInvoiceSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
		log.info("Success Alert is: " + pushInvoiceSuccessAlert);
		Assert.assertEquals(pushInvoiceSuccessAlert, "Freight successfully updated.", "Success Alert does not match expected value.");

		pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
		log.info("Clicked Alert Popup ");

	}
}