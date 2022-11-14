package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BaseFunction;

public class LoginPage extends BaseFunction {

	@FindBy(id = "userName")
	private WebElement userNameEle;

	@FindBy(id = "password")
	private WebElement passwordEle;

	@FindBy(id = "login")
	private WebElement loginBtn;

	public void sendUserName(String userName) {
		sendText(userNameEle, userName);
	}

	public void sendPwd(String pwd) {
		sendText(passwordEle, pwd);
	}

	public void clickLogin() {
		scrollAndClick(loginBtn);
	}

}