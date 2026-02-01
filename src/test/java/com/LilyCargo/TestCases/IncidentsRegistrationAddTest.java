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
    @Epic("Booked Freight 03")
    @Feature("Feature:03.07_Incidents Registration")
    @Story("As a user, I should be able to add Incidents Registration successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Incidents Registration Tab > Add Incidents Registration")
    public void VerifyIncidentsRegistrationCreation() {

        log = LogManager.getLogger(IncidentsRegistrationAddTest.class);
        log.info("Starting Incidents Registration Add Test from Incidents Registration Tab.");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);

        String tabHeading = pageObjectManager.getFreightDetail().getIncidentsRegistrationTabText();
        log.info("Tab Heading is: {}", tabHeading);
        Assert.assertEquals(tabHeading, "Incidents Registration", "Page heading does not match expected value.");

        pageObjectManager.getFreightDetail().clickIncidentsRegistrationTab();
        log.info("Clicked Incidents Registration Tab");

        pageObjectManager.getIncidentsRegistrationPage().clickOnIncidentsRegAddIcon();
        log.info("Clicked On Incidents Registration Add Icon");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "Add Incidents Register", "Popup heading does not match expected value.");

        pageObjectManager.getIncidentsRegistrationPage().enterIncidentsRegPopupProblemField(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Incidents Registration Problem Text");

        pageObjectManager.getIncidentsRegistrationPage().enterIncidentsRegPopupSolutionField(FakeDataUtil.getIncidentsRegProblemSolution());
        log.info("Entered Incidents Registration Solution Text");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Incidents Registration Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Incident registered successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

        pageObjectManager.getBookedFreights().enterFidNumber("27450");
        log.info("Entered Incidents Registration Solution Text");

        pageObjectManager.getBookedFreights().clickSearchGoBtn();
        log.info("Clicked Search Go Btn");

        String newFidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Searched Fid Number: {}", newFidNumber);

    }
}
