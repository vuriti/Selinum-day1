package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class workingwithff {
	
	//creta intace of chrome driver
	
	FirefoxDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			
		driver =new FirefoxDriver();
		
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
