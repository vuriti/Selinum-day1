package TestCase;

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
import Utils.ExcelConfig;
import junit.framework.Assert;

public class Edureka {
	WebDriver driver;
	Edureka_loginpage loginpage;

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
		Object[][] data = new Object[2][2];

		data[0][0] = "12132";
		data[0][1] = "132151";

		data[1][0] = "testee128@gmail.com";
		data[1][1] = "vuritikotaiah01";

		return data;

	}

	
	
	
	
	@DataProvider(name ="Exceldata")
	public Object[][]useexcel(){
		ExcelConfig config = new ExcelConfig("C:\\Users\\vurit\\eclipse-workspace\\FrameWork\\TestData\\TestData.xlsx");
		
		int rows = config.getrow(0);
		
		Object[][] data1 = new Object[rows][2];
		
		for (int i=0;i<rows;i++) {
			
			data1[i][0] = config.getdata(0, i, 0);
			data1[i][1] = config.getdata(0, i, 1);
			
		}
		return data1 ;
		
	}
	
	
	
	
	@BeforeMethod
	public void openurl() {

		Invokbrowser("chrome");

		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "Exceldata")
	public void TC_001(String user, String password) throws Throwable {

		System.out.println("Test 1 statrs");

		loginpage = new Edureka_loginpage(driver);

		loginpage.waittimepg1();
		loginpage.loginclick();
		loginpage.waittimeuser();
		loginpage.username(user);
		loginpage.password(password);
		loginpage.submitbutton();

		Thread.sleep(3000);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement profile = driver.findElement(By.xpath("//span[@class='webinar-profile-name']"));

		boolean homepage = profile.isDisplayed();
		Assert.assertEquals(true, homepage);

	}

	@AfterMethod
	public void close() {

		driver.quit();
	}
}
