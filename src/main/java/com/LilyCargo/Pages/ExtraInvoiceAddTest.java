package com.LilyCargo.Pages;

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

public class ExtraInvoiceAddTest extends TestBaseClass {

    Logger log;
    String InvoiceRemarksText = faker.lorem().characters(100);

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(ExtraInvoiceAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can add Extra Invoice successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Extra Invoice successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Extra Invoice successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Billing Center Tab > Extra Invoice")
    public void AddExtraInvoiceTest() throws InterruptedException {

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

        //----------------------------------Extra Invoice----------------------------------

        Assert.assertTrue(billingCenterTestPage.isProductSectionColHeading(), "Product Section Column Heading Not Displayed");
        log.info("Heading: " + billingCenterTestPage.getProductSectionColHeading());

        billingCenterTestPage.selectExtraInvClient();
        log.info("Selected Amazon EU SARL, Dutch Branch Client");

/*        billingCenterTestPage.selectInvoiceType();
        log.info("Selected Invoice Type");*/

        billingCenterTestPage.enterRemarks(InvoiceRemarksText);
        log.info("Entered Invoice Remarks Text");

        billingCenterTestPage.selectIntlEuInvDate("02", "24", "2025");
        log.info("Selected Intl Invoice DATE");

        // Generate the invoice number
        String generatedInvoice = billingCenterTestPage.generateInvoiceNumber();
        System.out.println("Generated Invoice Number: " + generatedInvoice);

        // Enter the invoice number
        billingCenterTestPage.enterInvoiceNumber(generatedInvoice);
        log.info("Entered Invoice Number");

        billingCenterTestPage.enterGraceDays("14");
        log.info("Entered Grace Days");

        billingCenterTestPage.scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Bottom");

        billingCenterTestPage.selectPidDropdown();
        log.info("Selected 80210 - 2% Disbursement Fee Product");

        billingCenterTestPage.scrollToFinishButton();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Finish Button.");

        billingCenterTestPage.clickFinishINVButton();
        log.info("Clicked Finish INV Button");

        Assert.assertTrue(billingCenterTestPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + billingCenterTestPage.getSuccessAlertMessage());

        billingCenterTestPage.clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddExtraInvoiceTest");
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
