package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Youtube {

public WebDriver driver;

	
	By search = By.cssSelector("input[id='search']");
	By click = By.xpath("//button[@id='search-icon-legacy']");
	By check = By.cssSelector("#logo-icon-container");
	
	public Youtube ( WebDriver driver)
	{
		this.driver= driver;
	}
	
	public WebElement Search()
	{
		return driver.findElement(search);
	}
	public WebElement submit()
	{
		return driver.findElement(click);
	}
		
	
	
	public WebElement able()
	{
		return driver.findElement(check);
	}
	
	
	
	
	
	
	
}
