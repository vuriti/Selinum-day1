package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.xpath.internal.operations.String;

public class workingwithChrome {
	
	//creta intace of chrome driver
	
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			
		driver =new ChromeDriver();
		
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
