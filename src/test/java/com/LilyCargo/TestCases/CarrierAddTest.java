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
import com.LilyCargo.Pages.CarriersTestPage;
import com.LilyCargo.Pages.FreightDetailTestPage;
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
import java.util.Locale;

public class CarrierAddTest extends TestBaseClass {

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
        log = LogManager.getLogger(CarrierAddTest.class);
        log.info("Test setup completed.");

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered Valid Username and Password.");
    }

    @Test(priority = 1, description = "Verify that a user can add carrier successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add carrier successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to add carrier successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add carrier")
    public void AddCarrierTest() throws InterruptedException {

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
    public void tearDown() throws IOException {
        ScreenShotUtil.takeScreenshotAtEndOfTest(driver, "AddCarrierTest");
        if (driver != null) {
            driver.quit(); // Closes the browser instance after each test method
            log.info("Browser closed successfully.");
        }
    }
}
