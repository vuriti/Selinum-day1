package assigment3;

import java.util.concurrent.TimeUnit;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Workingmethods {

	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	//LocalDateTime now = LocalDateTime.now();


	WebDriver driver;

	public void openbrowser(String browserType) {

		// Step 1: Launching the Browser

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
		
		System.out.println("****************Start******************");

	}

	public void openurl() {

		// step2 :2.Set the Selenium page loadtimeout after launching the browser. This
		// timeout will be applicable to any page load
		
		System.out.println("****************Open URL start******************");

		//System.out.println("current time:" + dtf.format(now));
		
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//System.out.println("current time after Page load Time out:" + dtf.format(now));

		// Step3 : Navigate to “https://www.edureka.co/”
		
		driver.manage().deleteAllCookies();

		driver.navigate().to("https://www.edureka.co/");

		// step 4: Maximize the Browser Window

		driver.manage().window().maximize();
		
		System.out.println("******************Open URL END**************************");

	}

	public void actionsonapp() {

		System.out.println("******************actions app start ****************");
		//System.out.println("current time:" + dtf.format(now));
		
		// step 5: Set implicit wait for all the activities on the browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//System.out.println("current time after implicit wait:" + dtf.format(now));
		
		System.out.println("******************************************");
		
		//System.out.println("current time:" + dtf.format(now));
		
		//Step 6:Set selenium script timeout and execute any asynchronous script (Ex: window.setTimeout(arguments[arguments. Length-1], 500);)to validate the  script timeout

	driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		//System.out.println("current time after script time out:" + dtf.format(now));
		
		//Step :7.Search for “Selenium” course in the search box and press “Enter”
		
	WebElement serch = driver.findElement(By.id("homeSearchBar"));
	
	serch.sendKeys("Selenium");
	serch.sendKeys(Keys.ENTER);	
	
	//Step : 8.Add explicit wait for page to navigate to selenium course and click on the course

	//System.out.println("current time :" + dtf.format(now));
	WebDriverWait wait = new WebDriverWait(driver,10);
	
 wait.until(ExpectedConditions.presenceOfElementLocated(By.className("courseimgsecgrid")));
 
 //System.out.println("current time after explicite out:" + dtf.format(now));
	
	driver.findElement(By.className("courseimgsecgrid")).click();
	
	
//step9 :	Wait for the whole selenium course page to be loaded and get the title of the page	
	
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	
	String titel = driver.getTitle();
	System.out.println("The Current Page is"+ titel );
	
	//Step 10:10.Validate the page title to be “Selenium 3.0 WebDriver Online Training”
	
	if(titel.contains("isSelenium 3.0")) {
		
		System.out.println("Test is Pass");
	} else {
		System.out.println("Test is Failed");
	}
	
	
	//11.Navigate back to the previous page
	
	driver.navigate().back();
	
	//12.Wait for whole page to be loaded and now select “All courses” from the menu option
	
	try {
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	System.out.println("Current Page is: " + driver.getTitle() );
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mCSB_3_container']/li[@id ='load_allcourses']")));	
	
	WebElement cource = driver.findElement(By.xpath("//div[@id='mCSB_3_container']/li[@id ='load_allcourses']"));
	//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	Actions bulider =new Actions(driver);
	
	Action seriesOfActions = bulider
			.moveToElement(cource)
			//.doubleClick(cource)
			.click(cource)
			//.doubleClick(cource)
			.build();
	seriesOfActions.perform();
	
	} catch (Exception e) {
		System.out.println("exception in all cource");
	}
		//cource.click();
	// WebDriverWait wait1 = new WebDriverWait(driver, 10);

	//wait.until(ExpectedConditions.elementToBeClickable(By.id("course-box-520")));
	 //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
	 
			 
	//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
	//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	WebElement Nextco = driver.findElement(By.xpath("//a[@data-coursename ='DevOps Masters Program']"));
	
	System.out.println(Nextco);
	
	
	
	System.out.println("Current Page is:raviteja " + driver.getTitle() );
		
			}

	public void closeurl() {
		
		System.out.println("we are closeing");
		driver.quit();
	}
	
}
