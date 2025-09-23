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
    @Epic("Booked Freights 03")
    @Feature("Feature:03.08.07_Billing Center")
    @Story("As a user, I should be able to add Extra Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Extra Invoice")
    public void VerifyExtraInvoiceCreation() throws InterruptedException {

        log = LogManager.getLogger(ExtraInvoiceAddTest.class);
        log.info("Starting EXTRA INV Add Test from Billing Center Tab");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);

        Assert.assertTrue(pageObjectManager.getFreightDetail().isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");
        log.info("Tab Heading: {}", pageObjectManager.getFreightDetail().getBillingCenterTabDisplayedText());

        pageObjectManager.getFreightDetail().clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isExtraInvTabDisplayed(), "Extra Tab Not Displayed");
        log.info("Page Heading: {}", pageObjectManager.getBillingCenterPage().getExtraInvTabName());

        pageObjectManager.getBillingCenterPage().clickOnExtraInvTab();
        log.info("Clicked Extra INV Tab");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Section Heading: {}", pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectExtraInvClient();
        log.info("Selected 'A.I. Trading GmbH' Client");

/*        pageObjectManager.getBillingCenterPage().enterExtraInvoiceNumber(FakeDataUtil.generateInvoiceNumber());
        log.info("Entered Invoice Number");*/

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

            String randomSaleAmount = FakeDataUtil.getRandomSaleAmount();
            pageObjectManager.getBillingCenterPage().enterSaleAmountByRowIndex(i, randomSaleAmount, scrollContainer);

        }

        pageObjectManager.getBillingCenterPage().scrollToSubmitButton();
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getBillingCenterPage().clickSubmitINVButton();
        log.info("Clicked Submit INV Button");

        //Assert.assertTrue(pageObjectManager.getBillingCenterPage().isPidDropdownDisabled(), "PID Dropdown should be disabled after invoice submission.");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Add Invoice Success Alert is: {}",successAlert);
        Assert.assertEquals(successAlert, "Extra Invoice Created Successfully", "Success Alert does not match expected value.");

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

    }
}
