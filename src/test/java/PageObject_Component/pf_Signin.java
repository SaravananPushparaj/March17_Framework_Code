package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Signin {
	
	//2nd section collect attribute
	@FindBy(name="logid")
	public WebElement txtbox_uname;
	
	@FindBy(name="pswd")
	public WebElement txtbox_pwd;
		
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btn_login;
	
	@FindBy(xpath="//b[contains(text(),'Sorry we were')]")
	public WebElement Invalid_msg;	
	
	
	
	//1st section
	public pf_Signin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//3rd section
	
	public void cl_login(String uname,String pwd)
	{
		txtbox_uname.sendKeys(uname);
		txtbox_pwd.sendKeys(pwd);
		btn_login.click();
	}
	
	
	public String getInvalidmsg()
	{
		return Invalid_msg.getText();
	}

}
