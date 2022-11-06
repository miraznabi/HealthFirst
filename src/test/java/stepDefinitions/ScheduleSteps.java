package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppointmentToEnrollPage;
import pages.RepInfoPage;
import pages.SchedulePage;
import pages.ScheduleWithRepPage;
import utilities.BaseClass;

public class ScheduleSteps extends BaseClass {

	// WebDriver driver;

	WebDriverWait wait;

	SchedulePage sp;
	ScheduleWithRepPage swrp;
	RepInfoPage rip;
	AppointmentToEnrollPage atep;

	@Given("browser is open")
	public void browser_is_open() {

//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

		BaseClass.setup();

		sp = new SchedulePage(driver);
		swrp = new ScheduleWithRepPage(driver);
		rip = new RepInfoPage(driver);
		atep = new AppointmentToEnrollPage(driver);
	}

	@When("I open the url")
	public void i_open_the_url() {

		driver.get(rc.getApplicationURL());

	}

	@Then("I verify schedule and enroll text")
	public void i_verify_schedule_and_enroll_text() {

		String enrollText = sp.getEnrollHeader().getText();

		assertEquals("Schedule an Appointment to Enroll", enrollText);

	}

	@Then("search representative")
	public void search_representative() {

		String searchRep = sp.getSearchRep().getText();
		assertEquals("Search Representatives", searchRep);

	}

	@Then("contact number")
	public void contact_number() {

		String contactNum = driver.findElement(By.xpath("//strong[normalize-space()='1-888-260-1010']")).getText();
		assertEquals("1-888-260-1010", contactNum);

	}

	@When("when I click medicare")
	public void when_i_click_medicare() {

		sp.getClickMedicare().click();

	}

	@When("click search rep")
	public void click_search_rep() {

		sp.getSearchRep().click();

	}

	@Then("verify header is {string}")
	public void verify_header_is(String header) {

		String actualHeader = swrp.getHeader().getText();
		Assert.assertEquals(header, actualHeader);
	}

	@When("search rep {string}")
	public void search_rep(String rep) throws InterruptedException {

		swrp.getSearchInput().sendKeys(rep);
		Thread.sleep(3000);
	}

	@When("click contact")
	public void click_contact() {

		swrp.getClickContact().click();
	}

	@When("I click view schedule")
	public void i_click_view_schedule() {

		rip.getViewSchedule().click();
	}

	@Then("verify banner is {string}")
	public void verify_banner_is(String banner) {

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(atep.getBanner()));
		String actualBanner = atep.getBanner().getText();
		Assert.assertEquals(banner, actualBanner);
	}

	@When("I click telephone")
	public void i_click_telephone() {

		atep.getTelephone().click();
	}

	@When("choose date")
	public void choose_date() throws InterruptedException {

		Thread.sleep(5000);
		atep.getDate().click();

	}

	@When("choose time")
	public void choose_time() throws InterruptedException {

		atep.getTime().click();

		Thread.sleep(5000);

	}

	@When("I click continue")
	public void i_click_continue() {

		atep.getContinue().click();

	}

	@Then("verify appoinment page")
	public void verify_appoinment_page() throws InterruptedException {
		String actualBanner = atep.getBanner().getText();
		Assert.assertEquals("Schedule an Appointment to Enroll", actualBanner);

	}

}
