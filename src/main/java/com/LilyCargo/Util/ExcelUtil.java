package com.LilyCargo.Util;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Object[][] getTestData(String sheetName, String filePath) {
		try (FileInputStream file = new FileInputStream(filePath)) 
				{

			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null || sheet.getPhysicalNumberOfRows() <= 1) {
				System.out.println("No data found in sheet: " + sheetName);
				return new Object[0][0];
			}

			// Count only the rows that contain data
			int totalRows = 0;
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // Start from row 1 (skip header)
				Row row = sheet.getRow(i);
				if (row != null && !isRowEmpty(row)) {
					totalRows++;
				}
			}

			// Get the number of columns from the first row
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			Object[][] data = new Object[totalRows][cols];

			DataFormatter formatter = new DataFormatter();
			int dataIndex = 0;

			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row row = sheet.getRow(i);

				// Skip empty or null rows
				if (row == null || isRowEmpty(row)) {
					System.out.println("Row " + i + " is empty or null, skipping.");
					continue;
				}

				for (int j = 0; j < cols; j++) {
					data[dataIndex][j] = formatter.formatCellValue(row.getCell(j)).trim(); // Ensure no null values
				}
				dataIndex++;
			}

			return data;

		} catch (IOException e) {
			e.printStackTrace();
			return new Object[0][0];
		}
	}

	// Helper method to check if the entire row is empty
	private static boolean isRowEmpty(Row row) {
		if (row == null) {
			return true;
		}
		for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
			if (row.getCell(cellNum) != null && !row.getCell(cellNum).toString().trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
