package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ChooseProjectTypePage;
import pageobject.ChooseTemplatesPage;
import pageobject.ConfigurePgae;
import pageobject.CreateProjectPage;
import pageobject.DraftPreviewPage;
import pageobject.ProjectsPage;

public class ProjectOptionsTest extends BaseTest {
	
	@Test(description = "Open preview project")
	public void tc01_previewProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewProjectBtn("start from template");
		ChooseTemplatesPage ctp = new ChooseTemplatesPage(driver);
		ctp.chooseTemplateType("application type", "personality test");
		ctp.chooseTemplate("what's your travel type?");
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.fillProjectName("My Favorite Travel");
		cpt.chooseProjectType("answer-based outcomes");
		CreateProjectPage cpp = new CreateProjectPage(driver);
		cpp.backToMyWorkspace();
		pp.getProjectOptions("My Favorite Travel", "preview");
		String expected = "draft preview";
		DraftPreviewPage dpp = new DraftPreviewPage(driver);
		Assert.assertEquals(dpp.itIsPreview(), expected);
		dpp.backToMainWindow();
	}
	
	@Test(description = "Publish a project")
	public void tc02_publishProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewProjectBtn("start from template");
		ChooseTemplatesPage ctp = new ChooseTemplatesPage(driver);
		ctp.chooseTemplateType("application type", "personality test");
		ctp.chooseTemplate("what's your travel type?");
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.fillProjectName("Amit's travel");
		cpt.chooseProjectType("answer-based outcomes");
		CreateProjectPage cpp = new CreateProjectPage(driver);
		cpp.backToMyWorkspace();
		pp.getProjectOptions("Amit's travel", "publish now");
		ConfigurePgae cp = new ConfigurePgae(driver);
		cp.clickPublish();
		String expected = "you need a paid plan to be able to publish.";
		Assert.assertEquals(cp.getErrorMsg(), expected);
	}
	
	@Test(description = "Delete a project")
	public void tc03_deleteProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewProjectBtn("start from template");
		ChooseTemplatesPage ctp = new ChooseTemplatesPage(driver);
		ctp.chooseTemplateType("application type", "personality test");
		ctp.chooseTemplate("what's your travel type?");
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.fillProjectName("Delete project test");
		cpt.chooseProjectType("answer-based outcomes");
		CreateProjectPage cpp = new CreateProjectPage(driver);
		cpp.backToMyWorkspace();
		int before = pp.getProjectNumber();
		pp.getProjectOptions("Delete project test", "Delete project");
		pp.deleteProjectOptions("delete");
		Assert.assertEquals(pp.getProjectNumber(), before - 1);
	}
	
	

}
