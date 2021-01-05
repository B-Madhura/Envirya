package Process;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class DupProcessName extends PropertiesFile
{
	@Test(dataProvider="SearchProvider14")
	public void verifyDupProcessName(String Type , String ProcessName) throws InterruptedException
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
        
        Assert.assertEquals("process name exists", driver.findElement(By.xpath("//h6[contains(text(),'process name exists')]")).getText());
        System.out.println(driver.findElement(By.xpath("//h6[contains(text(),'process name exists')]")).getText());
	}
	
	@DataProvider(name="SearchProvider14")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Dupliacte","Start8"},
		
			};

 }
}
