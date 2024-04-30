package maven_project.automation_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Search {

WebDriver driver;
	
	@BeforeTest
	
	public void launchWeb() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);
	}
	
	//verify if the search bar is enabled and verify the place holder text
	@Test
	public void testcase6() throws Exception {
		
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		 p.search.click();
		 Thread.sleep(2000);
	    
	   	System.out.println("search box is enabled"+ p.search.isEnabled());    
	 System.out.println(p.search.getAttribute("placeholder"));
	 	   
	}
	//verify if no value is entered in and gthe search icon is clicked
	@Test
	public void testcase7() throws Exception {
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
p.search.sendKeys("");

Actions act =  new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//div[@class = 'actions' ]/button"))).click().perform();
Thread.sleep(2000);

if(p.search_icon.isEnabled()==true)
{
	System.out.println("search icon is enabld");
}
else
{
	System.out.println("please enter a valid keyword to search");
	}
	}	
	@Test
	public void testcase8() throws Exception {
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
p.search.sendKeys("");

Actions act =  new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//div[@class = 'actions' ]/button"))).click().perform();
Thread.sleep(2000);

if(p.search_icon.isEnabled()==true)
{
	System.out.println("search icon is enabld");
}
else
{
	System.out.println("please enter a valid keyword to search");
	}
	}	
	
	
	 @AfterTest
		public void closeApp() {
			
		driver.close();
		}

}



