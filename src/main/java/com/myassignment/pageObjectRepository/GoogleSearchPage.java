package com.myassignment.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myassignment.abstractComponents.AbstractComp;

public class GoogleSearchPage extends AbstractComp {

	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "q")
	WebElement searchTxtBox;

	@FindBy(xpath = "//input[@value='Google Search']")
	WebElement searchButton;

	// Method to enter the search string into the search text box.
	public void entrSrchKeyWord(String keyWord) {
		
		searchTxtBox.sendKeys(keyWord);
	}

	// Method to click on the search button.
	public void clickSearchBtn() {

		searchButton.click();
	}

}
