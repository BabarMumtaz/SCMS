package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import com.LilyCargo.Util.FileUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemarksAddTest extends TestBeforeAndAfter {

    Logger log = LogManager.getLogger(RemarksAddTest.class);

    public void openRemarksTab() {
        log.info("Starting Remarks Test Setup");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the first Freight ID row");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to new browser tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);

        String tabHeading = pageObjectManager.getFreightDetail().getRemarksTabText();
        log.info("Tab Heading is: {}", tabHeading);
        Assert.assertEquals(tabHeading, "Remarks", "Page heading does not match expected value.");

        pageObjectManager.getFreightDetail().clickRemarksTab();
        log.info("Clicked on Remarks Tab");
    }

    @Test(priority = 1, description = "Verify adding Import Remarks", groups = {"smoke", "regression"}, enabled = true)
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Booked Freight 03")
    @Feature("Feature:03.06_Remarks")
    @Story("As a user, I should be able to add Import Remarks successfully")
    @Description("Test to verify that a user can successfully add import remarks")
    public void verifyImportRemarks() {
        openRemarksTab();

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked on Add Icon for Import Remarks");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Import Remarks", "Popup heading does not match expected value.");

        pageObjectManager.getRemarksPage().enterRemarksText(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Import Remarks Text");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked on Submit button for Import Remarks");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Import Remark added successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Closed the success alert for Import Remarks");
    }

    @Test(priority = 2, description = "Verify adding Customs Remarks", groups = {"regression"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("As a user, I should be able to add Customs Remarks successfully")
    @Description("Test to verify that a user can successfully add customs remarks")
    public void verifyCustomsRemarks() {
        openRemarksTab();

        pageObjectManager.getRemarksPage().clickOnCustomsRemarksTab();
        log.info("Clicked on Customs Remarks Tab");

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked on Add Icon for Customs Remarks");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Customs Remarks Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Customs Remarks", "Popup heading does not match expected value.");

        pageObjectManager.getRemarksPage().enterRemarksText(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Customs Remarks Text");

        String[] dateParts = FakeDataUtil.getDayMonthYear();
        pageObjectManager.getRemarksPage().selectCustomsRemarksDate(dateParts[0], dateParts[1], dateParts[2]);
        log.info("Selected Date for Customs Remarks: {}", String.join("-", dateParts));

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked on Submit button for Customs Remarks");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Customs Remarks Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Custom Remark added successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Closed the success alert for Customs Remarks");
    }

    @Test(priority = 3, description = "Verify adding Sales Remarks", groups = {"regression"}, enabled = true)
    @Severity(SeverityLevel.CRITICAL)
    @Story("As a user, I should be able to add Sales Remarks successfully")
    @Description("Test to verify that a user can successfully add sales remarks")
    public void verifySalesRemarks() {
        openRemarksTab();

        pageObjectManager.getRemarksPage().clickSalesRemarksTab();
        log.info("Clicked on Sales Remarks Tab");

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked on Add Icon for Sales Remarks");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Sales Remark Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Sales Remarks", "Popup heading does not match expected value.");

        pageObjectManager.getRemarksPage().enterRemarksText(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Sales Remarks Text");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked on Submit button for Sales Remarks");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Sales Remarks Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Sales Remark added successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Closed the success alert for Sales Remarks");

    }
}