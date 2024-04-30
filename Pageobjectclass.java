package maven_project.automation_testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pageobjectclass {
	

    @FindBy(tagName  = "header")WebElement header;
	@FindBy(xpath =  "//a[@class='logo']") WebElement logo;
    @FindBy(id    = "search")WebElement search;
    @FindBy(xpath = "//*[@id=\"store.menu\"]/nav") WebElement navigation;
    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")WebElement search_icon;
    // user -registration
    @FindBy(id = "firstname") WebElement firstname;
    @FindBy(id = "lastname") WebElement lastname;
    @FindBy(id = "email_address") WebElement email;
    @FindBy(id = "password") WebElement pass;
    @FindBy(id = "password-confirmation") WebElement confirmpass ;
    @FindBy(xpath = "//button[@title='Create an Account']")WebElement submit;

    
    // login page
    @FindBy(id = "email") WebElement login_email;
    @FindBy(id = "pass") WebElement login_pswd;
    @FindBy(id = "send2")WebElement SignIn;
    
    //forgot password
    @FindBy(linkText = "Forgot Your Password?")WebElement forgot_pswd;
    @FindBy(xpath ="//*[@id='form-validate']/fieldset/div[2]/label/span")
    WebElement forgot_pswd_label;
    @FindBy(xpath ="//*[@id=\"form-validate\"]/div/div[1]/button/span")WebElement Reset_password;
    @FindBy(id = "email_address")WebElement forgot_pswd_email;

    //footer
    @FindBy(xpath= "/html/body/div[2]/footer")WebElement footer;
    @FindBy(linkText = "Practice API Testing using Magento 2")WebElement Footer_Link1;
    @FindBy(className ="copyright")WebElement copyright;

}





