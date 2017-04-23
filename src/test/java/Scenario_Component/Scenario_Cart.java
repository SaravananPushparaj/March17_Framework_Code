package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.pf_Cart;
import PageObject_Component.pf_Homepage;
import PageObject_Component.pf_productdetails;

public class Scenario_Cart extends Base_Class {
	
	
	@Test(dataProvider="dp_AddCart",dataProviderClass=DataProvider_Component.Dataprovider_loaddata.class)
	public void testAddCart(Map<String,String> Cart) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Search_Item = Cart.get("Search_Item");
		String Exp_Result = Cart.get("Exp_Result");
		
		log.info("Executing the Testcase " +TC_ID);
				
		pf_Homepage home_page= new pf_Homepage(driver);
		home_page.Search(Search_Item);
		
		//Explicit wait
		WebDriverWait wait= new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOf(home_page.Valid_searchmsg));
		
		home_page.img_book.click();
		
		pf_productdetails productdet_page= new pf_productdetails(driver);
		productdet_page.Click_buy();
				
		pf_Cart cart_page= new pf_Cart(driver);
		driver.switchTo().frame(cart_page.Cart_frame);
		
		String Actual_Result = cart_page.getAddCartitem();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result+ "Expected Result is "+Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result+ "Expected Result is "+Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result+ "Expected Result is "+Exp_Result);
		}
		
		driver.switchTo().defaultContent();
		
		sAssert.assertAll();
		
		
	}

}
