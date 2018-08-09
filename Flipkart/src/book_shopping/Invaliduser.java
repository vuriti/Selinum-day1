package book_shopping;

import java.io.File;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(book_shopping.listener.class)

public class Invaliduser {

	public WebDriver driver;

	public int scc = 0;

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

	@BeforeTest
	public void openbrowser() {

		Invokbrowser("chrome");

	}

	/*
	 * 1. Open browser with Flipkart website 2.Search for a Selenium book 3.Check if
	 * it is delivered to the pin codespecified and print the duration needed 4.Add
	 * to the cart 5.While checking out, give a random email id and password
	 * 6.Capture the error message and capture the screenshot
	 */
	@Test

	public void Test_001() {

		driver.get("https://www.flipkart.com/");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		boolean Login = driver.findElement(By.xpath("//input[@class='_2zrpKA']")).isDisplayed();

		if (Login == true) {

			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		}

		String Act_title = driver.getTitle();

		String exp_title = "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";

		Assert.assertEquals(Act_title, exp_title);

	}

	@Test

	public void Test_002() throws Throwable {

		driver.get("https://www.flipkart.com/");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		//boolean Login = driver.findElement(By.xpath("//input[@class='_2zrpKA']")).isDisplayed();

		//if (Login == true) {

			//driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		//}

		// String Act_title = driver.getTitle();

		// String exp_title ="Online Shopping Site for Mobiles, Fashion, Books,
		// Electronics, Home Appliances and More";

		// Assert.assertEquals(Act_title, exp_title);

		driver.findElement(By.name("q")).sendKeys("mastering selenium webdriver 3.0");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();

		String Parentwin = driver.getWindowHandle();

		System.out.println(" Parent winow is : " + Parentwin);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title ='Mastering Selenium Webdriver 3.0']")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		Set<String> win = driver.getWindowHandles();

		for (String child : win) {

			if (!Parentwin.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);

				System.out.println(" current page is : " + driver.getTitle());

			}

		}

		driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("522318");

		driver.findElement(By.xpath("//span[@class ='_2aK_gu']")).click();

		//driver.findElement(By.xpath("//span[@class ='_3yGtFA']")).click();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);

		//String delv = driver.findElement(By.xpath("//span[@class ='kUhIIX']")).getText();

		//System.out.println(" Time for  delivary of the book : " + delv);

		//driver.findElement(By.xpath("//button[@class='_2AkmmA _2Rr3iH']")).click();

		driver.findElement(By.xpath("//button[@class ='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("Currnt Page is : " + driver.getTitle());

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _14O7kc _7UHT_c']")).click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class='_2zrpKA _14H79F']")).sendKeys("vuriti.teja128@gmail.com");

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _14H79F']")).sendKeys("9901091234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _14H79F']")).sendKeys("3215165");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']")).click();
		Thread.sleep(2000);
		String resl = driver.findElement(By.xpath("//span[@class='ZAtlA-']")).getText();

		String Exp_Res = "Your username or password is incorrect";

		Assert.assertEquals(resl, Exp_Res);

		scc = scc + 1;

		File scrsfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String name = ("D:\\selinum training\\Git HUB\\Flipkart" + scc + ".png");

		FileUtils.copyFile(scrsfile, new File(name));

		//driver.close();

		System.out.println(driver.getTitle());

	}

	
	@AfterTest

	public void Closewindow() {
		driver.close();
	}

}
