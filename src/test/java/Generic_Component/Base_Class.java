package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base_Class {
	
	public WebDriver driver;
	public ExtentReports extentreport;
	public ExtentTest extenttest;
	public static Logger log = Logger.getLogger(Base_Class.class);
	
	@BeforeMethod(groups={"smoke","regression"})
	public void Launchapp() throws IOException
	{
		Utility_Class c1= new Utility_Class();
		String btype = c1.Reading_Properties("btype");
		
		if(btype.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(btype.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_Testing\\chromedriv\\chromedriver.exe");
			 driver= new ChromeDriver();			
		}
		else if(btype.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","D:\\Selenium_Testing\\IEDriver\\IEDriverServer.exe");
			 driver= new InternetExplorerDriver();
		}
		
		//driver= new FirefoxDriver();
		driver.get(c1.Reading_Properties("URL"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	
	public String Capture_Screenshot(String TC_ID, String Order_Set) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";		
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\March17_Framework\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str));
		
		String path="D:\\March17_Framework\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str;
		return path;
		
	}
	
	@BeforeSuite(groups={"smoke","regression"})
	public void Report_extent()
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String str2=df.format(date);
		
		extentreport= new ExtentReports("D:\\March17_Framework\\Report\\"+"booksrediff"+str2+".html",false);
		
	}
	
	
	
	
	@AfterMethod(groups={"smoke","regression"})
	public void tearDown()
	{
		driver.quit();
		
		extentreport.endTest(extenttest);
		extentreport.flush();
	}
	

}
