Feature: CRM Login with Data Table

@Tag2
Scenario: Free CRM Login Test scenario

Given user is already on Login Page1
When title of Login Page is Free CRM1
Then user enter credentials using Data table1 and user click on Login Button1
	|username|password|
	|standard_user|secret_sauce|
	|performance_glitch_user|secret_sauce|
	|visual_user|secret_sauce|
And close the browser1


@Sanity
Scenario: Free CRM Login Test scenario

Given user is already on Login Page1
When title of Login Page is Free CRM
Then user enter credentials using Data table
	|username|	|password|
Then user click on Login Button
Then user is on Home Page.
And close the browser


