package com.QA.PassionTea;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	
	@FindAll({
		@FindBy(xpath="//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]"),
		@FindBy(xpath="//*[@id=\"wsb-button-00000000-0000-0000-0000-000451959280\"]"),
		@FindBy(xpath="//*[@id=\"wsb-button-00000000-0000-0000-0000-000451961556\"]")
	})
	private WebElement checkout;
	
	public void checkoutClick() {
		checkout.click();
	}
}
