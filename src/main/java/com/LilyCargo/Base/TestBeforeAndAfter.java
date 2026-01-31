package com.LilyCargo.Base;

import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.LilyCargo.Util.ScreenShotUtil;

public class TestBeforeAndAfter extends TestBaseClass {

    private static final Logger log = LogManager.getLogger(TestBeforeAndAfter.class);

    @BeforeMethod
    public void setUp(Method method, ITestResult result, ITestContext context) {
        initialization();
        context.setAttribute("WebDriver", driver);

        log.info("Browser initialized successfully.");
        pageObjectManager = new PageObjectManager(driver);

        boolean isLoginTest = false;
        for (String group : result.getMethod().getGroups()) {
            if (group.equals("login")) {
                isLoginTest = true;
                break;
            }
        }

        if (!isLoginTest) {
            performLogin();
        }
    }

    public void performLogin() {
        pageObjectManager.getLoginPage()
                .login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");

        // Avoid hard assertion that can block teardown
        if (!pageObjectManager.getLoginPage().isLoginSuccessful()) {
            log.error("Login was not successful.");
            throw new RuntimeException("Login failed. Aborting test.");
        }

        log.info("Login successful.");
    }

    public void logout() {
        try {
            pageObjectManager.getLoginPage().logout();
            log.info("Logged out successfully.");
            Thread.sleep(1000);
        } catch (Exception e) {
            log.warn("Logout attempt failed or user was already logged out.");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                try {
                    InputStream screenshotStream =
                            ScreenShotUtil.takeScreenshotForAllure(driver, testName);
                    if (screenshotStream != null) {
                        Allure.addAttachment("Screenshot on Failure", screenshotStream);
                    }
                    log.error("Test FAILED: {} - Screenshot captured.", testName);
                } catch (Exception e) {
                    log.error("Failed to capture screenshot for {}", testName, e);
                }
            } else {
                log.info("Test {}: {}",
                        testName,
                        (result.getStatus() == ITestResult.SUCCESS) ? "PASSED" : "SKIPPED");
            }

            // Safe logout
            try {
                logout();
            } catch (Exception e) {
                log.warn("Logout failed for test: {}", testName, e);
            }

        } finally {
            // ALWAYS close browser
            if (driver != null) {
                driver.quit();
                log.info("Browser closed.");
            }
        }
    }
}
