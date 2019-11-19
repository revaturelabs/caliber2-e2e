Feature: On Caliber category page
	Background: User on Caliber2
		Given The user is on the Caliber2 home page
		When the user clicks on the settings
		When the_user_clicks_on_category
	Scenario: The user goes add Assessment Category
		When The User clicks add assesment add fills in info
		Then The new Category appears in category list
	Scenario: The user edits an Assesment Category
		When The User clicks edit category and fills in info
		Then The category will appear edited
	Scenario: The user moves an active category to stale and back
		When The user clicks on an Active Categories
		Then The active category is moved to the stale category list
		When The user clicks on a Stale Category
		Then The stale category is moved to the active category list
