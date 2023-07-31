package com.obsqura.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ElementUtil;



public class LoginTest extends BaseTest{
	@Test(groups= {"sanity","regression"})
  public void verifyLogin() {
	  LoginPage loginpage=new LoginPage(driver);
	  String actualResult=loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
	  Assert.assertEquals(actualResult,"Clients");
  }
	
}
