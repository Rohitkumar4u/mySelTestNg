package offlineWebsite;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCases1LoginPage {
	WebDriver driver=null;
	@BeforeMethod
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html"); 
	}
	@AfterMethod
	public void driverCloser() {
		driver.close();
	}
	@Test (priority = 1)
	public void checkTitle() throws IOException {
		String actTitle=driver.getTitle();
		String expTitle="javabykiran";
		Assert.assertEquals(actTitle, expTitle);
	}  
	@Test (priority = 2)
	public void checkText1(){
		String act=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
		String exp="Java By Kiran";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 3)
	public void checkText2(){
		String act=driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
		String exp="JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(act, exp);

	}
	@Test (priority = 4)
	public void checkText3(){
		String act=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
		String exp="Sign in to start your session";
		Assert.assertEquals(act, exp);

	}  
	@Test (priority = 5)
	public void CheckBlankUName() throws IOException {
		FileInputStream fis=new FileInputStream("abcd.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String val=prop.getProperty("xpathUname");   //taken uname from prop file
		System.out.println("val >> " + val);

		driver.findElement(By.xpath(val)).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		String expMsg="blank not allowed";
		Assert.assertEquals(actMsg, expMsg);
	}
	@Test (priority = 6)
	public void CheckBlankPWord() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actMsg=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		String expMsg="blank not allowed";
		Assert.assertEquals(actMsg, expMsg);
	}
	@Test (priority = 7)
	public void CheckSpecialCharUName() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		String expMsg="alphabets only allowed";
		Assert.assertEquals(actMsg, expMsg);
	}
	@Test (priority = 8)
	public void CheckSpecialCharPWord() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actMsg=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		String expMsg="alphabets only allowed";
		Assert.assertEquals(actMsg, expMsg);
	}     
	@Test (priority = 9)
	public void CheckLogin() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com"); 
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actPage=driver.getTitle();
		System.out.println(actPage);
		String expPage="JavaByKiran | Dashboard";
		Assert.assertEquals(actPage, expPage); 
	}  
	@Test (priority = 10)
	public void CheckHypLinkTextRegiNew() {
		String actText=driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
		String expText="Register a new membership";
		Assert.assertEquals(actText, expText);
	} 
	@Test (priority = 11)
	public void CheckHypLinkClick() {
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		String actPage=driver.getTitle();
		String expPage="JavaByKiran | Registration page";
		Assert.assertEquals(actPage, expPage);
	} 
	
}