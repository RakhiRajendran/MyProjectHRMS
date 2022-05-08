package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class ALoginTestCase extends BaseClass {

	LoginPageRepo lpr;
	HomePageRepo hpr;

	@Test(groups = { "Smoke" }, priority = 1, enabled = true)
	public void verifyLoginButtonTextTC01() {
		lpr = new LoginPageRepo(driver);
		String actualLoginButtonText = lpr.getLoginButtonText();
		String expectedLoginButtonText = "Login";
		Assert.assertEquals(actualLoginButtonText, expectedLoginButtonText, "Login button text is different");
	}

	@Test(groups = { "Regression" }, priority = 2, enabled = true)
	public void verifyValidUserTC02() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualLoggedUserName = hpr.getLoggedUserNameText();
		String expectedLoggedUserName = "Welcome back, John Manuel!";
		Assert.assertEquals(actualLoggedUserName, expectedLoggedUserName, "Invalid username and password");
	}

	@Test(groups = { "Sanity" }, priority = 3, enabled = true)
	public void verifyInValidUserTC03() throws IOException {
		lpr = new LoginPageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualLoginTitle = lpr.getLoginPageTitlt();
		String expectedLoginTitle = "Demo HRMS | Log in";
		Assert.assertEquals(actualLoginTitle, expectedLoginTitle, "Logged in with Invalid username and password");
	}

	@Test(groups = { "Regression" }, priority = 4, enabled = true)
	public void verifyForgotPasswordTC04() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		String loginTitle = hpr.getPageTitle();
		lpr.clickForgotPassword();
		String forgotPasswordTitle = hpr.getPageTitle();
		Assert.assertNotSame(loginTitle, forgotPasswordTitle, "Logged are same");
	}

}
