package com.LilyCargo.TestCases;

import com.LilyCargo.Base.TestBaseClass;
import com.LilyCargo.Pages.*;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

public class SubmitMrnUsingUploadFileTest extends TestBaseClass {

    LoginTestPage loginPage;
    MenuBarTestPage menuBar;
    FreightTestPage bookedFreights;
    FreightListingTestPage freightListing;
    FreightDetailTestPage freightDetail;
    JavascriptExecutor js;
    Faker faker;
    Logger log;

    @BeforeMethod
    public void setup() {
        initialization(); // Opens a new browser instance
        loginPage = PageFactory.initElements(driver, LoginTestPage.class);
        menuBar = PageFactory.initElements(driver, MenuBarTestPage.class);
        bookedFreights = PageFactory.initElements(driver, FreightTestPage.class);
        freightListing = PageFactory.initElements(driver, FreightListingTestPage.class);
        freightDetail = PageFactory.initElements(driver, FreightDetailTestPage.class);

        faker = new Faker();
        js = (JavascriptExecutor) driver;
        log = LogManager.getLogger(FreightEditFromDetailPageTest.class);
        log.info("Test setup completed.");

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered Valid Username and Password.");
    }

}
