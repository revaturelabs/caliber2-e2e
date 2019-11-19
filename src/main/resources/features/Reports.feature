Feature: Report Feature
	Background: The user is on the reports page
	Given The user is on the Caliber2 home page
	When the user clicks on reports

Scenario: Select Batch Year
	When The user selects a year from the dropdown for year
	Then The select batch drop down is populated
	
Scenario Outline: Search Batch by Criteria
	When The user selects a year "<year>"
	And The user clicks the select batch dropdown
	And The user inputs a "<criteria>" into the search bar
	Then The batch dropdown should contain items matching the "<criteria>"
	
		Examples: 
		|criteria|year|
		|Dan|2020|
		|Pickles|2019|
		|Shelby|2018|
		
Scenario Outline:  Select Week to view reports
	When The user selects a year "<year>"
	When The user selects a batch "<batch>"
	Then A week selection drop down menu should be visible
	And populated with how many "<entries>" they have in that batch
	
	Examples:
	|year|batch|entries|
	|2020|Natalie Church - Full Stack Java/JEE - 11/9/2019|4|
	|2019|Dan Pickles - PEGA BPM - 10/7/2019|13|
	|2018|James K - Full Stack Java/JEE - 7/9/2018|10|
	
Scenario Outline: Selecting All trainees and all weeks
	When The user selects a year "<year>"
	And The user selects a batch "<batch>"
	And The user selects all trainees
	And The user selects all weeks
	Then The dashboard will populate information
	And The table should have the correct number of week columns
	And All cells should have an icon
	
	Examples:
	|year|batch|
	|2019|Dan Pickles - PEGA BPM - 10/7/2019|
	
Scenario Outline: Selecting specific trainees and All weeks
	When The user selects a year "<year>"
	And The user selects a batch "<batch>"
	And The user selects a trainee "<trainee>"
	And The user selects all weeks
	Then The dashboard will populate individual scores

	Examples:
	|year|batch|trainee|
	|2019|Dan Pickles - PEGA BPM - 10/7/2019|Martin, Andrew|
	
Scenario Outline: Selecting specific trainees and specific week
	When The user selects a year "<year>"
	And The user selects a batch "<batch>"
	And The user selects a trainee "<trainee>"
	And The user selects a report week "<week>"
	Then The dashboard will populate individual scores
	
	Examples:
	|year|batch|trainee|week|
	|2019|Dan Pickles - PEGA BPM - 10/7/2019|Martin, Andrew|Week 1|
	
Scenario Outline: Selecting specific all trainees and specific week
	When The user selects a year "<year>"
	And The user selects a batch "<batch>"
	And The user selects all trainees
	And The user selects a report week "<week>"
	Then The dashboard will populate charts

	Examples:
	|year|batch|week|
	|2019|Dan Pickles - PEGA BPM - 10/7/2019|Week 1|
























