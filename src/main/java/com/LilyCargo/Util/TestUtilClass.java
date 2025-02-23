package com.LilyCargo.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.LilyCargo.Base.TestBaseClass;

public class TestUtilClass extends TestBaseClass {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    static Workbook book;
    static Sheet sheet;

    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
            + "/src/main/java/SCMS/Cargo/Config/ScmsTestDataFile.xlsx";

    public static void takeScreenshotAtEndOfTest(String testCaseName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Get current date and time
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        // Define screenshot name with test case name + timestamp
        String fileName = testCaseName + "_" + timestamp + ".png";

        // Save screenshot in the 'screenshots' folder
        String currentDir = System.getProperty("user.dir") + "/screenshots/";
        FileUtils.copyFile(scrFile, new File(currentDir + fileName));

        System.out.println("Screenshot taken: " + fileName);
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }
}

