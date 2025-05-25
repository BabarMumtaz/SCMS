package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtraInvoiceAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add Extra Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Extra Invoice successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Extra Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Extra Invoice")
    public void VerifyExtraInvoiceCreation() throws InterruptedException {

        log = LogManager.getLogger(ExtraInvoiceAddTest.class);
        log.info("Starting EXTRA INV Add Test from Billing Center Tab");

        // Click on the freight ID
        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");
        log.info("Heading: " + pageObjectManager.getFreightDetail().getBillingCenterTabDisplayedText());

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        //----------------------------------Extra Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isExtraInvTabDisplayed(), "Extra Tab Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getExtraInvTabName());

        pageObjectManager.getBillingCenterPage().clickOnExtraInvTab();
        log.info("Clicked Extra INV Tab");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectExtraInvClient();
        log.info("Selected 'A.I. Trading GmbH' Client");

        String[] invoiceDate = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().selectExtraInvDate(invoiceDate[0], invoiceDate[1], invoiceDate[2]);
        log.info("Selected Extra Invoice DATE");

/*        // Generate the invoice number
        String generatedInvoice = pageObjectManager.getBillingCenterPage().generateInvoiceNumber();
        System.out.println("Generated Invoice Number: " + generatedInvoice);*/

        // Enter the invoice number
        pageObjectManager.getBillingCenterPage().enterExtraInvoiceNumber(FakeDataUtil.generateInvoiceNumber());
        log.info("Entered Invoice Number");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Invoice Period/Grace Days");

        pageObjectManager.getBillingCenterPage().enterExtraInvRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().selectLedgerTypeDropdown();
        log.info("Selected Ledger Type");

        pageObjectManager.getBillingCenterPage().selectExtraInvType();
        log.info("Selected Extra Invoice Type");

        pageObjectManager.getBillingCenterPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Bottom");

/*        pageObjectManager.getBillingCenterPage().selectPidDropdown();
        log.info("Selected 80210 - 2% Disbursement Fee Product");*/

        pageObjectManager.getBillingCenterPage().scrollToSubmitButton();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getBillingCenterPage().clickSubmitINVButton();
        log.info("Clicked Submit INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
