package DataOutput_File;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import Process_File.Process;
import config.PropertiesFile;

public class DataOutput extends PropertiesFile{
	
	
	public static void OutputData(WebDriver driver) throws InterruptedException
	{ 
		driver.findElement(By.xpath("//button[contains(text(),'Create process')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Next Activity')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Template')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/*[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("SelectTemplate"))).sendKeys("de");
        Thread.sleep(3000);        
        List<WebElement> options =driver.findElements(By.xpath("//LI[@id='combo-box-demo-option-0']"));
    	for(WebElement option :options){
    		if(option.getText().equalsIgnoreCase("demo")){
    	     option.click();  
	         }
    	}
    	Thread.sleep(3000);
    	driver.findElement(By.xpath(p.getProperty("SaveTemp2"))).click();
        
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(p.getProperty("DataSource"))).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("SelectSource"))).click();
	    Thread.sleep(3000);
	}
	
	 public static void DataFileSave(WebDriver driver) throws InterruptedException
	 {
		 
	    
	    WebElement element = driver.findElement(By.xpath(p.getProperty("FileSave")));
	    Actions action = new Actions(driver);
	    action.moveToElement(element).click().perform();
	    Thread.sleep(3000);
	 }
	 public static void SaveData(WebDriver driver) throws InterruptedException
	 {
	    driver.findElement(By.xpath(p.getProperty("SaveData"))).click();
	    Thread.sleep(3000);
	 }
	 public static void OCR(WebDriver driver) throws InterruptedException
	 {
	    driver.findElement(By.xpath(p.getProperty("OCR"))).click();
	    Thread.sleep(3000);
	 }
	 public static void SaveOCR(WebDriver driver) throws InterruptedException
	 {
        driver.findElement(By.xpath(p.getProperty("SaveOCR"))).click();
        Thread.sleep(3000);
	 }
	 public static void OutputFile(WebDriver driver,String FileName) throws InterruptedException
	 {
        driver.findElement(By.xpath(p.getProperty("Output"))).click();
        Thread.sleep(3000); 
        driver.findElement(By.xpath(p.getProperty("FileName"))).sendKeys(FileName);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("OutputFile"))).click();
        Thread.sleep(3000);
	}	
	 public static void OutputSave(WebDriver driver) throws InterruptedException
	 {
		 driver.findElement(By.xpath(p.getProperty("OutputTestButton"))).click();
	     Thread.sleep(5000);
	 }
	 public static void OutputConfirm(WebDriver driver) throws InterruptedException
	 {
		 driver.findElement(By.xpath(p.getProperty("ConfirmOutput"))).click();
		 Thread.sleep(3000);
	 }
	
	 public static void MapKeys(WebDriver driver) throws InterruptedException
	 {
		 driver.findElement(By.xpath(p.getProperty("Format"))).click();
	     Thread.sleep(3000);  
	     Select DataAlignment = new Select(driver.findElement(By.xpath(p.getProperty("DataAlignment"))));
	     DataAlignment.selectByValue("horizontal");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(p.getProperty("MapKeys"))).click();
	     Thread.sleep(3000);
	 }
	 
	 public static void MapKeysFile(WebDriver driver) throws InterruptedException
	 {
		 driver.findElement(By.xpath(p.getProperty("ChooseFile"))).sendKeys("E:\\ENVIRYA PROJECTS\\f111.xlsx");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(p.getProperty("MapButton"))).click();
	     driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]")).click(); 
	     driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).click();
	     Thread.sleep(3000);
	 }
	 
	 public static void UploadTestFile(WebDriver driver,StringSelection file_location) throws InterruptedException, AWTException
	 {
		    Robot robot = new Robot();
	        driver.findElement(By.xpath(p.getProperty("UploadTestFilesBtn"))).click();
	        robot.setAutoDelay(2000);
	        
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
	        driver.findElement(By.xpath(p.getProperty("TestFileSubmit"))).click();
	        Thread.sleep(3000);
	 }
	 public static void ConfirmOutput(WebDriver driver, String FileName) throws InterruptedException
	 {
	        driver.findElement(By.xpath(p.getProperty("OutputFile"))).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(p.getProperty("FileName"))).sendKeys(FileName);
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(p.getProperty("OutputTestButton"))).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath(p.getProperty("ConfirmOutput"))).click();
	        Thread.sleep(3000);
	 }
	@Test(dataProvider="DataProvider")
	public void TestNofilename(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
		OutputSave(driver);   
		Assert.assertEquals("Please enter filename.", driver.findElement(By.xpath("//div[contains(text(),'Please enter filename.')]")).getText());
		System.out.println("Test Passed- Blank File name");
    	driver.quit();         
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidfilename(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
    	String processname = UUID.randomUUID().toString();
    	String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
		OutputSave(driver);
		OutputConfirm(driver);
    	driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoMapkey(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);  
		MapKeys(driver);
        driver.findElement(By.xpath(p.getProperty("MapButton"))).click();
        Thread.sleep(5000);
        driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidMapkey(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);  
		MapKeys(driver);
		MapKeysFile(driver);
        driver.findElement(By.xpath(p.getProperty("SaveMapKeys"))).click();
        driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestInvalidMapkey(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);  
		MapKeys(driver);
        driver.findElement(By.xpath(p.getProperty("ChooseFile"))).sendKeys("E:\\ENVIRYA PROJECTS\\f111.xlsx");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("MapButton"))).click();
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).click();
        Thread.sleep(3000);
        driver.quit();          
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadNoFile(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
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
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
	    StringSelection file_location = new StringSelection("E:\\ENVIRYA PROJECTS\\f111.xlsx");
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        UploadTestFile(driver,file_location);
       
        Assert.assertEquals("Failed to upload file", driver.findElement(By.xpath("//div[contains(text(),'Failed to upload file')]")).getText());
		System.out.println("Test Passed- Failed to upload file");
		driver.quit();    
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadValidFile(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
	    StringSelection file_location = new StringSelection("E:\\ENVIRYA PROJECTS\\Test 1.pdf");
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        UploadTestFile(driver,file_location);
        Thread.sleep(3000);
		driver.quit();    
	}
	
	@Test(dataProvider="DataProvider")
	public void TestUploadUniqueFile(String browser) throws InterruptedException, AWTException
	{
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
	    StringSelection file_location = new StringSelection(" \"E:\\ENVIRYA PROJECTS\\Test 1.pdf\"" +" "+"\"E:\\ENVIRYA PROJECTS\\Test 2.pdf\" ");
	    StringSelection file_location1 = new StringSelection("E:\\ENVIRYA PROJECTS\\Test 1.pdf");
	    WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        UploadTestFile(driver,file_location);
        Thread.sleep(3000);
        UploadTestFile(driver,file_location1);
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
		StringSelection file_location = new StringSelection(" \"E:\\ENVIRYA PROJECTS\\Test 1.pdf\"" +" "+"\"E:\\ENVIRYA PROJECTS\\Test 2.pdf\" "+"\"E:\\ENVIRYA PROJECTS\\Test 3.pdf\" "+"\"E:\\ENVIRYA PROJECTS\\Test 4.pdf\" "+"\"E:\\ENVIRYA PROJECTS\\Test 5.pdf\" "+"\"E:\\ENVIRYA PROJECTS\\Test 6.pdf\" ");
		String username = "madhura@envirya.in";
    	String password = "Test@123";
	    String processname = UUID.randomUUID().toString();
	    String FileName = "TestFile";
		WebDriver driver = createBrowser(browser);	
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		OutputData(driver);
		DataFileSave(driver);
		SaveData(driver);
		OCR(driver);
		SaveOCR(driver);
		OutputFile(driver, FileName);
        driver.findElement(By.xpath(p.getProperty("UploadTestFiles"))).click();
        Thread.sleep(3000);
        UploadTestFile(driver,file_location);
        Thread.sleep(3000);
        Thread.sleep(5000);
        Assert.assertEquals("Failed to upload file", driver.findElement(By.xpath("//div[contains(text(),'Failed to upload file')]")).getText());
		System.out.println("Test Passed- Cannot upload more than 5 files");
        //driver.quit();  
	}
}