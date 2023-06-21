Feature: Login into salesforce application

Scenario: login with correct credentials
Given user opens salesforce application
When user on "Login Page"
When user enters correct username into text box as "lmdevalla@curious-unicorn-5zv0y8.com"
When user enters correct password into text box as "Lakshmi@2009"
When user clicks on Login button
When user on "Home Page"
Then verify home page title as "Home Page ~ Salesforce - Developer Edition"
