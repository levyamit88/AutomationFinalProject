package pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseProjectTypePage extends BasePage {

	public ChooseProjectTypePage(WebDriver driver) {
		super(driver);
	}

//  Elements names
	@FindBy(css = "#project-name")
	private WebElement projectNameField;
	@FindBy(css = ".col-selection")
	private List<WebElement> projectType;
	@FindBy(css = ".select-header")
	private WebElement projectBtn;
	@FindBy(css = ".modal-btn-start.swal-button")
	private WebElement startEditingBtn;
	@FindBy(css = "h4")
	private WebElement projectTypeTitle;

//	Testing methods
	public void fillProjectName(String name) {
		fillText(projectNameField, name);
	}

	public void chooseProjectType(String name) {
		for (WebElement elArea : projectType) {
			WebElement elTitle = elArea.findElement(By.cssSelector("h4"));
			if (getText(elTitle).equalsIgnoreCase(name)) {
				WebElement projectBtn = elArea.findElement(By.cssSelector(".select-header"));
				click(projectBtn);
				WebElement startEditingBtn = elArea.findElement(By.cssSelector(".modal-btn-start.swal-button"));
				click(startEditingBtn);
				break;
			}
		}

	}

}
