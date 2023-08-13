package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.ProjectsPage;

public class WorkspacesTest extends BaseTest{
	
	@Override
	public void setupWorkSpace() {
		super.setupWorkSpace();
	}
	
	@Test(description = "Add a new workspace")
	public void tc01_addNewWorkspace() {
		ProjectsPage pp = new ProjectsPage(driver);
		int before = pp.workspacesNumber();
		pp.addWorkspace("Test", "create");
		Assert.assertEquals(pp.workspacesNumber(), before + 1);
	}
	
	@Test(description = "Rename a workspace")
	public void tc02_renameWorkspace() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.getWorkspaceOptions("test");
		pp.renameWorkspaceOption("Amit", "rename");
	}

}
