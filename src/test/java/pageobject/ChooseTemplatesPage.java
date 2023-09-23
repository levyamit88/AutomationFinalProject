package pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ChooseTemplatesPage extends BasePage {

	public ChooseTemplatesPage(WebDriver driver) {
		super(driver);
	}

//	Elements names
	@FindBy(css = ".cursor-pointer .py-1")
	private List<WebElement> categoryBtn;
	@FindBy(css = ".divide-gray-100 .justify-between")
	private List<WebElement> templateType;
	@FindBy(css = ".rounded.shadow.group")
	private List<WebElement> templateArea;
	@FindBy(css = ".align-middle")
	private List<WebElement> templatTitle;
	@FindBy(css = "a.block.py-2.text-sm.text-white")
	private WebElement chooseBtn;

//	Testing methods
	public void chooseTemplateType(String categoryName, String templateTypeName) {
		for (WebElement el : categoryBtn) {
			if (getText(el).equalsIgnoreCase(categoryName)) {
				for (WebElement el1 : templateType) {
					if (getText(el1).toLowerCase().contains(templateTypeName)) {
						click(el1);
						break;
					}
				}
				break;
			}
		}
	}

	public void chooseTemplate(String templatTitle) {
		for (WebElement elArea : templateArea) {
			WebElement elTitle = elArea.findElement(By.cssSelector(".align-middle"));
			if (getText(elTitle).toLowerCase().contains(templatTitle)) {
				WebElement elBtn = elArea.findElement(By.cssSelector("a.block.py-2.text-sm.text-white"));
				Actions a = new Actions(driver);
				a.moveToElement(elBtn).click(elBtn).build().perform();
				break;
			}
		}

	}

}
