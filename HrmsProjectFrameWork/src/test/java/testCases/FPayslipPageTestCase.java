package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.PaySlipRepo;

public class FPayslipPageTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	PaySlipRepo psr;

	@Test(groups = { "Sanity" },priority = 1, enabled = true)
	public void vrifySearchPayslipTC22() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.clickPaySlip();
		hpr.clickPaySlip();
		hpr.clickGeneratePaySlip();
		psr = new PaySlipRepo(driver);
		psr.explictWait();
		psr.clickEyeIcon();
		psr.mouseOverText();
		boolean actualMouseOverText = psr.mouseOverText();
		Assert.assertTrue(actualMouseOverText);

	}

	@Test(groups = { "Regression" },priority = 1, enabled = true)
	public void verifyDownloadButtonTC23() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.clickPaySlip();
		hpr.clickPaySlip();
		hpr.clickGeneratePaySlip();
		psr = new PaySlipRepo(driver);
		psr.explictWait();
		String payrollTitle = hpr.getPageTitle();
		psr.clickDownLoadButton();
		String printPageTilte = hpr.getPageTitle();
		Assert.assertNotSame(payrollTitle, printPageTilte);
	}
}
