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


public class EuInvoiceAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add EU Invoice successfully using Standard INV Type", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add EU Invoice successfully using Standard INV Type")
    @Epic("Booked Freights 03")
    @Feature("Feature:03.08.04_Billing Center")
    @Story("As a user, I should be able to add EU Invoice successfully using Standard INV Type")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > EU Invoice")
    public void VerifyEUInvoiceCreation() throws InterruptedException {

        log = LogManager.getLogger(EuInvoiceAddTest.class);
        log.info("Starting EU INV Add Test from Billing Center Tab");

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

        pageObjectManager.getBillingCenterPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Invoice Remarks Text");

        pageObjectManager.getBillingCenterPage().enterGraceDays("60");
        log.info("Entered Grace Days");

        List<Integer> vatApplicableIndexes = Arrays.asList(1, 2, 3, 4);
        int totalProducts = 22;
        String vatValue = "2";
        WebElement scrollContainer = pageObjectManager.getBillingCenterPage().getProductListContainer();

        for (int i = 1; i <= totalProducts; i++) {
            if (i > 10) {
                pageObjectManager.getBillingCenterPage().clickAddRowAndWaitForNewRow();
            }
            pageObjectManager.getBillingCenterPage().selectEUPidByIndex(i);

            if (vatApplicableIndexes.contains(i)) {
                pageObjectManager.getBillingCenterPage().selectVatDropdownByIndexValue(i, vatValue, scrollContainer);
            }
        }

        pageObjectManager.getBillingCenterPage().scrollToFinishButton();
        log.info("Scrolled to Finish Button after selecting all products.");

        pageObjectManager.getBillingCenterPage().clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Add Invoice Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Invoice Created Successfully", "Success Alert does not match expected value.");

        pageObjectManager.getBillingCenterPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

    }
}
