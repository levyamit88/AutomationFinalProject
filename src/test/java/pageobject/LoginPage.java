package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

//	Elements names
	@FindBy(css = "[type='email']")
	private WebElement emailField;
	@FindBy(css = "[type='password']")
	private WebElement passwordField;
	@FindBy(css = "[data-icon='arrow-right-to-bracket']")
	private WebElement signInBtn;
	@FindBy(css = "div #cookiescript_accept")
	private WebElement cookiesAcceptBtn;
	@FindBy(css = "[title='These credentials do not match our records.']")
	private WebElement errorMsg;
	@FindBy(css = "[title='The email field is required.']")
	private WebElement emailErrorMsg;
	@FindBy(css = "[title='The password field is required.']")
	private WebElement passwordErrorMsg;

//	Testing Methods
	public void login(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(signInBtn);
	}

	public void cookiesWindow() {
		try {
			waiting(500);
			click(cookiesAcceptBtn);
		} catch (Exception e) {
		}
	}

//	Validations methods
	public String getErrorMsg() {
		return getText(errorMsg).toLowerCase();
	}

	public String getEmailErrorMsg() {
		return getText(emailErrorMsg).toLowerCase();
	}

	public String getPasswordErrorMsg() {
		return getText(passwordErrorMsg).toLowerCase();
	}

}
