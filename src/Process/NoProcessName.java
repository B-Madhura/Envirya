package Process;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class NoProcessName extends PropertiesFile
{

	@Test(dataProvider="SearchProvider13")
	public void verifyNoProcessName(String Type , String ProcessName) throws InterruptedException
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
        
        
        Assert.assertEquals("Enter process name first", driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]")).getText());
	}
	
	@DataProvider(name="SearchProvider13")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Blank",""},
		
			};
 }
}
