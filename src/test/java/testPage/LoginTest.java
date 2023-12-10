package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	// test testData
	String userId = "demo@codefios.com";
	String password = "abc123";

	String dashboardValidText = "Dashboard";

	@Test
	public void validUserShouldLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userId);
		loginPage.insertUserPassword(password);
		loginPage.clickOnSinginButton();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		dashboard.validateDashboardPage(dashboardValidText);
		BrowserFactory.tearDown();

	}

}
