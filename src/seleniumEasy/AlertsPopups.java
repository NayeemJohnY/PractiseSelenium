package seleniumEasy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertsPopups {
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		/*System.setProperty("webdriver.gecko.driver",
				"F:\\Selenium\\Driveres & JARS\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		simpleAlert();
		confirmAlert();
		promptAlert();
	

	
	}
	public static  void simpleAlert() throws Exception
	{
		driver.get("file:///F:/Selenium/SimpleAlert.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button")).click();;
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();	
	}
	public static  void confirmAlert() throws Exception
	{
		driver.get("file:///F:/Selenium/ConfirmAlert.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("button")).click();;
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();	
		System.out.println(driver.findElement(By.cssSelector("#confirmdemo")).getText());
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("button")).click();;
		Thread.sleep(2000);
		driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();	
		System.out.println(driver.findElement(By.cssSelector("#confirmdemo")).getText());
	}
	public static  void promptAlert() throws Exception
	{
		driver.get("file:///F:/Selenium/PromptAlert.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("button")).click();;
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		String name="Nayeem";
		alert.sendKeys(name);
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();	
		String actName=driver.findElement(By.cssSelector("#promptdemo")).getText();
		if(actName.contains(name))
		{
			System.out.println("success"+actName);
		}
		else
			System.out.println("failed");
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("button")).click();;
		driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.dismiss();	
		System.out.println(driver.findElement(By.cssSelector("#promptdemo")).getText());
		
	}
}
