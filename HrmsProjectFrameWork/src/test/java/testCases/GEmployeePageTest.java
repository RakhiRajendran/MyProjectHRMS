package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.AddNewEmployeeRepo;
import elementRepository.CoreHRAwardPageRepo;
import elementRepository.EmployeeRepo;
import elementRepository.EmployeeReportRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class GEmployeePageTest extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	EmployeeRepo er;
	EmployeeReportRepo err;
	AddNewEmployeeRepo aner;

	@Test(groups = { "Smoke" },priority = 1, enabled = true)
	public void verifyAddEmployeeTC24() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.explictWait();
		hpr.clickStaffEmployee();
		er = new EmployeeRepo(driver);
		er.explictWait();
		/*
		 * int col1=er.columnNumber(); System.out.println("column no:"+col1); int
		 * row1=er.rowNumber(); System.out.println("row no "+row1);
		 */
		er.clickAddNewEmployee();
		aner = new AddNewEmployeeRepo(driver);
		aner.enterFirstName("Athira");
		aner.enterlastName("Lal");
		aner.enterEmpId("AVPATC744");
		aner.selectJoiningDate("20220503");
		aner.selectCompany("CRROTHRM");
		aner.selectLocationy("Chennai Branch");
		aner.explictWait();
		aner.selectDepartment("MD Office");
		aner.selectDesignation("Software Developer");
		aner.enterUserName("athiralal");
		aner.enterEmail("athiralal@gmail.com");
		aner.selectGender("Female");
		aner.selectShift("Morning Shift");
		aner.enterdob("20200405");
		aner.enterphno("9747594711");
		aner.password("athiralal");
		aner.enterConpassword("athiralal");
		aner.selectRole("Hr");
		aner.selectLeave("Medical");
		aner.enterAddress("Vazhayil");
		aner.clickSave();
		/*
		 * int col2=er.columnNumber(); System.out.println(col2); int
		 * row2=er.rowNumber(); System.out.println(row2);
		 */
	}

	@Test(groups = { "Sanity" },priority = 2, enabled = true)
	public void verifyFilterEmployeeTC25() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.clickStaffEmployee();
		er = new EmployeeRepo(driver);
		er.explictWait();
		er.clickFilter();
		er.fliterCompanydropDown("CRROTHRM");
		er.fliterLocationdropDown("All");
		er.fliterDeptdropDown("All");
		er.fliterDesgdropDown("All");
		er.clickGetButton();
		Assert.assertTrue(true);
	}

	@Test(groups = { "Regression" },priority = 3, enabled = true)
	public void verifyEmployeeReportTC26() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.explictWait();
		hpr.clickStaffEmployee();
		er = new EmployeeRepo(driver);
		er.explictWait();
		er.getReport();
		er.clickEmpReport();
		err = new EmployeeReportRepo(driver);
		err.explictSearchWait();
		err.searchReport("Ishan Rahul");
		err.explictSearchWait();
		err.explictPdfWait();
		err.pdfClick();
		String actualURL = er.getCurrentUrl1();
		Assert.assertEquals(actualURL, CONSTANT.expectedEmployeeReportURL, "URL is not same");
	}

}
