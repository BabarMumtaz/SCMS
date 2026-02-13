package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubFIdListTabTest extends TestBeforeAndAfter {

    private static final Logger log = LogManager.getLogger(SubFIdListTabTest.class);

    @Test(priority = 1, description = "Verify that a user can View SubFId List Tab successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can View SubFId List Tab successfully")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.02_SubFIdListTab")
    @Story("As a user, I should be able to view SubFId List Tab successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Open Freight Detail > SubFId List Tab")
    public void VerifySubFIdListTabTest() throws InterruptedException {

        pageObjectManager.getMenuBar().clickMenu("Booked Freight");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getFreightDetail().clickTab("SUB-FIDs List");
        log.info("Starting SubFId List Tab Test from Detail Page.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickAdjustExporterAndOthersButton();
        log.info("Clicked Adjust Exporter Button");

        Thread.sleep(5000);

        String adjustExporterPopupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", adjustExporterPopupHeading);
        Assert.assertEquals(adjustExporterPopupHeading, "Adjust Exporter, Shipper, House BLNo & Client Reference", "Popup heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickUpdateBtn();
        log.info("Clicked Update Button");

        String adjustExporterSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", adjustExporterSuccessAlert);
        Assert.assertEquals(adjustExporterSuccessAlert, "SUBFID updated successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task Shortcut.");

        Thread.sleep(2000);

        String mrnPopupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", mrnPopupHeading);
        Assert.assertEquals(mrnPopupHeading, "Submit / Delete MRN # / Customs Status", "Popup heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickUpdateBtn();
        log.info("Clicking Update MRN Button.");

        String mrnSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", mrnSuccessAlert);
        Assert.assertEquals(mrnSuccessAlert, "MRN already exists against SUB-FID & Customs Status updated", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Closed the success alert for Update MRN");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickDownloadExcelButton();
        log.info("Clicked on Download Excel Button");

        String exportSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", exportSuccessAlert);
        Assert.assertEquals(exportSuccessAlert, "Data exported", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

    }
}