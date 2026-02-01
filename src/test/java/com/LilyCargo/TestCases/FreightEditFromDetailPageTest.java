package com.LilyCargo.TestCases;

import com.LilyCargo.Util.FakeDataUtil;
import com.LilyCargo.Util.FileUtil;
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
	public void EditFreightTestFromDetailPage(){

		log = LogManager.getLogger(FreightEditFromDetailPageTest.class);
		log.info("Starting Freight Edit Test from Detail Page.");

		pageObjectManager.getMenuBar().clickBookedFreightMenu();
		log.info("Clicked Booked Freight Button");

		String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
		log.info("Page Heading is: {}", pageHeading);
		Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

		String fidToSearch = FileUtil.getData("FreightID");
		pageObjectManager.getFreightListing().searchFid(fidToSearch);
		String searchedFid = pageObjectManager.getFreightListing().getSearchResultFid();
		Assert.assertEquals(searchedFid, fidToSearch, "Searched FId does not match expected value.");

		pageObjectManager.getFreightListing().clickOnFreightID();
		log.info("Clicked on the 1st row FreightID.");

		pageObjectManager.getFreightListing().switchToNewTab();
		log.info("Switched to the new tab");

		System.out.println("After switching, active window: " + driver.getWindowHandle());
		System.out.println("All open windows: " + driver.getWindowHandles());

		Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit wrapper not displayed.");

		String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
		log.info("Fid Number is: {}", fidNumber);

		pageObjectManager.getFreightDetail().clickOnEditFreightIconDP();
		log.info("Clicked on Booked Freight Edit Icon");

		String editPageHeading = pageObjectManager.getBookedFreights().getAddPageHeading();
		log.info("Edit Page Heading is: {}", editPageHeading);
		// Assert that heading starts with "Edit ID:" ""editPageHeading.startsWith("Edit ID:"), OR Contains
		Assert.assertTrue(editPageHeading.contains("Edit ID:"), "Edit Page heading does not contain 'Edit ID:'. Found: " + editPageHeading);

		pageObjectManager.getBookedFreights().clickSaveNextFreightBtn();
		log.info("Clicked Save & Next Freight Button");

		pageObjectManager.getBookedFreights().selectLogisticsType("FTL");
		log.info("Selected Logistics Type From Dropdown");

		pageObjectManager.getBookedFreights().selectWarehouseName("DE - DTM2 - Amazon");
		log.info("Selected Warehouse Name From Dropdown");

		pageObjectManager.getBookedFreights().selectNotifyParty("LILY MAAS LOGISTICS");
		log.info("Selected Notify Party From Dropdown");

		pageObjectManager.getBookedFreights().selectBroker("NL DKM (LMLOG)");
		log.info("Selected Broker From Dropdown");

		pageObjectManager.getBookedFreights().selectLFR("NL LMLOG Fiscal Rep (Import)");
		log.info("Selected LFR From Dropdown");

		pageObjectManager.getBookedFreights().selectFreightManager("Ciano Huang");
		log.info("Selected Freight Manager From Dropdown");

		pageObjectManager.getBookedFreights().selectLogistics("DGF HAM ICC");
		log.info("Selected Logistics From Dropdown");

		pageObjectManager.getBookedFreights().selectCustoms("DMS");
		log.info("Selected Customs From Dropdown");

		pageObjectManager.getBookedFreights().enterPreviousDocumentNumber(FakeDataUtil.getString());
		log.info("Entered Previous Document Number");

		pageObjectManager.getBookedFreights().enterBondedLocation(faker.address().fullAddress());
		log.info("Entered Bonded Location");

		pageObjectManager.getBookedFreights().enterInvoiceNo(FakeDataUtil.generateInvoiceNumber());
		log.info("Entered Invoice No");

		pageObjectManager.getBookedFreights().enterInvoiceValueInEUR(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Invoice Value EUR");

		pageObjectManager.getBookedFreights().selectVatProcedure("Paid");
		log.info("Selected VAT Procedure From Dropdown");

		pageObjectManager.getBookedFreights().selectTHCInvImpDate();
		log.info("Entered THC Inv Imp DATE: 1 Month in Future from Current Date");

		pageObjectManager.getBookedFreights().enterPinCode("1234");
		log.info("Entered Pin Code");

		pageObjectManager.getBookedFreights().selectPinExpireDate();
		log.info("Entered Pin Expire DATE: 1 Year in Future from Current Date");

		pageObjectManager.getBookedFreights().selectTruckingCo("DFDS WAREHOUSING");
		log.info("Selected Trucking Co From Dropdown");

		pageObjectManager.getBookedFreights().selectTruckingDate();
		log.info("Entered Trucking DATE: 1 Month in Future from Current Date");

		pageObjectManager.getBookedFreights().selectFreightBook("Douane Nederland");
		log.info("Selected Freight Book From Dropdown");

		pageObjectManager.getBookedFreights().selectInvoiceDate();
		log.info("Entered Invoice DATE: Current Date");

		pageObjectManager.getBookedFreights().selectAdditionalParty("Schavemaker");
		log.info("Selected Additional Party From Dropdown");

		pageObjectManager.getBookedFreights().selectAdjustOperator("LMLOG");
		log.info("Selected Adjust Operator From Dropdown");

		pageObjectManager.getBookedFreights().clickSaveNextFreightBtn();
		log.info("Clicked Customs Status Button");

		pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
		log.info("Clicked Alert Popup Cross Icon");

		pageObjectManager.getBookedFreights().selectCustomDocStatus("unsent");
		log.info("Selected Custom Doc Status From Dropdown");

		pageObjectManager.getBookedFreights().selectCustomsClearanceServices("Complete");
		log.info("Selected Customs Clearance Services From Dropdown");

		pageObjectManager.getBookedFreights().clickPurchaseStepBtn();
		log.info("Clicked Purchase Step Button");

/*		pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
		log.info("Clicked Alert Popup Cross Icon");*/

		pageObjectManager.getBookedFreights().enterAdminFee(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Admin Fee");

		pageObjectManager.getBookedFreights().enterAirportHandlingFee(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Airport Handling Fee");

		pageObjectManager.getBookedFreights().enterArrivalStorageFee(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Arrival Storage Fee");

		pageObjectManager.getBookedFreights().enterGasMeasurementCharge(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Gas Measurement Charge");

		pageObjectManager.getBookedFreights().enterFreightPurchaseUsdFee(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Freight Purchase Usd Fee");

		pageObjectManager.getBookedFreights().clickSaleStepBtn();
		log.info("Clicked Sales Step Button");

		pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
		log.info("Clicked Alert Popup Cross Icon");

		pageObjectManager.getBookedFreights().enterDeliveryCharges(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Delivery Charges");

		pageObjectManager.getBookedFreights().enterDuty(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Duty");

		pageObjectManager.getBookedFreights().enterVatEurFee(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Vat Eur Fee");

		pageObjectManager.getBookedFreights().enterFreightCharge(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Freight Charge");

		pageObjectManager.getBookedFreights().enterFreightSaleUsdFee(FakeDataUtil.getNumberWith2Decimal());
		log.info("Entered Freight Sale Usd Fee");

		pageObjectManager.getBookedFreights().clickSaveReturnFreightBtn();
		log.info("Clicked Save & Return Freight Button");

		String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
		log.info("Success Alert is: {}", successAlert);
		Assert.assertEquals(successAlert, "Freight successfully updated.", "Success Alert does not match expected value.");

		pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
		log.info("Clicked Alert Popup Cross Icon");

	}
}