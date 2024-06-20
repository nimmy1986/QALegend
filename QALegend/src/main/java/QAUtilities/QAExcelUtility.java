package QAUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QAExcelUtility 
{
		static FileInputStream file ;
		static XSSFWorkbook book;
		static XSSFSheet sheet;
		
		public static String readStringData(int row ,int column,String shname) throws Exception
		{
			file = new FileInputStream("C:\\Users\\anups\\eclipse-workspace\\QALegend\\src\\main\\resources\\QALegend.xlsx");
			book =new XSSFWorkbook(file);
			sheet =book.getSheet(shname);
			Row r = sheet.getRow(row);
			Cell c =r.getCell(column);
			return c.getStringCellValue();
		}
		public static String readIntegerData(int row , int column, String shname) throws Exception
		{
			file = new FileInputStream("C:\\Users\\anups\\eclipse-workspace\\QALegend\\src\\main\\resources\\QALegend.xlsx");
			book =new XSSFWorkbook(file);
			sheet =book.getSheet(shname);
			Row r = sheet.getRow(row);
			Cell c =r.getCell(column);
			int  a = (int) c.getNumericCellValue();
			return String.valueOf(a);
		}
		
	}