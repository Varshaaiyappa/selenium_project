package maven_project.automation_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Homepage_header {

	WebDriver driver;
	
	@BeforeTest
	
	public void launchWeb() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varsha\\OneDrive\\Desktop\\jar files\\chromedriverfolder\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);
	}
	
	//verify the application title
	@Test
	public void testcase1() throws Exception {

    String Apptitle = driver.getTitle();
    System.out.println("title of the page"+Apptitle);
    
    String Expected_title = "Home Page";
    Assert.assertEquals(Apptitle, Expected_title);
    System.out.println("test completed");
	}
	
	
	//verify all the links present in header
	@Test
	public void testcase2() throws Exception {
		
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		
		
		List<WebElement> links = p.header.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println("number of links in header is:"+ count);
		for(int i =0;i<links.size();i++) // to get the names of all the links in the website
	    {
	    	System.out.println(links.get(i).getText());
   }
		   }
	
	
	//test:VerifyHomePageLoad
	
	@Test
	public void testcase3() throws Exception {
    String Url = driver.getTitle();
    if(Url.contains("Home")) {
    	System.out.println("website loaded successfully");
    	   }
    else {
    	System.out.println("website is not loaded successfully");
    }
	}
	
	
	// verify all the essential elements of the web page are present (enabled and visible)
	
	@Test
	public void testcase4() throws Exception {
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		p.logo.isDisplayed();
		p.search.isDisplayed();
		p.navigation.isDisplayed();
		if(p.logo.isDisplayed()&&p.search.isDisplayed()&&p.navigation.isDisplayed()  == true) {
			System.out.println("the elements are displayed");
		}
		else 
		{
			System.out.println("the elements are not  displayed");
		}
	}
	
	// verify that on clicking the logo takes back to the home page itself

	@Test
	public void testcase5() throws Exception {
		Pageobjectclass p = PageFactory.initElements(driver,Pageobjectclass.class );
		p.logo.click();
		String Url = driver.getCurrentUrl();
		if(driver.getCurrentUrl().contains(Url)) {
			System.out.println("refreshes back to the home page");
		}
	}

//	
    @AfterTest
	public void closeApp() {
		
	driver.close();
	}

	}
	
	
	





