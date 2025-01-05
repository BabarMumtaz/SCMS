package com.LilyCargo.Pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RemarksTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(RemarksTestPage.class);

    // Constructor
    public RemarksTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Add']")
    WebElement remarksAddIcon;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Import Remarks']")
    WebElement importRemarksTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Customs Remarks']")
    WebElement customsRemarksTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Sales Remarks']")
    WebElement salesRemarksTab;

    @CacheLookup
    @FindBy(xpath = "//div[text()='import']")
    WebElement importRemarksPopupHeading;

    @CacheLookup
    @FindBy(className = "btn-close")
    WebElement remarksPopupCloseIcon;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='remarks']")
    WebElement RemarksPopupTextField;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitRemarksButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelRemarksButton;

    @CacheLookup
    @FindBy(xpath = "//div[text()='customs']")
    WebElement customsRemarksPopupHeading;

    @CacheLookup
    @FindBy(xpath = "//input[@name='cRemarksDate']")
    WebElement customsRemarksDateField;

    @CacheLookup
    @FindBy(id = "select-Set Time")
    WebElement customsRemarksTimeField;

    @CacheLookup
    @FindBy(xpath = "//li[text()='two days']")
    WebElement customsRemarksTimeOptions;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit & Email']")
    WebElement submitEmailRemarksButton;

    @CacheLookup
    @FindBy(xpath = "//div[text()='sales']")
    WebElement salesRemarksPopupHeading;

    @CacheLookup
    @FindBy(id = "jfkgabhog")
    WebElement successAlertMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    //	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean isImportRemarksTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(importRemarksTab)).isDisplayed();
    }

    public void clickOnRemarksPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(remarksPopupCloseIcon)).click();
    }

    public void clickOnCustomsRemarksTab() {
        wait.until(ExpectedConditions.visibilityOf(customsRemarksTab)).click();
    }

    public void scrollToBottom() {
        wait.until(ExpectedConditions.visibilityOf(submitRemarksButton)); // Ensure visibility
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitRemarksButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitRemarksButton));
    }

    public void clickSalesRemarksTab() {
        wait.until(ExpectedConditions.elementToBeClickable(salesRemarksTab)).click();
    }

    public String getPopupHeading() {
        return importRemarksPopupHeading.getText();
    }

    public boolean isImportRemarksPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(importRemarksPopupHeading)).isDisplayed();
    }

    public void clickOnRemarksAddIcon() {
        wait.until(ExpectedConditions.visibilityOf(remarksAddIcon)).click();
    }

    public void enterRemarksText(String text) {
        RemarksPopupTextField.sendKeys(text);
    }

    public void clickSubmitRemarksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitRemarksButton)).click();
    }

    public void clickCancelRemarksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelRemarksButton)).click();
    }

    private void selectDate(WebElement element, String month,String day, String year) {
        actions.click(element).sendKeys(month).sendKeys(day).sendKeys(year).perform();
    }

    public void selectCustomsRemarksDateDate(String month,String day, String year) {
        selectDate(customsRemarksDateField, month, day, year);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCustomsRemarksTime() {
        selectDropdownValue(customsRemarksTimeField, customsRemarksTimeOptions);
    }

    public void clickSubmitEmailRemarksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitEmailRemarksButton)).click();
    }

    public boolean isCustomsRemarksPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(customsRemarksPopupHeading)).isDisplayed();
    }

    public boolean isSalesRemarksPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(salesRemarksPopupHeading)).isDisplayed();
    }

    public String getSuccessAlertMessage() {
        return successAlertMessage.getText();
    }

    public boolean isSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successAlertMessage)).isDisplayed();
    }

    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }
}
