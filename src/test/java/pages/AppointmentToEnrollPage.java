package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AppointmentToEnrollPage {

	WebDriver driver;

	public AppointmentToEnrollPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Schedule an Appointment to Enroll')]")
	WebElement banner;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Telephone']")
	WebElement telephone;

	@FindBy(how = How.XPATH, using = "(//li[@role='button'])[4]")
	WebElement date;

	@FindBy(how = How.XPATH, using = "(//li)[position()=10]")
	WebElement time;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Continue']")
	WebElement Continue;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getBanner() {
		return banner;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getTime() {
		return time;
	}

	public WebElement getContinue() {
		return Continue;
	}

}
