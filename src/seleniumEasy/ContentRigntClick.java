package seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContentRigntClick {
	static WebDriver driver;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		doubleClick();
		/*
		 * driver.get("http://medialize.github.io/jQuery-contextMenu/demo.html")
		 * ; System.out.println(driver.getTitle());
		 * 
		 * WebElement
		 * elemenRight=driver.findElement(By.cssSelector(".context-menu-one"));
		 * Actions action = new Actions(driver);
		 * action.contextClick(elemenRight).build().perform();
		 * Thread.sleep(5000);
		 * System.out.println(driver.findElement(By.cssSelector(
		 * ".context-menu-icon-cut")).getText());
		 */

	}

	public static void doubleClick() {
		driver.get("http://api.jquery.com/dblclick/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//*[text()='Double click the block']//preceding::div"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(element.getCssValue("color"));
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		System.out.println(element.getCssValue("color"));

	}
}
