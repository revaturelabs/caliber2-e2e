Feature: Manage Batch
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
		And the user is on the manage batch page
		
	Scenario Outline: Create Batch
		When The user clicks on create batch
		And The user fills in "<trainingName>"
		And The user selects "<trainingType>"
		And The user selects "<skillType>"
		And the user selects "<location>"
		And The user selects "<trainer>" 
		And The user selects "<co-trainer>"
		And The user fills in "<startDate>" 
		And The user fills in "<endDate>"
		And the user fills in "<goodGrade>"
		And The user fills in "<passingGrade>"
		Then The user should be directed to batch list page but that doesnt work so i guess you can just deal with it

			Examples:
			|trainingName|trainingType|skillType|location|trainer|co-trainer|startDate|endDate|goodGrade|passingGrade|
			
			
	Scenario Outline: Import Batch
		When The user clicks import batch
		And The user inputs "<json>" into paste JSON field
		And The user clicks import grades
		Then The user is on the batch list page
		And The imported "<batch>" is in the list 
		
		#the batch variable is to identify the batch element in the list on the batch list page
		Examples: 
		|json|batch|           
	
	Scenario Outline: Select batch by year
		When The user selects "<year>" in drop down
		Then The batch list displays "<result>" that match
		
		Examples:
		|year|result|
		
		
	Scenario Outline: Show traniees
		When The user selectss "<year>" in drop down
		And The user clicks show trainees in "<batch>"
		Then "<result>" is displayed
		
		Examples:
		|year|batch|result|
		
		
		Scenario Outline: Show traniees
		When The user selectss "<year>" in drop down
		And The user clicks show trainees in "<batch>"
		And The user clicks add trainee
		And The user inputs "<fName>" in the first name field
		And The user inputs "<lName>" in the last name field
		And The user inputs "<email>" in the email field
		And The user inputs "<phoneNumber>" in the phone number field
		And The user selects "<trainingStatus>" from training status drop down
		And The user inputs "<skypeId>" in the skype ID field
		And The user inputs "<college>" in the college field
		And The user inputs "<degree>" in the degree field
		And The user inputs "<major>" in the major field
		And The user inputs "<recruiter>" in the recruiter field
		And The user inputs "<profileURL>" in the profile URL field
		And The user inputs "<techScreener>" in the tech screener field
		And The user inputs "<projectCompletion>" in the project completion field
		And The user clicks create button
		Then "<result>" is displayed in trainee list
		
		Examples:
		|fName|lName|email|phoneNumber|trainingStatus|skypeId|college|degree|major|recruiter|profileURL|techScreener|projectCompletion|result|
		
		
	Scenario Outline: Switch trainee to a different batch
		Given The user selects a "<year>" in drop down
		And The user clicks show trainees in "<originalBatch>"
		When The user clicks on the switch batch button for a "<trainee>"
		And The user selects "<newBatch>" from batch list drop down
		And The user clicks the swich button
		And The user clicks the confirm button
		And The user clicks on the show trainee button on "<newBatch>"
		Then The "<trainee>" should appear in the trainee list
		
		Examples:
		|year|originalBatch|trainee|newBatch|
		
		
	Scenario Outline: Edit trainee data
		Given The user selects a "<year>" in drop down
		And The user clicks show trainees in "<batch>"
		When The user clicks the edit trainee button on "<trainee>"
		And The user updates "<contents>" in "<field>"
		And The user clicks the update button
		Then The "<trainee>" "<field>" should match "<contents>"
		
		 Examples:
		 |year|batch|trainee|contents|field|
		 
		 
	Scenario Outline: Edit trainee status
		Given The user selects a "<year>" in drop down
		And The user clicks show trainees in "<batch>"
		When The user clicks the edit trainee button on "<trainee>"
		And The user selects "<contents>" in training status drop down
		And The user clicks the update button
		Then The "<trainee>" training status field  should match "<contents>"
		
		Examples:
		|year|batch|trainee|contents|
		
	
		
	Scenario Outline: Remove trainee
		Given The user selects a "<year>" in drop down
		And The user clicks show trainees in "<batch>"
		When The user clicks remove trainee button on "<trainee>"
		And The user clicks the delete button in alert
		And The user clicks confirm delete button in next alert
		Then The "<trainee>" should be removed from the trainee list
		
		Examples:
		|year|batch|trainee|
		
	Scenario Outline: Edit batch details fields by text entry
		Given The user selects a "<year>" in drop down
		When user click on the edit batch button on "<batch>"
		And The user updates "<contents>" in "<field>"
		And The user clicks the update button
		Then The "<batch>" "<field>" should match "<contents>" 
		
		Examples:
		|year|batch|contents|field|
		
	Scenario Outline: Edit batch details fields by selection
		Given The user selects a "<year>" in drop down
		When user click on the edit batch button on "<batch>"
		And The user selects "<contents>" in "<field>" dropdown
		And The user clicks the update button
		Then The "<batch>" "<field>" should match "<contents>" 
		
		Examples: 
		|year|batch|contents|field|
		
	Scenario Outline: Delete batch
		Given The user selects a "<year>" in drop down
		When The user clicks the delete batch button on "<batch>"
		And The user clicks the delete button in the alert
		And The user clicks confirm delete in the next alert
		Then The "<batch>" should be missing from batch list
		
		Examples:
		|year|batch|
	
	
	
	