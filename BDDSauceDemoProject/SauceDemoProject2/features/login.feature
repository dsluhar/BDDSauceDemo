Feature: Free CRM Login Feature

@Regression
Scenario Outline: Free CRM Login Test scenario

Given user is already on Login Page
When title of Login Page is Free CRM
Then user enter "<username>" and "<password>"
Then user click on Login Button
Then user is on Home Page
And close the browser

Examples:
	| username | password |
	| sqadilip@gmail.com | Dluhar@301 |
	| sqadilip03@gmail.com | Dluhar@301 |