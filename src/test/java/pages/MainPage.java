package pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{

	public MainPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "main-header-navbar")
	public WebElement pageHeader;
	
	public WebElement getRootMenu(String rootMenuItem){
		return this.pageHeader.findElement(By.xpath("//li/a[contains(text(),'" + rootMenuItem + "')]/.."));
	}
	
	public WebElement getSubMenuElement(WebElement parenItem, String subMenuItemText ){
		return parenItem.findElement(By.xpath("//li/a[contains(text(),'" + subMenuItemText + "')]"));
	} 

	public WebElement navigateThroughMenu(String text){
		//проверку, что такое элемент существует писать не буду.
		ArrayList<String> menuPath = new ArrayList<String>(Arrays.asList(text.split("-")));
		WebElement menuElement = getRootMenu(menuPath.get(0));
		menuPath.remove(0);
		
		for(String el : menuPath){
			(new Actions(driver)).moveToElement(menuElement).build().perform();
			takeScreenShot();
			menuElement = getSubMenuElement(menuElement, el);
		}
		(new Actions(driver)).moveToElement(menuElement).build().perform();
		takeScreenShot();
		return menuElement;
	}

	public List<WebElement> getSubmenuItems(WebElement parentMenuItem){
		return parentMenuItem.findElements(By.xpath(".//li"));
		 
	}

}
