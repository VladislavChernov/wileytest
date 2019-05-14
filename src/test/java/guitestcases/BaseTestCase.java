package guitestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import util.ListenerWithScreenShot;
import util.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static util.Utils.takeScreenShot;

@Listeners(ListenerWithScreenShot.class)
public class BaseTestCase {
	
	public static WebDriver driver;
	
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
            //takeScreenShot(driver, result.getName());
			Reporter.log("<a href='"+ takeScreenShot(driver, result.getName()) + "'> <img src='"+ takeScreenShot(driver, result.getName())+ "' height='100' width='100'/> </a>");
        }
    }

	@AfterSuite
	public static void tearDown(){
		driver.quit();
	}
}
