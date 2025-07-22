package com.LilyCargo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuBarTestPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public MenuBarTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//img[@src = '/static/media/aside-uncollapse.bd6caeaeff8ed082011267c649cadb4e.svg']")
	WebElement sideBarExpand;

	@FindBy(xpath = "//div[@title='Dashboard']")
	WebElement dashboardMenu;

	@FindBy(xpath = "//li[contains(@title,'Intrastats')]")
	WebElement intrastatsDashSubMenu;

	@FindBy(xpath = "//div[@title='Administration']")
	WebElement administrationMenu;

	@FindBy(xpath = "//div[@title='Administration']//li[@title='Overview']")
	WebElement overviewAdmSubMenu;

	@FindBy(xpath = "//li[@title='Booked Freight']")
	WebElement bookedFreightMenu;

	@FindBy(xpath = "//div[@title='Freight Relations']")
	WebElement freightRelationsMenu;

	@FindBy(xpath = "//li[@title='Carriers']")
	WebElement carriersFRSubMenu;

	@FindBy(xpath = "//li[@title='Clients']")
	WebElement clientFRSubMenu;

	@FindBy(xpath = "//li[@title='Export Companies']")
	WebElement exportCompaniesFRSubMenu;

	@FindBy(xpath = "//li[@title='Shippers']")
	WebElement shippersFRSubMenu;

	@FindBy(xpath = "//li[@title='Warehouses']")
	WebElement warehousesFRSubMenu;

	@FindBy(xpath = "//div[@title='Finance']")
	WebElement financeMenu;

	@FindBy(xpath = "//li[@title='International Products']")
	WebElement internationalProductsFinanceSubMenu;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	// Method to click on Logout button
	public void ClickExpandSideBarIcon() {
		sideBarExpand.click();
	}

	public void clickDashboardMenu() {
		dashboardMenu.click();
	}

	public void clickIntrastatsDashSubMenu() {
		intrastatsDashSubMenu.click();
	}

	public void clickAdministrationMenu() {
		administrationMenu.click();
	}

	public void clickOverviewAdmSubMenu() {
		overviewAdmSubMenu.click();
	}

	public void clickBookedFreightMenu() {
		bookedFreightMenu.click();
	}

	public void clickFreightRelationsMenu() {
		freightRelationsMenu.click();
	}

	public void clickCarriersFRSubMenu() {
		carriersFRSubMenu.click();
	}

	public void clickClientFRSubMenu() {
		clientFRSubMenu.click();
	}

	public void clickExportCompaniesFRSubMenu() {
		exportCompaniesFRSubMenu.click();
	}

	public void clickShippersFRSubMenu() {
		shippersFRSubMenu.click();
	}

	public void clickWarehousesFRSubMenu() {
		warehousesFRSubMenu.click();
	}

	public void clickFinanceMenu() {
		wait.until(ExpectedConditions.visibilityOf(financeMenu)).click();
	}

	public void clickInternationalProductsSubMenu() {
		wait.until(ExpectedConditions.visibilityOf(internationalProductsFinanceSubMenu)).click();
	}
}
