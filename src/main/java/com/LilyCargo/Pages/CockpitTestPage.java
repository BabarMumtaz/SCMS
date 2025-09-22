package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    /** ---------- Locators ---------- */

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

    @FindBy(xpath = "//button[contains(text(),'Latest added PLATO numbers')]")
    WebElement latestAddedPlatoTabName;

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

    /** ---------- Methods ---------- */

    public String getCustomsEntriesTriggerHeading() {
        return customsEntriesTriggerHeading.getText();
    }

/*    public boolean isCustomsEntriesTriggerHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading)).isDisplayed();
    }*/

    public boolean isCustomsEntriesTriggerHeadingDisplayed() {
        return isElementDisplayed(customsEntriesTriggerHeading);
    }

    public String getCockpitTriggersDynamicAreaText() {
        wait.until(ExpectedConditions.visibilityOf(dynamicListingDateCell));
        return cockpitTriggersDynamicAreaText.getText();
    }

    public boolean isCockpitTriggersDynamicAreaTextDisplayed() {
        return isElementDisplayed(cockpitTriggersDynamicAreaText);
    }

    public void clickTab(String tabName) {
        WebElement tabElement;
        switch (tabName.toLowerCase()) {
            case "latest added plato":
                tabElement = latestAddedPlatoTabName;
                break;
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

    public void clickLowMarginProjectionTabName() {
        lowMarginProjectionTabName.click();
    }

    public void clickLatestIncidentTabName() {
        latestIncidentRegistrationsTabName.click();
    }

    public void clickDailyImportDutyTabName() {
        dailyImportDutyTabName.click();
    }

    public boolean isLatestAddedPlatoListingDateCellDisplayed() {
        return isElementDisplayed(latestAddedPlatoListingDateCell);
    }

    public boolean isLowMarginProjectionListingDateCellDisplayed() {
        return isElementDisplayed(lowMarginProjectionListingDateCell);
    }

    public boolean isLatestIncidentListingDateCellDisplayed() {
        return isElementDisplayed(latestIncidentListingDateCell);
    }

    public boolean isDailyImportDutyListingDateCellDisplayed() {
        return isElementDisplayed(dailyImportDutyListingDateCell);
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

    /** ---------- Utility Methods ---------- */

    private void scrollToAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private boolean isElementDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public List<String> extractAndSaveAllCockpitTriggersData() {
        wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading));

        List<String> triggersData = new ArrayList<>();
        String triggersText = cockpitSideContent.getText().trim();

        String triggersLogs = "📥 Triggers" + " Data:\n" + triggersText + "\n";

        log.info(triggersLogs);

        saveListToFileWithTimestamp(triggersData, "cockpit_triggers_listData");
        return triggersData;
    }

    public void saveListToFileWithTimestamp(List<String> data, String baseFileName) {
        // Format: 2025-08-05_14-33-12
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        // Define the output directory path
        String outputDirPath = System.getProperty("user.dir") + "/output";
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs(); // create the /output/ folder if it doesn't exist
        }

        // Construct full file path with timestamp
        String filePath = outputDirPath + "/" + baseFileName + "_" + timestamp + ".txt";

        // Write data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ Data saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Failed to write to file: " + e.getMessage());
        }
    }

    public List<String> processCockpitTriggers(int max) {
        wait.until(ExpectedConditions.visibilityOf(customsEntriesTriggerHeading));
        List<String> results = new ArrayList<>();

        int limit = Math.min(cockpitTriggers.size(), max);

        for (int i = 0; i < limit; i++) {
            WebElement trigger = cockpitTriggers.get(i);
            String triggerText = trigger.getText().trim();

            try {
                // Scroll to trigger and click
                scrollToAndClick(trigger);
                log.info("🖱️ Clicked Trigger: " + triggerText);

                // Wait until section heading is updated
                wait.until(ExpectedConditions.textToBePresentInElement(
                        cockpitTriggersDynamicAreaText, triggerText.split(" ")[0]
                ));

                int totalRowCount = 0;
                boolean hasNextPage = true;

                while (hasNextPage) {
                    // Wait for rows or no-data message
                    waitShortForContentLoad();

                    int currentPageRowCount = listingRows.size();
                    totalRowCount += currentPageRowCount;

                    log.debug("📄 Page Rows: " + currentPageRowCount + " | Total so far: " + totalRowCount);

                    // Check if next button is enabled
                    if (isPaginationNextEnabled()) {
                        paginationNextBtn.click();
                        waitUntilTableRefreshes(); // optional spinner wait
                    } else {
                        hasNextPage = false;
                    }
                }

                String heading = cockpitTriggersDynamicAreaText.getText().trim();
                String result = (totalRowCount > 0)
                        ? "✅ Data found (" + totalRowCount + " rows across pages)"
                        : (isElementVisible(dynamicListingNoDataText) ? "ℹ️ No data found" : "⚠️ Unknown state");

                String summary = "Trigger: " + triggerText + " ➤ Heading: " + heading + " ➤ Result: " + result;
                log.info(summary);
                results.add(summary);

            } catch (TimeoutException e) {
                log.warn("⏳ Timeout waiting for trigger: " + triggerText);
            } catch (Exception e) {
                log.error("❌ Error processing trigger: " + triggerText + " | " + e.getMessage());
            }
        }

        // ✅ Save to timestamped file
        saveListToFileWithTimestamp(results, "cockpit_triggers_listingResults");

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


    private void waitShortForContentLoad() {
        try {
            wait.withTimeout(Duration.ofSeconds(2));
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfAllElements(listingRows),
                    ExpectedConditions.visibilityOf(dynamicListingNoDataText)
            ));
        } catch (TimeoutException ignored) {
            // Do nothing, no data visible yet
        } finally {
            wait.withTimeout(Duration.ofSeconds(10)); // reset to default
        }
    }

    private boolean isPaginationNextEnabled() {
        try {
            return paginationNextBtn.isDisplayed() && paginationNextBtn.isEnabled() &&
                    !paginationNextBtn.getAttribute("class").contains("disabled");
        } catch (Exception e) {
            return false;
        }
    }

    // Optional: if a spinner or loader appears while paginating
    private void waitUntilTableRefreshes() {
        try {
            WebElement spinner = driver.findElement(By.cssSelector(".loading-spinner")); // adjust if needed
            wait.until(ExpectedConditions.invisibilityOf(spinner));
        } catch (Exception ignored) {
            // No spinner, no problem
        }
    }

}
