package seleniumEasy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Utility;

public class CalenderPick {
	WebDriver driver;
	@BeforeClass
	void browser() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	/*@Test
	void calenderCurrentMonth() throws InterruptedException
	{
		driver.get("http://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement datefield=driver.findElement(By.xpath("//input[@id='datepicker']"));
		datefield.click();
		Thread.sleep(2000);
		List<WebElement> date=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table//td"));
		for(WebElement ele:date)
		{
		
			if(ele.getText().contentEquals("20"))
					{
				ele.click();
				break;
					}
			
			
		
		}
	}*/
	@Test
	void calenderPrevNext() throws Exception
	{
		driver.get("http://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement datefield=driver.findElement(By.xpath("//input[@id='datepicker']"));
		datefield.click();
		Thread.sleep(2000);
		WebElement prev=driver.findElement(By.xpath("//*[@title='Prev']"));
		WebElement next=driver.findElement(By.xpath("//*[@title='Next']"));
		WebElement year= driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
		System.out.println("Def year"+year.getText());
		WebElement month= driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
		System.out.println("Def month"+month.getText());
		while(year.getText()!="2016")
		{
			 year= driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
			 driver.findElement(By.xpath("//*[@title='Prev']")).click();
		}
		driver.findElement(By.xpath("//*[@class='ui-state-default'][text()='30']")).click();
	
	}
	@AfterMethod
	void failedTestCapture(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			try {
				Utility.FullScreenshot(driver, result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
