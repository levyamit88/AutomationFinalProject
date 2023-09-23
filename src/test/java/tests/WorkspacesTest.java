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
		pp.addWorkspace("Add workspace test", "create");
		Assert.assertEquals(pp.workspacesNumber(), before + 1);
	}
	
	@Test(description = "Delete a workspace")
	public void tc02_deleteWorkspace() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addWorkspace("Delete workspace test", "create");
		int before = pp.workspacesNumber();
		pp.getWorkspaceOptions("delete workspace test");
		pp.deleteWorkspaceOption("Delete workspace test", "delete");
		Assert.assertEquals(pp.workspacesNumber(), before - 1);		
	}

}
















