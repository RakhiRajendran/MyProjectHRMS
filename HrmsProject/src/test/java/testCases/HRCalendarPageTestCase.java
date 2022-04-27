package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HRCalendarPageRepo;
import elementRepository.HolidayPageRepo;
import elementRepository.HomePageRepo;
import elementRepository.LoginPageRepo;

public class HRCalendarPageTestCase extends BaseClass {
	LoginPageRepo lpr;
	HomePageRepo hpr;
	HRCalendarPageRepo hrcalpr;
	HolidayPageRepo holidaypr;

	@Test
	public void verifyHRCalendarHolidaysTC01(){
		lpr = new LoginPageRepo(driver);
		hpr = new HomePageRepo(driver);
		lpr.enterUsername("admin");
		lpr.enterPassword("123456");
		lpr.clickLogin();
		hpr.clickHRCalendrar();
		hrcalpr = new HRCalendarPageRepo(driver);
		holidaypr = new HolidayPageRepo(driver);
		hrcalpr.clickNextMonthButton();
		hrcalpr.hrCalendarDragandDrop();
		holidaypr.selectCompanyDropDown();
		holidaypr.enterEventName("Family Function");
		holidaypr.selectStartDate("20220513");
		holidaypr.selectEndDate("20220513");
		holidaypr.enterDescription("1 day leave");
		holidaypr.selectStatusDropDown();
		holidaypr.clickSave();
		String actualAttributeValueAfterDragNDrop = hrcalpr.getCalenderAttributevalue();
		String expectedAttributeValueAfterDragNDrop = "fc-title";
		Assert.assertEquals(actualAttributeValueAfterDragNDrop, expectedAttributeValueAfterDragNDrop,
				"Holiday dropdwn not worked as expected");

	}
}
