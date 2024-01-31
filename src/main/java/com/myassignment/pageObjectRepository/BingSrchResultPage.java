package com.myassignment.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import com.myassignment.abstractComponents.AbstractComp;

public class BingSrchResultPage extends AbstractComp {

	WebDriver driver;
	public BingSrchResultPage(WebDriver driver) {

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="q")
	WebElement srchTB;
	
	@FindBy(xpath="//ol[@id='b_results'] //h2/a")
	WebElement frstRR;
	
	
	
	public void verifyStrInSrchTB(String srcStr) {
	Assert.assertTrue(srchTB.getAttribute("value").equals(srcStr));
}
	public void verifyFirstSrchRslt(String srcStr) {
		waitForElementToAppear(frstRR);
		Assert.assertTrue(frstRR.getText().contains(srcStr));
	}
	
}
