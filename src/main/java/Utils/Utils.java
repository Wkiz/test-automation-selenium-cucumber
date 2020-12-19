package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Utils {
	

	private static WebDriver driver;
	private static final String currentDirectory = System.getProperty("user.dir");
	
	public static WebDriver openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase(Constants.CHROME.getValor())) {
			System.setProperty("webdriver.chrome.driver", currentDirectory + "/src/test/resources/drivers/chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--lang=en");
			
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase(Constants.FIREFOX.getValor())) {
			System.setProperty("webdriver.gecko.driver", currentDirectory + "/src/test/resources/drivers/geckodriver.exe");
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-lang=en");
			
			driver = new FirefoxDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static void sleep(long millis) {
	    try {
	      Thread.sleep(millis);
	    } catch (InterruptedException e) {
	      System.out.println("Sleep fail: " + e);
	    }
	  }
	
	public static void quitDriver() {
		driver.quit();
	}
}
