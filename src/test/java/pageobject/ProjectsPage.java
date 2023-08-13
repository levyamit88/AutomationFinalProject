package pageobject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends MenuAllPage {

	public ProjectsPage(WebDriver driver) {
		super(driver);
	}

//	Elements names
	@FindBy(css = "[data-intercom-target='project-overview-project-area']>div:nth-child(2)>.relative")
	private List<WebElement> projectArea;
	@FindBy(css = "[aria-labelledby='arrow-down']")
	private WebElement optionsArrow;
	@FindBy(css = ".pl-4.pr-4")
	private List<WebElement> optionBtn;
	@FindBy(css = ".mb-3 a")
	private List<WebElement> projectTitle;
	@FindBy(css = ".relative.dropdown.mr-3 [data-icon='chevron-down']:nth-child(2)")
	private WebElement newProjectBtn;
	@FindBy(css = ".w-72")
	private List<WebElement> projectStart;
	@FindBy(css = ".flex-nowrap>.whitespace-nowrap:nth-child(1)")
	private WebElement totalProject;
	@FindBy(css = "[placeholder^='Search for projects']")
	private WebElement searchField;
	@FindBy(css = ".inline-block")
	private List<WebElement> deleteProjectBtn;
	@FindBy(css = ".flex.justify-between > select")
	private WebElement sortBtn;
	@FindBy(css = ".flex.justify-between > select")
	private WebElement selectList;
	@FindBy(css = "button>[data-icon='plus']")
	private WebElement addWorkspacesBtn;
	@FindBy(css = "[placeholder='Workspace name']")
	private WebElement workspacesNameField;
	@FindBy(css = ".inline-block")
	private List<WebElement> createWorkspacesBtn;
	@FindBy(css = ".px-2 .mr-3.truncate")
	private List<WebElement> workspaceName;
	@FindBy(css = "[data-icon='chevron-down']:nth-child(1)")
	private WebElement workspaceOptionsBtn;
	@FindBy(css = ".block.pr-4")
	private List<WebElement> workspaceOptions;
	@FindBy(css = "[id^='text']")
	private WebElement renameField;
	@FindBy(css = ".ml-auto>.inline-block")
	private List<WebElement> renameWorkspaceOptions;

//	Testing methods
	public void getProjectOptions(String projectName, String optionName) {
		for (WebElement elArea : projectArea) {
			WebElement elTitle = elArea.findElement(By.cssSelector(".mb-3 a"));
			if (getText(elTitle).equalsIgnoreCase(projectName)) {
				WebElement optionsArrow = elArea.findElement(By.cssSelector("[aria-labelledby='arrow-down']"));
				click(optionsArrow);
				for (WebElement el : optionBtn) {
					if (el.getText().equalsIgnoreCase(optionName)) {
						el.click();
						break;
					}
				}
				break;
			}
		}
	}

	public void addNewProjectBtn(String projectType) {
		click(newProjectBtn);
		for (WebElement el : projectStart) {
			if (getText(el).toLowerCase().contains(projectType)) {
				click(el);
				break;
			}
		}

	}

	public void search(String name) {
		fillText(searchField, name);
	}

	public void deleteProjectOptions(String btnName) {
		for (WebElement el : deleteProjectBtn) {
			if (getText(el).toLowerCase().contains(btnName)) {
				click(el);
				break;
			}
		}
	}

	public void chooseSort(String name) {
		selectByValue(selectList, name);
	}

	public void addWorkspace(String name, String btnName) {
		click(addWorkspacesBtn);
		fillText(workspacesNameField, name);
		for (WebElement el : createWorkspacesBtn) {
			if (getText(el).toLowerCase().contains(btnName)) {
				click(el);
				break;
			}
		}

	}

	public void chooseWorkspace(String name) {
		for (WebElement el : workspaceName) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	public void getWorkspaceOptions(String name) {
		for (WebElement el : workspaceName) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				click(workspaceOptionsBtn);
				break;
			}
		}
	}

	public void renameWorkspaceOption(String name, String btnName) {
		for (WebElement el : workspaceOptions) {
			if (getText(el).toLowerCase().contains("rename")) {
				click(el);
				fillText(renameField, name);
				for (WebElement el1 : renameWorkspaceOptions) {
					if (getText(el1).toLowerCase().contains(btnName)) {
						click(el1);
						break;
					}
				}
			}
		}
	}

//	Validations methods	
	public int getProjectNumber() {
		String total = getText(totalProject);
		int projectNumber = Integer.parseInt(total.replaceAll("[^0-9]+", ""));
		return projectNumber;
	}

	public boolean itIsSearching(String projectName) {
		for (WebElement elArea : projectArea) {
			WebElement elTitle = elArea.findElement(By.cssSelector(".mb-3 a"));
			if (getText(elTitle).toLowerCase().contains(projectName)) {
				return true;
			}
		}
		return false;
	}

	public List<String> getProjectsNameForSort() {
		List<String> projectsNameBeforeSort = new ArrayList<>();
		for (WebElement n : projectTitle) {
			projectsNameBeforeSort.add(n.getText());
		}
		return projectsNameBeforeSort;
	}

	public boolean isProjectAdded(String name) {
		for (WebElement el : projectTitle) {
			if (getText(el).equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public boolean isProjectDeleted(String name) {
		for (WebElement el : projectTitle) {
			if (getText(el).equalsIgnoreCase(name)) {
				return false;
			}
		}
		return true;
	}

	public int workspacesNumber() {
		List<WebElement> list = driver.findElements(By.cssSelector(".px-2 .mr-3.truncate"));
		for (int i = 0; i < list.size(); i++) {

		}
		return list.size();
	}

}
