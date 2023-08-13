package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RatingWindowPage extends BasePage {

	public RatingWindowPage(WebDriver driver) {
		super(driver);
	}

//	Elements names
	@FindBy(css = ".involveme_embed_popup-close")
	private WebElement closeBtn;
	@FindBy(css = "style")
	private WebElement windowTitle;
	@FindBy(css = ".rating-item")
	private List<WebElement> ratingNumber;
	@FindBy(css = "#cr4ew8m")
	private WebElement descriptionField;
	@FindBy(css = ".c-button")
	private WebElement submitBtn;
	@FindBy(css = ".wrapper>.c-button-link")
	private WebElement skipBtn;
	@FindBy(css = ".view-participant.embedded")
	private WebElement raitingPopUp;

//	Testing methods
	public void closeRatingWindow() {
		waitForElemenetToBevisible(closeBtn);
		click(closeBtn);
	}

}
