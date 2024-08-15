package com.tutorialsninja.automation.stepdef;

import java.util.Map;


import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class Register {
	
	HeadersSection hs = new HeadersSection();
	RegisterPage rp = new RegisterPage(); //object to call the constructor to initialize webelements
	AccountSuccessPage sp = new AccountSuccessPage();
	
	@Given("I launch the application")
	public void I_launch_the_application() 
	{
	   Base.driver.get(Base.reader.getUrl());
	}

	@And("I navigate to Account Registration page")
	public void i_navigate_to_Account_Registration_page()  {
	   
		Elements.click(HeadersSection.myAccountlink);
		Elements.click(HeadersSection.register);
	}

	@When("I provide all the below valid details")
	public void i_provide_all_the_below_valid_details(DataTable datatable) {
		
		RegisterPage.enteralldetails(datatable,"unique");
		 
		 
	   
	}

	@And("I select the Privacy Policy")
	public void i_select_the_Privacy_Policy() {
		Elements.click(RegisterPage.privacyPolicy);
	    
	}

	@And("I click on Continue button")
	public void i_click_on_Continue_button() {
	    
		Elements.click(RegisterPage.continueButton);
	}
	
	

	@Then("I should see that the User Account has successfully created")
	public void i_should_see_that_the_User_Account_has_successfully_created() {
		
	
	Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadcrumb));
		
	    
	}
	
	@Then("I should see that the User Account is not created")
	public void i_should_see_that_the_User_Account_is_not_created()
	{
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.RegisterBreadcrumb));
		
	}
	
	@And("I should see the error messages informing the user to fill the mandatory fields")
	public void i_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields()
	{
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstnamewarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastnamewarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailwarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephonewarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordwarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.privacypolicywarning));
		
	}
	
	@And ("I subscribe to Newsletter")
	public void i_subscribe_to_newsletter()
	{
		Elements.click(RegisterPage.subscribenewsletter);
	}
	
	@When ("I provide the below duplicate details into the fields")
	public void i_provide_the_below_duplicate_details_into_the_fields(DataTable datatable) {
		
		RegisterPage.enteralldetails(datatable,"duplicate");
		 
		 
	   
	}
	
	@Then ("I should see the warning message stating that the user is already created")
	public void i_should_see_the_warning_message_stating_that_the_user_is_already_created()
	{
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.duplicateaccountwarming,"Warning: E-Mail Address is already registered!"));
		
	}
	
	


}
