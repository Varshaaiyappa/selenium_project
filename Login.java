package maven_project.automation_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Login {

	WebDriver driver;
	@BeforeTest
	public void launchWeb() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);
		
		  WebElement SignIn = driver.findElement(By.linkText( "Sign In"));
		  SignIn.click();
		    Thread.sleep(2500);
	
	
	}
	//verify all the fields related to registration are present
	@Test
	public void testcase9() throws Exception{
		List<WebElement> labelCount = driver.findElements(By.tagName("label"));
		
		   for(WebElement labelName : labelCount) { 
			    String name = labelName.getText();
			    System.out.println(name);
		   }
		    }
	//verify after entering 
	@Test
	public void testcase10() throws Exception{
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		 
	  p.login_email.sendKeys("hanshi@gmail.com");
	  p.login_pswd.sendKeys("Hanshi@gmail?12");
		  p.SignIn.click();
		  
		  if(driver.getTitle().contains("Customer Login")==false)
		  {
			  System.out.println("login successful!!");
		  }
		  else
		  {
			 System.out.println("login unsuccessful!!");
		  }
		
	}
	
	
	@AfterTest
	public void closeApp() {
		
		driver.close();
		}
	

}
