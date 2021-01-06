package DataSource_File;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import Account.LoginPage;
import Process_File.Process;
import Template_File.Template;
import config.PropertiesFile;
public class DataSource extends PropertiesFile
{
    public static void DSource(WebDriver driver) throws InterruptedException
    {
        driver.findElement(By.xpath(p.getProperty("DataSource"))).click();
        Thread.sleep(3000); 
    }
    public static void SelectSource(WebDriver driver) throws InterruptedException
    {
        driver.findElement(By.xpath(p.getProperty("SelectSource"))).click();
        Thread.sleep(3000);
        Select DropSelect=new Select(driver.findElement(By.xpath(p.getProperty("DropSelect"))));
        DropSelect.selectByVisibleText("Zip");
        Thread.sleep(3000);
        driver.findElement(By.xpath(p.getProperty("FileSave"))).click();
        Thread.sleep(3000);
    }
    public static void SaveDataSource(WebDriver driver) throws InterruptedException
    {
        driver.findElement(By.xpath(p.getProperty("SaveData"))).click();
        Thread.sleep(3000);
    }
    
    @Test(dataProvider="DataProvider")
    public void TestValidDataSource(String browser) throws InterruptedException
    {
          String username = "madhura@envirya.in";
          String password = "Test@123";
          String processname = UUID.randomUUID().toString(); 
          WebDriver driver = createBrowser(browser);        
          LoginPage.login(driver, username, password, false);
          Process.CreateProcess(driver,processname);
          Template.TemplateOption(driver);
          Template.ChooseTemplate(driver);
          Template.SelectTemplate(driver);
          DataSource.DSource(driver);  
          DataSource.SelectSource(driver);
          DataSource.SaveDataSource(driver);
    }
    @Test(dataProvider="DataProvider")
    public void TestValidDataSourceBlank(String browser) throws InterruptedException
    {
          String username = "madhura@envirya.in";
          String password = "Test@123";
          String processname = UUID.randomUUID().toString(); 
          WebDriver driver = createBrowser(browser);        
          LoginPage.login(driver, username, password, false);
          Process.CreateProcess(driver,processname);
          Template.TemplateOption(driver);
          Template.ChooseTemplate(driver);
          Template.SelectTemplate(driver);
          DataSource.DSource(driver);  
          DataSource.SaveDataSource(driver);
          Assert.assertEquals("Select one or multiple data sources", driver.findElement(By.xpath("//div[contains(text(),'Select one or multiple data sources')]")).getText());
          System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Select one or multiple data sources')]")).getText());
          Thread.sleep(3000);
    }
    
}
