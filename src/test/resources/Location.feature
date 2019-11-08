Feature: using the Caliber 2 Location Page
	Background: User on caliber 2 location Page
		Given The user is on the caliber 2 location page
	Scenario: The user adds a new location
		When The user clicks on add new location and fills in info
		Then The location is added to the list of locations
	Scenario: The user edits a location
		When The user clicks on edit location and fills in info
		Then The location appears as edited
	Scenario: The user makes a location inactive and the active
		When Thee user clicks on make inactive and confirms
		Then The location is made inactive
		When The user clicks on make active and confirms
		Then the location is made active
		
