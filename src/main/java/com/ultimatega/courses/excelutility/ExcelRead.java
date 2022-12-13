package com.ultimatega.courses.excelutility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelRead {
     /*
    URL to get the binary - http://poi.apache.org/download.html
    Binary Name - poi-bin-3.11-beta2-20140822.zip
    Extract the binary
    Add all the jars from the location you extracted to the build path
    Also add all the jars from lib, do not add the jar file of log4j
    Also add all the jars from ooxml-lib
    Only works for Excel 2007+
*/

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");

        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell Cell;

        // Location of the Excel file
        String path = projectPath + "\\src\\test\\java\\resources\\testdata\\ExcelRead.xlsx";
        String sheetName = "Sheet1";

        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);

            Cell = excelWSheet.getRow(1).getCell(2);
            String cellData = Cell.getStringCellValue();
            System.out.println("Cell Data: " + cellData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
