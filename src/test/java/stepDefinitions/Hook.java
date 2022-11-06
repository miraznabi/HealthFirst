package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;

public class Hook extends BaseClass {
	
	BaseClass base;

	public Hook(BaseClass base) {
		this.base = base;
	}
	
	@Before
	public void bf(Scenario scenario)
	{
		
		base.setScenario(scenario);
	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}


}
