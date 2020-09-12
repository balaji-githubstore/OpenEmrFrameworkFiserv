package com.fiserv.stepdefn;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fiserv.pages.DashboardPage;
import com.fiserv.pages.PatientFinderPage;
import com.fiserv.pages.SearchOrAddPatientPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {
	private static String actualAlertText;

	@When("I click or mousehover on Patient\\/Client")
	public void i_click_on_mousehover_on_Patient_Client() {
		DashboardPage.mouseOverOnPatientClient();
	}

	@When("I click on patients menu")
	public void i_click_on_patients_menu() {
		DashboardPage.clickOnPaitent();
	}

	@When("I click on Add New Patient")
	public void i_click_on_Add_New_Patient() {

		PatientFinderPage.switchToFinFrame();
		PatientFinderPage.clickOnAddNewPatient();
		PatientFinderPage.switchOutOfFrame();
	}

	@When("I fill below details")
	public void i_fill_below_details(io.cucumber.datatable.DataTable dataTable) {

		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String, String>> lists = dataTable.asMaps();
//		System.out.println(lists.get(0).get("firstname"));
//		System.out.println(lists.get(0).get("lastname"));
//		System.out.println(lists.get(0).get("dob"));
//		System.out.println(lists.get(0).get("gender"));

		SearchOrAddPatientPage.SwitchToPatFrame();

		Setup.driver.findElement(By.id("form_fname")).sendKeys(lists.get(0).get("firstname"));
		Setup.driver.findElement(By.id("form_lname")).sendKeys(lists.get(0).get("lastname"));
		Setup.driver.findElement(By.id("form_DOB")).sendKeys(lists.get(0).get("dob"));
		Select selectGender = new Select(Setup.driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText(lists.get(0).get("gender"));

	}

	@When("I click on Create New Patient")
	public void i_click_on_Create_New_Patient() {
		Setup.driver.findElement(By.id("create")).click();
		Setup.driver.switchTo().defaultContent();
	}

	@When("I click on confirm create new Patient")
	public void i_click_on_confirm_create_new_Patient() {
		Setup.driver.switchTo().frame("modalframe");
		Setup.driver.findElement(By.xpath("//*[@value='Confirm Create New Patient']")).click();
		Setup.driver.switchTo().defaultContent();
	}

	@When("I store the alert message and handle it")
	public void i_store_the_alert_message_and_handle_it() {
		
		WebDriverWait wait=new WebDriverWait(Setup.driver,50);
		wait.until(ExpectedConditions.alertIsPresent());
		
		actualAlertText = Setup.driver.switchTo().alert().getText();
		Setup.driver.switchTo().alert().accept();
	}

	@When("I close the happy birthday popup")
	public void i_close_the_happy_birthday_popup() {
		Setup.driver.findElement(By.xpath("//*[@class='closeDlgIframe']")).click();
	}

	@Then("I should validate the stored alert message {string}")
	public void i_should_validate_the_stored_alert_message(String expectedAlertText) {
		Assert.assertTrue(actualAlertText.contains(expectedAlertText));
	}

	@Then("I should get the added patient details as {string}")
	public void i_should_get_the_added_patient_details_as(String expectedPatientName) {
		SearchOrAddPatientPage.SwitchToPatFrame();
		String acutalValue = Setup.driver.findElement(By.xpath("//h2[contains(text(),'Medical Record Dashboard')]")).getText();
		Assert.assertTrue(acutalValue.toLowerCase().contains(expectedPatientName.toLowerCase()));
	}

}
