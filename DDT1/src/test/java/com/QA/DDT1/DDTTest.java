package com.QA.DDT1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class DDTTest {
	WebDriver driver = null;
	Actions action = null;
	FileInputStream file = null;
	FileOutputStream fileOut = null;
	XSSFWorkbook workbook = null;
	int i = 0;
	
	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Automated Testing\\Reports\\DDT1 Reports\\DDT.html");
	}
	
	@Before
	public void setup() {
		i++;
		test = report.startTest("Starting Test" + i);
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	
	@Test
	public void test1() throws FileNotFoundException, IOException{
		test = report.startTest("Open File");
		test.log(LogStatus.INFO,"Report Initialised");
		
		ExcelUtils.setExcelFile();
		test.log(LogStatus.INFO, "Workbook Opened and sheet selected");
		
//		XSSFSheet sheet = ExcelUtils.getExcelSheet();
//		test.log(LogStatus.INFO,"Sheet Retrieved");
		
		driver.get(Constant.URLAddUser);
		test.log(LogStatus.INFO, "Driver Initiated");

		AddUser user = PageFactory.initElements(driver, AddUser.class);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		for (int i = 1 ; i < 5 ; i++) {
			String username = ExcelUtils.getCellData(i, 0);
			String password = ExcelUtils.getCellData(i, 1);
			user.addUser(username);
			user.addPassword(password);
			user.clickSave();
			user.clickLoginLink();
			login.loginUser(username);
			login.loginPassword(password);
			login.clickLogin();
			WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
			if (checkElement.getText().equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "The add user and login passed");
				ExcelUtils.setCellData("Pass", i, 2);
			} else {
				test.log(LogStatus.FAIL, "There is no spoon");
				ExcelUtils.setCellData("Fail", i, 2);
			}
			assertEquals(checkElement.getText(),"**Successful Login**");
			login.clickAddUserLink();
		}
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		report.endTest(test);
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}
}
