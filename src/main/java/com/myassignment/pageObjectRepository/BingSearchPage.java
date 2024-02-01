package com.myassignment.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myassignment.abstractComponents.AbstractComp;

public class BingSearchPage extends AbstractComp {

	WebDriver driver;

	public BingSearchPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "bLogo")
	WebElement bLogo;

	@FindBy(name = "q")
	WebElement searchTxtBox;

	// Method to enter the search string into the search text box.
	public void entrSrchKeyWord(String keyWord) {

		waitForElementToAppear(bLogo);
		searchTxtBox.sendKeys(keyWord);
	}

	// Method to click on the search button.
	public void clickSearchBtn() {
		Actions a = new Actions(driver);
		a.moveToElement(searchTxtBox).keyDown(Keys.ENTER).build().perform();

	}

}
