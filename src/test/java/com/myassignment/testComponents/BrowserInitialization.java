package com.myassignment.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.myassignment.pageObjectRepository.BingSearchPage;
import com.myassignment.pageObjectRepository.GoogleSearchPage;
import com.myassignment.pageObjectRepository.YahooSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
	
	
	@BeforeTest
	public WebDriver launchBrowser(String url) throws IOException {
		driver = InitializeDriver();
		driver.get(url);
		return driver;
	}
		
	@AfterTest
	public void closeBrowser()
	{

		driver.quit();
	}
	
	

}
