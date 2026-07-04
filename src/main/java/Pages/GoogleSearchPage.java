package Pages;

import Utils.Config;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openGoogleHomepage() {
        driver.get(Config.getBaseUrl());
    }

    public void writeBookName(String searchText) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='q']|//input[@name='q']")));
        searchInput.clear();
        searchInput.sendKeys(searchText);
    }

    public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnK']")));
        searchButton.click();
    }

    public boolean verifyPage(String pageName) {
        if (pageName.equalsIgnoreCase(Constants.SEARCH_RESULTS.getValue())) {
            WebElement resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
            return resultStats.isDisplayed();
        }

        WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '" + pageName + "')])[1]")));
        return page.isDisplayed();
    }

    public String verifyTextBookResult() {
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='res']//a//span)[1]")));
        return firstResult.getText();
    }

    public void clickFirstResult() {
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='res']//a//span)[1]")));
        firstResult.click();
    }

    public boolean verifySuggestionListIsDisplayed() {
        WebElement suggestions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
        return suggestions.isDisplayed();
    }

    public void clickFirstListItem() {
        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@role='listbox']//li)[1]")));
        firstSuggestion.click();
    }
}
