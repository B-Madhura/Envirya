package QualityCheck_File;

import java.awt.AWTException;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import DataOutput_File.DataOutput;
import Process_File.Process;
import config.PropertiesFile;

public class QualityCheck extends PropertiesFile{
	
	public static void TestQualityCheck(WebDriver driver,String FileName) throws InterruptedException, AWTException
	{
		
		DataOutput.OutputData(driver);
		DataOutput.DataFileSave(driver);
		DataOutput.SaveData(driver);
		DataOutput.OCR(driver);
		DataOutput.SaveOCR(driver);
		DataOutput.OutputFile(driver, FileName);
		DataOutput.OutputSave(driver);
		Thread.sleep(3000);
		DataOutput.OutputConfirm(driver);
	}
	
	public static void TestAddQC(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[contains(text(),'Next Activity')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("QualityCheck"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("qc");
        Thread.sleep(3000);
        List<WebElement> options =driver.findElements(By.xpath("//LI[@id='combo-box-demo-option-0']"));
    	for(WebElement option :options){
    		if(option.getText().equalsIgnoreCase("madhuraqc@envirya.in")){
    	     option.click();  
	         }
    	}
    	Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddQCUser"))).click();
        Thread.sleep(3000);
	}
	
	public static void TestAddQV(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[contains(text(),'Next Activity')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[contains(text(),'Quality check')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("QualityCheckApprovers"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("qv");
	    Thread.sleep(3000);
	    List<WebElement> options =driver.findElements(By.xpath("//LI[@id='combo-box-demo-option-0']"));
		for(WebElement option :options){
			if(option.getText().equalsIgnoreCase("madhuraqv@envirya.in")){
		     option.click();  
	         }
		}
		Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("AddQCApprover"))).click();
	    Thread.sleep(3000);
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoQC(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		TestQualityCheck(driver,FileName);
        driver.findElement(By.xpath("//div[contains(text(),'Next Activity')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("QualityCheck"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddQCUser"))).click();
        Thread.sleep(3000);
		Assert.assertEquals("Please select any user to add", driver.findElement(By.xpath("//div[contains(text(),'Please select any user to add')]")).getText());
		System.out.println("Test Passed- No QC selected");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoQV(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		TestQualityCheck(driver,FileName);
        driver.findElement(By.xpath("//div[contains(text(),'Next Activity')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("QualityCheckApprovers"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddQCApprover"))).click();
        Thread.sleep(3000);
		Assert.assertEquals("Please select any user to add", driver.findElement(By.xpath("//div[contains(text(),'Please select any user to add')]")).getText());
		System.out.println("Test Passed- No QV selected");
    	driver.quit();          
	} 
	
	@Test(dataProvider="DataProvider")
	public void TestValidQC(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		TestQualityCheck(driver,FileName);
		TestAddQC(driver);
        Assert.assertEquals("Successfully added qc users", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qc users')]")).getText());
		System.out.println("Test Passed- Successfully added QC");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidQV(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		TestQualityCheck(driver,FileName);
		TestAddQV(driver);
        Assert.assertEquals("Successfully added qv users", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qv users')]")).getText());
		System.out.println("Test Passed- Successfully added QV");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidQCQV(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		TestQualityCheck(driver,FileName);
		TestAddQC(driver);
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(p.getProperty("QualityCheckApprovers")));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("qv");
        Thread.sleep(3000);
        List<WebElement> QV =driver.findElements(By.xpath("//LI[@id='combo-box-demo-option-0']"));
    	for(WebElement option :QV){
    		if(option.getText().equalsIgnoreCase("madhuraqv@envirya.in")){
    	     option.click();  
	         }
    	}
    	Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddQCApprover"))).click();
        Thread.sleep(3000);
        Assert.assertEquals("Successfully added qc validators", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qc validators')]")).getText());
		System.out.println("Test Passed- Successfully added QV");
		Thread.sleep(5000);
		//driver.findElement(By.xpath(p.getProperty("ConfirmQuality"))).click();
		WebElement element1 = driver.findElement(By.xpath(p.getProperty("ConfirmQuality")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).click().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("SaveQC"))).click();
		driver.quit();          
	}
	
}
