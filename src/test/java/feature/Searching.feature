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
Feature: Checking the Searching functionality of amazon website
Background: User must be on home page
Given Open web browser
Then User must be on the amazon home page by clicking URL 


  @tag1
  Scenario: SF_TC_65_Relevant product
  Given Enter valid product on the home page and search
  Then read the name of product and compare with name of product searched
  
    
    @tag2
	Scenario: SF_TC_61_Description Text
	Given Enter Valid description of the product on home page and search
	Then Compare the actual and expected description
	
	
	 @tag3
	Scenario: SF_TC_66_Product image
	Given Enter valid product on the home page and search
	Then Check the products displayed are with images
	
	@tag4
		Scenario: SF_TC_68_Product price
	Given Enter valid product on the home page and search
	Then Check the products displayed are with prices
    

