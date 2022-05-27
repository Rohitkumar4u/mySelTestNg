package annotationPractice;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
public class X {
	@Test
	public void m1() {
		System.out.println("X- 1 -@Test");
	}
	@BeforeMethod
	public void m2() {
		System.out.println("X- 2 -@BeforeMethod");
	}
	@AfterMethod
	public void m3() {
		System.out.println("X- 3 -@AfterMethod");
	}

}
