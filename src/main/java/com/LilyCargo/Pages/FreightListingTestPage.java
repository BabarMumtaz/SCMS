package com.LilyCargo.Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//button[@aria-label='Go to last page']")
	WebElement paginationLastPageIcon;

	@FindBy(xpath = "//table[@id=\"grid\"]/tbody/tr")
	List<WebElement> freightListRecords;

	@FindBy(xpath = "//table[@id=\"grid\"]/tbody/tr[1]/td[8]")
	WebElement clientCellLV;

	@FindBy(xpath = "//*[@id=\"grid\"]/tbody/tr[1]/td[1]")
	WebElement freightIDCellLV;

	@FindBy(xpath = "//table//tbody/tr[1]/td[1]//div[@title='Open Freight']")
	WebElement freightList1stRecord;

	@FindBy(xpath = "//table//tbody/tr[2]/td[1]//div[@title='Open Freight']")
	WebElement freightList2ndRecord;

	@FindBy(xpath = "//img[@alt='View']")
	WebElement viewFreightIcon;

	@FindBy(xpath = "//img[@alt='Edit']")
	WebElement editFreightIcon;

	@FindBy(xpath = "//div[@class='_loading_overlay_overlay css-1mig4ck _loading-overlay-transition-enter-done']")
	WebElement freightListingLoader;


//------------------------------------------------------------------------------------------------------------------------------------

	// Click on pagination last page icon
	public void clickOnPaginationLastPageIcon() {
		waitUtil.waitForElementToBeVisible(freightListingLoader);
		waitUtil.waitForElementToBeVisible(paginationLastPageIcon);
		waitUtil.waitForElementToBeClickable(paginationLastPageIcon);
	}

	// Scroll to the bottom of the page
	public void scrollToBottom() {
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void hoverOn1stRowClient() {
		waitUtil.waitForElementToBeVisible(freightIDCellLV);
		//actions.moveToElement(freightIDCellLV).perform();
	}

	// Hover over the last record
	public void hoverOverLastRecord() {
		waitUtil.waitForElementToBeVisible(freightListingLoader);
		scrollToBottom();
		WebElement lastRecord = getLastRecordElement();
		actions.moveToElement(lastRecord).perform();
	}

	// Get the last record element
	public WebElement getLastRecordElement() {
		WebElement lastRecord = freightListRecords.get(freightListRecords.size() - 1);
		waitUtil.waitForElementToBeVisible(lastRecord);
        return lastRecord;
    }

	// Click on Freight ID
	public void clickOnFreightID() {
		waitUtil.waitForElementToBeVisible(freightList1stRecord).click();
	}

	public void clickOn2ndFreightID() {
		waitUtil.waitForElementToBeVisible(freightList2ndRecord).click();
	}

/*	public void clickFIDByRowIndex(int rowIndex) {
		By fidLocator = By.xpath("(//td[@role='cell'][1]/a)[" + rowIndex + "]");
		WebElement rowIndexBased = waitUtil.waitForElementToBeClickable(fidLocator);

		System.out.println("Clicking FID at row index: " + rowIndex);
		rowIndexBased.click();
	}*/


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
}