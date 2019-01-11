package seleniumEasy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitInSelenium {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		browserSetup();
		// implictWait();
		//explicitWait();
		fluentWait();
	}

	public static void browserSetup() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void implictWait() {
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button")).click();
		WebElement ele = driver.findElement(By.xpath("//p[text()='WebDriver']"));

		boolean status = ele.isDisplayed();
		{
			if (status)
				System.out.println("Element displayed");
			else
				System.out.println("Falied to display");
		}
	}

	public static void explicitWait() {
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		boolean status = ele.isDisplayed();
		
			if (status)
				System.out.println("Element displayed");
			else
				System.out.println("Falied to display");
		
	}

	public static void fluentWait() {

		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

		.withTimeout(30, TimeUnit.SECONDS)

		.pollingEvery(250, TimeUnit.MILLISECONDS)

		.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				WebElement ele = driver.findElement(By.xpath("//*[@id='demo']"));
				String value = ele.getAttribute("innerHTML");
				if (value.equalsIgnoreCase("webdriver")) {
					System.out.println("Element " +value+ " is displayed");
					return ele;
				}

				else {
					System.out.println("vlaue in screen is "+value);
					return null;
				}
			}

		});
		System.out.println(element.isDisplayed());
	}
}
