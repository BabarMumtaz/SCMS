package com.LilyCargo.Util;

import java.time.Duration;
import org.openqa.selenium.By;
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

    public WebElement isVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    // Wait for an element to be clickable
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click using wait (ensures element is clickable)
    public void click(WebElement element) {
        waitForElementToBeClickable(element).click();
    }


    // ✅ Wait for an element to be visible
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTextToBePresent(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForUrlToContain(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForNumberOfWindows(int expectedNumber) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumber));
    }

}