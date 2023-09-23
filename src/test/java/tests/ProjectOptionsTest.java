package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ConfigurePgae;
import pageobject.DraftPreviewPage;
import pageobject.ProjectsPage;

public class ProjectOptionsTest extends BaseTest {
	
	@Test(description = "Open preview project")
	public void tc01_previewProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.getProjectOptions("preview project test", "preview");
		String expected = "draft preview";
		DraftPreviewPage dpp = new DraftPreviewPage(driver);
		Assert.assertEquals(dpp.itIsPreview(), expected);
		dpp.backToMainWindow();
	}
	
	@Test(description = "Delete a project")
	public void tc02_deleteProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		int before = pp.getProjectNumber();
		pp.getProjectOptions("delete project test", "Delete project");
		pp.deleteProjectOptions("delete");
		Assert.assertEquals(pp.getProjectNumber(), before - 1);
	}
	
	@Test(description = "Publish a project")
	public void tc03_publishProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.getProjectOptions("publish project test", "publish now");
		ConfigurePgae cp = new ConfigurePgae(driver);
		cp.clickPublish();
		String expected = "you need a paid plan to be able to publish.";
		Assert.assertEquals(cp.getErrorMsg(), expected);
	}
	
}
