package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;


public class SubmitMrnUsingUploadFileTest extends TestBeforeAndAfter {

    private Logger log;

    @Test(priority = 1, description = "Verify that a user can Submit MRN by uploading Doc MRN file successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Submit MRN by uploading Doc MRN file successfully from the Freight Detail page")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.03_Shortcuts & Email_Submit Mrn")
    @Story("As a user, I should be able to Submit MRN by uploading Doc MRN file successfully")
    @Step("Hit Site URL -> Login with valid credentials -> Booked Freight > Freight Detail Page > Submit MRN")
    public void VerifySubmitMrnTest() throws InterruptedException {
        log = LogManager.getLogger(SubmitMrnUsingUploadFileTest.class);
        log.info("Test setup completed.");

        performFreightListingActions();
        performFreightDetailActions();

    }

    private void performFreightListingActions() {

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);
    }

    private void performFreightDetailActions() {
        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().scrollToElement();
        log.info("Scrolled to Submit MRN section.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task Shortcut.");

 /*       Assert.assertTrue(pageObjectManager.getSubmitMrnCustomsStatusPage().isSubmitMrnPopupHeadingDisplayed(), "Submit MRN popup not visible");
        log.info("Popup Heading: " + pageObjectManager.getSubmitMrnCustomsStatusPage().getSubmitMrnPopupHeading());
*/
        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Submit / Delete MRN # / Customs Status", "Popup heading does not match expected value.");

        WebElement mrnInput = pageObjectManager.getSubmitMrnCustomsStatusPage().getMrnInput();

        // Check if the field is disabled OR already filled
        boolean isDisabled = mrnInput.getAttribute("disabled") != null;
        boolean hasValue = !mrnInput.getAttribute("value").trim().isEmpty();

        if (isDisabled || hasValue) {

            pageObjectManager.getSubmitMrnCustomsStatusPage().selectCustomsStatusDropdown();
            log.info("Selected Clear Customs Status");

            pageObjectManager.getSubmitMrnCustomsStatusPage().enterMrnRemarks(FakeDataUtil.getMrnNo());
            log.info("Entering Remarks");

            pageObjectManager.getGlobalMethodsPage().clickUpdateBtn();
            log.info("MRN field is either disabled or already filled. Clicking Update MRN Button.");

 /*           Assert.assertTrue(pageObjectManager.getSubmitMrnCustomsStatusPage().isMrnExistUpdatedCSSuccessAlertMessageDisplayed(), "Alert Message is different");
            log.info("Success Alert Message on Update: " + pageObjectManager.getSubmitMrnCustomsStatusPage().getMrnExistUpdatedCSSuccessAlertMessage());
*/
            String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("Success Alert is: {}", successAlert);
            Assert.assertEquals(successAlert, "MRN already exists against SUB-FID & Customs Status updated", "Success Alert does not match expected value.");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Closed the success alert for Update MRN");
        }
        else {

            pageObjectManager.getSubmitMrnCustomsStatusPage().enterMrnNumber(FakeDataUtil.getMrnNo());
            log.info("MRN field is enabled and empty. Entering MRN value: ");

            pageObjectManager.getSubmitMrnCustomsStatusPage().selectCustomsStatusDropdown();
            log.info("Selected Clear Customs Status After Entering MRN");

            pageObjectManager.getSubmitMrnCustomsStatusPage().enterMrnRemarks(FakeDataUtil.getMrnNo());
            log.info("Entering Remarks After Entering MRN");

            pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
            log.info("Clicking Submit button.");

/*
            Assert.assertTrue(pageObjectManager.getSubmitMrnCustomsStatusPage().isMrnAddedUpdatedCSSuccessAlertMessageDisplayed(), "Alert Message is different");
            log.info("Success Alert Message on Submit: " + pageObjectManager.getSubmitMrnCustomsStatusPage().getMrnAddedUpdatedCSSuccessAlertMessage());
*/

            String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
            log.info("Mrn Submission Success Alert is: {}", successAlert);
            Assert.assertEquals(successAlert, "MRN submitted against SUB-FID & Customs Status updated", "Success Alert does not match expected value.");

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Closed the success alert for Adding MRN");
        }

/*        pageObjectManager.getSubmitMrnCustomsStatusPage().clickUploadMrnButton();
        log.info("Clicked on Upload MRN Button.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickCancelMrnButton();
        log.info("Clicked on Cancel MRN button.");*/

    }
}
