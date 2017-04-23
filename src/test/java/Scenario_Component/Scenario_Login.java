package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Component.Base_Class;
import PageObject_Component.pf_Homepage;
import PageObject_Component.pf_Signin;

public class Scenario_Login extends Base_Class {
	
	
	@Test(dataProvider="dp_Invalidlogin",dataProviderClass=DataProvider_Component.Dataprovider_loaddata.class,groups={"smoke"})
	public void testInvalidlogin(Map<String,String> login) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = login.get("TC_ID");
		String Order_Set = login.get("Order_Set");
		String Uname = login.get("Uname");
		String Pwd = login.get("Pwd");
		String Exp_Result = login.get("Exp_Result");
		
		extenttest=extentreport.startTest(TC_ID);
		log.info("Executing the Testcase " +TC_ID + " Order set is  "+Order_Set);
		extenttest.log(LogStatus.PASS, "Executing the Testcase " +TC_ID + " Order set is  "+Order_Set);
		
		pf_Homepage home_page= new pf_Homepage(driver);
		home_page.Click_signin();
		
		pf_Signin signin_page= new pf_Signin(driver);
		signin_page.cl_login(Uname, Pwd);
		
		String Actual_Result = signin_page.getInvalidmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result);
			extenttest.log(LogStatus.PASS, "Passed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result,extenttest.addScreenCapture(Capture_Screenshot(TC_ID, Order_Set)));
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result);
			extenttest.log(LogStatus.FAIL, "Failed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result,extenttest.addScreenCapture(Capture_Screenshot(TC_ID, Order_Set)));
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result);
		}
		
		
		sAssert.assertAll();
	}
	
	
	
	@Test(dataProvider="dp_Validlogin",dataProviderClass=DataProvider_Component.Dataprovider_loaddata.class,groups={"regression"})
	public void testValidlogin(Map<String,String> login) throws IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = login.get("TC_ID");
		String Order_Set = login.get("Order_Set");
		String Uname = login.get("Uname");
		String Pwd = login.get("Pwd");
		String Exp_Result = login.get("Exp_Result");
		
		log.info("Executing the Testcase " +TC_ID + " Order set is  "+Order_Set);
		
		pf_Homepage home_page= new pf_Homepage(driver);
		home_page.Click_signin();
		
		pf_Signin signin_page= new pf_Signin(driver);
		signin_page.cl_login(Uname, Pwd);
		
		String Actual_Result = home_page.getValidmsg();
		
		if(Actual_Result.contains(Exp_Result))
		{

			log.info("Passed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  " +Actual_Result+ " Expected Result is "+Exp_Result);
		}
		
		home_page.Click_signout();
		
		sAssert.assertAll();
		
	}

}
