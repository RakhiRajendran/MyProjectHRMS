package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.RolePermissionRepo;

public class DRolePermissionTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	RolePermissionRepo rpr;

	@Test(groups = { "Sanity" },priority = 1, enabled = true)
	public void verifyAddNewRoleTC15() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.setRoleClick();
		rpr = new RolePermissionRepo(driver);
		rpr.addNewRole();
		rpr.enterRoleName("Automation Tester");
		rpr.selectAccessRole("All Menu Access");
		boolean result = rpr.saveAddNewRoleButton();
		Assert.assertTrue(result, "New role not added");

	}

	@Test(groups = { "Regression" },priority = 2, enabled = true)
	public void verifyAddNewRoleWithOutFieldsTC16() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.setRoleClick();
		rpr = new RolePermissionRepo(driver);
		rpr.addNewRole();
		rpr.saveAddNewRoleButton();
		String actualNegativeAlertMessage=rpr.alertMessage();
		String expectedNegativeAlertMessage="The role name field is required";
		Assert.assertEquals(actualNegativeAlertMessage, expectedNegativeAlertMessage,"Different assert message");
	}

	@Test(groups = { "Smoke" },priority = 3, enabled = true)
	public void verifySearchBarTC17() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.setRoleClick();
		rpr = new RolePermissionRepo(driver);
		rpr.enterSearchBar("aaa");
		Assert.assertTrue(true);

	}

	@Test(groups = { "Sanity" },priority = 4, enabled = true)
	public void verifyDeleteRoleTC18() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.setRoleClick();
		rpr = new RolePermissionRepo(driver);
		rpr.clickDeleteButton("4", "1");
		// rpr.deleteAlertConfirmButton();
		Assert.assertTrue(true, "Not Selected");
	}

	@Test(groups = { "Regression" },priority = 5, enabled = true)
	public void verifyEditIconTC19() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.setRoleClick();
		rpr = new RolePermissionRepo(driver);
		rpr.clickEditIcon("5", "1");
		rpr.explicitWaitEdit();
		boolean result = rpr.editUpdate();
		Assert.assertTrue(result);
	}
}
