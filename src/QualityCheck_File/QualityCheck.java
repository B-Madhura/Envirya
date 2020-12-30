package QualityCheck_File;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataOutput_File.DataOutput;
import config.PropertiesFile;

public class QualityCheck extends PropertiesFile{
	
	public static void TestQualityCheck(WebDriver driver) throws InterruptedException, AWTException
	{
		DataOutput.TestValidDataOutput(driver);
		Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("OutputFile"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("FileName"))).sendKeys("TestFile");
        driver.findElement(By.xpath(p.getProperty("OutputTestButton"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("ConfirmOutput"))).click();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoQC(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestQualityCheck(driver);
		Thread.sleep(3000);
		 
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
		WebDriver driver = createBrowser(browser);	
		TestQualityCheck(driver);
		Thread.sleep(3000);
		 
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
		WebDriver driver = createBrowser(browser);	
		TestQualityCheck(driver);
		Thread.sleep(3000);
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
        Assert.assertEquals("Successfully added qc users", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qc users')]")).getText());
		System.out.println("Test Passed- Successfully added QC");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidQV(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestQualityCheck(driver);
		Thread.sleep(3000);
		 
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
        Assert.assertEquals("Successfully added qv users", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qv users')]")).getText());
		System.out.println("Test Passed- Successfully added QV");
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidQCQV(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestQualityCheck(driver);
		Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Next Activity')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("QualityCheck"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("qc");
        Thread.sleep(3000);
        List<WebElement> QC =driver.findElements(By.xpath("//LI[@id='combo-box-demo-option-0']"));
    	for(WebElement option :QC){
    		if(option.getText().equalsIgnoreCase("madhuraqc@envirya.in")){
    	     option.click();  
	         }
    	}
    	Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddQCUser"))).click();
        Thread.sleep(3000);
        Assert.assertEquals("Successfully added qc users", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qc users')]")).getText());
		System.out.println("Test Passed- Successfully added QC");
		Thread.sleep(3000);
		//((JavascriptExecutor)driver).executeScript("scroll(0,900)");
		//Thread.sleep(3000);
		//driver.findElement(By.xpath(p.getProperty("QualityCheckApprovers"))).click();
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
