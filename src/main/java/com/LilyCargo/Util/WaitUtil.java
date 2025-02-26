package com.LilyCargo.Util;

import java.time.Duration;
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

    public void click(WebElement element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
    }

    public void waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
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
}