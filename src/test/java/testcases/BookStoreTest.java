package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import modules.BookStoreModule;

public class BookStoreTest extends BookStoreModule {

	SoftAssert softAssert = new SoftAssert();

	@BeforeSuite(alwaysRun = true)
	@Parameters("url")
	public void launchBrowser(String endpoint) {
		System.out.println("I'm in Before suite");
		driver.get(endpoint);
		driver.manage().window().maximize();
	}

	@BeforeTest(alwaysRun = true)
	public void login() {
		System.out.println("I'm in login");
		performLogin("seleniumAutomation", "Selenium@123");
		System.out.println("Username actual: " + getUserName());

	}

	@Test(dataProvider = "GetBookNames", priority = 1)
	public void test11(String bookName) {
		System.out.println("I'm in test 11");
		Assert.assertEquals(false, true);
		  System.out.println("At test for bookName : " + bookName); goToBookStore();
		  addBookToUserCollection(bookName); verifyBookAddedToUserProfile(bookName);
		 	}

	@Test(groups = { "Smoke", "Sanity" }, priority = 1, dependsOnMethods = "test11" )
	public void test2() {
		System.out.println("I'm in test 2");
	}

	@Test(groups = "Smoke", priority = 2)
	public void test3() {
		System.out.println("I'm in test 3");
	}

	@Test(groups = "regression", priority = 1, invocationCount = 3)
	public void test4() {
		System.out.println("I'm in test 4");
	}

	@Test(groups="sanity")
	public void test5(){
		System.out.println("I'm in test 5");
	}

	@AfterTest(alwaysRun = true)
	public void logout() {
		System.out.println("I'm in logout");
		performLogout();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		System.out.println("I'm in after suite");
		driver.quit();

	}

	@DataProvider(name = "GetBookNames")
	public Object[] getBookName() {
		return new String[] { "Programming JavaScript Applications", "You Don't Know JS",
				"Designing Evolvable Web APIs with ASP.NET" };
	}
}
