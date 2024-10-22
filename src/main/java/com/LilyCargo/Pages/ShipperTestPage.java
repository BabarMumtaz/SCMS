package com.LilyCargo.Pages;

import com.github.javafaker.Faker;
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
import java.util.Locale;

public class ShipperTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait;
    Faker faker;

    // Constructor that will be automatically called as soon as the object of the
    // class is created
    public ShipperTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        faker = new Faker(new Locale.Builder().setLanguage("nl").build());
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Carriers']")
    WebElement shipperPageHeading;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Add Shipper']")
    WebElement addShipperBtn;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Method to capture the page heading
    public String getPageHeading() {
        return shipperPageHeading.getText();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(shipperPageHeading)).isDisplayed();
    }

    public void clickAddCarrierBtn() {
        addShipperBtn.click();
    }


}
