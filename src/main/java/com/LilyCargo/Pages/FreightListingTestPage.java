package com.LilyCargo.Pages;

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

import com.LilyCargo.Util.WaitUtil;

public class FreightListingTestPage {
	private WebDriver driver;
	private JavascriptExecutor executor;
	private Actions actions;
	private WaitUtil waitUtil; // Use WaitUtil instead of WebDriverWait

	// Constructor
	public FreightListingTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.actions = new Actions(driver);
		this.waitUtil = new WaitUtil(driver); // Initialize WaitUtil
		PageFactory.initElements(driver, this);
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
	@FindBy(xpath = "//div[@title='Open Freight'][1]")
	WebElement viewFreight;

	@CacheLookup
	@FindBy(xpath = "//img[@alt='View']")
	WebElement viewFreightIcon;

	@CacheLookup
	@FindBy(xpath = "//img[@alt='Edit']")
	WebElement editFreightIcon;

//------------------------------------------------------------------------------------------------------------------------------------

	// Method to click on the pagination last page icon
	public void clickOnPaginationLastPageIcon() {
		waitUtil.waitUntilElementInvisible(By.cssSelector(".loading-overlay"));
		waitUtil.waitUntilElementClickable(paginationLastPageIcon).click();
	}

	// Scroll to the bottom of the page
	public void scrollToBottom() {
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Hover over the first row client cell
	public void hoverOn1stRowClient() {
		actions.moveToElement(clientCellLV).perform();
	}

	// Hover over the last record
	public void hoverOverLastRecord() {
		waitUtil.waitUntilElementInvisible(By.cssSelector(".loading-overlay"));
		scrollToBottom();
		WebElement lastRecord = getLastRecordElement();
		actions.moveToElement(lastRecord).perform();
	}

	// Get the last record element
	public WebElement getLastRecordElement() {
		waitUtil.waitUntilVisible(freightListRecords.get(freightListRecords.size() - 1));
		return freightListRecords.get(freightListRecords.size() - 1);
	}

	// Click on Freight ID
	public void clickOnFreightID() {
		waitUtil.waitUntilElementClickable(viewFreight).click();
	}

	// Switch to a new tab
	public void switchToNewTab() {
		String originalWindow = driver.getWindowHandle();
		waitUtil.waitForNumberOfWindows(2);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(originalWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
}