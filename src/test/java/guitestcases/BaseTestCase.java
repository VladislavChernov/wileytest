package guitestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import util.WebDriverFactory;

public class BaseTestCase {
	
	protected static WebDriver driver;
	
	public SoftAssert sa = new SoftAssert();
	
	@BeforeSuite
	public static void setUp(){
		driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.wiley.com/en-us");
		if(driver.findElement(By.xpath("//div[@class='modal-dialog']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='modal-footer']/button[contains(text(),'YES')]")).click();
		}
	}
	
	@AfterSuite
	public static void tearDown(){
		driver.close();
	}
}
