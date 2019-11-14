Feature: On Caliber 2 homepage
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
				
	Scenario Outline: The user is viewing the Last Quaility Audit
		When The user clicks on performance "<Performance>"
		Then The user toggles display of associates graded as "<Performance>"
		
		Examples:
		|Performance|Performance|
		|Poor|Poor|
		|Average|Average|
		|Good|Good|
		|Superstar|Superstar|
		
	Scenario Outline: The user is filtering the Last Quality Audit
		When The user clicks on the States dropdown
		When The user clicks on state "<State>"
		Then The user can see stats for "<State>"
		
		Examples:
		|State|State|
		|TX|TX|
		|MI|MI|
		|FL|FL|
		
	Scenario Outline: The user is viewing the A given State
		Given The user is viewing "<State>"
		When The user clicks on the Cities dropdown
		When The user clicks on city "<City>"
		Then The user can see stats for "<City>"
		
		Examples:
		|State|City|City|
		|TX|Dallas|Dallas|
		|MI|Detroit|Detroit|
		|FL|Tampa|Tampa|

	Scenario Outline: The user removes a week
		Given The user is on the home page
		When The user clicks on "<Week>"
		Then The table is updated
		
		Examples:
		|Week|
		|Week 1|
		|Week 2|
		|Week 3|
		|Week 4|
		|Week 5|
		|Week 6|
		
	Scenario: The user removes all weeks
		Given The user is on the home page
		When The user removes all weeks
		Then The table is empty
			
	Scenario: The user adds a week
		Given The user is on the home page
		When The user clicks the include weeks button
		When The user selects a week
		Then The table is updated
		
	Scenario: The user is viewing missing grade reports
		Given The user is on the home page
		When The user clicks on all weeks
		Then The user sees no results
		
		When The user clicks on one week
		Then The user sees all reports that include that week