Feature: On Caliber 2 homepage
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
		
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
		When The user clicks on the States dropdown
		When The user clicks on state "<State>"		
		When The user clicks on the Cities dropdown
		When The user clicks on city "<City>"
		Then The user can see stats for "<City>"
		
		Examples:
		|State|City|City|
		|TX|Dallas|Dallas|
		|MI|Detroit|Detroit|
		|FL|Tampa|Tampa|

	Scenario Outline: The user removes a week
		When The user removes a week "<Week>"
		Then The table is updated minus week "<Week>"
		
		Examples:
		|Week|Week|
		|1|1|
		|2|2|
		|3|3|
		|4|4|
		|5|5|
		|6|6|
		
	Scenario: The user removes all weeks
		When The user removes all weeks
		Then The table is empty
			
	Scenario Outline: The user adds a week
		When The user removes all weeks
		When The user clicks the include weeks button
		When The user selects a week "<Week>"
		Then The table is updated plus week "<Week>"
		
		Examples:
		|Week|Week|
		|1|1|
		|2|2|
		|3|3|
		|4|4|
		|5|5|
		|6|6|