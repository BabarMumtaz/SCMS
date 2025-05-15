package com.LilyCargo.Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

    /**
     * Takes a screenshot of the current browser state, saves it to the 'screenshots' folder,
     * and returns an InputStream of the saved file for attaching to Allure reports.
     *
     * @param driver   the WebDriver instance used to take the screenshot
     * @param testName the name of the test method (used in the filename)
     * @return InputStream of the screenshot file for Allure attachment
     */
    public static InputStream takeScreenshotForAllure(WebDriver driver, String testName) {
        try {
            // Capture screenshot and store it as a file
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Format timestamp to include in the screenshot file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Create a descriptive filename using the test name and timestamp
            String fileName = testName + "_" + timestamp + ".png";

            // Define the path where the screenshot will be saved
            String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;

            // Ensure the screenshots directory exists
            File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Copy the screenshot to the target location
            File destFile = new File(filePath);
            FileUtils.copyFile(scrFile, destFile);

            // Return an InputStream of the screenshot file for Allure attachment
            return new FileInputStream(destFile);

        } catch (IOException e) {
            // Print stack trace if there is an issue capturing or saving the screenshot
            e.printStackTrace();
            return null;
        }
    }
}