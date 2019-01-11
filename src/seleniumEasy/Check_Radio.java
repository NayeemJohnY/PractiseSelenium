package seleniumEasy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Check_Radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver",
				"F:\\Selenium\\Driveres & JARS\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/");
		driver.findElement(By.partialLinkText("radio button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List <WebElement> radio= driver.findElements(By.cssSelector("input[name='lang'][type='radio']"));
		for(WebElement radio_button:radio )	
		{ String lang_radio= radio_button.getAttribute("id");
			System.out.println(lang_radio);
			if(lang_radio.equalsIgnoreCase("RUBY"))
			{
			radio_button.click();
			}
		}
		List <WebElement> check= driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement check_box:check )	
		{ String lang_check= check_box.getAttribute("id");
			System.out.println(lang_check);
			if(lang_check.equalsIgnoreCase("code"))
			{
				check_box.click();
			}
		}
		
	}
	

}
