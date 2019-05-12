package guitestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static util.Utils.takeScreenShot;


public class BaseTestCase {
	
	protected static WebDriver driver;
	
	@BeforeSuite
	public static void setUp(){
		driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.wiley.com/en-us");
		if(driver.findElement(By.xpath("//div[@class='modal-dialog']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='modal-footer']/button[contains(text(),'YES')]")).click();
		}
		driver.manage().window().maximize();
	}


	@AfterMethod
    public void takeScreenshotOnError(ITestResult result) {
	    if(!result.isSuccess()) {
            takeScreenShot(driver, result.getName());
        }
    }

	@AfterSuite
	public static void tearDown(){
		driver.quit();
	}
}
