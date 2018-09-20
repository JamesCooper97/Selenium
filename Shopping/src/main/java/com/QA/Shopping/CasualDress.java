package com.QA.Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CasualDress {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div")
	private WebElement printedDress;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
	private WebElement cartPrintedDress;
	
	public void addCart() {
		cartPrintedDress.click();
	}
	
	public void hoverPrintedDress(Actions action) {
		action.moveToElement(printedDress).perform();
	}
}
