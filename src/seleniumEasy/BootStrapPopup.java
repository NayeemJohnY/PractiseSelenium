package seleniumEasy;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BootStrapPopup {
	WebDriver driver;

	@BeforeClass
	void browser() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	void bootStrap() {
		driver.get("http://seleniumpractise.blogspot.in/2016/11/handle-bootstrap-model-dialog-in.html");
		driver.findElement(By.xpath("//button[text()='Click here to Login']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Nayeem");
		driver.findElement(By.xpath("//button[text()='Close']")).click();

	}

	@AfterMethod
	void delay() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	void bootStrapWithoutFrame() {
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
try
{
	driver.findElement(By.xpath("//input[@id='authMobile']")).sendKeys("Nayeem");
}
catch (NoSuchElementException e)
{
	System.out.println(e.getMessage().trim());
}

	}

	@Test(priority=3)
	void RedBus() throws Exception {
		driver.get("https://www.redbus.in/");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// implicit not works here
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoAlertPresentException.class);
		WebElement Signlogo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				return (driver.findElement(By.xpath("//*[@id='i-icon-profile']")));
			}
		});
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert= driver.switchTo().alert();
		alert.dismiss();*/
		WebElement Signlogo = driver.findElement(By.xpath("//*[@id='i-icon-profile']"));
		Signlogo.click();
		WebElement ele = driver.findElement(By.xpath("//*[@id='signInLink']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		action.click().build().perform();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		driver.findElement(By.xpath("//button[text()='Sign in with Facebook']")).click();
		driver.findElement(By.xpath("//*[text()='Sign in with Google']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		while (i.hasNext()) {
			String child = i.next();

			if (driver.switchTo().window(child).getTitle().contains("Facebook")) {
				driver.findElement(By.id("email")).sendKeys("Nayeem");
				
			}
			if(driver.switchTo().window(child).getTitle().contains("Google"))
				driver.findElement(By.id("identifierId")).sendKeys("njnayeem");
			
		}
	}
}
