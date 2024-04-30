package maven_project.automation_testng;




	import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Footer {
		WebDriver driver;
		@BeforeMethod
		public void launchWeb() throws Exception {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.get("https://magento.softwaretestingboard.com/");
			driver.manage().window().maximize();
			Thread.sleep(2500);
		}
		
		// verify all the links present in the footer
		@Test
		public void testcase21() throws Exception {
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			  jse.executeScript("window.scrollBy(0, 3000)", "");
			  
			Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
			
			List<WebElement> links = p.footer.findElements(By.tagName("a"));
			int count = links.size();
			System.out.println("number of links in footer is:"+ count);
			for(int i =0;i<links.size();i++) // to get the names of all the links in the website
		    {
		    	System.out.println(links.get(i).getText());
	   }
		    
		
	}
		
		// verify  the links in the footer is navigating to the right page
		@Test
		public void testcase22() throws Exception {
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			  jse.executeScript("window.scrollBy(0, 3000)", "");
			  
			Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
			
			Boolean b1 = p.Footer_Link1.isEnabled();
			System.out.println(b1);
			
			p.Footer_Link1.click();
		
	Set<String> wc = driver.getWindowHandles();
			
			System.out.println(wc.size());
			for(String ref:wc) {
				driver.switchTo().window(ref);
				System.out.println(driver.getTitle());// prints all the titles of the webpage
						Thread.sleep(2000);
			}
			if(driver.getTitle().contains("Practice")) {
	System.out.println("the link navigated to the right page");
		   driver.switchTo().defaultContent();
		}
		}
		
		//verify if there is a copy right present
		@Test
		public void testcase23() throws Exception {
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			  jse.executeScript("window.scrollBy(0, 3000)", "");
			  
			Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
			
		
			String actual_result = p.copyright.getText();
			String expected_result = "We know you have an assignment to complete. If this site is not functioning as expected, drop us an email. Copyright © 2013-present Magento, Inc. All rights reserved.";
			
			assertEquals(actual_result, expected_result);
			  Assert.assertTrue(actual_result.contains(expected_result));
			  
			  System.out.println("copy right present");
			
		}
		
		@AfterMethod
		public void closeApp() {
			
			driver.quit();
			}
	}
		
		

		


