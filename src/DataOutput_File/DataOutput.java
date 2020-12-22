package DataOutput_File;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import Process_File.Process;
import config.PropertiesFile;

public class DataOutput extends PropertiesFile{
	
	
	public static void TestValidDataOutput(WebDriver driver) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname= UUID.randomUUID().toString(); 
		/*int i=1;
		i++;
		String processname = "AutoProcess"+i;*/
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("uploadTemplate1"))).click();
        Thread.sleep(3000);
        
        Robot robot = new Robot();
        driver.findElement(By.xpath(p.getProperty("UploadTempFile"))).click();
        robot.setAutoDelay(2000);
        
        StringSelection selection = new StringSelection("E:\\Madhura\\ENVIRYA PROJECTS\\Test 2.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
 
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
 
        robot.setAutoDelay(1000);
 
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Select FileType=new Select(driver.findElement(By.xpath("//select[@id='bucket']")));
        FileType.selectByVisibleText("general");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TemplateSubmit"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("CreateTemplate"))).click();
	    Thread.sleep(3000);
	    Thread.sleep(5000);
	    Thread.sleep(5000);
	    Thread.sleep(5000);
	   //Click on close icon
	    driver.findElement(By.cssSelector("body > div:nth-child(13) > div.MuiDialog-container.MuiDialog-scrollPaper > div > header > div > button > span.MuiIconButton-label > svg")).click();
	    driver.findElement(By.xpath(p.getProperty("TempName"))).sendKeys("Temp11");
	    //Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("ConfirmTemp"))).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath(p.getProperty("SaveTemp"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("PublishTemp"))).click();
	    Thread.sleep(10000);
	    
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/button[1]/span[1]/*[1]")));
        element.click();	   
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
 
        driver.findElement(By.xpath(p.getProperty("SaveOCR"))).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(p.getProperty("Output"))).click();
        Thread.sleep(3000); 
	}	
	
	@Test(dataProvider="DataProvider")
	public void TestNofilename(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("OutputFile"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("OutputTestButton"))).click();
        Thread.sleep(3000);
       
		Assert.assertEquals("Please enter filename.", driver.findElement(By.xpath("//div[contains(text(),'Please enter filename.')]")).getText());
		System.out.println("Test Passed- Blank File name");
    	driver.quit();
    	          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidfilename(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("OutputFile"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("FileName"))).sendKeys("TestFile");
        driver.findElement(By.xpath(p.getProperty("OutputTestButton"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("ConfirmOutput"))).click();
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoMapkey(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("Format"))).click();
        Thread.sleep(3000);
        
        Select DataAlignment = new Select(driver.findElement(By.xpath(p.getProperty("DataAlignment"))));
        DataAlignment.selectByValue("horizontal");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("MapKeys"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("MapButton"))).click();
        Thread.sleep(5000);
        driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidMapkey(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("Format"))).click();
        Thread.sleep(3000);
        
        Select DataAlignment = new Select(driver.findElement(By.xpath(p.getProperty("DataAlignment"))));
        DataAlignment.selectByValue("horizontal");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("MapKeys"))).click();
        driver.findElement(By.xpath(p.getProperty("ChooseFile"))).sendKeys("E:\\Madhura\\ENVIRYA PROJECTS\\f111.xlsx");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("MapButton"))).click();
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("SaveMapKeys"))).click();
        driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestInvalidMapkey(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("Format"))).click();
        Thread.sleep(3000);
       
        driver.findElement(By.xpath(p.getProperty("MapKeys"))).click();
        driver.findElement(By.xpath(p.getProperty("ChooseFile"))).sendKeys("E:\\Madhura\\ENVIRYA PROJECTS\\f111.xlsx");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("MapButton"))).click();
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).click();
        Thread.sleep(3000);
        driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadNoFile(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
        Thread.sleep(3000);
        Assert.assertEquals("No file selected.", driver.findElement(By.xpath("//div[contains(text(),'No file selected.')]")).getText());
		System.out.println("Test Passed- No file selected.");
		driver.quit();    
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadInvalidFile(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        
        Robot robot1 = new Robot();
        driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
        robot1.setAutoDelay(2000);
        
        StringSelection selection = new StringSelection("E:\\Madhura\\ENVIRYA PROJECTS\\f111.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        robot1.setAutoDelay(1000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
 
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
 
        robot1.setAutoDelay(1000);
 
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
        Thread.sleep(3000);
        Assert.assertEquals("Failed to upload file", driver.findElement(By.xpath("//div[contains(text(),'Failed to upload file')]")).getText());
		System.out.println("Test Passed- Failed to upload file");
		driver.quit();    
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadUniqueFile(String browser) throws InterruptedException, AWTException
	{
		String files=" \"E:\\Madhura\\ENVIRYA PROJECTS\\Test 1.pdf\"" +" "+"\"E:\\Madhura\\ENVIRYA PROJECTS\\Test 2.pdf\" ";
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        
        Robot robot1 = new Robot();
        driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
        robot1.setAutoDelay(2000);
    
        StringSelection selection = new StringSelection(files);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        robot1.setAutoDelay(1000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
 
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
 
        robot1.setAutoDelay(1000);
 
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        
        Robot robot2 = new Robot();
        driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
        robot2.setAutoDelay(2000);
    
        StringSelection selection1 = new StringSelection("E:\\Madhura\\ENVIRYA PROJECTS\\Test 1.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
        
        robot2.setAutoDelay(1000);
        robot2.keyPress(KeyEvent.VK_CONTROL);
        robot2.keyPress(KeyEvent.VK_V);
 
        robot2.keyRelease(KeyEvent.VK_CONTROL);
        robot2.keyRelease(KeyEvent.VK_V);
 
        robot2.setAutoDelay(1000);
 
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
        Thread.sleep(3000);
        String expected = "file already uploaded.";
        String get_text = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")).getText();
        String actual= get_text.substring(get_text.indexOf("file") + 0);
        Assert.assertEquals(expected, actual);
		System.out.println("Test Passed- file already uploaded");
		driver.quit();    
	
	}

	@Test(dataProvider="DataProvider")
	public void TestUploadFiveFile(String browser) throws InterruptedException, AWTException
	{
		String files=" \"E:\\Madhura\\ENVIRYA PROJECTS\\Test 1.pdf\"" +" "+"\"E:\\Madhura\\ENVIRYA PROJECTS\\Test 2.pdf\" "+"\"E:\\Madhura\\ENVIRYA PROJECTS\\Test 3.pdf\" "+"\"E:\\Madhura\\ENVIRYA PROJECTS\\Test 4.pdf\" "+"\"E:\\Madhura\\ENVIRYA PROJECTS\\Test 5.pdf\" "+"\"E:\\Madhura\\ENVIRYA PROJECTS\\Test 6.pdf\" ";
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        
        Robot robot1 = new Robot();
        driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
        robot1.setAutoDelay(2000);
    
        StringSelection selection = new StringSelection(files);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        robot1.setAutoDelay(1000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
 
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
 
        robot1.setAutoDelay(1000);
 
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
        Thread.sleep(3000);
        Assert.assertEquals("Failed to upload file", driver.findElement(By.xpath("//div[contains(text(),'Failed to upload file')]")).getText());
		System.out.println("Test Passed- Cannot upload more than 5 files");
        //driver.quit();  
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadValidFile(String browser) throws InterruptedException, AWTException
	{
		WebDriver driver = createBrowser(browser);	
		TestValidDataOutput(driver);
		Thread.sleep(3000);
		 
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        
        Robot robot1 = new Robot();
        driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
        robot1.setAutoDelay(2000);
        
        StringSelection selection = new StringSelection("E:\\Madhura\\ENVIRYA PROJECTS\\Test 1.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        robot1.setAutoDelay(1000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
 
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
 
        robot1.setAutoDelay(1000);
 
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
        Thread.sleep(3000);
		driver.quit();    
	}
}
