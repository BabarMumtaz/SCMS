package com.LilyCargo.Pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//img[@alt='Add']")
    WebElement remarksAddIcon;

    @FindBy(xpath = "//button[text()='Import Remarks']")
    WebElement importRemarksTab;

    @FindBy(xpath = "//button[text()='Customs Remarks']")
    WebElement customsRemarksTab;

    @FindBy(xpath = "//button[text()='Sales Remarks']")
    WebElement salesRemarksTab;

    @FindBy(xpath = "//div[text()='import']")
    WebElement importRemarksPopupHeading;

    @FindBy(className = "btn-close")
    WebElement remarksPopupCloseIcon;

    @FindBy(xpath = "//textarea[@name='remarks']")
    WebElement RemarksPopupTextField;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitRemarksButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelRemarksButton;

    @FindBy(xpath = "//div[text()='customs']")
    WebElement customsRemarksPopupHeading;

    @FindBy(xpath = "//input[@name='cRemarksDate']")
    WebElement customsRemarksDateField;

    @FindBy(id = "select-Set Time")
    WebElement customsRemarksTimeField;

    @FindBy(xpath = "//li[text()='two days']")
    WebElement customsRemarksTimeOptions;

    @FindBy(xpath = "//button[text()='Submit & Email']")
    WebElement submitEmailRemarksButton;

    @FindBy(xpath = "//div[text()='sales']")
    WebElement salesRemarksPopupHeading;

    @FindBy(xpath = "//div[contains(text(),'Import Remark added successfully')]")
    WebElement importRemarksSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Custom Remark added successfully')]")
    WebElement customsRemarksSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Sales Remark added successfully')]")
    WebElement salesRemarksSuccessAlertMessage;

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

    public boolean isImportRemarksPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(importRemarksPopupHeading)).isDisplayed();
    }

    public String getImportRemarksPopupHeading() {
        return importRemarksPopupHeading.getText();
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

    private void selectDateUsingKeys(WebElement element, String day, String month, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(year).perform();
    }

    public void selectCustomsRemarksDateDate(String day, String month, String year) {
        selectDateUsingKeys(customsRemarksDateField, day, month, year);
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

    public String getCustomsRemarksPopupHeading() {
        return customsRemarksPopupHeading.getText();
    }

    public boolean isSalesRemarksPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(salesRemarksPopupHeading)).isDisplayed();
    }

    public String getSalesRemarksPopupHeading() {
        return salesRemarksPopupHeading.getText();
    }


    public boolean isImportRemarkSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(importRemarksSuccessAlertMessage)).isDisplayed();
    }

    public String getImportRemarkSuccessAlertMessage() {
        return importRemarksSuccessAlertMessage.getText();
    }

    public boolean isCustomRemarkSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(customsRemarksSuccessAlertMessage)).isDisplayed();
    }

    public String getCustomRemarkSuccessAlertMessage() {
        return customsRemarksSuccessAlertMessage.getText();
    }

    public boolean isSaleRemarkSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(salesRemarksSuccessAlertMessage)).isDisplayed();
    }

    public String getSaleRemarkSuccessAlertMessage() {
        return salesRemarksSuccessAlertMessage.getText();
    }

    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }
}
