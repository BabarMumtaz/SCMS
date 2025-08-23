package com.LilyCargo.Base;

import com.LilyCargo.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    private WebDriver driver;

    /** ---------- Declare all page objects ---------- */

    private LoginTestPage loginPage;
    private MenuBarTestPage menuBar;
    private GlobalMethodsTestPage globalMethodsPage;
    private DashboardOverviewTestPage dashboardOverviewPage;
    private AdminOverviewTestPage adminOverviewPage;
    private CockpitTestPage cockpitPage;
    private IntrastatsTestPage intrastatsPage;
    private HsTriggersTestPage hsTriggersPage;
    private FreightTestPage bookedFreights;
    private FreightListingTestPage freightListing;
    private FreightDetailTestPage freightDetail;
    private SubmitMrnCustomsStatusPage submitMrnCustomsStatus;
    private DockPlannerPage dockPlanner;
    private RelationsAllFieldsTestPage relationsAllFieldsPage;
    private FinanceAllFieldsTestPage financeAllFieldsTestPage;
    private RemarksTestPage remarksPage;
    private IncidentsRegistrationTestPage incidentsRegistrationPage;
    private FycoDataTestPage fycoDataPage;
    private BillingCenterTestPage billingCenterPage;
    private CargoDataTestPage cargoDataPage;

    /** ---------- Constructor initializes WebDriver ---------- */

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

    public GlobalMethodsTestPage getGlobalMethodsPage() {
        return (globalMethodsPage == null) ? globalMethodsPage = PageFactory.initElements(driver, GlobalMethodsTestPage.class) : globalMethodsPage;
    }

    public DashboardOverviewTestPage getDashboardOverviewTestPage() {
        return (dashboardOverviewPage == null) ? dashboardOverviewPage = PageFactory.initElements(driver, DashboardOverviewTestPage.class) : dashboardOverviewPage;
    }

    public AdminOverviewTestPage getAdminOverviewTestPage() {
        return (adminOverviewPage == null) ? adminOverviewPage = PageFactory.initElements(driver, AdminOverviewTestPage.class) : adminOverviewPage;
    }

    public CockpitTestPage getCockpitPage() {
        return (cockpitPage == null) ? cockpitPage = PageFactory.initElements(driver, CockpitTestPage.class) : cockpitPage;
    }

    public IntrastatsTestPage getIntrastatsPage() {
        return (intrastatsPage == null) ? intrastatsPage = PageFactory.initElements(driver, IntrastatsTestPage.class) : intrastatsPage;
    }

    public HsTriggersTestPage getHsTriggersPage() {
        return (hsTriggersPage == null) ? hsTriggersPage = PageFactory.initElements(driver, HsTriggersTestPage.class) : hsTriggersPage;
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

    public RelationsAllFieldsTestPage getRelationsAllFieldsTestPage() {
        return (relationsAllFieldsPage == null) ? relationsAllFieldsPage = PageFactory.initElements(driver, RelationsAllFieldsTestPage.class) : relationsAllFieldsPage;
    }

    public FinanceAllFieldsTestPage getFinanceAllFieldsTestPage() {
        return (financeAllFieldsTestPage == null) ? financeAllFieldsTestPage = PageFactory.initElements(driver, FinanceAllFieldsTestPage.class) : financeAllFieldsTestPage;
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
