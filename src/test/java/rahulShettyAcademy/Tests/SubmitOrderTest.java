package rahulShettyAcademy.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulShettyAcademy.TestComponent.BaseTest;
import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.LandingPage;
import rahulShettyAcademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	
	@Test
	public void SubmitOrder() throws IOException //need to create method to use landingPage obhect
	//public static void main(String[] args) throws IOException
	{
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
		WebDriver driver= InitializeDriver();*/
		
		
		String productName= "ZARA COAT 3";
		//LandingPage landingPage= LaunchApplication();//as the main method was static instead of @test earlier there was an error 'Cannot make a static reference to the non-static method LaunchApplication() from the type BaseTest'
		ProductCatalogue productCatalogue= landingPage.LoginApplication("anshika@gmail.com", "Iamking@000");//so we changed the public main to @test
        productCatalogue.getProductList();
        productCatalogue.addToCart(productName);
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        Boolean match= cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        driver.close();

	}

}
