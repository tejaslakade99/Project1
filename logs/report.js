$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/qaclickacademy_Login.feature");
formatter.feature({
  "name": "Launch QAClickAcademy.com and Try Login with Failure Response",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Negative Test - Use wrong UserID and Password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginFailure"
    }
  ]
});
formatter.step({
  "name": "Initialize \"Google Chrome\" webdriver",
  "keyword": "Given "
});
formatter.step({
  "name": "Launch \"http://www.qaclickacademy.com/\" URL",
  "keyword": "And "
});
formatter.step({
  "name": "User Clicks on \"Login\" hyperlink",
  "keyword": "When "
});
formatter.step({
  "name": "User gets redirected to \"Login\" Screen having \"Email Address\" , \"Password\" and \"Log In\" Web Elements present",
  "keyword": "Then "
});
formatter.step({
  "name": "User populates Email Address as \"\u003cemail\u003e\" ,  Password as \"\u003cpassword\u003e\" and Clicks \"Log In\" Button",
  "keyword": "And "
});
formatter.step({
  "name": "User Login Failed",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "p@v.com",
        "12345"
      ]
    },
    {
      "cells": [
        "j@v.com",
        "123456"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Negative Test - Use wrong UserID and Password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginFailure"
    }
  ]
});
formatter.step({
  "name": "Initialize \"Google Chrome\" webdriver",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_QAClick.initialize_something_webdriver(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Launch \"http://www.qaclickacademy.com/\" URL",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_QAClick.launch_something_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicks on \"Login\" hyperlink",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_clicks_on_something_hyperlink(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User gets redirected to \"Login\" Screen having \"Email Address\" , \"Password\" and \"Log In\" Web Elements present",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_gets_redirected_to_something_screen_having_something_something_and_something_web_elements_present(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User populates Email Address as \"p@v.com\" ,  Password as \"12345\" and Clicks \"Log In\" Button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_populates_Email_Address_as_Password_as_and_Clicks_Button(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Login Failed",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_login_failed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Negative Test - Use wrong UserID and Password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginFailure"
    }
  ]
});
formatter.step({
  "name": "Initialize \"Google Chrome\" webdriver",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition_QAClick.initialize_something_webdriver(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Launch \"http://www.qaclickacademy.com/\" URL",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_QAClick.launch_something_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicks on \"Login\" hyperlink",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_clicks_on_something_hyperlink(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User gets redirected to \"Login\" Screen having \"Email Address\" , \"Password\" and \"Log In\" Web Elements present",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_gets_redirected_to_something_screen_having_something_something_and_something_web_elements_present(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User populates Email Address as \"j@v.com\" ,  Password as \"123456\" and Clicks \"Log In\" Button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_populates_Email_Address_as_Password_as_and_Clicks_Button(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Login Failed",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition_QAClick.user_login_failed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});