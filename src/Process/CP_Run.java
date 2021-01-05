package Process;

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

public class CP_Run extends PropertiesFile

{
	@Test(dataProvider="SearchProvider31")
	public void verifyQualityCheckApprovers(String Type , String ProcessName) throws InterruptedException, AWTException
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
        Thread.sleep(5000);
        
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
	    
	    driver.findElement(By.cssSelector("body > div:nth-child(13) > div.MuiDialog-container.MuiDialog-scrollPaper > div > header > div > button > span.MuiIconButton-label > svg")).click();
	    
	    driver.findElement(By.xpath(p.getProperty("SaveTemp"))).click();
	    Thread.sleep(3000);
	    Assert.assertEquals("Your template has been saved successfully", driver.findElement(By.xpath("//div[contains(text(),'Your template has been saved successfully')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your template has been saved successfully')]")).getText());
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath(p.getProperty("PublishTemp"))).click();
	    Thread.sleep(3000);
	    Assert.assertEquals("Your template has been published", driver.findElement(By.xpath("//div[contains(text(),'Your template has been published')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your template has been published')]")).getText());
	    Thread.sleep(5000);
	    
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
        
	    driver.findElement(By.xpath(p.getProperty("OCR"))).click();
	    Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("EnviryaOCR"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("OCRSubmit"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("SaveOCR"))).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("Output"))).click();
        Thread.sleep(3000);
        
        Select ExportTo= new Select(driver.findElement(By.xpath(p.getProperty("Export"))));
        ExportTo.selectByVisibleText("Export to .xls");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("OutputFile"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("FileName"))).sendKeys("Test");
        Thread.sleep(3000);
        
        Select DocSep = new Select(driver.findElement(By.xpath(p.getProperty("DocumentSeparator"))));
        DocSep.selectByVisibleText("worksheets");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("Format"))).click();
        Thread.sleep(3000);
        
        Robot robot1 = new Robot();
        driver.findElement(By.xpath(p.getProperty("MapKeys"))).click();
        robot1.setAutoDelay(2000);
  
        StringSelection selection1 = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\File.zip");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
        
        robot1.setAutoDelay(1000);
        
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
 
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
 
        robot1.setAutoDelay(1000);
 
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("SaveMapKeys"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TestFileReset"))).click();
        Thread.sleep(3000);
        
        //Robot robot2 = new Robot();
        //driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
        //robot2.setAutoDelay(2000);
        
        //StringSelection selection2 = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\PDF.pdf");
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2, null);
        //robot2.setAutoDelay(1000);
        
        //robot2.keyPress(KeyEvent.VK_CONTROL);
        //robot2.keyPress(KeyEvent.VK_V);
 
        //robot2.keyRelease(KeyEvent.VK_CONTROL);
        //robot2.keyRelease(KeyEvent.VK_V);
 
        //robot2.setAutoDelay(1000);
 
        //robot2.keyPress(KeyEvent.VK_ENTER);
        //robot2.keyRelease(KeyEvent.VK_ENTER);
        //Thread.sleep(3000);
        
       //driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("OutputTestButton"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("ConfirmOutput"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("SaveOutput"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("NextActivity"))).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(p.getProperty("QualityCheck"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("QualityCheckers"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("SearchQCUsers"))).sendKeys("roohiqc@envirya.in");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("AddQCUser"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("QualityCheckApprovers"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("SearchQCValidator"))).sendKeys("roohiqv@envirya.in");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("AddQCApprover"))).click();
	    Thread.sleep(3000);
	    Assert.assertEquals("Successfully added qc validators", driver.findElement(By.xpath("//div[contains(text(),'Successfully added qc validators')]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Successfully added qc validators')]")).getText());
	    
	    driver.findElement(By.xpath(p.getProperty("ConfirmQuality"))).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath(p.getProperty("CP_Save"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("CP_Run"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("EnterInstanceName"))).sendKeys("Test");
	    Thread.sleep(3000);
	    
	    Robot robot2 = new Robot();
	    driver.findElement(By.xpath(p.getProperty("CP_File"))).click();
	    robot2.setAutoDelay(2000);
	    StringSelection selection2 = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\File.zip");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2, null);
        robot2.setAutoDelay(1000);
        
        robot2.keyPress(KeyEvent.VK_CONTROL);
        robot2.keyPress(KeyEvent.VK_V);
 
        robot2.keyRelease(KeyEvent.VK_CONTROL);
        robot2.keyRelease(KeyEvent.VK_V);
 
        robot2.setAutoDelay(1000);
 
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
 
        driver.findElement(By.xpath(p.getProperty("CP_Upload"))).click();	    
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("CP_Submit"))).click();
        Thread.sleep(3000);
        
	}
	
	
	
	@DataProvider(name="SearchProvider31")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Quality Check Approvers","Start50"},
		
			};
	}



}
