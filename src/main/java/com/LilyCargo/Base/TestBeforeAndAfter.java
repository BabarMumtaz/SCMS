package com.LilyCargo.Base;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.LilyCargo.Util.ScreenShotUtil;

public class TestBeforeAndAfter extends TestBaseClass {
    private static final Logger log = LogManager.getLogger(TestBeforeAndAfter.class);

    @BeforeMethod
    public void setUp(Method method, ITestResult result) {
        initialization();
        log.info("Browser initialized successfully.");
        pageObjectManager = new PageObjectManager(driver);

        // Skip login if the test belongs to the "login" group
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
        pageObjectManager.getLoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
        log.info("Entered valid username and password.");

        // Check if login is successful
        Assert.assertTrue(pageObjectManager.getLoginPage().isLoginSuccessful(), "Login was not successful.");
        log.info("Login successful.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                ScreenShotUtil.takeScreenshotAtEndOfTest(driver, testName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            log.error("Test FAILED: {} - Screenshot captured.", testName);
        } else {
            log.info("Test {}: {}", testName, (result.getStatus() == ITestResult.SUCCESS) ? "PASSED" : "SKIPPED");
        }

        if (driver != null) {
            driver.quit();
            log.info("Browser closed.");
        }
    }

}