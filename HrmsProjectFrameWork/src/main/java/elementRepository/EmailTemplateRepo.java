package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class EmailTemplateRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public EmailTemplateRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement wait;
	@FindBy(xpath = "//li[@id='xin_table_next']//a[text()='Next']")
	WebElement nextButton;
	@FindBy(xpath = "//li[@id='xin_table_next']")
	WebElement nextAttributeValue;
	@FindBy(xpath = "//th[text()='Status']")
	WebElement sortColumn;
	@FindBy(xpath = "//tbody//tr[3]//span[@data-original-title=\"Edit\"='Edit']")
	WebElement welcomeEmailEdit;
	@FindBy(xpath="//input[@name='name']")
	WebElement templateName;
	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement updateMessage;
	

	public void explictWait() {
		wu.explictWaitVisibility(driver, wait);
	}
	public void explictWaitNext() {
		wu.waitForElementClickable(driver, nextButton);
	}

	public void clickNext() {
		nextButton.click();
	}

	public String getAttributeValue() {
		return gu.getElementAttributeValue(nextAttributeValue, "class");
	}

	public void clickSort() {
		sortColumn.click();
	}

	public String getSortAttributeValue() {
		return gu.getElementAttributeValue(sortColumn, "class");
	}

	public void clickEditButton() {
		welcomeEmailEdit.click();
	}
	public void clearTemplateName() {
		templateName.clear();
	}
	public void enterTemplateName(String s) {
		templateName.sendKeys(s);
	}
	public void clickUpdateButton() {
		updateButton.click();
	}
	public String updateStatusMessage() {
		return updateMessage.getText();
	}
	public void scrollDownEmailTemp() {
		gu.scrollingFunctionJS(driver);
	}
}
