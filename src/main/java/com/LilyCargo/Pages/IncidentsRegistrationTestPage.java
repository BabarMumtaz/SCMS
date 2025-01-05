package com.LilyCargo.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IncidentsRegistrationTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(IncidentsRegistrationTestPage.class);

    // Constructor
    public IncidentsRegistrationTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Add']")
    WebElement incidentsRegAddIcon;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Add Incidents Register']")
    WebElement incidentsRegPopupHeading;

    @CacheLookup
    @FindBy(className = "btn-close")
    WebElement incidentsRegPopupCloseIcon;

    @CacheLookup
    @FindBy(id = "problem")
    WebElement incidentsRegPopupProblemField;

    @CacheLookup
    @FindBy(id = "solution")
    WebElement incidentsRegPopupSolutionField;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitIncidentsRegButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelIncidentsRegButton;

    @CacheLookup
    @FindBy(id = "79vn6timw")
    WebElement successAlertMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    //	 ------------------------------------------------------------------------------------------------------------------------------------------------


    public void clickOnIncidentsRegAddIcon() {
        wait.until(ExpectedConditions.visibilityOf(incidentsRegAddIcon)).click();
    }

    public String getPopupHeading() {
        return incidentsRegPopupHeading.getText();
    }

    public boolean isIncidentsRegPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(incidentsRegPopupHeading)).isDisplayed();
    }

    public void enterIncidentsRegPopupProblemField(String text) {
        incidentsRegPopupProblemField.sendKeys(text);
    }

    public void enterIncidentsRegPopupSolutionField(String text) {
        incidentsRegPopupSolutionField.sendKeys(text);
    }

    public void scrollToBottom() {
        wait.until(ExpectedConditions.visibilityOf(submitIncidentsRegButton)); // Ensure visibility
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitIncidentsRegButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitIncidentsRegButton));
    }

    public void clickSubmitIncidentsRegButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitIncidentsRegButton)).click();
    }

    public void clickCancelIncidentsRegButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelIncidentsRegButton)).click();
    }

    public void clickOnIncidentsRegPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(incidentsRegPopupCloseIcon)).click();
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

