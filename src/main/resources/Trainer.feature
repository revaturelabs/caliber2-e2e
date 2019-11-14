Feature: caliber 2 trainer page
	Background: User on caliber 2 trainer page
		When The user clicks on the settings
		When The user clicks on the trainer
		
	Scenario Outline: The user makes a new trainer
		When The user clicks new trainer
		When The user inputs "<trainer_name>" into name input
		When The user inputs "<trainer_email>" into email input
		When The user inputs "<trainer_title>" into title input
		When The user selects "<trainer_role>" from list
		When The user clicks submit
		Then The new trainer is listed among trainer list
		
		Examples: 
		|trainer_name|trainer_email|trainer_title|trainer_role|
		|Cheesey Burgs|example@example.com|Lead Trainer|ROLE_TRAINER|
		|Test Trainer|test@test.com|Senior Trainer|ROLE_TRAINER|
		|Test QC|qc@qc.com|Lead QC|ROLE_QC|
		|Test Staging|staging@staging.com|Lead Staging|ROLE_STAGING|
		|Test VP|vp@vp.com|Lead VP|ROLE_VP|
		|Test Panel|panel@panel.com|Lead Panel|ROLE_PANEL|
	
	Scenario Outline: The user edits a trainer name
		When The user clicks edit trainer
		When The user inputs "<trainer_name>" into name input
		Then The trainers name should be "<trainer_name>"
		
		Examples:
		|trainer_name|trainer_name|
		|Updated Trainer|Updated Trainer|
		|Test Trainer|Test Trainer|
		|Final Update|Final Update|
		
	Scenario Outline: The user edits a trainer email
		When The user clicks edit trainer
		When The user inputs "<trainer_email>" into email input
		Then The trainers email should be "<trainer_email>"
		
		Examples:
		|trainer_email|trainer_email|
		|updated@updated.com|updated@updated.com|
		|testing@testing.com|testing@testing.com|
		|realemail@email.com|realemail@email.com|
		
	Scenario Outline: The user edits a trainer title
		When The user clicks edit trainer
		When The user inputs "<trainer_title>" into title input
		Then The trainers title should be "<trainer_title>"
		
		Examples:
		|trainer_title|trainer_title|
		|Updated Title|Updated Title|
		|Real Role Title|Real Role Title|
		|Lead Title|Lead Title|
	
	Scenario Outline: The user edits a trainer role
		When The user clicks edit trainer
		When The user selects "<trainer_role>" from list
		Then The trainers role should be "<trainer_role>"
		
		Examples:
		|trainer_role|trainer_role|
		|ROLE_PANEL|ROLE_PANEL|
		|ROLE_VP|ROLE_VP|
		|ROLE_TRAINER|ROLE_TRAINER|
		|ROLE_QC|ROLE_QC|
		|ROLE_STAGING|ROLE_STAGING|
		|ROLE_INACTIVE|ROLE_INACTIVE|
		
		
	Scenario: The user makes a trainer inactive
		When The user clicks inactive on a trainer
		When The user clicks on confirm
		Then The trainer is made inactive
		
	Scenario Outline: The user makes a trainer active
		When The user clicks edit trainer
		When The user selects "<trainer_role>" from list
		When The user clicks update
		Then The trainers role should be "<trainer_role>"
		
		Examples:
		|trainer_role|trainer_role|
		|ROLE_TRAINER|ROLE_TRAINER|
		|ROLE_PANEL|ROLE_PANEL|
		|ROLE_VP|ROLE_VP|
		|ROLE_QC|ROLE_QC|
		|ROLE_STAGING|ROLE_STAGING|
		
	Scenario Outline: The edit trainer modal is autopopulated
		When The user clicks edit trainer
		Then The trainer name field should match trainer name for row "<row_num>"
		Then The trainer email field should match trainer email for row "<row_num>"
		Then The trainer title field should match trainer title for row "<row_num>"
		Then The trainer role field should match trainer role for row "<row_num>"
		
		Examples:
		|row_num|
		|1|
		
		
		
		