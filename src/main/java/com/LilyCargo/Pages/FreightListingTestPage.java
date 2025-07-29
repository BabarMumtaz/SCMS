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

import static com.LilyCargo.Base.TestBaseClass.log;

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

	@FindBy(xpath = "//table//tr/td[1]")
	List<WebElement> freightListFidCells ;

	@FindBy(xpath = "//table//tbody/tr[1]/td[1]//div[@title='Open Freight']")
	WebElement freightList1stRecord;

	@FindBy(xpath = "//div[@class='_loading_overlay_overlay css-1mig4ck _loading-overlay-transition-enter-done']")
	WebElement freightListingLoaderArea;

//------------------------------------------------------------------------------------------------------------------------------------

	// Click on pagination last page icon
	public void clickOnPaginationLastPageIcon() throws InterruptedException {
		waitUtil.waitForElementToBeInVisible(freightListingLoaderArea);
		waitUtil.waitForElementToBeVisible(paginationLastPageIcon);
		waitUtil.waitForElementToBeClickable(paginationLastPageIcon).click();
	}

	public void clickLastFIDFromLastPage() throws InterruptedException {

		if (!freightListFidCells.isEmpty()) {
			int index = freightListFidCells.size() - 1; // last index
			WebElement lastFID = freightListFidCells.get(index);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastFID);
			waitUtil.waitForElementToBeVisible(lastFID).click();
			log.info("✅ Clicked on last FID: " + lastFID.getText().trim());
		} else {
			log.warn("⚠️ No FID rows found in table.");
		}
	}

	public void clickSpecificFID() throws InterruptedException {
		int rowToClick = 70; // 0-based index for row 5
		if (freightListFidCells.size() > rowToClick) {
			WebElement fid = freightListFidCells.get(rowToClick);
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fid);
			waitUtil.waitForElementToBeVisible(fid).click();
			log.info("✅ Clicked on FID at row " + (rowToClick + 1) + ": " + fid.getText().trim());
		} else {
			log.warn("⚠️ Requested row " + (rowToClick + 1) + " does not exist. Only " + freightListFidCells.size() + " rows available.");
		}

	}

	// Click on Freight ID
	public void clickOnFreightID() {
		waitUtil.waitForElementToBeVisible(freightList1stRecord).click();
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
}