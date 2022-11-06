package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindADoctorPage;
import utilities.BaseClass;

public class FindADocSteps extends BaseClass {

	FindADoctorPage fdp;
	WebDriverWait wait;
	

	@Given("I am on healthfirst homepage")
	public void i_am_on_healthfirst_homepage() {

		BaseClass.setup();
		scenario.log("Browser opened");
		driver.get("https://healthfirst.org/");

		fdp = new FindADoctorPage(driver);

	}

	@When("I click on find a doc")
	public void i_click_on_find_a_doc() throws InterruptedException {

		fdp.getFindDocBtn().click();
		scenario.log("Find a Doctor was clicked");
		
		Thread.sleep(2000);
	}

	@When("I choose HMO in insurance dropdown")
	public void i_choose_hmo_in_insurance_dropdown() {

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(fdp.getInsuranceDDBtn()));
		fdp.getInsuranceDDBtn().click();

		List<WebElement> dropdowns = fdp.getDDElements();

		for (WebElement dropdown : dropdowns) {

			if (dropdown.getText().equals("Healthfirst Connection Plan (HMO D-SNP)")) {

				dropdown.click();
				break;
			}

		}

	}

	@When("I enter {int}")
	public void i_enter(Integer zip) throws InterruptedException {

		Thread.sleep(3000);
		fdp.getZipInput().sendKeys(String.valueOf(zip));
		ExtentCucumberAdapter.addTestStepLog("***Zip code was provided***");
		Thread.sleep(3000);

		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		

	}

	@When("click on {string}")
	public void click_on(String facility) {

		fdp.getFacilityInput().sendKeys(facility);
		fdp.getSearchResult().click();
	}

	@Then("I should be able to click pediatric")
	public void i_should_be_able_to_click_pediatric() throws InterruptedException {

		fdp.getPediatricSearch().click();

		Thread.sleep(5000);
	}

}
