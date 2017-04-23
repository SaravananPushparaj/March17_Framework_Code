package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Cart {
	
	
	@FindBy(id="frmCart")
	public WebElement Cart_frame;
	
	@FindBy(xpath="//span[contains(text(),'Flood and Fire')]")
	public WebElement Cart_item;
	
	
	public pf_Cart(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String getAddCartitem()
	{
		
		return Cart_item.getText();
	}
	

}
