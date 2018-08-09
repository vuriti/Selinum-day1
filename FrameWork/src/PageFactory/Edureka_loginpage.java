package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edureka_loginpage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='signin pull-right top-signin']")
	WebElement loginbutton;

	@FindBy(xpath = "//input[@id='inputName']")
	WebElement userid;

	@FindBy(xpath = "//input[@id='pwd1']")
	WebElement password;

	@FindBy(xpath = "//div[@class ='forgotpasssec']//button[@type='submit']")
	WebElement submitbutton;

	public Edureka_loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waittimepg1() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));

	}
	
	public void waittimeuser() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(userid));

	}


	public void loginclick() {
		loginbutton.click();
	}
	
	public void username(String user) {
		
		userid.sendKeys(user);
	}
	
	public void password(String pass) {
		
		password.sendKeys(pass);
		
		}
	
	public void submitbutton() {
		
		submitbutton.click();
	}

}
