package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FycoDataAddTest extends TestBaseClass {

    Logger log;
    String fycoDataAddTestDescription = faker.lorem().characters(100);

    @Test(priority = 1, description = "Verify that a user can add Fyco Data successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Fyco Data successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to add Fyco Data successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Booked Freight > Detail > Fyco Data Tab > Add Fyco Data")
    public void AddFycoDataTest() throws InterruptedException {

        log = LogManager.getLogger(FycoDataAddTest.class);
        log.info("Starting FYCO DATA Add Test from Detail Page.");

        pageObjectManager.getFreightListing().hoverOn1stRowClient();
        log.info("Hover over 1st Row");

        // Click on the freight ID
        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        // Switch to the new tab
        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        // Check if the edit wrapper is displayed
        Assert.assertTrue(pageObjectManager.getFreightDetail().isFycoDataTabDisplayed(), "FYCO DATA tab is not Displayed");

        pageObjectManager.getFreightDetail().clickFycoDataTab();
        log.info("Clicked FYCO DATA Tab");

        //----------------------------------FYCO DATA----------------------------------
        pageObjectManager.getFycoDataPage().clickOnFycoDataAddIcon();
        log.info("Clicked On FYCO DATA Add Icon");

        Assert.assertTrue(pageObjectManager.getFycoDataPage().isFycoDataPopupHeadingDisplayed(), "FYCO DATA Popup Heading Not Displayed");
        log.info("Heading: " + pageObjectManager.getFycoDataPage().getPopupHeading());

        pageObjectManager.getFycoDataPage().enterPlatoNumberField(faker.number().digits(8));
        log.info("Entered FYCO DATA Problem Text");

        pageObjectManager.getFycoDataPage().enterArticleNumberField(faker.number().digits(3));
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().enterHsTaricNumberField(faker.number().digits(10));
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().enterProductDescriptionField(fycoDataAddTestDescription);
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().enterCtnsNumberField(faker.number().digits(4));
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().enterPcsField(faker.number().digits(4));
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().enterGrossKGField(faker.number().digits(4));
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().enterCvEuroField(faker.number().digits(6));
        log.info("Entered FYCO DATA Solution Text");

        pageObjectManager.getFycoDataPage().scrollToBottom();
        Thread.sleep(2000); // Replace with explicit wait if needed
        log.info("Scrolled to Submit Button.");

        pageObjectManager.getFycoDataPage().clickSubmitFycoDataButton();
        log.info("Clicked Submit FYCO DATA Button");

        Assert.assertTrue(pageObjectManager.getFycoDataPage().isSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Heading: " + pageObjectManager.getFycoDataPage().getSuccessAlertMessage());

        pageObjectManager.getFycoDataPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Alert Popup ");

        // Log out after the test
        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}

