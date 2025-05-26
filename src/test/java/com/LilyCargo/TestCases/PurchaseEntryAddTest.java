package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
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


public class PurchaseEntryAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add Purchase Entry successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Purchase Entry successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Purchase Entry successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Purchase Entry")
    public void VerifyPurchaseEntryCreation() throws InterruptedException {

        // Check if login is successful
        log = LogManager.getLogger(PurchaseEntryAddTest.class);
        log.info("Starting Purchase Entry Add Test from Billing Center Tab.");

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

        //---------------------------------- Purchase Entry ----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isPurchaseEntryTabDisplayed(), "Purchase Entry Tab is Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getPurchaseEntryTabName());

        pageObjectManager.getBillingCenterPage().clickOnPurchaseEntryTab();
        log.info("Clicked Purchase Entry Tab");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isGlAccountsSectionColHeadingDisplayed(), "Gl Accounts Section Column Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getGlAccountsSectionColHeading());

        pageObjectManager.getBillingCenterPage().selectPurchaseEntryShipper();
        log.info("Selected 'BTT Multimodal Container Solutions B.V.' Shipper");

        // Enter the invoice number
        pageObjectManager.getBillingCenterPage().enterPurchaseEntryNumber(FakeDataUtil.generateInvoiceNumber());
        log.info("Entered Purchase Entry Invoice Number");

        String[] invoiceDate = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterPurchaseEntryDate(invoiceDate[0], invoiceDate[1], invoiceDate[2]);
        log.info("Entered Purchase Entry DATE");

        pageObjectManager.getBillingCenterPage().enterPurchaseEntryTotalAmount(FakeDataUtil.getRandomSaleAmount());
        log.info("Entered Total Amount");

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\25Z-800016_LM24090910_PONU7928774_Amazon EU SARL, Dutch Branch.pdf";
        pageObjectManager.getBillingCenterPage().uploadInvoicePDF(filePath);
        log.info("Attached PDF file");

/*        pageObjectManager.getBillingCenterPage().selectLedgerTypeDropdown();
        log.info("Selected Ledger Type");*/

        List<String> productNames = Arrays.asList(
                "23021 - Logistics Payable",
                "23025 - Duty  payable (Credit)",
                "23026 - Paid to third party on client behalf",
                "43500 - Customs Fine",
                "70008 - Shipping Purchase",
                "71000 - Terminal and Cross Docking"
        );

        List<Integer> vatApplicableIndexes = Arrays.asList(1, 2, 3);
        String vatValue = "2";
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        for (int i = 1; i <= productNames.size(); i++) {
            if (i > 5) {
                pageObjectManager.getBillingCenterPage().clickAddRowAndWaitForNewRowGeneric(
                        pageObjectManager.getBillingCenterPage()::getGlAccountDropdownsCount,
                        () -> pageObjectManager.getBillingCenterPage().getGlAccountDropdownListPE(),
                        pageObjectManager.getBillingCenterPage().getAddRowButton(),
                        "Purchase Entry"
                );
            }

            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValueForPE(i, product, scrollContainer);

            if (vatApplicableIndexes.contains(i)) {
                pageObjectManager.getBillingCenterPage().selectVatDropdownByIndexValue(i, vatValue, scrollContainer);
            }

            String randomAmount = FakeDataUtil.getAmountEur();
            pageObjectManager.getBillingCenterPage().enterAmountEURByRowIndex(i, randomAmount, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToPushPurchaseEntryButton();
        log.info("Scrolled to Finish Button after selecting all products for Purchase Entry Type");

        pageObjectManager.getBillingCenterPage().clickPushPurchaseEntryButton();
        log.info("Clicked Finish INV Button for Purchase Entry Type");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isErrorAlertMessageDisplayed(), "Error Alert Message is Different");
        log.info("Heading: " + pageObjectManager.getBillingCenterPage().getErrorAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
