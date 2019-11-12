Feature: caliber 2 trainer page
	Background: User on caliber 2 trainer page
		Given The user is on the trainer page
	Scenario: the user makes a new trainer
		When The user clicks new trainer and fills in info
		Then The new trainer is listed among trainer list
	Scenario Outline: The user edits a trainer
		When The user clicks edit trainer and selects "<trainer_role>" from list
		Then The trainers role should be "<trainer_role>"
		
		Examples:
		|trainer_role|trainer_role|
		|ROLE_PANEL|ROLE_PANEL|
		|ROLE_VP|ROLE_VP|
		|ROLE_TRAINER|ROLE_TRAINER|
		|ROLE_QC|ROLE_QC|
		|ROLE_STAGING|ROLE_STAGING|
		|ROLE_INACTIVE|ROLE_INACTIVE|
		
		
	Scenario: The user makes a trainer inactive and active
		When the user clicks inactive on a trainer and confirms
		Then the trainer is made inactive
		When the user clicks make active on that trainer and confirms
		Then the trainer is made active
