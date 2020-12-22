package Process_File;

import java.awt.AWTException;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Account.LoginPage;
import config.PropertiesFile;

public class Process extends PropertiesFile
{
	public static void CreateProcess(WebDriver driver,String processname) throws InterruptedException
	{   
		//driver.findElement(By.xpath(p.getProperty("CreateProcess"))).click();
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is - " +pageTitle);
		Assert.assertEquals("Create Process",pageTitle);
        Thread.sleep(3000);  		    
	    driver.findElement(By.xpath(p.getProperty("ProcessName"))).sendKeys(processname);
        System.out.println("Enter Process Name :- " +processname);
        Thread.sleep(5000); 
	} 
	
	@Test(dataProvider="LoginData")
	public void TestValidProcessName(String browser) throws InterruptedException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = UUID.randomUUID().toString(); 
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		CreateProcess(driver,processname);
		Thread.sleep(2000);
		driver.quit();
	}	
	@Test(dataProvider="LoginData")
	public void TestBlankProcessName(String browser) throws InterruptedException, AWTException
     {
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname = "";
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		CreateProcess(driver,processname);
        driver.findElement(By.xpath(p.getProperty("createTemplate"))).click();
        Thread.sleep(5000);
        Assert.assertEquals("Enter process name first",driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]")).getText());
        driver.quit();
     }
	@Test(dataProvider="LoginData")
	public void TestDupProcessName(String browser) throws InterruptedException
	{
		String username = "roohi@envirya.in";
    	String password = "Yaali@1421";
    	String processname ="Test8"; 
    	WebDriver driver = createBrowser(browser);		
		LoginPage.login(driver, username, password, false);
		Process.CreateProcess(driver,processname);
		Thread.sleep(5000);
		Assert.assertEquals("process name exists",driver.findElement(By.xpath("//h6[contains(text(),'process name exists')]")).getText());
        System.out.println(driver.findElement(By.xpath("//h6[contains(text(),'process name exists')]")).getText());
		driver.quit();
	}
	 
	

}
