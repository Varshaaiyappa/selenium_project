package maven_project.automation_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class InvalidLogin {
WebDriver driver;
	
	@BeforeMethod
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
	
		  //verify that the email field accepts only a email in the valid format
			@Test
			public void testcase11() throws Exception{

				String ch = "@";
				
				 JavascriptExecutor jse = (JavascriptExecutor) driver;
				  jse.executeScript("window.scrollBy(0, 1000)", "");
				  
				Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
				
				 
			  p.login_email.sendKeys("uservarsha");
			  p.login_pswd.sendKeys("znxn");
				  p.SignIn.click();
				
				 
			if(p.login_email.getAttribute("value").contains(ch)) {
				
				System.out.println("valid email address");
			}
			else {
				WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

				  WebElement e = webdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='email-error']")));
				  System.out.println(e.getText());
			}
				
				 Thread.sleep(3000);
	   	  
			}
			
			  //verify if no value is entered in a particular field or all fields and clicked on submit
			@Test
			public void testcase12() throws Exception{
				 JavascriptExecutor jse = (JavascriptExecutor) driver;
				  jse.executeScript("window.scrollBy(0, 1000)", "");
				  
				Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class ); 
				
				 
	        p.login_email.sendKeys("");
				  p.login_pswd.sendKeys("");
					  p.SignIn.click();	
				
					  if (p.login_email.getAttribute("value").isEmpty() ||p.login_pswd.getAttribute("value").isEmpty() == true) {
						  
						  WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
						  WebElement e = webdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='pass-error']")));
						  System.out.println(e.getText());
					  }
					  
			}
			
			
			// verify if the email is in the correct format but not valid or if the password is wrong
			@Test
			public void testcase13() throws Exception{
				 JavascriptExecutor jse = (JavascriptExecutor) driver;
				  jse.executeScript("window.scrollBy(0, 1000)", "");
				  
				Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class ); 
				
				 
	        p.login_email.sendKeys("jsjdjd@gmail.com");
				  p.login_pswd.sendKeys("02jdwjej1923");
					  p.SignIn.click();	
					  
					  WebElement alert = driver.findElement(By.xpath("//div[@class = 'page messages']/div[2]/div/div/div"));
			
					  if(driver.getTitle().contains("Customer Login")) {
						  				
						    System.out.println(alert.getText()); 
					  }			
	  else {
						  System.out.println("Login Successfull");
					  }
					  
			}
			
	
			
			@AfterMethod
			public void closeApp() {
				
				driver.close();
				}

}
