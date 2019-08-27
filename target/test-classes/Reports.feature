Feature: Reports
	Scenario: The user clicks on the reports tab on the tool bar
		Given The user is on the Caliber2 home page
		When The user clicks on Reports
		Then The user should be on reports
		
	Scenario: The user selects the dropdown to change the year to 2018 from the default 2019
		Given The user is on the reports page
		When The user clicks the dropdown and clicks 2018
		Then The user will have the reports for 2018 displayed
	