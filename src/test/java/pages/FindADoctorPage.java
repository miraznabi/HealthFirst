package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FindADoctorPage {
	
	WebDriver driver;

	public FindADoctorPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//a[@href='/find-a-doctor'])[1]")
	WebElement findDocBtn;
	
	@FindBy(how = How.XPATH, using = "//img[@alt='image']")
	WebElement insuranceDDBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@class='DropdownLabel-m03vzn-8 fMUzBo']")
	List <WebElement> DDElements;
	
	public List<WebElement> getDDElements() {
		return DDElements;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Location']")
	WebElement zipInput;
	
	@FindBy(how = How.XPATH, using = "//input[@id='mycom']")
	WebElement facilityInput;
	
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Search']")
	WebElement searchResult;
	
	@FindBy(how = How.XPATH, using = "(//p[contains(text(),'PEDIATRIC')])[1]")
	WebElement pediatricSearch;

	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFindDocBtn() {
		return findDocBtn;
	}

	public WebElement getInsuranceDDBtn() {
		return insuranceDDBtn;
	}


	public WebElement getZipInput() {
		return zipInput;
	}

	public WebElement getFacilityInput() {
		return facilityInput;
	}

	public WebElement getSearchResult() {
		return searchResult;
	}

	public WebElement getPediatricSearch() {
		return pediatricSearch;
	}
	
	
	
	
	
	
	
	

}
