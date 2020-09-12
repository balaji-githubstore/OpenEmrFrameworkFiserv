@patient 
Feature: Patient Records 
	In order to maintain medical record
As a valid user
I should be able to create, delete, update the patient records

@addpatient 
Scenario: Add Patient 
	Given I have 'ch' browser with openemr page url 'https://demo.openemr.io/a/openemr/interface/login/login.php?site=default' 
	When I enter username as 'admin' and I enter password as 'pass' 
	And I select Language as 'English (Indian)' 
	And I click or mousehover on Patient/Client 
	And I click on patients menu 
	And I click on Add New Patient 
	And I fill below details 
		|firstname|lastname|dob|gender|
		|peter|paul|2020-09-11|Female|
	And I click on Create New Patient 
	And I click on confirm create new Patient 
	And I store the alert message and handle it 
	And I close the happy birthday popup 
	Then I should validate the stored alert message 'New Due' 
	And I should get the added patient details as 'peter' 
	
@addpatients 
Scenario Outline: Add Patients 
	Given I have 'ch' browser with openemr page url 'https://demo.openemr.io/a/openemr/interface/login/login.php?site=default' 
	When I enter username as 'admin' and I enter password as 'pass' 
	And I select Language as 'English (Indian)' 
	And I click or mousehover on Patient/Client 
	And I click on patients menu 
	And I click on Add New Patient 
	And I fill below details 
		|firstname|lastname|dob|gender|
		|<firstname>|<lastname>|<dob>|<gender>|
	And I click on Create New Patient 
	And I click on confirm create new Patient 
	And I store the alert message and handle it 
	And I close the happy birthday popup 
	Then I should validate the stored alert message '<alerttext>' 
	And I should get the added patient details as '<firstname>' 
	Examples: 
		|firstname|lastname|dob|gender|alerttext|
		|john|Ken|2020-09-11|Male|New Due|
		|ark|Zu|2020-09-11|Male|New Due|
		
		
		
		
	