package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// For the Page Object Model Only
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_name\"]")
	WebElement userNameElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement passwordElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"login_submit\"]")
	WebElement signInButton;

	// intractable method
	// Single Methods
	public void insertUserName(String userName) {
		userNameElement.sendKeys(userName);

	}

	public void insertUserPassword(String password) {
		passwordElement.sendKeys(password);

	}

	public void clickOnSinginButton() {
		signInButton.click();

	}

///combine Method
	public void performLogin(String userName, String password) {
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		signInButton.click();

	}

}
