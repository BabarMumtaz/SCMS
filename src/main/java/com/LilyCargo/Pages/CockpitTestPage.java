package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CockpitTestPage {

    WebDriver driver;
    WebDriverWait wait;
    Logger log;
    // Constructor that will be automatically called as soon as the object of the class is created
    public CockpitTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        LogManager.getLogger(CockpitTestPage.class);
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



//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public String getPageHeading() {
        return cockpitPageHeading.getText();
    }

    public boolean isPageHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cockpitPageHeading)).isDisplayed();
    }

    public String getCockpitTriggersDynamicAreaText() {
        wait.until(ExpectedConditions.visibilityOf(dynamicListingDateCell));
        return cockpitTriggersDynamicAreaText.getText();
    }


    public boolean isCockpitTriggersDynamicAreaTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cockpitTriggersDynamicAreaText)).isDisplayed();
    }

    public void extractAndSaveAllCockpitTriggersData() {
        wait.until(ExpectedConditions.visibilityOfAllElements(customsEntriesTriggerHeading));

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


    public List<String> processCockpitTriggers(int max) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < Math.min(cockpitTriggers.size(), max); i++) {
            WebElement trigger = cockpitTriggers.get(i);
            String triggerText = trigger.getText().trim();

            wait.until(ExpectedConditions.elementToBeClickable(trigger)).click();
            log.info("🖱️ Clicked Trigger: " + triggerText);

            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(dynamicListingNoDataText),
                    ExpectedConditions.visibilityOf(dynamicListingDateCell),
                    ExpectedConditions.textToBePresentInElement(cockpitTriggersDynamicAreaText, triggerText.split(" ")[0]) // rough match
            ));

            String headingText = cockpitTriggersDynamicAreaText.getText().trim();
            String result;
            if (!listingRows.isEmpty()) {
                result = "✅ Data found (" + listingRows.size() + " rows)";
            } else if (dynamicListingNoDataText.isDisplayed()) {
                result = "ℹ️ No data found";
            } else {
                result = "⚠️ Unknown state";
            }

            String summary = "Trigger: " + triggerText + " ➤ Heading: " + headingText + " ➤ Result: " + result;
            log.info(summary);
            results.add(summary);
        }

        return results;
    }

}
