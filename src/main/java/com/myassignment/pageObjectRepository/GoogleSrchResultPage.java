package com.myassignment.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import com.myassignment.abstractComponents.AbstractComp;

public class GoogleSrchResultPage extends AbstractComp {

	WebDriver driver;

	public GoogleSrchResultPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "q")
	WebElement srchTB;

	@FindBy(xpath = "//div[@class='yuRUbf'] //h3[contains(@class,'LC20lb')][1]")
	WebElement frstRR;

	// Method to verify the search string in the search text box in the search
	// result page.
	public void verifyStrInSrchTB(String srcStr) {

		Assert.assertTrue(srchTB.getText().equals(srcStr));
	}

	// Method to assert the first result returned by the search engine.
	public void verifyFirstSrchRslt(String srcStr) {
		
		waitForElementToAppear(frstRR);
		Assert.assertTrue(frstRR.getText().contains(srcStr));
	}

}
