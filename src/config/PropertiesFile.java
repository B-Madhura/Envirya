package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class PropertiesFile 
{
	protected static WebDriver driver;
	protected static Properties p;
	FileInputStream fi;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		p= new Properties();
		fi = new FileInputStream("C:\\Users\\Lenovo\\Downloads\\Envirya Project\\src\\config\\config.properties");
	    p.load(fi);
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\Envirya Project\\lib\\chromedriver.exe");
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Downloads\\Envirya Project\\lib\\geckodriver.exe");
    }

	public WebDriver  createBrowser(String browser) throws InterruptedException
	    	{
	    		WebDriver driver = null;
	    		/*if(browser=="firefox")
	    			{
	    			driver= new FirefoxDriver();
	    		    driver.get(p.getProperty("Url"));
	    		    Thread.sleep(3000);
	    		    }
	    		else */
	    			if(browser=="chrome")
	    		{
	    			driver =new ChromeDriver();
	    		     driver.get(p.getProperty("Url"));
	    		     driver.manage().window().maximize();
	    		     Thread.sleep(3000);
	    		}
	    		return driver;
	    	}
	    	
	@DataProvider(name="DataProvider")
    public static  Object[][] getDataFromDataprovider1()
    {
		//String browsers =
		return new Object[][]
			{
			{"chrome"}
		//{"firefox"},{"chrome"}
		
				};
			
    }	
    
	
//	@AfterTest
//	public void Close()
//	{
//		driver.close();
//	}
}