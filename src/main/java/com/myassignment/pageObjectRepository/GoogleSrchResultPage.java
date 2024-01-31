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
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Google']")
	WebElement gImg;
	
	@FindBy(name="q")
	WebElement srchTB;
	
	@FindBy(xpath="//div[@class='yuRUbf'] //h3[contains(@class,'LC20lb')][1]")
	WebElement frstRR;
	
	
	
	public void verifyStrInSrchTB(String srcStr) {
		Assert.assertTrue(gImg.isDisplayed());
	Assert.assertTrue(srchTB.getText().equals(srcStr));
}
	public void verifyFirstSrchRslt(String srcStr) {
		waitForElementToAppear(frstRR);
		Assert.assertTrue(frstRR.getText().contains(srcStr));
	}
	
}
