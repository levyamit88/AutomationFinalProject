package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ProjectsPage;
import pageobject.ChooseProjectTypePage;
import pageobject.ChooseTemplatesPage;
import pageobject.CreateProjectPage;

public class ProjectsTest extends BaseTest {

	@Test(description = "Add a new Project")
	public void tc01_addNewProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		int before = pp.getProjectNumber();
		pp.addNewProjectBtn("start from template");
		ChooseTemplatesPage ctp = new ChooseTemplatesPage(driver);
		ctp.chooseTemplateType("application type", "personality test");
		ctp.chooseTemplate("what diet is best for you?");
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.fillProjectName("Add new project test");
		cpt.chooseProjectType("answer-based outcomes");
		CreateProjectPage cpp = new CreateProjectPage(driver);
		cpp.backToMyWorkspace();
		Assert.assertEquals(pp.getProjectNumber(), before + 1);
	}

	@Test(description = "Search for a project in the workspace")
	public void tc02_searchProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.search("search project test");
		Assert.assertTrue(pp.itIsSearching("search project test"));
	}
	
//	@Test
//	public void deletAllProjects() {
//		ProjectsPage pp = new ProjectsPage(driver);
//		pp.deleteAll();
//	}
}
