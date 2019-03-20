Feature: Launch QAClickAcademy.com and Try Login with Failure Response 

@LoginFailure 
Scenario Outline: Negative Test - Use wrong UserID and Password 
	Given Initialize "Google Chrome" webdriver 
	And Launch "http://www.qaclickacademy.com/" URL 
	When User Clicks on "Login" hyperlink 
	Then User gets redirected to "Login" Screen having "Email Address" , "Password" and "Log In" Web Elements present 
	And User populates Email Address as "<email>" ,  Password as "<password>" and Clicks "Log In" Button 
	And User Login Failed
Examples:
|email|password|
|p@v.com|12345|
|j@v.com|123456|