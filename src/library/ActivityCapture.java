package library;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class ActivityCapture implements WebDriverEventListener{
	Logger logger=Logger.getLogger("Listners");

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("afterAlertAccept"+ arg0.toString());
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("afterAlertDismiss"+ arg0.toString());
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		logger.info("afterChangeValueOf"+ arg0.toString()+ " "+arg1.toString()+ " " +arg2.toString());
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("afterClickOn"+ arg0.toString());
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("afterNavigateBack"+ arg0.toString());
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("afterNavigateForward"+ arg0.toString());
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("afterNavigateRefresh"+ arg0.toString());
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("afterNavigateTo"+ arg0.toString());
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("afterScript"+ arg0.toString());
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("beforeAlertAccept"+ arg0.toString());
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("beforeAlertDismiss"+ arg0.toString());
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		logger.info("beforeChangeValueOf"+ arg0.toString());
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("beforeClickOn"+ arg0.toString());
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		logger.info("beforeFindBy"+ arg0.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("beforeNavigateBack"+ arg0.toString());
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("beforeNavigateForward"+ arg0.toString());
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		logger.info("beforeNavigateRefresh"+ arg0.toString());
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("beforeNavigateTo"+ arg0.toString());
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("beforeScript"+ arg0.toString());
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		logger.info("onException"+ arg0.toString());
	}
	
	

}
