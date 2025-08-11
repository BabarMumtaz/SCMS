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
            description = "Add FreightManager",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Freight Manager successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Freight Manager successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Freight Manager")
    public void VerifyFreightManagerAddTestCase(){

        log = LogManager.getLogger(FreightManagerAddTest.class);
        log.info("Starting Freight Manager Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickFreightManagersFRSubMenu();
        log.info("Clicked Freight Manager FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getFreightManagersPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Freight Manager Page Heading: " + pageObjectManager.getFreightManagersPage().getPageHeading());

        pageObjectManager.getFreightManagersPage().clickAddFreightManagerBtn();
        log.info("Clicked Freight Manager Add button");

        Assert.assertTrue(pageObjectManager.getFreightManagersPage().isAddPageHeadingDisplayed(), "Add Page Heading Not Displayed");
        log.info("Freight Manager Add Page Heading: " + pageObjectManager.getFreightManagersPage().getAddPageHeading());

        pageObjectManager.getFreightManagersPage().enterFreightManagerName(faker.company().name());
        log.info("Entered Freight Manager Company Name");

        pageObjectManager.getFreightManagersPage().enterFreightManagerEmail(faker.internet().emailAddress());
        log.info("Entered Freight Manager Email");

        pageObjectManager.getFreightManagersPage().enterFreightManagerDutchPhoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Freight Manager Phone Number");

        pageObjectManager.getFreightManagersPage().clickExtraEmailFieldCross();
        log.info("Click Extra Email Field Cross");

        pageObjectManager.getFreightManagersPage().clickExtraAddressFieldCross();
        log.info("Click Extra Address Field Cross");

        pageObjectManager.getFreightManagersPage().clickExtraPhoneFieldCross();
        log.info("Click Extra Phone Field Cross");

        pageObjectManager.getFreightManagersPage().clickSaveFreightManagerBack();
        log.info("Click Save Freight Manager Button");

        Assert.assertTrue(pageObjectManager.getFreightManagersPage().isFreightManagerSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getFreightManagersPage().getFreightManagerSuccessAlertMessage());

        pageObjectManager.getFreightManagersPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
