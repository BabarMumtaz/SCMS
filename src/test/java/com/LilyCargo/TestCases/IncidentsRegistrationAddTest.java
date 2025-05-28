package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncidentsRegistrationAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add Incidents Registration successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Incidents Registration successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Incidents Registration successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Incidents Registration Tab > Add Incidents Registration")
    public void VerifyIncidentsRegistrationCreation() throws InterruptedException {

        log = LogManager.getLogger(IncidentsRegistrationAddTest.class);
        log.info("Starting Incidents Registration Add Test from Incidents Registration Tab.");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        Assert.assertTrue(pageObjectManager.getFreightDetail().isIncidentsRegistrationTabDisplayed(), "Incidents Registration tab is not Displayed");
        log.info("Tab Heading: " + pageObjectManager.getFreightDetail().getIncidentsRegistrationTabText());

        pageObjectManager.getFreightDetail().clickIncidentsRegistrationTab();
        log.info("Clicked Incidents Registration Tab");

    //----------------------------------Incidents Registration----------------------------------

        pageObjectManager.getIncidentsRegistrationPage().clickOnIncidentsRegAddIcon();
        log.info("Clicked On Incidents Registration Add Icon");

        Assert.assertTrue(pageObjectManager.getIncidentsRegistrationPage().isIncidentsRegPopupHeadingDisplayed(), "Incidents Registration Popup Heading Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getIncidentsRegistrationPage().getPopupHeading());

        pageObjectManager.getIncidentsRegistrationPage().enterIncidentsRegPopupProblemField(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Incidents Registration Problem Text");

        pageObjectManager.getIncidentsRegistrationPage().enterIncidentsRegPopupSolutionField(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Incidents Registration Solution Text");

        pageObjectManager.getIncidentsRegistrationPage().clickSubmitIncidentsRegButton();
        log.info("Clicked Submit Incidents Registration Button");

        Assert.assertTrue(pageObjectManager.getIncidentsRegistrationPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getIncidentsRegistrationPage().getSuccessAlertMessage());

        pageObjectManager.getIncidentsRegistrationPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
