package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;

public class HomePageRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[@class='widget-user-username welcome-hrsale-user']")
	WebElement loggedUserName;

	@FindBy(xpath = "//span[@class='stamp-hrsale-4 stamp-hrsale-md bg-hrsale-secondary mr-3']")
	WebElement employeesIcon;

	@FindBy(xpath = "//span[@class='badge badge-info']")
	WebElement active2Icon;

	@FindBy(xpath = "//span[@class='badge bg-red']")
	WebElement inactive0Icon;

	@FindBy(xpath = "//a[text()=' Roles ']")
	WebElement rolesPermission;

	@FindBy(xpath = "//span[@class='stamp-hrsale-4 stamp-hrsale-md bg-hrsale-danger-4 mr-3']")
	WebElement leaveManagement;

	@FindBy(xpath = "//small[text()='Configuration']")
	WebElement hrmsSettings;
	
	@FindBy(xpath = "//a[@href='http://hrm.qabible.in/hrms/admin/calendar/hr']")
	WebElement hrCalendar;

	public String getLoggedUserNameText() {
		return gu.getElementText(loggedUserName);
	}

	public String getEmployeesIconBackgroundColor() {
		return gu.getElementBackgroundColour(employeesIcon);
	}

	public String getEmployeesActive2IconFontSize() {
		return gu.getElementCSSValues(active2Icon, "font-size");
	}

	public String getEmployeesInactive0FontFamily() {
		return gu.getElementCSSValues(inactive0Icon, "font-family");
	}

	public String getRolePermissionAttributevalue() {
		return gu.getElementAttributeValue(rolesPermission, "href");
	}

	public String getleaveManagementTagName() {
		return gu.getElementTagName(leaveManagement);
	}

	public String gethrmsSettingAttributeValue() {
		return gu.getElementAttributeValue(hrmsSettings, "class");
	}

	public String getHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickHRCalendrar() {
		hrCalendar.click();
	}
}
