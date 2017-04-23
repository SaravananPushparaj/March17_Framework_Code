package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Homepage {
	
	//collect the attribute
	@FindBy(linkText="Sign In")
	public WebElement lnk_signin;
	
	@FindBy(className="proper")
	public WebElement Valid_msg;
	
	@FindBy(linkText="Sign Out")
	public WebElement lnk_Signout;
	
	@FindBy(id="srchword")
	public WebElement txtbox_Search;
	
	@FindBy(className="newsrchbtn")
	public WebElement btn_Search;
	
	@FindBy(className="sorrymsg")
	public WebElement Invalid_searchmsg;
	
	@FindBy(id="find")
	public WebElement Valid_searchmsg;
	
	@FindBy(xpath="//div[@class='bookbox'][1]//img")
	public WebElement img_book;
	
	//1st section --initialize page factor
	public pf_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	//3rd section
	
	public void Click_signin()
	{
		lnk_signin.click();
		
	}
	
	public String getValidmsg()
	{
		return Valid_msg.getText();
	}
	
	public void Click_signout()
	{
		lnk_Signout.click();
		
	}
	
	public void Search(String Search_item)
	{
		
		txtbox_Search.sendKeys(Search_item);
		btn_Search.click();
		
	}
	
	public String getInvalidsearch()
	{
		
		return Invalid_searchmsg.getText();
	}
	
	public String getValidsearch()
	{
		
		return Valid_searchmsg.getText();
	}

}
