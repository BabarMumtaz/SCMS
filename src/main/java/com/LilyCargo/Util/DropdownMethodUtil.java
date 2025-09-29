package com.LilyCargo.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownMethodUtil {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor executor;
    private Logger log = LogManager.getLogger(DropdownMethodUtil.class);

    public DropdownMethodUtil(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.executor = (JavascriptExecutor) driver;
    }

    public void selectDropdownByText(WebElement dropdownElement, String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click(); // open dropdown
        log.info("Opened dropdown");

        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"))));

        executor.executeScript("arguments[0].scrollIntoView(true);", dropdownOption);
        dropdownOption.click();
        log.info("Selected option: {}", optionText);
    }
}
