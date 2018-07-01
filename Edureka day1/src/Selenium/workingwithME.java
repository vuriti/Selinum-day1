package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;

public class workingwithME {
	
	//creta intace of chrome driver
	
	EdgeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.edge.driver","C:\\Selenium Drivers\\MicrosoftWebDriver.exe");
			
		driver =new EdgeDriver();
		
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
