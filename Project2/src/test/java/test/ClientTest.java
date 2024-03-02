package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ClientPage;
import pages.LoginPage;
import utilities.ElementUtil;
import utilities.FakerUtility;


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
		String actualresult=clientPage.clientEdit("hp","India");
		Assert.assertEquals(actualresult,"India");
	}
	@Test(groups= {"delete"})
	public void verifyClientDelete() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.doLogin(ElementUtil.getPropertyValue("username"),ElementUtil.getPropertyValue("password"));
		ClientPage clientPage=new ClientPage(driver);
		boolean f=clientPage.clientDelete("abc");
		Assert.assertTrue(f);
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
