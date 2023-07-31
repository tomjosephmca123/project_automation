package com.obsqura.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.ClientPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ElementUtil;
import com.obsqura.utilities.FakerUtility;


public class ClientTest extends BaseTest{
	FakerUtility fakerutil;


	@Test(groups= {"addclient"})
	public void verifyAddClient() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		ClientPage clientPage=new ClientPage(driver);
		String actualresult=clientPage.addClient("hp","SCK",FakerUtility.cityName(),FakerUtility.state(),"686652","India",FakerUtility.phoneNumber(),"www.amazon.com","3456","$");
		Assert.assertEquals(actualresult,"hp");
	}


	@Test(groups="search")
	public void verifyClientSearch() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		ClientPage clientPage=new ClientPage(driver);
		String actualresult=clientPage.clientSearch("hp");
		Assert.assertEquals(actualresult,"hp");
	}

	@Test(groups= {"edit"})
	public void verifyClientEdit() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		ClientPage clientPage=new ClientPage(driver);
		String actualresult=clientPage.clientEdit("uk");
		Assert.assertEquals(actualresult,"uk");
	}
	@Test(groups= {"delete"})
	public void verifyClientDelete() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		ClientPage clientPage=new ClientPage(driver);
		String actualmsg=clientPage.clientDelete();
		System.out.println(actualmsg);
		Assert.assertEquals(actualmsg,"The record has been deleted.","wrong msg ");
	}
	@Test(groups= {"sort"})
	public void verifySortByCompanyName() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		ClientPage clientPage=new ClientPage(driver);
		boolean f=clientPage.sortByCompanyName();
		Assert.assertTrue(f);
	}
}
