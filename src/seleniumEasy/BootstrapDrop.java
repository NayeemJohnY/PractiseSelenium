package seleniumEasy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootstrapDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver",
				"F:\\Selenium\\Driveres & JARS\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html#");
		driver.findElement(By.xpath("//*[@id='menu1']")).click();

		List<WebElement> dropdwn = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));

		for (WebElement ele : dropdwn)

		{

			System.out.println(ele.getAttribute("innerHTML"));
		}

	}

}
