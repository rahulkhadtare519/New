package rahulShettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPagePrac {
	WebDriver driver;
	public ProductPrac productPrac;

	public LandingPagePrac(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy (id="userEmail")
	WebElement userId;
	
	@FindBy (id="userPassword")
	WebElement userPassword;

	@FindBy (id="login")
	WebElement submit;
	
	public ProductPrac LoginApplication(String userName, String password)
	{
		userId.sendKeys(userName);
		userPassword.sendKeys(password);
		submit.click();
		productPrac= new ProductPrac(driver);
		return productPrac;
	}
}
