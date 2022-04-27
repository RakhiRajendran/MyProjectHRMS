package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClass.GeneralUtilities;

public class LoginPageRepo {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

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
	@FindBy(xpath = "//a[@class='lnk-toggler']")
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
}
