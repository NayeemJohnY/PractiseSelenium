package seleniumEasy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MulipleSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver",
				"F:\\Selenium\\Driveres & JARS\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///F:/Selenium/Dropdown.html");
		Select multple = new Select(driver.findElement(By.name("Mobdevices")));

		List<WebElement> options = multple.getOptions();
		multple.deselectAll();
		for (WebElement ele : options) {
			if (ele.getText().equalsIgnoreCase("NOKIA")) {
				ele.click();
			}
			if (ele.getText().equalsIgnoreCase("htc")) {
				ele.click();
			}
			
		

		}
		for (WebElement ele : multple.getAllSelectedOptions()) {
			System.out.println(ele.getText());
		}

	}
}
