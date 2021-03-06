package com.QA.PassionTea;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingTea {
	WebDriver driver = null;
	FileInputStream file = null;
	
	public static ExtentReports report;
	public ExtentTest test;
	
	WelcomePage welcomePage = null;
	MenuPage menuPage = null;
	LetsTalkTeaPage teaPage = null;
	OurPassionPage passionPage = null;
	CheckoutPage checkoutPage = null;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Automated Testing\\Reports\\DDT1 Reports\\BDD.html");
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		test = report.startTest("Scenario 1");
		test.log(LogStatus.INFO, "Driver Initiated");
		driver.get(Constants.HomePage);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		welcomePage.clickMenu();
		menuPage = PageFactory.initElements(driver, MenuPage.class);
		menuPage.checkoutClick();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		assertEquals()
	    throw new PendingException();
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		report.endTest(test);
		driver.quit();
	}
}
