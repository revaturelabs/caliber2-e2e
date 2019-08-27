Feature: Testing the QA Page
	Scenario: Ensure the first user is correct
		Given The user is on the Caliber2 QA page
		Then The first trainee is Adams, Gary
	Scenario: Ensure the user can give feedback emojis
		When The user clicks on individual feedback
		When The user clicks on frown
		Then The feedback will be frown
	Scenario: Ensure the user can leave text feedback
		When The user clicks on the first textbox
		When The user types hello world
		When The user hits save
		When The user is on the Caliber2 QA page
		Then The text feedback will be hello world
# add more tests as necessary