package com.QA.BingTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BingPage {
	@FindBy(xpath = "//*[@id=\"sb_form_q\"]")
	private WebElement searchBox;
	
	@FindBy(id = "sb_form_go")
	private WebElement searchButton;
	
	public void searchFor(String text) {
		searchBox.sendKeys(text);
	}
	
	public void clickSearch(Actions action) {
		action.click(searchButton).perform();
	}
}
