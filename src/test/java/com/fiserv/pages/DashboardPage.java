package com.fiserv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fiserv.stepdefn.Setup;

public class DashboardPage {
	private static By flowBoardLocator=By.xpath("//div[text()='Flow Board']");
	private static By patientClientLocator=By.xpath("//*[text()='Patient/Client']");
	private static By paitentLocator=By.xpath("//*[text()='Patients']");
	
	
	public static void waitForPresenceOfFlowBoard()
	{
		WebDriverWait wait = new WebDriverWait(Setup.driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(flowBoardLocator));
	}
	
	public static String getCurrentTitle()
	{
		return Setup.driver.getTitle();
	}

	public static void mouseOverOnPatientClient()
	{
		Actions action = new Actions(Setup.driver);
		action.moveToElement(Setup.driver.findElement(patientClientLocator)).build().perform();
	}
	
	public static void clickOnPaitent()
	{
		Setup.driver.findElement(paitentLocator).click();
	}
}
