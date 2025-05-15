package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
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
    public void AddDockPlanner() throws InterruptedException {
        log = LogManager.getLogger(DockPlannerAddTest.class);
        log.info("Test setup completed.");

        performFreightListingActions();
        performFreightDetailActions();

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }

    private void performFreightListingActions() {
        pageObjectManager.getFreightListing().hoverOn1stRowClient();
        log.info("Hovered over the 1st row.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab.");
    }

    private void performFreightDetailActions() throws InterruptedException {
        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit wrapper not displayed.");
        log.info("Edit wrapper is displayed.");

        pageObjectManager.getFreightDetail().scrollToElement();
        log.info("Scrolled to Submit MRN section.");

        pageObjectManager.getFreightDetail().clickUploadMrnButton();
        log.info("Clicked on Upload MRN Button.");

        pageObjectManager.getFreightDetail().clickUploadMrnButton();
        log.info("Clicked on Upload MRN Button.");

        pageObjectManager.getFreightDetail().clickSubmitMrnTask();
        log.info("Clicked on Submit MRN Task.");

        pageObjectManager.getFreightDetail().clickCancelMrnButton();
        log.info("Clicked on Cancel MRN button.");
    }
}
