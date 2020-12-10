package Process;

import java.awt.datatransfer.StringSelection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.PropertiesFile;
import org.openqa.selenium.support.ui.Select;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.UUID;
import java.awt.Toolkit;

public class CreateProcess extends PropertiesFile 

{
	public static void Processcreation(WebDriver driver)
	{   
		String uuid = UUID.randomUUID().toString();   		    
	    driver.findElement(By.xpath(p.getProperty("ProcessName"))).sendKeys(uuid);
        System.out.println("Enter Process Name :- " +uuid);
	} 
	
	@Test(dataProvider="SearchProvider12")
	public void verifyCreateProcess(String Type , String ProcessName) throws InterruptedException, AWTException 
	{   
		driver.findElement(By.xpath(p.getProperty("username"))).sendKeys("roohi@envirya.in");
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("password"))).sendKeys("Yaali@1421");
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("login"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("CreateProcess"))).click();
		Thread.sleep(3000);
		
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is - " +pageTitle);
		Assert.assertEquals("Create Process",pageTitle);
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("ProcessName"))).sendKeys(ProcessName);
        System.out.println("Enter Process Name :- " +ProcessName);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("uploadTemplate1"))).click();
        Thread.sleep(3000);
        
        Robot robot = new Robot();
        driver.findElement(By.xpath(p.getProperty("uploadTemplate2"))).click();
        robot.setAutoDelay(1000);
        
        StringSelection selection = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\PDF.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        robot.setAutoDelay(1000);
        
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
 
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
 
        robot.setAutoDelay(1000);
 
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(3000);
        Select DocCategory= new Select (driver.findElement(By.xpath(p.getProperty("DocCategory"))));
        DocCategory.selectByVisibleText("InvoiceMaster");
        Thread.sleep(3000);
        Select FileType=new Select(driver.findElement(By.xpath(p.getProperty("FileType"))));
        FileType.selectByVisibleText("System Generated Pdf");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("IndividualButton"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TemplateSubmit"))).click();
        Thread.sleep(5000);
        
        Assert.assertEquals("Successfully uploaded image", driver.findElement(By.xpath("//div[contains(text(),'Successfully uploaded image')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Successfully uploaded image')]")).getText());
	}
	
	
	
	@DataProvider(name="SearchProvider12")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Valid","Start1"},
		
			};
	}
}


