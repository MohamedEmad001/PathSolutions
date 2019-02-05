package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	//Method to catch screenshots when TC failed
	
	public static void CaptureScreenshots(WebDriver driver , String ScreenShortname) throws IOException
	{
		
		Path dest = Paths.get("./ScreenShots" , ScreenShortname +".png");
		Files.createDirectories(dest.getParent());		
		FileOutputStream out = new FileOutputStream(dest.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();
		
	}
}
