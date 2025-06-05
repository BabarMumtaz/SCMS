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
	WebElement SideBarExpand;

	@FindBy(xpath = "//div[@title='Dashboard']")
	WebElement DashboardMenu;

	@FindBy(xpath = "//li[contains(@title,'Intrastats')]")
	WebElement IntrastatsDashSubMenu;

	@FindBy(xpath = "//div[@title='Administration']")
	WebElement AdministrationMenu;

	@FindBy(xpath = "//li[@title='Overview']")
	WebElement OverviewAdmSubMenu;

	@FindBy(xpath = "//li[@title='Booked Freight']")
	WebElement BookedFreightMenu;

	@FindBy(xpath = "//div[@title='Freight Relations']")
	WebElement FreightRelationsMenu;

	@FindBy(xpath = "//li[@title='Carriers']")
	WebElement CarriersFRSubMenu;

	@FindBy(xpath = "//li[@title='Clients']")
	WebElement ClientFRSubMenu;

	@FindBy(xpath = "//li[@title='Shippers']")
	WebElement ShippersFRSubMenu;

	@FindBy(xpath = "//div[@title='Finance']")
	WebElement financeMenu;

	@FindBy(xpath = "//li[@title='International Products']")
	WebElement internationalProductsFinanceSubMenu;

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	// Method to click on Logout button
	public void ClickExpandSideBarIcon() {
		SideBarExpand.click();
	}

	public void clickDashboardMenu() {
		DashboardMenu.click();
	}

	public void clickIntrastatsDashSubMenu() {
		// Click on date picker
		IntrastatsDashSubMenu.click();
	}

	public void clickAdministrationMenu() {
		AdministrationMenu.click();
	}

	public void clickOverviewAdmSubMenu() {
		OverviewAdmSubMenu.click();
	}

	public void clickBookedFreightMenu() {
		BookedFreightMenu.click();
	}

	public void clickFreightRelationsMenu() {
		FreightRelationsMenu.click();
	}

	public void clickCarriersFRSubMenu() {
		CarriersFRSubMenu.click();
	}

	public void clickClientFRSubMenu() {
		ClientFRSubMenu.click();
	}

	public void clickShippersFRSubMenu() {
		ShippersFRSubMenu.click();
	}

	public void clickFinanceMenu() {
		wait.until(ExpectedConditions.visibilityOf(financeMenu)).click();
	}

	public void clickInternationalProductsSubMenu() {
		wait.until(ExpectedConditions.visibilityOf(internationalProductsFinanceSubMenu)).click();
	}
}
