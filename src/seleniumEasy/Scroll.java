package seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scroll {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//scrollIntoView();
		scrollIntoView1();

		/*
		 * driver.get("http://www.softwaretestingmaterial.com"); // sleep for
		 * 3secs to load the page Thread.sleep(3000); scrollKey();
		 * scrollJavascript();
		 */

	}

	public static void scrollKey() throws Exception {
		Actions action = new Actions(driver);

		// SCROLL DOWN
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		// SCROLL UP
		action.sendKeys(Keys.PAGE_UP).build().perform();
		// driver.close();
	}

	public static void scrollJavascript() throws Exception {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public static void scrollIntoView() {
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		// Create instance of Javascript executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
		// now execute query which actually will scroll until that element is
		// not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		// Extract the text and verify
		System.out.println(element.getText());

	}
	public static void scrollIntoView1() {
		driver.get("http://www.softwaretestingmaterial.com");
		// Create instance of Javascript executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'LATEST')]"));
		// now execute query which actually will scroll until that element is
		// not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		// Extract the text and verify
		System.out.println(element.getText());
}}
