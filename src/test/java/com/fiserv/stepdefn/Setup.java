package com.fiserv.stepdefn;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	public static WebDriver driver;
	
	public static void launchBrowser(String browser,String url)
	{
		if (browser.equalsIgnoreCase("ff11")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		} else if (browser.equalsIgnoreCase("ie22")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@After
	public void endAll()
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File file= ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("screenshot/error.png"));
		Setup.driver.quit();
	}

}




