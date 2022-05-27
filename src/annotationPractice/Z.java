package annotationPractice;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Z {
  @Test
  public void m000() {
	  System.out.println("z-000-@Test");
  }
  @AfterTest
  public void m111() {
	  System.out.println("z-111-@AfterTest");
  }
  @BeforeSuite
  public void m222() {
	  System.out.println("z-222-@BeforeSuite");
  }
  @AfterSuite
  public void m333() {
	  System.out.println("z-333-@AfterSuite");
  }
}
