package com.LilyCargo.Base;

import com.LilyCargo.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    private WebDriver driver;

    // Declare all page objects
    private LoginTestPage loginPage;
    private MenuBarTestPage menuBar;
    private AdminOverviewTestPage adminOverviewTestPage;
    private IntrastatsTestPage intrastatsPage;
    private FreightTestPage bookedFreights;
    private FreightListingTestPage freightListing;
    private FreightDetailTestPage freightDetail;
    private SubmitMrnCustomsStatusPage submitMrnCustomsStatus;
    private DockPlannerPage dockPlanner;
    private CarriersTestPage carriersPage;
    private InternationalProductsPage internationalProductsPage;
    private CarrierListingTestPage carrierListing;
    private ClientTestPage clientPage;
    private ShipperTestPage shippersPage;
    private ShipperListingPage shipperListing;
    private ExportCompaniesTestPage exportCompaniesPage;
    private WarehousesTestPage warehousePage;
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

    public AdminOverviewTestPage getAdminOverviewTestPage() {
        return (adminOverviewTestPage == null) ? adminOverviewTestPage = PageFactory.initElements(driver, AdminOverviewTestPage.class) : adminOverviewTestPage;
    }

    public IntrastatsTestPage getIntrastatsPage() {
        return (intrastatsPage == null) ? intrastatsPage = PageFactory.initElements(driver, IntrastatsTestPage.class) : intrastatsPage;
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

    public SubmitMrnCustomsStatusPage getSubmitMrnCustomsStatusPage() {
        return (submitMrnCustomsStatus == null) ? submitMrnCustomsStatus = PageFactory.initElements(driver, SubmitMrnCustomsStatusPage.class) : submitMrnCustomsStatus;
    }

    public DockPlannerPage getDockPlannerPage() {
        return (dockPlanner == null) ? dockPlanner = PageFactory.initElements(driver, DockPlannerPage.class) : dockPlanner;
    }

    public InternationalProductsPage getInternationalProductsPage() {
        return (internationalProductsPage == null) ? internationalProductsPage = PageFactory.initElements(driver, InternationalProductsPage.class) : internationalProductsPage;
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

    public ShipperListingPage getShipperListing() {
        return (shipperListing == null) ? shipperListing = PageFactory.initElements(driver, ShipperListingPage.class) : shipperListing;
    }

    public ExportCompaniesTestPage getExportCompanyPage() {
        return (exportCompaniesPage == null) ? exportCompaniesPage = PageFactory.initElements(driver, ExportCompaniesTestPage.class) : exportCompaniesPage;
    }

    public WarehousesTestPage getWarehousePage() {
        return (warehousePage == null) ? warehousePage = PageFactory.initElements(driver, WarehousesTestPage.class) : warehousePage;
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
