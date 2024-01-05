package Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pomclass.MyProfilePage;
import pomclass.SS_AccountSettingPage;
import pomclass.SS_HomePage;
import pomclass.SS_TshirtPage;
import utility.Baseclass;
import utility.SS_MyAddressesPage;

@Listeners()
public class AddToCartTest extends Baseclass
{
	@Test
	public void Ss_AddToCart_001() throws Throwable
{
	Thread.sleep(3000);
	System.out.println("First Test Case");
	String titleHomePage = driver.getTitle();
	AssertJUnit.assertEquals(titleHomePage, "ShoppersStack | Home");

	SS_HomePage HP = new SS_HomePage(driver);
	Thread.sleep(5000);
	WebElement menLink = HP.getmenMenuLink();

	WU.mouseOverAction(driver, menLink);
	HP.getTshirtPopupLink().click();
	SS_TshirtPage tsp = new SS_TshirtPage(driver);
	String currenturl = driver.getCurrentUrl();
	AssertJUnit.assertEquals(currenturl, "https://www.shoppersstack.com/sub-category/men-tshirt");
	WU.mouseOverAction(driver, tsp.getTshirtTopLink());


	tsp.getLevisMensRegularFitTee_AddToCartButton().click();
	HP.getaddToCartLink().click();
	AssertJUnit.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/cart");


}

@Test(dataProvider="dataProviderAddress")
public void Ss_AddAddress_001(String home, String house_office, String street, String landmark, String country,
		String state, String city, String pincode, String phoneno)
{
	System.out.println("Add Address");
	SS_HomePage HP = new SS_HomePage(driver);
	HP.getaccountSettingIcon().click();

//	SS_AccountSettingPage AS = new SS_AccountSettingPage(driver);
//	AS.getmyProfileLink().click();
//	
	AssertJUnit.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/my-profile/my-profile-info");
	System.out.println("My Profile Page is Opened");
	
	MyProfilePage MP = new MyProfilePage(driver);
	MP.getmyaddressButtton().click();
	
	SS_MyAddressesPage MA = new SS_MyAddressesPage(driver);
	MA.getaddressformbutton().click();
	
}  

@DataProvider
public Object[][] dataProvider()
{
	Object[][] ref = new Object[1][9];
	ref[0][0]="Anil Kumar";
	ref[0][1]="153, Chandra Layout";
	ref[0][2]="Ponappa 2nd cross";
	ref[0][3]="Near Pampa Hotel";
	ref[0][4]="India";
	ref[0][5]="Karnataka";
	ref[0][6]="Bengaluru";
	ref[0][7]="560010";
	ref[0][8]="9731523565";
	return ref;
}
}




@Test
	public void SS_AddToCart_001() throws Throwable
{
	Thread.sleep(3000);
	System.out.println("First Test Case");
	String titleHomePage = driver.getTitle();
	Assert.assertEquals(titleHomePage, "ShoppersStack | Home");

	SS_HomePage HP = new SS_HomePage(driver);
	Thread.sleep(5000); 
	WebElement menLink = HP.getmenMenuLink();

	WU.mouseOverAction(driver, menLink);
	HP.getTshirtPopupLink().click();
	SS_TshirtPage tsp = new SS_TshirtPage(driver);
	String currenturl = driver.getCurrentUrl();
	Assert.assertEquals(currenturl, "https://www.shoppersstack.com/sub-category/men-tshirt");
	WU.mouseOverAction(driver, tsp.getTshirtTopLink());


	tsp.getLevisMensRegularFitTee_AddToCartButton().click();
	HP.getaddToCartLink().click();
	Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/cart");

	SS_addToCart AC = new SS_addToCart(driver);
	String levisProductTest = AC.getlevisProduct().getText();
	Assert.assertEquals(levisProductTest, "Levis Mens Regular Fit Tee");
	System.out.println(" The Product is Added to The Cart");
	
	AC.getbuynowButtonIncartPage().click();
	
	String addressPageurl = driver.getCurrentUrl();
	Assert.assertEquals(addressPageurl,"https://www.shoppersstack.com/selectaddress");
	System.out.println("Address Page Is Displayed");
	
	SS_MyAddressesPage HomeAddress = new SS_MyAddressesPage(driver);
	HomeAddress.getHomeAddress().click();
	HomeAddress.getProceedButton().click();

	PaymentPage Pay = new PaymentPage(driver);
	Pay.getCashOnDelevery().click();
	Pay.getProceedButtonInPaypage().click();

