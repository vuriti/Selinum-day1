package seleniumelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99 {

	ChromeDriver driver;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		// Dimension dim =new Dimension(400,600);

		// driver.manage().window().setSize(dim);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/v4/");

	}

	public void login(String Uid, String pass) {

		WebElement Uid1 = driver.findElement(By.name("uid"));
		Uid1.sendKeys(Uid);

		WebElement Pass1 = driver.findElement(By.name("password"));
		Pass1.sendKeys(pass);

		driver.findElement(By.name("btnLogin")).click();

		System.out.println("Page name is " + driver.getTitle());

	}

	public void closeweb() {
		driver.quit();
	}

	public void newcustomer() {

		driver.findElementByLinkText("New Customer").click();

		driver.findElement(By.name("name")).sendKeys("Ravi");
		driver.findElement(By.xpath("//input[@value='m']")).click();
		driver.findElement(By.id("dob")).sendKeys("08/13/1990");
		driver.findElement(By.name("addr")).sendKeys("Mamilla palli ");
		driver.findElement(By.name("city")).sendKeys("guntur");
		driver.findElement(By.name("state")).sendKeys("AP");
		driver.findElement(By.name("pinno")).sendKeys("522318");
		driver.findElement(By.name("telephoneno")).sendKeys("9911556622");

		String email;

		long time = System.currentTimeMillis();

		email = "abc" + time + "@gmail.com";

		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys("123545");
		driver.findElement(By.name("sub")).click();

		System.out.println("Page name is " + driver.getTitle());

	}
}
