package com.LilyCargo.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GlobalMethodsTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public GlobalMethodsTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])")
    List<WebElement> extraFieldCrossIcon;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[11]")
    WebElement extraEmailFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[12]")
    WebElement extraAddressFieldCross;

    @FindBy(xpath = "(//*[name()='svg'][@role='img'])[13]")
    WebElement extraPhoneFieldCross;

    @FindBy(xpath = "//button[text()='Save & Back']")
    WebElement saveAndBackBtn;

    @FindBy(xpath = "//button[text()='Save & New']")
    WebElement saveAndNewBtn;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement alertPopupListingPage;

    /** ---------- Methods ---------- */

    // ===== 2. Generic Dynamic Heading Method =====
    /**
     * Get the heading text for a given page.
     * Supports both h2 and h5 tag headings.
     * @param headingText Visible heading text on the page.
     * @return The heading WebElement.
     */
    private WebElement getPageHeading(String headingText) {
        String headingXpath = String.format("//h2[text()='%s'] | //h5[text()='%s']", headingText, headingText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(headingXpath)));
    }

    /**
     * Get the heading text for verification.
     * @param headingText The expected heading text.
     * @return The actual heading text.
     */
    public String getPageHeadingText(String headingText) {
        return getPageHeading(headingText).getText();
    }

    // ===== 2. Generic Success Alert Method ===== Finds a success alert message containing the given text.
    public WebElement getSuccessAlertElement(String alertText) {
        String alertXpath = String.format("//div[contains(text(),'%s')]", alertText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alertXpath)));
    }

    //Gets the text of a success alert.
    public String getSuccessAlertText(String alertText) {
        return getSuccessAlertElement(alertText).getText();
    }

     // Checks if a success alert is displayed.
    public boolean isSuccessAlertDisplayed(String alertText) {
        try {
            return getSuccessAlertElement(alertText).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void clickExtraEmailFieldCross() {
        extraEmailFieldCross.click();
    }

    public void clickExtraAddressFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraAddressFieldCross)).click();
    }

    public void clickExtraPhoneFieldCross() {
        wait.until(ExpectedConditions.visibilityOf(extraPhoneFieldCross)).click();
    }

    public void clickSaveAndBackBtn() {
        saveAndBackBtn.click();
    }

    public void clickSaveAndNewBtn() {
        saveAndNewBtn.click();
    }

    public void clickOnAlertPopupLP() {
        wait.until(ExpectedConditions.visibilityOf(alertPopupListingPage)).click();
    }

    public void clickAllDynamicCrossIcons() {
        for (int i = 0; i < 3; i++) {
            if (extraFieldCrossIcon.size() > 10) {
                extraFieldCrossIcon.get(10).click();

                // Wait for DOM update
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            } else {
                break; // Safety break if index 10 doesn't exist
            }
        }
    }
}