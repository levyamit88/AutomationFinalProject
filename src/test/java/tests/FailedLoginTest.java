package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class FailedLoginTest extends BaseTest {

	@Override
	public void setupLogin() {
	}
	
	@Override
	public void setupRatingPopUp() {
	}
	
	@Override
	public void setupWorkSpace() {
		super.setupWorkSpace();
	}

	@Test (dataProvider = "getData")
	public void tc01_failedLogin(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.cookiesWindow();
		lp.login(email, password);
		String expected = "these credentials do not match our records.";
		Assert.assertEquals(lp.getErrorMsg(), expected);
	}	
	@DataProvider 
	public Object[][] getData(){
		String[][] data = {
				{"levyamit88@gmail.com", "121212"},
				{"levy1111@gmail.com", "Aa12121212@"},
				{"amitlevy88@gmail.com", "Aa13131313#"}
		};		
		return data;		
	}	
	@Test(description = "Login with invalid Email address")
	public void tc02_failedLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.cookiesWindow();
		lp.login(" ", "Aa12121212@");
		String expected = "the email field is required.";
		Assert.assertEquals(lp.getEmailErrorMsg(), expected);
	}
	@Test(description = "Login with invalid password")
	public void tc03_failedLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.cookiesWindow();
		lp.login("levyamit88@gmail.com", " ");
		String expected = "the password field is required.";
		Assert.assertEquals(lp.getPasswordErrorMsg(), expected);
	}

}
