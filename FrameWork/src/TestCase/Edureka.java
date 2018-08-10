package TestCase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.Edureka_loginpage;
import PageFactory.Userhomepage;
import Utils.ExcelConfig;
import junit.framework.Assert;

public class Edureka {
	WebDriver driver;
	Edureka_loginpage loginpage;
	Userhomepage blog;

	public void Invokbrowser(String browserType) {

		System.out.println(browserType + "Browser is opening to Run the Tests ");

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Selenium Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Selenium Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			System.err.println("invalid browser option");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		System.out.println("***** Befor Method is completed ******");

	}

	@DataProvider(name = "login")
	public Object[][] login() {
		Object[][] data = new Object[1][2];

		// data[0][0] = "12132";
		// data[0][1] = "132151";

		data[0][0] = "testee128@gmail.com";
		data[0][1] = "vuritikotaiah01";

		return data;

	}

	@DataProvider(name = "Exceldata")
	public Object[][] useexcel() {
		ExcelConfig config = new ExcelConfig("C:\\Users\\vurit\\eclipse-workspace\\FrameWork\\TestData\\TestData.xlsx");

		int rows = config.getrow(0);

		Object[][] data1 = new Object[rows][2];

		for (int i = 0; i < rows; i++) {

			data1[i][0] = config.getdata(0, i, 0);
			data1[i][1] = config.getdata(0, i, 1);

		}
		return data1;

	}

	@BeforeMethod
	public void openurl() {

		Invokbrowser("chrome");

		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	// @SuppressWarnings("deprecation")
	@Test(dataProvider = "login")
	public void TC_001(String user, String password) throws Throwable {

		System.out.println("Test 1 statrs");

		loginpage = new Edureka_loginpage(driver);
		blog = new Userhomepage(driver);

		loginpage.waittimepg1();
		loginpage.loginclick();
		loginpage.waittimeuser();
		loginpage.username(user);
		loginpage.password(password);
		loginpage.submitbutton();
		// System.out.println("step before wait for blog");
		// blog.wiatblog();
		// System.out.println("step after wait for blog");
		Thread.sleep(5000);

		String Parent = driver.getWindowHandle();
		blog.clickblog();
		// System.out.println("click blog");

		Set<String> allwindow = driver.getWindowHandles();

		System.out.println("all window count : " + allwindow.size());

		for (String child : allwindow) {

			if (!Parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());

				Thread.sleep(3000);
			}

		}
		
		blog.editserach();
		blog.clicksearch();
		blog.clickinterview();

		driver.switchTo().window(Parent);

	}

	// @AfterMethod
	public void close() {

		driver.quit();
	}
}
