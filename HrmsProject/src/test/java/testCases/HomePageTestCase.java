package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class HomePageTestCase extends BaseClass {

	LoginPageRepo lpr;
	HomePageRepo hpr;

	@Test(priority = 1, enabled = true)
	public void verifyLoggedUserNameTC01() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		String actualLoggedUserName = hpr.getLoggedUserNameText();
		String expectedLoggedUserName = "Welcome back, John Manuel!";
		Assert.assertEquals(actualLoggedUserName, expectedLoggedUserName, "Loggedin user is different");
	}

	@Test(priority = 2, enabled = true)
	public void verifyEmployeesCssValuesTC02() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
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

	@Test(priority = 3, enabled = true)
	public void verifyRolesPermissionAttributeValuesTC03() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		String actualRolesAttributevalue = hpr.getRolePermissionAttributevalue();
		String expectedRolesAttributevalue = "http://hrm.qabible.in/hrms/admin/roles";
		Assert.assertEquals(actualRolesAttributevalue, expectedRolesAttributevalue, "Attribute value is different");

	}

	@Test(priority = 4, enabled = true)
	public void verifyLeaveManagementTagNameTC04() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		String actualLeaveManagementTagName = hpr.getleaveManagementTagName();
		String expectedLeaveManagementTagName = "span";
		Assert.assertEquals(actualLeaveManagementTagName, expectedLeaveManagementTagName, "Tag Name is different");

	}

	@Test(priority = 5, enabled = true)
	public void verifyHRMSSettingAttributeValueTC05() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		String actualHRMSSettingAttributeValue = hpr.gethrmsSettingAttributeValue();
		String expectedHRMSSettingAttributeValue = "text-muted";
		Assert.assertEquals(actualHRMSSettingAttributeValue, expectedHRMSSettingAttributeValue,
				"Attribute value is different");
	}

	@Test(priority = 6, enabled = true)
	public void verifyHomePageTitleTC06() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		
		WebDriverWait explictWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explictWait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='stamp-hrsale-4 stamp-hrsale-md bg-hrsale-secondary mr-3']")));
		
		String actualPageTilte = hpr.getHomePageTitle();
		String expectedPageTitle = "Dashboard | Demo HRMS";
		Assert.assertEquals(actualPageTilte, expectedPageTitle, "Page title is different");

	}

	@Test(priority = 7, enabled = true)
	public void verifyTrainingsDragNDropTC07() {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		//hpr.homePageDragandDrop();
		

	}

}
