package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class EmployeeReportRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public EmployeeReportRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement empRepopgbreadcrum;

	@FindBy(xpath = "//div[@id='xin_table_filter']//input[@type='search']")
	WebElement empReportSearch;
	@FindBy(xpath = "//span[text()='PDF']")
	WebElement pdf;

	public void explictWait() {
		wu.explictWaitVisibility(driver, empRepopgbreadcrum);
	}

	public void explictPdfWait() {
		wu.explictWaitVisibility(driver, pdf);
	}

	public void explictSearchWait() {
		wu.explictWaitVisibility(driver, empReportSearch);
	}

	public void searchReport(String s) {
		empReportSearch.sendKeys(s);
	}

	public void pdfClick() {
		pdf.click();
	}
}
