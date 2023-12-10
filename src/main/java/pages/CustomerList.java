package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerList extends BasePage {

	WebDriver driver;

	public CustomerList(WebDriver driverPass) {
		this.driver = driverPass;
	}

	@FindBy(how = How.XPATH, using = "//div/header/div/strong[text()='Customer List']")
	WebElement customerListHeader;

	@FindBy(how = How.XPATH, using = "")
	WebElement customerListHeader1;

	public void validateCustomerList(String headerString) {
		validateDashboardPage(customerListHeader, headerString, "Customer list page is not find");
	}

}
