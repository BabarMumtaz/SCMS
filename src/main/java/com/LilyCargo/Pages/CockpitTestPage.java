package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

public class CockpitTestPage {

    WebDriver driver;
    WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(CockpitTestPage.class);

    // Constructor that will be automatically called as soon as the object of the class is created
    public CockpitTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//span[contains(text(),'Mobile View ')]")
    WebElement mobileView;

    @FindBy(xpath = "(//canvas[@role='img'])[1]")
    WebElement mobileViewGraphArea;

    @FindBy(xpath = "//button[text()='Refresh'][1]")
    WebElement mobileViewRefreshBtn;

    @FindBy(xpath = "//img[@alt='icon']")
    WebElement dashboardViewIcon;

    @FindBy(xpath = "//span[contains(text(),'Customs Entries (DMS)')]")
    WebElement customsEntriesTriggerHeading;

    @FindBy(xpath = "//h2[text()='Cockpit']")
    WebElement cockpitPageHeading;

    @FindBy(xpath = "//div[@class='cockpit-side-content']")
    WebElement cockpitSideContent;

    @FindBy(xpath = "//div[@class='cockpit-side-content']//table//tr[td and td[2]]")
    List<WebElement> cockpitTriggers;

    @FindBy(xpath = "//td[text()='Cleared']")
    WebElement clearedTrigger;

    @FindBy(xpath = "//h3[1]")
    WebElement cockpitTriggersDynamicAreaText;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr[1]/td[1]")
    WebElement dynamicListingDateCell;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr")
    List<WebElement> listingRows;

    @FindBy(xpath = "//p[text()='No data found']")
    WebElement dynamicListingNoDataText;

    @FindBy(xpath = "//button[contains(text(),'Low Margin Projection')]")
    WebElement lowMarginProjectionTabName;

    @FindBy(xpath = "//button[contains(text(),'Latest Incident Registrations')]")
    WebElement latestIncidentRegistrationsTabName;

    @FindBy(xpath = "//button[contains(text(),'Daily Import Duty')]")
    WebElement dailyImportDutyTabName;

    @FindBy(xpath = "(//div[@class='cockpit-table-wrapper position-relative'])[1]/table/tbody/tr[1]/td[1]")
    WebElement latestAddedPlatoListingDateCell;

    @FindBy(xpath = "(//div[@class='cockpit-table-wrapper position-relative'])[2]/table/tbody/tr[1]/td[1]")
    WebElement lowMarginProjectionListingDateCell;

    @FindBy(xpath = "(//div[@class='cockpit-table-wrapper latest-incident-table position-relative'])[1]/table/tbody/tr[1]/td[1]")
    WebElement latestIncidentListingDateCell;

    @FindBy(xpath = "(//div[@class='cockpit-table-wrapper latest-incident-table position-relative'])[2]/table/tbody/tr[1]/td[1]")
    WebElement dailyImportDutyListingDateCell;

    @FindBy(xpath = "(//img[@alt='icon'])[3]")
    WebElement dailyImportDutyListingFidExportIcon;

    @FindBy(xpath = "//button[@aria-label='Go to first page']")
    WebElement paginationFirstPageIcon;

    @FindBy(xpath = "//button[@aria-label='Go to next page' and not(@disabled)]")
    WebElement paginationNextBtn;

    @FindBy(xpath = "//button[@aria-label='Go to last page']")
    WebElement paginationLastPageIcon;

    @FindBy(xpath = "//button[@aria-label='Go to last page' and not(@disabled)]")
    WebElement paginationLastBtn;

    // Dynamic section/trigger selectors
    By sectionLocator = By.xpath("//div[contains(@class,'cockpit-side-content')]//tbody"); // Adjust if needed
    By triggerLocator = By.xpath(".//tr[contains(@class, 'sidebar-item')]//td[1]");


//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public String getPageHeading() {
        return cockpitPageHeading.getText();
    }

    public boolean isPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cockpitPageHeading)).isDisplayed();
    }

    public String getCustomsEntriesTriggerHeading() {
        return customsEntriesTriggerHeading.getText();
    }

    public boolean isCustomsEntriesTriggerHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading)).isDisplayed();
    }

    public String getCockpitTriggersDynamicAreaText() {
        wait.until(ExpectedConditions.visibilityOf(dynamicListingDateCell));
        return cockpitTriggersDynamicAreaText.getText();
    }


    public boolean isCockpitTriggersDynamicAreaTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cockpitTriggersDynamicAreaText)).isDisplayed();
    }

    public void extractAndSaveAllCockpitTriggersData() {
        wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading));

        // File path where data will be written
        String filePath = "cockpit_triggers_data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

                String triggersText = cockpitSideContent.getText().trim();

                String triggersLogs = "📥 Triggers" + " Data:\n" + triggersText + "\n";

                log.info(triggersLogs);
                writer.write(triggersLogs);

            log.info("✅ Cockpit triggers data successfully written to: " + filePath);

        } catch (IOException e) {
            log.error("❌ Failed to write Cockpit triggers data to file: " + e.getMessage());
        }
    }

    public void clickLowMarginProjectionTabName() {
        lowMarginProjectionTabName.click();
    }

    public void clickLatestIncidentTabName() {
        latestIncidentRegistrationsTabName.click();
    }

    public void clickDailyImportDutyTabName() {
        dailyImportDutyTabName.click();
    }

    public void clickTab(String tabName) {
        WebElement tabElement;
        switch (tabName.toLowerCase()) {
            case "low margin projection":
                tabElement = lowMarginProjectionTabName;
                break;
            case "latest incident registrations":
                tabElement = latestIncidentRegistrationsTabName;
                break;
            case "daily import duty":
                tabElement = dailyImportDutyTabName;
                break;
            default:
                log.warn("⚠️ Invalid tab name: " + tabName);
                return;
        }
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
    }

    public void clickDailyImportDutyFidExportIcon() {
        wait.until(ExpectedConditions.visibilityOf(dailyImportDutyListingFidExportIcon)).click();
    }

    public void clickMobileViewIcon() {
        mobileView.click();
    }

    public void clickMobileViewRefreshBtn() {
        wait.until(ExpectedConditions.visibilityOf(mobileViewGraphArea));
        mobileViewRefreshBtn.click();
    }

    public void clickDashboardViewIcon() {
        dashboardViewIcon.click();
    }

/*
    public List<String> processCockpitTriggers(int max) {
        wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading));
        List<String> results = new ArrayList<>();

        for (int i = 0; i < Math.min(cockpitTriggers.size(), max); i++) {
            WebElement trigger = cockpitTriggers.get(i);
            String triggerText = trigger.getText().trim();

            try {
                wait.until(ExpectedConditions.elementToBeClickable(trigger)).click();
                log.info("🖱️ Clicked Trigger: " + triggerText);

                wait.until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOf(dynamicListingNoDataText),
                        ExpectedConditions.visibilityOf(dynamicListingDateCell),
                        ExpectedConditions.textToBePresentInElement(cockpitTriggersDynamicAreaText, triggerText.split(" ")[0])
                ));

                String heading = cockpitTriggersDynamicAreaText.getText().trim();
                String result = !listingRows.isEmpty()
                        ? "✅ Data found (" + listingRows.size() + " rows)"
                        : (dynamicListingNoDataText.isDisplayed() ? "ℹ️ No data found" : "⚠️ Unknown state");

                String summary = "Trigger: " + triggerText + " ➤ Heading: " + heading + " ➤ Result: " + result;
                log.info(summary);
                results.add(summary);

            } catch (TimeoutException e) {
                log.warn("⏳ Timeout waiting for trigger: " + triggerText);
            } catch (Exception e) {
                log.error("❌ Error processing trigger: " + triggerText + " | " + e.getMessage());
            }
        }

        return results;
    }
*/

    public List<String> processCockpitTriggers(int max) {
        wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading));
        List<String> results = new ArrayList<>();

        int limit = Math.min(cockpitTriggers.size(), max);

        for (int i = 0; i < limit; i++) {
            WebElement trigger = cockpitTriggers.get(i);
            String triggerText = trigger.getText().trim();

            try {
                // Scroll to the element for safety
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", trigger);

                // Wait for clickability and click
                wait.until(ExpectedConditions.elementToBeClickable(trigger)).click();
                log.info("🖱️ Clicked Trigger: " + triggerText);

                // Wait until the heading reflects the correct section
                wait.until(ExpectedConditions.textToBePresentInElement(
                        cockpitTriggersDynamicAreaText, triggerText.split(" ")[0]
                ));

                // Wait briefly for any data/no-data message to appear
                try {
                    wait.withTimeout(Duration.ofSeconds(2)); // Shorter timeout
                    wait.until(ExpectedConditions.or(
                            ExpectedConditions.visibilityOf(dynamicListingNoDataText),
                            ExpectedConditions.visibilityOf(dynamicListingDateCell)
                    ));
                } catch (TimeoutException ignored) {
                    // No data or rows found within quick timeout
                } finally {
                    // Reset timeout to default after custom wait
                    wait.withTimeout(Duration.ofSeconds(10));
                }

                String heading = cockpitTriggersDynamicAreaText.getText().trim();
                String result;

                if (!listingRows.isEmpty()) {
                    result = "✅ Data found (" + listingRows.size() + " rows)";
                } else if (isElementVisible(dynamicListingNoDataText)) {
                    result = "ℹ️ No data found";
                } else {
                    result = "⚠️ Unknown state";
                }

                String summary = "Trigger: " + triggerText + " ➤ Heading: " + heading + " ➤ Result: " + result;
                log.info(summary);
                results.add(summary);

            } catch (TimeoutException e) {
                log.warn("⏳ Timeout waiting for trigger: " + triggerText);
            } catch (Exception e) {
                log.error("❌ Error processing trigger: " + triggerText + " | " + e.getMessage());
            }
        }

        return results;
    }

    // Utility method to safely check element visibility
    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
