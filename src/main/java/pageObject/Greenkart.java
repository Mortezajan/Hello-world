package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Greenkart {

public WebDriver driver;

	
	
	
	By search = By.cssSelector("input[type='search']");
	By click = By.xpath("//*[@id=\'root\']/div/div[1]/div/div[18]/div[3]/button");
	By check = By.cssSelector("[alt='Cart']");

	
	
	public Greenkart ( WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	
	

	
	public WebElement getsearch()
	{
		return driver.findElement(search);
	}

	
	
	public WebElement Click()
	{
		return driver.findElement(click);
	}

	
	
	

	public WebElement submit()
	{
		return driver.findElement(check);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
