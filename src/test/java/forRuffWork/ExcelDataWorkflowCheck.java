package forRuffWork;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testUtilities.ExcelUtility;

public class ExcelDataWorkflowCheck {

	public static void main(String[] args) throws IOException {

		ExcelUtility excel = new ExcelUtility(
				"C:\\Users\\kiran\\eclipse-workspace\\OpenCart_V121_Artifact_ID\\testdata\\TestData.xlsx");
		int totoalRows = excel.getTotalRowCount("sheet1");
		System.out.println("total no of rows is " + totoalRows);

//		FileInputStream file = new FileInputStream("C:\\\\Users\\\\kiran\\\\eclipse-workspace\\\\OpenCart_V121_Artifact_ID\\\\testdata\\\\TestData.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheet("sheet1");
//		int lastRow = sheet.getLastRowNum();
//		int lastCell = sheet.getRow(0).getLastCellNum();
//		for(int i=0; i<=lastRow; i++)
//		{
//			XSSFRow row = sheet.getRow(i);
//			for(int j=0; j<lastCell; j++)
//			{
//				XSSFCell cell = row.getCell(j);
//				String cellValue = cell.toString();
//				System.out.print(cellValue+"\t");
//			}
//			System.out.println();
//		}
//		workbook.close();
//		file.close();

	}

}
