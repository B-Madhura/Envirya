package Template;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class UploadTemplateBlank extends PropertiesFile

{
	@Test(dataProvider="SearchProvider18")
	public void verifyUploadTemplateBlank(String Type , String ProcessName) throws InterruptedException
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
	    driver.findElement(By.xpath(p.getProperty("uploadTemplate1"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("uploadTemplate2"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("TemplateSubmit"))).click();
        Thread.sleep(5000);
        
        Assert.assertEquals("No file selected.", driver.findElement(By.xpath("//div[contains(text(),'No file selected.')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'No file selected.')]")).getText());
	}
	
	@DataProvider(name="SearchProvider18")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"Blank","test11"},
		
			};
	}

}
