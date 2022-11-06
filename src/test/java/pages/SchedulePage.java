package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage {

	WebDriver driver;

	public SchedulePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Schedule an Appointment to Enroll')]")
	WebElement enrollHeader;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Search Representatives']")
	WebElement searchRep;

	@FindBy(how = How.XPATH, using = "//strong[normalize-space()='1-888-260-1010']")
	WebElement contactNumber;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Medicare')]")
	WebElement clickMedicare;

	public WebElement getContactNumber() {
		return contactNumber;
	}

	public WebElement getClickMedicare() {
		return clickMedicare;
	}

	public WebElement getSearchRep() {
		return searchRep;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEnrollHeader() {
		return enrollHeader;
	}

}
