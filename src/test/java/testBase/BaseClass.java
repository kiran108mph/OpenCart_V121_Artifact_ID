package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties property;

	//@BeforeClass(groups = {"sanity","regression","dataDriven","master"})
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"common"})
	@Parameters({"os","browser"})
	public void setUp(String operatingSystem, String  browserName) throws IOException 
	{
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		property = new Properties();
		property.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		//Grid setup
		if(property.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities= new DesiredCapabilities();
			switch(operatingSystem.toLowerCase())
			{
			case "windows":capabilities.setPlatform(Platform.WIN11);break;
			case "mac":capabilities.setPlatform(Platform.MAC);break;
			case "linux":capabilities.setPlatform(Platform.LINUX);break;
			default:System.out.println("Not macthing the OS");return;
			}
			
			switch(browserName.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			default:System.out.println("Not macthing the browser");return;
			}
			
			driver = new RemoteWebDriver(new URL(property.getProperty("hubURL")),capabilities);
		}
		
		if(property.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (browserName.toLowerCase()) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default: System.out.println("Invalid browser");return;
			}	
		}
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.getProperty("url1"));
		driver.manage().window().maximize();
	} 

	
	//@AfterClass(groups = {"sanity","regression","dataDriven","master"})
	@AfterClass(groups = {"common"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String generateRandomString()
	{
		@SuppressWarnings("deprecation")
		String genratedRandomString = RandomStringUtils.randomAlphabetic(5);
		return genratedRandomString;
	}
	
	public String generateRandomPhoneNumber()
	{
		@SuppressWarnings("deprecation")
		String generatedRandomNumbers = RandomStringUtils.randomAlphabetic(10);
		return generatedRandomNumbers;
	}
	
	public String generateAlphaNumericPassword()
	{
		@SuppressWarnings("deprecation")
		String genratedRandomString = RandomStringUtils.randomAlphabetic(3);
		@SuppressWarnings("deprecation")
		String generatedRandomNumbers = RandomStringUtils.randomAlphabetic(3);
		String generatedAlphaNumericPassword = genratedRandomString+"@"+generatedRandomNumbers;
		return generatedAlphaNumericPassword;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
