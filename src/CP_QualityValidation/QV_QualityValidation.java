package CP_QualityValidation;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import config.PropertiesFile;

public class QV_QualityValidation extends PropertiesFile {
	public static void QualityValidation(WebDriver driver) throws InterruptedException, AWTException
	{
		String username = "madhuraqv@envirya.in";
    	String password = "Test@123";
		LoginPage.login(driver, username, password, false);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("CP_QualityValidation"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ValidateQV"))).click();
		Thread.sleep(3000);
	}
	
	public static void QV_Update(WebDriver driver,String updatedate, String updatetext) throws InterruptedException, AWTException{
		
		driver.findElement(By.xpath(p.getProperty("Datetextbox"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		driver.findElement(By.xpath(p.getProperty("Datetextbox"))).sendKeys(updatedate);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("UpdateQV"))).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys(updatetext);
    	driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
    	Thread.sleep(3000);
	}
	
	@Test(dataProvider="DataProvider")
	public void QV_TestNoUpdate(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		QualityValidation(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("UpdateQV"))).click();
        Thread.sleep(3000);
		Assert.assertEquals("Please edit something to update", driver.findElement(By.xpath("//div[contains(text(),'Please edit something to update')]")).getText());
		System.out.println("Test Passed- No Update");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QV_TestUpdate(String browser) throws InterruptedException, AWTException
	{
		String updatetext = "Text Changed";
		String updatedate = "30/04/2020";
		WebDriver driver = createBrowser(browser);	
		QualityValidation(driver);
		Thread.sleep(3000);
		QV_Update(driver,updatedate,updatetext);
		Assert.assertEquals("Successfully updated extracted data", driver.findElement(By.xpath("//div[contains(text(),'Successfully updated extracted data')]")).getText());
		System.out.println("Test Passed- Successfully updated extracted data");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QV_TestApproved(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		QualityValidation(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ApproveDoc"))).click();
        Thread.sleep(3000);
		Assert.assertEquals("Successfully approved extracted data quality check", driver.findElement(By.xpath("//div[contains(text(),'Successfully approved extracted data quality check')]")).getText());
		System.out.println("Test Passed- approved");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QV_TestRejected(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		QualityValidation(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("RejectDoc"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Change rejected");
        driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
        Thread.sleep(3000);
		Assert.assertEquals("rejected extracted data quality check", driver.findElement(By.xpath("//div[contains(text(),'rejected extracted data quality check')]")).getText());
		System.out.println("Test Passed- rejected");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QV_TestViewLogs(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		String username = "madhuraqv@envirya.in";
    	String password = "Test@123";
		LoginPage.login(driver, username, password, false);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("CP_QualityValidation"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ViewLogsQV"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("ViewSummary"))).click();
    	Thread.sleep(3000);
    	driver.quit();          
	}
}
