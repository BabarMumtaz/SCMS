package com.LilyCargo.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RelationsExtraFieldElementUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public RelationsExtraFieldElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAllDynamicCrossIcons(String xpath, int startIndex, int count) {
        for (int i = 0; i < count; i++) {
            List<WebElement> icons = driver.findElements(By.xpath(xpath));

            if (icons.size() > startIndex) {
                wait.until(ExpectedConditions.elementToBeClickable(icons.get(startIndex)))
                        .click();

                try { Thread.sleep(500); } catch (InterruptedException e) {}
            } else {
                break;
            }
        }
    }
}