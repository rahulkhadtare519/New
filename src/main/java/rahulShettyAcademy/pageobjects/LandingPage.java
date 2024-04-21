package rahulShettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
WebDriver driver;
public LandingPage(WebDriver driver) 
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement userPassword;

@FindBy(id="login")
WebElement submit;


public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}

public ProductCatalogue LoginApplication(String email, String password)
{
	userEmail.sendKeys(email);
	userPassword.sendKeys(password);
	submit.click();
	ProductCatalogue productCatalogue= new ProductCatalogue (driver);//need to share driver info when an object is created of other class
	return productCatalogue;
}
}