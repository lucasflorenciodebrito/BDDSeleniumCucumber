Feature: Costumers

Scenario: Add new Costumer
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on costumers Menu
	And click on costumers Menu Item
	And click on Add new button
	Then User can view Add new costumer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new costumer has been added sucessfully."
	And close browser

Scenario: Search Customer by EmailID
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on costumers Menu
	And click on costumers Menu Item
	And Enter customer Email
	When Click on search button
	Then User should found Email in the Search table
	And close browser