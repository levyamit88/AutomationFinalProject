package tests;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ProjectsPage;


public class SortTest extends BaseTest {

	@Test(description = "Sort the projects in ascending order by name")
	public void tc01_sortByNameAsc() {
		ProjectsPage pp = new ProjectsPage(driver);
		List<String> beforeSort = pp.getProjectsNameForSort();
		pp.chooseSort("name-asc");
		List<String> afterSort = pp.getProjectsNameForSort();
		Collections.sort(beforeSort);
		Assert.assertEquals(beforeSort, afterSort);
	}

	@Test(description = "Sort the projects in descending order by name")
	public void tc02_sortByNameDesc() {
		ProjectsPage pp = new ProjectsPage(driver);
		List<String> beforeSort = pp.getProjectsNameForSort();
		pp.chooseSort("name-desc");
		List<String> afterSort = pp.getProjectsNameForSort();
		Collections.sort(beforeSort, Collections.reverseOrder());
		Assert.assertEquals(beforeSort, afterSort);
	}
}
