package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfileEditTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Edit My Profile",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can edit My Profile successfully")
    @Epic("Administration")
    @Feature("Feature:01.02_Overview_My Profile")
    @Story("As a user, I should be able to Edit My Profile successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > Overview > My Profiles > Edit My Profile")
    public void VerifyMyProfileEditTestCase(){

        log = LogManager.getLogger(MyProfileEditTest.class);
        log.info("Starting My Profile Edit Test from Administration.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickOverviewAdmSubMenu();
        log.info("Clicked My Profile Sub Menu");

        String mainPageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Main Page Heading is: " + mainPageHeading);
        Assert.assertEquals(mainPageHeading, "Overview", "Page heading does not match expected value.");

        pageObjectManager.getAdminOverviewTestPage().clickMyProfileBtn();
        log.info("Clicked My Profile button");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "My Profile", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickEditDetailsBtn();
        log.info("Clicked Personal Info Edit button");

        pageObjectManager.getGlobalMethodsPage().clickUpdateBtn();
        log.info("Click Update My Profile Button");

        String personalInfoSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + personalInfoSuccessAlert);
        Assert.assertEquals(personalInfoSuccessAlert, "Profile Updated successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getGlobalMethodsPage().clickCancelBtn();
        log.info("Click Cancel Button");

        /** ---------- AccountInfo Section ---------- */

        pageObjectManager.getGlobalMethodsPage().clickEditDetailsBtn02();
        log.info("Clicked Account Info Edit button");

        pageObjectManager.getGlobalMethodsPage().clickUpdateBtn();
        log.info("Click Update My Profile Button");

        String accountInfoSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + accountInfoSuccessAlert);
        Assert.assertEquals(accountInfoSuccessAlert, "Profile Updated successfully", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getGlobalMethodsPage().clickCancelBtn();
        log.info("Click Cancel My Profile Button");

    }
}