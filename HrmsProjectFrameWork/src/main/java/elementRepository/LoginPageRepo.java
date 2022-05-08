package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;
import utilitiesClass.XLReadUtility;

public class LoginPageRepo {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	XLReadUtility xlu = new XLReadUtility();

	public LoginPageRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "iusername")
	WebElement userName;
	@FindBy(id = "ipassword")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath = "//a[@class='d-block small']")
	WebElement forgotPassword;

	public void enterUsername(String user) {
		userName.sendKeys(user);
	}

	public void enterPassword(String passwords) {
		password.sendKeys(passwords);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void clickForgotPassword() {
		forgotPassword.click();
	}

	public String getLoginButtonText() {
		return gu.getElementText(loginButton);
	}

	public String getLoginPageTitlt() {
		return gu.pageTitleFunction(driver);
	}

	public String xlStringReadCredentials(int row, int col) throws IOException {
		return xlu.stringDataRead(row, col);
	}

	public String xlIntReadCredential(int row, int col) throws IOException {
		return xlu.integerDataRead(row, col);
	}
}
