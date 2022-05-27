package offlineWebsite;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCases4UsersPage {
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
	}
	@AfterMethod
	public void driverCloser() {
		driver.close();
	}
	@Test (priority = 1)
	void sendKeysAlert(){
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[8]/a/span")).click();
		Alert alerttext=driver.switchTo().alert();
		String act=alerttext.getText();
		alerttext.accept();
		String exp="You can not delete Default User";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 2)
	void checkUsersClick(){     //By.linkText
		String act =driver.getTitle();
		String exp="JavaByKiran | User";
		Assert.assertEquals(act, exp);
	}
	@Test (priority = 3)
	void checkUserTableHeader(){     
		List<WebElement> tableHeader=driver.findElements(By.tagName("th"));
		System.out.println(tableHeader.size());

		for(WebElement tt:tableHeader) {
			System.out.print(tt.getText()+" ");
		}
		//Assert.assertEquals(act, exp);
	}
	@Test (priority = 4)
	void checkUserTableData(){     
		List<WebElement> tabledata=driver.findElements(By.tagName("td"));
		System.out.println(tabledata.size());

		for(WebElement tt:tabledata) {
			System.out.print(tt.getText()+" ");
		}
		//Assert.assertEquals(act, exp);   
	}
	@Test (priority = 5)
	void checkDeleteButton(){     //Used Dynamic xpath
		driver.findElement(By.xpath("//span[text()='Delete']")).click();  //Used Dynamic xpath
		Alert ok=driver.switchTo().alert();
		String act=ok.getText();
		ok.accept();
		String exp="You can not delete Default User";
		Assert.assertEquals(act, exp);
	} 
	@Test (priority = 6)
	void checkMobNumberLength(){    
		String MobNo=driver.findElement(By.xpath("//td[text()='9898989898']")).getText(); 
		int act=MobNo.length();
		int exp=10;
		Assert.assertEquals(act, exp);
	} 
	@Test (priority = 7)
	void check_AtTheRate_InMailId(){    
		String s=driver.findElement(By.xpath("//td[text()='kiran@gmail.com']")).getText();
		boolean act=s.contains("@");
		boolean exp=true;
		Assert.assertEquals(act, exp);
	} 
}