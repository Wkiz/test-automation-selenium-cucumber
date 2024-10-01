package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.Constants;

public class GoogleSearchPage {

	private WebDriver driver;
	
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

	public void openGoogleHomepage() {
		driver.get("https://www.google.com/");
	}

	public void writeBookName(String searchText) {
		driver.findElement(By.xpath("//input[@title='Buscar']")).sendKeys(searchText);
	}

	public void clickSearchButton() {
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
	}

	public boolean verifyPage(String pageName) {
		if(pageName.equalsIgnoreCase(Constants.SEARCH_RESULTS.getValue())) {
			WebElement resultStats = driver.findElement(By.xpath("//div[@id='result-stats']"));
			if(resultStats.isDisplayed()) {
				System.out.println("Result Stats is displayed!");
				return true;
			} else {
				return false;
			}
		} else {
			WebElement page = driver.findElement(By.xpath("(//*[contains(text(), '"
					+ pageName + "')])[1]"));
			if(page.isEnabled()) {
				System.out.println("Page is displayed!");
				return true;
			} else {
				return false;
			}
		}
	}
	
	public String verifyTextBookResult() {
		return driver.findElement(By.xpath("(//div[@id = 'res']//a//span)[1]")).getText();
	}
	
	public void clickFirstResult () {
		driver.findElement(By.xpath("(//div[@id = 'res']//a//span)[1]")).click();
	}
	
	public boolean verifySuggestionListIsDisplayed() {
		return driver.findElement(By.xpath("//ul[@role = 'listbox']")).isEnabled();
	}
	
	public void clickFirstListItem() {
		driver.findElement(By.xpath("(//ul[@role = 'listbox']//li)[1]")).click();
	}
}
