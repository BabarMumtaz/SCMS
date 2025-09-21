package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
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

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

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

        pageObjectManager.getFycoDataPage().enterPlatoNumberField(faker.number().digits(8));
        log.info("Entered PLATO #");

        pageObjectManager.getFycoDataPage().enterArticleNumberField(faker.number().digits(3));
        log.info("Entered Art #");

        pageObjectManager.getFycoDataPage().enterHsTaricNumberField("4202929890");
        log.info("Entered HS TERIC #");

/*        pageObjectManager.getFycoDataPage().enterHsTaricNumberField(faker.number().digits(10));
        log.info("Entered HS TERIC #");*/

        pageObjectManager.getFycoDataPage().enterProductDescriptionField(FakeDataUtil.getRemarks());
        log.info("Entered Product Description");

        pageObjectManager.getFycoDataPage().enterCtnsNumberField(faker.number().digits(4));
        log.info("Entered CTNS");

        pageObjectManager.getFycoDataPage().enterPcsField(faker.number().digits(4));
        log.info("Entered PCS");

        pageObjectManager.getFycoDataPage().enterGrossKGField(faker.number().digits(4));
        log.info("Entered Gross KG");

        pageObjectManager.getFycoDataPage().enterCvEuroField(faker.number().digits(6));
        log.info("Entered CV Euro");

        pageObjectManager.getGlobalMethodsPage().clickSubmitBtn();
        log.info("Clicked Submit Button");

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: {}", successAlert);
        Assert.assertEquals(successAlert, "Fyco successfully added.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup Cross Icon");

    }
}

