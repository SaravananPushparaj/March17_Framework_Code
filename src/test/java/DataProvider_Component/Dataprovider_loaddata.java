package DataProvider_Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import Generic_Component.ExcelRW;

public class Dataprovider_loaddata {
	
	@DataProvider(name="dp_Invalidlogin")
	public static Iterator<Object[]> getInvalidlogin() throws Exception
	{
		return commondp_logic("Login","InvalidLogin");
		
	}
	
	@DataProvider(name="dp_Validlogin")
	public static Iterator<Object[]> getValidlogin() throws Exception
	{
		return commondp_logic("Login","ValidLogin");
		
	}

	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<Object[]> getInvalidSearch() throws Exception
	{
		return commondp_logic("Search","InvalidSearch");
		
	}
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<Object[]> getValidSearch() throws Exception
	{
		return commondp_logic("Search","ValidSearch");
		
	}
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<Object[]> getAddCart() throws Exception
	{
		return commondp_logic("Cart","AddCart");
		
	}
	
	public static Iterator<Object[]> commondp_logic(String Sheetname,String sname) throws Exception
	{
		//constructor invoked
		ExcelRW xl= new ExcelRW("D:\\March17_Framework\\TestData\\TestData.xlsx");
		//get Row count
		int RowCount = xl.getRow(Sheetname);
		//get col count
		int Colcount = xl.getColum(Sheetname);
		//declared List of object
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			String Execute_Flag = xl.readCell(Sheetname, i, 2);
			String Script_name = xl.readCell(Sheetname, i, 3);
			
			if((Execute_Flag.equalsIgnoreCase("Y"))&&(Script_name.equalsIgnoreCase(sname)))
			{
				Map<String,String> dMap= new HashMap<String,String>();
				Object[] x= new Object[1];
				
				for(int j=0;j<Colcount;j++)
				{
					String Skey = xl.readCell(Sheetname, 0, j);
					String Value = xl.readCell(Sheetname, i, j);
					
					dMap.put(Skey, Value);				
					
					
				}
				
				x[0]=dMap;
				arr_list.add(x);
				
				
			}//end of if			
			
			
		}//end of for
		
		
		return arr_list.iterator();
		
		
		
	}
	
	
	
	
	
	
	
}
