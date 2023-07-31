package com.obsqura.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;


public class ElementUtil {
	//utility class for all element actions

	WebDriver driver;
	static Properties pro=new Properties();

	public ElementUtil(WebDriver driver) {

		this.driver=driver;

	}

	public ElementUtil()   {
		File src=new File(Constants.propertyConfig_File);

		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

	public String getApplicationUrl() {

		String url=pro.getProperty("baseUrl");		
		return url;			
	}

	public String getUserName() {

		String userName=pro.getProperty("username");		
		return userName;			
	}

	public String getPassword() {

		String Password=pro.getProperty("password");		
		return Password;			
	}


	public static String getPropertyValue(String key) 
	{

		File src=new File(Constants.propertyConfig_File);
		
		try {
			FileInputStream fis = new FileInputStream (src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		String value=pro.get(key).toString();
		return value;
	}



	public void sendKeys(WebElement element,String value) {

		element.clear();
		element.sendKeys(value);
	}


	public void click(WebElement element) {

		element.click();
	}

	public void clickCheckbox(List<WebElement> element) {

		for ( WebElement el : element ) {
			if ( !el.isSelected() ) {
				el.click();
			}else if(el.isSelected()) {

				el.click();		    	
			}
		}

	}

	public void selectDropdown(WebElement element,String type,String value) {


		Select sel=new Select(element);

		if (type.equalsIgnoreCase("index"))
			sel.selectByIndex(Integer.parseInt(value));
		
		else if  (type.equalsIgnoreCase("visibletext")) {
		
			sel.selectByVisibleText(value);
		}
			else if  (type.equalsIgnoreCase("byvalue")){
	
			sel.selectByValue(value);
			}
		}


	

	public void scrollIntoView(WebElement element) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",  element);

	}

	public void scrollIntoViews(List<WebElement> element ) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}


	public void scrollBottom(WebElement element) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);" , element);
	}

	public void scrollUp(WebElement element) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(500,0);" , element);
	}

	public boolean displayCheck(WebElement element) {

		boolean en=element.isDisplayed();

		return en;
	}

	public String displayCheckText(String value) {


		String en=value;

		return en;
	}
	public boolean enableCheck(WebElement element) {

		boolean en=element.isEnabled();

		return en;
	}


	public void checkAcceptAlert(WebElement element) {

		Alert al=driver.switchTo().alert();
		al.accept();

	}

	public void checkDismissAlert(WebElement element) {

		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
	
	public void mouseHover(WebElement element) {

		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void doubleClick(WebElement element) {

		Actions act=new Actions(driver);	
		act.doubleClick(element).perform();
	}

	public void rightClick(WebElement element) {

		Actions act=new Actions(driver);	
		act.contextClick(element);

	}
	
	public void enterKeyClick(WebElement element) {

		element.sendKeys(Keys.ENTER);

	}

	public void navigateBack() {

		driver.navigate().back();
	}



	public void dateSelect(WebElement element,String dateValue) {

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);

	}
	public String getText(WebElement element) {

		String s=element.getText();
		return s;
	}
	public void clickRadioButton(List<WebElement> element,int index) {
		element.get(index).click();
	}
	public void tabKey(WebElement element){

		element.sendKeys(Keys.TAB);

		}
	public void enterKey(WebElement element){

		element.sendKeys(Keys.ENTER);

		}
	

}
