package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreightManagerAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add Freight Manager",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Freight Manager successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.06_FreightManagers")
    @Story("As a user, I should be able to Add/Create Freight Manager successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Freight Manager")
    public void VerifyFreightManagerAddTestCase(){

        log = LogManager.getLogger(FreightManagerAddTest.class);
        log.info("Starting Freight Manager Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickFreightManagersFRSubMenu();
        log.info("Clicked Freight Manager FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Freight Managers", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Freight Manager Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Freight Manager", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Freight Manager Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Freight Manager Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Freight Manager Phone Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Clicked ALl Extra Fields Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Freight Manager Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Freight Manager successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
