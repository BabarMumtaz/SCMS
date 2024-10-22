package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.CarriersTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
import com.LilyCargo.Pages.LoginTestPage;
import com.LilyCargo.Pages.MenuBarTestPage;
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

    LoginTestPage loginPage;
    MenuBarTestPage menuBar;
    CarriersTestPage carriersPage;
    FreightDetailTestPage freightDetail;
    JavascriptExecutor js;
    Faker faker;
    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance
        loginPage = PageFactory.initElements(driver, LoginTestPage.class);
        menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
        carriersPage = PageFactory.initElements(driver, CarriersTestPage.class);

        // Initialize Faker with Dutch locale
        faker = new Faker(new Locale.Builder().setLanguage("nl").build());
        js = (JavascriptExecutor) driver;
        log = LogManager.getLogger(ShipperAddTest.class);
        log.info("Test setup completed.");

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered Valid Username and Password.");
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

        menuBar.clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        Assert.assertTrue(carriersPage.isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + carriersPage.getPageHeading());

        carriersPage.clickAddCarrierBtn();
        log.info("Clicked Carriers Add button");

    }

    @AfterMethod
    public void tearDown() throws IOException {
        ScreenShotUtil.takeScreenshotAtEndOfTest(driver, "AddShipperTest");
        if (driver != null) {
            driver.quit(); // Closes the browser instance after each test method
            log.info("Browser closed successfully.");
        }
    }
}
