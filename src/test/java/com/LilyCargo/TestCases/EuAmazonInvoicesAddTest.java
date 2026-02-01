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

public class EuAmazonInvoicesAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 0, description = "Verify that a user can add EU Invoice successfully using Amazon Brokerage INV Type", groups = {"smoke", "regression",}, enabled = true)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add EU Invoice successfully using Amazon Brokerage INV Type")
    @Epic("Booked Freights 03")
    @Feature("Feature:03.08.05_Billing Center")
    @Story("As a user, I should be able to add EU Invoice successfully using Amazon Brokerage INV Type")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > EU Invoice")
    public void VerifyEUAmazonBrokerageInvoiceCreation() throws InterruptedException {

        log = LogManager.getLogger(EuAmazonInvoicesAddTest.class);
        log.info("Starting EUAmazonBrokerage INV Add Test from Billing Center Tab");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");
        log.info("Tab Heading: " + pageObjectManager.getFreightDetail().getBillingCenterTabDisplayedText());

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        //----------------------------------EU Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isEuInvTabDisplayed(), "EU Tab Not Displayed");
        log.info("Tab Heading: " + pageObjectManager.getBillingCenterPage().getEuInvTabName());

        pageObjectManager.getBillingCenterPage().clickOnEulInvTab();
        log.info("Clicked EU INV Tab");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Section Heading: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client");

        pageObjectManager.getBillingCenterPage().selectAmazonBrokerageInvoiceType();
        log.info("Selected 'Amazon Brokerage'  Invoice Type");

        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().enterGraceDays("21");
        log.info("Entered Grace Days");

        List<String> productNames = Arrays.asList(
                "80120 - CEC - Export Customs Clearance",
                "23016 - CBAM TAX",
                "80120 - CBAM 3+ HS Lines",
                "80120 - CBAM Filing Charge",
                "80199 - PGH - Partner Government Agency Handling"
        );

        List<Integer> vatApplicableIndexes = Arrays.asList(0, 2);
        String vatValue = "2";
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        // Start from PID row 4
        int startingRowIndex = 4;

        for (int j = 0; j < productNames.size(); j++) {
            int currentRow = startingRowIndex + j;

            String product = productNames.get(j);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(currentRow, product, scrollContainer);

            if (vatApplicableIndexes.contains(j)) {
                pageObjectManager.getBillingCenterPage().selectVatDropdownByIndexValue(currentRow, vatValue, scrollContainer);
            }
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message 1st Time: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

    }

//--------------------------------------------------------------------------------------------

    @Test(priority = 1, description = "Verify that a user can add EU Invoice successfully using Amazon DUTY INV Type", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add EU Invoice successfully using Amazon DUTY INV Type")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add EU Invoice successfully using Amazon DUTY INV Type")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > EU Invoice")
    public void VerifyEUAmazonDutyInvoiceCreation() throws InterruptedException {

        log = LogManager.getLogger(EuAmazonInvoicesAddTest.class);
        log.info("Starting EuAmazon Duty Invoice Add Test from Billing Center Tab");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID 2nd Time");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab 2nd Time");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");
        log.info("Heading 2nd Time: " + pageObjectManager.getFreightDetail().getBillingCenterTabDisplayedText());

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab ");

        //----------------------------------EU Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isEuInvTabDisplayed(), "EU Tab Not Displayed");
        log.info("Page Heading 2nd Time: " + pageObjectManager.getBillingCenterPage().getEuInvTabName());

        pageObjectManager.getBillingCenterPage().clickOnEulInvTab();
        log.info("Clicked EU INV Tab for Amazon Duty INV Type");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Heading 2nd Time: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client for Amazon Duty INV Type");

        pageObjectManager.getBillingCenterPage().selectAmazonDutyInvoiceType();
        log.info("Selected 'Amazon Duty'  Invoice Type");

        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text for Amazon Duty INV Type");

        pageObjectManager.getBillingCenterPage().enterGraceDays("21");
        log.info("Entered Grace Days for Amazon Duty INV Type");

        List<String> productNames = Arrays.asList(
                "23015 - IVT - Import duty ( to replace VAT)",
                "23015 - DUT - Duty",
                "23016 - VAT - VAT fees"
        );

        List<Integer> vatApplicableIndexes = Arrays.asList(0, 2);
        String vatValue = "2";
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        // Start from PID row 4
        int startingRowIndex = 4;

        for (int j = 0; j < productNames.size(); j++) {
            int currentRow = startingRowIndex + j;

            String product = productNames.get(j);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(currentRow, product, scrollContainer);

            if (vatApplicableIndexes.contains(j)) {
                pageObjectManager.getBillingCenterPage().selectVatDropdownByIndexValue(currentRow, vatValue, scrollContainer);
            }
            // Enter random Sale amount using Faker
            String randomSaleAmount = FakeDataUtil.getRandomSaleAmount();
            pageObjectManager.getBillingCenterPage().enterSaleAmountByRowIndex(currentRow, randomSaleAmount, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products for Amazon Duty INV Type");

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button for Amazon Duty INV Type");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message 2nd Time: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon for Amazon Duty INV Type");

    }
}
