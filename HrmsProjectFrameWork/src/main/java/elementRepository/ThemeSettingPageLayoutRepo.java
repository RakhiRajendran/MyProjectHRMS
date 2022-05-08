package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class ThemeSettingPageLayoutRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ThemeSettingPageLayoutRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='page_header']")
	WebElement pageHeader;
	@FindBy(xpath = "//select[@name='footer_layout']")
	WebElement footerLayout;
	@FindBy(xpath = "//select[@name='statistics_cards']")
	WebElement staticsCard;
	@FindBy(xpath = "//select[@name='animation_style']")
	WebElement headerAnimation;
	@FindBy(xpath = "//select[@name='theme_option']")
	WebElement template;
	@FindBy(xpath = "//select[@name='dashboard_option']")
	WebElement adminDashboard;
	@FindBy(xpath = "//select[@name='login_page_options']")
	WebElement loginPageOption;
	@FindBy(xpath = "//input[@name='dashboard_calendar']")
	WebElement calender;
	@FindBy(xpath = "//div[@class='pull-xs-left m-r-1']//i[@class='fa fa-circle-o']")
	WebElement subMenuIcon;
	@FindBy(xpath = "//div[@class='row']//div[@class='col-md-12']//div[@class='form-group']//div[@class='form-actions box-footer']//button[@class='btn btn-primary']//i[@class='fa fa-check-square-o']")
	WebElement saveButton;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement waitThemePage;

	public void pageHeaderDropDown(String item) {
		gu.dropDownFunction(driver, pageHeader, item);
	}

	public void footerDropDown(String item) {
		gu.dropDownFunction(driver, footerLayout, item);
	}

	public void cardDropDown(String item) {
		gu.dropDownFunction(driver, staticsCard, item);
	}

	public void animationDropDown(String item) {
		gu.dropDownFunction(driver, headerAnimation, item);
	}

	public void templateDropDown(String item) {
		gu.dropDownFunction(driver, template, item);
	}

	public void adminDropDown(String item) {
		gu.dropDownFunction(driver, adminDashboard, item);
	}

	public void loginPageDropDown(String item) {
		gu.dropDownFunction(driver, loginPageOption, item);
	}

	public void clickCalender() {
		calender.click();
	}

	public void clickSubMenu() {
		subMenuIcon.click();

	}

	public boolean isSelectedradio() {
		return subMenuIcon.isSelected();

	}

	public void clickpageLayoutSaveButton() {
		saveButton.click();
	}

	public void explictWait() {
		wu.explictWaitVisibility(driver, waitThemePage);
	}

}
