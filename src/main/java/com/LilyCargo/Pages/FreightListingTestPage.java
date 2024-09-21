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

public class FreightListingTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	WebDriverWait wait; // Make sure WebDriverWait is initialized correctly

	// Constructor
	public FreightListingTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait here
		PageFactory.initElements(driver, this); // Initialize WebElements
	}

	@CacheLookup
	@FindBy(xpath = "//button[@aria-label='Go to last page']//*[name()='svg']")
	WebElement paginationLastPageIcon;

	@CacheLookup
	@FindBy(xpath = "//table[@id=\"grid\"]/tbody/tr")
	List<WebElement> freightListRecords;

	@CacheLookup
	@FindBy(xpath = "//table[@id=\"grid\"]/tbody/tr[1]/td[8]")
	WebElement clientCellLV;

	@CacheLookup
	@FindBy(xpath = "//img[@alt='View']")
	WebElement viewFreightIcon;

	@CacheLookup
	@FindBy(xpath = "//img[@alt='Edit']")
	WebElement editFreightIcon;

	// Method to click on the pagination last page icon
	public void clickOnPaginationLastPageIcon() {
		waitUntilElementInvisible(By.cssSelector(".loading-overlay"));
		waitUntilElementClickable(paginationLastPageIcon).click();
	}

	// Scroll to the bottom of the page
	public void scrollToBottom() {
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void hoverOn1stRowClient() {
		actions.moveToElement(clientCellLV).perform();
	}

	// Hover over the last record
	public void hoverOverLastRecord() {
		waitUntilElementInvisible(By.cssSelector(".loading-overlay"));
		scrollToBottom();

		WebElement lastRecord = getLastRecordElement();
		actions.moveToElement(lastRecord).perform();
	}

	// Get the last record element
	public WebElement getLastRecordElement() {
		waitUntilVisible(freightListRecords.get(freightListRecords.size() - 1));
		return freightListRecords.get(freightListRecords.size() - 1);
	}

	// Method to get the view freight icon
	public WebElement getViewEditIcon() {
		waitUntilVisible(viewFreightIcon);
		return viewFreightIcon;
	}

	// Click on view freight icon
	public void clickOnViewFreightIcon() {
		waitUntilElementClickable(viewFreightIcon).click();
	}
	
	public void ClickOnEditFreightIcon() {
		waitUntilElementClickable(editFreightIcon).click();
		
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
