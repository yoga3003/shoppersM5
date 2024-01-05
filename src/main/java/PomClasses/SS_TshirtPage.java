package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SS_TshirtPage 
{

	public WebDriver driver;
	public SS_TshirtPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='men tshirt']")
	private WebElement TshirtTopLink;
	
	public WebElement getTshirtTopLink()
	{
		return TshirtTopLink;
	}
	
	@FindBy(xpath="//span[text()='Levis Mens Regular Fit Tee']/../..//button")
	private WebElement LevisMensRegularFitTee_AddToCartButton;
	
	public WebElement getLevisMensRegularFitTee_AddToCartButton()
	{
		return LevisMensRegularFitTee_AddToCartButton;
	}
}