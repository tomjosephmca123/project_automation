package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtil;
import utilities.WaitUtil;

public class LoginPage {
WebDriver driver;
	
	ElementUtil elementUtil;
	WaitUtil waitUtil;
	
	
	@FindBy(name="email")
	WebElement emailField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(className="mt15")
	WebElement submitButton;
	
	@FindBy(linkText="Clients")
	WebElement ClientLink;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}
	
	public String doLogin(String username,String password) {
		elementUtil.sendKeys(emailField,username);
		elementUtil.sendKeys(passwordField,password);
		elementUtil.click(submitButton);
		String s=ClientLink.getText();//for assertion
		return s;
	}

}
