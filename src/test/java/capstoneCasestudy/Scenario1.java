package capstoneCasestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scenario1 {
	
	WebDriver driver;
	
	@FindBy(xpath ="//*[@id=\"menu-item-10\"]/a") WebElement contactbutton;
	@FindBy(xpath ="//*[@id=\"g3-name\"]") WebElement namefield;
	@FindBy(xpath ="//*[@id=\"g3-email\"]") WebElement emailfield;
	@FindBy(xpath ="//*[@id=\"contact-form-comment-g3-message\"]") WebElement commentfield;
	@FindBy(xpath ="//*[@id=\"contact-form-3\"]/form/div/div[4]/button") WebElement submitbutton;
	@FindBy(xpath ="//*[@id=\"contact-form-success-header\"]") WebElement verifymsg;


	
	public Scenario1(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifytitle() {
		
	      String actualtitle = driver.getTitle();
		
		Assert.assertEquals(actualtitle, "Want to practice test automation? Try these demo sites! | Automation Panda");
	}
	
	public void clickContact() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		contactbutton.click();
	}
	
	public void enterInfo (String name, String email, String comment) {
		
		contactbutton.click();
		namefield.sendKeys(name);
		emailfield.sendKeys(email);
		commentfield.sendKeys(comment);
		submitbutton.click();
	}

	public void verifymessage() {
		
		Assert.assertEquals(verifymsg.getText(), "Your message has been sent");
	}
}
