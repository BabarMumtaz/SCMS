package com.LilyCargo.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class ShipperListingPage {


    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Faker faker;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ShipperListingPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        faker = new Faker(new Locale.Builder().setLanguage("nl").build());
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//div[contains(text(),'Shipper successfully created.')]")
    WebElement addShipperSuccessAlertMessage;

    @FindBy(xpath = "//div[contains(text(),'Shipper successfully updated.')]")
    WebElement updateShipperSuccessAlertMessage;

    @FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
    WebElement alertPopupDP;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------


    public String getShipperSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(addShipperSuccessAlertMessage)).getText();
    }

    public boolean isShipperSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addShipperSuccessAlertMessage)).isDisplayed();
    }

    public boolean isUpdateShipperSuccessAlertMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(updateShipperSuccessAlertMessage)).isDisplayed();
    }

    public String getUpdatedShipperSuccessAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOf(updateShipperSuccessAlertMessage)).getText();
    }

    public void clickOnAlertPopupDP() {
        wait.until(ExpectedConditions.visibilityOf(alertPopupDP)).click();
    }

}
