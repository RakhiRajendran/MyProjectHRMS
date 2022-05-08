package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class ThemeSettingRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ThemeSettingRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-profile-block='notification']")
	WebElement notification;
	@FindBy(xpath = "//a[@data-profile-block='form_design']")
	WebElement formDesign;
	@FindBy(xpath = "//a[@data-profile-block='org_chart']")
	WebElement orgChart;

	public void clickNotification() {
		notification.click();
	}

	public void clickFormDesign() {
		formDesign.click();
	}

	public void clickOrgChart() {
		orgChart.click();

	}
}
