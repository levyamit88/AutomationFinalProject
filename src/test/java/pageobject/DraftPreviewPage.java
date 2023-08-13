package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPreviewPage extends BasePage {

	public DraftPreviewPage(WebDriver driver) {
		super(driver);
	}

//	Elements names	
	@FindBy(css = ".preview-notice")
	private WebElement previewTitle;

//	Validations methods
	public String itIsPreview() {
		moveToNewWindow();
		waiting(2000);
		return getText(previewTitle).toLowerCase();
	}

}
