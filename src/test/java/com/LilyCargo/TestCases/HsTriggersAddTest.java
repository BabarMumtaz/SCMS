package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import com.LilyCargo.Util.FakeDataUtil;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HsTriggersAddTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1,
            description = "Add HS Triggers",
            groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can add HS Triggers successfully")
    @Epic("Administration 02")
    @Feature("Feature:02.02_HsTriggers")
    @Story("As a user, I should be able to Add/Create All HS Triggers successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Administration > HS Triggers > Add All HS Triggers")
    public void VerifyHsTriggersAddTestCase(){

        log = LogManager.getLogger(HsTriggersAddTest.class);
        log.info("Starting HS Triggers Add Test from Freight Relations.");

        pageObjectManager.getMenuBar().clickAdministrationMenu();
        log.info("Clicked Administration Menu");

        pageObjectManager.getMenuBar().clickHsTriggersAdminSubMenu();
        log.info("Clicked HS Triggers Sub Menu");

        String dumpDutyHsHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading of 1st Tab is: {}", dumpDutyHsHeading);
        Assert.assertEquals(dumpDutyHsHeading, "DUMP DUTY HS", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked DUMP DUTY HS Add button");

        String dumpDutyHsAddHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", dumpDutyHsAddHeading);
        Assert.assertEquals(dumpDutyHsAddHeading, "Add Dump Duty HS", "Add Page heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(10));
        log.info("Entered Dump Duty HS Code");

        pageObjectManager.getHsTriggersPage().enterA30DutyPercent(FakeDataUtil.getRandomDecimalValues());
        log.info("Entered Dump Duty HS A30%");

        pageObjectManager.getHsTriggersPage().enterA35DutyPercent(FakeDataUtil.getRandomDecimalValues());
        log.info("Entered Dump Duty HS A35%");

        pageObjectManager.getHsTriggersPage().enterOther1(FakeDataUtil.getRemarks());
        log.info("Entered Dump Duty HS Other1");

        pageObjectManager.getHsTriggersPage().enterOther2(FakeDataUtil.getRemarks());
        log.info("Entered Dump Duty HS Other2");

        pageObjectManager.getHsTriggersPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered Dump Duty HS Remarks");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Clicked Save Dump Duty HS Button");

        String dumpDutyHsSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("Dump Duty HS Success Alert is: {}", dumpDutyHsSuccessAlert);
        Assert.assertEquals(dumpDutyHsSuccessAlert, "Dump Duty HS successfully created.",
                "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        /** ---------- CBAM HS TAB ---------- */

        pageObjectManager.getHsTriggersPage().clickCbamHsTab();
        log.info("Clicked CBAM HS TAB");

        String cbamHsHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading of 2nd Tab is: {}", cbamHsHeading);
        Assert.assertEquals(cbamHsHeading, "CBAM HS", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked CBAM HS Add button");

        String cbamHsAddHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", cbamHsAddHeading);
        Assert.assertEquals(cbamHsAddHeading, "Add CBAM HS", "Add Page heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(8));
        log.info("Entered CBAM HS Code");

        pageObjectManager.getHsTriggersPage().enterDirectDefaultValue(FakeDataUtil.getRandomDecimalValues());
        log.info("Entered CBAM HS Direct Default Value");

        pageObjectManager.getHsTriggersPage().enterIndirectDefaultValue(FakeDataUtil.getRandomDecimalValues());
        log.info("Entered CBAM HS Indirect Default Value");

        pageObjectManager.getHsTriggersPage().enterAverageValue(FakeDataUtil.getRandomDecimalValues());
        log.info("Entered CBAM HS Average Value");

        pageObjectManager.getHsTriggersPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered CBAM HS Remarks");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Clicked Save CBAM HS Button");

        String cbamHsSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("CBAM HS Success Alert is: {}", cbamHsSuccessAlert);
        Assert.assertEquals(cbamHsSuccessAlert, "CBAM HS successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        /** ---------- EUDR HS TAB ---------- */

        pageObjectManager.getHsTriggersPage().clickEudrHsTab();
        log.info("Clicked EUDR HS TAB");

        String eudrHsHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", eudrHsHeading);
        Assert.assertEquals(eudrHsHeading, "EUDR HS", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked EUDR HS Add button");

        String eudrHsAddHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", eudrHsAddHeading);
        Assert.assertEquals(eudrHsAddHeading, "Add EUDR HS", "Add Page heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(4));
        log.info("Entered EUDR HS Code");

        pageObjectManager.getHsTriggersPage().enterHeading(FakeDataUtil.getRemarks());
        log.info("Entered EUDR HS Heading");

        pageObjectManager.getHsTriggersPage().enterSubHeading(FakeDataUtil.getRemarks());
        log.info("Entered EUDR HS Sub Heading");

        pageObjectManager.getHsTriggersPage().enterTypeOfDocsNeeded(FakeDataUtil.getRemarks());
        log.info("Entered EUDR HS Type Of Docs Needed");

        pageObjectManager.getHsTriggersPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered EUDR HS Remarks");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Clicked Save EUDR HS Button");

        String eudrHsSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("EUDR HS Success Alert is: {}", eudrHsSuccessAlert);
        Assert.assertEquals(eudrHsSuccessAlert, "EUDR HS successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        /** ---------- MADB HS TAB ---------- */

        pageObjectManager.getHsTriggersPage().clickMadbHsTab();
        log.info("Clicked MADB HS TAB");

        String madbHsHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", madbHsHeading);
        Assert.assertEquals(madbHsHeading, "MADB HS", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked MADB HS Add button");

        String madbHsAddHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", madbHsAddHeading);
        Assert.assertEquals(madbHsAddHeading, "Add MADB HS", "Add Page heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(10));
        log.info("Entered MADB HS Code");

        pageObjectManager.getHsTriggersPage().enterCnEurKg(FakeDataUtil.getRandomCooDecimalValues());
        log.info("Entered MADB HS CnEurKg");

        pageObjectManager.getHsTriggersPage().enterInEurKg(FakeDataUtil.getRandomCooDecimalValues());
        log.info("Entered MADB HS InEurKg");

        pageObjectManager.getHsTriggersPage().enterVnEurKg(FakeDataUtil.getRandomCooDecimalValues());
        log.info("Entered MADB HS Sub VnEurKg");

        pageObjectManager.getHsTriggersPage().enterIdEurKg(FakeDataUtil.getRandomCooDecimalValues());
        log.info("Entered MADB HS IdEurKg");

        pageObjectManager.getHsTriggersPage().enterWorldEurKg(FakeDataUtil.getRandomCooDecimalValues());
        log.info("Entered MADB HS WorldEurKg");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Clicked Save MADB HS Button");

        String madbHsSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("MADB HS Success Alert is: {}", madbHsSuccessAlert);
        Assert.assertEquals(madbHsSuccessAlert, "MADB HS successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

        /** ---------- N851 HS TAB ---------- */

        pageObjectManager.getHsTriggersPage().clickN851HsTab();
        log.info("Clicked N851 HS TAB");

        String n851HsHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", n851HsHeading);
        Assert.assertEquals(n851HsHeading, "N851 HS", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked N851 HS Add button");

        String n851HsAddHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", n851HsAddHeading);
        Assert.assertEquals(n851HsAddHeading, "Add N851 HS", "Add Page heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(10));
        log.info("Entered N851 HS Code");

        pageObjectManager.getHsTriggersPage().enterNyCode(faker.address().zipCode());
        log.info("Entered N851 HS NyCode");

        pageObjectManager.getHsTriggersPage().enterDescription(FakeDataUtil.getRemarks());
        log.info("Entered N851 HS Description");

        pageObjectManager.getHsTriggersPage().enterBotanicName(FakeDataUtil.getRemarks());
        log.info("Entered N851 HS Botanic Name");

        pageObjectManager.getHsTriggersPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered EUDR HS Remarks");

        pageObjectManager.getHsTriggersPage().enterRemarks2(FakeDataUtil.getRemarks());
        log.info("Entered EUDR HS Remarks 2");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Clicked Save N851 HS Button");

        String n851HsSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("N851 HS Success Alert is: {}", n851HsSuccessAlert);
        Assert.assertEquals(n851HsSuccessAlert, "N851 HS successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

       /** ---------- OTHERS HS TAB ---------- */

        pageObjectManager.getHsTriggersPage().clickOtherHsTab();
        log.info("Clicked OTHERS HS TAB");

        String othersHsHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", othersHsHeading);
        Assert.assertEquals(othersHsHeading, "OTHER HS", "Page heading does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickAddButton();
        log.info("Clicked OTHERS HS Add button");

        String othersHsAddHeading = pageObjectManager.getGlobalMethodsPage().getAddPageHeading();
        log.info("Add Page Heading is: {}", othersHsAddHeading);
        Assert.assertEquals(othersHsAddHeading, "Add Other HS", "Add Page heading does not match expected value.");

        pageObjectManager.getHsTriggersPage().enterHsCode(FakeDataUtil.getHsCode(10));
        log.info("Entered OTHERS HS Code");

        pageObjectManager.getHsTriggersPage().enterNote1(FakeDataUtil.getRemarks());
        log.info("Entered OTHERS HS Note1");

        pageObjectManager.getHsTriggersPage().enterNote2(FakeDataUtil.getRemarks());
        log.info("Entered OTHERS HS Note2");

        pageObjectManager.getHsTriggersPage().enterRemarks(FakeDataUtil.getRemarks());
        log.info("Entered OTHERS HS Remarks");

        pageObjectManager.getHsTriggersPage().enterRemarks2(FakeDataUtil.getRemarks());
        log.info("Entered OTHERS HS Remarks 2");

        pageObjectManager.getGlobalMethodsPage().clickSaveAndBackBtn();
        log.info("Clicked Save OTHERS HS Button");

        String othersHsSuccessAlert = pageObjectManager.getGlobalMethodsPage().getAlertPopupText();
        log.info("OTHERS HS Success Alert is: {}", othersHsSuccessAlert);
        Assert.assertEquals(othersHsSuccessAlert, "Other HS successfully created.", "Success Alert does not match expected value.");

        pageObjectManager.getGlobalMethodsPage().clickOnAlertPopupCrossIcon();
        log.info("Clicked Cross icon of Alert");

    }
}
