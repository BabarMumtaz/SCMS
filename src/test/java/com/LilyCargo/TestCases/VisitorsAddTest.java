package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class VisitorsAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Visitor",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Visitor successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.11_Visitors")
    @Story("As a user, I should be able to Add/Create Visitor successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Visitor")
    public void VerifyVisitorsAddTestCase(){

        log = LogManager.getLogger(VisitorsAddTest.class);
        log.info("Starting Visitor Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickVisitorsFRSubMenu();
        log.info("Clicked Visitor FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Visitors", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Visitor Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Visitor", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().selectVisitorsDate();
        log.info("Entered Visitor DATE: 3 Days from Current Date");

        pageObjectManager.getRelationsAllFieldsTestPage().selectLocation("Amsterdam");
        log.info("Selected Location");

        pageObjectManager.getRelationsAllFieldsTestPage().enterOrganization(faker.company().name()); // New method for Dutch phone number
        log.info("Entered Visitor Organization");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Visitor Name");

        pageObjectManager.getGlobalMethodsPage().selectGender("Female");
        log.info("Selected Gender");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAppointmentWith(faker.name().name()); // New method for Dutch phone number
        log.info("Entered Visitor Appointment With");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Clicked ALl Extra Fields Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Visitor Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Visitor successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
