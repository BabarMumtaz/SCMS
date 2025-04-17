package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncidentsRegistrationAddTest extends TestBaseClass {

    Logger log;
    String IncidentsRegistrationText = faker.lorem().characters(500);

    @Test(priority = 1, description = "Verify that a user can add Incidents Registration successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Incidents Registration successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Incidents Registration successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Incidents Registration Tab > Add Incidents Registration")
    public void AddIncidentsRegistrationTest() throws InterruptedException {

        log = LogManager.getLogger(IncidentsRegistrationAddTest.class);
        log.info("Starting Incidents Registration Add Test from Detail Page.");

        pageObjectManager.getFreightListing().hoverOn1stRowClient();
        log.info("Hover over 1st Row");

        // Click on the freight ID
        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(pageObjectManager.getFreightDetail().isIncidentsRegistrationTabDisplayed(), "Incidents Registration tab is not Displayed");

        pageObjectManager.getFreightDetail().clickIncidentsRegistrationTab();
        log.info("Clicked Incidents Registration Tab");

    //----------------------------------Incidents Registration----------------------------------

        pageObjectManager.getIncidentsRegistrationPage().clickOnIncidentsRegAddIcon();
        log.info("Clicked On Incidents Registration Add Icon");

        Assert.assertTrue(pageObjectManager.getIncidentsRegistrationPage().isIncidentsRegPopupHeadingDisplayed(), "Incidents Registration Popup Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getIncidentsRegistrationPage().getPopupHeading());

        pageObjectManager.getIncidentsRegistrationPage().enterIncidentsRegPopupProblemField(IncidentsRegistrationText);
        log.info("Entered Incidents Registration Problem Text");

        pageObjectManager.getIncidentsRegistrationPage().enterIncidentsRegPopupSolutionField(IncidentsRegistrationText);
        log.info("Entered Incidents Registration Solution Text");

        pageObjectManager.getIncidentsRegistrationPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getIncidentsRegistrationPage().clickSubmitIncidentsRegButton();
        log.info("Clicked Submit Incidents Registration Button");

        Assert.assertTrue(pageObjectManager.getIncidentsRegistrationPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getIncidentsRegistrationPage().getSuccessAlertMessage());

        pageObjectManager.getIncidentsRegistrationPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
