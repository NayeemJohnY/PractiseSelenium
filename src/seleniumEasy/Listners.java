package seleniumEasy;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.ActivityCapture;

public class Listners {
	
	
	static WebDriver driver;
	
@BeforeTest
	public static void browserSetup() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		 ActivityCapture handle=new ActivityCapture();
		event1.register(handle);
		event1.manage().window().maximize();
		
		
	}

	/*@AfterMethod
	void endPage() {
		EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		 ActivityCapture handle=new ActivityCapture();
		event1.register(handle);
		event1.close();
	}

	@AfterTest
	void endSession() {
		EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		 ActivityCapture handle=new ActivityCapture();
		event1.register(handle);
		event1.quit();
	}*/

	@Test(priority = 1)
	void simpleAlert() throws Exception {
		EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		ActivityCapture handle=new ActivityCapture();
		event1.register(handle);
		event1.get("file:///F:/Selenium/SimpleAlert.html");
		event1.manage().window().maximize();
		event1.findElement(By.xpath("//button")).click();
		PropertyConfigurator.configure("F:\\Selenium\\webdriver\\PractiseSelenium\\src\\Log4jListners.Properties");
		Thread.sleep(2000);
		Alert alert = event1.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 2)
	void confirmAlert() throws Exception {
	EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		 ActivityCapture handle=new ActivityCapture();
		event1.register(handle);
		event1.get("file:///F:/Selenium/ConfirmAlert.html");
		event1.manage().window().maximize();
		event1.findElement(By.cssSelector("button")).click();
		;
		Thread.sleep(2000);
		Alert alert = event1.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept();
		System.out.println(driver.findElement(By.cssSelector("#confirmdemo")).getText());

		Thread.sleep(2000);
		event1.navigate().refresh();
		event1.findElement(By.cssSelector("button")).click();
		;
		Thread.sleep(2000);
		event1.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println(event1.findElement(By.cssSelector("#confirmdemo")).getText());
	}

	@Test(priority = 3)
	void promptAlert() throws Exception {
	EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		 ActivityCapture handle=new ActivityCapture();
		event1.register(handle);
		event1.get("file:///F:/Selenium/PromptAlert.html");
		event1.manage().window().maximize();
		event1.findElement(By.cssSelector("button")).click();
		;
		Alert alert = event1.switchTo().alert();
		Thread.sleep(2000);
		String name = "Nayeem";
		alert.sendKeys(name);
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		String actName = event1.findElement(By.cssSelector("#promptdemo")).getText();
		if (actName.contains(name)) {
			System.out.println("success" + actName);
		} else
			System.out.println("failed");

		Thread.sleep(2000);
		event1.navigate().refresh();
		event1.findElement(By.cssSelector("button")).click();
		;
		driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println(event1.findElement(By.cssSelector("#promptdemo")).getText());

	}
}
