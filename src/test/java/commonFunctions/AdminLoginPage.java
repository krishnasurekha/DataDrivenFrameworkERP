package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	// define Repository for login elements
	@FindBy(xpath = "//button[@id='btnreset']")
	WebElement ObjReset;
	@FindBy(name = "username")
	WebElement ObjUser;
	@FindBy(xpath = "//input[@id='password']")
	WebElement Objpass;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjLogin;

	// method for login
	public void adminLogin(String user, String pass) {
		ObjReset.click();
		ObjUser.sendKeys(user);
		Objpass.sendKeys(pass);
		ObjLogin.click();
	}

}
