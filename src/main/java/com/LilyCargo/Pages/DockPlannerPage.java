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

public class DockPlannerPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(DockPlannerPage.class);

    // Constructor
    public DockPlannerPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    //----------------------------------------------------------------------------------------------

    @FindBy(xpath = "//button[text()='Dock Planner']")
    WebElement dockPlannerShortcut;

    @FindBy(css = ".title.fw-bold.fs-2")
    WebElement dockPlannerPopupHeading;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[1]")
    WebElement dockPlannerJobDropdown;

    @FindBy(xpath = "//li[text()='Loading']")
    WebElement jobDropdownOptions;

    @FindBy(xpath = "(//div[@id='select-[object Object]'])[2]")
    WebElement dockNoDropdown;

    @FindBy(xpath = "//li[text()='2']")
    WebElement dockNoDropdownOptions;

    @FindBy(xpath = "//input[@name='storage']")
    WebElement dockPlannerStorageField;

    @FindBy(xpath = "//input[@name='truck_no']")
    WebElement dockPlannerTruckNoField;

    @FindBy(xpath = "//input[@name='trailer_no']")
    WebElement dockPlannerTrailerNoField;

    @FindBy(xpath = "//input[@name='remarks']")
    WebElement dockPlannerRemarksField;

    @FindBy(xpath = "//button[text()='Create']")
    WebElement dockPlannerCreateButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement dockPlannerCancelButton;

    @FindBy(xpath = "//button[text()='EXCEL']")
    WebElement dockPlannerExportButton;

    //img[@alt='Edit']

    @FindBy(xpath = "//div[contains(text(),'Dock Planner created.')]")
    WebElement dockPlannerSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    //----------------------------------------------------------------------------------------------

    public void scrollToElement() {
        executor.executeScript("arguments[0].scrollIntoView(true);", dockPlannerShortcut);
    }

    public void clickDockPlannerShortcut() {
        wait.until(ExpectedConditions.visibilityOf(dockPlannerShortcut)).click();
    }

    public boolean isDockPlannerPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dockPlannerPopupHeading)).isDisplayed();
    }

    public String getDockPlannerPopupHeading() {
        return dockPlannerPopupHeading.getText();
    }

    public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
        wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        wait.until(ExpectedConditions.visibilityOf(dropdownValue)).click();
    }

    public void selectDockPlannerJob() {
        selectDropdownValue(dockPlannerJobDropdown, jobDropdownOptions);
    }

    public void enterStorage(String text) {
        dockPlannerStorageField.sendKeys(text);
    }

    public void selectDockPlannerDockNo() {
        selectDropdownValue(dockNoDropdown, dockNoDropdownOptions);
    }

    public void enterTruckNo(String text) {
        dockPlannerTruckNoField.sendKeys(text);
    }

    public void enterTrailerNo(String text) {
        dockPlannerTrailerNoField.sendKeys(text);
    }

    public void enterRemarks(String text) {
        dockPlannerRemarksField.sendKeys(text);
    }

    public void clickDockPlannerCreateButton() {
        wait.until(ExpectedConditions.visibilityOf(dockPlannerCreateButton)).click();
    }

    public void clickDockPlannerCancelButton() {
        wait.until(ExpectedConditions.visibilityOf(dockPlannerCancelButton)).click();
    }

    public void clickDockPlannerExportButton() {
        wait.until(ExpectedConditions.visibilityOf(dockPlannerExportButton)).click();
    }

    public boolean isDockPlannerSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(dockPlannerSuccessAlertMessage)).isDisplayed();
    }

    public String getDockPlannerSuccessAlertMessage() {
        return dockPlannerSuccessAlertMessage.getText();
    }

    public void clickOnAlertPopupCrossIcon() {
        wait.until(ExpectedConditions.visibilityOf(successAlertCrossIcon)).click();
    }


}
