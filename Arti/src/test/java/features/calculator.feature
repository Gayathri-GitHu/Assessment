#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Home Loan Calculator
  The scenarios gives a way to find the Home Loan eligibility

  @Eligibilitycalculator
  Scenario Outline: Using the application to find the eligibility of availing Home loan
  Given Launch the application  
  Then Enter data into the fields and validate the eligibility
  	|applicationType|numberofDependant|propertytoBuy|annualIncome|otherIncome|livingExpense|homeLoanRepayment|otherRepayment|commitment|creditCardLimit|eligibility|
  	|Single|0|home|$80000|$10000|$500|$0|$100|$0|$10000|501,000|
  	#|Single|0|home|||$1||||||
	 And Click on Start over button
  Then Validate all the fields are empty
 

 