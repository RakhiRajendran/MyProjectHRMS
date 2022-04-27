package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageRepo;

public class LoginTestCase extends BaseClass {

	LoginPageRepo lpr;

	@Test
	public void verifyLoginButtonTextTC01() {
		lpr = new LoginPageRepo(driver);
		String actualLoginButtonText = lpr.getLoginButtonText();
		String expectedLoginButtonText = "Login";
		Assert.assertEquals(actualLoginButtonText, expectedLoginButtonText, "Login button text is different");
	}
}
