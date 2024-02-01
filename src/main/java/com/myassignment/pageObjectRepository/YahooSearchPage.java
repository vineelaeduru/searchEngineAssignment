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

	// Method to enter the search string into the search text box.
	public void entrSrchKeyWord(String keyWord) {

		waitForElementToAppear(yLogo);
		searchTxtBox.sendKeys(keyWord);

	}

	// Method to click on the search button.
	public void clickSearchBtn() {

		searchBtn.click();
	}

	// Method to switch to new window when the search result page is opened in new
	// tab.
	public void switchToRsltPg() {
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String rsltPg = it.next();
		driver.switchTo().window(rsltPg);
	}

}
