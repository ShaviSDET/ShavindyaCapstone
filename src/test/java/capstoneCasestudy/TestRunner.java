package capstoneCasestudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import capstoneCasestudy.*;

public class TestRunner {
	
	public WebDriver driver;
	Scenario1 scn1;
	Scenario2 scn2;
	
	@BeforeSuite
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Documents/Capstone/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//Scenario 1
	@Test
	public void scenario1() {
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		scn1 = new Scenario1(driver);
		scn1.verifytitle();
		scn1.clickContact();
		scn1.enterInfo("Test","test@test.com","Test");
		scn1.verifymessage();
	}

	//Scenario 2
	@Test
	public void scenario2() {
		driver.get("https://www.flipkart.com");
		scn2 = new Scenario2(driver);
		scn2.clickpopupclose();
		scn2.verifytitle();
		scn2.searchiphone("iphone 14");
		scn2.numberofresults();
		scn2.clickresult();
		scn2.verifynewtitle();
		
	}
}
