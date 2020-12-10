package Account;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import config.PropertiesFile;


public class RegisterPage extends PropertiesFile
{
	public void Register(WebDriver driver ,String uname , String pword1 , String pword2) throws InterruptedException
	{
        driver.findElement(By.xpath(p.getProperty("register"))).click();		
        driver.findElement(By.xpath(p.getProperty("Username"))).sendKeys(uname);;
		driver.findElement(By.xpath(p.getProperty("createpassword"))).sendKeys(pword1);;		
		driver.findElement(By.xpath(p.getProperty("confirmpassword"))).sendKeys(pword2);;
		driver.findElement(By.xpath(p.getProperty("register"))).click();
		 Thread.sleep(5000);
	}
	
	@Test(dataProvider="LoginData")
	public void RegisterTest(String browser) throws InterruptedException
	{	
		String uname = "roohi@envirya.in";
    	String pword1 = "Yaali@1421";
    	String pword2 = "Yaali@1421";
		System.out.println("Username is: "+uname);
		System.out.println("Password is: "+pword1);
		System.out.println("Confirm Password is: "+pword2);
		WebDriver driver = createBrowser(browser);
		Register(driver,uname,pword1,pword2);
		System.out.println("Registration Successful");
		driver.quit();
	}
	
	@Test(dataProvider="LoginData")
	public void TestInvalidEmail(String browser) throws InterruptedException
	{
		String uname = "manav@envirya.in@com";
    	String pword1 = "12345@qwert";
    	String pword2 = "12345@qwert";
		System.out.println("Username is: "+uname);
		System.out.println("Password is: "+pword1);
		System.out.println("Confirm Password is: "+pword2);
		WebDriver driver = createBrowser(browser);
		Register(driver,uname,pword1,pword2);
		Assert.assertEquals("Invalid email address",driver.findElement(By.xpath("//div[contains(text(),'Invalid email address')]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Invalid email address')]")).getText());			
		driver.quit();
	}
	
	@Test(dataProvider="LoginData")
	public void TestNoEmail(String browser) throws InterruptedException
	{	
		String uname = "";
    	String pword1 = "12345@qwert";
    	String pword2 = "12345@qwert";
		System.out.println("Username is: "+uname);
		System.out.println("Password is: "+pword1);
		System.out.println("Confirm Password is: "+pword2);
		WebDriver driver = createBrowser(browser);
		Register(driver,uname,pword1,pword2);
		String Expected_tooltip ="Please fill out this field.";
		Assert.assertEquals("Please fill out this field.", Expected_tooltip);
		System.out.println("Test Passed-Please fill out this field");		
		driver.quit();
	}

    @Test(dataProvider="LoginData")
	public void TestNoPassword(String browser) throws InterruptedException
	{	
    	String uname = "roohi@envirya.in";
    	String pword1 = "";
    	String pword2 = "12345@qwert";
		System.out.println("Username is: "+uname);
		System.out.println("Password is: "+pword1);
		System.out.println("Confirm Password is: "+pword2);
		WebDriver driver = createBrowser(browser);
		Register(driver,uname,pword1,pword2);
		String Expected_tooltip ="Please fill out this field.";
		Assert.assertEquals("Please fill out this field.", Expected_tooltip);
		System.out.println("Test Passed-Please fill out this field");	
		driver.quit();
	}
	
    @Test(dataProvider="LoginData")
	public void TestPasswordMatch(String browser) throws InterruptedException
	{
    	String uname = "roohi@envirya.in";
    	String pword1 = "12345";
    	String pword2 = "12345@qwert";
		System.out.println("Username is: "+uname);
		System.out.println("Password is: "+pword1);
		System.out.println("Confirm Password is: "+pword2);
		WebDriver driver = createBrowser(browser);
		Register(driver,uname,pword1,pword2);
		Assert.assertEquals("Wrong confirmation password!!", driver.findElement(By.cssSelector(".Toastify__toast-body")).getText());
		System.out.println(driver.findElement(By.cssSelector(".Toastify__toast-body")).getText());	
		driver.quit();
	}

	
    @Test(dataProvider="LoginData")
	public void TestPasswordPolicy(String browser) throws InterruptedException
	{
    	String uname = "roohi@envirya.in";
    	String pword1 = "12345";
    	String pword2 = "12345";
		System.out.println("Username is: "+uname);
		System.out.println("Password is: "+pword1);
		System.out.println("Confirm Password is: "+pword2);
		WebDriver driver = createBrowser(browser);
		Register(driver,uname,pword1,pword2);
		Assert.assertEquals("Password length must be greator than 8!!", driver.findElement(By.cssSelector(".Toastify__toast-body")).getText());
		System.out.println(driver.findElement(By.cssSelector(".Toastify__toast-body")).getText());
		driver.quit();
	}
}
	
		
		
 
		

	

