package seleniumEasy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionExample {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			BrowserSetup();
			//noElement();
			//hiddenElement();
			//AlertElement();
			//windowExecption();
			StaleElement();
			//SessionException();
			//DriverException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Suceess");
		}
	}

	public static void BrowserSetup() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void noElement() {

		try {
			driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
			driver.findElement(By.id("invalidid")).sendKeys("45689");// invalid
																		// id
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void hiddenElement() {

		try {
			driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
			driver.findElement(By.id("male")).click();// hidden element
		} catch (ElementNotVisibleException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void AlertElement() {

		try {

			driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void windowExecption() {

		try {
			driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
			driver.switchTo().window("facebook");
		} catch (NoSuchWindowException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void StaleElement() throws Exception {
		try {
			driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
			driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.name("q"));
			String parent = driver.getWindowHandle();
			driver.switchTo().window(parent);
			ele.sendKeys("Nayeem");
			
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void SessionException() throws Exception {
		try {
			driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
			driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
			Thread.sleep(3000);
			driver.close();
			driver.findElement(By.name("q")).sendKeys("john");

		} catch (SessionNotCreatedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void DriverException() throws Exception {
		try {
			driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
			driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
			Thread.sleep(3000);
			driver.quit();
			driver.findElement(By.name("q")).sendKeys("john");
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

	}
}
