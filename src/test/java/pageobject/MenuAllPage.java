package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MenuAllPage extends BasePage {

	public MenuAllPage(WebDriver driver) {
		super(driver);
	}

//	Elements names	
	@FindBy(css = ".text-sm.font-medium.truncate")
	private WebElement accountName;

//	Validations methods
	public String itIsMyAccount() {
		return getText(accountName).toLowerCase();
	}

}
