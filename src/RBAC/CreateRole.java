package RBAC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Account.LoginPage;
import config.PropertiesFile;


public class CreateRole extends PropertiesFile {

	public static void role(WebDriver driver,String rolename,String description) throws InterruptedException
	   {    
		driver.findElement(By.xpath("//p[contains(text(),'SETTINGS')]")).click();
		driver.findElement(By.xpath("//button[@id='create_role']")).click();
		driver.findElement(By.xpath(p.getProperty("RoleName"))).sendKeys(rolename);
	    driver.findElement(By.xpath(p.getProperty("RoleDesc"))).sendKeys(description); 
	   }
	
	public static void resource(WebDriver driver) throws InterruptedException
	  {
	    WebElement testDropDown = driver.findElement(By.xpath("//select[@name='resource']"));
	    testDropDown.click();
	    Select selectresource = new Select(testDropDown);  
	    selectresource.selectByIndex(2);
		driver.findElement(By.xpath("//button[contains(text(),'Assign Actions')]")).click();
        List<WebElement> ListOfCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		 for(int i=0; i< ListOfCheckBoxes.size() ; i++) {
		    ListOfCheckBoxes.get(i).click(); 
          }
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	   }
	
	public static void editrole(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//p[contains(text(),'SETTINGS')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Roles')]")).click();
	    Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='aade5fa0-f724-4c4d-9e34-3378643d3f52']")).click();
		Thread.sleep(5000);
	}
	
	
	/*@Test(dataProvider="DataProvider")
	public void TestValidRole(String browser) throws InterruptedException 
	{	 
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename= "new role";
		String description = "new description";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    role(driver,rolename,description);
	    resource(driver);
	    driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoRoleName(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename= "";
		String description = "new description";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    role(driver,rolename,description);
	    resource(driver);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed- Please fill out this field : Role Name");
    	driver.quit();
    }
	
	@Test(dataProvider="DataProvider")
	public void TestNoRoleDescription(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename= "new role";
		String description = "";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    role(driver,rolename,description);
	    resource(driver);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed- Please fill out this field : Role description");
    	driver.quit();
	 }
	
	@Test(dataProvider="DataProvider")
	public void TestNoRoleResource(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename= "new role";
		String description = "new description";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    role(driver,rolename,description);
	   
	    // Error should be :child "resources" fails because ["resources" does not contain 1 required value(s)]
	   
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestNoRoleAction(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename= "new role";
		String description = "new description";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    role(driver,rolename,description);
	   
	    WebElement testDropDown = driver.findElement(By.xpath("//select[@name='resource']"));
	    testDropDown.click();
	    Select selectresource = new Select(testDropDown);  
	    selectresource.selectByIndex(2);
	    driver.findElement(By.xpath("//button[contains(text(),'Assign Actions')]")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void TestInvalidRole(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename= "qc";
		String description = "new description";
			
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    role(driver,rolename,description);
	    resource(driver);
	    driver.quit();
	}*/
	
    /* ===================================================================================================== */
	
	@Test(dataProvider="DataProvider")
	public void EditRoleValid(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename = "edited name";
		String description = "edited description";
		WebDriver driver = createBrowser(browser);
		LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    editrole(driver);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(p.getProperty("EditRoleName"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    driver.findElement(By.xpath(p.getProperty("EditRoleName"))).sendKeys(rolename);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(p.getProperty("EditRoleDesc"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    driver.findElement(By.xpath(p.getProperty("EditRoleDesc"))).sendKeys(description);
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    Thread.sleep(5000);
	    //driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditRoleName(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
		WebDriver driver = createBrowser(browser);
	    LoginPage.login(driver,username,password, rememberMe);
	    editrole(driver);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(p.getProperty("EditRoleName"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    Thread.sleep(5000);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed- Please fill out this field : Role Name");
	    Thread.sleep(3000);
	    //driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditRoleDescription(String browser) throws InterruptedException 
	{	
		
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    WebDriver driver = createBrowser(browser);
	    LoginPage.login(driver,username,password, rememberMe);
	    Thread.sleep(5000);
	    editrole(driver);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(p.getProperty("EditRoleDesc"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    Thread.sleep(5000);
	    String Expected_tooltip ="Please fill out this field.";
    	Assert.assertEquals("Please fill out this field.", Expected_tooltip);
    	System.out.println("Test Passed- Please fill out this field : Role description");
	    Thread.sleep(3000);
	    //driver.quit();
	}
	
	@Test(dataProvider="DataProvider")
	public void EditRoleExists(String browser) throws InterruptedException 
	{	
		String username ="madhura@envirya.in";
	    String password ="Test@123";
	    boolean  rememberMe= false;
	    String rolename = "qc";
	    WebDriver driver = createBrowser(browser);
	    LoginPage.login(driver,username,password, rememberMe);
	    editrole(driver);
	    driver.findElement(By.xpath(p.getProperty("EditRoleName"))).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    driver.findElement(By.xpath(p.getProperty("EditRoleName"))).sendKeys(rolename);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    Thread.sleep(3000);
	    //driver.quit();
	}
}
