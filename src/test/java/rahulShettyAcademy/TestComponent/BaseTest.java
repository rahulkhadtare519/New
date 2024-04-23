package rahulShettyAcademy.TestComponent;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import rahulShettyAcademy.pageobjects.LandingPage;


public class BaseTest 
{
	public WebDriver driver;
	public LandingPage landingPage;

	public  WebDriver InitializeDriver() throws IOException 
	{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\rahulShettyAcademy\\TestComponent\\GlobalData.properties");
		prop.load(fis);
		//WebDriver driver;
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			 driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"/reports/"+ testCaseName + ".png");
		FileUtils.copyFile(source,file);   //FileUtils package is derived once 'Apache Commons IO' jar is added into dependency
		return System.getProperty("user.dir")+"/reports/"+ testCaseName + ".png";  //this is just a path hence return type is 'String'
	}
	
	@BeforeMethod(alwaysRun = true)   
	public LandingPage LaunchApplication() throws IOException
	{
		driver=InitializeDriver();
		landingPage= new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

}
