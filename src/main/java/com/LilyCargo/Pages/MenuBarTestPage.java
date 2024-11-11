package com.LilyCargo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBarTestPage {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public MenuBarTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	@CacheLookup
	@FindBy(xpath = "//img[@src = '/static/media/aside-uncollapse.bd6caeaeff8ed082011267c649cadb4e.svg']")
	WebElement SideBarExpand;

	@CacheLookup
	@FindBy(xpath = "//div[@title='Dashboard']")
	WebElement DashboardMenu;

	@CacheLookup
	@FindBy(xpath = "//li[contains(@title,'Intrastats')]")
	WebElement IntrastatsDashSubMenu;

	@CacheLookup
	@FindBy(xpath = "//div[@title='Administration']")
	WebElement AdministrationMenu;

	@CacheLookup
	@FindBy(xpath = "//li[@title='Overview']")
	WebElement OverviewAdmSubMenu;

	@CacheLookup
	@FindBy(xpath = "//li[@title='Booked Freight']")
	WebElement BookedFreightMenu;

	@CacheLookup
	@FindBy(xpath = "//div[@title='Freight Relations']")
	WebElement FreightRelationsMenu;

	@CacheLookup
	@FindBy(xpath = "//li[@title='Carriers']")
	WebElement CarriersFRSubMenu;

	@CacheLookup
	@FindBy(xpath = "//li[@title='Clients']")
	WebElement ClientFRSubMenu;

	@CacheLookup
	@FindBy(xpath = "//li[@title='Shippers']")
	WebElement ShippersFRSubMenu;

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

}
