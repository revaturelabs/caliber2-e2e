Feature: Category Lists
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
		When the user clicks on the settings
		When the_user_clicks_on_category
		
	Scenario: The user goes add Assessment Category
		When The User clicks add assesment 
		When The User inputs the category name
		When The User clicks the add button
		When The User clicks the close button
		Then The new Category appears in category list
	Scenario: The user edits an Assesment Category
		When The User clicks edit category button 
		When The User clicks the dropdown box
		When The User selects category
		When The User edits category name
		When The User clicks the save button
		When The User clicks the edit close button
		Then The category will appear edited
	Scenario: The user moves an active category to stale and back
		When The user clicks on an Active Categories
		Then The active category is moved to the stale category list
		When The user clicks on a Stale Category
		Then The stale category is moved to the active category list