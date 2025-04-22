package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadCargoDataTest extends TestBaseClass {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Upload Cargo Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Upload Cargo Data successfully")
    @Epic("EP001")
    @Feature("Feature:003")
    @Story("As a user, I should be able to Upload Cargo Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add carrier")
    public void CargoDataUploadTest() throws InterruptedException {

        log = LogManager.getLogger(UploadCargoDataTest.class);
        log.info("Test setup completed.");

        pageObjectManager.getFreightListing().hoverOn1stRowClient();
        log.info("Hover over 1st Row");

        // Click on the freight ID
        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        pageObjectManager.getFreightDetail().scrollToRight();
        log.info("Clicked Incidents Registration Tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(pageObjectManager.getFreightDetail().isCargoDataTabDisplayed(), "Cargo Data Tab tab is not Displayed");

        pageObjectManager.getFreightDetail().clickCargoDataTab();
        log.info("Clicked Cargo Data Tab");

    //----------------------------------Cargo Data Tab----------------------------------

        Assert.assertTrue(pageObjectManager.getCargoDataPage().isCargoDataListingHs1stCellDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
        log.info("Heading: " + pageObjectManager.getCargoDataPage().getCargoDataListingHs1stCellText());

        pageObjectManager.getCargoDataPage().selectNoTc();
        log.info("Selected NoTC");

        Assert.assertTrue(pageObjectManager.getCargoDataPage().isCargoDataListingAreaDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
        log.info("Heading: " + pageObjectManager.getCargoDataPage().getCargoDataListingAreaMessage());

        pageObjectManager.getCargoDataPage().clickOnUploadCargoDataIcon();
        log.info("Clicked Upload Cargo Data Icon");

        Assert.assertTrue(pageObjectManager.getCargoDataPage().isUploadCargoDataPopupDisplayed(), "Cargo Data Listing Hs 1st Cell Not Displayed");
        log.info("Heading: " + pageObjectManager.getCargoDataPage().getUploadCargoDataPopupHeading());

        pageObjectManager.getCargoDataPage().uploadCargoDataInChooseFile();
        log.info("Selected NoTC");

        pageObjectManager.getCargoDataPage().clickCargoDataPopupSubmitButton();
        log.info("Clicked Submit Button");

        Assert.assertTrue(pageObjectManager.getCargoDataPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getCargoDataPage().getSuccessAlertMessage());

        pageObjectManager.getCargoDataPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        pageObjectManager.getCargoDataPage().clickOnExportCargoDataIcon();
        log.info("Clicked Export Cargo Data Icon");

        Assert.assertTrue(pageObjectManager.getCargoDataPage().isExportSuccessAlertMessageDisplayed(), "Export Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getCargoDataPage().getExportSuccessAlertMessage());

        pageObjectManager.getCargoDataPage().clickOnExportAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}