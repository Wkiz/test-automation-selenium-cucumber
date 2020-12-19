package Definitions;

import Pages.GoogleSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleSearchSteps {
	
	GoogleSearchPage googleSearchPage = new GoogleSearchPage();
	
	public GoogleSearchSteps() {}

	@Given("^I\\'m on the homepage on (.*)$")
	public void openGoogleHomepage(String browser) {
		googleSearchPage.openBrowser(browser);
		googleSearchPage.openGoogleHomepage();
	}

	@When("^I type (.*) into the search field$")
	public void writeBookName(String searchText) {
		googleSearchPage.writeBookName(searchText);
	}

	@And("^I click the Google Search button$")
	public void clickSearchButton() {
	    googleSearchPage.clickSearchButton();
	}

	@Then("^the first result is (.*)$")
	public void verifyTextBookResult(String textResult) {
		Assert.assertEquals("The first result is not in accordance with the given text!", textResult, googleSearchPage.verifyTextBookResult());
	}

	@When("^I click on the first result link$")
	public void clickFirstResult() {
		googleSearchPage.clickFirstResult();
	}

	@Then("^I go to the (.*) page$")
	public void verifyPage(String pageName) {
		Assert.assertTrue("Incorrect page!", googleSearchPage.verifyPage(pageName));
	}

	@And("^the suggestions list is displayed$")
	public void verifySuggestionListIsDisplayed() {
		Assert.assertTrue("Suggestion List not is displayed!", googleSearchPage.verifySuggestionListIsDisplayed());
	}

	@And("^I click on the first suggestion in the list$")
	public void clickFirstListItem() {
		googleSearchPage.clickFirstListItem();
	}
	
	@After("@AfterQuitDriver")
	public void endTest() {
		googleSearchPage.quitDriver();
	}
}
