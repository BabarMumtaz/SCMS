package com.LilyCargo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static com.LilyCargo.Base.TestBaseClass.log;

public class DashboardOverviewTestPage {

    private String parentWindowHandle;
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public DashboardOverviewTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h4[contains(text(),'Customs Entries - YR')]")
    WebElement customsEntriesHeading;

    @FindBy(xpath = "//h4[contains(text(),'Customs Entries - YR')]/following-sibling::div")
    List<WebElement> customsEntriesCards;

    @FindBy(css = "div.stats-columns")
    List<WebElement> statsCards;

    @FindBy(xpath = "//div[@class='colmn-data']")
    List<WebElement> statsFullCards;

    @FindBy(xpath = "(//div[@class='sm-yellow-txt'][//div='Last 12 Months'])[1]")
    WebElement last12MonthsHeading;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public String getPageHeading() {
        return customsEntriesHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(customsEntriesHeading)).isDisplayed();
    }

    public String getCustomsEntriesSummary() {
        StringBuilder summary = new StringBuilder("📊 Customs Entries Cards Headings\n");
        for (WebElement entry : customsEntriesCards) {
            summary.append("• ").append(entry.getText().trim()).append("\n");
        }
        return summary.toString();
    }

    public void extractAllStatsCardsData() {
        wait.until(ExpectedConditions.visibilityOfAllElements(last12MonthsHeading));
        log.info("📊 Total cards found: " + statsCards.size());

        for (int i = 0; i < statsCards.size(); i++) {
            String cardText = statsCards.get(i).getText().trim();
            String cardLog = "📥 Card #" + (i + 1) + " Data:\n" + cardText + "\n\n";

            log.info(cardLog);
        }
    }

    public void extractAndSaveAllStatsCardsData() {
        wait.until(ExpectedConditions.visibilityOfAllElements(last12MonthsHeading));

        log.info("📊 Total cards found are: " + statsFullCards.size());

        // File path where data will be written
        String filePath = "dashboard_card_data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

/*            for (int i = 0; i < statsFullCards.size(); i++) {
                WebElement card = statsFullCards.get(i);
                String cardText = card.getText().trim();

                String cardLogs = "📥 Card #" + (i + 1) + " Data:\n" + cardText + "\n";

                log.info(cardLogs);
                writer.write(cardLogs);
            }*/

            for (int i = 0; i < statsFullCards.size(); i++) {
                WebElement card = statsFullCards.get(i);
                String[] lines = card.getText().split("\\r?\\n");

                StringBuilder formatted = new StringBuilder();
                formatted.append("📥 Card #").append(i + 1).append(" Data:\n");

                int lineIndex = 0;
                while (lineIndex < lines.length) {
                    String current = lines[lineIndex].trim();

                    // Case: 3-line group (Label + % + Value)
                    if (lineIndex + 2 < lines.length && lines[lineIndex + 1].contains("%")) {
                        String label = current;
                        String percent = lines[lineIndex + 1].trim();
                        String value = lines[lineIndex + 2].trim();
                        formatted.append(label).append(": ").append(percent).append(" | ").append(value).append("\n");
                        lineIndex += 3;
                    }
                    // Case: 2-line pair (Label + Value)
                    else if (lineIndex + 1 < lines.length) {
                        String label = current;
                        String value = lines[lineIndex + 1].trim();
                        formatted.append(label).append(": ").append(value).append("\n");
                        lineIndex += 2;
                    }
                    // Fallback for odd last line
                    else {
                        formatted.append(current).append("\n");
                        break;
                    }
                }

                log.info("\n" + formatted.toString().trim() + "\n");
                writer.write(formatted.toString().trim() + "\n\n");
            }

            log.info("✅ Dashboard card data successfully written to: " + filePath);

        } catch (IOException e) {
            log.error("❌ Failed to write dashboard data to file: " + e.getMessage());
        }
    }

    // Call this BEFORE opening a new window
    public void storeParentWindow() {
        parentWindowHandle = driver.getWindowHandle();
        log.info("📌 Stored parent window handle");
    }

    public void switchToNewTab() {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                log.info("🔁 Switched to new tab/window: " + handle);
                break;
            }
        }
    }

    public void switchBackToOriginalTab() {
        driver.switchTo().window(parentWindowHandle);
        log.info("🔙 Switched back to original window: " + parentWindowHandle);
    }
}
