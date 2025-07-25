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


	// Constructor
	public FreightDetailTestPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		this.waitUtil = new WaitUtil(driver); // Initialize WaitUtil
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

	@FindBy(xpath = "//div[@class='ft-edit-wrapper'][1]" )
	WebElement editFreightIconDP;

	//-------------------------------------CREATE SUBFID ----------------------------------------------------------

	@FindBy(css = "button[class='fid-add-btn btn btn-primary']")
	WebElement subFidAddIcon;

	@FindBy(xpath = "//div[text()='Create Sub Freight']")
	WebElement createSubFidPopupHeading;

	@FindBy(xpath = "//input[contains(@id,'selectable-')]")
	WebElement subFidShipperDrop;

	@FindBy(xpath = "//li[text()='Speed Arrow Logistic Service Limited']")
	WebElement subFidShipperDropValue;

	@FindBy(xpath = "//div[contains(@id,'select-NoTC ')]")
	WebElement subFidNoTcDrop;

	@FindBy(xpath = "//li[text()='TC1']")
	WebElement subFidNoTcDropValue;

	@FindBy(xpath = "//input[@name='hbl_no']")
	WebElement subFidHblNo;

	@FindBy(xpath = "//input[@name='client_ref']")
	WebElement subFidClientRef;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement submitSubFidButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelSubFidButton;

	@FindBy(className = "btn-close")
	WebElement SubFidPopupCloseIcon;

	@FindBy(css = ".status-select.fid-status-select.form-select")
	WebElement subFidDrop;

	@FindBy(xpath = "//li[text()='Speed Arrow Logistic Service Limited']")
	WebElement subFidDropValue;

	@FindBy(xpath = "//div[contains(text(),'Sub FID successfully added')]")
	WebElement subFidAddSuccessAlertMessage;

	//-----------------------------------------------------------------------------------------------

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

	@FindBy(xpath = "//div[@class='MuiTabs-scroller MuiTabs-fixed css-1anid1y']")
	WebElement freightTabHorizontalScroll;

	@FindBy(xpath = "//div[contains(text(),'Freight successfully created.')]")
	WebElement addFreightSuccessAlertMessage;

	@FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
	WebElement successAlertCrossIcon;

	@FindBy(xpath = "//div[contains(text(),'Freight successfully updated.')]")
	WebElement updateFreightSuccessAlertMessage;

	//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	public String getBFSuccessAlertMessage() {
		return waitUtil.waitForElementToBeVisible(addFreightSuccessAlertMessage).getText();
	}

	public boolean isBFSuccessAlertMessageDisplayed() {
		return waitUtil.waitForElementToBeVisible(addFreightSuccessAlertMessage).isDisplayed();
	}

	public void clickOnBFAlertPopupCrossIcon() {
		waitUtil.waitForElementToBeClickable(successAlertCrossIcon);
	}

	public boolean isEditFreightIconDisplayed() {
		return waitUtil.waitForElementToBeVisible(editFreightIconDP).isDisplayed();
	}

	public void clickOnEditFreightIconDP() {
		waitUtil.waitForElementToBeClickable(editFreightIconDP).click();
	}

	public boolean isUpdateBFSuccessAlertMessageDisplayed() {
		return waitUtil.waitForElementToBeVisible(updateFreightSuccessAlertMessage).isDisplayed();
	}

	public String getUpdatedBFSuccessAlertMessage() {
		return waitUtil.waitForElementToBeVisible(updateFreightSuccessAlertMessage).getText();
	}

	public void selectDropdownValue(WebElement dropdown, WebElement dropdownValue) {
		waitUtil.waitForElementToBeClickable(dropdown).click();
		executor.executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
		waitUtil.waitForElementToBeClickable(dropdownValue).click();
	}

	//--------------------------------------------------------------- SUBFID ------------------------

	public WebElement getSubFidDrop() {
		return subFidDrop;
	}
	public void clickSubFidAddIcon() {
		waitUtil.waitForElementToBeClickable(subFidAddIcon).click();
	}

	public String getCreateSubFidPopupHeading() {
		return waitUtil.waitForElementToBeVisible(createSubFidPopupHeading).getText();
	}

	public boolean isCreateSubFidPopupHeadingDisplayed() {
		return waitUtil.waitForElementToBeVisible(createSubFidPopupHeading).isDisplayed();
	}

	public void selectSubFidShipper() {
		selectDropdownValue(subFidShipperDrop, subFidShipperDropValue);
	}

	public void selectSubFidNoTc() {
		selectDropdownValue(subFidNoTcDrop, subFidNoTcDropValue);
	}

	public void enterSubFidHblNo(String text) {
		subFidHblNo.sendKeys(text);
	}

	public void enterSubFidClientRef(String text) {
		subFidClientRef.sendKeys(text);
	}

	public void clickSubmitSubFidButton() {
		waitUtil.waitForElementToBeClickable(submitSubFidButton).click();
	}

	public boolean isSubFidAddSuccessAlertMessageDisplayed() {
		return waitUtil.waitForElementToBeVisible(subFidAddSuccessAlertMessage).isDisplayed();
	}

	public String getSubFidAddSuccessAlertMessage() {
		return subFidAddSuccessAlertMessage.getText();
	}

	public void clickOnAlertPopupCrossIcon() {
		waitUtil.waitForElementToBeClickable(successAlertCrossIcon).click();
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

	//---------------------------------------------------------------

/*	public void scrollToBottom() {
		waitUtil.waitForElementToBeVisible(submitMRNTask); // Ensure visibility
		executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitMRNTask);
	}*/

	public boolean isRemarksTabDisplayed() {
		return waitUtil.waitForElementToBeVisible(remarksTab).isDisplayed();
	}

	public String getRemarksTabText() {
		return waitUtil.waitForElementToBeVisible(remarksTab).getText();
	}

	public void clickRemarksTab() {
		waitUtil.waitForElementToBeClickable(remarksTab).click();
	}

	public boolean isIncidentsRegistrationTabDisplayed() {
		return waitUtil.waitForElementToBeVisible(incidentsRegistrationTab).isDisplayed();
	}

	public String getIncidentsRegistrationTabText() {
		return waitUtil.waitForElementToBeVisible(fycoDataTab).getText();
	}

	public void clickIncidentsRegistrationTab() {
		waitUtil.waitForElementToBeClickable(incidentsRegistrationTab).click();
	}

	public boolean isFycoDataTabDisplayed() {
		return waitUtil.waitForElementToBeVisible(fycoDataTab).isDisplayed();
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

	public boolean isCargoDataTabDisplayed() {
		return waitUtil.waitForElementToBeVisible(cargoDataTab).isDisplayed();
	}

	public void clickCargoDataTab() {
		waitUtil.waitForElementToBeClickable(cargoDataTab).click();
	}

	public void scrollToRight() {
		// Ensure the freightTabHorizontalScroll element is visible before attempting to scroll
		waitUtil.waitForElementToBeVisible(freightTabHorizontalScroll);

		// Scroll the cargoDataTab into view
		executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cargoDataTab);

		// Wait until the cargoDataTab is clickable
		waitUtil.waitForElementToBeClickable(cargoDataTab).click();
	}
}