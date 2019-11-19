Feature: Manage Batch
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
		When the user clicks on manage batch
		
	Scenario Outline: Create Batch
		When The user clicks on create batch
		And The user fills in training name "<trainingName>"
		And The user selects training type <trainingType>
		And The user selects skill type <skillType>
		And the user selects location <location>
		And The user selects trainer <trainer>
		And The user selects co-trainer <co-trainer>
		And The user fills in startdate <startDate>
		And The user fills in end date <endDate>
		And the user fills in good gradesm <goodGrade>
		And The user fills in passing grades <passingGrade>
		And The user clicks the submit button
		Then The newly created batch should reflect the information given

			Examples:
			|trainingName|trainingType|skillType|location|trainer|co-trainer|startDate|endDate|goodGrade|passingGrade|
			|We Do Training|2|2|2|2|2|02022021|04042021|70|65|
			
	Scenario Outline: Import Batch
		When The user clicks import batch
		And The user inputs "<json>" into paste JSON field
		And The user clicks import grades
		Then The imported "<batch>" is in the list 
		
		#the batch variable is to identify the batch element in the list on the batch list page
		Examples: 
		|json|batch|   
		|importBatch.txt|Extreme Training|        
		
		Scenario Outline: Create trainee
		When  The user clicks show trainees in "<batch>"
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
		Then The trainee is displayed in trainee list
		
		Examples:
		|batch|fName|lName|email|phoneNumber|trainingStatus|skypeId|college|degree|major|recruiter|profileURL|techScreener|projectCompletion|
		
		
	Scenario Outline: Switch trainee to a different batch
		Given The user clicks show trainees in "<originalBatch>"
		When The user clicks on the switch batch button for a "<trainee>"
		And The user selects "<newBatch>" from batch list drop down
		And The user clicks the swich button
		And The user clicks the confirm button
		And The user clicks on the show trainee button on "<newBatch>"
		Then The "<traineeLName>" should appear in the trainee list
		
		Examples:
		|originalBatch|trainee|newBatch|
		
		
	Scenario Outline: Edit trainee data
		Given The user clicks show trainees in "<batch>"
		When The user clicks the edit trainee button on "<trainee>"
		And The user inputs "<fName>" in the first name field
		And The user inputs "<lName>" in the last name field
		And The user inputs "<email>" in the email field
		And The user inputs "<phoneNumber>" in the phone number field
		And The user selects <trainingStatus> from training status drop down
		And The user inputs "<skypeId>" in the skype ID field
		And The user inputs "<college>" in the college field
		And The user inputs "<degree>" in the degree field
		And The user inputs "<major>" in the major field
		And The user inputs "<recruiter>" in the recruiter field
		And The user inputs "<profileURL>" in the profile URL field
		And The user inputs "<techScreener>" in the tech screener field
		And The user inputs "<projectCompletion>" in the project completion field
		And The user clicks the update button
		Then The "<trainee>" should reflect changes
		
		 Examples:
		 |batch|trainee|fName|lName|email|phoneNumber|trainingStatus|skypeId|college|degree|major|recruiter|profileURL|techScreener|projectCompletion|
	
		
	Scenario Outline: Remove trainee
		When The user clicks show trainees in "<batch>"
		And The user clicks remove trainee button on "<trainee>"
		And The user clicks the delete button in alert
		And The user clicks confirm delete button in next alert
		Then The "<trainee>" should be removed from the trainee list
		
		Examples:
		|batch|trainee|
		
	Scenario Outline: Edit batch details fields by text entry
		When user click on the edit batch button on "<batch>"
		And The user inputs "<traningName>" in training name
		And The user selects <skillType> in skill type
		And The user selects <trainingType> in training type
		And The user selects <location> in location
		And The user selects <trainer> in trainer
		And The user selects <coTrainer> in coTrainer
		And The user inputs <startdate> in start date
		And The user inputs <endDate> in end date
		And The user inputs <goodGrade> in good grade
		And The user inputs <passingGrade> in passing grade
		And The user clicks the update button
		Then Batch details should reflect changes
		
		Examples:
		|batch|trainingName|skillType|trainingType|location|trainer|coTrainer|startDate|endDate|goodGrade|passingGrade|
		|1|TestTrainingName|2|2|2|2|2|01012020|03012020|80|60|
		
	Scenario Outline: Delete batch
		When The user clicks the delete batch button on "<batch>"
		And The user clicks the delete button in the alert
		And The user clicks confirm delete in the next alert
		Then The "<batch>" should be missing from batch list
		
		Examples:
		|batch|
	
	
	
	