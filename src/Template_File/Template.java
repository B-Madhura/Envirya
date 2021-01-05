package Template_File;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import Process_File.Process;
import config.PropertiesFile;

public class Template extends PropertiesFile
{
	public static void UploadTemplateFile(WebDriver driver,StringSelection file_location,String DocumentCategory,String Language,String filetype, String individualORcorporate)throws InterruptedException, AWTException
    {  
   	   driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/*[1]")).click();
       Thread.sleep(3000);
       Robot robot = new Robot();
       driver.findElement(By.xpath(p.getProperty("UploadTempFile"))).click();
       robot.setAutoDelay(1000);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file_location, null);
       robot.setAutoDelay(1000);
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       robot.keyRelease(KeyEvent.VK_V);
       robot.setAutoDelay(1000);
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(3000);
       driver.findElement(By.xpath(p.getProperty("DocCategory"))).sendKeys(DocumentCategory);
       driver.findElement(By.xpath(p.getProperty("Language"))).sendKeys(Language);
       driver.findElement(By.xpath(p.getProperty("FileType"))).sendKeys(filetype);
       driver.findElement(By.xpath(p.getProperty("IndividualButton"))).sendKeys(individualORcorporate);
       Thread.sleep(5000);
       driver.findElement(By.xpath(p.getProperty("TemplateSubmit"))).click();
       Thread.sleep(5000);
    }
	
	public static void CreateTemplate(WebDriver driver,String TempName) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("CreateTemplate"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TempName"))).sendKeys(TempName);
        Thread.sleep(5000);
	}
	
	public static void SaveTemp(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("SaveTemp"))).click();
        Thread.sleep(5000); 
	}
	
	public static void PublishTemp(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("PublishTemp"))).click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/button[1]/span[1]/*[1]")));
        element.click();
	}
	
	public static void SaveTempFile(WebDriver driver)
	{

	    driver.findElement(By.xpath("//div[contains(text(),'Save Template')]")).click();
	    System.out.println("Sucessfully updated the event"); 
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidUploadTemp(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("E:\\ENVIRYA PROJECTS\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Assert.assertEquals("Successfully uploaded image", driver.findElement(By.xpath("//div[contains(text(),'Successfully uploaded image')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Successfully uploaded image')]")).getText());
        Thread.sleep(3000);
		driver.quit();		
	}	
	@Test(dataProvider="DataProvider")
	public void TestUploadTempBlank(String browser) throws InterruptedException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		driver.findElement(By.xpath(p.getProperty("createTemplate"))).click();
	    Thread.sleep(5000);	    
	    Assert.assertEquals("Please create a template by uploading a template file", driver.findElement(By.xpath("//div[contains(text(),'Please create a template by uploading a template f')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please create a template by uploading a template f')]")).getText());
	    driver.quit();		
	}
	@Test(dataProvider="DataProvider")
	public void TestUploadTempFileBlank(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "";
    	String individualORcorporate = "Individual";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		driver.quit();		
	}
	@Test(dataProvider="DataProvider")
	public void TestTempNameBlank(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("E:\\ENVIRYA PROJECTS\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName = "";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Template.SaveTemp(driver);       
        Assert.assertEquals("Please enter template name.",driver.findElement(By.xpath("//div[contains(text(),'Please enter template name.')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please enter template name.')]")).getText());
        driver.quit();
	}

}
