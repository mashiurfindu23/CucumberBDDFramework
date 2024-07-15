package stepDefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("User is in the login page")
	public void user_is_in_the_login_page() {
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}
	

	@When("the user enters the user name {string}")
	public void the_user_enters_the_user_name(String username) {
		loginPage.enterUserName(username);

	}

	@When("User enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);

	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("User gets title of the page")
	public void user_gets_title_of_the_page() {
		title=loginPage.getPageTitle();
		System.out.println("title of the page is title: " + title);
		

	}

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String string) {
		Assert.assertTrue(title.contains("My account - My Shop"));

	}

}
