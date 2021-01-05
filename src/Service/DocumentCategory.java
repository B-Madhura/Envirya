package Service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import config.PropertiesFile;

public class DocumentCategory extends PropertiesFile{

	public static void service(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath("//p[contains(text(),'SERVICES')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'AI Models')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Document Category')]")).click();
		Thread.sleep(3000);
	}
	
	public static void AddTitle(WebDriver driver,String title, String category) throws InterruptedException{
		driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(title);
		driver.findElement(By.xpath("//span[contains(text(),'Save & Next')]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//input[@placeholder='Add category'])")).sendKeys(category);
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]/span[1]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]/span[1]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("a");
    	List<WebElement> options =driver.findElements(By.cssSelector("MuiAutocomplete-popper"));
    	for(WebElement option :options){
    		if(option.getText().equalsIgnoreCase("Page Segmentation")){
    	     option.click();  
	         }
    	}
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[contains(text(),'Save & Next')]")).click();
    	Thread.sleep(3000);
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoTitle(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		Thread.sleep(5000);
		service(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Save & Next')]")).click();
		Thread.sleep(3000);
		String Expected_error = driver.findElement(By.xpath("//p[contains(text(),'Please Enter the title')]")).getText();
    	Assert.assertEquals("Please Enter the title", Expected_error);
    	System.out.println("Test Passed-Please Enter the title");
    	Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestValidTitle(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String title = "Test Title1";
	    String category ="Test category1";
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		Thread.sleep(5000);
		service(driver);
		Thread.sleep(3000);
		AddTitle(driver,title,category);
    	driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    	Thread.sleep(3000);
    	driver.quit();
	}
	@Test(dataProvider="DataProvider")
	public void TestInvalidTitle(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String title = "test";
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		Thread.sleep(5000);
		service(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(title);
		driver.findElement(By.xpath("//span[contains(text(),'Save & Next')]")).click();
    	Thread.sleep(3000);
    	driver.quit();
	}
	
}
