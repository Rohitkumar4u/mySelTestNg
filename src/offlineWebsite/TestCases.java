package offlineWebsite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestCases {
	@Test
	public void checkOperation(){
		Operation oo=new Operation();
		int actResult=oo.additon(34, 10);
		int expResult=44;
		Assert.assertEquals(actResult, expResult);
	}	
	@Test
	public void checkXYZ(){
		Assert.assertEquals(7, 7);
	}
	@Test
	public void checkTitle() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

		String actTitle=driver.getTitle();
		driver.close();
		Assert.assertEquals(actTitle, "javabykiran");
	}
	@Test
	public void CheckBlankUname() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Desktop/RhtJbk/2.Selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		String actMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		driver.close();
		Assert.assertEquals(actMsg, "blank not allowed");

	}
}
