package com.LilyCargo.Pages;

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
import java.util.List;

import static com.LilyCargo.Base.TestBaseClass.log;

public class CockpitTestPage {

    WebDriver driver;
    WebDriverWait wait;

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
    List<WebElement> cockpitSideContent;

    @FindBy(xpath = "//td[text()='Cleared']")
    WebElement clearedTrigger;

    @FindBy(xpath = "//h3[1]")
    WebElement cockpitTriggersDynamicAreaText;

    @FindBy(xpath = "//table[@id='grid']/tbody/tr[1]/td[1]")
    WebElement dynamicListingDateCell;

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

        log.info("📊 Total Triggers found are: " + cockpitSideContent.size());

        // File path where data will be written
        String filePath = "cockpit_triggers_data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (int i = 0; i < cockpitSideContent.size(); i++) {
                WebElement triggers = cockpitSideContent.get(i);
                String triggersText = triggers.getText().trim();

                String triggersLogs = "📥 Triggers #" + (i + 1) + " Data:\n" + triggersText + "\n";

                log.info(triggersLogs);
                writer.write(triggersLogs);
            }

            log.info("✅ Dashboard card data successfully written to: " + filePath);

        } catch (IOException e) {
            log.error("❌ Failed to write dashboard data to file: " + e.getMessage());
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
}
