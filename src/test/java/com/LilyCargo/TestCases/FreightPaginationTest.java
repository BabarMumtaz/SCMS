package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBeforeAndAfter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreightPaginationTest extends TestBeforeAndAfter {

    Logger log;

    @Test(priority = 1, description = "Verify that a user can Add/Create freight successfully", groups = {"smoke", "regression"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a user can Add/Create freight successfully by entering data in required fields")
    @Epic("EP001")
    @Feature("Feature:002")
    @Story("As a user, I should be able to Add/Create freight successfully")
    @Step("Hit Site Url -> Login with valid credentials -> Create freight")
    public void FreightPagination() throws InterruptedException {

        log = LogManager.getLogger(FreightPaginationTest.class);
        log.info("Starting Freight Add Test.");

        pageObjectManager.getMenuBar().clickBookedFreightMenu();
        log.info("Clicked on Booked Freight Menu");

        String pageHeading = pageObjectManager.getGlobalMethodsPage().getMainPageHeadingText();
        log.info("Page Heading is: {}", pageHeading);
        Assert.assertEquals(pageHeading, "Booked Freights", "Page heading does not match expected value.");

        pageObjectManager.getFreightListing().clickSpecificFID();
/*
        // Click on the last page of freight listings
        pageObjectManager.getFreightListing().clickOnPaginationLastPageIcon();
        log.info("Clicked on Freight Pagination Last Icon");

        pageObjectManager.getFreightListing().clickLastFIDFromLastPage();*/

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        String fidNumber = pageObjectManager.getBookedFreights().getFidNumberText();
        log.info("Clicked Fid Number: {}", fidNumber);

        System.out.println("After switching, active window: " + driver.getWindowHandle());
        System.out.println("All open windows: " + driver.getWindowHandles());

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit wrapper not displayed.");

    }
}