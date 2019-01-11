package seleniumEasy;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class MoseHover {
	static WebDriver driver;
	static String parent;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		windowHandle();
		Thread.sleep(8000);
		driver.findElement(By.id("block")).click();
		driver.findElement(By.xpath("//*[@id='qsbClick']")).click();
		driver.findElement(By.name("qp")).sendKeys("test");
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Automation')]"));
		// $x("//*[starts-with(text(),'Automation')]")
		// $x("//*[contains(text(),'Automation')]")
		// "//*[text()='Automation Test']"
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		action.click().build().perform();

	}

	public static void windowHandle() {
		parent = driver.getWindowHandle();
		Set<String> window = driver.getWindowHandles();
		for (String child : window) {
			if (!child.equals(parent)) {
				driver.switchTo().window(child);
				System.out.println("Title" + driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println("Title" + driver.getTitle());

	}

}
