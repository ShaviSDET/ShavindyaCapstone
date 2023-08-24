package capstoneCasestudy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Scenario2 {
	
WebDriver driver;
	
	@FindBy(xpath ="/html/body/div[2]/div/div/button") WebElement popupbtnclose;
	@FindBy(xpath ="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input") WebElement searchfield;
	@FindBy(xpath ="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button") WebElement searchbtn;
	@FindBy(xpath ="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]") WebElement searchresult;
//	@FindBy(xpath ="//*[@id=\"g3-email\"]") WebElement emailfield;
//	@FindBy(xpath ="//*[@id=\"contact-form-comment-g3-message\"]") WebElement commentfield;
//	@FindBy(xpath ="//*[@id=\"contact-form-3\"]/form/div/div[4]/button") WebElement submitbutton;
//	@FindBy(xpath ="//*[@id=\"contact-form-success-header\"]") WebElement verifymsg;


	
	public Scenario2(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickpopupclose() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		popupbtnclose.click();
	}
	
	
	public void verifytitle() {
		
	      String actualtitle = driver.getTitle();
		
		Assert.assertEquals(actualtitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	public void searchiphone(String phonename) {
		searchfield.sendKeys(phonename);
		searchbtn.click();
	}
	
	public void numberofresults() {
		List<WebElement> items = driver.findElements(By.className("_4rR01T"));
		System.out.println("Number of Results:" + items.size());
	}
	
	public void clickresult() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		searchresult.click();
		
	}
	
	public void verifynewtitle() {
		
	      String actualtitle = driver.getTitle();
		
		Assert.assertEquals(actualtitle, "Iphone 14- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
	}
	
}



