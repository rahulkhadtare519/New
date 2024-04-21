package rahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.AbstractComponents.AbstractPrac;

public class ProductPrac extends AbstractPrac {
	WebDriver driver;
	//List<WebElement> products;
	
	public ProductPrac(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css = ".mb-3")
	List<WebElement> productsp;
	
	By productsBy=  By.cssSelector(".mb-3");
	
	
	public List<WebElement> getProductList()
	{
		WaitForElementsToAppear(productsBy);
		//products= driver.findElements(productsBy);
		System.out.println(productsp.size());
		return productsp;
	}
	
	public void AddToCart(String productName)
	{
//		int i=0;
//		for(i=0; i<productsp.size();i++)
//		{
//			WebElement product1= productsp.get(i).findElement(By.cssSelector("b"));
//			if(product1.getText().equals(productName))
//			{
//				product1.findElement(By.cssSelector("button:last-child")).click();
//			}
//		}
		WebElement product= productsp.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		product.findElement(By.cssSelector("button:last-child")).click();
	}

}
