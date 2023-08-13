package pageobject;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	String mainWindow;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void fillText(WebElement el, String text) {
		waiting(1000);
		highlightElement(el, "orange", "yellow");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		waiting(1500);
		highlightElement(el, "black", "red");
		el.click();
		waiting(1500);
	}

	public String getText(WebElement el) {
		waiting(1000);
		highlightElement(el, "blue", "");
		return el.getText();
	}
	
	public boolean isDisplayed(WebElement el) {
		return el.isDisplayed();
	}

	public void waiting(long mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {

		}
	}
	public void selectByValue(WebElement el, String name) {
		waiting(1000);
		highlightElement(el, "", "orange");
		Select s = new Select(el);
		s.selectByValue(name);
	}
	
	public void waitForElemenetToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waitForElemenetToBeinvisible(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOfAllElements(el));
	}
	
	public void waitForElemenetToBevisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOfAllElements(el));
	}
	
	public String getAttribute(WebElement el, String name) {
		highlightElement(el, "blue", "");
		return el.getAttribute(name);	
	}	
	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
	}
	public void backToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}	
	protected void highlightElement(WebElement element, String color, String bgColor) {
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 3px solid " + color + ";background-color: " + bgColor + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
}




















