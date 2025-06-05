package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
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

        Assert.assertTrue(pageObjectManager.getFreightDetail().isRemarksTabDisplayed(), "Remarks tab is not displayed");
        log.info("Remarks tab is visible");

        pageObjectManager.getFreightDetail().clickRemarksTab();
        log.info("Clicked on Remarks Tab");
    }

    @Test(priority = 1, description = "Verify adding Import Remarks", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("As a user, I should be able to add Import Remarks successfully")
    @Description("Test to verify that a user can successfully add import remarks")
    public void verifyImportRemarks() {
        openRemarksTab();

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked on Add Icon for Import Remarks");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isImportRemarksPopupHeadingDisplayed(), "Import Remarks popup not visible");
        log.info("Popup Heading of Import Remark: " + pageObjectManager.getRemarksPage().getImportRemarksPopupHeading());

        pageObjectManager.getRemarksPage().enterRemarksText(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Import Remarks Text");

        pageObjectManager.getRemarksPage().clickSubmitRemarksButton();
        log.info("Clicked on Submit button for Import Remarks");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isImportRemarkSuccessAlertMessageDisplayed(), "Import Remark success alert not displayed");
        log.info("Success Alert Message For Import Remark: " + pageObjectManager.getRemarksPage().getImportRemarkSuccessAlertMessage());

        pageObjectManager.getRemarksPage().clickOnAlertPopupCrossIcon();
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

        Assert.assertTrue(pageObjectManager.getRemarksPage().isCustomsRemarksPopupHeadingDisplayed(), "Customs Remarks popup not visible");
        log.info("Popup Heading of Customs Remark: " + pageObjectManager.getRemarksPage().getCustomsRemarksPopupHeading());

        pageObjectManager.getRemarksPage().enterRemarksText(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Customs Remarks Text");

        String[] dateParts = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getRemarksPage().selectCustomsRemarksDateDate(dateParts[0], dateParts[1], dateParts[2]);
        log.info("Selected Date for Customs Remarks: " + String.join("-", dateParts));

        pageObjectManager.getRemarksPage().clickSubmitRemarksButton();
        log.info("Clicked on Submit button for Customs Remarks");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isCustomRemarkSuccessAlertMessageDisplayed(), "Customs Remark success alert not displayed");
        log.info("Success Alert Message For Customs Remark: " + pageObjectManager.getRemarksPage().getCustomRemarkSuccessAlertMessage());

        pageObjectManager.getRemarksPage().clickOnAlertPopupCrossIcon();
        log.info("Closed the success alert for Customs Remarks");
    }

    @Test(priority = 3, description = "Verify adding Sales Remarks", groups = {"regression"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("As a user, I should be able to add Sales Remarks successfully")
    @Description("Test to verify that a user can successfully add sales remarks")
    public void verifySalesRemarks() {
        openRemarksTab();

        pageObjectManager.getRemarksPage().clickSalesRemarksTab();
        log.info("Clicked on Sales Remarks Tab");

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked on Add Icon for Sales Remarks");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isSalesRemarksPopupHeadingDisplayed(), "Sales Remarks popup not visible");
        log.info("Popup Heading of Sales Remark: " + pageObjectManager.getRemarksPage().getSalesRemarksPopupHeading());

        pageObjectManager.getRemarksPage().enterRemarksText(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Sales Remarks Text");

        pageObjectManager.getRemarksPage().clickSubmitRemarksButton();
        log.info("Clicked on Submit button for Sales Remarks");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isSaleRemarkSuccessAlertMessageDisplayed(), "Sales Remark success alert not displayed");
        log.info("Success Alert Message For Sales Remark: " + pageObjectManager.getRemarksPage().getSaleRemarkSuccessAlertMessage());

        pageObjectManager.getRemarksPage().clickOnAlertPopupCrossIcon();
        log.info("Closed the success alert for Sales Remarks");

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}