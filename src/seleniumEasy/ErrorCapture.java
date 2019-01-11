package seleniumEasy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ErrorCapture {
	WebDriver driver;
	
	@BeforeTest
	public void browser()
	
	{
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void ErrorTest()
	{
		driver.get("https://www.naukri.com");
		driver.findElement(By.cssSelector("#login_Layer")).click();
		driver.findElement(By.xpath("//button[@value='Login']")).click();
		String actualMsg=driver.findElement(By.cssSelector("#eLogin_err")).getText();
		String expected="plz enter mail ID";
		Assert.assertEquals(actualMsg, expected);
	
		
		
	}
	@Test
	public void ErrorLocal()
	{
		
		driver.get("file:///F:/Selenium/PromptAlert.html");
		driver.findElement(By.xpath("//button")).click();
		Alert alert=driver.switchTo().alert();
		String word="Nayeem";
		
		alert.sendKeys(word);
		alert.accept();
	 String text=driver.findElement(By.cssSelector("#promptdemo")).getText();
		Assert.assertNotEquals(text, word);
	}
	@AfterTest
	public void Ends()
	{
	
		driver.close();
		driver.quit();
	}
}
