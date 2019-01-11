package seleniumEasy;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import library.Utility;

public class FileUpload {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// fileSendkeys();
		fileUploadRobot();
	}

	public static void fileSendkeys() {
		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");
		driver.findElement(By.cssSelector("#uploadfile")).sendKeys("F://Selenium//FileTest.txt");

	}

	public static void fileUploadRobot() throws Exception {
		driver.get("http://my.monsterindia.com/create_account.html");
		Thread.sleep(1000);

		String pathtofile = "F:\\Selenium\\FileTest.txt";

		/*
		 * copy the path to clipboard to paste StringSelection is a class that
		 * can be used for copy and paste operations
		 * 
		 */
		StringSelection stringSelection = new StringSelection(pathtofile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		System.out.println(stringSelection);
		// to scroll the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,350)");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");maximum height

		Thread.sleep(2000);
		// to click the browse button
		driver.findElement(By.id("wordresume")).click();
		System.out.println("Browse clicked");
		// instacne to robot class
		Robot robot = new Robot();
		Thread.sleep(5000);
		// key press for paste the path in open dialog
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		// key release
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// to press enter ok
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}