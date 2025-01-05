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

public class FycoDataTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Logger log = LogManager.getLogger(FycoDataTestPage.class);

    // Constructor
    public FycoDataTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @CacheLookup
    @FindBy(id = "moal")
    WebElement fycoDataAddIcon;

    @CacheLookup
    @FindBy(xpath = "//div[text()='New']")
    WebElement fycoDataPopupHeading;

    @CacheLookup
    @FindBy(className = "btn-close")
    WebElement fycoDataPopupCloseIcon;

    @CacheLookup
    @FindBy(xpath = "//input[@name='platoNumber']")
    WebElement platoNumberField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='articleNumber']")
    WebElement articleNumberField;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitfycoDataButton;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelfycoDataButton;

    @CacheLookup
    @FindBy(id = "79vn6timw")
    WebElement successAlertMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement successAlertCrossIcon;

    //	 ------------------------------------------------------------------------------------------------------------------------------------------------


    public void clickOnfycoDataAddIcon() {
        wait.until(ExpectedConditions.visibilityOf(fycoDataAddIcon)).click();
    }

    public String getPopupHeading() {
        return fycoDataPopupHeading.getText();
    }

    public boolean isfycoDataPopupHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(fycoDataPopupHeading)).isDisplayed();
    }

    public void enterfycoDataPopupProblemField(String text) {
        fycoDataPopupProblemField.sendKeys(text);
    }

    public void enterfycoDataPopupSolutionField(String text) {
        fycoDataPopupSolutionField.sendKeys(text);
    }

    public void scrollToBottom() {
        wait.until(ExpectedConditions.visibilityOf(submitfycoDataButton)); // Ensure visibility
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitfycoDataButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitfycoDataButton));
    }

    public void clickSubmitfycoDataButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitfycoDataButton)).click();
    }

    public void clickCancelfycoDataButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelfycoDataButton)).click();
    }

    public void clickOnfycoDataPopupCloseIcon() {
        wait.until(ExpectedConditions.visibilityOf(fycoDataPopupCloseIcon)).click();
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
