package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProjectPage extends BasePage {

	public CreateProjectPage(WebDriver driver) {
		super(driver);
	}

//	Elements names
	@FindBy(css = "[title='Workspace: My Workspace']")
	private WebElement myWorkspaceBtn;

//	Testing methods
	public void backToMyWorkspace() {
		click(myWorkspaceBtn);
	}

}
