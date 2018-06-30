package Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class workingwithChrome {
	
	//creta intace of chrome driver
	
	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			
		driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");
		
	}

}
