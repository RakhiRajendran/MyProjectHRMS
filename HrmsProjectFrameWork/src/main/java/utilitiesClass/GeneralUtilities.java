package utilitiesClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

	public void dropDownFunction(WebDriver driver, WebElement element, String dropdownitem) {
		Select select = new Select(element);
		select.selectByVisibleText(dropdownitem);
		WebElement selectedValue = select.getFirstSelectedOption();
		System.out.println(selectedValue.getText());
	}

	public String pageTitleFunction(WebDriver driver) {
		return driver.getTitle();
	}

	public void mouseOverFunction(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void radioButtonFunction(WebElement element) {
		element.click();
	}

	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void keyFunction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	public void uploadFileFunction(WebDriver driver, WebElement element, String pathName) throws AWTException {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		StringSelection s = new StringSelection(pathName);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(250);

	}

	public void alertFunction(WebDriver driver, WebElement element) {
		element.click();
		driver.switchTo().alert().dismiss();
	}

	public void multipleWindowFunction(WebDriver driver, WebElement element1, WebElement element2) {
		element1.click();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}

	}

	public boolean toolTipFunction(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		return true;
	}

	public String currentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void scrollingFunctionJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,1750)");
	}

	public void scrolldownFunction(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void scrollUpFunction(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public int findColumnSize(WebDriver driver, String path) {
		List<WebElement> col = driver.findElements((By.xpath(path)));
		return col.size();
	}

	public int findRowSize(WebDriver driver, String path) {
		List<WebElement> rows = driver.findElements((By.xpath(path)));
		return rows.size();
	}

	public void clickJSFunction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	

}
