package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;
import elementRepository.ThemeSettingPageLayoutRepo;
import elementRepository.ThemeSettingRepo;

public class IThemeSettingPageTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	ThemeSettingRepo tsr;
	ThemeSettingPageLayoutRepo tsplr;

	@Test(groups = { "Regression" }, priority = 18, enabled = true)
	public void verifyThemeSettingPageLayoutTC30() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.clickFlowerIcon();
		hpr.clickThemeSetting();
		tsplr = new ThemeSettingPageLayoutRepo(driver);
		tsplr.explictWait();
		tsplr.pageHeaderDropDown("Breadcrumbs Light");
		tsplr.explictWait();
		tsplr.footerDropDown("Light Footer");
		tsplr.cardDropDown("4");
		tsplr.animationDropDown("fadeInDown");
		tsplr.templateDropDown("Template 1");
		tsplr.adminDropDown("Dashboard 1");
		tsplr.loginPageDropDown("Login page version 1");
		tsplr.clickSubMenu();
		boolean actualresult = tsplr.isSelectedradio();
		boolean expectedResult = false;
		SoftAssert softassert = new SoftAssert();
		softassert.assertSame(actualresult, expectedResult, "Radio button not selected");
		softassert.assertAll();
		tsplr.clickpageLayoutSaveButton();
	}
}
