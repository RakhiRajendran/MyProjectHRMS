package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;

public class HolidayPageRepo {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HolidayPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='aj_company']")
	WebElement company;
	@FindBy(xpath = "//input[@type='text']")
	WebElement eventName;
	@FindBy(xpath = "//input[@id='start_date']")
	WebElement startDate;
	@FindBy(xpath = "//input[@id='end_date']")
	WebElement endDate;
	@FindBy(xpath = "//div[@class='trumbowyg-editor']")
	WebElement description;
	@FindBy(xpath = "//select[@name='is_publish']")
	WebElement status;
	@FindBy(xpath = "//button[@class='btn btn-primary']//i[@class='fa fa-check-square-o']")
	WebElement saveButton;

	public void selectCompanyDropDown() {
		gu.dropDownFunction(driver, company, "CRROTHRM");
	}

	public void enterEventName(String eventname) {
		eventName.sendKeys(eventname);
	}

	public void selectStartDate(String startdate) {
		startDate.sendKeys(startdate);
	}

	public void selectEndDate(String enddate) {
		endDate.sendKeys(enddate);
	}
	public void enterDescription(String dis) {
		description.sendKeys(dis);
	}

	public void selectStatusDropDown() {
		gu.dropDownFunction(driver, status, "Published");
	}

	public void clickSave() {
		saveButton.click();
	}
}
