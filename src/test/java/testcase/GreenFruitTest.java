package testcase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Greenkart;
import resource.Base;



public class GreenFruitTest extends Base {

	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void awal() throws Exception {
		driver = initializeDriver();
		driver.get(prop.getProperty("url3"));
		log.info("this is log4j youtube");
		
		log.info("this is log4j test greenkart");
	}

	@Test
	public void barcelona() throws IOException {

		Greenkart g = new Greenkart(driver);
		g.Click().click();
		g.getsearch().sendKeys("Orange");
		g.submit().click();
		log.info("this is log4j test greenkart");

	}

	@Test
	public void quit() {
		driver.close();
	}

}