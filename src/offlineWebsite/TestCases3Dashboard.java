package offlineWebsite;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCases3Dashboard {
	WebDriver driver=null;
	@BeforeMethod
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com"); 
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	}
	@AfterMethod
	public void driverCloser() {
		driver.close();
	}
	@Test (priority = 1)
	public void CheckMainMenuClick() {
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[2]/a/span")).click();
		String dashboard=driver.getTitle();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		String user=driver.getTitle();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a/span")).click();
		String operator=driver.getTitle();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[5]/a/span")).click();
		String usefulLink=driver.getTitle();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[6]/a/span")).click();
		String downloads=driver.getTitle();

		ArrayList<String> actual=new ArrayList<String>();
		actual.add(dashboard);
		actual.add(user);
		actual.add(operator);
		actual.add(usefulLink);
		actual.add(downloads);

		ArrayList<String> expected=new ArrayList<String>();
		expected.add("JavaByKiran | Dashboard");
		expected.add("JavaByKiran | User");
		expected.add("JavaByKiran | Operators");
		expected.add("JavaByKiran | Useful Links");
		expected.add("JavaByKiran | Downloads");
		Assert.assertEquals(actual, expected); 
	}
	@Test (priority = 2)
	public void CheckDashBoardMenu() {
		String actSelenium=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[1]/div/div[1]/h3")).getText();
		String actJavaJ2EE=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[2]/div/div[1]/h3")).getText();
		String actPython=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[3]/div/div[1]/h3")).getText();
		String actPhp=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/div[1]/h3")).getText();

		ArrayList<String> act=new ArrayList<String>();
		act.add(actSelenium);
		act.add(actJavaJ2EE);
		act.add(actPython);
		act.add(actPhp);
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("Selenium");
		exp.add("Java / J2EE");
		exp.add("Python");
		exp.add("Php");
		Assert.assertEquals(act, exp);
	}  
	@Test (priority = 3)
	public void CheckSubHeading() {
		String t1=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[1]/div/div[1]/p")).getText();
		String t2=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[2]/div/div[1]/p")).getText();
		String t3=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[3]/div/div[1]/p")).getText();
		String t4=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/div[1]/p")).getText();
		ArrayList<String> act=new ArrayList<String>();
		act.add(t1);
		act.add(t2);
		act.add(t3);
		act.add(t4);
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("Automation Testing");
		exp.add("Software Development");
		exp.add("Data Science");
		exp.add("Web Development");
		Assert.assertEquals(act, exp);
	}	                             
	@Test (priority = 4)
	public void CheckTextCopyRight() {
		String act=driver.findElement(By.xpath("/html/body/div/footer/strong")).getText();
		String exp="Copyright © 2005-2019 JavaByKiran.";
		Assert.assertEquals(act, exp);
	}  
	@Test (priority = 5)
	public void CheckTextDesign() {
		String act=driver.findElement(By.xpath("/html/body/div/footer/div/b")).getText();
		String exp="Design for Selenium Automation Test";
		Assert.assertEquals(act, exp);
	}                   
	@Test (priority = 6)
	public void CheckTextHeader() {
		String act=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		String exp="Dashboard Courses Offered";
		Assert.assertEquals(act, exp);
	}   
	@Test (priority = 7)
	public void CheckDownloadsClick() {
		driver.findElement(By.linkText("Downloads")).click(); //Used By.LinkText
		String act=driver.getTitle();
		String exp="JavaByKiran | Downloads";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 8)
	public void CheckUsefulLinkClick() {
		driver.findElement(By.partialLinkText("Usef")).click(); //Used By.partialLinkText
		String act=driver.getTitle();
		String exp="JavaByKiran | Useful Links";
		Assert.assertEquals(act, exp);
	}
}