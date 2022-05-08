package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class EmployeeRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public EmployeeRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement employee;
	@FindBy(xpath = "//button[text()=' Add New']")
	WebElement addNewEmployee;
	@FindBy(xpath = "//div[@class='box-tools pull-right']//span[@class='fa fa-filter']")
	WebElement filter;
	@FindBy(xpath = "//select[@id='filter_company']")
	WebElement filterCompany;
	@FindBy(xpath = "//select[@id='filter_location']")
	WebElement filterLocation;
	@FindBy(xpath = "//select[@id='filter_department']")
	WebElement filterDept;
	@FindBy(xpath = "//select[@id='filter_designation']")
	WebElement filterDesg;
	@FindBy(xpath = "//div[@class='col-md-1']//button[@name='hrsale_form']")
	WebElement get;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-primary dropdown-toggle']")
	WebElement report;
	@FindBy(xpath = "//a[@href='http://hrm.qabible.in/hrms/admin/reports/employees/']")
	WebElement empReport;
	@FindBy(xpath = "//li[text()='Employees Report']")
	WebElement window2;
	@FindBy(xpath = "//table[@class='datatables-demo table table-striped table-bordered dataTable no-footer']//thead//tr//th[2]")
	WebElement nameColumntable;
	@FindBy(xpath = "//table[@class='datatables-demo table table-striped table-bordered dataTable no-footer']//tr[2]")
	WebElement nameRowtable;

	public void clickAddNewEmployee() {
		addNewEmployee.click();
	}

	public void clickFilter() {
		filter.click();
	}

	public void fliterCompanydropDown(String item) {
		gu.dropDownFunction(driver, filterCompany, item);

	}

	public void fliterLocationdropDown(String item) {
		gu.dropDownFunction(driver, filterLocation, item);
	}

	public void fliterDeptdropDown(String item) {
		gu.dropDownFunction(driver, filterDept, item);
	}

	public void fliterDesgdropDown(String item) {
		gu.dropDownFunction(driver, filterDesg, item);
	}

	public void clickGetButton() {
		get.click();
	}

	public String getCurrentUrl1() {
		return gu.currentUrl(driver);
	}

	public void getReport() {
		report.click();
	}

	public void clickEmpReport() {
		gu.multipleWindowFunction(driver, empReport, window2);
		gu.currentUrl(driver);

	}

	public String getCurrentUrl2() {
		return gu.currentUrl(driver);
	}

	public void explictWait() {
		wu.waitForElementClickable(driver, employee);
	}

	public int columnNumber() {
		return gu.findColumnSize(driver,"//table[@class='datatables-demo table table-striped table-bordered dataTable no-footer']//thead//tr//th[1]");
	}

	public int rowNumber() {
		return gu.findRowSize(driver,"//table[@class='datatables-demo table table-striped table-bordered dataTable no-footer']//tr[2]");
	}

}
