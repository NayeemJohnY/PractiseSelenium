package seleniumEasy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthent {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.engprod-charter.net/");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("F:\\Selenium\\AutoIT\\HandleAuth.exe");
	}

}
