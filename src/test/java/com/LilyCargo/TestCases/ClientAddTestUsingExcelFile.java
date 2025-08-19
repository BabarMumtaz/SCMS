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

public class ClientAddTestUsingExcelFile extends TestBeforeAndAfter {

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
    @Description("Verify that a user can Add/Create Client successfully by entering data in required fields Using Excel File")
    @Epic("Freight Relations 04")
    @Feature("Feature:04.02.02_Client")
    @Story("As a user, I should be able to Add/Create Client successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Create Client")
    public void AddClientTestUsingExcelFile(String Name, String ContactPerson, String Address1, String Email1, String FinancialEmail,
                              String FiscalMattersEmail1, String CeoEmail1, String TelephoneNumber1, String RegionDropDown,
                              String CountryDropDown, String ZipCity, String Vat, String LfrDropDown, String ScmEmails, String CustomsReleaseEmails, String BillingEmails) {

        log = LogManager.getLogger(ClientAddTestUsingExcelFile.class);
        log.info("Starting Client Add Test from Freight Relations using Excel file.");

        pageObjectManager.getMenuBar().clickFreightRelationsMenu();
        log.info("Clicked Freight Relations Menu");

        pageObjectManager.getMenuBar().clickClientFRSubMenu();
        log.info("Clicked Client FR Sub Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: " + pageHeading);
        Assert.assertEquals(pageHeading, "Clients", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked Client Add button");

        // Log the dropdown selections for clarity
        log.info("Adding client data: Region - " + RegionDropDown + ", Country - " + CountryDropDown + ", LFR - "
                + LfrDropDown);

        pageObjectManager.getClientPage().addClientData(Name, ContactPerson, Address1, Email1, FinancialEmail, FiscalMattersEmail1, CeoEmail1,
                TelephoneNumber1, RegionDropDown, CountryDropDown, ZipCity, Vat, LfrDropDown, ScmEmails, CustomsReleaseEmails, BillingEmails);

        String successAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Success Alert is: " + successAlert);
        Assert.assertEquals(successAlert, "Client successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupLP();
        log.info("Clicked Cross icon of Alert");

    }
}
