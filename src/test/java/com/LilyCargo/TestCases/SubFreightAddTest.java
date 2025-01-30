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

public class SubFreightAddTest extends TestBaseClass {

    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(SubFreightAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can Upload Cargo Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Upload Cargo Data successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to Upload Cargo Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add carrier")
    public void CreateSubFreightTest() throws InterruptedException {

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

        freightDetail.scrollToRight();
        log.info("Clicked Incidents Registration Tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(freightDetail.isCargoDataTabDisplayed(), "Cargo Data Tab tab is not Displayed");

        freightDetail.clickCargoDataTab();
        log.info("Clicked Cargo Data Tab");

        //----------------------------------Cargo Data Tab----------------------------------

        Assert.assertTrue(cargoDataPage.isCargoDataListingHs1stCellDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
        log.info("Heading: " + cargoDataPage.getCargoDataListingHs1stCellText());

        cargoDataPage.selectNoTc();
        log.info("Selected NoTC");

        Assert.assertTrue(cargoDataPage.isCargoDataListingAreaDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
        log.info("Heading: " + cargoDataPage.getCargoDataListingAreaMessage());

        cargoDataPage.clickOnUploadCargoDataIcon();
        log.info("Clicked Upload Cargo Data Icon");

        Assert.assertTrue(cargoDataPage.isUploadCargoDataPopupDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
        log.info("Heading: " + cargoDataPage.getUploadCargoDataPopupHeading());

        cargoDataPage.uploadCargoDataInChooseFile();
        log.info("Selected NoTC");

        cargoDataPage.clickCargoDataPopupSubmitButton();
        log.info("Clicked Submit Button");

        Assert.assertTrue(cargoDataPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + cargoDataPage.getSuccessAlertMessage());

        cargoDataPage.clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        cargoDataPage.clickOnExportCargoDataIcon();
        log.info("Clicked Export Cargo Data Icon");

        Assert.assertTrue(cargoDataPage.isExportSuccessAlertMessageDisplayed(), "Export Success Alert Message Not Displayed");
        log.info("Heading: " + cargoDataPage.getExportSuccessAlertMessage());

        cargoDataPage.clickOnExportAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("CreateSubFreightTest");
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