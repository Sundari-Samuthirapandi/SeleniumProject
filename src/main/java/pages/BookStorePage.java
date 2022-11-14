package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import common.BaseFunction;

public class BookStorePage extends BaseFunction{
	
	public void selectBookFromBookStore(String bookName) {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		scrollAndClick( driver.findElement(By.linkText(bookName)));
	}

}
