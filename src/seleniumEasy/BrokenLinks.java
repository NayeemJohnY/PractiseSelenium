package seleniumEasy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"F:\\Selenium\\Driveres & JARS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("total links are "+links.size());
		for (int i=0; i<links.size(); i++)
		{
			WebElement ele=links.get(i);
			String url=ele.getAttribute("href");
			verifyLinkactive(url);
		}
	
	
	}
	public static void verifyLinkactive(String linkUrl)
	{
		try
		{
			URL  url = new URL(linkUrl);
			HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode()==200)
			{
				System.out.println(linkUrl+" - "+httpURLConnection.getResponseMessage());
			}
			if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			{
				System.out.println(linkUrl+" - "+httpURLConnection.getResponseMessage());
			}
		}
		catch (Exception e)
		{
			
		}
	}
}
