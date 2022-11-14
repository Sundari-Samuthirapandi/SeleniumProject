package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProperties {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor javascriptExecutor;

	static {
		WebDriverManager.chromedriver().setup();
		System.out.println("Is driver null: "+ driver);
		if (driver == null) {
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 3000);
			javascriptExecutor = (JavascriptExecutor) driver;	
		}
	}

	public DriverProperties() {
		
		if (driver != null)
			PageFactory.initElements(driver, this);

	}

}
