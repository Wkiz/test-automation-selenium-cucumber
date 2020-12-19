package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.Constants;
import Utils.Utils;

public class GoogleSearchPage {

	public GoogleSearchPage () {}

	static WebDriver driver;
	
	public void openBrowser(String browser) {
		driver = Utils.openBrowser(browser);
	}
	public void openGoogleHomepage() {
		driver.navigate().to("https://www.google.com/");
		Utils.sleep(3000);
	}

	public void writeBookName(String searchText) {
		driver.findElement(By.xpath("//input[@title='Buscar']")).sendKeys(searchText);
		Utils.sleep(2000);
	}

	public void clickSearchButton() {
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		Utils.sleep(3000);
	}

	public boolean verifyPage(String pageName) {
		if(pageName.equalsIgnoreCase(Constants.SEARCH_RESULTS.getValor())) {
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
		Utils.sleep(2000);
	}
	
	public boolean verifySuggestionListIsDisplayed() {
		return driver.findElement(By.xpath("//ul[@role = 'listbox']")).isEnabled();
	}
	
	public void clickFirstListItem() {
		driver.findElement(By.xpath("(//ul[@role = 'listbox']//li)[1]")).click();
		Utils.sleep(2000);
	}
	
	public void quitDriver() {
		Utils.sleep(5000);
		Utils.quitDriver();
	}
}
