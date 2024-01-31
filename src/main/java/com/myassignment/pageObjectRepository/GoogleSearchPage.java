package com.myassignment.pageObjectRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myassignment.abstractComponents.AbstractComp;

public class GoogleSearchPage extends AbstractComp{
	
	WebDriver driver;
	public GoogleSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Google']")
	WebElement image;
	
	@FindBy(name="q")
	WebElement searchTxtBox;
	
	@FindBy(xpath="//input[@value='Google Search']")
	WebElement searchButton;
	
	public void entrSrchKeyWord(String keyWord) {

		waitForElementToAppear(image);
		searchTxtBox.sendKeys(keyWord);
		
		
		
	}
	
	public void clickSearchBtn() {
		
		searchButton.click();
	}
	
	
}
