package com.obsqura.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.ElementUtil;
import com.obsqura.utilities.WaitUtil;

public class ClientPage{
	
	WebDriver driver;

	ElementUtil elementUtil;
	WaitUtil waitUtil;

	@FindBy(linkText="Clients")
	WebElement ClientLink;


	@FindBy(className="btn-default")
	WebElement addClientField;

	@FindBy(xpath="//input[@name='company_name']")
	WebElement companynameField;

	@FindBy(name="address")
	WebElement addressField;

	@FindBy(name="city")
	WebElement cityField;

	@FindBy(name="state")
	WebElement stateField;

	@FindBy(name="zip")
	WebElement zipField;

	@FindBy(name="country")
	WebElement countryField;

	@FindBy(name="phone")
	WebElement phoneField;

	@FindBy(name="website")
	WebElement websiteField;

	@FindBy(name="vat_number")
	WebElement vat_numberField;

	@FindBy(id="s2id_autogen6")
	WebElement clientGroupField;

	@FindBy(id="s2id_currency")
	WebElement currencyDropDown;

	@FindBy(xpath="//div[@id='select2-drop']//li[2]")
	WebElement currencyDropDown2;

	@FindBy(name="currency_symbol")
	WebElement currencySymbolField;

	@FindBy(className="btn-primary")
	WebElement submitField;

	@FindBy(name="disable_online_payment")
	List<WebElement> disableRadioButton;

	@FindBy(xpath="//input[@type='search']")
	WebElement searchField;

	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[@title='Edit client']")
	WebElement editField;

	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[@title='Delete client']")
	WebElement deleteField;

	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmDeleteButton;

	@FindBy(xpath="//th[text()='Company name']")
	WebElement sortByCompanyName;

	@FindBy(xpath="//div[@class='app-alert-message']")
	WebElement deletemsg;

	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[2]")
	WebElement newaddedcompany;

	
	@FindBy(xpath="//b[@role='presentation']")
	WebElement downarrowsybol;
	
	@FindBy(xpath="//ul[@role='listbox']//li[5]")
	WebElement alloption;
	
	@FindBy(xpath="//table[@id='client-table']//tbody//td[2]")
	List<WebElement> companynamelist;


	public ClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}

	public String addClient(String companyname,String address,String city,String state,String zip,String country,String phone,String website,String vat_number,String currencySymbol) {
		elementUtil.click(ClientLink);
		elementUtil.click(addClientField);
		elementUtil.sendKeys(companynameField,companyname);
		elementUtil.sendKeys(addressField,address);
		elementUtil.sendKeys(cityField,city);
		elementUtil.sendKeys(stateField,state);
		elementUtil.sendKeys(zipField,zip);
		elementUtil.sendKeys(countryField,country);
		elementUtil.sendKeys(phoneField,phone);
		elementUtil.sendKeys(websiteField,website);
		elementUtil.sendKeys(vat_numberField,vat_number);		
		elementUtil.scrollIntoView(currencyDropDown);
		elementUtil.click(currencyDropDown);
		elementUtil.click(currencyDropDown2);
		elementUtil.clickRadioButton(disableRadioButton,0);
		elementUtil.sendKeys(currencySymbolField,currencySymbol);
		elementUtil.click(submitField);
		waitUtil.waitForElementvisibile(ClientLink);
		elementUtil.click(ClientLink);
		elementUtil.sendKeys(searchField,companyname);
		String s=elementUtil.getText(newaddedcompany);
		return s;
	}
	public String clientSearch(String searchelement) {
		elementUtil.click(ClientLink);
		elementUtil.sendKeys(searchField,searchelement);
		String s=elementUtil.getText(newaddedcompany);
		return s;
	}
	public String clientEdit(String newAddress) {
		elementUtil.click(ClientLink);
		elementUtil.click(editField);
		elementUtil.sendKeys(addressField,newAddress);
		elementUtil.click(submitField);
		waitUtil.waitForElementvisibile(editField);
		elementUtil.click(editField);
		String s=elementUtil.getText(addressField);
		return s;
	}

	public String clientDelete() {
		elementUtil.click(ClientLink);
		elementUtil.click(deleteField);
		elementUtil.click(confirmDeleteButton);
		waitUtil.waitForElementvisibile(deletemsg);
		String s=elementUtil.getText(deletemsg);
		return s;
	}
	public boolean sortByCompanyName() {
		boolean flag;
		elementUtil.click(ClientLink);
		elementUtil.click(downarrowsybol);
		elementUtil.click(alloption);
		elementUtil.click(sortByCompanyName);
		
		ArrayList<String> newList = new ArrayList<>();
		for(int i=0;i<companynamelist.size();i++) {
			newList.add(companynamelist.get(i).getText());
		}
		ArrayList<String> newList2 = new ArrayList<>();
		for(int i=0;i<companynamelist.size();i++) {
			newList2.add(companynamelist.get(i).getText());
		}
		Collections.sort(newList2);
		if(newList.equals(newList2))
			flag=true;
		else
			flag=false;
		System.out.println(flag);
		return flag;
		
	}


}
