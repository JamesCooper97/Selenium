package com.QA.BingTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingPageTest {

	WebDriver driver = null;
	Actions action = null;
	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Automated Testing\\Reports\\BingWebPageTest.html");
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	
	@Test
	public void chromeSearchBox() throws InterruptedException {
		test = report.startTest("Search Test");
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing Opened");
		BingPage page = PageFactory.initElements(driver,  BingPage.class);
		BingPage searchedPage = PageFactory.initElements(driver, BingPage.class);
		
		page.searchFor("Chicken");
		Thread.sleep(2000);
		page.clickSearch(action);
		test.log(LogStatus.INFO, "Search Run");
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[2]/h2"));
		System.out.println(checkElement.getText());
		if (checkElement.getText().equals("Chicken")) {
			test.log(LogStatus.PASS, "The chicken element passed");
		} else {
			test.log(LogStatus.FAIL, "There is no spoon");
		}
		assertEquals("Chicken",checkElement.getText());
	}
	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000);
		report.endTest(test);
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}
}
