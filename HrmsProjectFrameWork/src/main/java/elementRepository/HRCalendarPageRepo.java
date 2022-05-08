package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;

public class HRCalendarPageRepo {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HRCalendarPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='fc-next-button btn btn-primary']")
	WebElement nextMonthButton;

	@FindBy(xpath = "//button[@class='fc-prev-button btn btn-primary']")
	WebElement prevMonthButton;

	@FindBy(xpath = "//span[text()=' Holidays']")
	WebElement sourceHoliday;

	@FindBy(xpath = "//a[@data-goto='{\"date\":\"2022-06-15\",\"type\":\"day\"}']")
	WebElement destinationHoliday;

	@FindBy(xpath = "//span[@class='fc-title']")
	WebElement destinationAfterDragNDrop;

	public void clickNextMonthButton() {
		nextMonthButton.click();
	}

	public void clickPrevMonthButton() {
		prevMonthButton.click();
	}

	public void hrCalendarDragandDrop() {
		gu.dragAndDropFunction(driver, sourceHoliday, destinationHoliday);
	}

	public String getCalenderAttributevalue() {
		return gu.getElementAttributeValue(destinationAfterDragNDrop, "class");
	}
	public String getHolidayTagName() {
		return sourceHoliday.getTagName();
	}
}
