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

public class FulfillmentTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public FulfillmentTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//button[text()='Manage Storage Location']")
    WebElement manageStorageLocationBtn;

    @FindBy(xpath = "//button[text()='Add new Delivery']")
    WebElement addNewDeliveryBtn;

    @FindBy(xpath = "//button[text()='Deliver All']")
    WebElement deliverAllBtn;

    @FindBy(xpath = "//input[@name='storage_location']")
    WebElement storageLocationField;

    @FindBy(xpath = "//input[@name='logistic_operator_id']")
    WebElement logisticOperatorIdDropdown;

    @FindBy(xpath = "//input[@name='ctns']")
    WebElement ctnsField;

    /** ---------- Methods ---------- */

    public void clickManageStorageLocationBtn() {
        wait.until(ExpectedConditions.visibilityOf(manageStorageLocationBtn)).click();
    }

    public void clickAddNewDeliveryBtn() {
        wait.until(ExpectedConditions.visibilityOf(addNewDeliveryBtn)).click();
    }

    public void enterStorageLocationField(String text) {
        actions.click(storageLocationField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .perform();
        storageLocationField.sendKeys(text);
    }

    public void enterCtnsField(String text) {
        ctnsField.sendKeys(text);
    }

}

