package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    /** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

    public IncidentsRegistrationTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    /** ---------- Locators ---------- */

    @FindBy(xpath = "//img[@alt='Add']")
    WebElement incidentsRegAddIcon;

    @FindBy(id = "problem")
    WebElement incidentsRegPopupProblemField;

    @FindBy(id = "solution")
    WebElement incidentsRegPopupSolutionField;

    /** ---------- Methods ---------- */

    public void clickOnIncidentsRegAddIcon() {
        wait.until(ExpectedConditions.visibilityOf(incidentsRegAddIcon)).click();
    }

    public void enterIncidentsRegPopupProblemField(String text) {
        incidentsRegPopupProblemField.sendKeys(text);
    }

    public void enterIncidentsRegPopupSolutionField(String text) {
        incidentsRegPopupSolutionField.sendKeys(text);
    }

}

