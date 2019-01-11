package seleniumEasy;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Log4jdemo {
	
	public static void main(String[] args) {
		Logger logger=Logger.getLogger("Log4jdemo");
		PropertyConfigurator.configure("F:\\Selenium\\webdriver\\PractiseSelenium\\src\\Log4j.properties");
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
	WebDriver	driver = new ChromeDriver();
		driver.manage().window().maximize();
        logger.info("Browser Opened");
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        logger.info("Implicit wait given");
      
 
        // Load application
        driver.get("https://www.google.co.in/");
        logger.info("Url opened");
      
 
        // type Selenium
        driver.findElement(By.name("q")).sendKeys("Selenium");
        logger.info("keyword type");       
        
       
    }
}
