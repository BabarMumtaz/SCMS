package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CarrierAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add carrier successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add carrier successfully")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.01_Carriers")
    @Story("As a user, I should be able to add carrier successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Carriers Relation > Add Carrier")
    public void VerifyCarrierAddTestCase() {

        log = LogManager.getLogger(CarrierAddTest.class);
        log.info("Starting Carrier Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickCarriersFRSubMenu();
        log.info("Clicked Carriers FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Carriers", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Carriers Add button");

        String addPageHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: " + addPageHeading);
        Assert.assertEquals(addPageHeading, "Add Carrier", "Add Page heading does not match expected value.");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTicker(faker.company().name());
        log.info("Entered Ticker Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterName(faker.name().name());
        log.info("Entered Carrier's Name");

        pageObjectManager.getRelationsAllFieldsTestPage().enterEmail(faker.internet().emailAddress());
        log.info("Entered Carrier's Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterTelephoneNumber(FakeDataUtil.getDutchPhoneNumber()); // New method for Dutch phone number
        log.info("Entered Carrier's Tel Number");

        pageObjectManager.getRelationsAllFieldsTestPage().enterAddress1(faker.address().streetAddress());
        log.info("Entered Address");

        pageObjectManager.getRelationsAllFieldsTestPage().enterZipCity(faker.address().zipCode());
        log.info("Entered Zip City");

        pageObjectManager.getGlobalMethodsPage().selectCountryName("CHINA");
        log.info("Selected Country");

        pageObjectManager.getRelationsAllFieldsTestPage().enterExtraEmailLabel("Extra Email");
        log.info("Entered Extra Email");

        pageObjectManager.getRelationsAllFieldsTestPage().enterExtraEmailValue(faker.internet().emailAddress());
        log.info("Entered Extra Email Value");

        pageObjectManager.getGlobalMethodsPage().clickAllDynamicCrossIcons();
        log.info("Click Extra Field Cross");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Click Save Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Carrier successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}