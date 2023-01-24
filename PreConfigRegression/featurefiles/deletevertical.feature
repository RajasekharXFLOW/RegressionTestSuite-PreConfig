@tag
Feature: Delete existing vertical feature
  I want to use this template for validating Delete Existing Vertical Functionality

  @tag1
  Scenario: Check Delete Existing Vertical Functionality
  Given i open browser with url = "https://preconfig-a13.expflow.in/auth/sign-in"
  Then i should see login page
  When i enter usrname as "onboarding@xflow.com"
  And i enter password as "xFlow@321"
  And i click on login
  When i click on delete vertical "Test Create new Vertical"
  Then i should see the vertical deleted "Test Create new Vertical"
  When i click logout
  When i close browser