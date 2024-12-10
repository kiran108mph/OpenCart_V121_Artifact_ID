package testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle cellStyle;
	public String path;
	
	public ExcelUtility(String path)
	{
		this.path = path;
	}
	
	public int getTotalRowCount(String sheetName) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public int getTotalColumnCount(String sheetName, int rowNumber) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		int cellCount = row.getLastCellNum();		
		workbook.close();
		fis.close();	
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rowNumber, int columnNumber) throws IOException 
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(columnNumber);
		
		DataFormatter dataformatter = new DataFormatter();
		String data;
		try
		{
			data = dataformatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data = "";
		}
		workbook.close();
		fis.close();	
		return data;
	}
	
	public void setCellData(String sheetName, int rowNumber, int columnNumber, String data) throws IOException
	{
		File xlfile = new File(path);
		if(!xlfile.exists())
		{
			workbook =  new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workbook.write(fos);
		}
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1)
		{
			workbook.createSheet(sheetName); //If sheet not exists then create new sheet
		}
		sheet= workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNumber)==null)
		{
			sheet.createRow(rowNumber); //If row not exists then create new row
		}
		row = sheet.getRow(rowNumber); 
		
		cell=row.createCell(columnNumber);
		cell.setCellValue(data);
		fos= new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
		
	}
	
	
	
}
