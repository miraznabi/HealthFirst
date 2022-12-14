package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File(
				"C:\\Users\\miraz\\eclipse-workspace\\HealthFirst\\src\\test\\resources\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("url");
		return url;
	}

	public String getBrowser() {
		String browserName = pro.getProperty("browser");
		return browserName;
	}

}
