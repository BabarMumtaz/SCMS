package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.LilyCargo.Util.ExcelUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

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
            dataProvider = "getClientTestData",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Add/Create Client successfully by entering data in required fields")
    @Epic("EP001")
    @Feature("Feature:004")
    @Story("As a user, I should be able to Add/Create Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Create Client")
    public void AddClientTest(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail,
                              String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1, String RegionDropDown,
                              String CountryDropDown, String ZipCity, String Vat, String LfrDropDown, String ScmEmails, String CustomsReleaseEmails, String BillingEmails) {

        log = LogManager.getLogger(ClientAddTest.class);
        log.info("Starting Client Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        Assert.assertTrue(pageObjectManager.getClientPage().isHeadingDisplayed(), "Heading Not Displayed");
        log.info("Page Heading: " + pageObjectManager.getClientPage().getPageHeading());

        pageObjectManager.getClientPage().clickAddClientBtn();
        log.info("Clicked Client Add button");

        // Log the dropdown selections for clarity
        log.info("Adding client data: Region - " + RegionDropDown + ", Country - " + CountryDropDown + ", LFR - "
                + LfrDropDown);

        pageObjectManager.getClientPage().addClientData(Name, ContactPerson, Address1, Email1, FinancialEmail, FiscalMattersEmail1, CeoEmail1,
                TelephoneNumber1, RegionDropDown, CountryDropDown, ZipCity, Vat, LfrDropDown, ScmEmails, CustomsReleaseEmails, BillingEmails);

        Assert.assertTrue(pageObjectManager.getClientPage().isClientSuccessAlertMessageDisplayed(), "Success Alert Message Not Displayed");
        log.info("Success Alert Message: " + pageObjectManager.getClientPage().getClientSuccessAlertMessage());

        pageObjectManager.getClientPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

        pageObjectManager.getLoginPage().logout();
        log.info("Logged out successfully.");
    }
}
