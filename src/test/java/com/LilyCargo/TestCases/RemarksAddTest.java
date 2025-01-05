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

public class RemarksAddTest extends TestBaseClass {

    Logger log;
    String importCustomsSalesRemarks = faker.lorem().characters(500);

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(RemarksAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can add SHIPPER successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add SHIPPER successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add SHIPPER successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add SHIPPER")
    public void AddRemarksTest() throws InterruptedException {

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
        Assert.assertTrue(freightDetail.isRemarksTabDisplayed(), "Remarks tab is not Displayed");

        freightDetail.clickRemarksTab();
        log.info("Clicked Remarks Tab");

        remarksPage.clickOnRemarksAddIcon();
        log.info("Clicked On Remarks Add Icon");

        Assert.assertTrue(remarksPage.isImportRemarksPopupHeadingDisplayed(), "Import Remarks Popup Heading Not Displayed");
        log.info("Heading: " + remarksPage.getPopupHeading());

        remarksPage.enterRemarksText(importCustomsSalesRemarks);
        log.info("Entered Remarks Text");

        remarksPage.scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        remarksPage.clickSubmitRemarksButton();
        log.info("Clicked Submit Remarks Button");

        Assert.assertTrue(remarksPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + remarksPage.getSuccessAlertMessage());

        remarksPage.clickOnCustomsRemarksTab();
        log.info("Click On Customs Remarks Tab");

        remarksPage.clickOnRemarksAddIcon();
        log.info("Clicked On Remarks Add Icon");

        remarksPage.enterRemarksText(importCustomsSalesRemarks);
        log.info("Entered Remarks Text");

        remarksPage.scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        remarksPage.selectCustomsRemarksDateDate("02", "24", "2025");
        log.info("Entered Customs Remarks DATE");

        remarksPage.enterShipperAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        remarksPage.clickSubmitRemarksButton();
        log.info("Clicked Submit Remarks Button");






        remarksPage.enterShipperZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        remarksPage.selectCountry();
        log.info("Selected Country");

        remarksPage.enterShipperEmail1(faker.internet().emailAddress());
        log.info("Entered Shipper's Email");

        remarksPage.enterShipperDutchPhoneNumber(); // New method for Dutch phone number
        log.info("Entered Shipper's Tel Number");

        remarksPage.enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        remarksPage.enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        remarksPage.clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        remarksPage.clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        remarksPage.enterShipperSCMEmail(faker.internet().emailAddress());
        log.info("Entered Shipper's SCM Email");

        remarksPage.clickSaveShipperBack();
        log.info("Click Save Shipper Button");

        remarksPage.clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddShipperTest");
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