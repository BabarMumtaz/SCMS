package com.LilyCargo.TestCases;

import com.LilyCargo.Util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.LilyCargo.Util.FakeDataUtil;

import org.testng.annotations.Test;
import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class FreightAddTest extends TestBeforeAndAfter {

	Logger log;

	@Test(priority = 1, description = "Verify that a user can Add/Create freight successfully", groups = {"smoke", "regression"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that a user can Add/Create freight successfully by entering data in required fields")
	@Epic("Booked Freight 03")
	@Feature("Feature:03_Create Freight")
	@Story("As a user, I should be able to Add/Create freight successfully")
	@Step("Hit Site Url -> Login with valid credentials -> Create freight")
	public void VerifyFreightCreation(){

        log = LogManager.getLogger(FreightAddTest.class);
        log.info("Starting Freight Add Test.");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        pageObjectManager.getBookedFreights().clickCreateFreightBtn();
        log.info("Clicked Create Freight Button");

        String addPageHeading = pageObjectManager.getBookedFreights().getAddPageHeading();
        log.info("Add Page Heading is: {}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Create New Freight", "Add Page heading does not match expected value.");

        pageObjectManager.getBookedFreights().enterFNO(FakeDataUtil.getRandomNumber());
        log.info("Entered FNO");

        pageObjectManager.getBookedFreights().selectEtdDate();
        log.info("Entered ETD DATE: Current Date");

        pageObjectManager.getBookedFreights().selectEtaDate();
        log.info("Entered ETA DATE: 10 Days in Future from Current Date");

        pageObjectManager.getBookedFreights().enterContainerNumber(FakeDataUtil.getString());
        log.info("Entered Container Number");

        pageObjectManager.getBookedFreights().enterClientReference(FakeDataUtil.getString());
        log.info("Entered Client Ref");

        pageObjectManager.getBookedFreights().enterBLNO(FakeDataUtil.getString());
        log.info("Entered BLNo");

        pageObjectManager.getBookedFreights().enterHouseBLNO(FakeDataUtil.getString());
        log.info("Entered SubFid House BL No");

        pageObjectManager.getBookedFreights().selectClient("Amazon EU SARL, Dutch Branch");
        log.info("Selected Client Dropdown Value");

        pageObjectManager.getBookedFreights().selectServiceType("Clear");
        log.info("Selected Service Type Dropdown Value");

        pageObjectManager.getBookedFreights().selectShipper("ShenZhen JingSen");
        log.info("Selected Shipper Dropdown Value");

        pageObjectManager.getBookedFreights().selectCOO("TURKEY");
        log.info("Selected COO");

        pageObjectManager.getBookedFreights().selectContainerType("40RFT");
        log.info("Selected Container Type Dropdown Value");

        pageObjectManager.getBookedFreights().enterContents(FakeDataUtil.getNumberWithoutDecimal());
        log.info("Entered Contents");

        pageObjectManager.getBookedFreights().enterWeights(FakeDataUtil.getNumberWith2Decimal());
        log.info("Entered Weights");

        pageObjectManager.getBookedFreights().enterMeasurements(FakeDataUtil.getNumberWith2Decimal());
        log.info("Entered Measurements");

        pageObjectManager.getBookedFreights().selectPortOfLoading("Shantou Port");
        log.info("Selected Port Of Loading Dropdown Value");

        pageObjectManager.getBookedFreights().selectCutOffDate();
        log.info("Entered Cut OFf Date: Current Date");

        pageObjectManager.getBookedFreights().selectCutOffTime("18:40");
        log.info("Entered Cut OFf Time");

        pageObjectManager.getBookedFreights().selectPortOfDischarge("Hong Kong");
        log.info("Selected Port Of Discharge Dropdown Value");

        pageObjectManager.getBookedFreights().selectCarrierCompany("Cathy Pacific");
        log.info("Selected Carrier Company Value");

        pageObjectManager.getBookedFreights().selectExportCompany("BEIJING CENTURY");
        log.info("Selected Export Company Value");

        pageObjectManager.getBookedFreights().selectFreightWay("Air");
        log.info("Selected Freight Way Value");

        pageObjectManager.getBookedFreights().enterVesselName(FakeDataUtil.getRandomCountry());
        log.info("Entered Vessel Name");

        pageObjectManager.getBookedFreights().enterServVoyage(FakeDataUtil.getString());
        log.info("Entered Serv. Voyage");

        pageObjectManager.getBookedFreights().enterImoNo(FakeDataUtil.getRandomNumber());
        log.info("Entered IMO No");

        pageObjectManager.getBookedFreights().selectVesselFlag("TURKEY");
        log.info("Selected Vessel Flag");

        pageObjectManager.getBookedFreights().enterAirFlightNo(FakeDataUtil.getRandomNumber());
        log.info("Entered Airflight No");

        pageObjectManager.getBookedFreights().selectAirlineFlag("TURKEY");
        log.info("Selected Airline Flag");

        pageObjectManager.getBookedFreights().selectAtaDate();
        log.info("Entered ATA DATE: 10 Days in Future from Current Date");

        pageObjectManager.getBookedFreights().clickSaveReturnFreightBtn();
        log.info("Clicked Save & Return Freight Button");

        String pushInvoiceSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", pushInvoiceSuccessAlert);
        Assert.assertEquals(pushInvoiceSuccessAlert, "Freight successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        FileUtil.saveData("FreightID", fidNumber);
        log.info("Stored Fid Number for reuse: {}", fidNumber);

    }
}