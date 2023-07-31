package com.obsqura.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.obsqura.constants.Constants;

public class WaitUtil {
	//define the wait functions used in project
	
	WebDriver driver;
	
	WebDriverWait wait;

	
	public WaitUtil(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void waitForPageTitle(String title) {
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleIs(title));
			}

	public void waitForElementClick(WebElement  element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
			}
	
	
	public void waitForElementvisibile(WebElement  element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
}