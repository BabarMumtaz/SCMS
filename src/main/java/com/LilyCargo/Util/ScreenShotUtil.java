package com.LilyCargo.Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

    public static void takeScreenshotAtEndOfTest(WebDriver driver, String testName) throws IOException {
        // Capture screenshot as a file
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the directory where the screenshot will be saved
        String currentDir = System.getProperty("user.dir");

        // Format date and time to include in the filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Create a filename based on the test name and current timestamp
        String fileName = testName + "_" + timestamp + ".png";

        // Copy the screenshot file to the specified location
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + fileName));
    }
}