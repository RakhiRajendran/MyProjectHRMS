package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class AddNewEmployeeRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public AddNewEmployeeRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement wait;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@name='employee_id']")
	WebElement empId;
	@FindBy(xpath = "//input[@name='date_of_joining']")
	WebElement dateOfJoining;
	@FindBy(xpath = "//div[@class='form-body']//select[@name='company_id']")
	WebElement company;
	@FindBy(xpath = "//div[@id='department_ajax']//select[@name='department_id']")
	WebElement department;
	@FindBy(xpath = "//div[@id='designation_ajax']//select[@name='designation_id']")
	WebElement designation;
	@FindBy(xpath = "//select[@id='aj_location_id']")
	WebElement location;
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='date_of_birth']")
	WebElement dob;
	@FindBy(xpath = "//input[@name='contact_no']")
	WebElement phno;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='confirm_password']")
	WebElement conpassword;
	@FindBy(xpath = "//select[@name='role']")
	WebElement role;
	@FindBy(xpath = "//select[@name='gender']")
	WebElement gender;
	@FindBy(xpath = "//select[@name='office_shift_id']")
	WebElement shift;
	@FindBy(xpath = "//select[@name='leave_categories[]']")
	WebElement leave;
	@FindBy(xpath = "//input[@name='address']")
	WebElement address;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement save;

	public void enterFirstName(String fn) {
		firstName.sendKeys(fn);
	}

	public void enterlastName(String fn) {
		lastName.sendKeys(fn);
	}

	public void enterEmpId(String fn) {
		empId.sendKeys(fn);
	}

	public void selectJoiningDate(String startdate) {
		dateOfJoining.sendKeys(startdate);
	}

	public void password(String n) {
		password.sendKeys(n);
	}

	public void enterConpassword(String n) {
		conpassword.sendKeys(n);
	}

	public void selectCompany(String item) {
		gu.dropDownFunction(driver, company, item);
	}

	public void selectLocationy(String item) {
		gu.dropDownFunction(driver, location, item);
	}

	public void selectDepartment(String item) {
		gu.dropDownFunction(driver, department, item);
	}

	public void selectDesignation(String item) {
		gu.dropDownFunction(driver, designation, item);
	}

	public void enterUserName(String n) {
		username.sendKeys(n);
	}

	public void enterEmail(String n) {
		email.sendKeys(n);
	}

	public void enterAddress(String n) {
		address.sendKeys(n);
	}

	public void selectRole(String item) {
		gu.dropDownFunction(driver, role, item);
	}

	public void selectLeave(String item) {
		gu.dropDownFunction(driver, leave, item);
	}

	public void enterdob(String n) {
		dob.sendKeys(n);
	}

	public void enterphno(String n) {
		phno.sendKeys(n);
	}

	public void selectGender(String item) {
		gu.dropDownFunction(driver, gender, item);
	}

	public void selectShift(String item) {
		gu.dropDownFunction(driver, shift, item);
	}

	public void clickSave() {
		save.click();
	}

	public void explictWait() {
		wu.explictWaitVisibility(driver, wait);
	}
	
}