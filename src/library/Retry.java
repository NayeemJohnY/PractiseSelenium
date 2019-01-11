package library;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int mincount=1;
	int maxcount=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
		if(mincount<=maxcount)
		{
			System.out.println("Following test is failing===="+result.getName());
			System.out.println("Retrying the test Count is=== "+ (mincount));
			mincount++;
	return true;
		}
		
		return false;
	}

}

/*@Test(priority=3)
void WebTest()
{
	System.setProperty("webdriver.gecko.driver",
			"F:\\Selenium\\Driveres & JARS\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("file:///F:/Selenium/ConfirmAlert.html");
	driver.findElement(By.xpath("//button")).click();
}*/