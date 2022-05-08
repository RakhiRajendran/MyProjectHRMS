package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.EmailTemplateRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class HEmailTemplateTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	EmailTemplateRepo etr;

	@Test(groups = { "Regression" }, priority = 1, enabled = true)
	public void verifyEmailTempatePageNextButtonTC27() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.mouseOverProfilePic();
		hpr.clickSystemIcon();
		hpr.clickEmailTemplate();
		etr = new EmailTemplateRepo(driver);
		etr.scrollDownEmailTemp();
		etr.explictWaitNext();
		String attributeValueBeforeClickNext = etr.getAttributeValue();
		etr.clickNext();
		String attributeValueAfterClickNext = etr.getAttributeValue();
		Assert.assertNotEquals(attributeValueAfterClickNext, attributeValueBeforeClickNext, "Attribut value is same");
	}

	@Test(groups = { "Sanity" }, priority = 2, enabled = true)
	public void verifyEmailTempateSortingFunctionTC28() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.mouseOverProfilePic();
		hpr.clickSystemIcon();
		hpr.clickEmailTemplate();
		etr = new EmailTemplateRepo(driver);
		etr.explictWait();
		String attributeValueBeforeClick = etr.getSortAttributeValue();
		etr.clickSort();
		String attributeValueAfterClick = etr.getSortAttributeValue();
		Assert.assertNotEquals(attributeValueAfterClick, attributeValueBeforeClick, "Attribut value is same");
	}

	@Test(groups = { "Smoke" }, priority = 3, enabled = true)
	public void verifyEmailTemplateEditFunctionTC29() throws IOException, InterruptedException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.explictWait();
		hpr.mouseOverProfilePic();
		hpr.clickSystemIcon();
		hpr.clickEmailTemplate();
		etr = new EmailTemplateRepo(driver);
		etr.explictWait();
		etr.clickEditButton();
		etr.clearTemplateName();
		etr.enterTemplateName("Email Template Name");
		etr.clickUpdateButton();
		String actualUpdateMessage = etr.updateStatusMessage();
		Assert.assertEquals(actualUpdateMessage, CONSTANT.expectedEmailUpdateMessage, "Wrong message");
	}
}
