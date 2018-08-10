package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Userhomepage {
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav home-login hidden-sm hidden-xs']//a[@href ='/blog/all/']")
	WebElement blog ;
	@FindBy(xpath ="//input[@id='search-inp']")
	WebElement serach;
	@FindBy(xpath ="//i[@class='icon-search search_ico submit-ico-button search-button-top']")
	WebElement serachbutton;
	@FindBy(xpath ="//a[@class='content-tab interviewclick']")
	WebElement interview;
	
	
	WebDriver driver;
	
	public Userhomepage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void wiatblog() {
		
				
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(blog));
		
	}
	
	public void clickblog() {
		 blog.click();
		//Actions actions = new Actions(driver);

		//actions.moveToElement(blog).click().perform();
	}
	
	public void waitsearch() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(serach));
		
	}
	public void editserach() {
		waitsearch();
		serach.sendKeys("Selenium");
		
	}
	
	public void clicksearch() {
		
		serachbutton.click();
		
	}
	
public void waitintervie() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(interview));
		
	}

public void clickinterview( ) {
	
	waitintervie();
	interview.click();
}
	

}
