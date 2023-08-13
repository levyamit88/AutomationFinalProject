package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurePgae extends BasePage {

	public ConfigurePgae(WebDriver driver) {
		super(driver);
	}

//	Elements names
	@FindBy(css = ".flex.justify-between>button")
	private WebElement publishBtn;
	@FindBy(css = ".mt-4.block")
	private WebElement errorMsg;
	@FindBy(css = ".inline-block:nth-child(1)")
	private WebElement cancelBtn;
	@FindBy(css = "[title='Workspace: My Workspace']")
	private WebElement myWorkspaceBtn;

//	Testing methods	
	public void clickPublish() {
		click(publishBtn);
	}

//	Validations methods
	public String getErrorMsg() {
		try {
			return getText(errorMsg).toLowerCase();
		} catch (Exception e) {
			click(cancelBtn);
			click(myWorkspaceBtn);
		}
		return "";
	}

}
