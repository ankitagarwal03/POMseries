package com.qa.opencart.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    private static Workbook workbook;
    private static Object[][] obj;

    public static Object[][] getDataFromSheet(String sheetName){

        try {
            FileInputStream file = new FileInputStream("./src/main/resources/register.xlsx");
            workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            obj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            for(int i=0;i<sheet.getLastRowNum();i++){
                for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                    obj[i][j] = sheet.getRow(i+1).getCell(j).toString();
                    System.out.println(sheet.getRow(i+1).getCell(j).toString());
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

}
