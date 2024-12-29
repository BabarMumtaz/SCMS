package com.LilyCargo.TestCases;

import java.io.IOException;
import java.time.Duration;

import com.LilyCargo.Pages.*;
import com.LilyCargo.Util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Util.ExcelUtil;
import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class ClientAddTest extends TestBaseClass {

    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(ClientAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    // DataProvider to fetch data from Excel file
    @DataProvider
    public Object[][] getClientTestData() {
        return ExcelUtil.getTestData("ClientData",
                (System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\ClientTestData.xlsx"));
    }

    @Test(priority = 1,
            description = "Add Client",
            dataProvider = "getClientTestData",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Add/Create Client successfully by entering data in required fields")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Create Client")
    public void AddClientTest(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail,
                              String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1, String RegionDropDown,
                              String CountryDropDown, String ZipCity, String Vat, String LfrDropDown) {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");

        menuBar.clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        menuBar.clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        Assert.assertTrue(clientPage.isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Heading: " + clientPage.getPageHeading());

        clientPage.clickAddClientBtn();
        log.info("Clicked Client Add button");

        // Log the dropdown selections for clarity
        log.info("Adding client data: Region - " + RegionDropDown + ", Country - " + CountryDropDown + ", LFR - "
                + LfrDropDown);

        clientPage.addClientData(Name, ContactPerson, Address1, Email1, FinancialEmail, FiscalMattersEmail1, CeoEmail1,
                TelephoneNumber1, RegionDropDown, CountryDropDown, ZipCity, Vat, LfrDropDown);

        clientPage.clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        Assert.assertTrue(clientPage.isHeadingDisplayed(), "Heading Not Displayed");
        loginPage.logout();
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddClientTest");
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
