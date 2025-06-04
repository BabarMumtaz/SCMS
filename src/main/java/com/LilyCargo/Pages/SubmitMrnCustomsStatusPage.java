package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitMrnCustomsStatusPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(SubmitMrnCustomsStatusPage.class);

    // Constructor
    public SubmitMrnCustomsStatusPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    //----------------------------------------------------------------------------------------------

    @FindBy(xpath = "//div[text()='Submit / Delete MRN # / Customs Status']")
    WebElement mrnPopupHeading;

    @FindBy(className = "btn-close")
    WebElement mrnPopupCloseIcon;

    @FindBy(xpath = "//input[@name='mrn']")
    WebElement mrnNumberField;

    @FindBy(xpath = "//input[@name='remarks']")
    WebElement mrnRemarksTextField;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelRemarksButton;

    @FindBy(xpath = "//input[@name='imaDate']")
    WebElement mrnDateField;

    @FindBy(xpath = "//div[@id='select-Customs Status']")
    WebElement customsStatusDropdown;

    @FindBy(xpath = "//li[text()='Clear']")
    WebElement customsStatusDropdownOptions;

    @FindBy(xpath = "//div[text()='Warning!']")
    WebElement deleteMrnPopupHeading;

    @FindBy(xpath = "//div[text()='delete MRN for SUB-FID !']")
    WebElement deleteMrnPopupWarningText;

    @FindBy(xpath = "//div[text()='Upload MRN File']")
    WebElement uploadMrnPopupHeading;

    @FindBy(xpath = "//div[contains(text(),'Customs Status updated')]")
    WebElement noMrnAddedUpdatedCSSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'MRN submitted against SUB-FID & Customs Status updated')]")
    WebElement mrnAddedUpdatedCSSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'MRN already exists against SUB-FID & Customs Status updated')]")
    WebElement mrnExistUpdatedCSSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    @FindBy(xpath = "//button[text()='Submit MRN & Customs Status']")
    WebElement submitMrnTask;

    @FindBy(xpath = "//button[text()='Upload']")
    WebElement uploadMrnButton;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitMrnButton;

    @FindBy(xpath = "//button[text()='Update']")
    WebElement updateMrnButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelMrnButton;

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteMrnButton;

    //	 ------------------------------------------------------------------------------------------------------------------------------------------------

    public void scrollToElement() {
        executor.executeScript("arguments[0].scrollIntoView(true);", submitMrnTask);
    }

    public void clickSubmitMrnTask() {
        wait.until(ExpectedConditions.visibilityOf(submitMrnTask)).click();
    }

    public void clickUploadMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(uploadMrnButton)).click();
    }

    public void clickSubmitMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(submitMrnButton)).click();
    }

    public void clickUpdateMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(updateMrnButton)).click();
    }

    public void clickCancelMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(cancelMrnButton)).click();
    }

    public void clickDeleteMrnButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteMrnButton)).click();
    }

    public void clickOnMrnPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(mrnPopupCloseIcon)).click();
    }

    public boolean isSubmitMrnPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(mrnPopupHeading)).isDisplayed();
    }

    public String getSubmitMrnPopupHeading() {
        return mrnPopupHeading.getText();
    }

    public void enterMrnNumber(String text) {
        mrnNumberField.sendKeys(text);
    }

    public WebElement getMrnInput() {
        return mrnNumberField;
    }

    public void enterMrnRemarks(String text) {
        mrnRemarksTextField.sendKeys(text);
    }

    public void clickCancelRemarksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelRemarksButton)).click();
    }

    private void selectDate(WebElement element, String day, String month, String year) {
        actions.click(element).sendKeys(day).sendKeys(month).sendKeys(year).perform();
    }

    public void selectCustomsRemarksDateDate(String day, String month, String year) {
        selectDate(mrnDateField, day, month, year);
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        dropdown.click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();
    }

    public void selectCustomsStatusDropdown() {
        selectDropdownValue(customsStatusDropdown, customsStatusDropdownOptions);
    }

    public boolean isDeleteMrnPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(deleteMrnPopupHeading)).isDisplayed();
    }

    public String getDeleteMrnPopupWarningText() {
        return deleteMrnPopupWarningText.getText();
    }

    public boolean isUploadMrnPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(uploadMrnPopupHeading)).isDisplayed();
    }

    public String getUploadMrnPopupHeading() {
        return uploadMrnPopupHeading.getText();
    }

    public boolean isNoMrnAddedUpdatedCSSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(noMrnAddedUpdatedCSSuccessAlertMessage)).isDisplayed();
    }

    public String getNoMrnAddedUpdatedCSSuccessAlertMessage() {
        return noMrnAddedUpdatedCSSuccessAlertMessage.getText();
    }

    public boolean isMrnAddedUpdatedCSSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(mrnAddedUpdatedCSSuccessAlertMessage)).isDisplayed();
    }

    public String getMrnAddedUpdatedCSSuccessAlertMessage() {
        return mrnAddedUpdatedCSSuccessAlertMessage.getText();
    }

    public boolean isMrnExistUpdatedCSSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(mrnExistUpdatedCSSuccessAlertMessage)).isDisplayed();
    }

    public String getMrnExistUpdatedCSSuccessAlertMessage() {
        return mrnExistUpdatedCSSuccessAlertMessage.getText();
    }

    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }
}
