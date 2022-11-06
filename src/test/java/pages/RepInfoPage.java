package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RepInfoPage {
	WebDriver driver;

	public RepInfoPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'View Schedule')]")
	WebElement viewSchedule;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getViewSchedule() {
		return viewSchedule;
	}

}
