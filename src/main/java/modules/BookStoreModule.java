package modules;

import org.openqa.selenium.JavascriptExecutor;

import common.BaseFunction;
import pages.BookDetailsPage;
import pages.BookStorePage;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProfilePage;

public class BookStoreModule extends BaseFunction {
	
	LoginPage login = new LoginPage();
	ProfilePage profile = new ProfilePage();
	BookDetailsPage detailsPage = new BookDetailsPage();
	BookStorePage bookStorePage = new BookStorePage();
	CommonPage commonPage = new CommonPage();
	

	public void performLogin(String userName, String password) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		login.sendUserName(userName);
		login.sendPwd(password);
		login.clickLogin();
	}
	
	public void goToBookStore() {
		commonPage.selectBookStoreMenu();
	}
	
	public String getUserName() {
		return profile.getUserName();
	}
	
	public void addBookToUserCollection(String bookName) {
		bookStorePage.selectBookFromBookStore(bookName);
		detailsPage.addBookToUserCollection();
		detailsPage.backToBookStore();
		
	}
	
	public void verifyBookAddedToUserProfile(String bookName) {
		commonPage.selectProfileMenu();
		profile.verifyBookAddedIntoUserCollection(bookName);
	}
	
	public void performLogout() {
		commonPage.clickLogout();
	}

}
