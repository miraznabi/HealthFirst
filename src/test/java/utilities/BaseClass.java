package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static ReadConfig rc = new ReadConfig();
	
	//public String baseURL = rc.getApplicationURL();
	//public String userName = rc.getUsername();


	public static WebDriver driver;
	public static Scenario scenario;

	
	
	//public static Logger logger;


	public static void setup() {
		//logger = Logger.getLogger("eBanking");
		//PropertyConfigurator.configure("Log4j.properties");
		
		String browser = rc.getBrowser();
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
    public Scenario getScenario()
    {
        return scenario;
    }
    
    public void setScenario(Scenario scenario)
    {
        this.scenario = scenario;
    }
	

}
