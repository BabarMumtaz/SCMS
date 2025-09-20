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

public class AllEuInvoicesAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add EU Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add EU Invoice successfully")
    @Epic("Booked Freights 03")
    @Feature("Feature:03.08.03_Billing Center")
    @Story("As a user, I should be able to add EU Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Add EU Invoice")
    public void VerifyAllEuInvoicesAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(AllEuInvoicesAddTest.class);
        log.info("Starting EU All INV Add Test from Billing Center Tab.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");

        pageObjectManager.getFreightDetail().selectLastSubFID();
        Thread.sleep(500);

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        pageObjectManager.getBillingCenterPage().clickOnEulInvTab();
        log.info("Clicked EU INV Tab");

        Thread.sleep(500);

        // Setup shared data
        List<String> productNames = Arrays.asList(
                "80100 - DDP Service 20 FT",
                "80100 - DDP Service 40 FT",
                "80100 - DDP Service 45 HQ"
        );
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        // Add EU Invoice
        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        //pageObjectManager.getBillingCenterPage().addInvoice("STANDARD", "14", productNames, scrollContainer);

        // Add Other Invoice Types
        List<String> euInvoiceTypes = Arrays.asList("STANDARD", "TAX INV", "Z-TYPE INV", "CREDIT INV", "Y-TYPE INV");
        for (String type : euInvoiceTypes) {
            pageObjectManager.getBillingCenterPage().addInvoice(type, productNames, scrollContainer);
        }


        // Invoice types for Amazon client
        List<String> amazonClientEuInvoiceTypes = Arrays.asList("STANDARD", "CREDIT INV");

        // Loop through all invoice types
        for (String type : amazonClientEuInvoiceTypes) {
            // Select Amazon Client before each invoice type
            pageObjectManager.getBillingCenterPage().selectClient();
            log.info("Selected EU SARL, Dutch Branch Client");

            // Add invoice for the current type
            pageObjectManager.getBillingCenterPage().addInvoice(type, productNames, scrollContainer);
            log.info("Added EU Invoice Type: " + type + " for Amazon Client");
        }


        List<String> euAmazonInvoiceTypes = Arrays.asList("AMAZON BROKERAGE INV", "AMAZON DUTY INV");

        // Loop through all invoice types
        for (String type : euAmazonInvoiceTypes) {
            // Select Amazon Client before each invoice type
            pageObjectManager.getBillingCenterPage().selectClient();
            log.info("Selected Amazon EU SARL, Dutch Branch Client");

            // Add invoice for the current type
            pageObjectManager.getBillingCenterPage().addAmazonInvoice(type);
            log.info("Added Amazon Invoice Type: " + type + " for Amazon Client");
        }

        pageObjectManager.getBillingCenterPage().clickOnBilledInvoicesTab();
        log.info("Clicked on Billed Invoices Tab");

        pageObjectManager.getBillingCenterPage().clickDownloadInvoicePdfIcon();
        log.info("Clicked on Download Invoice Pdf Icon");

        pageObjectManager.getBillingCenterPage().clickEditInvoiceIcon();
        log.info("Clicked on Invoice Edit Icon");

        pageObjectManager.getGlobalMethodsPage().clickEditDetailsBtn();
        log.info("Clicked Edit Btn");

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Update Invoice Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Invoice Created Successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getBillingCenterPage().clickPushToExactIcon();
        log.info("Clicked on Invoice Push To Exact Icon");

        String pushInvoiceSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Update Invoice Success Alert is: " + pushInvoiceSuccessAlert);
        Assert.assertEquals(pushInvoiceSuccessAlert, "Invoice Created Successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");
    }
}