package com.fiserv.pages;

import com.fiserv.stepdefn.Setup;

public class SearchOrAddPatientPage {
	private static String patFrameName="pat";
	
	
	public static void SwitchToPatFrame()
	{
		Setup.driver.switchTo().frame(patFrameName);
	}

}
