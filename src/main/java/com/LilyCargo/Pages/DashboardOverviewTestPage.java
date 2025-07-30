package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//h4[contains(text(),'Customs Entries - YR')]")
    WebElement customsEntriesHeading;

    @FindBy(xpath = "//h4[contains(text(),'Customs Entries - YR')]/following-sibling::div")
    List<WebElement> customsEntriesCards;

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
