package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomer;
import pages.CustomerList;
import pages.Dashboard;
import pages.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;
	// test testData
	String userId = "demo@codefios.com";
	String password = "abc123";

	String dashboardValidText = "Dashboard";
	String addCustomerValidText = "New Customer";
	String fullName = "ram chandra";
	String email = "codefios@gmail.com";
	String componyName = "Techfios";
	String phone = "1234567890";

	String streetAddress = "333 w chicago";
	String city = "NewYork";
	String zipCode = "65555";
	String country = "Nepal";
	String group = "Java";

	String customerListHeader = "Customer List";

	@Test
	public void addCustomerTest() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userId);
		loginPage.insertUserPassword(password);
		loginPage.clickOnSinginButton();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		dashboard.validateDashboardPage(dashboardValidText);
		dashboard.clickOnCustomerButton();
		dashboard.clickOnAddcustomerButton();

		AddCustomer addCustomer = PageFactory.initElements(driver, AddCustomer.class);
		addCustomer.validateAddNewCustomerPage(addCustomerValidText);
		addCustomer.insertFullName(fullName);
		addCustomer.selectComponyName(componyName);
		addCustomer.insertEmail(email);

		addCustomer.insertPhoneNumber();
		// addCustomer.insertPhoneNumber(phone);
		addCustomer.insertStreetAddress(streetAddress);
		addCustomer.insertCity(city);
		addCustomer.insertZipCode(zipCode);
		addCustomer.selectCountry(country);
		addCustomer.selectGroup(group);
		addCustomer.clickOnSaveButton();

		CustomerList customerList = PageFactory.initElements(driver, CustomerList.class);
		customerList.validateCustomerList(customerListHeader);

		BrowserFactory.tearDown();

	}

}
