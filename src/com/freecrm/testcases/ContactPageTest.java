package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactPageTest extends TestBase {

	public ContactPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Parameters ({"browser"})
	@BeforeMethod
	public void setup(String browser,Method method) throws ATUTestRecorderException {
		initialization(browser);
		recorder = new ATUTestRecorder("E:\\workspace\\FreeCRMApplication\\videos" , method.getName() , false);
		recorder.start();
		WebElement loginTextBox = driver.findElement(By.name("username"));
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginTextBox.sendKeys(prop.getProperty("username"));
		passwordTextBox.sendKeys(prop.getProperty("password"));
		loginButton.click();
	}
	
	@AfterMethod
	public void TearDown(Method method) throws IOException, ATUTestRecorderException {
		recorder.stop();
		TestUtils.takePicture(method.getName());
		driver.quit();
	}
	
	@Test (dataProvider = "TestData")
	public void addContact(String fname, String lname, String companyname, String departmentname) {
		driver.switchTo().frame("mainpanel");
		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		WebElement newcontact = driver.findElement(By.xpath("//a[text()='New Contact']"));
		newcontact.click();
		
		WebElement firstname = driver.findElement(By.id("first_name"));
		WebElement lastname = driver.findElement(By.id("surname"));
		WebElement company = driver.findElement(By.name("client_lookup"));
		WebElement department = driver.findElement(By.id("department"));
		WebElement save = driver.findElement(By.xpath("//input[@type='submit']"));
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(lname);
		department.sendKeys(departmentname);
		save.click();
		
		
	}
	
	@DataProvider
	public Object[][] TestData() throws Throwable{
		
		Object data[][]= TestUtils.getdDataFromExcell("Sheet1");
		return data;
		
		
	}
	
	

}
