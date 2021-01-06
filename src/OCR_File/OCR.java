package OCR_File;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Account.LoginPage;
import DataSource_File.DataSource;
import Process_File.Process;
import Template_File.Template;
import config.PropertiesFile;
  public class OCR extends PropertiesFile
  {
   public static void EnviryaOCR(WebDriver driver) throws InterruptedException
    {
      driver.findElement(By.xpath(p.getProperty("OCR"))).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath(p.getProperty("EnviryaOCR"))).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath(p.getProperty("OCRSubmit"))).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath(p.getProperty("SaveOCR"))).click();
      Thread.sleep(3000);
    }
   
   @Test(dataProvider="DataProvider")
   public void TestEnviryaOCR(String browser) throws InterruptedException
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
      OCR.EnviryaOCR(driver);
   }
   
   
}