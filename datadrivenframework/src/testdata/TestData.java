package testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class TestData {
	public static HSSFWorkbook workbook;
	//public static XSSFWorkbook workbook1;
	public static HSSFSheet worksheet;
	public static DataFormatter formatter= new DataFormatter();
	public static String file_location = System.getProperty("user.dir")+"/TestData/TD.xls";
	static String SheetName= "AddCustomer";
	public  String Res;
	public int DataSet=-1;

	
	@DataProvider
	public static Object[][] dp() {
		return new Object[][] {
			new Object[] { "mgr123", "mgr!23", "jo" },
		//	new Object[] { "test", "test1" },
		};
	}

	@DataProvider
	public static Object[][] dp1() {
		return new Object[][] {
			new Object[] { "mgr123", "mgr!23","Guru99 Bank Home Page","ram" },
		//	new Object[] { "test", "test1","Welcome: Mercury Tours" },
		};
	}

	@DataProvider
	public static Object[][] dpx() throws IOException {
		FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
		workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
		worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
		HSSFRow Row=worksheet.getRow(0);
		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum= Row.getLastCellNum(); // get last ColNum 

		Object Data[][]= new Object[RowNum-1][ColNum]; // pass my� count data in array

		for(int i=0; i<RowNum-1; i++) //Loop work for Rows
		{
			HSSFRow row= worksheet.getRow(i+1);

			for (int j=0; j<ColNum; j++) //Loop work for colNum
			{
				if(row==null)
					Data[i][j]= "";
				else
				{
					HSSFCell cell= row.getCell(j);
					if(cell==null)
						Data[i][j]= ""; //if it get Null value it pass no data 
					else
					{
						String value=formatter.formatCellValue(cell);
						Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
					}
				}
			}
		}

		return Data;

	}

}
