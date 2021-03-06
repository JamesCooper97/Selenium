package com.QA.DDT1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelSheet;
	private static XSSFWorkbook ExcelBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void setExcelFile() {
		try {
			FileInputStream ExcelFile = new FileInputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelBook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static XSSFSheet getExcelSheet() {
		return ExcelSheet;
	}

	public static String getCellData(int Row, int Col) {
		try {
			Cell = ExcelSheet.getRow(Row).getCell(Col);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum) {
		try {
			Row = ExcelSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}