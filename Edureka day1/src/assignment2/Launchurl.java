package assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launchurl {

	WebDriver driver;
	String titel;

	public void openapp(String browserType) {

		// Step 1: launching any browser

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
			System.err.println("Invalid Browser");
		}

		// Step2 : Maximize the window
		driver.manage().window().maximize();

		// Step 3: open edureka URL
		driver.get("https://www.edureka.co");

		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);

	}

	public void elements() {

		driver.findElement(By.id("homeSearchBarIcon")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);

		// driver.findElement(By.name("user_v1[query]")).sendKeys("Testing");

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//input[@value='m']")).click();

		driver.findElement(By.xpath("//li[@class='ga-instructor']")).click();

		// fill the form

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name ='first_name']")).sendKeys("Testone");
		driver.findElement(By.xpath("//input[@placeholder ='Company Name*']")).sendKeys("ABCD");
		driver.findElement(By.name("email")).sendKeys("123456@gmail.com");
		driver.findElement(By.xpath("//input[@type ='tel']")).sendKeys("+919901097051");

		// Drop down
		driver.findElement(By.xpath("//option[@value ='10-20']")).click();

		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);
	}

	public void navigation() {

		System.out.println("******Now we will do navigation*******");

		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);

		driver.navigate().back();

		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);

		driver.navigate().forward();
		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);
	}

	public void close() {
		driver.quit();
		
	}
}
