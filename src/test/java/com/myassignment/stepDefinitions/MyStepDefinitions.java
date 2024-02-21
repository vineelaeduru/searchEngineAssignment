package com.myassignment.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.myassignment.pageObjectRepository.BingSearchPage;
import com.myassignment.pageObjectRepository.BingSrchResultPage;
import com.myassignment.pageObjectRepository.GoogleSearchPage;
import com.myassignment.pageObjectRepository.GoogleSrchResultPage;
import com.myassignment.pageObjectRepository.YahooSearchPage;
import com.myassignment.pageObjectRepository.YahooSrchResultPage;
import com.myassignment.testComponents.BrowserInitialization;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefinitions {

	WebDriver driver;
	private BrowserInitialization b = new BrowserInitialization();
	private GoogleSearchPage gSrch;
	private YahooSearchPage ySrch;
	private BingSearchPage bSrch;
	private GoogleSrchResultPage gRP;
	private YahooSrchResultPage yRP;
	private BingSrchResultPage bRP;

	@Given("^I navigate to (.*) search page$")
	public void navigate_to_search_page(String seName) throws IOException {
		String url = null;
		if (seName.equalsIgnoreCase("google")) {
			url = "https://www.google.com";
			driver = b.launchBrowser(url);
			gSrch = new GoogleSearchPage(driver);
		}
		if (seName.equalsIgnoreCase("yahoo")) {
			url = "https://www.yahoo.com";
			driver = b.launchBrowser(url);
			ySrch = new YahooSearchPage(driver);
		}
		if (seName.equalsIgnoreCase("bing")) {
			url = "https://www.bing.com";
			driver = b.launchBrowser(url);
			bSrch = new BingSearchPage(driver);
		}

	}

	@When("I enter {string} in the {string} textbox")
	public void enter_keyword_to_search(String keyWord, String seName) {

		if (seName.equalsIgnoreCase("google")) {
			gSrch.entrSrchKeyWord(keyWord);
		}
		if (seName.equalsIgnoreCase("yahoo")) {
			ySrch.entrSrchKeyWord(keyWord);
		}
		if (seName.equalsIgnoreCase("bing")) {
			bSrch.entrSrchKeyWord(keyWord);
		}

	}

	@When("I click on the search button in the {string} page")
	public void click_on_search_button(String seName) {
		if (seName.equalsIgnoreCase("google")) {
			gSrch.clickSearchBtn();
		}
		if (seName.equalsIgnoreCase("yahoo")) {
			ySrch.clickSearchBtn();
		}
		if (seName.equalsIgnoreCase("bing")) {
			bSrch.clickSearchBtn();
		}
	}

	@Then("verify the {string} search results return {string}")
	public void verify__search_result(String seName, String srchStr) {
		if (seName.equalsIgnoreCase("google")) {
			gRP = new GoogleSrchResultPage(driver);
			gRP.verifyStrInSrchTB(srchStr);
			gRP.verifyFirstSrchRslt(srchStr);
		}
		if (seName.equalsIgnoreCase("yahoo")) {
			yRP = new YahooSrchResultPage(driver);
			yRP.verifyStrInSrchTB(srchStr);
			yRP.verifyFirstSrchRslt(srchStr);
		}
		if (seName.equalsIgnoreCase("bing")) {
			bRP = new BingSrchResultPage(driver);
			bRP.verifyStrInSrchTB(srchStr);
			bRP.verifyFirstSrchRslt(srchStr);
		}

		b.closeBrowser();
	}

}
