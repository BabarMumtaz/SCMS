package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DockPlannerAddTest extends TestBeforeAndAfter {

    private Logger log;

    @Test(priority = 1, description = "Verify that a user can Add Dock Planner successfully", groups = {"regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Add Dock Planner successfully from the Freight Detail page")
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to Add Dock Planner successfully")
    @Step("Hit Site URL -> Login with valid credentials -> Booked Freight > Freight Detail Page > Dock Planner")
    public void VerifyDockPlannerCreation() throws InterruptedException {
        log = LogManager.getLogger(DockPlannerAddTest.class);
        log.info("Test setup completed.");

        performFreightListingActions();
        performFreightDetailActions();

    }

    private void performFreightListingActions() {
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

        pageObjectManager.getDockPlannerPage().scrollToElement();
        log.info("Scrolled to Submit MRN section.");

        pageObjectManager.getDockPlannerPage().clickDockPlannerShortcut();
        log.info("Clicked on Submit MRN Task Shortcut.");

        Assert.assertTrue(pageObjectManager.getDockPlannerPage().isDockPlannerPopupHeadingDisplayed(), "Submit MRN popup not visible");
        log.info("Popup Heading: {}", pageObjectManager.getDockPlannerPage().getDockPlannerPopupHeading());

        pageObjectManager.getDockPlannerPage().selectDockPlannerJob();
        log.info("Selected Job");

        pageObjectManager.getDockPlannerPage().enterStorage(FakeDataUtil.getString());
        log.info("Entered Storage");

        pageObjectManager.getDockPlannerPage().selectDockPlannerDockNo();
        log.info("Selected Dock No");

        pageObjectManager.getDockPlannerPage().enterTruckNo(FakeDataUtil.getString());
        log.info("Entered Truck No");

        pageObjectManager.getDockPlannerPage().enterTrailerNo(FakeDataUtil.getString());
        log.info("Entered Trailer No");

        pageObjectManager.getDockPlannerPage().enterRemarks(FakeDataUtil.getString());
        log.info("Entered Remarks");

        pageObjectManager.getDockPlannerPage().clickDockPlannerCreateButton();
        log.info("Clicked on Create Dock Planner button.");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Dock Planner created.", "Success Alert does not match expected value.");

        pageObjectManager.getDockPlannerPage().clickDockPlannerExportButton();
        log.info("Clicked on Export Dock Planner button.");

        pageObjectManager.getDockPlannerPage().clickDockPlannerCancelButton();
        log.info("Clicked on Cancel Dock Planner button.");

    }
}
