@login 
Feature: Login Validation 
	In order to maintain medical record
	As a user
	I should access to the portal

@valid 
Scenario: Valid Credential 
	Given I have 'ch' browser with openemr page url 'https://demo.openemr.io/a/openemr/interface/login/login.php?site=default'
	When I enter username as 'admin' and I enter password as 'pass' 
	And I select Language as 'English (Indian)' 
    Then I should get the access to the portal with title as 'OpenEMR'
    
@invalid 
Scenario: Invalid Credential 
	Given I have 'ch' browser with openemr page url 'https://demo.openemr.io/a/openemr/interface/login/login.php?site=default'
	When I enter username as 'bala' and I enter password as 'pass' 
	And I select Language as 'English (Indian)' 
    Then I should not get access to the portal with error as 'Invalid username or password'