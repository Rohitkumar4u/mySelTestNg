package offlineWebsite;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCases2RegisterNewMember {
	WebDriver driver=null;
	@BeforeMethod
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	}
	@AfterMethod
	public void driverCloser() {
		driver.close();
	}
	@Test (priority = 1)
	void checkText1(){
		String act=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
		String exp="Java By Kiran";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 2)
	void checkText2(){
		String act=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
		String exp="Register a new membership";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 3)
	void checkTextBoxAvailability(){
		String name=driver.findElement(By.xpath("//*[@id=\"name\"]")).getText();
		String mobile=driver.findElement(By.xpath("//*[@id=\"mobile\"]")).getText();
		String email=driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();
		String password=driver.findElement(By.xpath("//*[@id=\"password\"]")).getText();
		ArrayList<String> act=new ArrayList<String>();
		act.add(name);
		act.add(mobile);
		act.add(email);
		act.add(password);
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("");
		exp.add("");	
		exp.add("");	
		exp.add("");	
		Assert.assertEquals(act, exp);
	}  
	@Test (priority = 4)
	void checkBlankInput(){
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();

		String nameMsg=driver.findElement(By.xpath("//*[@id=\"name_error\"]")).getText();
		String mobileMsg=driver.findElement(By.xpath("//*[@id=\"mobile_error\"]")).getText();
		String emailMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		String passMsg=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		ArrayList<String> act=new ArrayList<String>();
		act.add(nameMsg);
		act.add(mobileMsg);
		act.add(emailMsg);
		act.add(passMsg);
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("Please enter Name.");
		exp.add("Please enter Mobile.");
		exp.add("Please enter Email.");
		exp.add("Please enter Password.");
		Assert.assertEquals(act, exp);
	}  
	@Test (priority = 5)
	void checkSplCharInput(){
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!@#$%^&*()");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();

		String nameMsg=driver.findElement(By.xpath("//*[@id=\"name_error\"]")).getText();
		String mobileMsg=driver.findElement(By.xpath("//*[@id=\"mobile_error\"]")).getText();
		String emailMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		String passMsg=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		ArrayList<String> act=new ArrayList<String>();
		act.add(nameMsg);
		act.add(mobileMsg);
		act.add(emailMsg);
		act.add(passMsg);
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("Please enter Name.");
		exp.add("Please enter Mobile.");
		exp.add("Please enter valid email.");
		exp.add("Please enter valid password.");
		Assert.assertEquals(act, exp);
	}  
	@Test (priority = 6)
	void checkSignIn(){
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Vijay");
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("v@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("000000");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();
		String actText=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expText="User registered successfully.";
		Assert.assertEquals(actText, expText);
	}  
	@Test (priority = 7)
	void checkSignInButtonText(){
		String act=driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).getText();
		String exp="Sign In";
		Assert.assertEquals(act, exp);
	}     
	@Test (priority = 8)
	void checkHyperlinkText(){
		String act=driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
		String exp="I already have a membership";
		Assert.assertEquals(act, exp);
	}  
	@Test (priority = 9)
	void checkHyperLinkClick(){
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		String act=driver.getTitle();
		String exp="JavaByKiran | Log in";
		Assert.assertEquals(act, exp);
	}
}