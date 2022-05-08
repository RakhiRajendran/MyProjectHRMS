package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilitiesClass.ScreenShotUtility;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
	ScreenShotUtility scrshot;
	public static Properties prop;

	public static void testBasics() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties");
		prop.load(fis);
	}

	/*
	 * @BeforeMethod
	 * 
	 * public void beforeMethod() throws IOException { testBasics();
	 * 
	 * System.setProperty(prop.getProperty("ChromeDriver"),
	 * System.getProperty("user.dir") +
	 * "\\src\\main\\resources\\Driver\\chromedriver_win32 (2)\\chromedriver.exe");
	 * driver = new ChromeDriver(); driver.get(prop.getProperty("URL"));
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
	 */

	@BeforeMethod(alwaysRun = true)

	@Parameters("Browser")
	public void beforeMethod(String Browser) throws IOException {
		testBasics();
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty(prop.getProperty("ChromeDriver"), System.getProperty("user.dir")
					+ "\\src\\main\\resources\\Driver\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Edge")) {
			System.setProperty(prop.getProperty("EdgeDriver"), System.getProperty("user.dir")
					+ "\\src\\main\\resources\\Driver\\edgedriver_win64 (2)\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)

	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.close();
	}

}
