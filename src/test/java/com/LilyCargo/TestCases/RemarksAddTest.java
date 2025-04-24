package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemarksAddTest extends TestBeforeAndAfter {

    Logger log;
    String importCustomsSalesRemarks = faker.lorem().characters(500);

    @Test(priority = 1, description = "Verify that a user can add Remarks successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Remarks successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Remarks successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Remarks Tab > Remarks")
    public void AddRemarksTest() throws InterruptedException {

        log = LogManager.getLogger(RemarksAddTest.class);
        log.info("Starting Remarks Add Test from Detail Page.");

        pageObjectManager.getFreightListing().hoverOn1stRowClient();
        log.info("Hover over 1st Row");

        // Click on the freight ID
        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(pageObjectManager.getFreightDetail().isRemarksTabDisplayed(), "Remarks tab is not Displayed");

        pageObjectManager.getFreightDetail().clickRemarksTab();
        log.info("Clicked Remarks Tab");

        //----------------------------------IMPORT REMARKS----------------------------------
        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked On Remarks Add Icon");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isImportRemarksPopupHeadingDisplayed(), "Import Remarks Popup Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getRemarksPage().getPopupHeading());

        pageObjectManager.getRemarksPage().enterRemarksText(importCustomsSalesRemarks);
        log.info("Entered Remarks Text");

        pageObjectManager.getRemarksPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getRemarksPage().clickSubmitRemarksButton();
        log.info("Clicked Submit Remarks Button");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getRemarksPage().getSuccessAlertMessage());

        //----------------------------------CUSTOMS REMARKS----------------------------------
        pageObjectManager.getRemarksPage().clickOnCustomsRemarksTab();
        log.info("Click On Customs Remarks Tab");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isCustomsRemarksPopupHeadingDisplayed(), "Import Remarks Popup Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getRemarksPage().getPopupHeading());

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked On Remarks Add Icon");

        pageObjectManager.getRemarksPage().enterRemarksText(importCustomsSalesRemarks);
        log.info("Entered Remarks Text");

        pageObjectManager.getRemarksPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getRemarksPage().selectCustomsRemarksDateDate("02", "24", "2025");
        log.info("Selected Customs Remarks DATE");

  /*      pageObjectManager.getRemarksPage().selectCustomsRemarksTime();
        log.info("Selected Customs Remarks Time");*/

        pageObjectManager.getRemarksPage().clickSubmitRemarksButton();
        log.info("Clicked Submit Remarks Button");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getRemarksPage().getSuccessAlertMessage());

        //----------------------------------SALES REMARKS----------------------------------
        pageObjectManager.getRemarksPage().clickSalesRemarksTab();
        log.info("Click On Sales Remarks Tab");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isSalesRemarksPopupHeadingDisplayed(), "Import Remarks Popup Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getRemarksPage().getPopupHeading());

        pageObjectManager.getRemarksPage().clickOnRemarksAddIcon();
        log.info("Clicked On Remarks Add Icon");

        pageObjectManager.getRemarksPage().enterRemarksText(importCustomsSalesRemarks);
        log.info("Entered Remarks Text");

        pageObjectManager.getRemarksPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getRemarksPage().clickSubmitRemarksButton();
        log.info("Clicked Submit Remarks Button");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getRemarksPage().getSuccessAlertMessage());

        pageObjectManager.getRemarksPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
