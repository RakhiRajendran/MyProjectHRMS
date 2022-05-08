package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class HomePageRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

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

	@FindBy(xpath = "//h5[@class='mb-1']//a[@href='http://hrm.qabible.in/hrms/admin/roles']")
	WebElement roleSetRole;

	@FindBy(xpath = "//i[@class='fa fa-futbol-o']")
	WebElement CoreHRFootball;
	@FindBy(xpath = "//a[@href='http://hrm.qabible.in/hrms/admin/awards']")
	WebElement coreHrAward;

	@FindBy(xpath = "//h5[@class='mb-1']//a[@href='http://hrm.qabible.in/hrms/admin/employees']")
	WebElement staffEmployee;

	@FindBy(xpath = "//i[@class='fa fa-asterisk']")
	WebElement flowerIcon;
	@FindBy(xpath = "//ul[@class='dropdown-menu animated fadeInDown']//a[@href='http://hrm.qabible.in/hrms/admin/theme']")
	WebElement themeSettings;
	@FindBy(xpath = "//i[@class='fa fa-calculator']")
	WebElement paySlip;
	@FindBy(xpath = "//a[@href='http://hrm.qabible.in/hrms/admin/payroll/generate_payslip']")
	WebElement generatePaySlip;
	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement profilePc;
	@FindBy(xpath = "//div[@class='info']//i[@class='fa fa-power-off']")
	WebElement signOutButton;
	@FindBy(xpath = "//ul [@class='sidebar-menu tree']//i[@class='fa fa-cog']")
	WebElement systems;
	@FindBy(xpath = "//ul[@class='dropdown-menu animated fadeInDown']//a[@href='http://hrm.qabible.in/hrms/admin/settings/email_template']")
	WebElement emailTemplate;
	@FindBy(xpath = "//div[@class='slimScrollBar']")
	WebElement scrollBar;

	public void mouseOverProfilePic() {
		gu.mouseOverFunction(driver, profilePc);
	}

	public void clickSigOutButton() {
		signOutButton.click();
	}

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

	public String getHrmsSettingAttributeValue() {
		return gu.getElementAttributeValue(hrmsSettings, "class");
	}

	public String getPageTitle() {
		return gu.pageTitleFunction(driver);
	}

	public void clickHRCalendrar() {
		hrCalendar.click();
	}

	public void explictWait() {
		wu.explictWaitVisibility(driver, leaveManagement);
	}

	public void moveToDashBoard() {
		gu.mouseOverFunction(driver, CoreHRFootball);
	}

	public void clickCoreHR() {
		CoreHRFootball.click();
	}

	public void setRoleClick() {
		roleSetRole.click();
	}

	public void clickStaffEmployee() {
		staffEmployee.click();
	}

	public void clickCoreHrAward() {
		coreHrAward.click();
	}

	public void clickFlowerIcon() {
		flowerIcon.click();
	}

	public void clickThemeSetting() {
		themeSettings.click();
	}

	public void clickPaySlip() {
		paySlip.click();
	}

	public void clickGeneratePaySlip() {
		generatePaySlip.click();
	}

	public void clickSystemIcon() {
		gu.clickJSFunction(driver, systems);
	}

	public void clickEmailTemplate() {
		gu.clickJSFunction(driver, emailTemplate);
	}

	

}
