package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Util.ScreenShotUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class EuInvoiceAddTest extends TestBaseClass {

    Logger log;
    String InvoiceRemarksText = faker.lorem().characters(100);

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(EuInvoiceAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can add EU Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add EU Invoice successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add EU Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > EU Invoice")
    public void AddEulInvoiceTest() throws InterruptedException {

        // Check if login is successful
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");

        freightListing.hoverOn1stRowClient();
        log.info("Hover over 1st Row");

        // Click on the freight ID
        freightListing.clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        freightListing.switchToNewTab();
        log.info("Switched to the new tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(freightDetail.isBillingCenterTabDisplayed(), "Billing Center tab is not Displayed");

        freightDetail.clickBillingCenterTab();
        log.info("Clicked Billing Center Tab");

        //----------------------------------EU Invoice----------------------------------

        Assert.assertTrue(billingCenterPage.isEuInvTabDisplayed(), "EU Tab Not Displayed");
        log.info("Heading: " + billingCenterPage.getEuInvTabName());

        billingCenterPage.clickOnEulInvTab();
        log.info("Clicked EU INV Tab");

        Assert.assertTrue(billingCenterPage.isProductSectionColHeadingDisplayed(), "Product Section Column Heading Not Displayed");
        log.info("Heading: " + billingCenterPage.getProductSectionColHeading());

        billingCenterPage.clickOnClientDropdownCrossIcon();
        log.info("Clicked On Client Dropdown Cross Icon");

        billingCenterPage.selectClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client");

        billingCenterPage.selectInvoiceType();
        log.info("Selected Invoice Type");

        billingCenterPage.enterRemarks(InvoiceRemarksText);
        log.info("Entered Invoice Remarks Text");

        billingCenterPage.selectIntlEuInvDate("02", "24", "2025");
        log.info("Selected Intl Invoice DATE");

        // Generate the invoice number
        String generatedInvoice = billingCenterPage.generateInvoiceNumber();
        System.out.println("Generated Invoice Number: " + generatedInvoice);

        // Enter the invoice number
        billingCenterPage.enterInvoiceNumber(generatedInvoice);
        log.info("Entered Invoice Number");

        billingCenterPage.enterGraceDays("14");
        log.info("Entered Grace Days");

/*        billingCenterPage.scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Bottom");

        billingCenterPage.selectPidDropdown();
        log.info("Selected 80210 - 2% Disbursement Fee Product");

        billingCenterPage.scrollToFinishButton();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Finish Button.");*/

        billingCenterPage.clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(billingCenterPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + billingCenterPage.getSuccessAlertMessage());

        billingCenterPage.clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddEulInvoiceTest");
        closeBrowser();
    }

    private void captureScreenshot(String testName) {
        try {
            ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
            log.info("Screenshot captured for test: " + testName);
        } catch (IOException e) {
            log.error("Error capturing screenshot.", e);
        }
    }

    private void closeBrowser() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed successfully.");
        }
    }
}
