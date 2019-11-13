Feature: on Caliber 2 Quality Audit page
	 Background: User on Caliber 2
	 	Given: User on quality audit page
	 
	 Scenario outline: search batch by first name, last name, curriculum
	 	Given: User on quality audit page 
	 	When: User clicks on Select Batch
	 	When: User types "<search>" in search bar
	 	Then: The batch should be "<batch>"
	 	
	 Examples:
	 |search|batch|
	 |dan|Dan Pickles - PETA BPM - 10/7/2019|
	 |dan|Dan Pickles - PETA BPM - 11/9/2019|
	 |church|Natalie Church - Full Stack Java/JEE - 7/9/20199|
	 |church|Natalie Church - Full Stack Java/JEE - 11/9/2019|
	 |church|Ashley Church - Full Stack Java/JEE - 7/9/2019|
	 |pega bpm|Dan Pickles - PETA BPM - 10/7/2019|
	 |pega bpm|Dan Pickles - PETA BPM - 11/9/2019|
	 
	 
	 	
	 Scenario: select week
	 	Given: User selects a batch
	 	When: User clicks available week
	 	Then: User views current trainees with results of technical skills and soft skills with notes of that week

	 Scenario: update trainee technical skills
	 	Given: User selects a batch
	 	When: User selects a week
	 	When: User selects star under technical skills of first trainee
	 	Then: First trainee has star in technical skills
	 		
	 Scenario: update trainee soft skills
	 	Given: User selects a batch
	 	When: User selects a week
	 	When: User selects star under soft skills of first trainee
	 	Then: First trainee has star in soft skills
	
	 Scenario outline: add trainee notes
	 	Given: User selects a batch
	 	When: User selects a week
	 	When: User types "<comment>" in notes section
	 	Then: First trainee notes should be "<notes>"
	 	
	 	|comment|notes|
	    |good job|good job|
	    
	    
	    
	    
	 Scenario outline: Add comment
	 Given: User selects a batch
	 When: User click pencil icon beside trainee
	 When: User clicks Green flag
	 When: User types "<comment>" in comment section
	 When: User clicks Update Comment button
	 Then: Comment "<response>" added with green/red flag icon beside Trainee
	
	|comment|response|
	|good job|good job|
	
	Scenario: Delete comment
	Given: User selects a batch
	When: User clicks flag icon beside trainee
	When: User clicks Delete Comment button
	When: User clicks are you sure button
	Then: comment is deleted from trainee
	
	Scenario: Cancel update comment
	Given: User selects a batch
	When: User clicks pencil icon beside trainee
	When: User clicks cancel button
	Then: no changes are made
	
	
	
	
	 Scenario outline: filter batches
	 	Given: User on quality audit page
	 	When: User selects "<year>" in year dropbox
	 	When: User selects "<quarter>" in quarter dropbox
	 	When: User clicks on Select Batch
	 	Then: batch "<batch>" should be displayed 
	
		|year|quarter|batch|
	 	|2019|Q2|Jake Smith - Full Stack Java/EE - 3/9/2019|
	 	
	 Scenario outline: filter zero batches
	 	Given: User on quality audit page
	 	When: User selects "<year>" in year dropbox
	 	When: User selects "<quarter>" in quarter dropbox
	 	When: User clicks on Select Batch
	 	Then: No batches found should be displayed
	 	
	 	|year|quarter|
	 	|2018|Q1|
	
	
	 Scenario: update overall qc status
	 	Given: User selects a batch
	 	When: User selects a week
	 	When: User selects smily face under overall QC Status
	 	Then: Smily face is displayed under overall QC Status
	 
	 Scenario outline: add overall qc feedback
	 	Given: User selects a batch
	 	When: User selects a week
	 	When: User types "<comment>" in Overall QC Feedback section
	 	Then: feedback should display "<feedback>"
	 	
	 	|comment|feedback|
	 	|good job|good job|
	
	
	 	
	 Scenario: Don't add new week 
	 	Given: User selects a batch
	 	When: User clicks + button next to latest week
	 	When: User clicks no
	 	Then: no changes are made to page
	 
	 Scenario: Do add new week
	 	Given: User selects a batch
	 	When: User clicks + button next to latest week
	 	When: User clicks yes
	 	Then: new week is added to page
	 
	 Scenario: add categories to current week
	 	Given: User select a batch
	 	When: User clicks + button next to categories this week:
	 	When: User clicks category from dropdown menu
	 	Then: category tag is displayed on page
	 
	 Scenario: save button works
	 	Given: User selects a batch
	 	When: User clicks save button
	 	Then: Changes saved to page
	 	
	 	
	 	

