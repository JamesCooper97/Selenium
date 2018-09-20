package com.QA.Shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Index {
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
	private WebElement hoverDress;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
	private WebElement casualDress;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul")
	private WebElement menu;
	
	public void hover(Actions action) {
		action.moveToElement(hoverDress).perform();
	}
	
	public void casualDressClick(Actions action, WebDriver driver) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.visibilityOf(menu));
		System.out.println(menu.isDisplayed());
		casualDress.click();

	}
}
