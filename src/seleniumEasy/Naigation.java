package seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Naigation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","F:\\Selenium\\Driveres & JARS\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
	//driver.get("https://www.facebook.com");
	//driver.navigate().to("https://google.com");
	driver.get("https://facebook.com");
	driver.navigate().to("https://www.google.com");
	driver.findElement(By.cssSelector("input#lst-ib")).sendKeys("Nayeem");
	Thread.sleep(5000);
	driver.navigate().refresh();
	driver.navigate().back();
	driver.findElement(By.partialLinkText("Create")).click();
	
	System.out.println(driver.getTitle());
	
	
	

	}

}
