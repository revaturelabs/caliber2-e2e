Feature: Location Management
	Background: User on caliber 2 location Page
		Given The user is on the Caliber2 home page
		When the user clicks on the settings
		When the user clicks on the location
		
	Scenario Outline: The user adds a new location
		When The user clicks on add new location
		When The user types "<company>" into Company Name
		When The user types "<address>" into Street Address
		When The user types "<city>" into City
		When The user clicks on the Add State dropdown menu
		When The user selects "<state>"
		When The user types "<zip>" into Zipcode
		When The user clicks Save
		Then The location named "<company>" is added to the list of locations
		
		Examples:
		|company|address|city|state|zip|
		|Test Loc|1234 Testing St|Cheyanne|WY|13579|
		
	Scenario Outline: The Edit Location modal is populated
		When The user clicks on edit location for row <rowNum>
		Then The Company Name field should match Company for row <rowNum>
		Then The Street Address field should match Address for row <rowNum>
		Then The City field should match Address for row <rowNum>
		Then The State field should match Address for row <rowNum>
		Then The Zipcode field should match Address for row <rowNum>
		
		Examples:
		|rowNum|
		|1|
		
		
	Scenario Outline: The user modifies location Name
		When The user clicks on edit location for row <rowNum>
		When The user types "<company>" into edit Company Name
		When The user clicks Save edit
		Then The name field for the location at row <rowNum> is updated with "<company>"

		Examples:
		|rowNum|company|
		|1|Nintendo|
		|1|Sony|
		
	Scenario Outline: The user modifies location Address
		When The user clicks on edit location for row <rowNum>
		When The user types "<address>" into edit Street Address
		When The user clicks Save edit
		Then The address field for the location at row <rowNum> is updated with "<address>"
		
		Examples:
		|rowNum|address|
		|1|1123 Fib Road|
		|1|8080 Tomcat Blvd|
	
	Scenario Outline: The user modifies location City
		When The user clicks on edit location for row <rowNum>
		When The user types "<city>" into edit City
		When The user clicks Save edit
		Then The city field for the location at row <rowNum> is updated with "<city>"
		
		Examples:
		|rowNum|city|
		|1|Honolulu|
		|1|London|
		
	Scenario Outline: The user modifies location State
		When The user clicks on edit location for row <rowNum>
		When The user clicks on the Edit State dropdown menu
		When The user selects "<state>" edit
		When The user clicks Save edit
		Then The state field for the location at row <rowNum> is updated with "<state>"
		
		Examples:
		|rowNum|state|
		|1|MN|
		|1|FL|
		
	Scenario Outline: The user modifies location Zipcode
		When The user clicks on edit location for row <rowNum>
		When The user types "<zip>" into edit Zipcode
		When The user clicks Save edit
		Then The zipcode field for the location at row <rowNum> is updated with "<zip>"
		
		Examples:
		|rowNum|zip|
		|1|12345|
		|1|98765|
		
		
	Scenario: The user makes a location inactive or active
		When The user clicks on make inactive or make active for first location
		When The user clicks Reactivate or Deactivate
		Then The location is made inactive or active
		
	Scenario: The user makes a location inactive or active
		When The user clicks on make inactive or make active for first location
		When The user clicks Reactivate or Deactivate
		Then The location is made inactive or active
		

