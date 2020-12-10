package CP_QualityValidation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class CP_QVApprove extends PropertiesFile

{
	@Test(dataProvider="SearchProvider35")
	public void verifyCP_QV_Approve(String Type ,String username , String password) throws InterruptedException
	{
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is - " +pageTitle);
		Assert.assertEquals("Login",pageTitle);
        Thread.sleep(2000);
        
        WebElement enviryaLogo =driver.findElement(By.xpath(p.getProperty("logo")));
        if(enviryaLogo.isDisplayed())
        {
        	System.out.println("Logo is Displayed");
        }else
        {
        	System.out.println("Logo is not displayed");
        }
		
		driver.findElement(By.xpath(p.getProperty("username"))).sendKeys(username);
		System.out.println("Parameter for Username passed as:- " +username);
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("password"))).sendKeys(password);
		System.out.println("Parameter for Password passed as:- " +password);
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("login"))).click();
		Thread.sleep(4000);
		System.out.println("Successfully Logged into QV User");
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("CP_QualityValidation"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ViewLogsQV"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(p.getProperty("ViewSummary"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("BackQV"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ValidateQV"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ApproveDoc"))).click();
		Thread.sleep(3000);
		System.out.println("Approved the Document");
		
  }
	
	@DataProvider(name="SearchProvider35")
	public Object[][] getDataFromDataprovider()
	{
	return new Object[][]
			{
		     
		{"CP_QC_Approve","roohiqv@envirya.in","Yaali@1421"},
		
			};
	}

}
