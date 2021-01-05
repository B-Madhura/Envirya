package Template_File;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class NoTemplateName extends PropertiesFile 

{
	@Test(dataProvider="DataProvider")
	public void verifyNoTemplateName(String Type , String ProcessName) throws InterruptedException, AWTException 
	{   
		driver.findElement(By.xpath(p.getProperty("username"))).sendKeys("roohi@envirya.in");
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("password"))).sendKeys("Yaali@1421");
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("login"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("CreateProcess"))).click();
		Thread.sleep(3000);
		
        driver.findElement(By.xpath(p.getProperty("ProcessName"))).sendKeys(ProcessName);
        System.out.println("Enter Process Name :- " +ProcessName);
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("uploadTemplate1"))).click();
        Thread.sleep(3000);
        
        Robot robot = new Robot();
        driver.findElement(By.xpath(p.getProperty("uploadTemplate2"))).click();
        robot.setAutoDelay(2000);
        
        StringSelection selection = new StringSelection("E:\\ENVIRYA PROJECTS\\PDF.pdf");
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
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("CreateTemplate"))).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("SaveTemp"))).click();
        Thread.sleep(5000);
        
        Assert.assertEquals("Please enter template name.",driver.findElement(By.xpath("//div[contains(text(),'Please enter template name.')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please enter template name.')]")).getText());
	}
	
}
