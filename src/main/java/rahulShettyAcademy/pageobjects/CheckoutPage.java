package rahulShettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
