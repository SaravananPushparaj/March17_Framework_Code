package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.pf_Homepage;

public class Scenario_Search extends Base_Class {
	
	
	@Test(dataProvider="dp_InvalidSearch",dataProviderClass=DataProvider_Component.Dataprovider_loaddata.class,groups={"smoke"})
	public void testInvalidSearch(Map<String,String> Search) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		log.info("Executing the Testcase "+TC_ID + "Order set is "+Order_Set);
		
		pf_Homepage home_page= new pf_Homepage(driver);
		home_page.Search(Search_Item);
		
		String Actual_Result = home_page.getInvalidsearch();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result +" Expected Result is " +Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result +" Expected Result is " +Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result +" Expected Result is " +Exp_Result);
		}
		
		
		
		sAssert.assertAll();
	}
	
	
	@Test(dataProvider="dp_ValidSearch",dataProviderClass=DataProvider_Component.Dataprovider_loaddata.class,groups={"regression"})
	public void testValidSearch(Map<String,String> Search) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result").replace(".0", "");
		
		log.info("Executing the Testcase "+TC_ID + "Order set is "+Order_Set);
		
		pf_Homepage home_page= new pf_Homepage(driver);
		home_page.Search(Search_Item);
		
		String Actual_Result = home_page.getValidsearch();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result +" Expected Result is " +Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result +" Expected Result is " +Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result +" Expected Result is " +Exp_Result);
		}
		
		
		
		sAssert.assertAll();
		
		
	}

}
