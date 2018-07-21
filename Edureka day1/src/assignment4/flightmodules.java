package assignment4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class flightmodules {

	WebDriver driver;

	public void openbrowser(String browserType) {

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

	}

	public void launchurl() {

		System.out.println("*********************Step 1: Launching URL**********************");

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.goindigo.in/?linkNav=home_header");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		System.out.println("Current Page is : " + driver.getTitle());

		System.out.println("*******************Step1: Completed****************************");

	}

	public void search() {
		System.out.println("***************************Step2: search flight******************");

	//** selecting From	is first click on the from filed and then select the Bengalore from drop down*****//
	driver.findElement(By.xpath("//div[@id='oneWay']//input[@class='origins-value city-name-value']")).click();
	driver.findElement(By.xpath("//div[@id='oneWay']//ul[@class='city-name origin-city-name']//li[@data-val='BLR']")).click();
		
	
	//** selecting TO is first click on the TO filed and then select the Hyderabad from drop down*****//

	driver.findElement(By.xpath("//div[@id='oneWay']//input[@class='destinations-value city-name-value']")).click();
	driver.findElement(By.xpath("//div[@id='oneWay']//ul[@class='city-name dest-city-name']//li[@data-val='HYD']")).click();
		
	//************* Drop Down selection(multiple drop downs fields in one filed)***************//
	
	//Step 1: select the drop down field 
	driver.findElement(By.xpath("//div[@id='oneWay']//input[@class='count travellers-count']")).click();
	

	//Step 2: use the Selct Function
	Select adult =new Select(driver.findElement(By.xpath("//div[@id='oneWay']//div[@class='cols']//label[@class='select-wrapper']//select[@aria-label='Adult']")));
	adult.selectByVisibleText("3");

	Select child =new Select(driver.findElement(By.xpath("//div[@id='oneWay']//div[@class='cols']//label[@class='select-wrapper']//select[@aria-label='Child(2 to 12 years)']")));
	child.selectByVisibleText("2");
	
	// ******************click on search button*********************
	
	driver.findElement(By.xpath("//div[@id='oneWay']//button[contains(text(),'Search Flight')]")).click();

	}
	
	public void useofAttributes() {
		System.out.print("***************** Get Flight Details**************\n");
		
		//Getting Link count in a Page
		
		System.out.println(driver.getTitle());
		
		List<WebElement>  alllink = driver.findElements(By.xpath("//script[@src]"));
		
		System.out.println("Total number of Scr links in the page :"+alllink.size());
		
		//Getting An attribute of element
		
		WebElement Att =driver.findElement(By.xpath("//script[@id ='facebook-jssdk']"));
		
		System.out.println("Attribute:  "+Att.getAttribute("src"));
		
		
		// print all links text and attribute :
		
		
		for (WebElement link : alllink) {
			
			System.out.println("Link attribute is  : "+ link.getAttribute("src")+ "Link Text : " + link.getText());
		}
		
		
			
	}
	

	private void scrollBy(int x, int y){
		JavascriptExecutor jsEngine;
		
		String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		
		jsEngine = (JavascriptExecutor) driver;
		
		jsEngine.executeScript(jsCommand);
	}

	public void getallflights() throws InterruptedException {
		
		// Getting flight details
		
		Thread.sleep(5000);

		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		List<WebElement> Flighttime = driver.findElements(By.xpath("//div[@class='flightNum text-right']/span[1]"));
		
		List<WebElement> Flighttype = driver.findElements(By.xpath("//div[@class='flightNum text-right']/span[2]"));
		
		int a= Flighttime.size();
		
		//System.out.println(Flightlist.isEmpty());
		System.out.println(" Number flights we have from BLR to HYD are : "+ a);
		
		// get flight timings
		
		for (WebElement link : Flighttime ) {
			
			System.out.println(" flight time is : "+ link.getText());
		}
		
for (WebElement link1 : Flighttype ) {
			
			System.out.println(" flight type is : "+ link1.getText());
		}
		
	}

}
