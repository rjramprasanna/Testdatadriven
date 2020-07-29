package driverpack;

import org.testng.annotations.Test;

import repository.ObjectRepository;
import testdata.TestData;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {


	WebDriver driver;
	ObjectRepository or;
	Library l;
	@Test(dataProvider = "dp", dataProviderClass=TestData.class)
	public void f(String un, String pwd, String cusname ) throws InterruptedException {
		System.out.println(un + " -----> "+ pwd);
		l.inputByName(or.txtUserName, un, "UserName");
		//driver.findElement(or.txtUserName).sendKeys(un);
		//driver.findElement(By.name("userName")).sendKeys(un);
		l.inputByName(or.txtPassword, pwd, "Password");
		//driver.findElement(or.txtPassword).sendKeys(pwd);
		//driver.findElement(or.btnLogin).click();
		l.clickObject(or.btnLogin, "Login button");
		l.clickObject(or.lnknewcustomer, "New Customer");
		l.inputByName(or.txtcustomername, cusname, "name");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//driver.findElement(or.lnkSignOff).click();
		l.clickObject(or.lnkSignOff, "SignOff link");
		driver.switchTo().alert().accept();
	}

	//	@Test(dataProvider = "dpx", dataProviderClass=TestData.class)
	public void g(String un, String pwd, String expWinTitle) {
		System.out.println(un + " -----> "+ pwd);
		System.out.println("Actual window title: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle().trim(), expWinTitle);
		driver.findElement(or.txtUserName).sendKeys(un);
		driver.findElement(or.txtPassword).sendKeys(pwd);
		driver.findElement(or.btnLogin).click();
		driver.findElement(or.lnkSignOff).click();
		driver.switchTo().alert().accept();
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\SELINUM\\SOFTWARE\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/index.php");
		l = new Library(driver);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Close application");
		driver.close();
	}


}
