package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseFunction extends DriverProperties{
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	
	public void sendText(WebElement element, String valueToBeEntered) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(valueToBeEntered);
		
	}

	public void scrollAndClick( WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
	}
	
	public String getTextFromElement(WebElement element) {
		scrollToElement(element);
		return element.getText();
		
	}
	
	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
	}
	
	public void scrollToElement( WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
}
