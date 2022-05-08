package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class PaySlipRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public PaySlipRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@id='xin_table']//tbody//tr[1]//td[1]//span[@data-original-title='View']")
	WebElement eyeIcon;
	@FindBy(xpath = "//span[@class='fa fa-download']")
	WebElement downLoadButton;

	public void clickEyeIcon() {
		eyeIcon.click();
	}

	public boolean mouseOverText() {
		return gu.toolTipFunction(driver, eyeIcon);
	}

	public void explictWait() {
		wu.explictWaitVisibility(driver, eyeIcon);
	}

	public void clickDownLoadButton() {
		downLoadButton.click();
	}
}
