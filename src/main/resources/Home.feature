Feature: On Caliber 2 homepage
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
	Scenario Outline: The user clicks on tabs
		When The user clicks on "<Tab>"
		Then The user is on the "<Tab>" page
		
		Examples:
		|Tab|Tab|
		|Manage Batch|Manage Batch|
		|Assess Batch|Assess Batch|
		|Quality Audit|Quality Audit|
		|Reports|Reports|
		|Home|Home|
		|Revature Icon|Home|
		
	Scenario Outline: The user clicks on settings options
		Given The user clicks on Settings
		When The user clicks on "<Option>"
		Then the user is on the "<Option>" page
		
		Examples:
		|Option|Option|
		|Trainers|Trainers|
		|Locations|Locations|
		|Category|Category|
		
	Scenario Outline: The user is viewing the Last Quaility Audit
		When The user clicks on "<Performance>"
		Then The user toggles display of associates graded as "<Performance>"
		
		Examples:
		|Performance|Performance|
		|Poor|Poor|
		|Average|Average|
		|Good|Good|
		|Superstar|Superstar|
		
	Scenario Outline: The user is filtering the Last Quality Audit
		When The user clicks on the States dropdown
		When The clicks on "<State>"
		Then The user can see stats for "<State>"
		
		Examples:
		|State|State|
		|TX|TX|
		|MI|MI|
		|FL|FL|
		
	Scenario Outline: The user is viewing the A given State
		Given The user is viewing "<State>"
		When The user clicks on the Cities dropdown
		When The clicks on "<City>"
		Then The user can see stats for "<City>"
		
		Examples:
		|State|City|City|
		|TX|Dallas|Dallas|
		|MI|Detroit|Detroit||
		|FL|Tampa|Tampa|

	Scenario: The user is viewing missing grade reports
		Given The user in on the home page
		When The user clicks on all weeks
		Then The user sees no results
		
		When The user clicks on one week
		Then The user sees all reports that include that week