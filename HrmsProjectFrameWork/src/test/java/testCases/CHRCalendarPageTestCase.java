package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HRCalendarPageRepo;
import elementRepository.HolidayPageRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class CHRCalendarPageTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	HRCalendarPageRepo hrcalpr;
	HolidayPageRepo holidaypr;

	@Test(groups = { "Regression" },priority = 9,enabled=true)
	public void verifyHRCalendarHolidaysTC13() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.clickHRCalendrar();
		hrcalpr = new HRCalendarPageRepo(driver);
		holidaypr = new HolidayPageRepo(driver);
		hrcalpr.clickNextMonthButton();
		hrcalpr.hrCalendarDragandDrop();
		holidaypr.selectCompanyDropDown();
		holidaypr.enterEventName("Family Function");
		holidaypr.selectStartDate("20220613");
		holidaypr.selectEndDate("20220613");
		holidaypr.enterDescription("1 day leave");
		holidaypr.selectStatusDropDown();
		holidaypr.clickSave();
		String actualAttributeValueAfterDragNDrop = hrcalpr.getCalenderAttributevalue();
		String expectedAttributeValueAfterDragNDrop = "fc-title";
		Assert.assertEquals(actualAttributeValueAfterDragNDrop, expectedAttributeValueAfterDragNDrop,
				"Holiday dropdwn not worked as expected");

	}
	@Test(groups = { "Smoke" },priority = 10,enabled=true)
	public void verifyHRHolidaysTagNameTC14() throws IOException {
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername(lpr.xlStringReadCredentials(1, 0));
		lpr.enterPassword(lpr.xlIntReadCredential(1, 1));
		lpr.clickLogin();
		hpr.clickHRCalendrar();
		hrcalpr = new HRCalendarPageRepo(driver);
		holidaypr = new HolidayPageRepo(driver);
		String actualTagName=hrcalpr.getHolidayTagName();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualTagName, CONSTANT.expHolidayTagName,"Different tag name");
		softassert.assertAll();
		
	}
}
