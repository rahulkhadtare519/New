package rahulShettyAcademy.Tests;

import org.testng.annotations.Test;

import rahulShettyAcademy.TestComponent.BaseTestPractise;
import rahulShettyAcademy.pageobjects.LandingPagePrac;
import rahulShettyAcademy.pageobjects.ProductPrac;

public class SubmitOrderPrac extends BaseTestPractise{
	
	@Test
	public void SubmitOrder() {
		ProductPrac productPrac= landingPagePrac.LoginApplication("anshika@gmail.com", "Iamking@000");
		//productPrac.getProductList();
		productPrac.AddToCart("ADIDAS ORIGINAL");
	}
	
	
	

}
