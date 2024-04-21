package rahulShettyAcademy.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import rahulShettyAcademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
        landingPage.LoginApplication("anshika@gmail.com", "Iamking@000");
        
	}

}
