package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntlInvoiceAddTest extends TestBaseClass {

    Logger log;
    String InvoiceRemarksText = faker.lorem().characters(100);

    @Test(priority = 1, description = "Verify that a user can add INTL Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add INTL Invoice successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add INTL Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Add INTL Invoice")
    public void AddIntlInvoiceTest() throws InterruptedException {

        log = LogManager.getLogger(IntlInvoiceAddTest.class);
        log.info("Starting INTL INV Add Test from Detail Page.");

        pageObjectManager.getFreightListing().hoverOn1stRowClient();
        log.info("Hover over 1st Row");

        // Click on the freight ID
        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        //----------------------------------INTL Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().clickOnClientDropdownCrossIcon();
        log.info("Clicked On Client Dropdown Cross Icon");

        pageObjectManager.getBillingCenterPage().selectClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client");

/*        pageObjectManager.getBillingCenterPage().selectInvoiceType();
        log.info("Selected Invoice Type");*/

        pageObjectManager.getBillingCenterPage().enterRemarks(InvoiceRemarksText);
        log.info("Entered Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().selectIntlEuInvDate("02", "24", "2025");
        log.info("Selected Intl Invoice DATE");

        // Generate the invoice number
        String generatedInvoice = pageObjectManager.getBillingCenterPage().generateInvoiceNumber();
        System.out.println("Generated Invoice Number: " + generatedInvoice);

        // Enter the invoice number
        pageObjectManager.getBillingCenterPage().enterInvoiceNumber(generatedInvoice);
        log.info("Entered Invoice Number");

        pageObjectManager.getBillingCenterPage().enterGraceDays("14");
        log.info("Entered Grace Days");

        pageObjectManager.getBillingCenterPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Bottom");

        pageObjectManager.getBillingCenterPage().selectPidDropdown();
        log.info("Selected 80210 - 2% Disbursement Fee Product");

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Finish Button.");

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
