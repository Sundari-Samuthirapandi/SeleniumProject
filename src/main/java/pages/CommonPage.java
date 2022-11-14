package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BaseFunction;

public class CommonPage extends BaseFunction{
	
	@FindBy(xpath = "//span[text()='Profile']")
	private WebElement profileMenuOption;
	
	@FindBy(xpath = "//span[text()='Book Store']")
	private WebElement bookStoreMenuOption;
	
	@FindBy(xpath = "//button[text()='Log out']")
	private WebElement logoutBtn;
	
	public void selectProfileMenu() {
		scrollAndClick(profileMenuOption);
	}
	
	public void selectBookStoreMenu() {
		scrollAndClick(bookStoreMenuOption);
	}
	
	public void clickLogout() {
		click(logoutBtn);
	}

}
