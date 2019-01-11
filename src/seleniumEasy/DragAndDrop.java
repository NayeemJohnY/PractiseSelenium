package seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(5000);
		WebElement source=driver.findElement(By.cssSelector("#draggable"));
		WebElement target=driver.findElement(By.cssSelector("#droppable"));
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	
		

	}

}
