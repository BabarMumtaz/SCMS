package com.LilyCargo.Util;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ✅ Wait for an element to be visible
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public void waitForElementToBeClickable(WebElement element) {
         wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForTextToBePresent(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    // Wait for alert to be present
    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // Wait for a specific title
    public boolean waitForTitle(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }

    // Wait for URL to contain specific text
    public boolean waitForUrlContains(String urlFraction) {
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }

    public void waitForNumberOfWindows(int expectedNumber) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumber));
    }

}