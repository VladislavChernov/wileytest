package guitestcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Suspendable;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.MainPage;

public class TestCases extends BaseTestCase{

	@Test
	public void checkLinksOnTopMenuDisplayed() {

		MainPage mp = new MainPage(driver);

		sa.assertTrue(mp.getRootMenu("WHO WE SERVE").isDisplayed());
		sa.assertTrue(mp.getRootMenu("SUBJECTS").isDisplayed());
		sa.assertTrue(mp.getRootMenu("ABOUT").isDisplayed());
		sa.assertAll();
	}

	@Test
	public void checkItemsUnderWhoWeServe(){
		
		List<String> subHeaders = Arrays.asList("Students","Instructors", "Book Authors",
				"Professionals", "Researchers", "Institutions", "Librarians", 
				"Corporations", "Societies", "Journal Editors", "Bookstores", "Government");

		MainPage mp = new MainPage(driver);

		WebElement menuItem = mp.navigateThroughMenu("WHO WE SERVE");
		List<WebElement> subMenuItems = mp.getSubmenuItems(menuItem);

		
		sa.assertEquals(subMenuItems.size(), 12); //на данный момент там 12 пунктов в меню.

		for(WebElement el : subMenuItems) {
			sa.assertTrue(subHeaders.contains(el.getText().trim()));
		}
		sa.assertAll();
	}
}
