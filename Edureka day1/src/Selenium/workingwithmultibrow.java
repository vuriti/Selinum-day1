package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class workingwithmultibrow {
	
	//creta intace of chrome driver
	
	WebDriver driver;
	
	public void invokeBrowser(String browserType) {
		
		if (browserType.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			
		driver =new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Selenium Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			
			driver =new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		
		Dimension dim =new Dimension(400,600);
		
		driver.manage().window().setSize(dim);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");
		
	}
	
	public void  navigatecomands() {
		
		driver.navigate().to("http://facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public void close() {
		
		driver.close();
		driver.quit();
		
	}
	
	public java.lang.String titelofpage() {
		
		return driver.getTitle();
		
		
		
	}
}
