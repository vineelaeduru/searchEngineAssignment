package com.myassignment.pageObjectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myassignment.abstractComponents.AbstractComp;

public class YahooSearchPage extends AbstractComp {

	WebDriver driver;

	public YahooSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#ybar-logo")
	WebElement yLogo;

	@FindBy(id = "ybar-sbq")
	WebElement searchTxtBox;

	@FindBy(css = "button#ybar-search")
	WebElement searchBtn;

	public void entrSrchKeyWord(String keyWord) {
		
		waitForElementToAppear(yLogo);
		searchTxtBox.sendKeys(keyWord);

	}

	public void clickSearchBtn() {

		searchBtn.click();
	}
	
	public void switchToRsltPg() {
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		//String srchPg = it.next();
		String rsltPg=it.next();
		driver.switchTo().window(rsltPg);
	}

}
