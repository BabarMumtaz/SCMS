package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AllIntlInvoicesAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add all INTL Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add all INTL Invoice successfully")
    @Epic("Booked Freights 03")
    @Feature("Feature:03.08.02_Billing Center")
    @Story("As a user, I should be able to add all INTL Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Add INTL Invoice")
    public void VerifyAllIntlInvoicesAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(AllIntlInvoicesAddTest.class);
        log.info("Starting INTL All INV Add Test from Billing Center Tab.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Fid Number is: {}", fidNumber);

        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");

        pageObjectManager.getFreightDetail().selectLastSubFID();
        Thread.sleep(500);

        pageObjectManager.getFreightDetail().clickBillingCenterTab();

        Thread.sleep(500);

        // Setup shared data
        List<String> productNames = Arrays.asList(
                "80200 - DDP Service 20 FT Container",
                "80200 - DDP Service 40 FT Container"
        );
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        // Add Other Invoice Types
        List<String> inltInvoiceTypes = Arrays.asList("STANDARD", "TAX INV", "Z-TYPE INV", "CREDIT INV", "Y-TYPE INV");
        for (String type : inltInvoiceTypes) {
            pageObjectManager.getBillingCenterPage().addInvoice(type, productNames, scrollContainer);
        }

        // Invoice types for Amazon client
        List<String> amazonIntlInvoiceTypes = Arrays.asList("STANDARD", "TAX INV", "CREDIT INV");

        // Loop through all invoice types
        for (String type : amazonIntlInvoiceTypes) {
            // Select Amazon Client before each invoice type
            pageObjectManager.getBillingCenterPage().selectClient();
            log.info("Selected Amazon EU SARL, Dutch Branch Client");

            // Add invoice for the current type
            pageObjectManager.getBillingCenterPage().addInvoice(type, productNames, scrollContainer);
            log.info("Added Intl Invoice Type: {} for Amazon Client", type);
        }
/*

        pageObjectManager.getBillingCenterPage().clickOnBilledInvoicesTab();
        log.info("Clicked on Billed Invoices Tab");

        pageObjectManager.getBillingCenterPage().clickDownloadInvoicePdfIcon();
        log.info("Clicked on Download Invoice Pdf Icon");

        String pdfDownloadSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("PDF Downloaded Success Alert is: {}", pdfDownloadSuccessAlert);
        Assert.assertEquals(pdfDownloadSuccessAlert, "PDF Downloaded", "PDF Download Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getBillingCenterPage().clickEditInvoiceIcon();
        log.info("Clicked on Invoice Edit Icon");

        pageObjectManager.getGlobalMethodsPage().clickEditDetailsBtn();
        log.info("Clicked Edit Btn");

        pageObjectManager.getBillingCenterPage().updateRemarks(FakeDataUtil.getRemarks());
        log.info("Updated Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        String updateInvoiceSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Update Invoice Success Alert is: {}", updateInvoiceSuccessAlert);
        Assert.assertEquals(updateInvoiceSuccessAlert, "Invoice Created Successfully", "Update success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getBillingCenterPage().scrollToRight();
        log.info("Scroll to Right Towards Push Icon");

        pageObjectManager.getBillingCenterPage().clickPushToExactIcon();
        log.info("Clicked on Invoice Push To Exact Icon");

        String alertText = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Initial Alert Text is: {}", alertText);

        if (alertText.equals("Invoice is being pushed to Exact.")) {
            log.warn("Invoice push is in progress. Continuing with warning check flow...");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Clicked Cross icon of Alert");

            Thread.sleep(4000);

            String pushInvoiceWarningAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("Warning Alert is: {}", pushInvoiceWarningAlert);

            Assert.assertTrue(
                    pushInvoiceWarningAlert.startsWith("Couldn't process "),
                    "Warning Alert does not contain 'Couldn't process INV#.. Check warning for details!' -> " + pushInvoiceWarningAlert
            );

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Clicked Cross icon of Warning Alert");

        } else if (alertText.equals("Please connect to Exact and get the tokens first.")) {
            log.error("Exact connection missing: {}", alertText);

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Closed Alert Popup for Exact Token Warning");

        } else {
            // fallback if unexpected alert text is found
            log.warn("Unexpected Alert Text: {}", alertText);
            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Closed Unexpected Alert Popup");
        }
*/

    }
}
