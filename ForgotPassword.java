package maven_project.automation_testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ForgotPassword {
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
	

	// verify that the Forgot password is present in the login page and on clicking the link the page should open
	@Test
	public void testcase14()throws Exception {
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		if (p.forgot_pswd.isDisplayed()) {
		System.out.println("forgot password link is present in the login  page");
	}
		else {
			System.out.println("no forgot password link present on the screen ");
		}
		
		p.forgot_pswd.click();
		
		if(driver.getTitle().equalsIgnoreCase("Forgot your password?")) {
		
			System.out.println(" user is currently in the forgot password link");
	}
		else {
			System.out.println(" failed");
		}
}
	// verify that the email id option is present and it is enabled in the forgot password page
	@Test
	public void testcase15()throws Exception {
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
	
		List<WebElement> labelCount = driver.findElements(By.tagName("label"));
		
		   for(WebElement labelName : labelCount) { 
			    String name = labelName.getText();
			    System.out.println(name);
		 
			Boolean value = p.forgot_pswd_label.isEnabled();
			if (value==true) {
				System.out.println("email field is enabled");
			}
		  }
		   }
	
	  //verify that the email field accepts only a email in the valid format
	@Test
	public void testcase16() throws Exception{

		String ch = "@";
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		 
	  p.forgot_pswd_email.sendKeys("uservarsh");
	  p.Reset_password.click();
		
		 
	if(p.forgot_pswd_email.getAttribute("value").contains(ch)) {
		
		System.out.println("valid email address");
	}
	else {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"email_address-error\"]")));
		  System.out.println(e.getText());
	}
		
		 Thread.sleep(3000);
	  
	}
	
	//verify if reset my password button is clicked without engtering a email or when the email field is left blank
	
	@Test
	public void testcase17() throws Exception{
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		p.forgot_pswd_email.sendKeys("");
		p.Reset_password.click();
		
		if(p.forgot_pswd_email.getAttribute("value").isEmpty()) {
			  String actual_error = driver.findElement(By.xpath("//div[@id='email_address-error']")).getText();
			  
			  String expected_error =  "This is a required field.";
			  
			  Assert.assertEquals(actual_error, expected_error);
			  
			  Assert.assertTrue(actual_error.contains("This is a required field."));
		  
			  System.out.println("Please enter a valid email to reset the password");
				}
			  
		}
		
	//verify on entering a valid email address
	@Test
	public void testcase18() throws Exception{
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		p.forgot_pswd_email.sendKeys("varsha@gmail.com");
		p.Reset_password.click();
		
		  WebElement alert = driver.findElement(By.xpath("//div[@class = 'page messages']/div[2]/div/div/div"));
			
		  if(driver.getTitle().contains("Customer Login")) {
			  				
			    System.out.println(alert.getText()); 
		  }			
else {
			  System.out.println("failed");
		  }
		  
	}
	
@AfterTest
public void closeApp() {
	
	driver.close();
	}


}



