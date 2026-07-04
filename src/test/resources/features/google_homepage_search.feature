#Author: Alexis Erazo - alexis1995xd@gmail.com
Feature: Google Homepage Search

  Scenario Outline: User can search by using the suggestions
    Given I go to the Google homepage
    When I type <searchText> into the search field
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then I go to the search results page
    And the first result is <textResult>
    When I click on the first result link
    Then I go to the <pageName> page

    Examples: 
      | searchText            | textResult              | pageName               |
      | The name of the w     | The Name of the Wind    | the name of the wind   |
      | The canterville       | The Canterville Ghost   | Canterville            |