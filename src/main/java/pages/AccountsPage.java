package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	
	private By actSections= By.xpath("//ul[@class='myaccount-link-list']//span");
	
	public AccountsPage(WebDriver driver) {
		this.driver= driver;
	}
	public String getAccountsPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getAccoutsPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(actSections).size();
	}
	
	public List<String> getActSectionList() {
		List<String> accountsList=new ArrayList<>();
		List<WebElement> actSecHeaderList=driver.findElements(actSections);
		
		for(WebElement e:actSecHeaderList) {
			String text=e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		
		return accountsList;
	}

}
