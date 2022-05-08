package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.WaitUtility;

public class RolePermissionRepo {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public RolePermissionRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-xs btn-primary']")
	WebElement addNew;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement roleName;

	@FindBy(xpath = "//select[@id='role_access']")
	WebElement selectAccess;

	@FindBy(xpath = "//li[@id='treeview_r1_tv_active']/descendant::span[@class='k-icon k-plus'][1]")
	WebElement staff;

	@FindBy(xpath = "//div[@class='form-actions box-footer']//button[@class='btn btn-primary']")
	WebElement saveAddNewRole;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBar;

	@FindBy(xpath = "//table[@id='xin_table']//tbody//tr[4]//td[1]//span[@title='Delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa fa-check-square-o']")
	WebElement deleteAlertClose;

	@FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-primary']//i[@class='fa fa fa-check-square-o']")
	WebElement deleteAlertConfirm;

	@FindBy(xpath = "//table[@id='xin_table']//tbody//tr[3]//td[1]//span[@title='Edit']")
	WebElement editIcon;
	@FindBy(xpath = "//button[text()=' Update']")
	WebElement update;
	@FindBy(xpath = "//h4[@id='edit-modal-data']")
	WebElement editTitle;
	@FindBy(xpath = "//tr[@role='row']//th[@aria-label=' Added Date: activate to sort column ascending']//i[@class='fa fa-calendar']")
	WebElement sortArrowDate;
	@FindBy(xpath="//div[text()='The role name field is required']")
	WebElement alertNegativeMessage;

	public void addNewRole() {
		addNew.click();
	}

	public void enterRoleName(String rolename) {
		roleName.sendKeys(rolename);
	}

	public void selectAccessRole(String item) {
		gu.dropDownFunction(driver, selectAccess, item);
	}

	public boolean saveAddNewRoleButton() {
		saveAddNewRole.click();
		return true;
	}

	public void clickStaffPluse() throws InterruptedException {
		Thread.sleep(3000);
		staff.click();
	}

	public void enterSearchBar(String searchitem) {
		searchBar.sendKeys(searchitem);
		gu.keyFunction(driver);
	}

	public void clickDeleteButton(String tr, String td) {
		deleteButton.click();
	}

	public void deleteAlertCloseButton() {
		deleteAlertClose.click();
	}

	public boolean deleteAlertConfirmButton() {
		deleteAlertConfirm.click();
		deleteAlertConfirm.isSelected();
		return false;
		
	}

	public void clickEditIcon(String tr, String td) {
		editIcon.click();
	}

	public boolean editUpdate() {
		update.click();
		update.isEnabled();
		return true;
		
	}

	public void clickSortArrow() {
		sortArrowDate.click();
	}

	public String checkAttributevalue() {
		return gu.getElementAttributeValue(sortArrowDate, "class");
	}

	public void expilctWait() {
		wu.explictWaitVisibility(driver, sortArrowDate);
	}
	public void explicitWaitEdit() {
		wu.explictWaitVisibility(driver, editTitle);
	}
	public String alertMessage() {
		return alertNegativeMessage.getText();
	}
}
