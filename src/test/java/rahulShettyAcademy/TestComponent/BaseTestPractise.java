package rahulShettyAcademy.TestComponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import rahulShettyAcademy.pageobjects.LandingPagePrac;

public class BaseTestPractise {
	public WebDriver driver;
	public LandingPagePrac landingPagePrac;
	
	public WebDriver InitializeDriver() throws IOException 
	{
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\rahulShettyAcademy\\TestComponent\\GlobalData.properties");
		Properties prop= new Properties();
		prop.load(fis);
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
		return driver;
	}
	
	@BeforeMethod
	public LandingPagePrac LaunchApplication() throws IOException 
	{
		driver= InitializeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		landingPagePrac = new LandingPagePrac(driver);
		return landingPagePrac;
	}

}
