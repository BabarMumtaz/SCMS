package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import com.LilyCargo.Util.FileUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FycoDataAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can add Fyco Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Fyco Data successfully")
    @Epic("Booked Freight 03")
    @Feature("Feature:03.08_Fyco Data")
    @Story("As a user, I should be able to add Fyco Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Fyco Data Tab > Add Fyco Data")
    public void VerifyFycoDataCreation(){

        log = LogManager.getLogger(FycoDataAddTest.class);
        log.info("Starting FYCO DATA Add Test from FYCO DATA Tab.");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked Booked Freight Button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        pageObjectManager.getFreightListing().searchFid("106312");
        log.info("Entered FID# 106312 in the search");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);

        String tabHeading = pageObjectManager.getFreightDetail().getFycoDataTabText();
        log.info("Tab Heading is: {}", tabHeading);
        Assert.assertEquals(tabHeading, "Fyco Data", "Page heading does not match expected value.");

        pageObjectManager.getFreightDetail().clickFycoDataTab();
        log.info("Clicked FYCO DATA Tab");

        pageObjectManager.getFycoDataPage().clickOnFycoDataAddIcon();
        log.info("Clicked On FYCO DATA Add Icon");

        String popupHeading = pageObjectManager.getGlobalMethodsPage().getPopupHeadingText();
        log.info("Popup Heading is: {}", popupHeading);
        Assert.assertEquals(popupHeading, "New PLATO Entry", "Popup heading does not match expected value.");

        pageObjectManager.getFycoDataPage().enterMrnNumberField("25NL5T9XOKCWAHMDR9");
        log.info("Entered MRN# 25NL5T9XOKCWAHMDR9");

        pageObjectManager.getFycoDataPage().clickMrnNumberFieldVerifyBtn();
        log.info("Clicked MrnNumberFieldVerifyBtn");

        String mrnSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", mrnSuccessAlert);
        Assert.assertEquals(mrnSuccessAlert, "MRN validated successfully.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");

        pageObjectManager.getFycoDataPage().enterPlatoNumberField(faker.number().digits(8));
        log.info("Entered PLATO #");

        pageObjectManager.getFycoDataPage().enterArticleNumberField(faker.number().digits(3));
        log.info("Entered Art #");

        pageObjectManager.getFycoDataPage().enterHsTaricNumberField("8510200000");
        log.info("Entered HS TERIC# 8510200000");

/*        pageObjectManager.getFycoDataPage().enterHsTaricNumberField(faker.number().digits(10));
        log.info("Entered HS TERIC #");*/

/*        pageObjectManager.getFycoDataPage().enterProductDescriptionField(FakeDataUtil.getRemarks());
        log.info("Entered Product Description");

        pageObjectManager.getFycoDataPage().enterCtnsNumberField(faker.number().digits(4));
        log.info("Entered CTNS");

        pageObjectManager.getFycoDataPage().enterPcsField(faker.number().digits(4));
        log.info("Entered PCS");

        pageObjectManager.getFycoDataPage().enterGrossKGField(faker.number().digits(4));
        log.info("Entered Gross KG");

        pageObjectManager.getFycoDataPage().enterCvEuroField(faker.number().digits(6));
        log.info("Entered CV Euro");*/

        pageObjectManager.getFycoDataPage().clickHsTaricFieldVerifyBtn();
        log.info("Clicked HsTericFieldVerifyBtn");

        String hsTaricSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", hsTaricSuccessAlert);
        Assert.assertEquals(hsTaricSuccessAlert, "HS Taric# found in cargo data.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Fyco successfully added.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

    }
}

