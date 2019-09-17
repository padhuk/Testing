package com.org.learningmaven.ReuseTest;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.Assert;

public class BaseLogin {
	public WebDriver driver;
	public Properties prop;
	
	public void openbrowser(String browserr)
    {
		if(prop==null) {
			prop=new Properties();
			try {
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//Projectconfig.properties");
				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println(prop.getProperty("appurl"));
		
		
		if(browserr.equals("Mozilla")) {
			driver=new FirefoxDriver();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			System.out.println( "Opened Mozilla" );
		}
		if(browserr.equals("Chrome")) {
			driver=new ChromeDriver();
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			System.out.println( "Opened Chrome" );
		}
		if(browserr.equals("IE")) {
			driver=new InternetExplorerDriver();
			System.out.println( "Opened IE" );
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		}
		if(browserr.equals("Edge")) {
			driver=new EdgeDriver();
			System.out.println( "Opened Edge" );
			System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"null");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }
	
    public void urll(String urll)
    {
		driver.get(prop.getProperty("appurl"));
        System.out.println( "Enter URL!" );
        
    }
	
    public void login(String Locatorkey, String value)
    {
        System.out.println( "Enter user ID" );
       // driver.findElement(By.xpath(prop.getProperty(xppathkey))).sendKeys(value);
        getElement(Locatorkey).sendKeys(value);
    }
	
    public void pwd(String Locatorkey)
    {
        System.out.println( "Enter Password" );
        //driver.findElement(By.xpath("click")).click();
        getElement(Locatorkey).click();
    }
    
    public boolean isElementPresent(String locatorKey){
		List<WebElement> elementList=null;
		if(locatorKey.endsWith("_id"))
			elementList = driver.findElements(By.id(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			elementList = driver.findElements(By.name(prop.getProperty(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			elementList = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		else{
			reportfailure("Locator not correct - " + locatorKey);
			Assert.fail("Locator not correct - " + locatorKey);
		}
		
		if(elementList.size()==0)
			return false;	
		else
			return true;
	}

    public void reportFailure(String msg){
	//	test.log(LogStatus.FAIL, msg);
		//takeScreenShot();
		Assert.fail(msg);
	}
    
	public WebElement getElement(String Locatorkey) {
		
		WebElement e=null;
		try {
		if(Locatorkey.endsWith("_id")) {
			e=driver.findElement(By.id(prop.getProperty(Locatorkey)));
		}
		else if(Locatorkey.endsWith("_name")) {
			e=driver.findElement(By.name(prop.getProperty(Locatorkey)));
		}
		else if(Locatorkey.endsWith("_xpath")) {
			e=driver.findElement(By.xpath(prop.getProperty(Locatorkey)));
		}
		else
		{
			reportfailure("Locate is not correct"+ Locatorkey);
			Assert.fail("Locate is not correct"+ Locatorkey);
		}
		
		}catch(Exception ex) {
		reportfailure(ex.getMessage());
		ex.printStackTrace();
		Assert.fail("Failed the test"+ ex.getMessage());
		}
		return e;
	}
    
    public void reportfailure(String msg)
    {
    	
    }
    
    
    public void logoff()
    {
        System.out.println( "Click on Signout" );
    }
    
    public boolean verifyText(String locatorKey,String expectedTextKey){
		String actualText=getElement(locatorKey).getText().trim();
		String expectedText=prop.getProperty(expectedTextKey);
		if(actualText.equals(expectedText))
			return true;
		else 
			return false;
		
	}

	
}
