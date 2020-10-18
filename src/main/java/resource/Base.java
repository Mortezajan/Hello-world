package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
                                          

		prop.load(fis);
		//String brow = prop.getProperty("Browser");
		String brow = System.getProperty("Browser");

		System.out.println(brow);
		if (brow.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\work\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			
			if(brow.contains("headless"))
			{
				
				option.addArguments("-headless");
			}
			driver = new ChromeDriver(option);

		} else if (brow.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\work\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (brow.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\work\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;

	}
	
	
	public String getScreenshotpath(String testcaseName,WebDriver driver) throws IOException 
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile ;
		
             }	
}
	
	

