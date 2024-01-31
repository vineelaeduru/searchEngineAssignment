package com.myassignment.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInitialization {
	public static WebDriver driver;
	
	public WebDriver InitializeDriver() throws IOException {
		
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fIS = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\GlobalData.properties");
		prop.load(fIS);
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			driver = new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();			 
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();			 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	
	
	public WebDriver launchBrowser(String url) throws IOException {
		driver = InitializeDriver();
		driver.get(url);
		return driver;
	}
		

	public void closeBrowser()
	{

		driver.quit();
	}
	
	

}
