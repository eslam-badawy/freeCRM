package com.freecrm.testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class HomePage extends TestBase{

	

	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Parameters ({"browser"})
	@BeforeMethod
	public void setup(String browser, Method method) throws ATUTestRecorderException {
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
	public void tearDown(Method method) throws ATUTestRecorderException, IOException {
		recorder.stop();
		TestUtils.takePicture(method.getName());
		driver.quit();
	}

	@Test(priority = 5)
	public void ClickOnContactsTest()  {
		driver.switchTo().frame("mainpanel");
		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		WebElement statusLable = driver.findElement(By.xpath("//td[text()='Status']"));
		boolean ActualResult = statusLable.isDisplayed();
		Assert.assertTrue(ActualResult, "the status lable is not displayed");

	}

	@Test(priority = 6)
	public void ClickOnDealsTest() {
		driver.switchTo().frame("mainpanel");
		WebElement deals = driver.findElement(By.xpath("//a[text()='Deals']"));
		deals.click();
		WebElement KeywordLable = driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean ActualResult = KeywordLable.isDisplayed();
		Assert.assertTrue(ActualResult, "the Keyword lable is not displayed");
	}

	@Test(priority = 7)
	public void ClickOnTasksTest() {
		driver.switchTo().frame("mainpanel");
		WebElement tasks = driver.findElement(By.xpath("//a[text()='Tasks']"));
		tasks.click();
		WebElement KeywordLable = driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean ActualResult = KeywordLable.isDisplayed();
		Assert.assertTrue(ActualResult, "the Keyword lable is not displayed");
	
	}

}
