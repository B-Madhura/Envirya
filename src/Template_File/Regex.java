package Template_File;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Account.LoginPage;
import Process.CreateProcess;
import Template_File.Template;
import config.PropertiesFile;

public class Regex extends PropertiesFile 

 {	
	public void Edit(WebDriver driver,String TempName,String FieldName,String AliasName) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("TempName"))).sendKeys(TempName);
        Thread.sleep(5000);
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
	public void AddNew(WebDriver driver,String TempName,String FieldName,String AliasName) throws InterruptedException
	{       
        driver.findElement(By.xpath(p.getProperty("TempName"))).sendKeys(TempName);
        Thread.sleep(5000);
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
	public void AddFormat(WebDriver driver,String SampleValue) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("AddFormat"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("SampleValue"))).sendKeys(SampleValue);
        Thread.sleep(2000);
        driver.findElement(By.xpath(p.getProperty("Next"))).click();
        Thread.sleep(2000);
	}
	public void MixedType(WebDriver driver,String BlockType,String NumChar,String CharType) throws InterruptedException
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
	public void TestValue(WebDriver driver,String TestValue) throws InterruptedException
	{
		driver.findElement(By.xpath(p.getProperty("TestValue"))).sendKeys(TestValue);
        driver.findElement(By.xpath(p.getProperty("Test"))).click();
        Thread.sleep(3000);        
	}
	
//	@Test(dataProvider="DataProvider")
//	public void TestFNEmpty(String browser) throws InterruptedException, AWTException
//     {
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";
//    	String FieldName = "";
//    	String AliasName = "";
//		WebDriver driver = createBrowser(browser);		
//		LoginPage.login(driver, username, password, false);
//		CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//        driver.findElement(By.xpath(p.getProperty("Done"))).click();
//        Thread.sleep(5000);
//        Assert.assertEquals("Field name cannot be empty!", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        driver.close();
//        
//     }
//	@Test(dataProvider="DataProvider")
//	public void TestAliasName(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";
//    	String FieldName = "Invoice Num";
//    	String AliasName = "";
//    	WebDriver driver = createBrowser(browser);
//    	LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//        Assert.assertEquals("Please enter an alias", driver.findElement(By.xpath("//div[contains(text(),'Please enter an alias')]")).getText());
//        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please enter an alias')]")).getText());
//        Thread.sleep(3000);
//	    driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestSampleValueEmpty(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String SampleValue ="";
//		WebDriver driver = createBrowser(browser);
//		LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//        Assert.assertEquals("Please enter a sample value to continue", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//	    System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//	    Thread.sleep(3000);
//	    driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestSampleInput(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String SampleValue ="20AP3ZI8 ";
//    	WebDriver driver = createBrowser(browser);
//    	LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//        driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestCharacterTypeAlphabet(String browser) throws InterruptedException, AWTException
//	{	
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String SampleValue ="20AP3ZI8 ";
//    	String range1 = "3";
//    	String range2 = "3";
//        WebDriver driver = createBrowser(browser);
//        LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//        Select CharacterType= new Select (driver.findElement(By.xpath(p.getProperty("BlockType"))));
//        CharacterType.selectByVisibleText("Alphabet");
//        Select Alphabet= new Select (driver.findElement(By.xpath(p.getProperty("AlphabetChoice"))));
//        Alphabet.selectByVisibleText("Uppercase or Lowercase");
//        driver.findElement(By.id("outlined-basic")).sendKeys(range1);
//        driver.findElement(By.id("outlined-basic")).sendKeys(range2);
//        driver.findElement(By.xpath(p.getProperty("CharacterDone"))).click();
//        System.out.println("Changed the character type to Alphabet.");
//        driver.close();
//	}
//        @Test(dataProvider="DataProvider")
//    	public void TestCharacterTypeNumeric(String browser) throws InterruptedException, AWTException
//    	{
//    		String username = "roohi@envirya.in";
//        	String password = "Yaali@1421";
//        	String TempName= "Test";
//        	String DocumentCategory ="InvoiceMaster";
//        	String Language = "English";
//        	String filetype = "System Generated Pdf";
//        	String individualORcorporate = "Individual";		
//        	String FieldName = "Invoice Num";
//        	String AliasName = "Invoice No.";
//        	String SampleValue ="20AP3ZI8 ";
//        	String range1 = "3";
//        	String range2 = "3";
//            WebDriver driver = createBrowser(browser);
//            LoginPage.login(driver, username, password, false);
//        	CreateProcess.Processcreation(driver);
//    		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//    		AddNew(driver,TempName,FieldName,AliasName);
//    		AddFormat(driver,SampleValue);
//            Select CharacterType1= new Select (driver.findElement(By.xpath(p.getProperty("BlockType"))));
//            CharacterType1.selectByVisibleText("Numeric");
//            driver.findElement(By.id("outlined-basic")).sendKeys(range1);
//            driver.findElement(By.id("outlined-basic")).sendKeys(range2);
//            driver.findElement(By.xpath(p.getProperty("CharacterDone"))).click();
//            System.out.println("Changed the character type to Numeric.");
//            driver.close();
//    	}
//        @Test(dataProvider="DataProvider")
//    	public void TestCharacterTypeMixed(String browser) throws InterruptedException, AWTException
//    	{
//    		String username = "roohi@envirya.in";
//        	String password = "Yaali@1421";
//        	String TempName= "Test";
//        	String DocumentCategory ="InvoiceMaster";
//        	String Language = "English";
//        	String filetype = "System Generated Pdf";
//        	String individualORcorporate = "Individual";		
//        	String FieldName = "Invoice Num";
//        	String AliasName = "Invoice No.";
//        	String BlockType = "Mixed";
//        	String SampleValue ="20AP3ZI8 ";
//    	    String NumChar ="8"; 
//    	    String CharType = "Number";
//            WebDriver driver = createBrowser(browser);
//            LoginPage.login(driver, username, password, false);
//        	CreateProcess.Processcreation(driver);
//    		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//    		AddNew(driver,TempName,FieldName,AliasName);
//    		AddFormat(driver,SampleValue);
//    		MixedType(driver,BlockType,NumChar,CharType);
//    		System.out.println("Changed the character type to Mixed.");
//            driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestTestValueBlank(String browser) throws InterruptedException, AWTException
//	{ 
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String BlockType = "Mixed";
//    	String SampleValue ="20AP3ZI8 ";
//	    String NumChar ="8"; 
//	    String CharType = "Number";
//	    String TestValue = "";
//        WebDriver driver = createBrowser(browser);
//        LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//		MixedType(driver,BlockType,NumChar,CharType);
//		TestValue(driver,TestValue);
//        Assert.assertEquals("Enter a value a to be tested", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        Thread.sleep(3000);
//        driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestFinishError(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String BlockType = "Mixed";
//    	String SampleValue ="20AP3ZI8 ";
//	    String NumChar ="8"; 
//	    String CharType = "Number";
//		WebDriver driver = createBrowser(browser);
//		LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//		MixedType(driver,BlockType,NumChar,CharType);   
//        driver.findElement(By.xpath(p.getProperty("Finish"))).click();
//        Thread.sleep(3000);
//        Assert.assertEquals("Cannot finish without a successful test", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        Thread.sleep(3000);
//        driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestInvalidTestValue(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String BlockType = "Mixed";
//    	String SampleValue ="20AP3ZI8";
//	    String NumChar ="8"; 
//	    String CharType = "Number";
//    	String TestValue ="20AP3Z8";
//		WebDriver driver = createBrowser(browser);
//		LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//		MixedType(driver,BlockType,NumChar,CharType);     
//		TestValue(driver,TestValue);
//        Assert.assertEquals("Test failed!", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        Thread.sleep(3000);
//	    driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestValidTestValue(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String BlockType = "Mixed";
//    	String SampleValue ="20AP3ZI8";
//	    String NumChar ="8"; 
//	    String CharType = "Number";
//    	String TestValue ="20AP3ZI8";
//		WebDriver driver = createBrowser(browser);
//		LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//		MixedType(driver,BlockType,NumChar,CharType);     
//		TestValue(driver,TestValue);
//        Assert.assertEquals("Test Passed!", driver.findElement(By.xpath("//div[contains(text(),'Test Passed!')]")).getText());
//        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Test Passed!')]")).getText()); 
//        Thread.sleep(3000);
//        driver.close();
//	}
//	@Test(dataProvider="DataProvider")
//	public void TestRegex(String browser) throws InterruptedException, AWTException
//	{
//		String username = "roohi@envirya.in";
//    	String password = "Yaali@1421";
//    	String TempName= "Test";
//    	String DocumentCategory ="InvoiceMaster";
//    	String Language = "English";
//    	String filetype = "System Generated Pdf";
//    	String individualORcorporate = "Individual";		
//    	String FieldName = "Invoice Num";
//    	String AliasName = "Invoice No.";
//    	String BlockType = "Mixed";
//    	String SampleValue ="20AP3ZI8";
//	    String NumChar ="8"; 
//	    String CharType = "Number";
//    	String TestValue ="20AP3ZI8";
//		WebDriver driver = createBrowser(browser);
//		LoginPage.login(driver, username, password, false);
//    	CreateProcess.Processcreation(driver);
//		Template.UploadTemplateFile(driver,DocumentCategory,Language, filetype,  individualORcorporate);
//		AddNew(driver,TempName,FieldName,AliasName);
//		AddFormat(driver,SampleValue);
//		MixedType(driver,BlockType,NumChar,CharType);    
//		TestValue(driver,TestValue);
//        Assert.assertEquals("Test Passed!", driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
//        Thread.sleep(3000);
//        driver.findElement(By.xpath(p.getProperty("Finish"))).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath(p.getProperty("Done"))).click();
//        driver.findElement(By.xpath(p.getProperty("ConfirmTemp"))).click();
//        System.out.println("Successfully added new value");
//        Thread.sleep(3000);
//        driver.close();
//	}
	
	@Test(dataProvider="DataProvider")
	public void TestEdit(String browser) throws InterruptedException, AWTException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String TempName= "Test";
    	String DocumentCategory ="InvoiceMaster";
    	String Language = "English";
    	String filetype = "System Generated Pdf";
    	String individualORcorporate = "Individual";
    	String FieldName = "Invoice Num";
    	String AliasName = "Invoice No.";
    	String BlockType = "Mixed";
    	String SampleValue ="20AP3ZI8";
	    String NumChar ="8"; 
	    String CharType = "Number";
    	String TestValue ="20AP3ZI8";
    	WebDriver driver = createBrowser(browser);
		LoginPage.login(driver, username, password, false);
    	CreateProcess.Processcreation(driver);
		Template.UploadTemplateFile(driver, null, DocumentCategory,Language, filetype,  individualORcorporate);
		Edit( driver, TempName, FieldName, AliasName);
		AddFormat(driver,SampleValue);
		MixedType(driver,BlockType,NumChar,CharType);
		TestValue(driver,TestValue);
		driver.findElement(By.xpath(p.getProperty("Finish"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(p.getProperty("Done"))).click();
        driver.findElement(By.xpath(p.getProperty("ConfirmTemp"))).click();
        System.out.println("Successfully Edited Value");
        driver.close();
	}
	
	
}

