package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.*;
import com.LilyCargo.Util.ScreenShotUtil;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;

public class ShipperAddTest extends TestBaseClass {

    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(ShipperAddTest.class);
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
    public void AddShipperTest() throws InterruptedException {

        // Check if login is successful
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");

        menuBar.clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        menuBar.clickShippersFRSubMenu();
        log.info("Clicked Shipper FR Sub Menu");

        Assert.assertTrue(shippersPage.isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + shippersPage.getPageHeading());

        shippersPage.clickAddShipperBtn();
        log.info("Clicked Shipper Add button");

        Assert.assertTrue(shippersPage.isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Heading: " + shippersPage.getAddPageHeading());

        shippersPage.enterShipperStore(faker.company().name());
        log.info("Entered Shipper Store Name");

        shippersPage.selectExportCompany();
        log.info("Selected Export Company");

        shippersPage.enterShipperName(faker.company().name());
        log.info("Entered Shippers Name");

        shippersPage.enterShipperAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        shippersPage.enterShipperZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        shippersPage.selectCountry();
        log.info("Selected Country");

        shippersPage.enterShipperEmail1(faker.internet().emailAddress());
        log.info("Entered Shipper's Email");

        shippersPage.enterShipperDutchPhoneNumber(); // New method for Dutch phone number
        log.info("Entered Shipper's Tel Number");

        shippersPage.enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        shippersPage.enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        shippersPage.clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        shippersPage.clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        shippersPage.enterShipperSCMEmail(faker.internet().emailAddress());
        log.info("Entered Shipper's SCM Email");

        shippersPage.clickSaveShipperBack();
        log.info("Click Save Shipper Button");

        shippersPage.clickOnAlertPopupDP();
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
