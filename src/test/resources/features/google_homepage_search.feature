#Author: Alexis Erazo - alexis1995xd@gmail.com
Feature: Google Homepage Search

  @FirstScenario @AfterQuitDriver
  Scenario Outline: User can search with "Google Search"
    Given I'm on the homepage on Firefox
    When I type <searchText> into the search field
    And I click the Google Search button
    Then I go to the search results page
    And the first result is <textResult>
    When I click on the first result link
    Then I go to the <pageName> page

    Examples: 
      | searchText            | textResult                                                    | pageName                     |
      | The name of the wind  | The Name of the Wind - Patrick Rothfuss                       | Patrick Rothfuss - The Books |
      | The canterville ghost | El fantasma de Canterville - Wikipedia, la enciclopedia libre | Canterville                  |

  @SecondScenario @AfterQuitDriver
  Scenario Outline: User can search by using the suggestions
    Given I'm on the homepage on Chrome
    When I type <searchText> into the search field
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then I go to the search results page
    And the first result is <textResult>
    When I click on the first result link
    Then I go to the <pageName> page

    Examples: 
      | searchText            | textResult                                                    | pageName                     |
      | The name of the w     | The Name of the Wind - Patrick Rothfuss                       | Patrick Rothfuss - The Books |
			| The canterville       | El fantasma de Canterville - Wikipedia, la enciclopedia libre | Canterville                  |