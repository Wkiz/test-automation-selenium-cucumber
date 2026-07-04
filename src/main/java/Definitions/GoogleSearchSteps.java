package Definitions;

import Pages.GoogleSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GoogleSearchSteps {

    private GoogleSearchPage googleSearchPage;

    public GoogleSearchSteps() {
    }

    private GoogleSearchPage getGoogleSearchPage() {
        if (googleSearchPage == null) {
            googleSearchPage = new GoogleSearchPage(Hooks.getDriver());
        }
        return googleSearchPage;
    }

    @Given("I go to the Google homepage")
    public void openGoogleHomepage() {
        getGoogleSearchPage().openGoogleHomepage();
    }

    @When("^I type (.*) into the search field$")
    public void writeBookName(String searchText) {
        getGoogleSearchPage().writeBookName(searchText);
    }

    @And("^I click the Google Search button$")
    public void clickSearchButton() {
        getGoogleSearchPage().clickSearchButton();
    }

    @Then("^the first result is (.*)$")
    public void verifyTextBookResult(String textResult) {
        Assertions.assertEquals(textResult, getGoogleSearchPage().verifyTextBookResult(textResult), "The first result is not in accordance with the given text!");
    }

    @When("^I click on the first result link$")
    public void clickFirstResult() {
        getGoogleSearchPage().clickFirstResult();
    }

    @Then("^I go to the (.*) page$")
    public void verifyPage(String pageName) {
        Assertions.assertTrue(getGoogleSearchPage().verifyPage(pageName), "Incorrect page!");
    }

    @And("^the suggestions list is displayed$")
    public void verifySuggestionListIsDisplayed() {
        Assertions.assertTrue(getGoogleSearchPage().verifySuggestionListIsDisplayed(), "Suggestion List not is displayed!");
    }

    @And("^I click on the first suggestion in the list$")
    public void clickFirstListItem() {
        getGoogleSearchPage().clickFirstListItem();
    }
}
