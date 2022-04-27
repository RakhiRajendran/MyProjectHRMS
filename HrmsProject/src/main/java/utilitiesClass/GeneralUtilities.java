package utilitiesClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}

	public String getElementBackgroundColour(WebElement element) {
		String cssBackgroundColor = Color.fromString(element.getCssValue("background-color")).asHex();
		return cssBackgroundColor;
	}

	public String getElementCSSValues(WebElement element, String cssv) {
		String cssvalue = element.getCssValue(cssv);
		return cssvalue;
	}

	public String getElementAttributeValue(WebElement element, String av) {
		String elementAttributeValue = element.getAttribute(av);
		return elementAttributeValue;
	}

	public String getElementTagName(WebElement element) {
		String elementTagName = element.getTagName();
		return elementTagName;
	}

	public void dragAndDropFunction(WebDriver driver, WebElement Source, WebElement Destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(Source, Destination).perform();

	}
	public void dropDownFunction(WebDriver driver, WebElement element,String dropdownitem)
	{
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(dropdownitem);
		
	}
	

			
	
}
