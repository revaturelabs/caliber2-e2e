This file is to describe some of the conventions developed for creation of the Page Object Models in Caliber 2.

Front-End naming conventions.
    When given the project, most of the front-end did not have component IDs, so the convention of: (component-name-functionality) was adopted.
        Key areas to id were input fields, buttons, tables, dropdowns.
        ie:
            qc-feedback-dropdown-toggle  -- this is an button that opens a dropdown in the QC feedback area.
            quality-audit-list-table  -- this is the primary table of the quality audit page
            batch-select-dropdown-open-button  -- this is a button that opens the dropdown to search/select batches
            batch-select-dropdown-list  -- this is the container for the selectable items in a dropdown

POM
    The Page Object Models made use of 3 primary naming conventions.
        If the method is created using selenium's annotation method, then it has no prefix.
        If the method is manually created and is returning a WebElement then it is prefixed with get.
        If the method performs a simple action such as a common click or dropdown select, then the method is prefixed with click or select as appropriate.
    Another common occurance in the POMs is that a method will take in a webelement and return a subelement of the given element.
        This occures most often with tables where the test will iterate through the rows and pass the row into another method to fetch a subelement out of the row.