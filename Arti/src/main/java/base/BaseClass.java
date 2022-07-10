package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static Properties props;
	public static FileInputStream fis;
	public static WebDriver driver;

	public BaseClass() throws IOException {
		try {
			props = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/base/prop.properties");

			props.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		if (props.getProperty("Browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:/Users/Karthi/Downloads/chromedriver_win32 (2)/chromedriver.exe");
			driver = new ChromeDriver();
		}
		try {
			driver.get(props.getProperty("calc_url"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
