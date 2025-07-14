package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.ExcelUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClientAddTest extends TestBeforeAndAfter {

    Logger log;

    // DataProvider to fetch data from Excel file
    @DataProvider
    public Object[][] getClientTestData() {
        return ExcelUtil.getTestData("ClientData",
                (System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\ClientTestData.xlsx"));
    }

    @Test(priority = 1,
            description = "Add Client",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add Client successfully")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Freight Relations > Add Client")
    public void AddClientAddTestCase(){

        log = LogManager.getLogger(ClientAddTestUsingExcelFile.class);
        log.info("Starting Client Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getClientPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getClientPage().getPageHeading());

        pageObjectManager.getClientPage().clickAddClientBtn();
        log.info("Clicked Client Add button");

        Assert.assertTrue(pageObjectManager.getClientPage().isClientSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getClientPage().getClientSuccessAlertMessage());

        pageObjectManager.getClientPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
