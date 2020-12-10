package TemplateFile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Account.LoginPage;
import Process.CreateProcess;
import config.PropertiesFile;

public class Template extends PropertiesFile

{
	public static void UploadTemplateFile(WebDriver driver,String DocumentCategory,String Language,String filetype, String individualORcorporate)throws AWTException, InterruptedException
    {  
   	   driver.findElement(By.xpath(p.getProperty("uploadTemplate1"))).click();
       Thread.sleep(3000);
       Robot robot = new Robot();
       driver.findElement(By.xpath(p.getProperty("UploadTempFile"))).click();
       robot.setAutoDelay(1000);
       StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
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
       Thread.sleep(3000);
       driver.findElement(By.xpath(p.getProperty("TemplateSubmit"))).click();
       Thread.sleep(5000);
	   driver.findElement(By.xpath(p.getProperty("CreateTemplate"))).click();
       Thread.sleep(5000);    
	}
	
	@Test(dataProvider="SearchProvider15")
	public void verifyNoTemplateName(String browser) throws InterruptedException, AWTException 
	{   
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String TempName= "Test";
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver, username, password, false);
		CreateProcess.Processcreation(driver);        
        driver.findElement(By.xpath(p.getProperty("TempName"))).sendKeys(TempName);
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("ConfirmTemp"))).click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(p.getProperty("ExtractTables"))).click();
        Thread.sleep(3000);
        
        driver.findElement(By.cssSelector("body > div:nth-child(13) > div.MuiDialog-container.MuiDialog-scrollPaper > div > header > div > button > span.MuiIconButton-label > svg")).click();
        
        driver.findElement(By.xpath(p.getProperty("ViewResult"))).click();
        Thread.sleep(3000);
        
        driver.findElement(By.cssSelector("body > div:nth-child(13) > div.MuiDialog-container.MuiDialog-scrollPaper > div > header > div > button > span.MuiIconButton-label > svg")).click();
        
        driver.findElement(By.xpath(p.getProperty("SaveTemp"))).click();
        Thread.sleep(3000);
        Assert.assertEquals("Your template has been saved successfully", driver.findElement(By.xpath("//div[contains(text(),'Your template has been saved successfully')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your template has been saved successfully')]")).getText());
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("PublishTemp"))).click();
        Thread.sleep(3000);
 
        
	}

	 {
		// TODO Auto-generated method stub
		
	}
	
}


