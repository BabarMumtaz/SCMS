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

        // Add INTL Invoice
        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        //pageObjectManager.getBillingCenterPage().addInvoice("STANDARD", "14", productNames, scrollContainer);

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
            log.info("Added Intl Invoice Type: " + type + " for Amazon Client");
        }
    }
}
