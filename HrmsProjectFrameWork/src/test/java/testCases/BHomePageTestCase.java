package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.CoreHRAwardPageRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class BHomePageTestCase extends BaseClass {

	LoginPageRepo lpr;
	HomePageRepo hpr;
	CoreHRAwardPageRepo chrapr;

	@Test(groups = { "Sanity" },priority = 3, enabled = true)
	public void verifyLoggedUserNameTC05() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualLoggedUserName = hpr.getLoggedUserNameText();
		String expectedLoggedUserName = "Welcome back, John Manuel!";
		Assert.assertEquals(actualLoggedUserName, expectedLoggedUserName, "Loggedin user is different");
	}

	@Test(groups = { "Smoke" },priority = 4, enabled = true)
	public void verifyEmployeesCssValuesTC06() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualBackgroundColor = hpr.getEmployeesIconBackgroundColor();
		String expectedBackgroundColor = "#6861ce";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualBackgroundColor, expectedBackgroundColor, "BackgroundColour is different");
		softAssert.assertAll();
		String actualFontSize = hpr.getEmployeesActive2IconFontSize();
		String expectedFontSize = "8.925px";
		softAssert.assertEquals(actualFontSize, expectedFontSize, "FontSize  is different");
		softAssert.assertAll();
		String actualFontFamily = hpr.getEmployeesInactive0FontFamily();
		String expectedFontFamily = "Poppins, sans-serif";
		softAssert.assertEquals(actualFontFamily, expectedFontFamily, "FontFamily  is different");
		softAssert.assertAll();
	}

	@Test(groups = { "Sanity" },priority = 5, enabled = true)
	public void verifyRolesPermissionAttributeValuesTC07() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualRolesAttributevalue = hpr.getRolePermissionAttributevalue();
		String expectedRolesAttributevalue = "http://hrm.qabible.in/hrms/admin/roles";
		Assert.assertEquals(actualRolesAttributevalue, expectedRolesAttributevalue, "Attribute value is different");

	}

	@Test(groups = { "Regression" },priority = 6, enabled = true)
	public void verifyLeaveManagementTagNameTC08() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualLeaveManagementTagName = hpr.getleaveManagementTagName();
		String expectedLeaveManagementTagName = "span";
		Assert.assertEquals(actualLeaveManagementTagName, expectedLeaveManagementTagName, "Tag Name is different");

	}

	@Test(groups = { "Smoke" },priority = 7, enabled = true)
	public void verifyHRMSSettingAttributeValueTC09() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		String actualHRMSSettingAttributeValue = hpr.getHrmsSettingAttributeValue();
		String expectedHRMSSettingAttributeValue = "text-muted";
		Assert.assertEquals(actualHRMSSettingAttributeValue, expectedHRMSSettingAttributeValue,
				"Attribute value is different");
	}

	@Test(groups = { "Sanity" },priority = 8, enabled = true)
	public void verifyHomePageTitleTC10() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		String actualPageTilte = hpr.getPageTitle();
		String expectedPageTitle = "Dashboard | Demo HRMS";
		Assert.assertEquals(actualPageTilte, expectedPageTitle, "Page title is different");
	}

	@Test(groups = { "Regression" },priority = 9, enabled = true)
	public void verifyCoreHrFootBallIconTC11() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		chrapr = new CoreHRAwardPageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.clickCoreHR();
		hpr.clickCoreHrAward();
		String actualAttributeValue = chrapr.awardAttributeValue();
		String expectedAttributeValue = "breadcrumb-item active";
		Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "You are not In CoreHR Award Page");
	}

	@Test(groups = { "Regression" },priority = 10, enabled = true)
	public void verifySignOutButtonTC12() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.mouseOverProfilePic();
		String homePageTitle = hpr.getPageTitle();
		hpr.clickSigOutButton();
		String loginPageTitle = hpr.getPageTitle();
		Assert.assertNotSame(homePageTitle, loginPageTitle);
	}

}
