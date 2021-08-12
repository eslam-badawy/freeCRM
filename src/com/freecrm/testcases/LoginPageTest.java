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


public class LoginPageTest extends TestBase {


	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@Parameters ({"browser"})
	@BeforeMethod
	public void setup(String browser,Method method) throws ATUTestRecorderException {
		initialization(browser);
		recorder = new ATUTestRecorder("E:\\workspace\\FreeCRMApplication\\videos" , method.getName() , false);
		recorder.start();

	}

	@AfterMethod
	public void tearDown(Method method) throws ATUTestRecorderException, IOException {
		recorder.stop();
		TestUtils.takePicture(method.getName());
		driver.quit();
	}

	@Test(priority = 1)
	public void titleTest() {
		String Expectedresult = ("Free CRM - CRM software for customer relationship management, sales, and support.");
		String Actualresult = driver.getTitle();
		System.out.println(Actualresult);
		Assert.assertEquals(Actualresult, Expectedresult, "the title is not correct");
	
	}

	@Test(priority = 2)
	public void urlCheck()  {
		String Expectedresult = ("https://classic.freecrm.com/index.html");
		String Actualresult = driver.getCurrentUrl();
		System.out.println(Actualresult);
		Assert.assertEquals(Actualresult, Expectedresult, "the url is not correct");
	}

	@Test(priority = 3)
	public void logoTest() {
		WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
		boolean Actualresult = logo.isDisplayed();
		System.out.println(Actualresult);
		Assert.assertTrue(Actualresult, "the logo is not displayed");


	}

	@Test(priority = 4)
	public void loginTest()  {
		WebElement loginTextBox = driver.findElement(By.name("username"));
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginTextBox.sendKeys(prop.getProperty("username"));
		passwordTextBox.sendKeys(prop.getProperty("password"));
		loginButton.click();
		String Expectedresult = ("CRMPRO");
		String Actualresult = driver.getTitle();
		Assert.assertEquals(Actualresult, Expectedresult, "username or password is wrong");


	}

	

}
