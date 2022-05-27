package offlineWebsite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.grid.web.Values;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.common.LengthConverter;

public class TestCases5AddUserPage {
	WebDriver driver=null;
	@BeforeMethod
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com"); 
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.findElement(By.linkText("Users")).click();           //By.linkText
		//driver.findElement(By.partialLinkText("Use")).click();    //By.partiallinkText
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();//add user
	}
	@AfterMethod
	public void driverCloser() {
		driver.close();
	}
	@Test (priority = 1)
	void CheckblankSubmit(){    //No result
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		String act=driver.findElement(By.xpath("//*[text()='Please fill out this field.']")).getText();
		String exp="please fill out this field";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 2)
	void CheckIntegerInUsername(){
		driver.findElement(By.xpath("//input[@class=\"form-control\" and  @id=\"username\"]")).sendKeys("1");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		String act=driver.findElement(By.xpath("//*[text()='Number Not Allowed']")).getText();
		String exp="Number Not Allowed";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 2)
	void CheckCharInMobile(){
		driver.findElement(By.xpath("//input[@class=\"form-control\" and @placeholder=\"Mobile\"]")).sendKeys("e");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
	//	Assert.assertEquals(act, exp);
	}
}
