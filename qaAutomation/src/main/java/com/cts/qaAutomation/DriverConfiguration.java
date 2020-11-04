package com.cts.qaAutomation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfiguration {
	
	//@Bean
	public WebDriver getWebDriver() {
		String exePath = "D:/selenium/driver/driver/latest/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); 
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.get("https://qaa.rci.com");
        return driver;
	}

}
