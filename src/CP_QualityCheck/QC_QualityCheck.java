package CP_QualityCheck;

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

public class QC_QualityCheck extends PropertiesFile {
	
	public static void QualityCheck(WebDriver driver) throws InterruptedException, AWTException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("QC_verifyBtn"))).click();
		Thread.sleep(3000);
	}
	
	public static void QC_Update(WebDriver driver,String updatedate) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(p.getProperty("Datetextbox"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("Datetextbox"))).sendKeys(updatedate);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("UpdateDoc"))).click();
		Thread.sleep(3000);
	}
	public static void QC_UpdateText(WebDriver driver,String updatetext) throws InterruptedException
	{
		driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys(updatetext);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
		Thread.sleep(3000);
	}
	public static void QC_Verify(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("QCVerify"))).click();
        Thread.sleep(3000);
	}
	public static void QC_ViewSummary(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("ViewLogsQC"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("ViewSummary"))).click();
    	Thread.sleep(3000);
	}
	@Test(dataProvider="DataProvider")
	public void QC_TestNoUpdate(String browser) throws InterruptedException, AWTException
	{
		String username = "madhuraqc@envirya.in";
    	String password = "Test@123";
    	String updatedate= "";
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver, username, password, false);
		QualityCheck(driver);
		QC_Update(driver, updatedate);
		Assert.assertEquals("Please edit something to update", driver.findElement(By.xpath("//div[contains(text(),'Please edit something to update')]")).getText());
		System.out.println("Test Passed- No Update");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QC_TestUpdate(String browser) throws InterruptedException, AWTException
	{
		String username = "madhuraqc@envirya.in";
    	String password = "Test@123";
		String updatetext = "Text Changed";
		String updatedate = "30/04/2020";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		QualityCheck(driver);
		QC_Update(driver,updatedate);
		QC_UpdateText(driver, updatetext);
		Assert.assertEquals("Successfully updated extracted data", driver.findElement(By.xpath("//div[contains(text(),'Successfully updated extracted data')]")).getText());
		System.out.println("Test Passed- Successfully updated extracted data");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QC_TestVerify(String browser) throws InterruptedException, AWTException
	{
		String username = "madhuraqc@envirya.in";
    	String password = "Test@123";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		QualityCheck(driver);
		QC_Verify(driver);
		Assert.assertEquals("Successfully verified quality check data", driver.findElement(By.xpath("//div[contains(text(),'Successfully verified quality check data')]")).getText());
		System.out.println("Test Passed- Data Verified");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void QC_TestViewLogs(String browser) throws InterruptedException, AWTException
	{
		String username = "madhuraqc@envirya.in";
    	String password = "Test@123";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		QC_ViewSummary(driver);
    	driver.quit();          
	}

	
}
