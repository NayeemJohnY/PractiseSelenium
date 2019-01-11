package seleniumEasy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadAutoIT {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///F:/Selenium/FileUpload.html");
		driver.findElement(By.cssSelector("input")).click();
		Thread.sleep(2000);
		
		//Runtime.getRuntime().exec("F:\\Selenium\\AutoIT\\FileUpload.exe");
		Runtime.getRuntime().exec("F:\\Selenium\\AutoIT\\UploadMultiple.exe"+" "+"F:\\Selenium\\Dropdown.html");
		
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("input")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("F:\\Selenium\\AutoIT\\UploadMultiple.exe"+" "+"F:\\Selenium\\ConfirmAlert.html");
		
		
		
	
		
	}

}
