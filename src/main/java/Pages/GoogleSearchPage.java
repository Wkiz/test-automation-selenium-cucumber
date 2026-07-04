package Pages;

import Utils.Config;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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
        handleCaptchaIfPresent();
        if (pageName.equalsIgnoreCase(Constants.SEARCH_RESULTS.getValue())) {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.pollingEvery(Duration.ofMillis(500)).until(d -> d.getCurrentUrl().contains("/search")
                    || !d.findElements(By.cssSelector("div.g")).isEmpty()
                    || !d.findElements(By.cssSelector("a h3")).isEmpty());
            return true;
        }

        return wait.until(driver -> driver.getPageSource().contains(pageName) || driver.getTitle().contains(pageName));
    }

    public String verifyTextBookResult(String expectedText) {
        boolean found = wait.until(driver -> {
            List<WebElement> candidates = driver.findElements(By.xpath("//h3[contains(text(),'" + expectedText + "')] | //a[contains(text(),'" + expectedText + "')] | //span[contains(text(),'" + expectedText + "')]"));
            for (WebElement candidate : candidates) {
                if (candidate.isDisplayed()) {
                    String text = candidate.getText().trim();
                    if (!text.isEmpty() && text.toLowerCase().contains(expectedText.toLowerCase())) {
                        return true;
                    }
                }
            }
            return false;
        });

        if (found) {
            List<WebElement> candidates = driver.findElements(By.xpath("//h3[contains(text(),'" + expectedText + "')] | //a[contains(text(),'" + expectedText + "')] | //span[contains(text(),'" + expectedText + "')]"));
            for (WebElement candidate : candidates) {
                if (candidate.isDisplayed()) {
                    String text = candidate.getText().trim();
                    if (!text.isEmpty() && text.toLowerCase().contains(expectedText.toLowerCase())) {
                        return text;
                    }
                }
            }
        }

        return driver.getTitle();
    }

    public void clickFirstResult() {
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("main a[href], [role='main'] a[href], h3 a[href]")));
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

    private void handleCaptchaIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> iframes = shortWait.pollingEvery(Duration.ofMillis(500)).until(d -> {
                List<WebElement> frames = d.findElements(By.cssSelector("iframe[title*='reCAPTCHA'], iframe[src*='recaptcha/enterprise/anchor'], iframe[name*='a-']"));
                return frames.isEmpty() ? null : frames;
            });

            if (iframes == null || iframes.isEmpty()) {
                return;
            }

            for (WebElement iframe : iframes) {
                try {
                    shortWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

                    List<By> checkboxSelectors = Arrays.asList(
                            By.cssSelector("div.recaptcha-checkbox-border"),
                            By.cssSelector("div.recaptcha-checkbox-borderAnimation"),
                            By.cssSelector("span.recaptcha-checkbox"),
                            By.cssSelector("span#recaptcha-anchor"),
                            By.cssSelector("label.recaptcha-checkbox")
                    );

                    for (By selector : checkboxSelectors) {
                        List<WebElement> candidates = driver.findElements(selector);
                        if (!candidates.isEmpty()) {
                            WebElement checkbox = candidates.get(0);
                            if (checkbox.isDisplayed()) {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                                driver.switchTo().defaultContent();
                                return;
                            }
                        }
                    }
                } catch (Exception ignored) {
                    driver.switchTo().defaultContent();
                } finally {
                    driver.switchTo().defaultContent();
                }
            }
        } catch (Exception ignored) {
            driver.switchTo().defaultContent();
        }
    }
}
