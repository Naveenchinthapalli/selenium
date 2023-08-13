package com.orange.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelutilities {

		
		static XSSFRow row;
		static XSSFCell cell;

		public static String getCellValue(String excelfilepath, String sheetName, int rowIndex, int cellIndex)
				throws IOException {

			FileInputStream excelfile = new FileInputStream(excelfilepath);
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowIndex);
			XSSFCell cell = row.getCell(cellIndex);
			String data = "";
			try {

				if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
					return "";
				} else {
					data = cell.getStringCellValue();
				}
			} catch (Exception e) {

			}
			return data;
		}

		public static void setCellValue(String excelfilepath, String sheetName, int rowIndex, int cellIndex, String data)
				throws IOException {

			FileInputStream excelfile = new FileInputStream(excelfilepath);
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet.getRow(rowIndex) == null) {
				row = sheet.createRow(rowIndex);
				cell = row.createCell(cellIndex);
				cell.setCellValue(data);
			} else {
				row = sheet.getRow(rowIndex);

				cell = row.createCell(cellIndex);
				cell.setCellValue(data);
			}

			FileOutputStream saveFile = new FileOutputStream(excelfilepath);
			workbook.write(saveFile);

		}

		public static void setRowOfCellValue(String excelfilepath, String sheetName, int rowIndex, int cellIndex,
				String data) throws IOException {

			FileInputStream excelfile = new FileInputStream(excelfilepath);
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowIndex);
			XSSFCell rowofNewcell = row.createCell(cellIndex);
			rowofNewcell.setCellValue(data);
			FileOutputStream saveFile = new FileOutputStream(excelfilepath);
			workbook.write(saveFile);
			saveFile.close();
		}

		public static int getLastRowNum(String excelfilepath, String sheetName) throws IOException {
			FileInputStream excelfile = new FileInputStream(excelfilepath);
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			return rowCount;
		}

		public static int getLastcellNum(String excelfilepath, String sheetName, int rowIndex) throws IOException {
			FileInputStream excelfile = new FileInputStream(excelfilepath);
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int cellCount = sheet.getRow(rowIndex).getLastCellNum();
			return cellCount;
		}


	}


