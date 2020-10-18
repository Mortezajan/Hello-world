package testcase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObject.Youtube;
import resource.Base;

public class YoutubeTest extends Base {
public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void awal() throws Exception {
		driver = initializeDriver();
		driver.get(prop.getProperty("url4"));
		
	}

	@Test
	public void barcelona() throws IOException {

		Youtube y = new Youtube(driver);
		y.Search().sendKeys("bercelona vs real madrid");
		Assert.assertTrue(y.submit().isDisplayed());
		Assert.assertEquals(y.able().isDisplayed(), true);
		log.info("this is log4j youtube");
	}

	@Test
	public void quit() {
		driver.close();
	}

}

	
	
	
	
	
	
	
	

