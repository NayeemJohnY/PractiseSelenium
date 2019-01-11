package library;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void captureScreesnhot(WebDriver driver, String screeshotName) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" + screeshotName + ".png"));
		System.out.println("Scresbhot Captured");

	}

	public static void FullScreenshot(WebDriver driver, String screeshotName) throws Exception {
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		ImageIO.write(image, "png", new File("./Screenshots/" + screeshotName +".png"));
	}
}
