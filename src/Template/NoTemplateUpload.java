package Template;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class NoTemplateUpload extends PropertiesFile
{
	@Test(dataProvider="SearchProvider16")
	public void verifyNoTemplateUpload(String Type , String ProcessName) throws InterruptedException
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
    driver.findElement(By.xpath(p.getProperty("createTemplate"))).click();
    Thread.sleep(5000);
    
    Assert.assertEquals("Please create a template by uploading a template file", driver.findElement(By.xpath("//div[contains(text(),'Please create a template by uploading a template f')]")).getText());
    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Please create a template by uploading a template f')]")).getText());
	}

	@DataProvider(name="SearchProvider16")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Valid","Start1"},
		
			};
	}
}
