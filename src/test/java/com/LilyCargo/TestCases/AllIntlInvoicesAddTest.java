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

    @Test(priority = 1, description = "Verify that a user can add INTL Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add INTL Invoice successfully")
    @Epic("Booked Freights 03")
    @Feature("Feature:03.08.02_Billing Center")
    @Story("As a user, I should be able to add INTL Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Add INTL Invoice")
    public void VerifyAllIntlInvoicesAddTestCase() throws InterruptedException {

        log = LogManager.getLogger(AllIntlInvoicesAddTest.class);
        log.info("Starting INTL INV Add Test from Billing Center Tab.");

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

        //----------------------------------INTL Invoice----------------------------------

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Section Heading: " + pageObjectManager.getBillingCenterPage().getProductSectionColHeading());

        Thread.sleep(500);

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        String[] invoiceDate = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterIntlEuInvDate(invoiceDate[0], invoiceDate[1], invoiceDate[2]);
        log.info("Entered Intl Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("14");
        log.info("Entered Grace Days");

        List<String> productNames = Arrays.asList(
                "80200 - DDP Service 20 FT Container",
                "80200 - DDP Service 40 FT Container"
        );

        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        /** ---------- TAX INV ---------- */

        //STANDARD, TAX INV, Z-TYPE INV, CREDIT INV, Y-TYPE INV
        pageObjectManager.getBillingCenterPage().selectInvoiceType("TAX INV");
        log.info("Selected 'TAX INV' Invoice Type");

        String[] invoiceDate1 = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterIntlEuInvDate(invoiceDate1[0], invoiceDate1[1], invoiceDate1[2]);
        log.info("Entered Intl Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Grace Days");

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        /** ----------  Z-TYPE INV  --------- */

        //STANDARD, TAX INV, Z-TYPE INV, CREDIT INV, Y-TYPE INV
        pageObjectManager.getBillingCenterPage().selectInvoiceType("Z-TYPE INV");
        log.info("Selected 'Z-TYPE INV' Invoice Type");

        String[] invoiceDate2 = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterIntlEuInvDate(invoiceDate2[0], invoiceDate2[1], invoiceDate2[2]);
        log.info("Entered Intl Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Grace Days");

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        /** ----------  CREDIT INV  --------- */

        //STANDARD, TAX INV, Z-TYPE INV, CREDIT INV, Y-TYPE INV
        pageObjectManager.getBillingCenterPage().selectInvoiceType("CREDIT INV");
        log.info("Selected 'CREDIT INV' Invoice Type");

        String[] invoiceDate3 = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterIntlEuInvDate(invoiceDate3[0], invoiceDate3[1], invoiceDate3[2]);
        log.info("Entered Intl Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Grace Days");

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        /** ----------  Y-TYPE INV  --------- */

        //STANDARD, TAX INV, Z-TYPE INV, CREDIT INV, Y-TYPE INV
        pageObjectManager.getBillingCenterPage().selectInvoiceType("Y-TYPE INV");
        log.info("Selected 'Y-TYPE INV' Invoice Type");

        String[] invoiceDate4 = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterIntlEuInvDate(invoiceDate4[0], invoiceDate4[1], invoiceDate4[2]);
        log.info("Entered Intl Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Grace Days");

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        /** ----------  TAX INV with AMAZON CLIENT  --------- */

        pageObjectManager.getBillingCenterPage().selectClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client");

        //STANDARD, TAX INV, Z-TYPE INV, CREDIT INV, Y-TYPE INV
        pageObjectManager.getBillingCenterPage().selectInvoiceType("TAX INV");
        log.info("Selected 'TAX INV' Invoice Type");

        String[] invoiceDate5 = FakeDataUtil.getInvoiceDayMonthYear();
        pageObjectManager.getBillingCenterPage().enterIntlEuInvDate(invoiceDate5[0], invoiceDate5[1], invoiceDate5[2]);
        log.info("Entered Intl Invoice DATE");

        pageObjectManager.getBillingCenterPage().enterGraceDays("7");
        log.info("Entered Grace Days");

        for (int i = 1; i <= productNames.size(); i++) {
            String product = productNames.get(i - 1);
            pageObjectManager.getBillingCenterPage().selectDropdownByIndexValue(i, product, scrollContainer);
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");
        Thread.sleep(1000);

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(pageObjectManager.getBillingCenterPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getBillingCenterPage().getSuccessAlertMessage());

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");
    }
}
