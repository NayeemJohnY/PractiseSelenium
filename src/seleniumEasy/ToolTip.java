package seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolTip {

	
	static WebDriver driver;
	
	@BeforeTest
		public static void browserSetup() {
			System.setProperty("webdriver.chrome.driver",
					"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
	}
	
	
	/*
	void Tooltip()
	{
		driver.get("http://demo.guru99.com/selenium/webform/tooltip.html");
		WebElement ele=driver.findElement(By.xpath("//*[@id='download_now']"));
		Actions action=new Actions(driver);
		action.clickAndHold().moveToElement(ele).build().perform();
		WebElement tooltip=driver.findElement(By.xpath(".//*[@class='tooltip']/a"));
		String  textofToolTip=	tooltip.getText();
		String expToolTip= "What's new in 3.2";
		System.out.println(expToolTip);
		Assert.assertEquals(textofToolTip, expToolTip);
		
	}
	//*[@id="GmailAddress"]
	//*[@id="tos-background-overlay-div"]
	@Test
	void Tooltip1()
	{
		driver.get("http://jqueryui.com/tooltip/");
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement ele=driver.findElement(By.xpath("//*[@id='age']"));
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
		WebElement tooltip=driver.findElement(By.xpath("//*[@class='ui-tooltip-content']"));
		String  textofToolTip=	tooltip.getText();
		String expToolTip= "We ask for your age only for statistical purposes.";
		System.out.println(textofToolTip);
		Assert.assertEquals(textofToolTip, expToolTip);
		
	}*/
	@Test
	void Tooltip2()
	{
		driver.get("https://accounts.google.com/SignUp");
	
		driver.findElement(By.xpath("//*[@id='GmailAddress']")).click();
		Actions action=new Actions(driver);
		String expToolTip="You can use letters, numbers, and periods.";
		WebElement tooltip=driver.findElement(By.xpath("//*[@class='jfk-bubble-content-id']"));
		//WebElement tooltip=driver.findElement(By.xpath("//*[@class='infomsg']"));
		action.moveToElement(tooltip).build().perform();
		String  textofToolTip=	tooltip.getText();
		System.out.println(textofToolTip);
		Assert.assertEquals(textofToolTip, expToolTip);
		
	}
}

