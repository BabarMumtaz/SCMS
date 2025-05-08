package com.LilyCargo.Base;

import com.LilyCargo.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    private WebDriver driver;

    // Declare all page objects
    private LoginTestPage loginPage;
    private MenuBarTestPage menuBar;
    private FreightTestPage bookedFreights;
    private FreightListingTestPage freightListing;
    private FreightDetailTestPage freightDetail;
    private CarriersTestPage carriersPage;
    private CarrierListingTestPage carrierListing;
    private ClientTestPage clientPage;
    private ShipperTestPage shippersPage;
    private RemarksTestPage remarksPage;
    private IncidentsRegistrationTestPage incidentsRegistrationPage;
    private FycoDataTestPage fycoDataPage;
    private BillingCenterTestPage billingCenterPage;
    private CargoDataTestPage cargoDataPage;

    // Constructor initializes WebDriver
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    // Lazy Initialization - Create objects only when needed
    public LoginTestPage getLoginPage() {
        return (loginPage == null) ? loginPage = PageFactory.initElements(driver, LoginTestPage.class) : loginPage;
    }

    public MenuBarTestPage getMenuBar() {
        return (menuBar == null) ? menuBar = PageFactory.initElements(driver, MenuBarTestPage.class) : menuBar;
    }

    public FreightTestPage getBookedFreights() {
        return (bookedFreights == null) ? bookedFreights = PageFactory.initElements(driver, FreightTestPage.class) : bookedFreights;
    }

    public FreightListingTestPage getFreightListing() {
        return (freightListing == null) ? freightListing = PageFactory.initElements(driver, FreightListingTestPage.class) : freightListing;
    }

    public FreightDetailTestPage getFreightDetail() {
        return (freightDetail == null) ? freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class) : freightDetail;
    }

    public CarriersTestPage getCarriersPage() {
        return (carriersPage == null) ? carriersPage = PageFactory.initElements(driver, CarriersTestPage.class) : carriersPage;
    }

    public CarrierListingTestPage getCarrierListing() {
        return (carrierListing == null) ? carrierListing = PageFactory.initElements(driver, CarrierListingTestPage.class) : carrierListing;
    }

    public ClientTestPage getClientPage() {
        return (clientPage == null) ? clientPage = PageFactory.initElements(driver, ClientTestPage.class) : clientPage;
    }

    public ShipperTestPage getShippersPage() {
        return (shippersPage == null) ? shippersPage = PageFactory.initElements(driver, ShipperTestPage.class) : shippersPage;
    }

    public RemarksTestPage getRemarksPage() {
        return (remarksPage == null) ? remarksPage = PageFactory.initElements(driver, RemarksTestPage.class) : remarksPage;
    }

    public IncidentsRegistrationTestPage getIncidentsRegistrationPage() {
        return (incidentsRegistrationPage == null) ? incidentsRegistrationPage = PageFactory.initElements(driver, IncidentsRegistrationTestPage.class) : incidentsRegistrationPage;
    }

    public FycoDataTestPage getFycoDataPage() {
        return (fycoDataPage == null) ? fycoDataPage = PageFactory.initElements(driver, FycoDataTestPage.class) : fycoDataPage;
    }

    public BillingCenterTestPage getBillingCenterPage() {
        return (billingCenterPage == null) ? billingCenterPage = PageFactory.initElements(driver, BillingCenterTestPage.class) : billingCenterPage;
    }

    public CargoDataTestPage getCargoDataPage() {
        return (cargoDataPage == null) ? cargoDataPage = PageFactory.initElements(driver, CargoDataTestPage.class) : cargoDataPage;
    }

}
