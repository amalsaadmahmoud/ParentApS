package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.TimeZone;

public class Helper {
    public static void captureScreenShot(WebDriver driver, String screenshotname) {
        Path dest = Paths.get("./Screenshots", screenshotname + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
        
    }
    
 // select 2 values from the combobox
 	public static void SelectComboValues(WebDriver driver, By by) {
 		for (int i = 0; i <= 2; i++) {
 			driver.findElement(by).click();// click on that combo

 			Actions actions = new Actions(driver);
 			actions.sendKeys(Keys.DOWN).build().perform();// press down arrow key
 			Actions action = new Actions(driver);
 			action.sendKeys(Keys.ENTER).build().perform();// press enter
 		}
 	}
 	
	// get current day number
	public static String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);

		return todayStr;
	}
	
	// Method to double click on any button
		public static void doubleClickElement(WebDriver driver, By btn_ID) {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(btn_ID);
			// Double click
			for (int i = 0; i <= 2; i++) {
				action.doubleClick(element).perform();
			}
		}
    
    
}
