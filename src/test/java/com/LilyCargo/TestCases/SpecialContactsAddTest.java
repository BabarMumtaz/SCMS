package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpecialContactsAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Special Contact",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Special Contact successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.14_Special Contacts")
    @Story("As a user, I should be able to Add/Create Special Contact successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Special Contact")
    public void VerifySpecialContactsAddTestCase(){

        log = LogManager.getLogger(SpecialContactsAddTest.class);
        log.info("Starting Special Contact Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickSpecialContactsFRSubMenu();
        log.info("Clicked Special Contact FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Special Contacts", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Special Contact Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Special Contact", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterOrganization(faker.company().industry()); // New method for Dutch phone number
        log.info("Entered Special Contact Organization");

        pageObjectManager.getRelationsAllFieldsTestPage().enterBranch(faker.company().name()); // New method for Dutch phone number
        log.info("Entered Special Contact Branch");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Special Contact Name");

        pageObjectManager.getGlobalMethodsPage().selectGender("Female");
        log.info("Selected Gender");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Special Contact Telephone Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Special Contact Email");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Clicked ALl Extra Fields Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Special Contact Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Special Contact successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
