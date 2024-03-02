package pages;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.ElementUtil;
import utilities.WaitUtil;

public class ProjectPage {
WebDriver driver;
	
	ElementUtil elementUtil;
	WaitUtil waitUtil;
	
	@FindBy(linkText="Projects")
	WebElement ProjectLink;
	
	@FindBy(linkText="All Projects")
	WebElement AllProjectsLink;
	
	@FindBy(linkText="Add project")
	WebElement AddprojectLink;
	
	@FindBy(name="title")
	WebElement titleField;
	
	@FindBy(xpath="//div[@id='s2id_autogen5']")
	WebElement clientField;
	
	@FindBy(xpath="//div[@id='select2-drop']//li[3]")
	WebElement clientFieldValue;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement descriptionField;
	
	
	@FindBy(name="start_date")
	WebElement start_dateField;
	
	@FindBy(xpath="//input[@name='deadline']")
	WebElement deadlineField;
	
	@FindBy(xpath="//input[@id='price']")
	WebElement priceField;
	
	@FindBy(xpath="//input[@id='s2id_autogen7']")
	WebElement labelField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitField;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[@title='Edit project']")
	WebElement editField;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[@title='Delete project']")
	WebElement deleteIcon;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmDeleteButton;
	
	@FindBy(xpath="//table[@id='project-table']//thead//th[1]")
	WebElement sortByIdField;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[2]//a")
	WebElement newprojecttitle;
	
	@FindBy(xpath="//div[@class='app-alert-message']")
	WebElement deletemsg;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//td[1]")
	List<WebElement> idlist;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//td[2]")
	List<WebElement> projectList;
	
	
	
	public ProjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}
	public String addProject(String title,String description,String start_date,String deadline,String price,String label) {
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		elementUtil.click(AddprojectLink);
		elementUtil.sendKeys(titleField,title);
		elementUtil.click(clientField);
		elementUtil.click(clientFieldValue);
		elementUtil.sendKeys(descriptionField,description);
		elementUtil.dateSelect(start_dateField,start_date);
		elementUtil.dateSelect(deadlineField,deadline);
		elementUtil.sendKeys(priceField,price);
		elementUtil.tabKey(priceField);
		elementUtil.sendKeys(labelField,label);
		elementUtil.enterKey(labelField);
		elementUtil.click(submitField);
		waitUtil.waitForElementvisibile(ProjectLink);
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);;
		elementUtil.sendKeys(searchField,title);
		String s=elementUtil.getText(newprojecttitle);
		return s;
	}
	
	public String projectSearch(String searchelement) {
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		elementUtil.sendKeys(searchField,searchelement);
		String s=elementUtil.getText(newprojecttitle);
		return s;
	}
	
	public String projectEdit(String newPrice) {
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		elementUtil.click(editField);
		elementUtil.sendKeys(descriptionField,newPrice);
		elementUtil.click(submitField);
		waitUtil.waitForElementvisibile(ProjectLink);
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		waitUtil.waitForElementvisibile(editField);
		elementUtil.click(editField);
		elementUtil.scrollIntoView(descriptionField);
		waitUtil.waitForElementvisibile(descriptionField);
		String s=elementUtil.getText(descriptionField);
		return s;
	}
	public boolean deleteProject(String valuefordelete) {
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		int m=projectList.size();
		System.out.println(m);
		int rowcount=elementUtil.getTableRowCount(projectList,valuefordelete);
		WebElement deleterow=driver.findElement(By.xpath("//table[@id='project-table']//tbody//tr["+rowcount+"]//td[9]//a[@title='Delete project']"));
		elementUtil.click(deleterow);
		elementUtil.click(confirmDeleteButton);
		waitUtil.waitForElementvisibile(deletemsg);
		waitUtil.waitForElementvisibile(ProjectLink);
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		int n=projectList.size();
		System.out.println(n);
		if(n==m-1)
			return true;
		else
			return false;
	}
	public boolean sortById() {
		boolean flag;
		elementUtil.click(ProjectLink);
		elementUtil.click(AllProjectsLink);
		elementUtil.click(sortByIdField);
		ArrayList<Integer> newList = new ArrayList<>();
		for(int i=0;i<idlist.size();i++) {
			int n=Integer.parseInt(idlist.get(i).getText());
			newList.add(n);
		}
		ArrayList<Integer> newList2 = new ArrayList<>();
		for(int i=0;i<idlist.size();i++) {
			int n=Integer.parseInt(idlist.get(i).getText());
			newList2.add(n);
		}
		Collections.sort(newList2);
		if(newList.equals(newList2))
			flag=true;
		else
			flag=false;
		return flag;
	}
	

}
