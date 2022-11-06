package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ScheduleWithRepPage {

	WebDriver driver;

	public ScheduleWithRepPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h1[@itemprop='name']")
	WebElement header;

	@FindBy(how = How.XPATH, using = "//input[@id='repTableSearchInput']")
	WebElement searchInput;

	@FindBy(how = How.XPATH, using = "//a[@class='contactButton']")
	WebElement clickContact;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getSearchInput() {
		return searchInput;
	}

	public WebElement getClickContact() {
		return clickContact;
	}

}
