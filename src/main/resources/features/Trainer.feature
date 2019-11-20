Feature: Trainer Management
	Background: User on caliber 2 trainer page
		Given The user is on the Caliber2 home page
		When the user clicks on the settings
		When the user clicks on the trainer
		
	Scenario Outline: The user makes a new trainer
		When The user clicks new trainer
		When The user inputs "<trainer_name>" into name input
		When The user inputs "<trainer_email>" into email input
		When The user inputs "<trainer_title>" into title input
		When The user selects "<trainer_role>" from list
		When The user clicks submit
		Then The new trainer has information "<result_name>" and "<result_email>" and "<result_title>" and "<result_role>"
		
		Examples: 
		|trainer_name|trainer_email|trainer_title|trainer_role|result_name|result_email|result_title|result_role|
		|Test Creation|example@example.com|Lead Trainer|ROLE_TRAINER|Test Creation|example@example.com|Lead Trainer|ROLE_TRAINER|
	
	Scenario Outline: The user edits a trainer name
		When The user clicks edit trainer for trainer "<listed_name>"
		When The user inputs "<trainer_name>" into edit name input
		Then The trainers name should be "<trainer_name>"
		
		Examples:
		|listed_name|trainer_name|trainer_name|
		|New|Updated Trainer|Updated Trainer|
		
	Scenario Outline: The user edits a trainer email
		When The user clicks edit trainer for trainer "<listed_name>"
		When The user inputs "<trainer_email>" into edit email input
		Then The trainers email should be "<trainer_email>"
		
		Examples:
		|listed_name|trainer_email|trainer_email|
		|Test Creation|updated@updated.com|updated@updated.com|
		
	Scenario Outline: The user edits a trainer title
		When The user clicks edit trainer for trainer "<listed_name>"
		When The user inputs "<trainer_title>" into edit title input
		Then The trainers title should be "<trainer_title>"
		
		Examples:
		|listed_name|trainer_title|trainer_title|
		|Test Creation|Updated Title|Updated Title|
	
	Scenario Outline: The user edits a trainer role
		When The user clicks edit trainer for trainer "<listed_name>"
		When The user selects "<trainer_role>" from edit list
		Then The trainers role should be "<trainer_role>"
		
		Examples:
		|listed_name|trainer_role|trainer_role|
		|Test Creation|ROLE_PANEL|ROLE_PANEL|
		
		
	Scenario Outline: The user makes a trainer inactive
		When The user clicks inactive on a trainer "<listed_name>"
		When The user clicks on confirm
		Then The trainer "<listed_name>" is made inactive
		
		Examples:
		|listed_name|
		|temp|
		
	Scenario Outline: The user makes a trainer active
		When The user clicks edit trainer for trainer "<listed_name>"
		When The user selects "<trainer_role>" from edit list
		When The user clicks update
		Then The trainers role should be "<trainer_role>"
		
		Examples:
		|listed_name|trainer_role|trainer_role|
		|temp|ROLE_TRAINER|ROLE_TRAINER|		
		