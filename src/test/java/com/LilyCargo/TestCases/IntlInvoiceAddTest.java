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

public class IntlInvoiceAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add INTL Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add INTL Invoice successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add INTL Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Add INTL Invoice")
    public void VerifyIntlInvoiceCreation() throws InterruptedException {

        log = LogManager.getLogger(IntlInvoiceAddTest.class);
        log.info("Starting INTL INV Add Test from Billing Center Tab.");

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

        //----------------------------------INTL Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client");

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        String[] invoiceDate = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().selectIntlEuInvDate(invoiceDate[0], invoiceDate[1], invoiceDate[2]);
        log.info("Entered Intl Invoice DATE");

        // Enter the invoice number
        pageObjectManager.getBillingCenterPage().enterInvoiceNumber(FakeDataUtil.generateInvoiceNumber());
        log.info("Entered Invoice Number");

        pageObjectManager.getBillingCenterPage().enterGraceDays("14");
        log.info("Entered Grace Days");

        List<String> productNames = Arrays.asList(
                "80210 - 2% Disbursement Fee",
                "80210 - Additional Customs Line",
                "80210 - Additional HS Code Charge",
                "80299 - Administration fee",
                "80208 - Air Shipping Fee",
                "80200 - All in handling",
                "80220 - CBAM Filing Charge",
                "80220 - CBAM Lines",
                "23016 - CBAM Tax",
                "43600 - Claim on Cargo (Value)",
                "23011 - Container Trucking",
                "80200 - Contract DDP service (Air) Cargo",
                "80210 - Customs Declaration",
                "80200 - DDP Service 20 FT Container",
                "80200 - DDP Service 40 FT Container",
                "80200 - DDP Service 45 FT Container",
                "23013 - Delivery / DPD Express Parcels (Value)",
                "23011 - Delivery / Logistics payable (Value)"
        );

        List<Integer> vatApplicableIndexes = Arrays.asList(1, 2, 3);
        String vatValue = "2";
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        for (int i = 1; i <= productNames.size(); i++) {
            if (i > 10) {
                pageObjectManager.getBillingCenterPage().clickAddRowAndWaitForNewRow();
            }
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
            // Step 2: If VAT applies to this row, select VAT
            if (vatApplicableIndexes.contains(i)) {
                pageObjectManager.getBillingCenterPage().selectVatDropdownByIndexValue(i, vatValue, scrollContainer);
            }
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(2000);

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
