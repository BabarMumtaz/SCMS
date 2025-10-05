package com.LilyCargo.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LilyCargo.Util.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FreightDetailTestPage {

	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;
	private WaitUtil waitUtil; // Use WaitUtil instead of WebDriverWait
	Logger log = LogManager.getLogger(FreightDetailTestPage.class);

	/** ---------- Constructor that will be automatically called as soon as the object of the class is created ---------- */

	public FreightDetailTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.waitUtil = new WaitUtil(driver); // Initialize WaitUtil
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

	/** ---------- Locators ---------- */

	@FindBy(xpath = "//div[@class='ft-edit-wrapper'][1]" )
	WebElement editFreightIconDP;

	@FindBy(css = "button[class='fid-add-btn btn btn-primary']")
	WebElement subFidAddIcon;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement submitSubFidButton;

	@FindBy(css = ".status-select.fid-status-select.form-select")
	WebElement subFidDrop;

	@FindBy(xpath = "//button[text()='Remarks']")
	WebElement remarksTab;

	@FindBy(xpath = "//button[text()='Incidents Registration']")
	WebElement incidentsRegistrationTab;

	@FindBy(xpath = "//button[text()='Fyco Data']")
	WebElement fycoDataTab;

	@FindBy(xpath = "//button[text()='Billing Center']")
	WebElement billingCenterTab;

	@FindBy(xpath = "//button[text()='Cargo Data']")
	WebElement cargoDataTab;

	@FindBy(xpath = "//button[text()='Fulfillment']")
	WebElement fulfillmentTab;

	@FindBy(xpath = "//div[@class='MuiTabs-scroller MuiTabs-fixed css-1anid1y']")
	WebElement freightTabHorizontalScroll;

	/** ---------- Methods ---------- */

	public boolean isEditFreightIconDisplayed() {
		return waitUtil.waitForElementToBeVisible(editFreightIconDP).isDisplayed();
	}

	public void clickOnEditFreightIconDP() {
		waitUtil.waitForElementToBeClickable(editFreightIconDP).click();
	}

	public void clickSubFidAddIcon() {
		waitUtil.waitForElementToBeClickable(subFidAddIcon).click();
	}

	public void clickYesButton() {
		waitUtil.waitForElementToBeClickable(submitSubFidButton).click();
	}

	public void selectLastSubFID() {
		waitUtil.waitForElementToBeVisible(subFidDrop);
		Select subFidSelect = new Select(subFidDrop);  // Wrap the WebElement
		List<WebElement> options = subFidSelect.getOptions();

		if (options.size() > 1) {
			WebElement lastOption = options.get(options.size() - 1);
			String text = lastOption.getText().trim();

			if (!text.equalsIgnoreCase("A") && !text.equalsIgnoreCase("None")) {
				subFidSelect.selectByVisibleText(text);
				log.info("🔁 Selected last valid SubFID: " + text);
			} else {
				log.warn("⚠️ Last SubFID option is invalid (A or None): " + text);
			}
		} else {
			log.warn("⚠️ No SubFID options available.");
		}
	}

	public String getRemarksTabText() {
		return waitUtil.waitForElementToBeVisible(remarksTab).getText();
	}

	public void clickRemarksTab() {
		waitUtil.waitForElementToBeClickable(remarksTab).click();
	}

	public String getIncidentsRegistrationTabText() {
		return waitUtil.waitForElementToBeVisible(incidentsRegistrationTab).getText();
	}

	public void clickIncidentsRegistrationTab() {
		waitUtil.waitForElementToBeClickable(incidentsRegistrationTab).click();
	}

	public String getFycoDataTabText() {
		return waitUtil.waitForElementToBeVisible(fycoDataTab).getText();
	}

	public void clickFycoDataTab() {
		waitUtil.waitForElementToBeClickable(fycoDataTab).click();
	}

	public boolean isBillingCenterTabDisplayed() {
		return waitUtil.waitForElementToBeVisible(billingCenterTab).isDisplayed();
	}

	public String getBillingCenterTabDisplayedText() {
		return waitUtil.waitForElementToBeVisible(billingCenterTab).getText();
	}

	public void clickBillingCenterTab() {
		waitUtil.waitForElementToBeClickable(billingCenterTab).click();
	}

	public void clickCargoDataTab() {
		waitUtil.waitForElementToBeClickable(cargoDataTab).click();
	}

	public void clickFulfillmentTab() {
		waitUtil.waitForElementToBeClickable(fulfillmentTab).click();
	}

	public String getCargoDataTabText() {
		return waitUtil.waitForElementToBeVisible(cargoDataTab).getText();
	}

	public String getFulfillmentTabText() {
		return waitUtil.waitForElementToBeVisible(fulfillmentTab).getText();
	}

	public void scrollToRight() {
		// Ensure the freightTabHorizontalScroll element is visible before attempting to scroll
		waitUtil.waitForElementToBeVisible(freightTabHorizontalScroll);

		// Scroll the cargoDataTab into view
		executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", fulfillmentTab);

		waitUtil.waitForElementToBeVisible(cargoDataTab);
	}
}