package com.realtimeProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage
{

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomers_menu=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
	
	By lnkCustomers_menuitem=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a");
	
	
	By btnAddnew=By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a"); //Add new
		
	By txtEmail=By.xpath("//*[@id=\"Email\"]");
	
	By txtPassword=By.xpath("//*[@id=\"Password\"]");
	
	By txtFirstName=By.xpath("//*[@id=\"FirstName\"]");
	
	By txtLastName=By.xpath("//*[@id=\"LastName\"]");
	
	By rdMaleGender=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[5]/div[2]/div/div[1]/div/label");
	By rdFeMaleGender=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/label");
	
	By txtDob=By.xpath("//*[@id=\"DateOfBirth\"]");
	
	By txtCompanyName=By.xpath("//*[@id=\"Company\"]");
	
	By chbIsTaxExempt=By.xpath("//*[@id=\"IsTaxExempt\"]");
	
	
	By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div");
	
	By lstitemAdministrators=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By listitemForumModerators=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By lstitemGuests=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By lstitemRegistered=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	By lstitemVendors=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	
	
	By drpmgrOfVendor=By.xpath("//*[@id=\"VendorId\"]");
	
	By chkActive=By.xpath("//*[@id=\"Active\"]");
	
	By txtAdminComment=By.xpath("//*[@id=\"AdminComment\"]");
	
	By btnSave=By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]");
	
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFeMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click() ;    //Default
		}
	}	
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void ClickIsTaxExempt() 
	{
		ldriver.findElement(chbIsTaxExempt).click();
	}
	
	public void setCustomerRoles( String role) 
		{
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		
			ldriver.findElement(txtcustomerRoles).click();
						
			WebElement listitem;
			
			switch(role)
			{
			case "Administrators":
					listitem=ldriver.findElement(lstitemAdministrators); break;
			case "Guests":
					listitem=ldriver.findElement(lstitemGuests); break;
			case "Registered":
				listitem=ldriver.findElement(lstitemRegistered); break;
			case "Vendors":
				listitem=ldriver.findElement(lstitemVendors); break;
			default:
				listitem=ldriver.findElement(lstitemGuests);
			}
						
			JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
			
	}

	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
}
