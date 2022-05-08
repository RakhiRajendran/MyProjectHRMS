package testCases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CoreHRAwardPageRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class ECoreHRAwardPageTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	CoreHRAwardPageRepo chrapr;

	@Test(groups = { "Smoke" },priority = 1, enabled = true)
	public void verifyAddAwardTC20() throws IOException, AWTException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		chrapr = new CoreHRAwardPageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.clickCoreHR();
		hpr.clickCoreHrAward();
		hpr.clickCoreHR();
		chrapr.explictWait();
		chrapr.clickAddAwardButon();
		chrapr.explictWaitInside();
		chrapr.selectCompanyAward("CRROTHRM");
		chrapr.explictWait();
		chrapr.selectEmployeeAward("John Smith");
		chrapr.selectAwardType("Performer of the Year");
		chrapr.dateOfAward();
		chrapr.enterGift("Watch");
		chrapr.enterCashAmount("5000");
		chrapr.enterAwardInfo("Best Employee in the team");
		chrapr.enterAwardDescription("This award is for Performance");
		chrapr.enterAwardYear("202204");
		chrapr.doneButton();
		chrapr.awardPhotoUpload();
		chrapr.clickSave();
		String actualMessage=chrapr.addalertMessageAddAward();
		Assert.assertEquals(actualMessage, CONSTANT.expAwardMessage,"Not Expected");;
		//Assert.assertSame(true, chrapr.checkFileUpload(), "File not uploaded");
	}

	@Test(groups = { "Regression" },priority = 2, enabled = true)
	public void verifyAddAwardWithOutFieldTC21() throws IOException, AWTException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		chrapr = new CoreHRAwardPageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		//hpr.explictWait();
		hpr.clickCoreHR();
		hpr.clickCoreHrAward();
		hpr.clickCoreHR();
		//chrapr.explictWait();
		chrapr.clickAddAwardButon();
		chrapr.explictWaitInside();
		chrapr.selectCompanyAward("CRROTHRM");
		//chrapr.explictWait();
		chrapr.selectEmployeeAward("Ishan Rahul");
		chrapr.selectAwardType("Performer of the Year");
		// chrapr.selectAwardDate("20220520");
		chrapr.enterGift("Watch");
		chrapr.enterCashAmount("5000");
		chrapr.enterAwardInfo("Best Employee in the team");
		chrapr.enterAwardDescription("This award is for the year 2021");
		chrapr.enterAwardYear("202204");
		chrapr.doneButton();
		chrapr.awardPhotoUpload();
		chrapr.clickSave();
		String actualAlertMessage = chrapr.alertMessageAddAward();
		String expectedAlertMessage = "The award date field is required.";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Wrong message");
	}

}
