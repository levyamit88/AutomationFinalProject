package tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.LoginPage;
import pageobject.ProjectsPage;
import pageobject.RatingWindowPage;
import utils.Util;

public class BaseTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Util u = new Util();
		driver.get(u.readProperty("url"));
	}
		
	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.cookiesWindow();
		lp.login("levyamit88@gmail.com", "Aa12121212@");
	}
	
	@BeforeClass
	public void setupRatingPopUp() {
		RatingWindowPage rwp = new RatingWindowPage(driver);
		rwp.closeRatingWindow();
	}
	@BeforeClass
	public void setupWorkSpace() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.chooseWorkspace("my workspace");	
	}
	
	@AfterMethod
	public void failedTest(ITestResult result) {
	  //check if the test failed
		if (result.getStatus() == ITestResult.FAILURE ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./FailedScreenShots/" + result.getName()+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//result.getname() method will give you current test case name. 
			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		}
	}
    @AfterClass
	public void tearDown() {
	driver.quit();
	}

}
