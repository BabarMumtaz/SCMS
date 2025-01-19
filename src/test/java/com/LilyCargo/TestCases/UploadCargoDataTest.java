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

public class UploadCargoDataTest extends TestBaseClass {

    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(UploadCargoDataTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can add carrier successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add carrier successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to add carrier successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add carrier")
    public void CargoDataTest() throws InterruptedException {

        // Check if login is successful
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");

        menuBar.clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        menuBar.clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        Assert.assertTrue(carriersPage.isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + carriersPage.getPageHeading());

        carriersPage.clickAddCarrierBtn();
        log.info("Clicked Carriers Add button");

        carriersPage.enterTicker(faker.number().digits(7));
        log.info("Entered Ticker Number");

        carriersPage.enterCarrierName(faker.company().name());
        log.info("Entered Carrier's Name");

        carriersPage.enterCarrierEmail(faker.internet().emailAddress());
        log.info("Entered Carrier's Email");

        carriersPage.enterDutchPhoneNumber(); // New method for Dutch phone number
        log.info("Entered Carrier's Tel Number");

        carriersPage.enterAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        carriersPage.enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        carriersPage.selectCountry();
        log.info("Selected Country");

        carriersPage.enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        carriersPage.enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        carriersPage.clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        carriersPage.clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        carriersPage.clickSaveCarrierBack();
        log.info("Click Save Carrier Button");

        carriersPage.clickOnAlertPopupDP();
        log.info("Clicked Cross icon of Alert");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddCarrierTest");
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