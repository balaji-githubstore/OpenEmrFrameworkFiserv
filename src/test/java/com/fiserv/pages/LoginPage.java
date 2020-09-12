package com.fiserv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.fiserv.stepdefn.Setup;

public class LoginPage {
	private static By userLocator=By.id("authUser");
	private static By passLocator=By.id("clearPass");
	private static By languageLocator=By.name("languageChoice");
	private static By loginLocator=By.xpath("//*[@type='submit']");
	private static By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");
	
		
	public static void enterUsername(String username)
	{
		Setup.driver.findElement(userLocator).sendKeys(username);
	}
	
	public static void enterPassword(String password)
	{
		Setup.driver.findElement(passLocator).sendKeys(password);
	}

	public static void selectLanguage(String language)
	{
		Select selectLanaguage = new Select(Setup.driver.findElement(languageLocator));
		selectLanaguage.selectByVisibleText(language);
	}
	
	public static void clickOnLogin()
	{
		Setup.driver.findElement(loginLocator).click();
	}
	
	public static String getErrorMessage()
	{
		return Setup.driver.findElement(errorLocator).getText().trim();
	}
}
