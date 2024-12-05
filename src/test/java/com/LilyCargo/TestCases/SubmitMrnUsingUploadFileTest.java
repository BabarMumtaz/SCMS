package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Util.ScreenShotUtil;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitMrnUsingUploadFileTest extends TestBaseClass {

    Faker faker;
    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance

        log = LogManager.getLogger(SubmitMrnUsingUploadFileTest.class);
        log.info("Test setup completed.");

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");
    }

    @Test(priority = 1, description = "Verify that a user can Submit MRN by uploading Doc MRN file successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Submit MRN by uploading Doc MRN file successfully from the Freight Detail page")
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to Submit MRN by uploading Doc MRN file successfully")
    @Step("Hit Site URL -> Login with valid credentials -> Booked Freight > Freight Detail Page > Submit MRN")
    public void SubmitMrnUsingUploadFile() throws InterruptedException {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");

        freightListing.hoverOn1stRowClient();
        log.info("Hovered over the 1st row.");

        freightListing.clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        freightListing.switchToNewTab();
        log.info("Switched to the new tab.");

        Assert.assertTrue(freightDetail.isEditFreightIconDisplayed(), "Edit wrapper not displayed.");

        freightDetail.scrollToBottom();
        Thread.sleep(2000); // For visual confirmation, can be replaced with a wait
        log.info("Scroll to Submit MRN");

        freightDetail.clickUploadMrnButton();
        log.info("Clicked on Upload MRN Button.");

        freightDetail.clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task.");

        freightDetail.clickCancelMrnButton();
        log.info("Clicked on Cancel MRN button.");

        loginPage.logout();
        log.info("Logged out successfully.");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        try {
            ScreenShotUtil.takeScreenshotAtEndOfTest(driver, "SubmitMrnUsingUploadFile");
        } catch (IOException e) {
            log.error("Error capturing screenshot.", e);
        }
        if (driver != null) {
            driver.quit();
            log.info("Browser closed successfully.");
        }
    }
}
