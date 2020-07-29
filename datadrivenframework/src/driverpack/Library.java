package driverpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Library {

	WebDriver driver;

	public Library(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void inputByName(By object, String testData, String objName)
	{
		if(driver.findElements(object).size()==1)
		{
			driver.findElement(object).sendKeys(testData);
		}else
		{
			Assert.fail(objName + "- Object is not available");
		}
	}

	public void clickObject(By object,String objName)
	{
		if(driver.findElements(object).size()==1)
		{
			driver.findElement(object).click();
		}else
		{
			Assert.fail(objName + "- Object is not available");
		}
	}
}
