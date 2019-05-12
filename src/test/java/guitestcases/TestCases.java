package guitestcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

public class TestCases extends BaseTestCase{

	@Test
	public void checkLinksOnTopMenuDisplayed() {
		SoftAssert sa = new SoftAssert();

		MainPage mp = new MainPage(driver);

		sa.assertTrue(mp.getRootMenu("WHO WE SERVE").isDisplayed());
		sa.assertTrue(mp.getRootMenu("SUBJECTS").isDisplayed());
		sa.assertTrue(mp.getRootMenu("ABOUT").isDisplayed());
		sa.assertAll();
	}

	@Test
	public void checkItemsUnderWhoWeServe(){

		SoftAssert sa = new SoftAssert();

		List<String> subHeaders = Arrays.asList("Students","Instructors", "Book Authors",
				"Professionals", "Researchers", "Institutions", "Librarians", 
				"Corporations", "Societies", "Journal Editors", "Bookstores", "Government");

		MainPage mp = new MainPage(driver);

		WebElement menuItem = mp.navigateThroughMenu("WHO WE SERVE");
		List<WebElement> subMenuItems = mp.getSubmenuItems(menuItem);

		
		sa.assertEquals(subMenuItems.size(), 11); //на данный момент там 12 пунктов в меню.

		for (WebElement el : subMenuItems) {
			sa.assertTrue(subHeaders.contains(el.getText().trim()), "Элемент " + el.getText() + " отсутствует.");
		}
		sa.assertAll();
	}

}
