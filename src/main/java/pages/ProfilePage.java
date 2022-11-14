package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import common.BaseFunction;


public class ProfilePage extends BaseFunction{
	
	@FindBy(id="gotoStore")
	private WebElement gotoStore;
	
	@FindBy(xpath = "//div[@class='action-buttons']//a")
	private List<WebElement> bookNames;
	
	@FindBy(xpath = "//label[contains(text(),'User Name')]/following-sibling::label")
	private WebElement userNameLabel;
	
	public void clickGoToBookStore() {
		scrollAndClick(gotoStore);
	}
	
	public String getUserName() {
		return getTextFromElement(userNameLabel);
	}
	
	public void verifyBookAddedIntoUserCollection(String expectedBookName) {
		boolean isBookAdded = false;
		for(WebElement element: bookNames) {
			System.out.println("I'm in for");
			if(getTextFromElement(element).equalsIgnoreCase(expectedBookName)) {
				System.out.println("I'm in If");
				isBookAdded = true;
				break;
			}
		}
		Assert.assertEquals(isBookAdded, true,"Book not added to User collection list");
	
	}
	
}
