package com.QA.practice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class RunnerTest {
	ChromeDriver driver;
	private String url = "http://thedemosite.co.uk/";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	  public void testUntitledTestCase() throws Exception {
	    driver.findElement(By.linkText("4. Login")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("FormsButton2")).click();
	    //assertEquals("Username too short.  The username must be at least 4 characters in length.", closeAlertAndGetItsText());
	  }
	
	@After
	public void tearDown() {
		
	}
}
