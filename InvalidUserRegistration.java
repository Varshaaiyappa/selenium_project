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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InvalidUserRegistration {

	
	WebDriver driver;
	
	@BeforeMethod
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
	
	
	
	// verify clicking on submit button with no input
	@Test
	public void testcase5() throws Exception {


		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
    
    
		 Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		 
		String value1 = p.firstname.getAttribute("value");
		String     value2 = p.lastname.getAttribute("value");
		String     value3 =	 p.email.getAttribute("value");
		String    value4 =	p.pass.getAttribute("value");
		String	     value5 =	p.confirmpass.getAttribute("value");
    p.firstname.sendKeys("varsha");
    p.submit.click();


if(value1.contains("")||value2.contains("")||value3.contains("")||value4.contains("")||value5.contains("") )
{
   System.out.println("please fill all the fields");
}

	}

	// verify that only valid email address is added to the email field 
	@Test
	public void testcase6() throws Exception {
		
		String ch = "@";
	
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		 
	  p.firstname.sendKeys("uservarsha");
	  p.lastname.sendKeys("");
		  p.email.sendKeys("abc");
		  p.submit.click();
		
		 
	if(p.email.getAttribute("value").contains(ch)) {
		
		System.out.println("valid email address");
	}
	else {
		
		 WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  WebElement e = webdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='email_address-error']")));
		  System.out.println(e.getText());
	}
		
		 Thread.sleep(3000);
	  
	}
     @Test
	public void testcase7() throws Exception {
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		p.pass.sendKeys("abc");
		
		if(p.pass.getAttribute("value").length() < 8) {
		  String actual_error = driver.findElement(By.xpath("//div[@id='password-error']")).getText();
	  
	  String expected_error =  "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
	  
	  Assert.assertEquals(actual_error, expected_error);
	  
	  Assert.assertTrue(actual_error.contains("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."));
  
	  System.out.println("Please enter a valid password equal /greater than 8 symbols");
		}
		
		p.pass.clear();
		
		Thread.sleep(3000);
		
		p.pass.sendKeys("afhsgdgfsjs");
		
		  String actual_error = driver.findElement(By.xpath("//div[@id='password-error']")).getText();
		  
		  String expected_error =  "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
		  
		  Assert.assertEquals(actual_error, expected_error);
		  
		  Assert.assertTrue(actual_error.contains("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."));
	  
		  System.out.println("Please enter a valid password with lower case , upper case, digits , special characters");
	}

	// verify that password and confirm password matches
    @Test
	public void testcase8() throws Exception {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0, 1000)", "");
		  
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		p.pass.sendKeys("Abc@123?!");
		p.confirmpass.sendKeys("Abc@");
		p.submit.click();
		
if(p.pass.getAttribute("value")!=(p.confirmpass.getAttribute("value"))){
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='password-confirmation-error']")));
	  System.out.println(e.getText());
}
		
}	
		
		
	
	
@AfterMethod
	public void closeApp() {
		
		driver.close();
		}
}


