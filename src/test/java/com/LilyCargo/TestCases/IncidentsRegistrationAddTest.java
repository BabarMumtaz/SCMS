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

public class IncidentsRegistrationAddTest extends TestBaseClass {

    Logger log;
    String IncidentsRegistrationText = faker.lorem().characters(500);

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(IncidentsRegistrationAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can add Incidents Registration successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Incidents Registration successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Incidents Registration successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Incidents Registration Tab > Add Incidents Registration")
    public void AddIncidentsRegistrationTest() throws InterruptedException {

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
        Assert.assertTrue(freightDetail.isIncidentsRegistrationTabDisplayed(), "Incidents Registration tab is not Displayed");

        freightDetail.clickIncidentsRegistrationTab();
        log.info("Clicked Incidents Registration Tab");

        //----------------------------------Incidents Registration----------------------------------
        incidentsRegistrationPage.clickOnIncidentsRegAddIcon();
        log.info("Clicked On Incidents Registration Add Icon");

        Assert.assertTrue(incidentsRegistrationPage.isIncidentsRegPopupHeadingDisplayed(), "Incidents Registration Popup Heading Not Displayed");
        log.info("Heading: " + incidentsRegistrationPage.getPopupHeading());

        incidentsRegistrationPage.enterIncidentsRegPopupProblemField(IncidentsRegistrationText);
        log.info("Entered Incidents Registration Problem Text");

        incidentsRegistrationPage.enterIncidentsRegPopupSolutionField(IncidentsRegistrationText);
        log.info("Entered Incidents Registration Solution Text");

        incidentsRegistrationPage.scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        incidentsRegistrationPage.clickSubmitIncidentsRegButton();
        log.info("Clicked Submit Incidents Registration Button");

        Assert.assertTrue(incidentsRegistrationPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + incidentsRegistrationPage.getSuccessAlertMessage());

        Assert.assertTrue(incidentsRegistrationPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + incidentsRegistrationPage.getSuccessAlertMessage());

        incidentsRegistrationPage.clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddIncidentsRegistrationTest");
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
