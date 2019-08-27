Feature: Testing the QA Page
	Scenario: Ensure the first user is correct
		Given The user is on the Caliber2 QA page
		When The user clicks on Quality Audit
		Then The first trainee is Adams, Gary
	Scenario: Ensure the user can give feedback emojis
		When The user clicks on individual feedback
		When The user clicks on frown
		Then The feedback will be frown
# add more tests as necessary