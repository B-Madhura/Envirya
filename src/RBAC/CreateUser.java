package RBAC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Account.LoginPage;
import config.PropertiesFile;


public class CreateUser extends PropertiesFile {
	
	public static void user(WebDriver driver,String email,String password,String confirmpassword) throws InterruptedException
	   {    
		driver.findElement(By.xpath("//p[contains(text(),'SETTINGS')]")).click();
		driver.findElement(By.xpath("//button[@id='create_user']")).click();
		driver.findElement(By.xpath(p.getProperty("CreateUserEmail"))).sendKeys(email);
		driver.findElement(By.xpath(p.getProperty("CreateUserPassword"))).sendKeys(password);
		driver.findElement(By.xpath(p.getProperty("CreateUserConfirmPassword"))).sendKeys(confirmpassword);
	   }
	
	public static void edituser(WebDriver driver,String password, String confirmpassword) throws InterruptedException
	{
		driver.findElement(By.xpath("//p[contains(text(),'SETTINGS')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
	    Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("EditUser"))).click();
	    Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("ChangePassword"))).sendKeys(password);
		driver.findElement(By.xpath(p.getProperty("ChangeConfirmPassword"))).sendKeys(confirmpassword);
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	}
	
	public static void AssignRoles(WebDriver driver) throws InterruptedException
	{
	   List<WebElement> ListOfCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	   for(int i=0; i< ListOfCheckBoxes.size() ; i++) {
	   ListOfCheckBoxes.get(i).click(); 
       }
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(3000);
   }
	
	@Test(dataProvider="DataProvider")
	public void TestNoEmail(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "";
		String password1 = "Test@111";
		String confirmpassword = "Test@111";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed-Please fill out this field: Email");
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhura@envirya.in";
		String password1 = "";
		String confirmpassword = "Test@111";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed-Please fill out this field: Password");
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoConfirmPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhura@envirya.in";
		String password1 = "Test@111";
		String confirmpassword = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed-Please fill out this field: Confirm Password");
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoRole(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhura@envirya.in";
		String password1 = "Test@111";
		String confirmpassword = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestInvalidEmail(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhurab";
		String password1 = "Test@111";
		String confirmpassword = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
		String Expected_error = driver.findElement(By.xpath("//div[contains(text(),'Invalid email address')]")).getText();
    	Assert.assertEquals("Invalid email address", Expected_error);
    	System.out.println("Test Passed-Invalid email address");
    	Thread.sleep(3000);
    	driver.quit();
	}
		
	
	@Test(dataProvider="DataProvider")
	public void TestAlreadyExistsEmail(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhura@envirya.in";
		String password1 = "Test@111";
		String confirmpassword = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
		// Error should be : User already exist with the given email
		Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestInvalidPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhura@envirya.in";
		String password1 = "123456789";
		String confirmpassword = "Test@111";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
		String Expected_error = driver.findElement(By.xpath("//div[contains(text(),'Password must contain a lowercase letter, uppercas')]")).getText();
    	Assert.assertEquals("Password must contain a lowercase letter, uppercase letter , a number and a special character!!", Expected_error);
    	System.out.println("Test Passed-Invalid Password");
    	Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestInvalidConfirmPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhura@envirya.in";
		String password1 = "Test@111";
		String confirmpassword = "123456789";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
		String Expected_error = driver.findElement(By.xpath("//div[contains(text(),'Wrong confirmation password!!')]")).getText();
		Assert.assertEquals("Wrong confirmation password!!", Expected_error);
		System.out.println("Test Passed-Invalid Confirm Password");
		Thread.sleep(3000);
	    driver.quit();
	}
	
	
	
	@Test(dataProvider="DataProvider")
	public void TestValidUser(String browser) throws InterruptedException 
	{	
		//WebDriver driver = createBrowser(browser);
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String email = "madhurab@envirya.in";
		String password1 = "Test@111";
		String confirmpassword = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		user(driver,email,password1,confirmpassword);
		Thread.sleep(5000);
		AssignRoles(driver);
		Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditUserNoPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		String password1 = "";
		String confirmpassword = "Test@111";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		edituser(driver,password1,confirmpassword);
		
		String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Change Password Test Passed-Please fill out this field: Password");
		Thread.sleep(3000);
	    driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditUserNoConfirmPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		String confirmpassword = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		edituser(driver,password,confirmpassword);
		
		String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Change Password Test Passed-Please fill out this field: Confirm Password");
		Thread.sleep(3000);
	    driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditUserInvalidPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		String password1 = "123456789";
		String confirmpassword = "123456789";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		edituser(driver,password1,confirmpassword);
		
		String Expected_error = driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]")).getText();
    	Assert.assertEquals("Password must contain a lowercase letter, uppercase letter , a number and a special character!!", Expected_error);
    	System.out.println("Change Password Test Passed-Invalid Password");
    	Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditUserInvalidConfirmPassword(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		String confirmpassword = "123456789";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		edituser(driver,password,confirmpassword);
		
		String Expected_error = driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]")).getText();
    	Assert.assertEquals("Wrong confirmation password!!", Expected_error);
    	System.out.println("Change Password Test Passed-Invalid Confirm Password");
    	Thread.sleep(3000);
    	driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditUserValid(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		String confirmpassword = "Test@123";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
		edituser(driver,password,confirmpassword);
		
    	Thread.sleep(3000);
    	driver.quit();
	}
	
}