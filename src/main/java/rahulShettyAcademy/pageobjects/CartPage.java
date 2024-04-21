package rahulShettyAcademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css="h3")//.cartSection h3
	List<WebElement> productTitles;
	
	By productNames= By.cssSelector("h3");
	
			
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement goToCart;
	
	By toastMsg= By.cssSelector("#toast-container");

	
	public void goToCart()
	{
		waitForElementToDisappear(toastMsg);
		waitForWebElementToAppear(goToCart);
		goToCart.click();
	}
	
	public Boolean verifyProductDisplay(String product)
	{
		waitForElementToAppear(productNames);
		Boolean match= productTitles.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}

	public CheckoutPage goToCheckoutPage()
	{
		checkoutEle.click();
		CheckoutPage checkoutPage= new CheckoutPage(driver);//need to share driver info when an object is created of other class
		return checkoutPage;
	}

}
