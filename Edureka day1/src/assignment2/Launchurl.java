package assignment2;

import org.openqa.selenium.chrome.ChromeDriver;

public class Launchurl {
	
	ChromeDriver driver;
	
	public void openapp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.edureka.co");
		driver.close();
		driver.quit();
		
	}
	

}
