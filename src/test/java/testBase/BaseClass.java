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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	 
	

	
	@BeforeClass(groups= {"regression","sanity","master"})
	 @Parameters({"os","browser"})	
	  
	  public void setup(String os, String br) throws IOException //(String os, String br) throws IOException 
	  
	  {
		  // loading config.properties file
		 FileReader file=new FileReader(".//src/test/resources/config.properties");
		 p =new Properties();
		 p.load(file);
		  
		//Loading Log4j2 File
		  
		  logger= LogManager.getLogger(this.getClass());
		
		 
		 // launching browser based on condition 
		
		  switch(br.toLowerCase())
		  {
		  case "chrome": WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); break;
		  case "edge": WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); break;
		  default: System.out.println("No matching browser");
		  return;
		  
		  }
		  
		  
		  
		  //WebDriverManager.chromedriver().setup();
		  // driver= new ChromeDriver();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();	  
		  driver.get(p.getProperty("appURL"));
		  
		  
	  }
	  
	  @AfterClass(groups= {"regression","sanity","master"})
	  public void teardown()
	  {
		  driver.quit();
	  }
	  
		public String randomString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomNumber()
		{
			String generatedString=RandomStringUtils.randomNumeric(10);
			return generatedString;
		}
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}	
 
}
