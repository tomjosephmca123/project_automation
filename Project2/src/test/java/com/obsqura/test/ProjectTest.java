package com.obsqura.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProjectPage;
import com.obsqura.utilities.ElementUtil;
import com.obsqura.utilities.ExcelRead;

public class ProjectTest extends BaseTest{
	
  @Test(dataProvider="userData",groups= {"addproject"})
  public void verifyAddProject(String title,String description,String start_date,String deadline,String price,String label) {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com","12345678");
	  ProjectPage projectpage=new ProjectPage(driver);
	  String actualresult=projectpage.addProject(title,description,start_date,deadline,price,label);
	  Assert.assertEquals(actualresult, title);
  }
  
  @Test(groups= {"search"})
  public void verifyClientSearch() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
	  ProjectPage projectpage=new ProjectPage(driver);
	  String actualresult=projectpage.projectSearch("mintra");
	  Assert.assertEquals(actualresult,"mintra");
  }
  
  @Test(groups= {"edit"})
  public void verifyEditProject() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
	  ProjectPage projectpage=new ProjectPage(driver);
	  String actualresult=projectpage.projectEdit("web");
	  Assert.assertEquals(actualresult,"web");
  }
  
  @Test(groups= {"delete"})
  public void verifyDeleteProject() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
	  ProjectPage projectpage=new ProjectPage(driver);
	  String actualresult=projectpage.deleteProject();
	  Assert.assertEquals(actualresult,"The record has been deleted.","wrong msg ");
  }
  
  @Test(groups= {"sort"})
  public void verifySortById() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
	  ProjectPage projectpage=new ProjectPage(driver);
	  boolean f=projectpage.sortById();
	  Assert.assertTrue(f);
  }
  
  
  @DataProvider()
	public Object [][] userData() throws InvalidFormatException, IOException{
	  Object[][] data=ExcelRead.getDataFromExcel(Constants.testData,"Sheet1");
	  return data;

}
}
