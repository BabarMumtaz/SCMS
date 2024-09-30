package com.LilyCargo.Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrierListingTestPage {

    WebDriver driver;
    JavascriptExecutor executor;
    Actions actions;
    WebDriverWait wait; // Make sure WebDriverWait is initialized correctly

    // Constructor
    public CarrierListingTestPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait here
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    @CacheLookup
    @FindBy(xpath = "//table[@id='grid']/tbody/tr")
    List<WebElement> carrierListRecords;

    @CacheLookup
    @FindBy(xpath = "//table[@id='grid'][1]/tbody/tr[1]/td[3]")
    WebElement addressCellLV;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='View'][1]")
    WebElement viewCarrierIcon;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Edit'][1]")
    WebElement editCarrierIcon;

    @CacheLookup
    @FindBy(css = "button[type='button'] p")
    WebElement editCarrierIconFromDetail;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

    // Scroll to the bottom of the page
    public void scrollToBottom() {
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void hoverOnCarrier1stRow() {
        waitUntilElementInvisible(By.cssSelector(".loading-overlay"));
        actions.moveToElement(addressCellLV).perform();
    }

    // Method to get the view freight icon
    public WebElement getViewEditIcon() {
        waitUntilVisible(viewCarrierIcon);
        return viewCarrierIcon;
    }

    // Click on view freight icon
    public void clickOnViewCarrierIcon() {
        waitUntilElementClickable(viewCarrierIcon).click();
    }

    public void clickOnEditCarrierIcon() {
        waitUntilElementClickable(editCarrierIcon).click();

    }

    // Switch to a new tab
    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void clickOnEditCarrierIconFromDetail() {
        waitUntilElementClickable(editCarrierIconFromDetail).click();

    }

    public boolean isViewPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(editCarrierIconFromDetail)).isDisplayed();
    }

    // Utility method to wait until element is clickable
    private WebElement waitUntilElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Utility method to wait until element is visible
    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Utility method to wait until element is invisible
    private void waitUntilElementInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
