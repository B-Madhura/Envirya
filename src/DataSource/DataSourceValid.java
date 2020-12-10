package DataSource;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class DataSourceValid extends PropertiesFile

{
	@Test(dataProvider="SearchProvider19")
	public void verifyDataSourceValid(String Type , String ProcessName) throws InterruptedException, AWTException 
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
	    Thread.sleep(3000);
	    
	    Assert.assertEquals("Successfully uploaded image", driver.findElement(By.xpath("//div[contains(text(),'Successfully uploaded image')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Successfully uploaded image')]")).getText());
        
	    driver.findElement(By.xpath(p.getProperty("CreateTemplate"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("TempName"))).sendKeys("Start");
	    Thread.sleep(3000);
	
	    driver.findElement(By.xpath(p.getProperty("ConfirmTemp"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("ExtractTables"))).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.cssSelector("body > div:nth-child(13) > div.MuiDialog-container.MuiDialog-scrollPaper > div > header > div > button > span.MuiIconButton-label > svg")).click();
	    
	    driver.findElement(By.xpath(p.getProperty("ViewResult"))).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.cssSelector("body >div:nth-child(13) > div.MuiDialog-container.MuiDialog-scrollPaper > div > header > div > button > span.MuiIconButton-label > svg")).click();
	    
	    driver.findElement(By.xpath(p.getProperty("SaveTemp"))).click();
	    Thread.sleep(5000);
	    Assert.assertEquals("Your template has been saved successfully", driver.findElement(By.xpath("//div[contains(text(),'Your template has been saved successfully')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your template has been saved successfully')]")).getText());
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath(p.getProperty("PublishTemp"))).click();
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/button[1]/span[1]/*[1]")));
        element.click();	    
	
	    driver.findElement(By.xpath(p.getProperty("SaveTemp2"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("NextActivity"))).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(p.getProperty("DataSource"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("SelectSource"))).click();
	    Thread.sleep(3000);
	    
	    Select DropSelect=new Select(driver.findElement(By.xpath(p.getProperty("DropSelect"))));
	    DropSelect.selectByVisibleText("Zip");
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath(p.getProperty("FileSave"))).click();
	    Thread.sleep(3000);
	    
	   driver.findElement(By.xpath(p.getProperty("SaveData"))).click();
	   Thread.sleep(3000);
        
        
	}


	@DataProvider(name="SearchProvider19")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Valid","Start7"}
		
			};
	}
}
