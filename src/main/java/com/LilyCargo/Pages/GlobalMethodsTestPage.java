package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    Actions actions;
    WebDriverWait wait;

    // Constructor that will be automatically called as soon as the object of the class is created
    public GlobalMethodsTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
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