package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDetails {
	Properties prop;

	public configDetails() {
		File file = new File(System.getProperty("user.dir") + "\\Configration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		String browserName = prop.getProperty("browser");
		return browserName;
	}
	
	public String getBaseUrl() {
		String baseUrl = prop.getProperty("baseUrl");
		return baseUrl;
	}

}
