package com.fiserv.pages;

import org.openqa.selenium.By;

import com.fiserv.stepdefn.Setup;

public class PatientFinderPage {
	private static String finFrameName="fin";
	private static By addNewPatientLocator=By.id("create_patient_btn1");
	
	
	public static void switchToFinFrame()
	{
		Setup.driver.switchTo().frame(finFrameName);
	}
	
	public static void clickOnAddNewPatient()
	{
		Setup.driver.findElement(addNewPatientLocator).click();
	}
	public static void switchOutOfFrame()
	{
		Setup.driver.switchTo().defaultContent();
	}
}
