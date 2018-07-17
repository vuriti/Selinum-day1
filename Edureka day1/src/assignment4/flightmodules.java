package assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class flightmodules {

	WebDriver driver;
	
	public void openbrowser(String browserType) {

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

	}

	public void launchurl() {

		System.out.println("*********************Step 1: Launching URL**********************");

		driver.get("https://www.goindigo.in/?linkNav=home_header");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		System.out.println("Current Page is : " + driver.getTitle());

		System.out.println("*******************Step1: Completed****************************");

	}

	public void search() {
		System.out.println("***************************Step2: search flight******************");

		WebElement trip = driver.findElement(By.xpath("//li[@class='current']/a[@class='one-way-tab bw-trip-tabs']"));
		trip.click();

		// System.out.println("***Mange the infromation POP UP***");

		//driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

		//String pop = driver.findElement(By.xpath("//div[@class ='modal-header2']//h4[@class ='modal-title' and @aria-live = 'polite']")).getText();

		//System.out.println("popup text :" + pop);
		
		//Actions action = new Actions(driver);

	 driver.findElement(By.xpath("//*[@id=\"globalModal\"]/div/div/div[3]/button")).click();
		
		
		//action.moveToElement(popup);		
		//action.doubleClick(popup);
		
		//popup.click();


	}

}
