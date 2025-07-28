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

        Assert.assertTrue(pageObjectManager.getBookedFreights().getHeading().contains("Booked Freights"), "Heading not Matched");

        // Click on the last page of freight listings
        pageObjectManager.getFreightListing().clickOnPaginationLastPageIcon();
        log.info("Clicked on Freight Pagination Last Icon");

        // Hover over the last record
        pageObjectManager.getFreightListing().hoverOverLastRecord();
        log.info("Hovered over the last record");

        pageObjectManager.getFreightListing().clickOnFreightID();
        log.info("Clicked on the 1st row FreightID.");

        pageObjectManager.getFreightListing().switchToNewTab();
        log.info("Switched to the new tab");

        System.out.println("After switching, active window: " + driver.getWindowHandle());
        System.out.println("All open windows: " + driver.getWindowHandles());

        Assert.assertTrue(pageObjectManager.getFreightDetail().isEditFreightIconDisplayed(), "Edit wrapper not displayed.");

    }
}