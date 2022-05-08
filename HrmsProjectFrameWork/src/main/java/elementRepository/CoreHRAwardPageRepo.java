package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class CoreHRAwardPageRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public CoreHRAwardPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement award;
	@FindBy(xpath = "//select[@id='aj_company']")
	WebElement companyAward;
	@FindBy(xpath = "//select[@name='employee_id']")
	WebElement employeeAward;
	@FindBy(xpath = "//select[@name='award_type_id']")
	WebElement awardType;
	@FindBy(xpath = "//input[@class='form-control date hasDatepicker']")
	WebElement awardDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement addAwardMonth;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement addAwardYear;
	@FindBy(xpath="//tbody//tr[4]//td[2]//a[@class='ui-state-default']")
	WebElement addAwardDay;
	@FindBy(xpath = "//input[@name='gift']")
	WebElement awardGift;
	@FindBy(xpath = "//input[@name='cash']")
	WebElement awardCash;
	@FindBy(xpath = "//textarea[@name='award_information']")
	WebElement awardInfo;
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement awardDescription;
	@FindBy(xpath = "//input[@class='form-control d_month_year hasDatepicker']")
	WebElement awardMnthYr;
	@FindBy(xpath = "//input[@id='award_picture']")
	WebElement awardFotoUpload;
	@FindBy(xpath = "//div[@class='form-actions box-footer']//button[@class='btn btn-primary']//i[@class='fa fa fa-check-square-o']")
	WebElement awardSave;
	@FindBy(xpath = "//div[@id='accordion']//a[@class='text-dark collapsed']//button[@type='button']")
	WebElement addAward;
	@FindBy(xpath = "//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	WebElement done;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement alertMessage;
	@FindBy(xpath="//div[text()='Award added.']")
	WebElement addalertMessage;
	

	public String awardAttributeValue() {
		return gu.getElementAttributeValue(award, "class");
	}

	public void clickAddAwardButon() {
		addAward.click();
	}

	public void selectCompanyAward(String item) {
		gu.dropDownFunction(driver, companyAward, item);
	}

	public void selectEmployeeAward(String item) {
		gu.dropDownFunction(driver, employeeAward, item);
	}

	public void selectAwardType(String item) {
		gu.dropDownFunction(driver, awardType, item);
	}

	public void selectAwardDate() {
		awardDate.click();
	}
	public void selectAwardMonthDropDown(String month) {
		gu.dropDownFunction(driver, addAwardMonth,month);
	}
	public void selectAwardYearDropDown(String year) {
		gu.dropDownFunction(driver, addAwardYear, year);
	}
	public void selectAwardDay() {
		addAwardDay.click();
	}
	
	public void dateOfAward() {
		selectAwardDate();
		selectAwardMonthDropDown("Aug");
		selectAwardYearDropDown("2023");
		selectAwardDay();
	}

	public void enterGift(String giftitem) {
		awardGift.sendKeys(giftitem);
	}

	public void enterCashAmount(String cash) {
		awardCash.sendKeys(cash);
	}

	public void enterAwardInfo(String info) {
		awardInfo.sendKeys(info);
	}

	public void enterAwardDescription(String desc) {
		awardDescription.sendKeys(desc);
	}

	public void enterAwardYear(String year) {
		awardMnthYr.sendKeys(year);
	}

	public void doneButton() {
		done.click();
	}

	public void clickSave() {
		awardSave.click();
	}

	public void explictWait() {
		wu.explictWaitVisibility(driver, award);
	}

	public void explictWaitInside() {
		wu.explictWaitVisibility(driver, companyAward);
	}

	public void awardPhotoUpload() throws AWTException {
		gu.uploadFileFunction(driver, awardFotoUpload,System.getProperty("user.dir") + "\\src\\main\\resources\\Hmr awards\\images.jpg");
	}

	public boolean checkFileUpload() {
		return awardFotoUpload.isDisplayed();	
	}
	public String alertMessageAddAward() {
		return alertMessage.getText();
	}
	public String addalertMessageAddAward() {
		return addalertMessage.getText();
	}
}
