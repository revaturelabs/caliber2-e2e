Feature: Assess Batch

	Background: the user is on the assess batch tab
		Given The user is on the Caliber2 home page
		When the user clicks on assess batch
		Then the user should be on the assess batch page
		
	Scenario Outline: find batch based on criteria
		When the user clicks on the year dropdown
		When the user chooses a <year>
		When the user clicks on quarter dropdown
		When the user chooses a <quarter>
		When the user clicks on select batch dropdown
		When the user enters <criteria> into the search bar
		When the user clicks on the first displayed result
		Then the page title should be <title>
		
		Examples:
		|year|quarter|criteria|title|
		|2019|Q4|natalie|temp|
		|2019|Q4|church|temp|
		|2019|Q4|java|temp|
		|2019|Q3|dan|temp2|
		|2019|Q3|pickles|temp2|
		|2019|Q3|pega|temp2|
		|2018|Q3|shelby|temp3|
		|2018|Q3|levinson|temp3|
		|2018|Q3|java|temp3|
		
	Scenario: select a week to view and assess
		Given the user is on a specific batch page
		When the user clicks on a specific week
		Then the details of that week should be displayed
	
	Scenario: add a week
		Given the user is on a specific batch page
		When the user clicks the plus button
		When the user clicks the yes button
		Then a new week should be displayed on the batch page
	
	Scenario: add an assessment to current week
		Given the user is on a specific batch page
		When the user clicks create assessment
		When the user fills out assessment information
		When the user clicks create assessment
		Then the batch page will update with the new information
	
	Scenario: import grades from revpro
		Given the user is on a specific batch page
		When the user clicks import grades
		When the user enters a valid json from revpro
		Then the batch page will be updated with the new information
	
	Scenario: calculate statistics
		Given the user is on a specific batch page with existing assessments
		When the user changes an assessment grade for a specific associate
		Then the statistics at the bottom of the page should update correctly
	
	Scenario: save changes
		Given the user is on a specific batch page and has made changes to the existing data
		When the user clicks save changes
		Then the batch information should update accordingly
	