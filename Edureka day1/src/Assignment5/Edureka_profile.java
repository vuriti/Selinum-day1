package Assignment5;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edureka_profile {

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
		driver.manage().deleteAllCookies();

		// Step 3: open edureka URL
		driver.get("https://www.edureka.co");

		titel = driver.getTitle();

		System.out.println("The current Page is :" + titel);

	}

	public void login(String UserID, String Pass) throws Throwable {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

		Thread.sleep(5000);
		// driver.switchTo().frame("GTM-MQVFZMQ");

		WebElement login_u = driver.findElement(By.xpath("//div[@class='tab-content']//input[@id='inputName']"));

		WebElement login_p = driver.findElement(By.xpath("//div[@class='tab-content']//input[@id='pwd1']"));

		System.out.println(login_u.isDisplayed());

		login_u.sendKeys(UserID);

		login_p.sendKeys(Pass);

		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String name = driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).getText();

		System.out.println(" user loged in with name : " + name);

	}

	public void myprofile() throws Throwable {

		driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains (text(),'My Profile')]")).click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='professional_details']/i[@class='icon-pr-edit']")).click();

		WebElement cmpny = driver.findElement(By.xpath("//input[@name='companyName']"));

		cmpny.sendKeys("Igate1");

		Select levl = new Select(driver.findElement(By.xpath("//select[@name='currentjob']")));

		levl.selectByVisibleText("Mid management");

		Select indu = new Select(driver.findElement(By.xpath("//select[@name='currentIndustry']")));

		indu.selectByVisibleText("Internet");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='changes-saved']")));
		

		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[@for ='name' and contains (text(),'Employment types looking for *')]")));

		
		Thread.sleep(1000);
		WebElement save = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));

		save.click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		String Parent = driver.getWindowHandle();
		
		System.out.println("Window ID : "+ Parent);
		
		
		
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav home-login hidden-sm hidden-xs']//a[contains(text(),'Blog')]")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Set<String> allwindow =driver.getWindowHandles();
		
		System.out.println("all window count : " + allwindow.size());
		
		for (String child: allwindow) {
			
			if(!Parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				
				Thread.sleep(3000);
				
				driver.close();
			}
			
					
		}
		
		driver.switchTo().window(Parent);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains (text(),'Log Out')]")).click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	String a1=	driver.findElement(By.xpath("//a[contains(text(),'Corporate Training')]")).getText();
	
	System.out.println(a1);
			
			
		
		
		
		
	}
}
