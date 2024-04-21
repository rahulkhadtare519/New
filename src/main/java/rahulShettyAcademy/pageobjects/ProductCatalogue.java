package rahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products; //to get product list
	}
	
	public void addToCart(String product1)
	{
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(product1)).findFirst().orElse(null);
		prod.findElement(By.cssSelector("button:last-child")).click(); //findFirst().orElse(null) is to convert List into a single WebElement.
	}
	
}
