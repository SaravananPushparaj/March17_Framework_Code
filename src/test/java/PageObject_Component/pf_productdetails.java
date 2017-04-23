package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_productdetails {
	
	
	@FindBy(className="buynowbtnbig")
	public WebElement btn_buy;
	
	
	public pf_productdetails(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void Click_buy()
	{
		btn_buy.click();
	}

}
