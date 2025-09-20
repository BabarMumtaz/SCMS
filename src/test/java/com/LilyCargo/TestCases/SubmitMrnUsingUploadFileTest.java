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
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to Submit MRN by uploading Doc MRN file successfully")
    @Step("Hit Site URL -> Login with valid credentials -> Booked Freight > Freight Detail Page > Submit MRN")
    public void VerifySubmitMrnTest() throws InterruptedException {
        log = LogManager.getLogger(SubmitMrnUsingUploadFileTest.class);
        log.info("Test setup completed.");

        performFreightListingActions();
        performFreightDetailActions();

    }

    private void performFreightListingActions() {

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");
    }

    private void performFreightDetailActions() throws InterruptedException {
        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit Freight icon is not Displayed");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().scrollToElement();
        log.info("Scrolled to Submit MRN section.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task Shortcut.");

        Assert.assertTrue(pageObjectManager.getSubmitMrnCustomsStatusPage().isSubmitMrnPopupHeadingDisplayed(), "Submit MRN popup not visible");
        log.info("Popup Heading: " + pageObjectManager.getSubmitMrnCustomsStatusPage().getSubmitMrnPopupHeading());

        WebElement mrnInput = pageObjectManager.getSubmitMrnCustomsStatusPage().getMrnInput();

        // Check if the field is disabled OR already filled
        boolean isDisabled = mrnInput.getAttribute("disabled") != null;
        boolean hasValue = !mrnInput.getAttribute("value").trim().isEmpty();

        if (isDisabled || hasValue) {

            pageObjectManager.getSubmitMrnCustomsStatusPage().selectCustomsStatusDropdown();
            log.info("Selected Clear Customs Status");

            pageObjectManager.getSubmitMrnCustomsStatusPage().enterMrnRemarks(FakeDataUtil.getMrnNo());
            log.info("Entering Remarks");

            pageObjectManager.getSubmitMrnCustomsStatusPage().clickUpdateMrnButton();
            log.info("MRN field is either disabled or already filled. Clicking Update MRN Button.");

            Assert.assertTrue(pageObjectManager.getSubmitMrnCustomsStatusPage().isMrnExistUpdatedCSSuccessAlertMessageDisplayed(), "Alert Message is different");
            log.info("Success Alert Message on Update: " + pageObjectManager.getSubmitMrnCustomsStatusPage().getMrnExistUpdatedCSSuccessAlertMessage());

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

            pageObjectManager.getSubmitMrnCustomsStatusPage().clickSubmitMrnButton();
            log.info("Clicking Submit button.");

            Assert.assertTrue(pageObjectManager.getSubmitMrnCustomsStatusPage().isMrnAddedUpdatedCSSuccessAlertMessageDisplayed(), "Alert Message is different");
            log.info("Success Alert Message on Submit: " + pageObjectManager.getSubmitMrnCustomsStatusPage().getMrnAddedUpdatedCSSuccessAlertMessage());

            pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
            log.info("Closed the success alert for Adding MRN");
        }

/*        pageObjectManager.getSubmitMrnCustomsStatusPage().clickUploadMrnButton();
        log.info("Clicked on Upload MRN Button.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickSubmitMrnButton();
        log.info("Clicked on Submit MRN Task.");

        pageObjectManager.getSubmitMrnCustomsStatusPage().clickCancelMrnButton();
        log.info("Clicked on Cancel MRN button.");*/

    }
}
