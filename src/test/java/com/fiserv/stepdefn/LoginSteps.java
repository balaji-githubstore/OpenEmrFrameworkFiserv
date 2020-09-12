package com.fiserv.stepdefn;

import org.junit.Assert;

import com.fiserv.pages.DashboardPage;
import com.fiserv.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("I have {string} browser with openemr page url {string}")
	public void i_have_browser_with_openemr_page(String browser, String url) {
		//if(Setup.driver == null)
			Setup.launchBrowser(browser, url);
		//else
			//Setup.driver.get(url);
	}	

	@When("I enter username as {string} and I enter password as {string}")
	public void i_enter_username_as_and_I_enter_password_as(String username, String password) {	
		LoginPage.enterUsername(username);
		LoginPage.enterPassword(password);	
	}

	@When("I select Language as {string}")
	public void i_enter_Language_as(String language) {
		LoginPage.selectLanguage(language);
		LoginPage.clickOnLogin();
	}

	@Then("I should get the access to the portal with title as {string}")
	public void i_should_get_the_access_to_the_portal(String expectedValue) {
		DashboardPage.waitForPresenceOfFlowBoard();
		
		String actualValue= DashboardPage.getCurrentTitle();
		
		//assert should in steps
		Assert.assertEquals(expectedValue,actualValue);
	}
	
	@Then("I should not get access to the portal with error as {string}")
	public void i_should_not_get_access_to_the_portal_with_error_as(String expectedValue) {    
		String actualValue = LoginPage.getErrorMessage();
		Assert.assertTrue(actualValue.contains(expectedValue));
	}

}
