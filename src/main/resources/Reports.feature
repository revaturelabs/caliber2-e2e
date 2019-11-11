Feature: Report Feature
	Background: The user is on the reports page
	Given The user is on Caliber 2 web page 
	And The user is in the Reports tab

Scenario: Select Batch Year
	When The user selects a year from the dropdown for year
	Then The select batch drop down is populated
	
Scenario Outline: Search Batch by Criteria
	When The user selects a "<year>"
	And The user clicks the select batch dropdown
	And The user inputs a "<criteria>"  into the search  bar
	Then The batch dropdown should contain items matching the "<criteria>"
	
		Examples: 
		|criteria|year|
		|Natalie|2020|
		|Church|2020|
		|Java|2020|
		|Dan|2020|
		|Pega|2020|
		|Pickles|2019|
		|Jake|2019|
		|BPM|2019|
		|Shelby|2018|
		|Hines|2018|
		|Jee|2018|
		
Scenario Outline:  Select Week to view reports
	Given The user selects a "<year>"
	When The user selects a "<batch>"
	Then A week selection drop down menu should be visible
	And populated with how many "<entries>" they have in that batch
	
	Examples:
	|year|batch|entries|
	|2020|Natalie Church - Full Stack Java/JEE - 11/9/2019|4|
	|2019|Dan Pickles - PEGA BPM - 10/7/2019|4|
	|2018|James K - Full Stack Java/JEE - 7/9/2018|10|
	
Scenario Outline: Selecting All trainees and all weeks
	When The user selects a "<year>"
	And The user selects a"<batch>"
	And The user selects all trainees
	And The user selects all weeks
#	Then The dashboard will populate  information
	
	Examples:
	|year|batch|
	
Scenario Outline: Selecting specific trainees and All weeks
	When The user selects a "<year>"
	And The user selects a"<batch>"
	And The user selects a "<trainee>"
	And The user selects all weeks
#Then The dashboard will populate  information

	Examples:
	|year|batch|trainee|
	
Scenario Outline: Selecting specific trainees and specific week
	When The user selects a "<year>"
	And The user selects a"<batch>"
	And The user selects a "<trainee>"
	And The user selects "<week>"
#Then The dashboard will populate  information
	
	Examples:
	|year|batch|trainee|week|
	
Scenario Outline: Selecting specific all trainees and specific week
	When The user selects a "<year>"
	And The user selects a"<batch>"
	And The user selects all trainees
	And The user selects "<week>"
#Then The dashboard will populate  information

	Examples:
	|year|batch|week|
	
























