package dataProvider;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Formatter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginWithDP {
	public WebDriver driver=null;
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
		System.out.println(n);
		System.out.println(s);
	}
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { 1, "a" },
			new Object[] { 2, "b" },
		};
	}

	@Test(dataProvider = "loginData")
	public void loginWithDP(String uname, String password, String expectedMsg) {
		System.setProperty("webdriver.chrome.driver", "chromedriver101.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html"); 

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actMsg=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		String expMsg=expectedMsg;
		driver.close();
		Assert.assertEquals(actMsg, expMsg);

	}

	@DataProvider
	public Object[][] loginData() {
		FileInputStream fileInputStream= new FileInputStream("LoginTestdata.xlsx"); //Excel sheet file location get mentioned here
		Workbook workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
		Sheet worksheet = workbook.getSheet("Login");           // get my sheet from workbook
		Row Row=worksheet.getRow(0);                      //get my Row which start from 0   

		int RowNum = worksheet.getPhysicalNumberOfRows();   // count my number of Rows
		int ColNum= Row.getLastCellNum();                   // get last ColNum 

		Object Data[][]= new Object[RowNum-1][ColNum];     // pass my  count data in array

		for(int i=0; i<=RowNum-1; i++)                         //Loop work for Rows
		{  
			Row row= worksheet.getRow(i+1);

			for (int j=0; j<=ColNum; j++)                         //Loop work for colNum
			{
				if(row==null)
					Data[i][j]= "";
				else 
				{
					Cell cell= row.getCell(j);
					if(cell==null)
						Data[i][j]= "";                        //if it get Null value it pass no data 
					else
					{
						String value=Formatter.formatCellValue(cell);
						Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
					}
				}
			}
		}

		return Data;
		return new Object[][] {
			//new Object[] { "", "" , "Please enter password."},
		};
	}

}

