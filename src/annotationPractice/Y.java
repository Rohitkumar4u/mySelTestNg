package annotationPractice;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
public class Y {
  @Test
  public void m00() {
	  System.out.println("Y-00 -@Test");
  }
  @BeforeClass
  public void m11() {
	  System.out.println("Y-11 -@BeforeClass");
  }
  @AfterClass
  public void m22() {
	  System.out.println("Y-22 -@AfterClass");
  }
  @BeforeTest
  public void m33() {
	  System.out.println("Y-33 -@BeforeTest");
  }
}
