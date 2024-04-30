package maven_project.automation_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class UserRegistration {
	
	WebDriver driver;
	@BeforeTest
	public void launchWeb() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);
		
	    WebElement createacc = driver.findElement(By.linkText("Create an Account"));
	    createacc.click();
	    Thread.sleep(2500);
	    
		}
	//test case-3 : Verify all the fields related to registration are present
	@Test
	public void testcase3() throws Exception {
		
		List<WebElement> labelCount = driver.findElements(By.tagName("label"));
		
		   for(WebElement labelName : labelCount) { 
			    String name = labelName.getText();
			    System.out.println(name);
		   }
	}
	
	
	
	//test case-4 : Verify User Registration With Valid Credentials
	@Test
	public void testcase4() throws Exception {


    Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
    p.firstname.sendKeys("hanshika");
    Thread.sleep(2500);
    p.lastname.sendKeys("Aiyappa");
    Thread.sleep(2500);
    p.email.sendKeys("hanshi@gmail.com");
    Thread.sleep(2500);
    p.pass.sendKeys("Hanshi@gmail?12");
    Thread.sleep(2500);
    p.confirmpass.sendKeys("Hanshi@gmail?12");
    Thread.sleep(2500);
    p.submit.click();
    
    WebElement alert = driver.findElement(By.xpath("//div[@class = 'page messages']/div[2]/div/div/div"));
    System.out.println(alert.getText()); 
    Thread.sleep(4500);
    
    if (alert.getText().contains("There is already an account with this email address")) {
  
    	driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
    	Thread.sleep(4500);}
    	else {
    		System.out.println("new user created successfully");
    	}
    
    
    }
    
	

	@AfterTest
	public void closeApp() {
		
		driver.close();
		}
}



