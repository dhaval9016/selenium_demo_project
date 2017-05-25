package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class wordpress_login_page
{
	XSSFWorkbook wb; 
	XSSFSheet sheet1;
	
	public wordpress_login_page(String strFilepath) throws IOException
	{
		File src = new File(strFilepath);
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);			
	}
	
	public String getdata(int sheetNumber , int row, int column)
	{
		sheet1 =  wb.getSheetAt(sheetNumber);
		
		String data	= sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data; 
	}
	
	public int getRowcount(int sheetNumber)
	{
		int row = wb.getSheetAt(sheetNumber).getLastRowNum()+1;
		return row;
	}
	

}
