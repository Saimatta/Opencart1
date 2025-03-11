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
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
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

public class TestBase { /// All commons methods used in TestCases
	public  WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
	
		FileReader file=new FileReader("D:\\Eclipse_Workspace\\Opencart\\src\\test\\resources\\config.properties");//Reading the file
		p=new Properties();
		p.load(file);  //loading the file
		
		logger=LogManager.getLogger(this.getClass());//Log4j
		//os
		if(p.getProperty("exe_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")){
				cap.setPlatform(Platform.LINUX);
			}
			
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}else {
				System.out.println("Invalid platform");
				return;
			}
			//browser
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			default : System.out.println("Invalid browser"); return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444"),cap);
		}
		
		
		
		if(p.getProperty("exe_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:
			System.out.println("Invalid Browser"); return;
		}
		}
		logger.info("Browser name is : "+br);
//		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl")); //Uisng Application url using properties
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public String getrandomstring() {
		String name=RandomStringUtils.randomAlphabetic(6);
		return name;
	}
	
	public String getRandomNumber() {
		String mob=RandomStringUtils.randomNumeric(10);
		return mob;
	}
	
	public String getRandomemail() {
		String email=getrandomstring()+"@gmail.com";
		return email;
	}
	public String getrandompass() {
		String pass=getrandomstring()+"@"+getRandomNumber();
		return pass;
	}
	
	public String captureScreen(String tname) throws IOException{
		String timestamp=new SimpleDateFormat("YYYYHHMMSS").format(new Date());
		TakesScreenshot takess=(TakesScreenshot)driver;
		File sourceFile=takess.getScreenshotAs(OutputType.FILE);
		String targetfilepath=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"-"+timestamp;
		File targetfile=new File(targetfilepath);
		sourceFile.renameTo(targetfile);
		return targetfilepath;
	}
}
