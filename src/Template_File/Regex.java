package Template_File;

import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import Process_File.Process;
import config.PropertiesFile;

public class Regex extends PropertiesFile
{
	public static void Edit(WebDriver driver,String FieldName,String AliasName) throws InterruptedException
	{
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement Edit= driver.findElement(By.name("InvoiceNum"));
        je.executeScript("arguments[0].scrollIntoView(true);", Edit);
        Thread.sleep(3000);
        Edit.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='5e9d594c16e92d36fd170242']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("FieldName"))).clear();
        driver.findElement(By.xpath(p.getProperty("FieldName"))).sendKeys(FieldName);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AliasName"))).sendKeys(AliasName);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddAlias"))).click();
        Thread.sleep(3000);
		
	}
	
	public static void AddNew(WebDriver driver,String FieldName,String AliasName) throws InterruptedException
	{       
		JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement Addnew= driver.findElement(By.xpath(p.getProperty("AddNew")));
        Thread.sleep(3000);
        je.executeScript("arguments[0].scrollIntoView(true);", Addnew);
        Thread.sleep(3000);
        Addnew.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("FieldName"))).sendKeys(FieldName);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AliasName"))).sendKeys(AliasName);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("AddAlias"))).click();
        Thread.sleep(3000);

	}
	public static void DoneNewField(WebDriver driver) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("Done"))).click();
        Thread.sleep(5000);
		
	}
	public static void AddFormat(WebDriver driver,String SampleValue) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("AddFormat"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("SampleValue"))).sendKeys(SampleValue);
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("Next"))).click();
        Thread.sleep(2000);
	}
	public static void AlphabetType(WebDriver driver,String range1,String range2) throws InterruptedException
	{
		Select CharacterType= new Select (driver.findElement(By.xpath(p.getProperty("BlockType"))));
        CharacterType.selectByVisibleText("Alphabet");
        Select Alphabet= new Select (driver.findElement(By.xpath(p.getProperty("AlphabetChoice"))));
        Alphabet.selectByVisibleText("Uppercase or Lowercase");
        driver.findElement(By.id("outlined-basic")).sendKeys(range1);
        driver.findElement(By.id("outlined-basic")).sendKeys(range2);
        driver.findElement(By.xpath(p.getProperty("CharacterDone"))).click();
	}
	public static void NumericType(WebDriver driver, String range1,String range2)
	{
        Select CharacterType1= new Select (driver.findElement(By.xpath(p.getProperty("BlockType"))));
        CharacterType1.selectByVisibleText("Numeric");
        driver.findElement(By.id("outlined-basic")).sendKeys(range1);
        driver.findElement(By.id("outlined-basic")).sendKeys(range2);
        driver.findElement(By.xpath(p.getProperty("CharacterDone"))).click();
	}
	public static void MixedType(WebDriver driver,String BlockType,String NumChar,String CharType) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("Block"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("BlockType"))).sendKeys(BlockType);
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("NumChar"))).sendKeys(NumChar);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='chars_array__item_1']//div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("CharType"))).sendKeys(CharType);
        Thread.sleep(3000);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement CharDone = driver.findElement(By.xpath(p.getProperty("CharDone")));
        je.executeScript("arguments[0].click();", CharDone);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='chars_array__item_2']//div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("CharType"))).sendKeys(CharType);
        Thread.sleep(3000);
        WebElement CharDone1 = driver.findElement(By.xpath(p.getProperty("CharDone")));
        je.executeScript("arguments[0].click();", CharDone1);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='chars_array__item_5']//div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("CharType"))).sendKeys(CharType);
        Thread.sleep(3000);
        WebElement CharDone2 = driver.findElement(By.xpath(p.getProperty("CharDone")));
        je.executeScript("arguments[0].click();", CharDone2);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='chars_array__item_8']//div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("CharType"))).sendKeys(CharType);
        Thread.sleep(3000);
        WebElement CharDone3 = driver.findElement(By.xpath(p.getProperty("CharDone")));
        je.executeScript("arguments[0].click();", CharDone3);
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("CharacterDone"))).click();
        Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("TestNext"))).click();
	    Thread.sleep(3000);
	}
	public static void TestValue(WebDriver driver,String TestValue) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("TestValue"))).sendKeys(TestValue);
        driver.findElement(By.xpath(p.getProperty("Test"))).click();
        Thread.sleep(3000);        
	}
	public static void AddFieldFinish(WebDriver driver) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("Finish"))).click();
        Thread.sleep(3000);
	}
	public static void ConfirmTemp(WebDriver driver) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("ConfirmTemp"))).click();
        Thread.sleep(3000);
	}
	
	@Test(dataProvider="LoginData")
	public void TestFNEmpty(String browser) throws InterruptedException, AWTException
     {
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "";
    	String AliasName = "";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
        Regex.DoneNewField(driver);
        Assert.assertEquals("Field name cannot be empty!", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        driver.close();        
     }
	@Test(dataProvider="LoginData")
	public void TestAliasName(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Assert.assertEquals("Please enter an alias", driver.findElement(By.xpath("//div[contains(text(),'Please enter an alias')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please enter an alias')]")).getText());
        Thread.sleep(3000);
	    driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestSampleValueEmpty(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String SampleValue ="";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
        Assert.assertEquals("Please enter a sample value to continue", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
	    Thread.sleep(3000);
	    driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestSampleInput(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String SampleValue ="20AP3ZI8";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		AddFormat(driver,SampleValue);
        driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestCharacterTypeAlphabet(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String SampleValue ="20AP3ZI8";
    	String range1 = "3";
    	String range2 = "3";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.AlphabetType(driver, range1, range2);
        System.out.println("Changed the character type to Alphabet.");
        driver.close();
	}
    @Test(dataProvider="LoginData")
	public void TestCharacterTypeNumeric(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String SampleValue ="20AP3ZI8";
    	String range1 = "3";
    	String range2 = "3";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.NumericType(driver, range1, range2);
        System.out.println("Changed the character type to Numeric.");
        driver.close();
	}
    @Test(dataProvider="LoginData")
	public void TestCharacterTypeMixed(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		System.out.println("Changed the character type to Mixed.");
        driver.close();
     }
	@Test(dataProvider="LoginData")
	public void TestTestValueBlank(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
	    String TestValue = "";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		Regex.TestValue(driver,TestValue);
        Assert.assertEquals("Enter a value a to be tested", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        Thread.sleep(3000);
        driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestFinishError(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
	    String TestValue = "";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		Regex.TestValue(driver,TestValue);
        Regex.AddFieldFinish(driver);
        Assert.assertEquals("Cannot finish without a successful test", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        Thread.sleep(3000);
        driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestInvalidTestValue(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
	    String TestValue = "20AP3Z8";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		Regex.TestValue(driver,TestValue);
        Regex.AddFieldFinish(driver);
        Assert.assertEquals("Test failed!", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
        Thread.sleep(3000);
	    driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestValidTestValue(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
	    String TestValue = "20AP3ZI8";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		Regex.TestValue(driver,TestValue);
        Regex.AddFieldFinish(driver);
        Assert.assertEquals("Test Passed!", driver.findElement(By.xpath("//div[contains(text(),'Test Passed!')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Test Passed!')]")).getText()); 
        Thread.sleep(3000);
        driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestRegex(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
	    String TestValue = "20AP3ZI8";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.AddNew(driver,FieldName,AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		Regex.TestValue(driver,TestValue);
        Regex.AddFieldFinish(driver);
        Regex.DoneNewField(driver);
        Regex.ConfirmTemp(driver);
        System.out.println("Successfully added new value");
        Thread.sleep(3000);
        driver.close();
	}
	@Test(dataProvider="LoginData")
	public void TestEdit(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	StringSelection file_location = new StringSelection("C:\\Users\\tfrsln55\\Desktop\\Test1.pdf");
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String TempName ="Test";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
	    String TestValue = "20AP3ZI8";
    	WebDriver driver = createBrowser(browser);
    	LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Template.UploadTemplateFile(driver,file_location,DocumentCategory,Language,filetype,individualORcorporate);
		Template.CreateTemplate(driver, TempName);
		Regex.Edit(driver,FieldName, AliasName);
		Regex.AddFormat(driver,SampleValue);
		Regex.MixedType(driver,BlockType,NumChar,CharType);
		Regex.TestValue(driver,TestValue);
        Regex.AddFieldFinish(driver);
        Regex.DoneNewField(driver);
        Regex.ConfirmTemp(driver);
        System.out.println("Successfully Edited Value");
        driver.close();
	}
}
