package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FinanceAllFieldsTestPage {
    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */
    public FinanceAllFieldsTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//input[@name='pid']")
    WebElement pidfield;

    @FindBy(xpath = "//input[@name='lmgbr']")
    WebElement lmgbrField;

    @FindBy(xpath = "//input[@name='lmgbr_out']")
    WebElement lmgbrOutField;

    @FindBy(xpath = "//input[@name='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//input[@name='sort']")
    WebElement sortField;

    @FindBy(xpath = "//input[@name='price']")
    WebElement priceField;

    /** ---------- Methods ---------- */

    public void enterPid(String text) {
        pidfield.sendKeys(text);
    }

    public void enterLmgbrIn(String text) {
        lmgbrField.sendKeys(text);
    }

    public void enterLmgbrOut(String text) {
        lmgbrOutField.sendKeys(text);
    }

    public void enterDescription(String text) {
        descriptionField.sendKeys(text);
    }

    public void updateDescription(String text) {
        actions.click(descriptionField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        descriptionField.sendKeys(text);
    }

    public void enterSort(String text) {
        sortField.sendKeys(text);
    }

    public void enterPrice(String text) {
        priceField.sendKeys(text);
    }

 }