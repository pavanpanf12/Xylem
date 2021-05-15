package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import stepDefintions.StepDefintion_TestCase01;

public class initialization {
	public static WebDriver driver;
	public FileInputStream fis = null;
	public Properties prop;
	public StepDefintion_TestCase01 hp;
	public String userDir = System.getProperty("user.dir");
	public GetProperty gp = new GetProperty();
	
	/* 
	 * this method is used for set up the property of chromedrive and path for the chromedriver. 
	 */
	@BeforeClass
	public void setSystemProperty() {
		System.setProperty("webdriver.chrome.driver", userDir+"\\driver\\chromedriver.exe");
	}
	
	/* 
	 * this method is used for launching the browser and open the below url
	 */
	@BeforeMethod
	public void preCondition_Login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(gp.getProperty("URl"));
		hp = new StepDefintion_TestCase01();
	}
	
	/*
	 * this method is used for closing the browser.
	 */
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
