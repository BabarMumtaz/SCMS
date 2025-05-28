package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.ScreenShotUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitMrnUsingUploadFileTest extends TestBeforeAndAfter {

    private Logger log;

    @Test(priority = 1, description = "Verify that a user can Submit MRN by uploading Doc MRN file successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Submit MRN by uploading Doc MRN file successfully from the Freight Detail page")
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to Submit MRN by uploading Doc MRN file successfully")
    @Step("Hit Site URL -> Login with valid credentials -> Booked Freight > Freight Detail Page > Submit MRN")
    public void SubmitMrnUsingUploadFile() throws InterruptedException {
        log = LogManager.getLogger(SubmitMrnUsingUploadFileTest.class);
        log.info("Test setup completed.");

        performFreightListingActions();
        performFreightDetailActions();

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }

    private void performFreightListingActions() {

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");
    }

    private void performFreightDetailActions() throws InterruptedException {
        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getFreightDetail().scrollToElement();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit MRN section.");

        pageObjectManager.getFreightDetail().clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task Shortcut.");

        Assert.assertTrue(pageObjectManager.getRemarksPage().isImportRemarksPopupHeadingDisplayed(), "Submit MRN popup not visible");
        log.info("Popup Heading: " + pageObjectManager.getRemarksPage().getImportRemarksPopupHeading());

        pageObjectManager.getFreightDetail().clickUploadMrnButton();
        log.info("Clicked on Upload MRN Button.");

        pageObjectManager.getFreightDetail().clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task.");

        pageObjectManager.getFreightDetail().clickCancelMrnButton();
        log.info("Clicked on Cancel MRN button.");
    }
}
