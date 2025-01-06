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

public class FycoDataAddTest extends TestBaseClass {

    Logger log;
    String fycoDataAddTestDescription = faker.lorem().characters(100);

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(FycoDataAddTest.class);
        log.info("Test setup completed.");

        performLogin();
    }

    private void performLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can add Fyco Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Fyco Data successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Fyco Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Fyco Data Tab > Add Fyco Data")
    public void AddFycoDataTest() throws InterruptedException {

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
        Assert.assertTrue(freightDetail.isFycoDataTabDisplayed(), "Incidents Registration tab is not Displayed");

        freightDetail.clickFycoDataTab();
        log.info("Clicked Incidents Registration Tab");

        //----------------------------------Incidents Registration----------------------------------
        fycoDataPage.clickOnFycoDataAddIcon();
        log.info("Clicked On Incidents Registration Add Icon");

        Assert.assertTrue(fycoDataPage.isFycoDataPopupHeadingDisplayed(), "Incidents Registration Popup Heading Not Displayed");
        log.info("Heading: " + fycoDataPage.getPopupHeading());

        fycoDataPage.enterPlatoNumberField(faker.number().digits(8));
        log.info("Entered Incidents Registration Problem Text");

        fycoDataPage.enterArticleNumberField(faker.number().digits(3));
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.enterHsTaricNumberField(faker.number().digits(10));
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.enterProductDescriptionField(fycoDataAddTestDescription);
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.enterCtnsNumberField(faker.number().digits(4));
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.enterPcsField(faker.number().digits(4));
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.enterGrossKGField(faker.number().digits(4));
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.enterCvEuroField(faker.number().digits(6));
        log.info("Entered Incidents Registration Solution Text");

        fycoDataPage.scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        fycoDataPage.clickSubmitFycoDataButton();
        log.info("Clicked Submit Incidents Registration Button");

        Assert.assertTrue(fycoDataPage.isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + fycoDataPage.getSuccessAlertMessage());

        fycoDataPage.clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() {
        captureScreenshot("AddFycoDataTest");
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

