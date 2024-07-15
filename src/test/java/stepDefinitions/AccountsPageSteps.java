package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	String title;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialTable) {
		List<Map<String, String>> credentialList = credentialTable.asMaps();
		String userName=credentialList.get(0).get("username");
		String password=credentialList.get(0).get("password");
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		
		accountsPage=loginPage.doLogin(userName, password);
	    
	}
	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
		String url=accountsPage.getAccountsPageUrl();
		System.out.println("url of the page is :"+ url);
		Assert.assertTrue(url.contains("controller=my-account"));
	    
	}
	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	 title=accountsPage.getAccoutsPageTitle();
	    System.out.println("title of the page is :"+title);
	}
	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
	   Assert.assertTrue(title.contains("My account - My Shop"));
	}
	@Then("User gets the accounts section")
	public void user_gets_the_accounts_section(DataTable sectionTable) {
		List<String>expSecList=sectionTable.asList();
		System.out.println("expected accounts section list: "+expSecList);
		List<String> actSecList= accountsPage.getActSectionList();
		System.out.println("actual accounts section list: "+actSecList);
		Assert.assertEquals(actSecList, expSecList);
	   
	}
	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSecCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount()==expectedSecCount);
	    
	}


}
