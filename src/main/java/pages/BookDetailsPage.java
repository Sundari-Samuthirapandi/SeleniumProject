package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BaseFunction;

public class BookDetailsPage extends BaseFunction{
	
	@FindBy(xpath = "//button[text()='Add To Your Collection']")
	private WebElement addToCollectionBtn;
	
	@FindBy(xpath = "//button[text()='Back To Book Store']")
	private WebElement backToBookStoreBtn;
	
	public void addBookToUserCollection() {
		scrollAndClick(addToCollectionBtn);
		acceptAlert();
	}
	
	
	public void backToBookStore() {
		scrollAndClick(backToBookStoreBtn);
	}

}
