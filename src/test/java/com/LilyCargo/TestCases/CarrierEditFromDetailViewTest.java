package com.LilyCargo.TestCases;

import java.io.IOException;

import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.FreightTestPage;
import com.LilyCargo.Pages.CarrierListingTestPage;
import com.LilyCargo.Pages.CarriersTestPage;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CarrierEditFromDetailViewTest extends TestBaseClass {

    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(CarrierEditFromDetailViewTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can edit carrier successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can edit Carrier successfully from the Carrier view page")
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to edit carrier successfully")
    @Step("Hit Site Url > Login with valid credentials > Detail Page of Carrier > Edit carrier")
    public void EditCarrierTest() throws InterruptedException {

        // Check if login is successful
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");

        menuBar.clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        menuBar.clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        Assert.assertTrue(carriersPage.isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + carriersPage.getPageHeading());

        carrierListing.hoverOnCarrier1stRow();
        log.info("Hover over 1st Row");

        carrierListing.clickOnViewCarrierIcon();
        log.info("Hover over View Icon and click");

        Assert.assertTrue(carrierListing.isViewPageDisplayed(), "View Page is not Displayed");

        carrierListing.clickOnEditCarrierIconFromDetail();
        log.info("Clicked on Edit button on view page");

        carriersPage.enterCarrierEmail2(faker.internet().emailAddress());
        log.info("Entered Carrier's Email 2");

        carriersPage.enterDutchPhoneNumber2(); // New method for Dutch phone number
        log.info("Entered Carrier's Tel 2 Number");

        carriersPage.enterAddress2(faker.address().streetAddress());
        log.info("Entered Address 2");

        carriersPage.clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross icon");

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
        captureScreenshot(" EditCarrierTest");
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