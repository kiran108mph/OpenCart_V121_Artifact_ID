package testUtilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = "C:\\Users\\kiran\\eclipse-workspace\\OpenCart_V121_Artifact_ID\\testdata\\TestData.xlsx"; //taking xl file from testData
		ExcelUtility xlutility =  new ExcelUtility(path); //Creating an object for xlutility to make use of excel method
		int numberOfRows = xlutility.getTotalRowCount("LoginDetails"); //Get the total number of rows to write a loop to retrieve the data
		System.out.println("The total number of rows is "+numberOfRows);
		int numberOfColums = xlutility.getTotalColumnCount("LoginDetails", 1); //Get the total number of columns to write a loop to retrieve the data
		System.out.println("The total number of columns is "+numberOfColums);
		String[][] logInData = new String[numberOfRows][numberOfColums]; //Creating new two dimentional array with some size
		for(int i=1; i<=numberOfRows; i++)
		{
			for(int j=0; j<numberOfColums; j++)
			{
				logInData[i-1][j]=xlutility.getCellData("LoginDetails", i, j);
			}
			
		} 
		return logInData; //returning two dimension array;
	}
}

