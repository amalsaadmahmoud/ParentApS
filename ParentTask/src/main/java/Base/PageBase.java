package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Utils.HighLightDriver;


public class PageBase {

	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver;

	public PageBase() {		
		if (driver == null) {
			
			
			System.out.print("launch browser");
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properities/prop.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");

				

			}
			else if(config.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
				
			}
			
			driver = new HighLightDriver();
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			
		}
	}

	public static void quit() {

		driver.quit();

	}


}
