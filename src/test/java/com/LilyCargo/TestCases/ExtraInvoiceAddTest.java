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
        log.info("Tab Heading: " + pageObjectManager.getFreightDetail().getBillingCenterTabDisplayedText());

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        //----------------------------------Extra Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isExtraInvTabDisplayed(), "Extra Tab Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getBillingCenterPage().getExtraInvTabName());

        pageObjectManager.getBillingCenterPage().clickOnExtraInvTab();
        log.info("Clicked Extra INV Tab");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Section Heading: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectExtraInvClient();
        log.info("Selected 'A.I. Trading GmbH' Client");

        // Enter the invoice number
        pageObjectManager.getBillingCenterPage().enterExtraInvoiceNumber(FakeDataUtil.generateInvoiceNumber());
        log.info("Entered Invoice Number");

        String[] invoiceDate = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterExtraInvoiceDate(invoiceDate[0], invoiceDate[1], invoiceDate[2]);
        log.info("Entered Extra Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Invoice Period/Grace Days");

        pageObjectManager.getBillingCenterPage().enterExtraInvRemarks(FakeDataUtil.getRemarksInCharacters());
        log.info("Entered Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().selectLedgerTypeDropdown();
        log.info("Selected Ledger Type");

        pageObjectManager.getBillingCenterPage().selectExtraInvType();
        log.info("Selected Extra Invoice Type");

        List<String> productNames = Arrays.asList(
                "80210 - 2% Disbursement Fee",
                "80210 - Additional Customs Line",
                "80210 - Additional HS Code Charge",
                "80299 - Administration fee",
                "80208 - Air Shipping Fee"
        );

        List<Integer> vatApplicableIndexes = Arrays.asList(1, 2, 3);
        String vatValue = "2";
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
            // Step 2: If VAT applies to this row, select VAT
            if (vatApplicableIndexes.contains(i)) {
                pageObjectManager.getBillingCenterPage().selectVatDropdownByIndexValue(i, vatValue, scrollContainer);
            }

            String randomAmount = FakeDataUtil.getAmountEur();
            pageObjectManager.getBillingCenterPage().enterAmountEInvoiceByRowIndex(i, randomAmount, scrollContainer);

            // Enter random Sale amount using Faker
            String randomSaleAmount = FakeDataUtil.getRandomSaleAmount();
            pageObjectManager.getBillingCenterPage().enterSaleAmountByRowIndex(i, randomSaleAmount, scrollContainer);

        }

        pageObjectManager.getBillingCenterPage().scrollToSubmitButton();
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getBillingCenterPage().clickSubmitINVButton();
        log.info("Clicked Submit INV Button");

        //Thread.sleep(2000);

        //Assert.assertTrue(pageObjectManager.getBillingCenterPage().isPidDropdownDisabled(), "PID Dropdown should be disabled after invoice submission.");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isExtraInvSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getExtraInvSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
