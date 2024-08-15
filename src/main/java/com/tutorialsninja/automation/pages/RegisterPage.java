package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import io.cucumber.datatable.DataTable;

public class RegisterPage {
	
	public  RegisterPage()
	{
		PageFactory.initElements(Base.driver,this);
	}
	
	@FindBy(id="input-firstname")
	public static WebElement FirstName;
	
	@FindBy(id="input-lastname")
	public static WebElement LastName;
	
	@FindBy(id="input-email")
	public static WebElement email;
	
	@FindBy(id="input-telephone")
	public static WebElement telephone;
	
	@FindBy(id="input-password")
	public static WebElement password;
	
	@FindBy(id="input-confirm")
	public static WebElement confirmpassword;
	
	@FindBy(name="agree")
	public static WebElement privacyPolicy;
	
	@FindBy(css="input[type=\"submit\"][value=\"Continue\"]")
	public static WebElement continueButton;
	
	@FindBy(linkText="Register")
	public static WebElement RegisterBreadcrumb;
	
	@FindBy(css="input[id='input-firstname']+div")
	public static WebElement firstnamewarning;
	
	@FindBy(css="input[id='input-lastname']+div")
	public static WebElement lastnamewarning;
	
	@FindBy(css="input[id='input-email']+div")
	public static WebElement emailwarning;
	
	@FindBy(css="input[id='input-telephone']+div")
	public static WebElement telephonewarning;
	
	@FindBy(css="input[id='input-password']+div")
	public static WebElement passwordwarning;
	
	@FindBy(css="div[class$='alert-dismissible']")
	public static WebElement privacypolicywarning;
	
	@FindBy(css="input[name='newsletter'][value='1']")
	public static WebElement subscribenewsletter;
	
	@FindBy(css="div[class$=\"alert-dismissible\"]")
	public static WebElement duplicateaccountwarming;
	
	
	
	public static void enteralldetails(DataTable datatable, String detailsType)
	{
		Map<String, String> map = datatable.asMap(String.class, String.class);
		 
		 Elements.TypeText(RegisterPage.FirstName, map.get("FirstName"));
		 Elements.TypeText(RegisterPage.LastName, map.get("LastName"));
		 Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		 Elements.TypeText(RegisterPage.password, map.get("Password"));
		 Elements.TypeText(RegisterPage.confirmpassword, map.get("Password"));
		 
		 if(detailsType.equalsIgnoreCase("duplicate"))
			 Elements.TypeText(RegisterPage.email,map.get("Email"));
		 else
			 Elements.TypeText(RegisterPage.email, System.currentTimeMillis()+ map.get("Email"));
			 
	}
	
	

}
